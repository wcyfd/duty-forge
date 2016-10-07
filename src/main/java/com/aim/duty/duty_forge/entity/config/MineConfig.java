package com.aim.duty.duty_forge.entity.config;

public class MineConfig {

	public MineConfig(int id,String name,int temperature) {
		this.name = name;
		this.id = id;
		this.temperature = temperature;
	}

	public String name;
	public int id;
	public int temperature;
}
