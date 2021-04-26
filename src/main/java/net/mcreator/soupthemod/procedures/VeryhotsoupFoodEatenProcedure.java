package net.mcreator.soupthemod.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.soupthemod.SoupTheModModElements;
import net.mcreator.soupthemod.SoupTheModMod;

import java.util.Map;

@SoupTheModModElements.ModElement.Tag
public class VeryhotsoupFoodEatenProcedure extends SoupTheModModElements.ModElement {
	public VeryhotsoupFoodEatenProcedure(SoupTheModModElements instance) {
		super(instance, 83);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SoupTheModMod.LOGGER.warn("Failed to load dependency entity for procedure VeryhotsoupFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setFire((int) 15);
	}
}
