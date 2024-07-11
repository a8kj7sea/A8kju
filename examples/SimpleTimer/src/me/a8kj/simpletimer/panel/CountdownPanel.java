package me.a8kj.simpletimer.panel;

import javax.swing.JLabel;
import javax.swing.JPanel;

import lombok.Getter;

import java.awt.Color;
import java.awt.Font;

public class CountdownPanel extends JPanel {

    public CountdownPanel() {
        timerLabel = new JLabel("00:00");
    }

    @Getter
    private JLabel timerLabel;

    public void init() {
        timerLabel.setFont(new Font(Font.SANS_SERIF, 1, 56));
        timerLabel.setForeground(Color.red);
        this.add(timerLabel);
    }

}
