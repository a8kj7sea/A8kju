package me.a8kj.ui.a8kju.entity;

import java.awt.Dimension;
import java.awt.Toolkit;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Size {
    private int width, height;

    private static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();

    public static Size getScreenSize() {
        return new Size((int) SCREEN_SIZE.getWidth(), (int) SCREEN_SIZE.getHeight());
    }

}
