package net.mcreator.soupthemod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.soupthemod.SoupTheModModElements;
import net.mcreator.soupthemod.SoupTheModMod;

import java.util.Map;

@SoupTheModModElements.ModElement.Tag
public class SpeedsoupFoodEatenProcedure extends SoupTheModModElements.ModElement {
	public SpeedsoupFoodEatenProcedure(SoupTheModModElements instance) {
		super(instance, 81);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SoupTheModMod.LOGGER.warn("Failed to load dependency entity for procedure SpeedsoupFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 1200, (int) 2, (false), (false)));
	}
}
