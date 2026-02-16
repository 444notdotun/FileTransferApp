package filetransfer.transfer2.filetransfer.service;


import filetransfer.transfer2.filetransfer.dtos.response.FileReaderResponse;

public interface FileReader {

    String readFile(String fileLocation);
}
