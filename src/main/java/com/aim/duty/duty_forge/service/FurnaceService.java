package com.aim.duty.duty_forge.service;

import com.aim.duty.duty_base.entity.bo.Equip;
import com.aim.duty.duty_base.entity.bo.Furnace;

public interface FurnaceService {
	void create(Furnace forge,int propId, int num, int shape1, int shape2, int shape3);

	void addFuel(Furnace forge, int propId, int num);

	void updateTemperature(Furnace forge);

	void hit(Furnace forge, int partId);

	void addMagic(Furnace forge,int partId, int magicId);

	void sharp(Furnace forge);
	
	void destroyEquip(Furnace forge,int equipId);
	
	void print(StringBuilder sb,Equip equip);
}
