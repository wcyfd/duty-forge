package com.aim.duty.duty_forge.entity;

import java.util.HashMap;
import java.util.Map;

public class Equip extends AbstractProp {

	private Map<String, Integer> attributeMap = new HashMap<>();

	@Override
	public boolean isChange() {
		// TODO Auto-generated method stub
		return false;
	}

	public Map<String, Integer> getAttributeMap() {
		return attributeMap;
	}

}
