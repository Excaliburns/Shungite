package moe.krp.shungite.items.crystal.effects;

import net.minecraft.ChatFormatting;
import net.minecraft.world.effect.MobEffect;

public class ShungiteEffect {
    private String name;
    private MobEffect mobEffect;
    private int pointValue;
    private int maxLevel;
    private ChatFormatting color;
    private ShungiteEffectType type;

    public enum ShungiteEffectType {
        POSITIVE_PLUS, // really good!
        POSITIVE,
        NEGATIVE,
        NEGATIVE_PLUS,
        NEUTRAL
    }

    public ShungiteEffect(
        final String name,
        final MobEffect effect,
        final int pointValue,
        final int maxLevel,
        final ChatFormatting color,
        final ShungiteEffectType type
    ) {
        this.name = name;
        this.mobEffect = effect;
        this.pointValue = pointValue;
        this.maxLevel = maxLevel;
        this.color = color;
        this.type = type;
    }

    public String getDisplayName() {
        return this.mobEffect.getDisplayName().getString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MobEffect getMobEffect() {
        return mobEffect;
    }

    public void setMobEffect(MobEffect mobEffect) {
        this.mobEffect = mobEffect;
    }

    public int getPointValue() {
        return pointValue;
    }

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public ChatFormatting getColor() {
        return color;
    }

    public void setColor(ChatFormatting color) {
        this.color = color;
    }
}
