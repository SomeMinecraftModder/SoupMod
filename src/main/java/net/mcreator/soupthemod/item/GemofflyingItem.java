
package net.mcreator.soupthemod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import net.mcreator.soupthemod.procedures.GemofflyingItemInHandTickProcedure;
import net.mcreator.soupthemod.SoupTheModModElements;

import java.util.Map;
import java.util.HashMap;

@SoupTheModModElements.ModElement.Tag
public class GemofflyingItem extends SoupTheModModElements.ModElement {
	@ObjectHolder("soup_the_mod:gemofflying")
	public static final Item block = null;
	public GemofflyingItem(SoupTheModModElements instance) {
		super(instance, 74);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxDamage(500).rarity(Rarity.UNCOMMON));
			setRegistryName("gemofflying");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			if (selected) {
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				GemofflyingItemInHandTickProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
