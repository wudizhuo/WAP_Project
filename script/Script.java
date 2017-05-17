import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Script {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("init data begin");

        Files.lines(Paths.get("script/initialData.sh")).forEach(Script::exec);

        System.out.println("init data end");
    }

    private static void exec(String content) {
        Process p = null;
        try {
            p = Runtime.getRuntime().exec(content);
            p.waitFor();

            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}