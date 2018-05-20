package com.alex.spring.stereo.properties;

import com.alex.spring.stereo.CompactDisc;
import com.alex.spring.stereo.MediaPlayer;

public class CDPlayer implements MediaPlayer {
    private CompactDisc compactDisc;

    // @Autowired
    public void setCompactDisc(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    public void play() {
        compactDisc.play();
    }
}