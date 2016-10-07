package com.aim.duty.duty_forge.service;

import java.awt.EventQueue;

import com.aim.duty.duty_base.entity.Equip;
import com.aim.duty.duty_base.entity.Forge;
import com.aim.duty.duty_forge.cache.ConstantCache;
import com.aim.duty.duty_forge.cache.config.FuelConfigCache;
import com.aim.duty.duty_forge.entity.config.FuelConfig;
import com.aim.duty.duty_forge.ui.MainFrame;

public class ServiceImplProxy implements Service {

	public ServiceImplProxy(Service service) {
		this.service = service;
	}

	private Service service;

	@Override
	public void create(Forge forge, int propId, int num, int shape1, int shape2, int shape3) {
		// TODO Auto-generated method stub
		service.create(forge, propId, num, shape1, shape2, shape3);
	}

	@Override
	public void addFuel(Forge forge, int propId, int num) {
		// TODO Auto-generated method stub
		service.addFuel(forge, propId, num);
		final Forge f = forge;
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				String readyBurnName = FuelConfigCache.map.get(f.getReadyFuelId()).name;
				MainFrame main = ConstantCache.mainFrame;
				main.getReadyBurnJLabel().setText(main.readyBurnText + readyBurnName);
				System.out.println("num:" + f.getReadyFuelNum());
				main.getReadtBurnCountJLabel().setText(main.readyBurnCountText + f.getReadyFuelNum());
			}

		});
	}

	@Override
	public void updateTemperature(Forge forge) {
		service.updateTemperature(forge);
		final Forge f = forge;
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				MainFrame frame = ConstantCache.mainFrame;
				frame.getTemperatureJLabel().setText(f.getTemperature() + "");
				frame.getReadtBurnCountJLabel().setText(frame.readyBurnCountText + f.getReadyFuelNum());
				FuelConfig config = FuelConfigCache.map.get(f.getBurnFuelId());
				String name = "";
				if (config != null)
					name = config.name;
				frame.getBurningJLabel().setText(frame.buringText + name);

				name="";
				config = FuelConfigCache.map.get(f.getReadyFuelId());
				if (config != null)
					name = config.name;
				frame.getReadyBurnJLabel().setText(frame.readyBurnText + name);
			}
		});
	}

	@Override
	public void hit(Forge forge, int partId) {
		// TODO Auto-generated method stub
		service.hit(forge, partId);
	}

	@Override
	public void addMagic(Forge forge,  int partId, int magicId) {
		// TODO Auto-generated method stub
		service.addMagic(forge, partId, magicId);
	}

	@Override
	public void sharp(Forge forge) {
		// TODO Auto-generated method stub
		service.sharp(forge);
	}

	@Override
	public void destroyEquip(Forge forge, int equipId) {
		// TODO Auto-generated method stub
		service.destroyEquip(forge, equipId);
	}
	
	@Override
	public void print(StringBuilder sb,Equip equip) {
		// TODO Auto-generated method stub
		service.print(sb, equip);
		
	}

}
