package com.gobeyond.memebe.service.impl;

import com.gobeyond.memebe.enumeration.ImageExtensions;
import com.gobeyond.memebe.exception.FileUploadException;
import com.gobeyond.memebe.service.StorageService;
import com.gobeyond.memebe.utils.GlobalUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAmount;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.gobeyond.memebe.utils.MemebeConstants.BASE_PATH;

@Slf4j
@Service
public class StorageServiceImpl implements StorageService {
    @Override
    public void init() {

    }

    @Override
    public void store(MultipartFile file, String userId) {
        try {
            if (file.isEmpty()) {
                throw new FileUploadException(404, "Passed file is corrupted");
            }

            //Checking is the folder related to the user exists or not
            Path path = Path.of(BASE_PATH + userId);
            if (!Files.exists(path)) {
                Files.createDirectory(path);
            }

            List<String> extensions = List.of(String.valueOf(Arrays.stream(ImageExtensions.values()).sorted().collect(Collectors.toList())));
            boolean isFileExtensionValid = extensions.stream().anyMatch(s -> file.getName().contains(s));
            if (!isFileExtensionValid){
                 throw new FileUploadException(400, "File extension is not supported by our system");
            }

            Date now = new Date();
            String inputFileExtension = file.getName().substring(file.getName().lastIndexOf("."));

            //Create File in user's folder
            GlobalUtils.write(file, Path.of(path + "_" + now.toInstant() + inputFileExtension));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Stream<Path> loadAll() {
        return null;
    }

    @Override
    public Path load(String filename) {
        return null;
    }

    @Override
    public Resource loadAsResource(String filename) {
        return null;
    }

    @Override
    public void deleteAll() {

    }

}
