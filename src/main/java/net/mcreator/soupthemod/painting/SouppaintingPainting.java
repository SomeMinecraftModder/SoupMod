
package net.mcreator.soupthemod.painting;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.entity.item.PaintingType;

import net.mcreator.soupthemod.SoupTheModModElements;

@SoupTheModModElements.ModElement.Tag
public class SouppaintingPainting extends SoupTheModModElements.ModElement {
	public SouppaintingPainting(SoupTheModModElements instance) {
		super(instance, 37);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(32, 32).setRegistryName("souppainting"));
	}
}
