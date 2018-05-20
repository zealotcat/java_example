package com.alex.spring.stereo;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
// import org.springframework.context.support.*;
import org.springframework.context.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(CDPlayerConfig.class);
        MediaPlayer player = context.getBean(MediaPlayer.class);
        player.play();
    }
}