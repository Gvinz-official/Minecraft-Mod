package net.LimboTeam.tropicmod.entity;


import net.LimboTeam.tropicmod.TropicAdventureMod;
import net.LimboTeam.tropicmod.entity.custom.EyeEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TropicAdventureMod.MOD_ID);

    public static final RegistryObject<EntityType<EyeEntity>> EYE =
            ENTITY_TYPES.register("eye",
                    () -> EntityType.Builder.of(EyeEntity :: new, MobCategory.MONSTER)
                            .sized(0.8f, 0.8f)
                            .build(new ResourceLocation(TropicAdventureMod.MOD_ID, "eye").toString()));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
