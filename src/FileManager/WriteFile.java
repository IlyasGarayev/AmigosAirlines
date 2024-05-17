package FileManager;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class WriteFile {
    private Path path ;

    public WriteFile(Path path){
        this.path = path;
    }

    public void write(String string) throws IOException {
            OutputStream outputStream = Files.newOutputStream(
                    path,
                    StandardOpenOption.APPEND,
                    StandardOpenOption.WRITE
            );

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

            bufferedWriter.write(string);

            bufferedWriter.close();
    }


}