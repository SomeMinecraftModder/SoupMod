
package net.mcreator.soupthemod.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.soupthemod.itemgroup.SouplistItemGroup;
import net.mcreator.soupthemod.SoupTheModModElements;

import java.util.List;
import java.util.Collections;

@SoupTheModModElements.ModElement.Tag
public class SoupwoodFenceGateBlock extends SoupTheModModElements.ModElement {
	@ObjectHolder("soup_the_mod:soupwood_fence_gate")
	public static final Block block = null;
	public SoupwoodFenceGateBlock(SoupTheModModElements instance) {
		super(instance, 104);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(SouplistItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends FenceGateBlock {
		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(4f, 6f).lightValue(0));
			setRegistryName("soupwood_fence_gate");
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 10;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
