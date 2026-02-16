package filetransfer.filetransfer.service;

import filetransfer.filetransfer.dtos.request.FileReaderAndWriterRequest;
import filetransfer.filetransfer.dtos.response.FileReaderAndWriterResponse;
import filetransfer.filetransfer.exception.FileReaderException;

import java.io.*;
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
            System.out.println( "seeking file on this url "+uri );
            InputStream reader = uri.toURL().openStream();
            String apiResponse = new String(reader.readAllBytes());
            System.out.println( "apiresponse is "+!apiResponse.isBlank());
            System.out.println("file read successfully");
            return apiResponse;
        } catch (Exception e) {
            System.out.println( "api has issues not my code");
            throw new RuntimeException("api request is bad");
        }

    }

    private void writeResult(String ApiResult,FileReaderAndWriterRequest fileReaderRequest) throws IOException {
        try(OutputStream outputStream = new FileOutputStream(fileReaderRequest.getFileWriterLocation())){
            outputStream.write(ApiResult.getBytes());
            validateFile(ApiResult);
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
