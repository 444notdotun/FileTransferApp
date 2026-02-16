package filetransfer.filetransfer.controller;

import filetransfer.filetransfer.dtos.request.FileReaderAndWriterRequest;
import filetransfer.filetransfer.dtos.response.FileReaderAndWriterResponse;
import filetransfer.filetransfer.dtos.response.FileReaderResponse;
import filetransfer.filetransfer.service.FileReader;
import filetransfer.filetransfer.service.FileReaderAndWriter;
import filetransfer.filetransfer.service.FileReaderAndWriterImpl;
import filetransfer.filetransfer.service.FileReaderImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ReadFileContoller {
    private FileReader fileReader;
    private FileReaderAndWriter fileReaderAndWriter;
    public ReadFileContoller() {
        this.fileReader = new FileReaderImpl();
        this.fileReaderAndWriter = new FileReaderAndWriterImpl();
    }

    @GetMapping("/{fileLocation}")
    public ResponseEntity<?> readFile( String fileLocation) {
        String fileReaderResponse = fileReader.readFile(fileLocation);
        return ResponseEntity.status(HttpStatus.FOUND).body(fileReaderResponse);
    }

    @PostMapping("/readAndWriteFile")
    public ResponseEntity<?> readAndWriteFile(FileReaderAndWriterRequest fileReaderAndWriterRequest) throws IOException {
        FileReaderAndWriterResponse  fileReaderAndWriterResponse = fileReaderAndWriter.readsAndWriteToFile(fileReaderAndWriterRequest);
        return ResponseEntity.status(HttpStatus.FOUND).body(fileReaderAndWriterResponse);
    }



}
