package Eksamensforelesning.Filbehandling;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ScannerTest {
    
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(new File("Eksamensforelesning/Filbehandling/ExampleFile.txt"));
        String line = null;
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            System.out.println(line);
        }
        scanner.close();
    }
}
