package com.aim.duty.duty_forge.entity.config;

public class FuelConfig {
	public String name;
	public int id;
	public int addHeart;
	public int maxHeart;
	public int reduceHeart;
	public int duration;

	public FuelConfig(int id, String name, int addHeart, int maxHeart, int reduceHeart,int duration) {
		this.id = id;
		this.name = name;
		this.addHeart = addHeart;
		this.maxHeart = maxHeart;
		this.reduceHeart = reduceHeart;
		this.duration = duration;
	}
}
