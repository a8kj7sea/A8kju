package me.a8kj.ui.a8kju.util;

import java.util.Timer;
import java.util.TimerTask;

import lombok.Getter;
import me.a8kj.ui.a8kju.enums.TaskState;

// not completed yet and not good choice to use
@Deprecated
public abstract class A8kjuTask extends TimerTask {

    @Getter
    private TaskState taskState = TaskState.IDLE;
    private final Timer timer = new Timer();

    public A8kjuTask runTaskLater(int delay) {
        taskState = TaskState.RUNNING;
        this.timer.schedule(this, delay);
        return this;
    }

    public A8kjuTask runTaskTimer(int startAfter, int period) {
        taskState = TaskState.RUNNING;
        this.timer.scheduleAtFixedRate(this, startAfter, period);
        return this;
    }

    @Override
    public boolean cancel() {
        taskState = TaskState.CANCELLED;
        return super.cancel();
    }

}
