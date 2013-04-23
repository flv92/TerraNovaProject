package fr.terranova.flv92.dinosaurus.render;

import fr.terranova.flv92.dinosaurus.model.ModelStegosaurus;
import fr.terranova.flv92.dinosaurus.entity.EntityStegosaurus;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import org.lwjgl.opengl.GL11;

public class RenderStegosaurus extends RenderLiving
{

    public RenderStegosaurus(ModelBase var1, float var2) {
        super(var1, var2);
        setRenderPassModel(var1);
    }

    public RenderStegosaurus(ModelBase var1, ModelBase var2, float var3) {
        super(var1, var3);
        setRenderPassModel(var2);
    }

    public void renderCow(EntityStegosaurus var1, double var2, double var4, double var6, float var8, float var9) {
        GL11.glPushMatrix();
        GL11.glDisable(2884);
        this.mainModel.onGround = renderSwingProgress(var1, var9);

        if (this.renderPassModel != null) {
            this.renderPassModel.onGround = this.mainModel.onGround;
        }

        this.mainModel.isRiding = var1.isRiding();

        if (this.renderPassModel != null) {
            this.renderPassModel.isRiding = this.mainModel.isRiding;
        }

        try {
            float var10 = var1.prevRenderYawOffset + (var1.renderYawOffset - var1.prevRenderYawOffset) * var9;
            float var11 = var1.prevRotationYaw + (var1.rotationYaw - var1.prevRotationYaw) * var9;
            float var12 = var1.prevRotationPitch + (var1.rotationPitch - var1.prevRotationPitch) * var9;
            renderLivingAt(var1, var2, var4, var6);
            float var13 = handleRotationFloat(var1, var9);
            rotateCorpse(var1, var13, var10, var9);
            float var14 = 0.0625F;
            GL11.glEnable(32826);
            GL11.glScalef(6.0F, -6.0F, 6.0F);
            preRenderCallback(var1, var9);
            GL11.glTranslatef(0.0F, -24.0F * var14 - 0.007813F, 0.0F);
            float var15 = var1.prevLegYaw + (var1.legYaw - var1.prevLegYaw) * var9;
            float var16 = var1.legSwing - var1.legYaw * (1.0F - var9);

            if (var15 > 1.0F) {
                var15 = 1.0F;
            }

            loadDownloadableImageTexture(var1.skinUrl, var1.getTexture());
            GL11.glEnable(3008);
            this.mainModel.setLivingAnimations(var1, var16, var15, var9);
            ((ModelStegosaurus) this.mainModel).render(var1, var16, var15, var13, var11 - var10, var12, var14);


            for (int var17 = 0; var17 < 4; var17++) {
                if (shouldRenderPass(var1, var17, var9) < 0) {
                    continue;
                }
                ((ModelStegosaurus) this.renderPassModel).render(var1, var16, var15, var13, var11 - var10, var12, var14);
                GL11.glDisable(3042);
                GL11.glEnable(3008);
            }

            renderEquippedItems(var1, var9);
            float var25 = var1.getBrightness(var9);
            int var18 = getColorMultiplier(var1, var25, var9);

            if (((var18 >> 24 & 0xFF) > 0) || (var1.hurtTime > 0) || (var1.deathTime > 0)) {
                GL11.glDisable(3553);
                GL11.glDisable(3008);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                GL11.glDepthFunc(514);

                if ((var1.hurtTime > 0) || (var1.deathTime > 0)) {
                    GL11.glColor4f(var25, 0.0F, 0.0F, 0.4F);
                    ((ModelStegosaurus) this.mainModel).render(var1, var16, var15, var13, var11 - var10, var12, var14);


                    for (int var19 = 0; var19 < 4; var19++) {
                        if (inheritRenderPass(var1, var19, var9) < 0) {
                            continue;
                        }
                        GL11.glColor4f(var25, 0.0F, 0.0F, 0.4F);
                        ((ModelStegosaurus) this.renderPassModel).render(var1, var16, var15, var13, var11 - var10, var12, var14);
                    }

                }

                if ((var18 >> 24 & 0xFF) > 0) {
                    float var26 = (var18 >> 16 & 0xFF) / 255.0F;
                    float var20 = (var18 >> 8 & 0xFF) / 255.0F;
                    float var21 = (var18 & 0xFF) / 255.0F;
                    float var22 = (var18 >> 24 & 0xFF) / 255.0F;
                    GL11.glColor4f(var26, var20, var21, var22);


                    ((ModelStegosaurus) this.mainModel).render(var1, var16, var15, var13, var11 - var10, var12, var14);


                    for (int var23 = 0; var23 < 4; var23++) {
                        if (inheritRenderPass(var1, var23, var9) < 0) {
                            continue;
                        }
                        GL11.glColor4f(var26, var20, var21, var22);
                        ((ModelStegosaurus) this.renderPassModel).render(var1, var16, var15, var13, var11 - var10, var12, var14);
                    }

                }

                GL11.glDepthFunc(515);
                GL11.glDisable(3042);
                GL11.glEnable(3008);
                GL11.glEnable(3553);
            }

            GL11.glDisable(32826);
        }
        catch (Exception var24) {
            var24.printStackTrace();
        }

        GL11.glEnable(2884);
        GL11.glPopMatrix();
        passSpecialRender(var1, var2, var4, var6);
    }

    public void doRenderLiving(EntityLiving var1, double var2, double var4, double var6, float var8, float var9) {
        renderCow((EntityStegosaurus) var1, var2, var4, var6, var8, var9);
    }

    public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
        renderCow((EntityStegosaurus) var1, var2, var4, var6, var8, var9);
    }

    protected int shouldRenderPass(EntityLiving var1, int var2, float var3) {
        return -1;
    }
}