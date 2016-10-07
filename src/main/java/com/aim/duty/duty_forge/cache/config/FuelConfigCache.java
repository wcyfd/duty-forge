package com.aim.duty.duty_forge.cache.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.aim.duty.duty_forge.entity.config.FuelConfig;

public class FuelConfigCache {
	public static Map<Integer, FuelConfig> map = new HashMap<>();
	public static Vector<String> fuelNameVector = new Vector<>();
	public static Vector<FuelConfig> fuelVector = new Vector<>();

	public static void putConfig(FuelConfig config) {
		fuelNameVector.add(config.name);
		fuelVector.add(config);
		map.put(config.id, config);
	}
}
