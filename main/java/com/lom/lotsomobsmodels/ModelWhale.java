// Date: 22.04.2013 15:30:12
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package com.lom.lotsomobsmodels;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
@SideOnly(Side.CLIENT)
public class ModelWhale extends ModelBase
{
  //fields
    ModelRenderer body;
    ModelRenderer abdomen;
    ModelRenderer tail;
    ModelRenderer mouth;
    ModelRenderer fin1;
    ModelRenderer fin2;
  
  public ModelWhale()
  {
    textureWidth = 512;
    textureHeight = 256;
    
      body = new ModelRenderer(this, 0, 0);
      body.addBox(0F, 0F, 0F, 20, 16, 37);
      body.setRotationPoint(-10F, 0F, -17F);
      body.setTextureSize(512, 256);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      abdomen = new ModelRenderer(this, 0, 100);
      abdomen.addBox(0F, 0F, 0F, 16, 14, 20);
      abdomen.setRotationPoint(-8F, 2F, 20F);
      abdomen.setTextureSize(512, 256);
      abdomen.mirror = true;
      setRotation(abdomen, 0F, 0F, 0F);
      tail = new ModelRenderer(this, 200, 0);
      tail.addBox(-6F, 0F, 0F, 12, 4, 9);
      tail.setRotationPoint(0F, 8F, 40F);
      tail.setTextureSize(512, 256);
      tail.mirror = true;
      setRotation(tail, 0F, 0F, 0F);
      mouth = new ModelRenderer(this, 115, 0);
      mouth.addBox(0F, 0F, 0F, 16, 3, 28);
      mouth.setRotationPoint(-8F, 16F, -15F);
      mouth.setTextureSize(512, 256);
      mouth.mirror = true;
      setRotation(mouth, 0F, 0F, 0F);
      fin1 = new ModelRenderer(this, 0, 65);
      fin1.addBox(0F, 0F, -4F, 12, 2, 8);
      fin1.setRotationPoint(10F, 8F, -3F);
      fin1.setTextureSize(512, 256);
      fin1.mirror = true;
      setRotation(fin1, 0F, 0F, 0.8179294F);
      fin2 = new ModelRenderer(this, 0, 65);
      fin2.addBox(-11F, 0F, -4F, 12, 2, 8);
      fin2.setRotationPoint(-10F, 9F, -3F);
      fin2.setTextureSize(512, 256);
      fin2.mirror = true;
      setRotation(fin2, 0F, 0F, -0.8179311F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    body.render(f5);
    abdomen.render(f5);
    tail.render(f5);
    mouth.render(f5);
    fin1.render(f5);
    fin2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
  }

}
