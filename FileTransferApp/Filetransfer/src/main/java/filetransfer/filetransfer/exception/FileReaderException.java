package filetransfer.filetransfer.exception;

public class FileReaderException extends FileTransferException {
    public FileReaderException(String fileIsEmpty) {
        super(fileIsEmpty);
    }
}
