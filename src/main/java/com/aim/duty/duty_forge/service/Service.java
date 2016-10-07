package com.aim.duty.duty_forge.service;

import com.aim.duty.duty_forge.entity.Equip;
import com.aim.duty.duty_forge.entity.Forge;

public interface Service {
	void create(Forge forge,int propId, int num, int shape1, int shape2, int shape3);

	void addFuel(Forge forge, int propId, int num);

	void updateTemperature(Forge forge);

	void hit(Forge forge, int partId);

	void addMagic(Forge forge,int partId, int magicId);

	void sharp(Forge forge);
	
	void destroyEquip(Forge forge,int equipId);
	
	void print(StringBuilder sb,Equip equip);
}
