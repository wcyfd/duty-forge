package com.aim.duty.duty_forge.cache.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.aim.duty.duty_forge.entity.config.FuelConfig;
import com.aim.duty.duty_forge.entity.config.Shape1Config;

public class Shape1ConfigCache {
	public static Map<Integer, Shape1Config> map = new HashMap<>();
	public static Vector<String> shape1NameVector = new Vector<>();
	public static Vector<Shape1Config> shape1Vector = new Vector<>();
	
	public static void putConfig(Shape1Config config){
		map.put(config.id, config);
		shape1NameVector.add(config.name);
		shape1Vector.add(config);
	}
}
