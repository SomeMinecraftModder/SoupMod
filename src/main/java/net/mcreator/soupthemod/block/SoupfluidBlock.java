
package net.mcreator.soupthemod.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.feature.LakesFeature;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Items;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BucketItem;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.Block;

import net.mcreator.soupthemod.SoupTheModModElements;

import java.util.Random;

@SoupTheModModElements.ModElement.Tag
public class SoupfluidBlock extends SoupTheModModElements.ModElement {
	@ObjectHolder("soup_the_mod:soupfluid")
	public static final FlowingFluidBlock block = null;
	@ObjectHolder("soup_the_mod:soupfluid_bucket")
	public static final Item bucket = null;
	public static FlowingFluid flowing = null;
	public static FlowingFluid still = null;
	private ForgeFlowingFluid.Properties fluidproperties = null;
	public SoupfluidBlock(SoupTheModModElements instance) {
		super(instance, 6);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerFluids(RegistryEvent.Register<Fluid> event) {
		event.getRegistry().register(still);
		event.getRegistry().register(flowing);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(still, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(flowing, RenderType.getTranslucent());
	}

	@Override
	public void initElements() {
		fluidproperties = new ForgeFlowingFluid.Properties(() -> still, () -> flowing,
				FluidAttributes.builder(new ResourceLocation("soup_the_mod:blocks/soup_fluid_tex"),
						new ResourceLocation("soup_the_mod:blocks/soup_fluid_tex_no_so_still")).luminosity(0).density(1000).viscosity(1000))
								.bucket(() -> bucket).block(() -> block);
		still = (FlowingFluid) new ForgeFlowingFluid.Source(fluidproperties).setRegistryName("soupfluid");
		flowing = (FlowingFluid) new ForgeFlowingFluid.Flowing(fluidproperties).setRegistryName("soupfluid_flowing");
		elements.blocks.add(() -> new FlowingFluidBlock(still, Block.Properties.create(Material.WATER)) {
		}.setRegistryName("soupfluid"));
		elements.items.add(() -> new BucketItem(still, new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ItemGroup.MISC))
				.setRegistryName("soupfluid_bucket"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("soup_the_mod:soupbiome")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, new LakesFeature(BlockStateFeatureConfig::deserialize) {
				@Override
				public boolean place(IWorld world, ChunkGenerator generator, Random rand, BlockPos pos, BlockStateFeatureConfig config) {
					DimensionType dimensionType = world.getDimension().getType();
					boolean dimensionCriteria = false;
					if (dimensionType == DimensionType.OVERWORLD)
						dimensionCriteria = true;
					if (!dimensionCriteria)
						return false;
					return super.place(world, generator, rand, pos, config);
				}
			}.withConfiguration(new BlockStateFeatureConfig(block.getDefaultState()))
					.withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(10))));
		}
	}
}
