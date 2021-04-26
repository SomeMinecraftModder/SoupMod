
package net.mcreator.soupthemod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.mcreator.soupthemod.procedures.InvisiblesoupFoodEatenProcedure;
import net.mcreator.soupthemod.itemgroup.SouplistItemGroup;
import net.mcreator.soupthemod.SoupTheModModElements;

import java.util.Map;
import java.util.HashMap;

@SoupTheModModElements.ModElement.Tag
public class InvisiblesoupItem extends SoupTheModModElements.ModElement {
	@ObjectHolder("soup_the_mod:invisiblesoup")
	public static final Item block = null;
	public InvisiblesoupItem(SoupTheModModElements instance) {
		super(instance, 85);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(SouplistItemGroup.tab).maxStackSize(64).rarity(Rarity.UNCOMMON)
					.food((new Food.Builder()).hunger(9).saturation(0f).build()));
			setRegistryName("invisiblesoup");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.DRINK;
		}

		@Override
		public net.minecraft.util.SoundEvent getEatSound() {
			return net.minecraft.util.SoundEvents.ENTITY_GENERIC_DRINK;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				InvisiblesoupFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
