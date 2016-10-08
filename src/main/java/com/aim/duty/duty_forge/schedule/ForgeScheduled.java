package com.aim.duty.duty_forge.schedule;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.aim.duty.duty_base.entity.bo.Forge;
import com.aim.duty.duty_forge.cache.ConstantCache;
import com.aim.duty.duty_forge.service.ForgeService;

public class ForgeScheduled {
	private static ScheduledExecutorService fightScheduled = new ScheduledThreadPoolExecutor(1);

	public static void start() {
		updateTemperature();
	}

	private static void updateTemperature() {
		fightScheduled.scheduleAtFixedRate(new Runnable() {
			public void run() {
				ForgeService service = ConstantCache.service;
				Forge forge = ConstantCache.forge;
				if (service != null && forge != null)
					service.updateTemperature(forge);
			}
		}, 0, 1, TimeUnit.SECONDS);

	}
}
