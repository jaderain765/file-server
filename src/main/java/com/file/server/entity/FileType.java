package com.file.server.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public enum FileType {
    IMAGE("사진","common.config.save.image.path", new String[]{"png", "jpg", "webp"}),
    ZIP("압축파일","", new String[]{"zip", "7z", "rar", "tar", "gz"}),
    DOCUMENT("문서","", new String[]{"pdf", "xlsx", "txt"});
    
    private String value; // 값
    private String savePath; // 저장 경로(yml)
    private String[] extensions; // 허용 된 확장자
}
