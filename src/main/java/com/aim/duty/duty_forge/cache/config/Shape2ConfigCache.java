package com.aim.duty.duty_forge.cache.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.aim.duty.duty_forge.entity.config.Shape2Config;

public class Shape2ConfigCache {
	public static Map<Integer, Shape2Config> map = new HashMap<>();
	public static Vector<String> shape2NameVector = new Vector<>();
	public static Vector<Shape2Config> shape2Vector = new Vector<>();
	
	public static void putConfig(Shape2Config config){
		map.put(config.id, config);
		shape2NameVector.add(config.name);
		shape2Vector.add(config);
	}
}
