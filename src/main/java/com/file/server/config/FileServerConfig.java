package com.file.server.config;

import com.file.server.entity.RunSystemOs;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileServerConfig {

    @Value("common.config.run-system-os")
    private String runSystemOsName;

    /**
     * 시스템 정보
     * 
     * @return
     */
    @Bean
    public RunSystemOs getRunSystemOs() {
        if("WINDOWS".equals(runSystemOsName)) return RunSystemOs.WINDOWS;
        else if("LINUX".equals(runSystemOsName)) return RunSystemOs.LINUX;
        else return RunSystemOs.WINDOWS;
    }

}
