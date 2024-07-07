package me.a8kj.ui.a8kju;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import me.a8kj.ui.a8kju.entity.Menu;
import me.a8kj.ui.a8kju.entity.Settings;
import me.a8kj.ui.a8kju.exception.NotValidMenuSettingsException;

@Getter
@RequiredArgsConstructor
public abstract class A8kju extends JFrame implements Menu {

	private final @NonNull Settings settings;

	protected abstract void onEnable();

	@Deprecated
	public void onDisable() {
	}

	public A8kju build() throws NotValidMenuSettingsException {

		if (settings == null) {
			throw new NotValidMenuSettingsException();
		}

		this.setVisible(settings.isVisiable());
		this.setTitle();
		this.setResizable(settings.isResizable());
		this.setSize();
		this.setCloseType();
		this.setAppIcon();

		if (settings.isCenterize())
			this.centerize();

		update();
		onEnable();

		return this;

	}

	private void setAppIcon() {
		Image image = settings.getAppIcon();
		if (image != null)
			this.setIconImage(image);
	}

	@Override
	public void centerize() {
		int width = Toolkit.getDefaultToolkit().getScreenSize().width - this.settings.getSize().getWidth();
		int height = Toolkit.getDefaultToolkit().getScreenSize().height - this.settings.getSize().getHeight();
		setLocation(width / 2, height / 2);
	}

	@Deprecated
	@Override
	public void reload() {
		this.disable();
		this.enable();
		this.pack();

	}

	private void setCloseType() {
		if (settings.getCloseType() != null) {
			this.setDefaultCloseOperation(settings.getCloseType().getCloseType());
		}
	}

	private void setTitle() {
		if (settings.getTitle() != null) {
			this.setTitle(settings.getTitle());
		}
	}

	private void setSize() {
		if (settings.getSize() != null) {
			this.setSize(settings.getSize().getWidth(), settings.getSize().getHeight());
		}
	}

	@Override
	public void update() {
		this.pack();
		this.setSize();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void kill() {
		this.disable();
	}
}
