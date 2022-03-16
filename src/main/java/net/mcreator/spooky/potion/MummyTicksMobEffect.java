
package net.mcreator.spooky.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class MummyTicksMobEffect extends MobEffect {
	public MummyTicksMobEffect() {
		super(MobEffectCategory.HARMFUL, -1);
		setRegistryName("mummy_ticks");
	}

	@Override
	public String getDescriptionId() {
		return "effect.spooky.mummy_ticks";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
