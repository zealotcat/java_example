package com.alex.spring.stereo;

import org.springframework.beans.factory.annotation.*;

public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;

    @Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    @Autowired
    public void setCompactDisc(CompactDisc cd) {
        this.cd = cd;
    }

    public void play() {
        System.out.println("*** A CD Player ***");
        cd.play();
    }
}