package com.file.server.service.impl;

import com.file.server.entity.FileEntity;
import com.file.server.entity.RunSystemOs;
import com.file.server.exception.CustomRuntimeException;
import com.file.server.repository.FileRepository;
import com.file.server.service.FileService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@Primary // 구현체가 두개 이상일 경우 해당 구현체를 기본적으로 사용한다.
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final FileRepository fileRepository;
    private final RunSystemOs runSystemOs;

    @Override
    public FileEntity save(FileSystemResource resource) {
        return null;
    }

    @Override
    public FileSystemResource load(String uuid) {
        try{
            FileEntity fe = fileRepository.findById(uuid).orElseThrow(() -> {
                throw new CustomRuntimeException("파일 정보를 찾을 수 없습니다.");
            });

            String filePath = this.runSystemOs.getPathValue() + fe.getFilePath() + "\\" + fe.getFileName() + "." + fe.getExtension();
            File findFile = new File(filePath);

            if(!findFile.exists())
                throw new CustomRuntimeException("경로에 파일이 존재하지 않습니다.");

            return new FileSystemResource(findFile);
        }catch (CustomRuntimeException e){
            log.error(e.getMessage());
        }

        return null;
    }
}
