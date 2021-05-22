package controller;

import java.io.IOException;

public interface IReadFile {
    public void ReadFileGenericFood (String path, String file) throws IOException;
    public void ReadFileWithoutPath (String file) throws IOException;
}