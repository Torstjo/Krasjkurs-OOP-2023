package Eksamensforelesning.Filbehandling;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;

public class NioFile {
    
    public static void main(String[] args) throws IOException {
        
        Path path = Paths.get("minegenkode/src/main/java/Eksamensforelesning/Filbehandling/ExampleFile.txt");
        String str = "Dette er et eksempel på å skrive med Files\nLinje 2";
        byte[] bs = str.getBytes();
        Files.write(path, bs);

        List<String> content = Files.readAllLines(path);
        for (String string : content) {
            System.out.println(string);
        }
    }
}