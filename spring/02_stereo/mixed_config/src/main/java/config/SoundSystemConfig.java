package com.alex.spring.stereo;

import org.springframework.context.annotation.*;

@Configuration
@Import(CDPlayerConfig.class)
@ImportResource("classpath:cd-config.xml")
public class SoundSystemConfig {
}