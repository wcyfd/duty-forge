package com.aim.duty.duty_forge.cache.config;

import com.aim.duty.duty_forge.entity.config.FuelConfig;
import com.aim.duty.duty_forge.entity.config.MagicConfig;
import com.aim.duty.duty_forge.entity.config.MineConfig;
import com.aim.duty.duty_forge.entity.config.Shape1Config;
import com.aim.duty.duty_forge.entity.config.Shape2Config;
import com.aim.duty.duty_forge.entity.config.Shape3Config;

public class ConfigCache {

	public static void init() {
		MineConfigCache.putConfig(new MineConfig(1, "铜", 80));
		MineConfigCache.putConfig(new MineConfig(2, "铁", 120));
		MineConfigCache.putConfig(new MineConfig(3, "银", 180));
		MineConfigCache.putConfig(new MineConfig(4, "金", 200));

		FuelConfigCache.putConfig(new FuelConfig(5, "木头", 10, 100, 8, 30));
		FuelConfigCache.putConfig(new FuelConfig(6, "油", 20, 150, 20, 20));
		FuelConfigCache.putConfig(new FuelConfig(7, "动物脂肪", 15, 130, 20, 20));
		FuelConfigCache.putConfig(new FuelConfig(8, "木炭", 20, 200, 10, 60));
		FuelConfigCache.putConfig(new FuelConfig(9, "煤", 30, 400, 20, 50));

		MagicConfigCache.putConfig(new MagicConfig(10, "水"));
		MagicConfigCache.putConfig(new MagicConfig(11, "火"));
		MagicConfigCache.putConfig(new MagicConfig(12, "风"));
		MagicConfigCache.putConfig(new MagicConfig(13, "电"));

		Shape1ConfigCache.putConfig(new Shape1Config(14, "短剑刃", 30, 10, 2, 20));
		Shape1ConfigCache.putConfig(new Shape1Config(15, "长剑刃", 20, 20, 3, 30));
		Shape1ConfigCache.putConfig(new Shape1Config(16, "重剑刃", 40, 40, 5, 50));

		Shape2ConfigCache.putConfig(new Shape2Config(17, "短护手", 0, 2, 20));
		Shape2ConfigCache.putConfig(new Shape2Config(18, "直形护手", 10, 3, 30));
		Shape2ConfigCache.putConfig(new Shape2Config(19, "圆线形护手", 30, 4, 40));
		Shape2ConfigCache.putConfig(new Shape2Config(20, "半圆形护手", 60, 5, 50));

		Shape3ConfigCache.putConfig(new Shape3Config(21, "单手柄", 20, 20, 2, 20));
		Shape3ConfigCache.putConfig(new Shape3Config(22, "双手柄", 25, 30, 3, 30));
	}
}
