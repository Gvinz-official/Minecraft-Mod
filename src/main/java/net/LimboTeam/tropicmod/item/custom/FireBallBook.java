package net.LimboTeam.tropicmod.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;


public class FireBallBook extends Item {

    public FireBallBook(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack item = player.getItemInHand(hand);
        Vec3 look = player.getLookAngle();
        LargeFireball largeFireball = new LargeFireball(level, player, 1D, 1D, 1D, 3);
        largeFireball.setPos(player.getX() + look.x * 1.5D,player.getY() + look.y * 1.5D,
                player.getZ() + look.z * 1.5D );
        largeFireball.xPower = look.x * 2.0D;
        largeFireball.yPower = look.y * 2.0D;
        largeFireball.zPower = look.z * 2.0D;
        largeFireball.setGlowingTag(true);
        player.getCooldowns().addCooldown(this, 40);
        level.addFreshEntity(largeFireball);
        return new InteractionResultHolder<ItemStack>(InteractionResult.SUCCESS, item);
    }
}
