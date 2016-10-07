package com.aim.duty.duty_forge.cache.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.aim.duty.duty_forge.entity.config.MineConfig;

public class MineConfigCache {
	public static Map<Integer, MineConfig> map = new HashMap<>();
	public static Vector<String> mineNameVector = new Vector<>();
	public static Vector<MineConfig> mineVector = new Vector<>();

	public static void putConfig(MineConfig config) {
		mineNameVector.add(config.name);
		mineVector.add(config);
		map.put(config.id, config);
	}
}
