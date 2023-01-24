package moe.krp.shungite.items.crystal.effects;

import net.minecraft.ChatFormatting;
import net.minecraft.world.effect.MobEffect;

public class CustomShungiteEffect extends ShungiteEffect {
    public String displayName;

    public CustomShungiteEffect(final MobEffect effect, final String name, final int pointValue, final int maxLevel, final ChatFormatting color, final String displayName) {
        super(name, effect, pointValue, maxLevel, color);
        this.displayName = displayName;
    }

    @Override
    public String getDisplayName() {
        return this.displayName;
    }
}
