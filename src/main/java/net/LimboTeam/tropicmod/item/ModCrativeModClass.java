package net.LimboTeam.tropicmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCrativeModClass {
    public static final CreativeModeTab TropicModTab = new CreativeModeTab("tropictab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.LAVA_ORE.get());
        }
    };
}
