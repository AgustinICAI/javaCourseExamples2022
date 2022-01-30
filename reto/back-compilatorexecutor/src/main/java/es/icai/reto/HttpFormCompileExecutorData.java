package es.icai.reto;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Comparator;
import java.util.UUID;
import java.util.logging.Logger;

import static es.icai.reto.util.CompileExecutor.compileAndExecute;

public class HttpFormCompileExecutorData implements HttpFunction {
    private static final Logger logger = Logger.getLogger(HttpFormCompileExecutorData.class.getName());

    @Override
    public void service(HttpRequest request, HttpResponse response)
            throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {

        if (!"POST".equals(request.getMethod())) {
            response.setStatusCode(HttpURLConnection.HTTP_BAD_METHOD);
            return;
        }

        String tempDirectory = System.getProperty("java.io.tmpdir");
        Path execPath = Paths.get(tempDirectory, String.valueOf(UUID.randomUUID()));
        Files.createDirectories(execPath);

        for (HttpRequest.HttpPart httpPart : request.getParts().values()) {
            String filename = httpPart.getFileName().orElse(null);
            if (filename == null) {
                continue;
            }


            logger.info("Processing file: " + filename);
            // Note: GCF's temp directory is an in-memory file system
            // Thus, any files in it must fit in the instance's memory.

            Path filePath = Paths.get(execPath.toString(), filename).toAbsolutePath();
            // Note: files saved to a GCF instance itself may not persist across executions.
            // Persistent files should be stored elsewhere, e.g. a Cloud Storage bucket.
            Files.copy(httpPart.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            logger.info("Stored file: " + filePath);
        }
        String className = request.getQueryParameters().get("className").get(0);
        String method = request.getQueryParameters().get("method").get(0);

        String output = compileAndExecute(execPath, className, method);
        logger.info(output);

        logger.info(String.format("className: %s (method: %s)", className, method));

        PrintWriter pw = new PrintWriter(response.getWriter());
        pw.print(output);
        pw.close();



        //Deleting all classes uploaded

        Files.walk(execPath)
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);

    }
}