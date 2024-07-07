package me.a8kj.ui.a8kju.entity;

public interface Menu {

    public void update();

    public void kill();

    default public void centerize(){}

    default void reload() {
    };

}
