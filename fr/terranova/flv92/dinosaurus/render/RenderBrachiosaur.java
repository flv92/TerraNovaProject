package fr.terranova.flv92.dinosaurus.render;

import fr.terranova.flv92.dinosaurus.model.ModelBrachiosaur;
import fr.terranova.flv92.dinosaurus.entity.EntityBrachiosaur;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import org.lwjgl.opengl.GL11;

public class RenderBrachiosaur extends RenderLiving {

    public RenderBrachiosaur(float var1) {
        super(new ModelBrachiosaur(), var1);
    }

    private float func_77034_a(float var1, float var2, float var3) {
        float var4;
        for (var4 = var2 - var1; var4 < -180.0F; var4 += 360.0F);
        while (var4 >= 180.0F)
        {
            var4 -= 360.0F;
        }

        return var1 + var3 * var4;
    }

    public void renderNew(EntityBrachiosaur var1, double var2, double var4, double var6, float var8, float var9) {
        GL11.glPushMatrix();
        GL11.glDisable(2884);
        this.mainModel.onGround = renderSwingProgress(var1, var9);

        if (this.renderPassModel != null)
        {
            this.renderPassModel.onGround = this.mainModel.onGround;
        }

        this.mainModel.isRiding = var1.isRiding();

        if (this.renderPassModel != null)
        {
            this.renderPassModel.isRiding = this.mainModel.isRiding;
        }

        try
        {
            float var10 = func_77034_a(var1.prevRenderYawOffset, var1.renderYawOffset, var9);
            float var11 = func_77034_a(var1.prevRotationYawHead, var1.rotationYawHead, var9);
            float var12 = var1.prevRotationPitch + (var1.rotationPitch - var1.prevRotationPitch) * var9;
            renderLivingAt(var1, var2, var4, var6);
            float var13 = handleRotationFloat(var1, var9);
            rotateCorpse(var1, var13, var10, var9);
            float var14 = 0.0625F;
            GL11.glEnable(32826);
            GL11.glScalef(5.0F, -5.0F, 5.0F);
            preRenderCallback(var1, var9);
            GL11.glTranslatef(0.0F, -24.0F * var14 - 0.007813F, 0.0F);
            float var15 = var1.prevLegYaw + (var1.legYaw - var1.prevLegYaw) * var9;
            float var16 = var1.legSwing - var1.legYaw * (1.0F - var9);

            if (var1.isChild())
            {
                var16 *= 3.0F;
            }

            if (var15 > 1.0F)
            {
                var15 = 1.0F;
            }

            GL11.glEnable(3008);
            this.mainModel.setLivingAnimations(var1, var16, var15, var9);
            renderModel(var1, var16, var15, var13, var11 - var10, var12, var14);

            for (int var21 = 0; var21 < 4; var21++)
            {
                int var18 = shouldRenderPass(var1, var21, var9);

                if (var18 <= 0)
                {
                    continue;
                }
                this.renderPassModel.setLivingAnimations(var1, var16, var15, var9);
                this.renderPassModel.render(var1, var16, var15, var13, var11 - var10, var12, var14);

                if (var18 == 15)
                {
                    float var17 = var1.ticksExisted + var9;
                    loadTexture("%blur%/misc/glint.png");
                    GL11.glEnable(3042);
                    float var19 = 0.5F;
                    GL11.glColor4f(var19, var19, var19, 1.0F);
                    GL11.glDepthFunc(514);
                    GL11.glDepthMask(false);

                    for (int var22 = 0; var22 < 2; var22++)
                    {
                        GL11.glDisable(2896);
                        float var20 = 0.76F;
                        GL11.glColor4f(0.5F * var20, 0.25F * var20, 0.8F * var20, 1.0F);
                        GL11.glBlendFunc(768, 1);
                        GL11.glMatrixMode(5890);
                        GL11.glLoadIdentity();
                        float var23 = var17 * (0.001F + var22 * 0.003F) * 20.0F;
                        float var24 = 0.3333333F;
                        GL11.glScalef(var24, var24, var24);
                        GL11.glRotatef(30.0F - var22 * 60.0F, 0.0F, 0.0F, 1.0F);
                        GL11.glTranslatef(0.0F, var23, 0.0F);
                        GL11.glMatrixMode(5888);
                        this.renderPassModel.render(var1, var16, var15, var13, var11 - var10, var12, var14);
                    }

                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                    GL11.glMatrixMode(5890);
                    GL11.glDepthMask(true);
                    GL11.glLoadIdentity();
                    GL11.glMatrixMode(5888);
                    GL11.glEnable(2896);
                    GL11.glDisable(3042);
                    GL11.glDepthFunc(515);
                }

                GL11.glDisable(3042);
                GL11.glEnable(3008);
            }

            renderEquippedItems(var1, var9);
            float var28 = var1.getBrightness(var9);
            int var18 = getColorMultiplier(var1, var28, var9);
            OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
            GL11.glDisable(3553);
            OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);

            if (((var18 >> 24 & 0xFF) > 0) || (var1.hurtTime > 0) || (var1.deathTime > 0))
            {
                GL11.glDisable(3553);
                GL11.glDisable(3008);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                GL11.glDepthFunc(514);

                if ((var1.hurtTime > 0) || (var1.deathTime > 0))
                {
                    GL11.glColor4f(var28, 0.0F, 0.0F, 0.4F);
                    this.mainModel.render(var1, var16, var15, var13, var11 - var10, var12, var14);

                    for (int var22 = 0; var22 < 4; var22++)
                    {
                        if (inheritRenderPass(var1, var22, var9) < 0)
                        {
                            continue;
                        }
                        GL11.glColor4f(var28, 0.0F, 0.0F, 0.4F);
                        this.renderPassModel.render(var1, var16, var15, var13, var11 - var10, var12, var14);
                    }

                }

                if ((var18 >> 24 & 0xFF) > 0)
                {
                    float var17 = (var18 >> 16 & 0xFF) / 255.0F;
                    float var19 = (var18 >> 8 & 0xFF) / 255.0F;
                    float var27 = (var18 & 0xFF) / 255.0F;
                    float var20 = (var18 >> 24 & 0xFF) / 255.0F;
                    GL11.glColor4f(var17, var19, var27, var20);
                    this.mainModel.render(var1, var16, var15, var13, var11 - var10, var12, var14);

                    for (int var26 = 0; var26 < 4; var26++)
                    {
                        if (inheritRenderPass(var1, var26, var9) < 0)
                        {
                            continue;
                        }
                        GL11.glColor4f(var17, var19, var27, var20);
                        this.renderPassModel.render(var1, var16, var15, var13, var11 - var10, var12, var14);
                    }

                }

                GL11.glDepthFunc(515);
                GL11.glDisable(3042);
                GL11.glEnable(3008);
                GL11.glEnable(3553);
            }

            GL11.glDisable(32826);
        } catch (Exception var25)
        {
            var25.printStackTrace();
        }

        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glEnable(3553);
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GL11.glEnable(2884);
        GL11.glPopMatrix();
        passSpecialRender(var1, var2, var4, var6);
    }

    public void doRenderLiving(EntityLiving var1, double var2, double var4, double var6, float var8, float var9) {
        renderNew((EntityBrachiosaur) var1, var2, var4, var6, var8, var9);
    }

    public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
        renderNew((EntityBrachiosaur) var1, var2, var4, var6, var8, var9);
    }
}