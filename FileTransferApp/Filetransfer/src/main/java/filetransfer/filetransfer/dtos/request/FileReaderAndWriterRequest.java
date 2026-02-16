package filetransfer.filetransfer.dtos.request;

import lombok.Data;

@Data
public class FileReaderAndWriterRequest {
    private String LocalPort;
    private String IpAddress;
    private String FilePath;
    private String FileName;
    private String fileWriterLocation;
}
