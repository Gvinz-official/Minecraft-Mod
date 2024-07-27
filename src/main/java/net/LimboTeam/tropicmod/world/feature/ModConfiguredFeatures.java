package net.LimboTeam.tropicmod.world.feature;

import com.google.common.base.Supplier;

import com.google.common.base.Suppliers;
import net.LimboTeam.tropicmod.TropicAdventureMod;
import net.LimboTeam.tropicmod.block.Modbloks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
        DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, TropicAdventureMod.MOD_ID);

    //Определяем что где будет спавниться и создаем лист

    //В обычном мире
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_VOLIFRAM_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, Modbloks.VOLIFRAM.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, Modbloks.VOLIFRAM.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_VASE = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, Modbloks.VASE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, Modbloks.VASE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_HEART_BLOCK = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.POINTED_DRIPSTONE), Modbloks.HEART_BLOCK.get().defaultBlockState())));

    //В Энде
    public static final Supplier<List<OreConfiguration.TargetBlockState>> END_ORICHALCUM_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), Modbloks.ORICHALCUM_BLOCK_ORE.get().defaultBlockState())));

    //В заду
    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_LAVA_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, Modbloks.LAVA_BLOCK_ORE.get().defaultBlockState())));



    //Тут блять используем количество спана и лист из которого будет браться
    public static final RegistryObject<ConfiguredFeature<?, ?>> VOLIFRAM_ORE = CONFIGURED_FEATURES.register("volifram",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_VOLIFRAM_ORES.get(), 9)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> VASE_READY = CONFIGURED_FEATURES.register("vase",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_VASE.get(), 9)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> HEART_BLOCK = CONFIGURED_FEATURES.register("heart_block",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_HEART_BLOCK.get(), 5)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> LAVA_ORE = CONFIGURED_FEATURES.register("lavablockore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_LAVA_ORES.get(), 7)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> ORICHALCUM_ORE = CONFIGURED_FEATURES.register("orichalcum_block_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(END_ORICHALCUM_ORES.get(), 5)));



    public static final RegistryObject<ConfiguredFeature<?, ?>> PALM =
            CONFIGURED_FEATURES.register("palm", ()->
                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(Modbloks.PALM_LOG.get()),
                            new StraightTrunkPlacer(5,6,3),
                            BlockStateProvider.simple(Modbloks.PALM_LEAVES.get()),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                            new TwoLayersFeatureSize(1, 0, 2)).build()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> PALM_SPAWN =
            CONFIGURED_FEATURES.register("palm_spawn", ()-> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            ModPlacedFeatures.PALM_CHECKED.getHolder().get(),
                            0.5F)), ModPlacedFeatures.PALM_CHECKED.getHolder().get())));


    public static void register(IEventBus eventBus){
        CONFIGURED_FEATURES.register(eventBus);
    }
}
