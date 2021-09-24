package com.shintaro.sheduled.sheduled;

public class Locker {
	
	private static Locker instance;
	private static boolean slepping;
	
	public boolean isSlepping() {
		return slepping;
	}
	
	public boolean setSlepping(boolean state) {
		slepping = state;
		return slepping;
	}
	
	public static Locker getInstance() {
		if(instance == null)
			instance = new Locker();
		return instance;
	}

}
