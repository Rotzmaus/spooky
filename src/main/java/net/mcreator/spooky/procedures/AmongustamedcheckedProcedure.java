package net.mcreator.spooky.procedures;

import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;

public class AmongustamedcheckedProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return !(entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false);
	}
}
