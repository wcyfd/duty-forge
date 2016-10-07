package com.aim.duty.duty_forge.entity;

public class WeightDuration extends Weight {

	public WeightDuration(int min, int max, int duration) {
		this.min = min;
		this.max = max;
		this.value = duration;
	}

	private int value;

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
