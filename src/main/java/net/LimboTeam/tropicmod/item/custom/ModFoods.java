package net.LimboTeam.tropicmod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties HEART = (new FoodProperties.Builder()).fast().nutrition(1).saturationMod(0.1F)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 1200, 15), 1.0F).alwaysEat().build();
    public static final FoodProperties STAR = (new FoodProperties.Builder()).fast().nutrition(1).saturationMod(0.1F)
            .effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 15), 1.0F)
            .effect(new MobEffectInstance(MobEffects.GLOWING, 300, 15), 1.0F).alwaysEat().build();
    public static final FoodProperties BANANA = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.8F)
            .alwaysEat().build();
}
