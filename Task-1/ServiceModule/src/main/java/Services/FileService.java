package Services;

import java.io.File;
import java.io.IOException;

public class FileService {
    private static final String TEMP_FILE_NAME = "temp-file";
    private static final String TEMP_FILE_EXT = ".tmp";
    File tempFile;

    public FileService() throws IOException {
        createTempFile();
    }

    public void createTempFile() throws IOException {
        tempFile = File.createTempFile(TEMP_FILE_NAME, TEMP_FILE_EXT);
        tempFile.deleteOnExit();
    }

    public File getTempFile() throws IOException {
        return tempFile;
    }
}
