package net.mcreator.soupthemod.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.soupthemod.SoupTheModModElements;

import java.util.Map;

@SoupTheModModElements.ModElement.Tag
public class SoupFoodEatenProcedure extends SoupTheModModElements.ModElement {
	public SoupFoodEatenProcedure(SoupTheModModElements instance) {
		super(instance, 1);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure SoupFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity && !entity.world.isRemote) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Soup!"), (false));
		}
	}
}
