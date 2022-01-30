package es.icai.reto.util;

import org.json.JSONObject;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.stream.Collectors;

public class CompileExecutor {

    private static String[] compileSource(Path javaPath, String className) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        Instant start = Instant.now();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();

        Path javaFile = Paths.get(javaPath.toString(), className + ".java");

        compiler.run(null, outputStream, outputStream1, javaFile.toFile().getAbsolutePath());

        String output1 = new String(outputStream.toByteArray());
        String output2 = new String(outputStream1.toByteArray());

        return new String[]{output1, output2};
    }

    private static String runClass(Path javaPath, String className, String method) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Path classPath = Paths.get(javaPath.toString(), className + ".class");

        URL classUrl = classPath.getParent().toFile().toURI().toURL();
        URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{classUrl});
        Class<?> clazz = Class.forName(className, true, classLoader);
        try {
            return (String) clazz.getMethod(method, null).invoke(null, null);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String compileAndExecute(Path javaPath, String className, String method) {

        JSONObject jsonObject = new JSONObject();


        Instant startCompilation = Instant.now();
        JSONObject jsonCompilation = new JSONObject();
        String[] outputCompilation = compileSource(javaPath, className);

        jsonCompilation.put("elapsedTime",Duration.between(startCompilation, Instant.now()).toMillis());
        jsonCompilation.put("stdout",outputCompilation[0]);
        jsonCompilation.put("stderr",outputCompilation[1]);
        jsonCompilation.put("status",outputCompilation[1].isBlank()?"success":"failed");
        jsonObject.put("compilation",jsonCompilation);
        //Failed compilation
        if(!outputCompilation[1].isBlank())
            return jsonObject.toString();


        Instant startExecution = Instant.now();
        JSONObject jsonExecution = new JSONObject();

        String outputExecution = null;
        String errorExecution = null;
        try {
            outputExecution = runClass(javaPath,className, method);
        } catch (Exception e) {
            errorExecution = e.getMessage();
        }

        jsonExecution.put("elapsedTime",Duration.between(startExecution, Instant.now()).toMillis());
        jsonExecution.put("stdout",outputExecution);
        if (errorExecution!=null) {
            jsonExecution.put("status", "failed");
            jsonExecution.put("stderr",errorExecution);
        }
        else
            jsonExecution.put("status", "success");
        jsonObject.put("execution",jsonExecution);

        return jsonObject.toString();
    }


    public static void main(String... args) throws Exception {
        System.out.println(compileAndExecute(Paths.get("."), "AppTest", "test"));

    }
}

