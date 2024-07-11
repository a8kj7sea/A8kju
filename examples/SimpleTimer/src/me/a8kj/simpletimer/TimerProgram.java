package me.a8kj.simpletimer;

import me.a8kj.simpletimer.entity.Timer;
import me.a8kj.simpletimer.menu.TimerMenu;
import me.a8kj.simpletimer.task.UpdateTimerTask;
import me.a8kj.ui.a8kju.exception.NotValidMenuSettingsException;

public class TimerProgram {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        try {
            Timer simpleTimer = Timer.of(0, 120);
            TimerMenu timerMenu = new TimerMenu(simpleTimer);
            timerMenu.build();
            UpdateTimerTask updateTimerTask = new UpdateTimerTask(timerMenu);
            updateTimerTask.runTaskTimer(0, 1000);
        } catch (NotValidMenuSettingsException e) {
            e.printStackTrace();
        }
    }
}
