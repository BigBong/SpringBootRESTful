package org.community.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by frodoking on 2016/12/29.
 */
@Component
@ConfigurationProperties("community")
public class CustomProperties {
    private String fileSystemDir;

    public String getFileSystemDir() {
        return fileSystemDir;
    }

    public void setFileSystemDir(String fileSystemDir) {
        this.fileSystemDir = fileSystemDir;
    }
}
