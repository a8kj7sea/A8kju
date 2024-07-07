package me.a8kj.ui.a8kju.entity;

import java.awt.Image;

import lombok.Builder;
import lombok.Data;
import me.a8kj.ui.a8kju.enums.CloseType;

@Data
@Builder
public class Settings {

    private boolean visiable;
    private String title;
    private Size size;
    private boolean resizable;
    private boolean centerize;

    private Image appIcon;

    private CloseType closeType;

}
