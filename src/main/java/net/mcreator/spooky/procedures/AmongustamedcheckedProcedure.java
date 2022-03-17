package net.mcreator.spooky.procedures;

import net.minecraftforge.eventbus.api.Event;

public class AmongustamedcheckedProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return !(entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false);
	}
}
