package cc.hamzaelmarjani.utils;

import java.io.IOException;

public class CommandUtils {
    public void runCommand(String command) {
        try {
            new ProcessBuilder("bash", "-c", command)
                    .inheritIO()
                    .start()
                    .waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    /// Run this only on IDE environment like Intellij, VSCode ...
    /// This will only print empty lines, this is because the IDEA will not perform clear console programmatically.
    public void fakeClearConsole(int lines) {
        for (int i = 0; i < lines; i++)
            System.out.println();
    }
}
