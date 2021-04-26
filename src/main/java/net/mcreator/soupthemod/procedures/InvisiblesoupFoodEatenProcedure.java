package net.mcreator.soupthemod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.soupthemod.SoupTheModModElements;
import net.mcreator.soupthemod.SoupTheModMod;

import java.util.Map;

@SoupTheModModElements.ModElement.Tag
public class InvisiblesoupFoodEatenProcedure extends SoupTheModModElements.ModElement {
	public InvisiblesoupFoodEatenProcedure(SoupTheModModElements instance) {
		super(instance, 85);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SoupTheModMod.LOGGER.warn("Failed to load dependency entity for procedure InvisiblesoupFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INVISIBILITY, (int) 460, (int) 1, (false), (false)));
	}
}
