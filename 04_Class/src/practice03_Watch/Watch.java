package practice03_Watch;

public class Watch {
	
	Watch watch;
	
    // 필드
	private int hour;  // 0 ~ 23
	private int minute;  // 0 ~ 59
	private int second;  // 0 ~ 59
	
	// 생성자
	public Watch(int hour, int minute, int second) {
		this.hour = hour;  
		this.minute = minute;
		this.second = second;
	}
	// 메소드

	public Watch getWatch() {
		return watch;
	}

	public void setWatch(Watch watch) {
		this.watch = watch;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

}
