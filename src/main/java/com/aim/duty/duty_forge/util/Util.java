package com.aim.duty.duty_forge.util;

import java.util.Random;

public class Util {

	public static Random rand = new Random();

	public static int rand(int value) {
		if (value <= 0)
			return 0;
		return rand.nextInt(value);
	}

	public static long getTime1() {
		return System.currentTimeMillis();
	}

	public static int getTime2() {
		return (int) (System.currentTimeMillis() / 1000);
	}
}
