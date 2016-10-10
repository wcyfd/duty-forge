package com.aim.duty.duty_forge.service;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import com.aim.duty.duty_base.cache.config.FuelConfigCache;
import com.aim.duty.duty_base.cache.config.MineConfigCache;
import com.aim.duty.duty_base.cache.config.Shape1ConfigCache;
import com.aim.duty.duty_base.cache.config.Shape2ConfigCache;
import com.aim.duty.duty_base.cache.config.Shape3ConfigCache;
import com.aim.duty.duty_base.entity.bo.Equip;
import com.aim.duty.duty_base.entity.bo.Furnace;
import com.aim.duty.duty_base.entity.bo.Prop;
import com.aim.duty.duty_base.entity.config.FuelConfig;
import com.aim.duty.duty_base.entity.config.MineConfig;
import com.aim.duty.duty_base.entity.config.Shape1Config;
import com.aim.duty.duty_base.entity.config.Shape2Config;
import com.aim.duty.duty_base.entity.config.Shape3Config;
import com.aim.duty.duty_base.service.Constant;
import com.aim.duty.duty_base.util.Util;
import com.aim.duty.duty_forge.cache.ConstantCache;
import com.aim.duty.duty_forge.cache.EquipCache;
import com.aim.duty.duty_forge.cache.PropCache;

public class ForgeServiceImpl implements ForgeService {

	@Override
	public void create(Furnace forge, int propId, int num, int shape1, int shape2, int shape3) {
		Equip equip = this.createEquip();
		forge.setEquip(equip);

		equip.getAttributeMap().put(Constant.MATERIAL, propId);
		equip.getAttributeMap().put(Constant.MATERIAL_COUNT, num);
		equip.getAttributeMap().put(Constant.SHAPE_1, shape1);
		equip.getAttributeMap().put(Constant.SHAPE_2, shape2);
		equip.getAttributeMap().put(Constant.SHAPE_3, shape3);
		equip.getAttributeMap().put(Constant.SHAPE_1_HIT, 0);
		equip.getAttributeMap().put(Constant.SHAPE_2_HIT, 0);
		equip.getAttributeMap().put(Constant.SHAPE_3_HIT, 0);
	}

	@Override
	public void addFuel(Furnace forge, int propId, int num) {
		int readyFuelId = forge.getReadyFuelId();
		if (readyFuelId == propId) {
			forge.setReadyFuelNum(forge.getReadyFuelNum() + num);
		} else {
			forge.setReadyFuelId(propId);
			forge.setReadyFuelNum(num);
		}

	}

	@Override
	public void updateTemperature(Furnace forge) {
		int nowTime = Util.getTime2();

		if (nowTime >= forge.getBurnEndTime()) {
			int readyFuelId = forge.getReadyFuelId();
			if (readyFuelId != Constant.NO_PROP) {
				forge.setBurnFuelId(readyFuelId);
				forge.setBurnDeltaTime(FuelConfigCache.map.get(readyFuelId).duration);
				forge.setBurnStartTime(nowTime);
				forge.setReadyFuelNum(forge.getReadyFuelNum() - 1);
				if (forge.getReadyFuelNum() == 0)
					forge.setReadyFuelId(Constant.NO_PROP);
			} else {
				forge.setBurnFuelId(Constant.NO_PROP);
			}
		}

		int t = forge.getTemperature();
		if (forge.getBurnFuelId() != Constant.NO_PROP) {
			FuelConfig config = FuelConfigCache.map.get(forge.getBurnFuelId());

			if (t + config.addHeart > config.maxHeart) {
				if (t - config.reduceHeart < config.maxHeart) {
					t = config.maxHeart;
				} else if (t - config.reduceHeart > config.maxHeart) {
					t -= config.reduceHeart;
				}
			} else {
				t += config.addHeart;
			}

		} else {
			t -= 40;
			t = t <= 0 ? 0 : t;
		}
		forge.setTemperature(t);
		System.out.println(forge.getTemperature());

	}

	@Override
	public void hit(Furnace forge, int partId) {
		int temperature = forge.getTemperature();
		Equip equip = forge.getEquip();
		if (equip == null) {
			return;
		}
		int mine = this.getAttribute(equip, Constant.MATERIAL);
		MineConfig mineConfig = MineConfigCache.map.get(mine);
		if (temperature < mineConfig.temperature) {
			return;
		}

		boolean addDuration = false;
		int attack = 0;
		int defence = 0;
		int duration = 0;
		if (partId == 1) {
			this.addAttribute(equip, Constant.SHAPE_1_HIT, 1);
			int hit = this.getAttribute(equip, Constant.SHAPE_1_HIT);
			int shapeId = this.getAttribute(equip, Constant.SHAPE_1);
			Shape1Config config = Shape1ConfigCache.map.get(shapeId);
			if (hit > config.baseHit && hit <= config.maxHit) {
				addDuration = true;
			} else if (hit == config.baseHit) {
				this.addAttribute(equip, Constant.ATTACK, config.attack);
				this.addAttribute(equip, Constant.DURATION, config.duration);

			}
			attack = config.attack;
			duration = config.duration;

		} else if (partId == 2) {
			this.addAttribute(equip, Constant.SHAPE_2_HIT, 1);
			int hit = this.getAttribute(equip, Constant.SHAPE_2_HIT);
			int shapeId = this.getAttribute(equip, Constant.SHAPE_2);
			Shape2Config config = Shape2ConfigCache.map.get(shapeId);
			if (hit > config.baseHit && hit <= config.maxHit) {
				addDuration = true;
			} else if (hit == config.baseHit) {
				this.addAttribute(equip, Constant.DEFENCE, config.defence);
			}

			defence = config.defence;

		} else if (partId == 3) {
			this.addAttribute(equip, Constant.SHAPE_3_HIT, 1);
			int hit = this.getAttribute(equip, Constant.SHAPE_3_HIT);
			int shapeId = this.getAttribute(equip, Constant.SHAPE_3);
			Shape3Config config = Shape3ConfigCache.map.get(shapeId);
			if (hit > config.baseHit && hit <= config.maxHit) {
				addDuration = true;
			} else if (hit == config.baseHit) {
				this.addAttribute(equip, Constant.ATTACK, config.attack);
				this.addAttribute(equip, Constant.DURATION, config.duration);
			}

			attack = config.attack;
			duration = config.duration;
		}

		if (addDuration) {

			// for (WeightDuration w : PropCache.getDurationList()) {
			// if (temperature >= w.getMin() && temperature < w.getMax()) {
			// attributeMap.put(Constant.DURATION, duration + w.getValue());
			// break;
			// }
			// }

			int randAttack = Util.rand(attack);
			int randDuration = Util.rand(duration);
			int randDefence = Util.rand(defence);
			this.addAttribute(equip, Constant.ATTACK, randAttack);
			this.addAttribute(equip, Constant.DURATION, randDuration);
			this.addAttribute(equip, Constant.DEFENCE, randDefence);

			this.addAttribute(equip, Constant.DURATION, 2);
		}

	}

	public int getAttribute(Equip equip, String name) {
		Integer i = equip.getAttributeMap().get(name);
		return i == null ? 0 : i;
	}

	public void addAttribute(Equip equip, String name, int addNum) {
		Integer v = equip.getAttributeMap().get(name);
		if (v == null) {
			v = 0;
			equip.getAttributeMap().put(name, v);
		}
		v += addNum;
		equip.getAttributeMap().put(name, v);
	}

	@Override
	public void addMagic(Furnace forge, int partId, int magicId) {
		Equip equip = ConstantCache.forge.getEquip();
		if (equip == null)
			return;

		int value = Util.rand(100);

		this.addAttribute(equip, Constant.MAGIC + partId + "|" + magicId, value);

	}

	@Override
	public void sharp(Furnace forge) {
		Equip equip = forge.getEquip();
		if (equip == null)
			return;

		int value = Util.rand(500);
		this.addAttribute(equip, Constant.ATTACK, value);
		Map<Integer, Equip> map = EquipCache.getEquipMap();
		int size = map.size();
		equip.setId(size + 1);
		map.put(equip.getId(), equip);
		forge.setEquip(null);
	}

	@Override
	public void destroyEquip(Furnace forge, int equipId) {
		Equip equip = EquipCache.getEquipMap().get(equipId);
		int materalId = equip.getAttributeMap().get(Constant.MATERIAL);
		int materal_count = equip.getAttributeMap().get(Constant.MATERIAL_COUNT);
		Random rand = new Random();
		int num = rand.nextInt(materal_count);
		this.addProp(materalId, materal_count);
	}

	@Override
	public void print(StringBuilder sb, Equip equip) {
		// TODO Auto-generated method stub
		for (Entry<String, Integer> entrySet : equip.getAttributeMap().entrySet()) {
			String name = entrySet.getKey();
			Integer value = entrySet.getValue();
			sb.append(name).append(":").append(value).append("\n");
		}
	}

	private Equip createEquip() {
		Equip equip = new Equip();
		int size = EquipCache.getEquipMap().size();
		return equip;
	}

	private void addProp(int propId, int num) {
		if (propId == 0) {
			return;
		}
		Prop prop = PropCache.getPropMap().get(propId);
		if (checkPropIsNull(prop)) {
			prop = this.createProp(propId);
			PropCache.getPropMap().put(prop.getPropId(), prop);
		}
		prop.setNum(prop.getNum() + num);
	}

	private boolean checkProp(Prop prop, int num) {
		if (checkPropIsNull(prop))
			return true;

		if (checkPropNotEnough(prop, num))
			return true;
		return false;
	}

	private boolean checkPropIsNull(Prop prop) {
		if (prop == null) {
			System.out.println("prop is null");
			return true;
		}
		return false;
	}

	private boolean checkPropNotEnough(Prop prop, int num) {
		int originNum = prop.getNum();
		if (num < originNum) {
			System.out.println("fuel not enough");
			return true;
		}
		return false;
	}

	private Prop createProp(int propId) {
		Prop prop = new Prop();
		prop.setPropId(propId);
		return prop;
	}

}
