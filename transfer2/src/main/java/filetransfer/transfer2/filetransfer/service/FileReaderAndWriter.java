package filetransfer.transfer2.filetransfer.service;



import filetransfer.transfer2.filetransfer.dtos.request.FileReaderAndWriterRequest;
import filetransfer.transfer2.filetransfer.dtos.response.FileReaderAndWriterResponse;

import java.io.IOException;

public interface FileReaderAndWriter {
    FileReaderAndWriterResponse readsAndWriteToFile(FileReaderAndWriterRequest fileReaderRequest) throws IOException;


}
