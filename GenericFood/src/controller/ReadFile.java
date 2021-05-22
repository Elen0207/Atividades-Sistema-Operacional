package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFile implements IReadFile {
    private String [] phrase;

    public ReadFile() {
        super();
    }

    public void ReadFileGenericFood(String path, String file) throws IOException {
        File GenericFood = new File(path, file);

        if ( GenericFood.exists() && GenericFood.isFile() ) {

            FileInputStream flow = new FileInputStream(GenericFood);
            InputStreamReader reader = new InputStreamReader(flow);
            BufferedReader buffer = new BufferedReader(reader);
            String line = buffer.readLine();
            
            while (line != null) {
                phrase = line.split(",");
 
                for (String word: phrase) {
                    if (word.equalsIgnoreCase("fruits")) {
                        System.out.println("Fruta: "+line);
                    }
                }
                line = buffer.readLine();
            }

            buffer.close();
            reader.close();
            flow.close();
        } 
        else {
            throw new IOException("Arquivo Invalido");
        }       
    }

    public void ReadFileWithoutPath( String file) throws IOException {
        File GenericFood = new File(file);

        if ( GenericFood.exists() && GenericFood.isFile() ) {

            FileInputStream flow = new FileInputStream(GenericFood);
            InputStreamReader reader = new InputStreamReader(flow);
            BufferedReader buffer = new BufferedReader(reader);
            String line = buffer.readLine();
            
            while (line != null) {
                phrase = line.split(",");
 
                for (String word: phrase) {
                    if (word.equalsIgnoreCase("Fruits")) {
                        System.out.println("Fruta: "+line);
                    }
                }
                line = buffer.readLine();
            }

            buffer.close();
            reader.close();
            flow.close();
        } 
        else {
            throw new IOException("Arquivo Invalido");
        }       
    }
}