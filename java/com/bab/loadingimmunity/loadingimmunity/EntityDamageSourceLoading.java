package com.bab.loadingimmunity.loadingimmunity;

import net.minecraft.entity.Entity;
import net.minecraft.util.EntityDamageSource;

/**
 * Dummy damage source for invulnerability testing.
 */
public class EntityDamageSourceLoading extends EntityDamageSource {
    public EntityDamageSourceLoading(String damageTypeIn, Entity damageSourceEntityIn) {
        super(damageTypeIn, damageSourceEntityIn);
    }
}
