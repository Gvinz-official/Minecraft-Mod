package net.LimboTeam.tropicmod.item;

import net.LimboTeam.tropicmod.TropicAdventureMod;
import net.LimboTeam.tropicmod.block.Modbloks;
import net.LimboTeam.tropicmod.entity.ModEntityTypes;
import net.LimboTeam.tropicmod.item.custom.FireBallBook;
import net.LimboTeam.tropicmod.item.custom.ModFoods;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TropicAdventureMod.MOD_ID);

    //Адские вещи
    public static final RegistryObject<Item> LAVA_ORE = ITEMS.register("lavaore",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TropicModTab)));
    public static final RegistryObject<Item> LAVA_SLITOK = ITEMS.register("lavaslitok",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TropicModTab)));


    //Вольфрамовые вещи
    public static final RegistryObject<Item> VOLIFRAM_ORE = ITEMS.register("volifram_ore",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TropicModTab)));
    public static final RegistryObject<Item> VOLIFRAM_INGOT = ITEMS.register("volifram_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TropicModTab)));
    public static final RegistryObject<Item> VOLIFRAM_NUGGET = ITEMS.register("volifram_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TropicModTab)));
    public static final RegistryObject<Item> VOLIFRAM_STICK = ITEMS.register("volifram_stick",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TropicModTab)));

    //Арихалковые вещи
    public static final RegistryObject<Item> ORICHALCUM_ORE = ITEMS.register("orichalcum_ore",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TropicModTab)));
    public static final RegistryObject<Item> ORICHALCUM_INGOT = ITEMS.register("orichalcum_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TropicModTab)));


    //eatable
    public static final RegistryObject<Item> HEART = ITEMS.register("heart",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TropicModTab).food(ModFoods.HEART)));
    public static final RegistryObject<Item> STAR = ITEMS.register("star",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TropicModTab).food(ModFoods.STAR)));
    //fruits
    public static final RegistryObject<Item> BANANA = ITEMS.register("banana",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TropicModTab).food(ModFoods.BANANA)));



    //Оружия
    public static final RegistryObject<Item> LAVA_SWORD = ITEMS.register("lava_sword",
            () -> new SwordItem(Tiers.DIAMOND, 5, -3.25f,
                    new Item.Properties().tab(ModCreativeModTab.TropicModTab).stacksTo(1)));
    public static final RegistryObject<Item> ORICHALCUM_SWORD = ITEMS.register("orichalcum_sword",
            () -> new SwordItem(Tiers.DIAMOND, 7, -3f,
                    new Item.Properties().tab(ModCreativeModTab.TropicModTab).stacksTo(1)));
    public static final RegistryObject<Item> KNUTE = ITEMS.register("knute",
            () -> new SwordItem(Tiers.DIAMOND, 2, -2f,
                    new Item.Properties().tab(ModCreativeModTab.TropicModTab).stacksTo(1)));

    //books

    public static final RegistryObject<Item> MAGIC_BOOK = ITEMS.register("magic_book",
            () -> new BowItem(new Item.Properties().tab(ModCreativeModTab.TropicModTab).durability(100)));

    public static final RegistryObject<Item> MAGIC_FIREBALL_BOOK = ITEMS.register("magic_fireball_book",
            () -> new FireBallBook(new Item.Properties().tab(ModCreativeModTab.TropicModTab).durability(50)));




    //seeds and plodi
    public static final RegistryObject<Item> STAR_SEEDS = ITEMS.register("star_seeds",
            () -> new ItemNameBlockItem(Modbloks.STAR_CROP_BLOCK.get(),
                    new Item.Properties().tab(ModCreativeModTab.TropicModTab)));

    //mana star
    public static final RegistryObject<Item> MANA_STAR = ITEMS.register("mana_star",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TropicModTab)));


    //linz
    public static final RegistryObject<Item> LINZ = ITEMS.register("linz",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TropicModTab)));

    //spawn egg
    public static final RegistryObject<Item> EYE_SPAWN_EGG = ITEMS.register("eye_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.EYE, 919090, 871616 ,
                    new Item.Properties().tab(ModCreativeModTab.TropicModTab)));

    //sign
    public static final RegistryObject<Item> PALM_SIGN = ITEMS.register("palm_sign",
            () -> new SignItem(new Item.Properties().tab(ModCreativeModTab.TropicModTab).stacksTo(16),
                    Modbloks.PALM_SIGN.get(), Modbloks.PALM_WALL_SIGN.get()));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

