
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
import net.minecraft.block.StairsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.soupthemod.itemgroup.SouplistItemGroup;
import net.mcreator.soupthemod.SoupTheModModElements;

import java.util.List;
import java.util.Collections;

@SoupTheModModElements.ModElement.Tag
public class SoupwoodStairsBlock extends SoupTheModModElements.ModElement {
	@ObjectHolder("soup_the_mod:soupwood_stairs")
	public static final Block block = null;
	public SoupwoodStairsBlock(SoupTheModModElements instance) {
		super(instance, 101);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(SouplistItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends StairsBlock {
		public CustomBlock() {
			super(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(6f, 4f)).getDefaultState(),
					Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(6f, 4f).lightValue(0));
			setRegistryName("soupwood_stairs");
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
