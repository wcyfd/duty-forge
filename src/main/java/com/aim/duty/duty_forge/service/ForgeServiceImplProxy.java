package com.aim.duty.duty_forge.service;

import java.awt.EventQueue;

import com.aim.duty.duty_base.cache.config.FuelConfigCache;
import com.aim.duty.duty_base.entity.bo.Equip;
import com.aim.duty.duty_base.entity.bo.Furnace;
import com.aim.duty.duty_base.entity.config.FuelConfig;
import com.aim.duty.duty_forge.cache.ConstantCache;
import com.aim.duty.duty_forge.ui.MainFrame;

public class ForgeServiceImplProxy implements ForgeService {

	public ForgeServiceImplProxy(ForgeService service) {
		this.service = service;
	}

	private ForgeService service;

	@Override
	public void create(Furnace forge, int propId, int num, int shape1, int shape2, int shape3) {
		// TODO Auto-generated method stub
		service.create(forge, propId, num, shape1, shape2, shape3);
	}

	@Override
	public void addFuel(Furnace forge, int propId, int num) {
		// TODO Auto-generated method stub
		service.addFuel(forge, propId, num);
		final Furnace f = forge;
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
	public void updateTemperature(Furnace forge) {
		service.updateTemperature(forge);
		final Furnace f = forge;
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
	public void hit(Furnace forge, int partId) {
		// TODO Auto-generated method stub
		service.hit(forge, partId);
	}

	@Override
	public void addMagic(Furnace forge,  int partId, int magicId) {
		// TODO Auto-generated method stub
		service.addMagic(forge, partId, magicId);
	}

	@Override
	public void sharp(Furnace forge) {
		// TODO Auto-generated method stub
		service.sharp(forge);
	}

	@Override
	public void destroyEquip(Furnace forge, int equipId) {
		// TODO Auto-generated method stub
		service.destroyEquip(forge, equipId);
	}
	
	@Override
	public void print(StringBuilder sb,Equip equip) {
		// TODO Auto-generated method stub
		service.print(sb, equip);
		
	}

}
