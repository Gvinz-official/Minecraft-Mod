package net.LimboTeam.tropicmod.entity.client;

import net.LimboTeam.tropicmod.TropicAdventureMod;
import net.LimboTeam.tropicmod.entity.custom.EyeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class EyeModel extends AnimatedGeoModel<EyeEntity> {
    @Override
    public ResourceLocation getModelResource(EyeEntity eyeEntity) {
        return new ResourceLocation(TropicAdventureMod.MOD_ID, "geo/eye.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EyeEntity eyeEntity) {
        return new ResourceLocation(TropicAdventureMod.MOD_ID, "textures/entity/eye.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EyeEntity eyeEntity) {
        return new ResourceLocation(TropicAdventureMod.MOD_ID, "animations/eye.animation.json");
    }
}
