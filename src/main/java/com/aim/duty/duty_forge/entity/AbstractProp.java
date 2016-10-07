package com.aim.duty.duty_forge.entity;

public abstract class AbstractProp extends GameObject {

	private int id;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public abstract boolean isChange();

}
