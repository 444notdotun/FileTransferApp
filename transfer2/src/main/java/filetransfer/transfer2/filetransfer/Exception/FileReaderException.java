package filetransfer.transfer2.filetransfer.Exception;

public class FileReaderException extends FileTransferException {
    public FileReaderException(String fileIsEmpty) {
        super(fileIsEmpty);
    }
}
