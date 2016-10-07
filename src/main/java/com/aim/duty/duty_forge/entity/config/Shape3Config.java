package com.aim.duty.duty_forge.entity.config;

public class Shape3Config {
	public int id;
	public String name;
	public int duration;
	public int attack;
	public int baseHit;
	public int maxHit;

	public Shape3Config(int id, String name,int duration,int attack,int baseHit,int maxHit) {
		this.name = name;
		this.id = id;
		this.duration = duration;
		this.attack = attack;
		this.baseHit = baseHit;
		this.maxHit = maxHit;
	}
}
