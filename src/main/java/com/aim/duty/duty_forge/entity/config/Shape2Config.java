package com.aim.duty.duty_forge.entity.config;

public class Shape2Config {
	public int id;
	public String name;
	public int defence;
	public int baseHit;
	public int maxHit;

	public Shape2Config(int id, String name,int defence,int baseHit,int maxHit) {
		this.name = name;
		this.id = id;
		this.defence = defence;
		this.baseHit = baseHit;
		this.maxHit = maxHit;
	}
}
