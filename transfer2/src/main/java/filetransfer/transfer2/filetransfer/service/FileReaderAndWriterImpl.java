package filetransfer.transfer2.filetransfer.service;


import filetransfer.transfer2.filetransfer.Exception.FileReaderException;
import filetransfer.transfer2.filetransfer.dtos.request.FileReaderAndWriterRequest;
import filetransfer.transfer2.filetransfer.dtos.response.FileReaderAndWriterResponse;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

public class FileReaderAndWriterImpl implements FileReaderAndWriter {

    @Override
    public FileReaderAndWriterResponse readsAndWriteToFile(FileReaderAndWriterRequest fileReaderRequest) throws IOException {
        writeResult(readFromApi(fileReaderRequest),fileReaderRequest);
        FileReaderAndWriterResponse fileReaderAndWriterResponse = new FileReaderAndWriterResponse();
        fileReaderAndWriterResponse.setMessage("SUCCESS");
        return fileReaderAndWriterResponse;
    }

    private String readFromApi( FileReaderAndWriterRequest fileReaderRequest) throws IOException  {
        try{
            URI uri = URI.create(fileReaderRequest.getIpAddress()+fileReaderRequest.getLocalPort()+fileReaderRequest.getFilePath()+fileReaderRequest.getFileName());
            InputStream reader = uri.toURL().openStream();
            System.out.println(reader);
            System.out.println("file read successfully");
            return new String(reader.readAllBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void writeResult(String ApiResult,FileReaderAndWriterRequest fileReaderRequest) throws IOException {
        try(OutputStream outputStream = new FileOutputStream(fileReaderRequest.getFileWriterLocation())){
            validateFile(ApiResult);
            outputStream.write(ApiResult.getBytes());
            System.out.println("file written successfully");
        } catch (IOException e) {
            System.out.println("file written failed due to location");
            throw new RuntimeException(e);
        }
    }
    private  void validateFile(String response){
        if(response.isBlank()){
            throw new FileReaderException("file is empty");
        }
    }
}
