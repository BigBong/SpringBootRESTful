package org.community.service;

import org.community.property.CustomProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by frodoking on 2016/12/27.
 */
@Service
public class FileService {

    @Autowired
    private CustomProperties customProperties;

    public List<String> getAll() {
        List<String> list = new ArrayList<>();
        String rootPath = customProperties.getFileSystemDir();
        File dir = new File(rootPath);
        if (dir.exists()) {
            File[] files = dir.listFiles();
            for (File f : files) {
                list.add(f.getName());
            }
        }
        return list;
    }

    public void save(MultipartFile file) {
    }
}
