package fr.terranova.flv92.dinosaurus.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelHadrosaur extends ModelBase
{
  ModelRenderer head;
  ModelRenderer body;
  ModelRenderer leg1;
  ModelRenderer leg2;
  ModelRenderer leg3;
  ModelRenderer leg4;
  ModelRenderer leg45;
  ModelRenderer leg35;
  ModelRenderer leg15;
  ModelRenderer leg25;
  ModelRenderer tail2;
  ModelRenderer tail1;
  ModelRenderer neck;
  ModelRenderer Shape1;

  public ModelHadrosaur()
  {
    this.textureWidth = 128;
    this.textureHeight = 64;
    this.head = new ModelRenderer(this, 0, 0);
    this.head.addBox(-4.0F, -4.0F, -8.0F, 5, 5, 10);
    this.head.setRotationPoint(1.5F, 12.0F, -11.0F);
    this.head.setTextureOffset(128, 64);
    this.head.mirror = true;
    setRotation(this.head, 0.0872665F, 0.0F, 0.0F);
    this.body = new ModelRenderer(this, 35, 0);
    this.body.addBox(-5.0F, -10.0F, -7.0F, 10, 16, 8);
    this.body.setRotationPoint(0.0F, 11.0F, 3.0F);
    this.body.setTextureOffset(128, 64);
    this.body.mirror = true;
    setRotation(this.body, 1.570796F, 0.0F, 0.0F);
    this.leg1 = new ModelRenderer(this, 0, 17);
    this.leg1.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4);
    this.leg1.setRotationPoint(-4.0F, 14.0F, 7.0F);
    this.leg1.setTextureOffset(128, 64);
    this.leg1.mirror = true;
    setRotation(this.leg1, 0.0F, 0.0F, 0.0F);
    this.leg2 = new ModelRenderer(this, 0, 17);
    this.leg2.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4);
    this.leg2.setRotationPoint(5.0F, 14.0F, 7.0F);
    this.leg2.setTextureOffset(128, 64);
    this.leg2.mirror = true;
    setRotation(this.leg2, 0.0F, 0.0F, 0.0F);
    this.leg3 = new ModelRenderer(this, 0, 29);
    this.leg3.addBox(-2.0F, 0.0F, -2.0F, 4, 5, 4);
    this.leg3.setRotationPoint(-5.0F, 16.0F, -5.0F);
    this.leg3.setTextureOffset(128, 64);
    this.leg3.mirror = true;
    setRotation(this.leg3, 0.0F, 0.0F, 0.0F);
    this.leg4 = new ModelRenderer(this, 0, 29);
    this.leg4.addBox(-2.0F, 0.0F, -2.0F, 4, 5, 4);
    this.leg4.setRotationPoint(5.0F, 16.0F, -5.0F);
    this.leg4.setTextureOffset(128, 64);
    this.leg4.mirror = true;
    setRotation(this.leg4, 0.0F, 0.0F, 0.0F);
    this.leg45 = new ModelRenderer(this, 0, 39);
    this.leg45.addBox(0.0F, 5.0F, 0.0F, 3, 3, 3);
    this.leg45.setRotationPoint(3.5F, 15.25F, -4.25F);
    this.leg45.setTextureOffset(128, 64);
    this.leg45.mirror = true;
    setRotation(this.leg45, -0.349066F, 0.0F, 0.0F);
    this.leg35 = new ModelRenderer(this, 0, 39);
    this.leg35.addBox(-3.0F, 5.0F, 0.0F, 3, 3, 3);
    this.leg35.setRotationPoint(-3.5F, 15.3F, -4.25F);
    this.leg35.setTextureOffset(128, 64);
    this.leg35.mirror = true;
    setRotation(this.leg35, -0.349066F, 0.0F, 0.0F);
    this.leg15 = new ModelRenderer(this, 0, 39);
    this.leg15.addBox(0.0F, 5.0F, 0.0F, 3, 4, 3);
    this.leg15.setRotationPoint(-5.5F, 15.0F, 5.75F);
    this.leg15.setTextureOffset(128, 64);
    this.leg15.mirror = true;
    setRotation(this.leg15, 0.0F, 0.0F, 0.0F);
    this.leg25 = new ModelRenderer(this, 0, 39);
    this.leg25.addBox(0.0F, 5.0F, 0.0F, 3, 4, 3);
    this.leg25.setRotationPoint(3.5F, 15.0F, 5.75F);
    this.leg25.setTextureOffset(128, 64);
    this.leg25.mirror = true;
    setRotation(this.leg25, 0.0F, 0.0F, 0.0F);
    this.tail2 = new ModelRenderer(this, 52, 25);
    this.tail2.addBox(0.0F, 0.0F, 0.0F, 4, 4, 6);
    this.tail2.setRotationPoint(-2.0F, 12.0F, 17.0F);
    this.tail2.setTextureOffset(128, 64);
    this.tail2.mirror = true;
    setRotation(this.tail2, -0.0872665F, 0.0F, 0.0F);
    this.tail1 = new ModelRenderer(this, 23, 37);
    this.tail1.addBox(0.0F, 0.0F, 0.0F, 5, 5, 9);
    this.tail1.setRotationPoint(-2.5F, 10.0F, 9.0F);
    this.tail1.setTextureOffset(128, 64);
    this.tail1.mirror = true;
    setRotation(this.tail1, -0.1570796F, 0.0F, 0.0F);
    this.neck = new ModelRenderer(this, 72, 0);
    this.neck.addBox(0.0F, 0.0F, 0.0F, 4, 4, 8);
    this.neck.setRotationPoint(-2.0F, 9.0F, -10.0F);
    this.neck.setTextureOffset(128, 64);
    this.neck.mirror = true;
    setRotation(this.neck, -0.7853982F, 0.0F, 0.0F);
    this.Shape1 = new ModelRenderer(this, 73, 13);
    this.Shape1.addBox(0.0F, 0.0F, 0.0F, 3, 1, 15);
    this.Shape1.setRotationPoint(-1.5F, 8.5F, -19.0F);
    this.Shape1.setTextureOffset(128, 64);
    this.Shape1.mirror = true;
    setRotation(this.Shape1, 0.1745329F, 0.0F, 0.0F);
  }

  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.head.render(f5);
    this.body.render(f5);
    this.leg1.render(f5);
    this.leg2.render(f5);
    this.leg3.render(f5);
    this.leg4.render(f5);
    this.leg45.render(f5);
    this.leg35.render(f5);
    this.leg15.render(f5);
    this.leg25.render(f5);
    this.tail2.render(f5);
    this.tail1.render(f5);
    this.neck.render(f5);
    this.Shape1.render(f5);
  }

  private void setRotation(ModelRenderer modelrenderer, float f, float f1, float f2)
  {
    modelrenderer.rotateAngleX = f;
    modelrenderer.rotateAngleY = f1;
    modelrenderer.rotateAngleZ = f2;
  }

  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.leg1.rotateAngleX = (MathHelper.cos(f * 0.6662F) * 1.4F * f1);
    this.leg2.rotateAngleX = (MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1);
    this.leg3.rotateAngleX = (MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1);
    this.leg4.rotateAngleX = (MathHelper.cos(f * 0.6662F) * 1.4F * f1);
    this.leg15.rotateAngleX = (MathHelper.cos(f * 0.6662F) * 1.4F * f1);
    this.leg25.rotateAngleX = (MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1);
    this.leg35.rotateAngleX = (MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1 + -0.349066F);
    this.leg45.rotateAngleX = (MathHelper.cos(f * 0.6662F) * 1.4F * f1 + -0.349066F);
  }
}