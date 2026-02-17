package filetransfer.filetransfer.controller;

import filetransfer.filetransfer.dtos.request.FileReaderAndWriterRequest;
import filetransfer.filetransfer.dtos.response.FileReaderAndWriterResponse;
import filetransfer.filetransfer.service.FileReader;
import filetransfer.filetransfer.service.FileReaderAndWriter;
import filetransfer.filetransfer.service.FileReaderImpl;
import filetransfer.filetransfer.service.FileReaderAndWriterImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class ReadFileController {
    private FileReader fileReader;
    private FileReaderAndWriter fileReaderAndWriter;

    public ReadFileController() {
        this.fileReader = new FileReaderImpl();
        this.fileReaderAndWriter = new FileReaderAndWriterImpl();
    }

    @GetMapping("/{fileLocation}")
    public ResponseEntity<?> readFile(@PathVariable String fileLocation) {
        String fileReaderResponse = fileReader.readFile(fileLocation);
        return ResponseEntity.status(HttpStatus.FOUND).body(fileReaderResponse);
    }

    @PostMapping("/readAndWriteFile")
    public ResponseEntity<?> readAndWriteFile(@RequestBody FileReaderAndWriterRequest fileReaderAndWriterRequest) throws IOException {
        FileReaderAndWriterResponse fileReaderAndWriterResponse = fileReaderAndWriter.readsAndWriteToFile(fileReaderAndWriterRequest);
        return ResponseEntity.status(HttpStatus.FOUND).body(fileReaderAndWriterResponse);
    }
}
