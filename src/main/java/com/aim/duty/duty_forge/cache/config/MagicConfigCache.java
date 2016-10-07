package com.aim.duty.duty_forge.cache.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.aim.duty.duty_forge.entity.config.MagicConfig;

public class MagicConfigCache {
	public static Map<Integer, MagicConfig> map = new HashMap<>();
	public static Vector<String> magicNameVector = new Vector<>();
	public static Vector<MagicConfig> magicConfigVector = new Vector<>();

	public static void putConfig(MagicConfig config) {
		magicNameVector.add(config.name);
		magicConfigVector.add(config);
		map.put(config.id, config);
	}
}
