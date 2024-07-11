package com.file.server.repository;

import com.file.server.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileJpaRepository  extends FileRepository, JpaRepository<FileEntity, String>{
}
