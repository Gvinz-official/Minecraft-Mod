package net.LimboTeam.tropicmod.world.feature;

import net.LimboTeam.tropicmod.TropicAdventureMod;
import net.LimboTeam.tropicmod.block.Modbloks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, TropicAdventureMod.MOD_ID);


    public static final RegistryObject<PlacedFeature> VOLIFRAM_ORE_PLACED = PLACED_FEATURES.register("volifram_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.VOLIFRAM_ORE.getHolder().get(),
                    commonOrePlacement(7, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> VASE_PLACED = PLACED_FEATURES.register("vase_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.VASE_READY.getHolder().get(),
                    commonOrePlacement(2, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));



    //trees
   public static final RegistryObject<PlacedFeature> PALM_CHECKED = PLACED_FEATURES.register("palm_checked",
           ()-> new PlacedFeature(ModConfiguredFeatures.PALM.getHolder().get(),
                   List.of(PlacementUtils.filteredByBlockSurvival(Modbloks.PALM_SAPLING.get()))));

   public static final RegistryObject<PlacedFeature> PALM_PLACED = PLACED_FEATURES.register("palm_placed",
           ()-> new PlacedFeature(ModConfiguredFeatures.PALM.getHolder().get(), VegetationPlacements.treePlacement(
                   PlacementUtils.countExtra(3, 0.1f, 2))));





    public static final RegistryObject<PlacedFeature> HEART_BLOCK_PLACED = PLACED_FEATURES.register("heart_block_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.HEART_BLOCK.getHolder().get(), commonOrePlacement(5, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));


    public static final RegistryObject<PlacedFeature> ORICHALCUM_ORE_PLACED = PLACED_FEATURES.register("orichalcum_block_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.ORICHALCUM_ORE.getHolder().get(), commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> LAVA_ORE_PLACED = PLACED_FEATURES.register("lavablockore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.LAVA_ORE.getHolder().get(), commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));


    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }


    public static void register (IEventBus eventBus){
        PLACED_FEATURES.register(eventBus);
    }
}
