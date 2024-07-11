package com.file.server.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RunSystemOs {
    LINUX("LINUX", "common.config.download.linux-path"),
    WINDOWS("WINDOWS", "common.config.download.windows-path");

    private String name;
    private String pathValue;
}
