package com.file.server.controller;

import com.file.server.service.FileService;
import com.file.server.service.impl.ImageFileServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class FileController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final FileService fileService;
    private final ImageFileServiceImpl imageService;

    /**
     * 파일 저장
     *
     * 파일 저장은 보안코드 없이는 허용하지 않는다.
     *
     * @return
     */
    public ResponseEntity<?> save(){
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    /**
     * 이미지 요청 (보안절차 없음)
     *
     * @param uuid uuid
     * @param w 가로길이
     * @param h 세로길이
     * @return
     */
    @GetMapping("/image/{uuid}")
    public ResponseEntity<?> send(
            @PathVariable String uuid,
            @RequestParam(required = false) Integer w,
            @RequestParam(required = false) Integer h){

        return new ResponseEntity<>(imageService.load(uuid, w, h), HttpStatus.OK);
    }
}
