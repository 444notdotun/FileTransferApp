package filetransfer.filetransfer.service;

import filetransfer.filetransfer.dtos.request.FileReaderAndWriterRequest;
import filetransfer.filetransfer.dtos.response.FileReaderAndWriterResponse;

import java.io.IOException;

public interface FileReaderAndWriter {
    FileReaderAndWriterResponse readsAndWriteToFile(FileReaderAndWriterRequest fileReaderRequest) throws IOException;


}
