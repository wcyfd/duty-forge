package com.aim.duty.duty_forge.cache.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.aim.duty.duty_forge.entity.config.Shape3Config;

public class Shape3ConfigCache {
	public static Map<Integer, Shape3Config> map = new HashMap<>();
	public static Vector<String> shape3NameVector = new Vector<>();
	public static Vector<Shape3Config> shape3Vector = new Vector<>();

	public static void putConfig(Shape3Config config) {
		map.put(config.id, config);
		shape3NameVector.add(config.name);
		shape3Vector.add(config);
	}
}
