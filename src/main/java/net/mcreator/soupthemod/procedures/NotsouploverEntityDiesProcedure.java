package net.mcreator.soupthemod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;

import net.mcreator.soupthemod.item.SouppiergemItem;
import net.mcreator.soupthemod.item.SoupgemItem;
import net.mcreator.soupthemod.SoupTheModModElements;
import net.mcreator.soupthemod.SoupTheModMod;

import java.util.Random;
import java.util.Map;

@SoupTheModModElements.ModElement.Tag
public class NotsouploverEntityDiesProcedure extends SoupTheModModElements.ModElement {
	public NotsouploverEntityDiesProcedure(SoupTheModModElements instance) {
		super(instance, 41);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SoupTheModMod.LOGGER.warn("Failed to load dependency x for procedure NotsouploverEntityDies!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SoupTheModMod.LOGGER.warn("Failed to load dependency y for procedure NotsouploverEntityDies!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SoupTheModMod.LOGGER.warn("Failed to load dependency z for procedure NotsouploverEntityDies!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SoupTheModMod.LOGGER.warn("Failed to load dependency world for procedure NotsouploverEntityDies!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		for (int index0 = 0; index0 < (int) ((((new Random()).nextInt((int) 2 + 1)) + 1)); index0++) {
			if (!world.getWorld().isRemote) {
				ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(SoupgemItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
		}
		if ((((new Random()).nextInt((int) 5 + 1)) == 0)) {
			if (!world.getWorld().isRemote) {
				ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(SouppiergemItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
		}
	}
}
