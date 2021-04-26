package net.mcreator.soupthemod.procedures;

import net.minecraftforge.fml.network.NetworkHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.network.PacketBuffer;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.soupthemod.gui.SoupvillagerguiGui;
import net.mcreator.soupthemod.SoupTheModModElements;
import net.mcreator.soupthemod.SoupTheModMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

import io.netty.buffer.Unpooled;

@SoupTheModModElements.ModElement.Tag
public class SoupvillagerRightClickedOnEntityProcedure extends SoupTheModModElements.ModElement {
	public SoupvillagerRightClickedOnEntityProcedure(SoupTheModModElements instance) {
		super(instance, 76);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SoupTheModMod.LOGGER.warn("Failed to load dependency x for procedure SoupvillagerRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SoupTheModMod.LOGGER.warn("Failed to load dependency y for procedure SoupvillagerRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SoupTheModMod.LOGGER.warn("Failed to load dependency z for procedure SoupvillagerRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SoupTheModMod.LOGGER.warn("Failed to load dependency world for procedure SoupvillagerRightClickedOnEntity!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean gui_opened = false;
		gui_opened = (boolean) (false);
		{
			List<Entity> _entfound = world
					.getEntitiesWithinAABB(Entity.class,
							new AxisAlignedBB(x - (4 / 2d), y - (4 / 2d), z - (4 / 2d), x + (4 / 2d), y + (4 / 2d), z + (4 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if ((!(gui_opened))) {
					if ((entityiterator instanceof PlayerEntity)) {
						{
							Entity _ent = entityiterator;
							if (_ent instanceof ServerPlayerEntity) {
								BlockPos _bpos = new BlockPos((int) x, (int) y, (int) z);
								NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
									@Override
									public ITextComponent getDisplayName() {
										return new StringTextComponent("Soupvillagergui");
									}

									@Override
									public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
										return new SoupvillagerguiGui.GuiContainerMod(id, inventory,
												new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
									}
								}, _bpos);
							}
						}
						gui_opened = (boolean) (true);
					}
				}
			}
		}
	}
}
