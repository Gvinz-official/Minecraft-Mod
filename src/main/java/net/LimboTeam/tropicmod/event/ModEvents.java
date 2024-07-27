package net.LimboTeam.tropicmod.event;

import net.LimboTeam.tropicmod.TropicAdventureMod;
import net.LimboTeam.tropicmod.entity.ModEntityTypes;
import net.LimboTeam.tropicmod.entity.custom.EyeEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = TropicAdventureMod.MOD_ID)
    public class ForgeEvents{

    }

    @Mod.EventBusSubscriber(modid = TropicAdventureMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public class ModEventBusEvents{
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event){
            event.put(ModEntityTypes.EYE.get(), EyeEntity.setAttributes());
        }
    }
}
