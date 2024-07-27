package net.LimboTeam.tropicmod.util;

import net.LimboTeam.tropicmod.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModItemProperties {
    public static void addCustomItemProperties(){
        makeBow(ModItems.MAGIC_BOOK.get());
        makeBow(ModItems.MAGIC_FIREBALL_BOOK.get());
    }

    private static void makeBow(Item item) {
        ItemProperties.register(item, new ResourceLocation("pull"), (stack, level, entity, i) -> {
            if (entity == null) {
                return entity.getUseItem() != stack ? 0.0F : (float)(stack.getUseDuration() -
                        entity.getUseItemRemainingTicks()) / 20.0F;
            } else {
                return entity.getUseItem() != stack ? 0.0F : (float)(stack.getUseDuration() -
                        entity.getUseItemRemainingTicks()) / 20.0F;
            }
        });

        ItemProperties.register(item, new ResourceLocation("pulling"), (stack, level, entity, i) -> {
            return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F;
        });
    }
}
