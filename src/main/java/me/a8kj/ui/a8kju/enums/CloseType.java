package me.a8kj.ui.a8kju.enums;

import javax.swing.JFrame;

import lombok.Getter;

@Getter
public enum CloseType {

    KEEP_OPEN(JFrame.DO_NOTHING_ON_CLOSE), 
    CLOSE_ON_EXIT(JFrame.EXIT_ON_CLOSE);

    private int closeType;

    CloseType(int closeType) {
        this.closeType = closeType;
    }

}
