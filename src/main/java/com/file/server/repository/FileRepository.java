package com.file.server.repository;

import com.file.server.entity.FileEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileRepository {
    FileEntity save(FileEntity fileEntity);
    Optional<FileEntity> findById(String id);
}
