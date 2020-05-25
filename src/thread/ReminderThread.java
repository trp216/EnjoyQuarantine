package thread;

import model.Reminder;
import ui.FreeController;

public class ReminderThread extends Thread {

	private Reminder r;
	
	private FreeController freegui;
	
	private int maxmin;
	
	public ReminderThread(Reminder r, FreeController freegui, int maxmin) {
		this.r = r;
		this.freegui = freegui;;
		setDaemon(true);
	}

	@Override
	public void run() {
		while(r.isKeepRunning()==true) {
			r.advanceTimer(maxmin);
			freegui.isTime(false,r);
			try {
				sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		freegui.isTime(true,r);
	}
}
