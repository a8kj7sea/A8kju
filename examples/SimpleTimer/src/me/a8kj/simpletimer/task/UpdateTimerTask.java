package me.a8kj.simpletimer.task;

import javax.swing.JLabel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.a8kj.simpletimer.entity.Timer;
import me.a8kj.simpletimer.menu.TimerMenu;
import me.a8kj.simpletimer.panel.CountdownPanel;
import me.a8kj.ui.a8kju.enums.TaskState;
import me.a8kj.ui.a8kju.util.A8kjuTask;

@SuppressWarnings("deprecation")
@RequiredArgsConstructor
@Getter
public class UpdateTimerTask extends A8kjuTask {

    private final TimerMenu timerMenu;

    @Override
    public void run() {

        if (getTaskState() != TaskState.RUNNING)
            return;

        CountdownPanel countdownPanel = this.timerMenu.getCountdownPanel();
        JLabel countdownLabel = countdownPanel.getTimerLabel();

        Timer ourSimpleTimer = this.timerMenu.getTimer();

        if (timerMenu.getTimer().canEnd()) {
            this.cancel();
            countdownLabel.setText("Deal!");
            return;
        }

        ourSimpleTimer.start();
        countdownLabel.setText(String.format("%02d:%02d", ourSimpleTimer.getMinutes(), ourSimpleTimer.getSeconds()));

    }

}
