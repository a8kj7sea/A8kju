package me.a8kj.simpletimer.menu;

import javax.swing.ImageIcon;

import lombok.Getter;



import me.a8kj.simpletimer.entity.Timer;
import me.a8kj.simpletimer.panel.CountdownPanel;
import me.a8kj.ui.a8kju.A8kju;
import me.a8kj.ui.a8kju.entity.Settings;
import me.a8kj.ui.a8kju.entity.Size;
import me.a8kj.ui.a8kju.enums.CloseType;

@Getter
public class TimerMenu extends A8kju {

    private final Timer timer;

    public TimerMenu(Timer timer) {
        super(Settings.builder()
                .appIcon(new ImageIcon("assets/app-icon.png").getImage())
                .title("Example App | Timer")
                .centerize(true) // To make window in middle
                .resizable(false)
                .closeType(CloseType.CLOSE_ON_EXIT)
                .size(new Size(512, 512))
                .visiable(true)
                .build());
        this.timer = timer;
    }

    @Getter
    private CountdownPanel countdownPanel = new CountdownPanel();

    @Override
    protected void onEnable() {
        countdownPanel.init();
        this.add(countdownPanel);
        this.update();
    }

}