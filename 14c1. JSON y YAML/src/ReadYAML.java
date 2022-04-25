import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadYAML {
    public static void main(String argv[])
    {
        Yaml yaml = new Yaml(new Constructor(User.class));
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get("resources/user.yaml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        User user = yaml.load(reader);
        System.out.println(user);

    }
}
