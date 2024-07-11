package com.file.server.service;

import com.file.server.entity.FileEntity;
import org.springframework.core.io.FileSystemResource;

public interface FileService {

    /** 파일 저장하기 */
    public FileEntity save(FileSystemResource resource);

    /** 파일 가져오기 */
    public FileSystemResource load(String uuid);

}
