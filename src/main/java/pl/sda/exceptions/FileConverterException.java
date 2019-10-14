package pl.sda.exceptions;

public class FileConverterException extends RuntimeException {
    public FileConverterException(String msg) {
        super(msg);
    }

    public FileConverterException(String msg, Throwable e) {
        super(msg, e);
    }
}