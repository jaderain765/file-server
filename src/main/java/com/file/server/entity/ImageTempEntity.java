package com.file.server.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="File")
@Getter
@ToString
public class ImageTempEntity {
    @Id
    private String UUID; // 파일 고유 코드(제한크기) (ex : uuid + (w=300,y=340))
    private Integer width; // 이미지 가로
    private Integer height; // 이미지 세로
    private LocalDateTime saveDt; // 저장 일자
    private LocalDate loadDate; // 불러온 날짜
}
