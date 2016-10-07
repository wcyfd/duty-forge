package com.aim.duty.duty_forge.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aim.duty.duty_base.entity.Prop;
import com.aim.duty.duty_base.entity.WeightDuration;

public class PropCache {
	public static Map<Integer, Prop> propMap = new HashMap<>();

	public static List<WeightDuration> durationList = new ArrayList<>();

	public static Map<Integer, Prop> getPropMap() {
		return propMap;
	}

	public static List<WeightDuration> getDurationList() {
		return durationList;
	}

	public static void init() {
		WeightDuration w1 = new WeightDuration(0, 10, 10);
		WeightDuration w2 = new WeightDuration(10, 20, 20);
		WeightDuration w3 = new WeightDuration(20, 30, 30);
		WeightDuration w4 = new WeightDuration(30, 40, 40);
		WeightDuration w5 = new WeightDuration(40, 50, 50);
		WeightDuration w6 = new WeightDuration(50, 70, 60);
		WeightDuration w7 = new WeightDuration(70, 101, 70);
		PropCache.getDurationList().add(w1);
		PropCache.getDurationList().add(w2);
		PropCache.getDurationList().add(w3);
		PropCache.getDurationList().add(w4);
		PropCache.getDurationList().add(w5);
		PropCache.getDurationList().add(w6);
		PropCache.getDurationList().add(w7);
		
		Prop prop = new Prop();
		prop.setPropId(1);
		prop.setNum(2);
		PropCache.getPropMap().put(1, prop);
	}
}
