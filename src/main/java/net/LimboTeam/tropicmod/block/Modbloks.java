package net.LimboTeam.tropicmod.block;

import net.LimboTeam.tropicmod.TropicAdventureMod;
import net.LimboTeam.tropicmod.block.custom.*;
import net.LimboTeam.tropicmod.block.entity.ModWoodTypes;
import net.LimboTeam.tropicmod.item.ModCreativeModTab;
import net.LimboTeam.tropicmod.item.ModItems;
import net.LimboTeam.tropicmod.world.feature.tree.PalmTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class Modbloks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TropicAdventureMod.MOD_ID);


    //Блоки
    public static final RegistryObject<Block> LAVA_BLOCK = registerBlock("lava_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).
                    strength(6f).requiresCorrectToolForDrops()), ModCreativeModTab.TropicModTab);

    public static final RegistryObject<Block> VOLIFRAM_BLOCK = registerBlock("volifram_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).
                    strength(6f).requiresCorrectToolForDrops()), ModCreativeModTab.TropicModTab);

    public static final RegistryObject<Block> ORICHALCUM_BLOCK = registerBlock("orichalcum_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).
                    strength(6f).requiresCorrectToolForDrops()), ModCreativeModTab.TropicModTab);

    //verevka
    public static final RegistryObject<Block> VEREVKA = registerBlock("verevka",
            () -> new Rope(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.BAMBOO).noOcclusion()),
            ModCreativeModTab.TropicModTab);


    //serdtse
    public static final RegistryObject<Block> HEART_BLOCK = registerBlock("heart_block",
            () -> new HeartBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion().
                    lightLevel(state -> state.getValue(HeartBlock.LIT) ? 6 : 0)), ModCreativeModTab.TropicModTab);

    public static final RegistryObject<Block> HEART_LAMP = registerBlock("heart_lamp",
            () -> new HeartLamp(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion().
                    lightLevel(state -> state.getValue(HeartBlock.LIT) ? 10 : 0)), ModCreativeModTab.TropicModTab);


    //Руды
    public static final RegistryObject<Block> VOLIFRAM = registerBlock("volifram",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f), UniformInt.of(3, 7)), ModCreativeModTab.TropicModTab);


    public static final RegistryObject<Block> LAVA_BLOCK_ORE = registerBlock("lavablockore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModTab.TropicModTab);

    public static final RegistryObject<Block> ORICHALCUM_BLOCK_ORE = registerBlock("orichalcum_block_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(8f).requiresCorrectToolForDrops(),
                    UniformInt.of(5, 9)), ModCreativeModTab.TropicModTab);


    //Vaza
    public static final RegistryObject<Block> VASE = registerBlock("vase",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.GLASS)
                    .strength(1f).requiresCorrectToolForDrops().noOcclusion(),
                    UniformInt.of(5, 9)), ModCreativeModTab.TropicModTab);


    //star crop
    public static final RegistryObject<Block> STAR_CROP_BLOCK = BLOCKS.register("star_crop_block",
            () -> new StarCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    //Palm tree things
    public static final RegistryObject<Block> PALM_LOG = registerBlock("palm_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .requiresCorrectToolForDrops()), ModCreativeModTab.TropicModTab);
    public static final RegistryObject<Block> PALM_WOOD = registerBlock("palm_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .requiresCorrectToolForDrops()), ModCreativeModTab.TropicModTab);
    public static final RegistryObject<Block> STRIPPED_PALM_LOG = registerBlock("stripped_palm_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                    .requiresCorrectToolForDrops()), ModCreativeModTab.TropicModTab);
    public static final RegistryObject<Block> STRIPPED_PALM_WOOD = registerBlock("stripped_palm_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    .requiresCorrectToolForDrops()), ModCreativeModTab.TropicModTab);

    public static final RegistryObject<Block> PALM_PLANKS = registerBlock("palm_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    .requiresCorrectToolForDrops()) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            }, ModCreativeModTab.TropicModTab);
    public static final RegistryObject<Block> PALM_LEAVES = registerBlock("palm_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .requiresCorrectToolForDrops()) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            }, ModCreativeModTab.TropicModTab);

    public static final RegistryObject<Block> PALM_SAPLING = registerBlock("palm_sapling",
            () -> new SaplingBlock(new PalmTreeGrower(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModTab.TropicModTab);

    public static final RegistryObject<Block> PALM_STAIRS = registerBlock("palm_stairs",
            () -> new StairBlock(() -> Modbloks.PALM_PLANKS.get().defaultBlockState() ,BlockBehaviour.Properties.of(Material.WOOD)
                    .requiresCorrectToolForDrops()), ModCreativeModTab.TropicModTab);

    public static final RegistryObject<Block> PALM_SLAB = registerBlock("palm_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .requiresCorrectToolForDrops()), ModCreativeModTab.TropicModTab);

    public static final RegistryObject<Block> PALM_FENCE = registerBlock("palm_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .requiresCorrectToolForDrops()), ModCreativeModTab.TropicModTab);

    public static final RegistryObject<Block> PALM_FENCE_GATE = registerBlock("palm_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .requiresCorrectToolForDrops()), ModCreativeModTab.TropicModTab);

    public static final RegistryObject<Block> PALM_BUTTON = registerBlock("palm_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .requiresCorrectToolForDrops().noCollission()), ModCreativeModTab.TropicModTab);

    public static final RegistryObject<Block> PALM_PRESSURE_PLATE = registerBlock("palm_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,BlockBehaviour.Properties.of(Material.WOOD)
                    .requiresCorrectToolForDrops()), ModCreativeModTab.TropicModTab);

    public static final RegistryObject<Block> PALM_DOOR = registerBlock("palm_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .requiresCorrectToolForDrops().noOcclusion()), ModCreativeModTab.TropicModTab);

    public static final RegistryObject<Block> PALM_TRAP_DOOR= registerBlock("palm_trap_door",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .requiresCorrectToolForDrops().noOcclusion()), ModCreativeModTab.TropicModTab);

    public static final RegistryObject<Block> PALM_WALL_SIGN = registerBlockWithoutBlockItem("palm_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.PALM));

    public static final RegistryObject<Block> PALM_SIGN = registerBlockWithoutBlockItem("palm_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.PALM));




    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
