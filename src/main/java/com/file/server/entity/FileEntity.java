package com.file.server.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name="File")
@Getter
@ToString
public class FileEntity {
    @Id
    private String UUID; // 파일 고유 코드
    private String extension; // 확장자
    private String fileName; // 파일 이름
    private FileType fileType; // 파일 종류
    private String filePath; // 저장 경로
    private Long fileSize; // 용량
    private Integer width; // 이미지 가로 길이
    private Integer height; // 이미지 세로 길이
    private char usedYn; // 사용가능 여부
    private LocalDateTime saveDt; // 저장 일자
}
