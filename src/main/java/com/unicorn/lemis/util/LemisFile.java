package com.unicorn.lemis.util;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author kano_dayo
 * @date 2022/3/31 18:50
 */

public class LemisFile {

    private LemisFile() {}

    public static Path fileExtension(Path file, String fExtension) {
        final String fileName = file.getFileName().toString();
        final int lDot = fileName.lastIndexOf('.');
        if (file.getParent() == null) {
            return Paths.get(fileName.substring(0, lDot + 1) + fExtension);
        } else {
            return file.getParent().resolve(
                    fileName.substring(0, lDot + 1) + fExtension);
        }
    }

}
