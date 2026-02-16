package filetransfer.transfer2.filetransfer.controller;



import filetransfer.transfer2.filetransfer.dtos.response.FileReaderResponse;
import filetransfer.transfer2.filetransfer.service.FileReader;
import filetransfer.transfer2.filetransfer.service.FileReaderImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadFileContoller {
    private final FileReader fileReader;
    public ReadFileContoller() {
        this.fileReader = new FileReaderImpl();
    }

    @GetMapping("/{fileLocation}")
    public ResponseEntity<?> readFile( @RequestParam String fileLocation) {
        System.out.println("fileLocation: " + fileLocation);
        String fileReaderResponse = fileReader.readFile(fileLocation);
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(fileReaderResponse);
    }



}
