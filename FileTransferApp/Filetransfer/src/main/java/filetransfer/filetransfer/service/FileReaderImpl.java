package filetransfer.filetransfer.service;



import filetransfer.filetransfer.dtos.response.FileReaderResponse;
import filetransfer.filetransfer.exception.FileReaderException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileReaderImpl implements FileReader{
    @Override
    public String readFile(String fileLocation) {
        try(InputStream inputStream = new FileInputStream(fileLocation)){
            System.out.println("reading file ");
            String response = new String(inputStream.readAllBytes());
            System.out.println("read !!!");
            validateFile(response);
            return response;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private  void validateFile(String response){
        if(response.isBlank()){
            throw new FileReaderException("file is empty");
        }
    }
}
