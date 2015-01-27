package swd.game.action

public interface ActionListener {

	public void onstart(Action action);
	public void onend(Action action);
	public void onupdate(Action action);
}
