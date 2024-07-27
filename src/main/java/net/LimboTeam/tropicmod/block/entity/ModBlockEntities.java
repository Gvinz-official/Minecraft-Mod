package net.LimboTeam.tropicmod.block.entity;

import net.LimboTeam.tropicmod.TropicAdventureMod;
import net.LimboTeam.tropicmod.block.Modbloks;
import net.LimboTeam.tropicmod.block.entity.custom.ModSignBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TropicAdventureMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> SIGN_BLOCK_ENTITIES =
            BLOCK_ENTITIES.register("sign_block_entity", ()->
                    BlockEntityType.Builder.of(ModSignBlockEntity::new,
                            Modbloks.PALM_WALL_SIGN.get(),
                            Modbloks.PALM_SIGN.get()).build(null));


    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
