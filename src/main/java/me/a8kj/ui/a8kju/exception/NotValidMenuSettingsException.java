package me.a8kj.ui.a8kju.exception;

public class NotValidMenuSettingsException extends Exception {

    public NotValidMenuSettingsException() {
        super("Sorry your menu settings not valid or null !");
    }

    public NotValidMenuSettingsException(String message) {
        super(message);
    }
}
