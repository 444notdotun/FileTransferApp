import filetransfer.filetransfer.dtos.request.FileReaderAndWriterRequest;
import filetransfer.filetransfer.service.FileReader;
import filetransfer.filetransfer.service.FileReaderAndWriter;
import filetransfer.filetransfer.service.FileReaderAndWriterImpl;
import filetransfer.filetransfer.service.FileReaderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderAndWriterImplTest {
    private final FileReaderAndWriter fileReaderAndWriterImpl;
    private FileReader fileReader;

    public  FileReaderAndWriterImplTest() {
        this.fileReaderAndWriterImpl = new FileReaderAndWriterImpl();
        this.fileReader = new FileReaderImpl();
    }
    FileReaderAndWriterRequest fileReaderAndWriterRequest;


    @BeforeEach
    void setUp() {
        fileReaderAndWriterRequest = new FileReaderAndWriterRequest();
        fileReaderAndWriterRequest.setFileName("result.json");
        fileReaderAndWriterRequest.setFilePath("/home/notdotun/Desktop/GITHUB/transfer2/src/main/java/filetransfer/transfer2/filetransfer/utils/");
        fileReaderAndWriterRequest.setLocalPort("8080/readFile?fileLocation=");
        fileReaderAndWriterRequest.setIpAddress("http://127.0.0.1:");
        fileReaderAndWriterRequest.setFileWriterLocation("/home/notdotun/Desktop/GITHUB/CinemaBookingApp/Filetransfer/src/main/java/filetransfer/filetransfer/utils/result.json");
    }
    @Test
    void testThatFileCanBeReadAndResultWritten() throws IOException {
        assertEquals("SUCCESS",fileReaderAndWriterImpl.readsAndWriteToFile(fileReaderAndWriterRequest).getMessage());
    }

    @Test
    void testThatFileCanBeRead(){
        String result = """
                {"name":"Zeus",
                  "age":100000,
                  "country":"greece"
                }""";
        assertEquals(result,fileReader.readFile(fileReaderAndWriterRequest.getFileWriterLocation()));


    }

}