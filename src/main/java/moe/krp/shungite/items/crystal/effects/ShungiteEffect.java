package moe.krp.shungite.items.crystal.effects;

import lombok.Getter;
import lombok.Setter;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;

@Getter @Setter
public class ShungiteEffect {
    private String name;
    private MobEffect mobEffect;
    private int pointValue;
    private int maxLevel;
    private ChatFormatting color;

    public ShungiteEffect(
        final String name,
        final MobEffect effect,
        final int pointValue,
        final int maxLevel,
        final ChatFormatting color
    ) {
        this.name = name;
        this.mobEffect = effect;
        this.pointValue = pointValue;
        this.maxLevel = maxLevel;
        this.color = color;
    }

    public String getDisplayName() {
        return this.mobEffect.getDisplayName().getString();
    }
}
