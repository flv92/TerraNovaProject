package fr.terranova.flv92.dinosaurus.render;

import fr.terranova.flv92.dinosaurus.entity.EntityHadrosaur;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderHadrosaur extends RenderLiving
{
  public RenderHadrosaur(ModelBase par1ModelBase, float par2)
  {
    super(par1ModelBase, par2);
  }

  public void renderHadrosaur(EntityHadrosaur par1EntityHadrosaur, double par2, double par4, double par6, float par8, float par9)
  {
    super.doRenderLiving(par1EntityHadrosaur, par2, par4, par6, par8, par9);
  }

  public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
  {
    renderHadrosaur((EntityHadrosaur)par1EntityLiving, par2, par4, par6, par8, par9);
  }

  public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
  {
    renderHadrosaur((EntityHadrosaur)par1Entity, par2, par4, par6, par8, par9);
  }

  protected void scaleAmmonite(EntityHadrosaur entityammonite, float f)
  {
    float f1 = 4.25F;
    GL11.glScalef(f1, f1, f1);
  }

  protected void preRenderCallback(EntityLiving entityliving, float f)
  {
    scaleAmmonite((EntityHadrosaur)entityliving, f);
  }
}