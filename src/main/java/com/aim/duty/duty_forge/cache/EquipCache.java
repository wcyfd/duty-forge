package com.aim.duty.duty_forge.cache;

import java.util.HashMap;
import java.util.Map;

import com.aim.duty.duty_base.entity.bo.Equip;

public class EquipCache {
	public static Map<Integer, Equip> equipMap = new HashMap<>();

	public static Map<Integer, Equip> getEquipMap() {
		return equipMap;
	}
}
