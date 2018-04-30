package yaossg.mod.mana_craft.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import yaossg.mod.mana_craft.config.Config;
import yaossg.mod.mana_craft.item.ItemManaApple;
import yaossg.mod.mana_craft.item.ManaCraftItems;
import yaossg.mod.mana_craft.util.RandomBuffer;

import java.util.Random;

public class EntityManaBall extends EntityThrowable {
    public static final float defaultVelocity = 0.4f;
    public static final float betterVelocity = 0.5f;
    public static final float defaultInaccuracy = 1;

    public EntityManaBall(World worldIn) {
        super(worldIn);
    }
    public EntityManaBall(World worldIn, EntityLivingBase throwerIn) {
        super(worldIn, throwerIn);
    }
    public EntityManaBall(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    private static final Random random = new Random();
    private static final RandomBuffer rb = new RandomBuffer(random);
    @Override
    protected void onImpact(RayTraceResult result) {
        if(rb.isEmpty())
            rb.allocate(64);
        if(result.entityHit instanceof EntityPig && Config.bombSize > 0 && rb.getBoolean(4)) {
            if (thrower != null)
                ItemManaApple.appleExplosin(thrower, (EntityPig) result.entityHit, world.isRemote);
            if (!world.isRemote) {
                world.setEntityState(this, (byte) 3);
                setDead();
            }
        }
        if (result.entityHit != null)
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), 7);
    }

    public static class Render extends RenderSnowball<EntityManaBall> {
        public Render(RenderManager renderManagerIn) {
            super(renderManagerIn, ManaCraftItems.itemManaBall, Minecraft.getMinecraft().getRenderItem());
        }
    }
}


