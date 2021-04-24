package net.mcreator.soupthemod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.soupthemod.SoupTheModModElements;

import java.util.Map;

@SoupTheModModElements.ModElement.Tag
public class InvertedsoupFoodEatenProcedure extends SoupTheModModElements.ModElement {
	public InvertedsoupFoodEatenProcedure(SoupTheModModElements instance) {
		super(instance, 67);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure InvertedsoupFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.LEVITATION, (int) 480, (int) 1, (false), (false)));
	}
}
