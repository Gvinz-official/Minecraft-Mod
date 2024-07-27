package net.LimboTeam.tropicmod;

import com.mojang.logging.LogUtils;
import net.LimboTeam.tropicmod.block.Modbloks;
import net.LimboTeam.tropicmod.block.entity.ModBlockEntities;
import net.LimboTeam.tropicmod.block.entity.ModWoodTypes;
import net.LimboTeam.tropicmod.entity.ModEntityTypes;
import net.LimboTeam.tropicmod.entity.client.EyeRenderer;
import net.LimboTeam.tropicmod.item.ModItems;
import net.LimboTeam.tropicmod.loot.ModLootModifiers;
import net.LimboTeam.tropicmod.util.ModItemProperties;
import net.LimboTeam.tropicmod.world.feature.ModConfiguredFeatures;
import net.LimboTeam.tropicmod.world.feature.ModPlacedFeatures;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TropicAdventureMod.MOD_ID)
public class TropicAdventureMod {
    public static final String MOD_ID = "tropicmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public TropicAdventureMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        Modbloks.register(modEventBus);

        ModBlockEntities.register(modEventBus);

        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);

        ModEntityTypes.register(modEventBus);

        ModLootModifiers.register(modEventBus);

        GeckoLib.initialize();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::ClientSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        Sheets.addWoodType(ModWoodTypes.PALM);
    }
    private void ClientSetup (final FMLClientSetupEvent event){
        ModItemProperties.addCustomItemProperties();

        WoodType.register(ModWoodTypes.PALM);
        BlockEntityRenderers.register(ModBlockEntities.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);
    }



    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ModItemProperties.addCustomItemProperties();
            EntityRenderers.register(ModEntityTypes.EYE.get(), EyeRenderer::new);
        }
    }
}
