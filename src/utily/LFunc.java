package utily;

public class LFunc {
	
	public static void Sleep(int time){		//time in 0.1 sec
		time = time * 100;
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
