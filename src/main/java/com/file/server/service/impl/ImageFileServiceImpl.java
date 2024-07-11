package com.file.server.service.impl;

import com.file.server.entity.RunSystemOs;
import com.file.server.repository.FileRepository;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

@Service
public class ImageFileServiceImpl extends FileServiceImpl {

    public ImageFileServiceImpl(FileRepository fileRepository, RunSystemOs runSystemOs) {
        super(fileRepository, runSystemOs);
    }

    /**
     * 사이즈에 맞는 이미지 가져오기
     *
     * @param uuid
     * @param w
     * @param h
     * @return
     */
    public FileSystemResource load(String uuid, Integer w, Integer h) {
        // 원본 이미지 가져오기
        if(w== null && h == null) return super.load(uuid);

        return new FileSystemResource(this.getTempUuid(uuid, w, h));
    }

    /**
     * 파일 정보를 토대로 임시 이미지 아이디를 찾는다.
     *
     * @param uuid
     * @param w
     * @param h
     * @return
     */
    private String getTempUuid(String uuid, Integer w, Integer h){
        String newUuid = uuid;

        if(w != null && h != null) newUuid += "(w=" + w + ",h=" + h + ")"; // (w=300,h=450)
        else if(w != null && h == null) newUuid += "(w=" + w + ")"; // (w=300)
        else if(w == null && h != null) newUuid += "(h=" + h + ")"; // (h=450)

        return newUuid;
    }
}
