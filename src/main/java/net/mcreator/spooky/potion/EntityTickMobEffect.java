
package net.mcreator.spooky.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class EntityTickMobEffect extends MobEffect {
	public EntityTickMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
		setRegistryName("entity_tick");
	}

	@Override
	public String getDescriptionId() {
		return "effect.spooky.entity_tick";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
