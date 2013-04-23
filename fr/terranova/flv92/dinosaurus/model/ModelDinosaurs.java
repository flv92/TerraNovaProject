package fr.terranova.flv92.dinosaurus.model;

import net.minecraft.client.model.ModelBase;

public abstract class ModelDinosaurs extends ModelBase
{
  public void a(float f, float f1, float f2, float f3, float f4, float f5)
  {
    setRotationAngles(f, f1, f2, f3, f4, f5, false);
  }

  protected abstract void setRotationAngles(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean);
}