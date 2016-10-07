package com.aim.duty.duty_forge.entity.config;

public class Shape1Config {
	public int id;
	public String name;
	public int duration;
	public int attack;
	public int baseHit;
	public int maxHit;

	public Shape1Config(int id, String name,int duration,int attack,int baseHit,int maxHit) {
		this.name = name;
		this.id = id;
		this.attack = attack;
		this.duration = duration;
		this.baseHit = baseHit;
		this.maxHit = maxHit;
	}
}
