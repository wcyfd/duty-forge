package com.aim.duty.duty_forge.entity;

public abstract class GameObject {

	private boolean change;

	public abstract boolean isChange();

	public void setChange(boolean change) {
		this.change = change;
	}

}
