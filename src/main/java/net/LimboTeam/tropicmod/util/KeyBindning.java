package net.LimboTeam.tropicmod.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBindning {

    public static final String KEY_CATEGORY_TROPICMOD = "key.category.tropicmod.tropicmod";
    public static final String KEY_INCREASE_MANA = "key.tropicmod.increase_mana";
    public static final String KEY_INCREASE_HEALTH = "key.tropicmod.increase_health";

    public static final KeyMapping USE_KEY = new KeyMapping(KEY_INCREASE_MANA, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_J, KEY_CATEGORY_TROPICMOD);

}
