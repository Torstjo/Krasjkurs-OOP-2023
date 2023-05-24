package EksamensforelesningLF.Filbehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderAndWriter {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("EksamensforelesningLF/Filbehandling/ExampleFile.txt"));
        String data = null;
        while ((data = reader.readLine()) != null) {
            System.out.println(data);
        }
        reader.close();

        //BufferedWriter writer = new BufferedWriter(new FileWriter("minegenkode/src/main/java/Eksamensforelesning/Filbehandling/ExampleFile.txt"));
        //String text = "Dette har vi skrevet til fil";
        //writer.write(text);
        //writer.close();
    }
}
