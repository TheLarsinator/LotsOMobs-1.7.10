// Date: 10.10.2012 18:21:37
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package com.lom.lotsomobsmodels;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;


@SideOnly(Side.CLIENT)
public class ModelBear extends ModelBase
{
  //fields
    ModelRenderer MainBody;
    ModelRenderer Vet;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer Head;
    ModelRenderer Jaw;
    ModelRenderer Nose;
    ModelRenderer Ear1;
    ModelRenderer Ear2;
    ModelRenderer Tail;
  
  public ModelBear()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      MainBody = new ModelRenderer(this, 0, 0);
      MainBody.addBox(0F, 0F, 0F, 18, 12, 23);
      MainBody.setRotationPoint(-9F, 3F, -2F);
      MainBody.setTextureSize(128, 128);
      MainBody.mirror = true;
      setRotation(MainBody, 0F, 0F, 0F);
      Vet = new ModelRenderer(this, 0, 38);
      Vet.addBox(0F, 0F, 0F, 20, 14, 12);
      Vet.setRotationPoint(-10F, 2F, 3F);
      Vet.setTextureSize(128, 128);
      Vet.mirror = true;
      setRotation(Vet, 0F, 0F, 0F);
      Leg1 = new ModelRenderer(this, 0, 0);
      Leg1.addBox(-2F, 0F, -2F, 4, 9, 4);
      Leg1.setRotationPoint(6F, 15F, 1F);
      Leg1.setTextureSize(128, 128);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, 0F);
      Leg2 = new ModelRenderer(this, 0, 0);
      Leg2.addBox(-2F, 0F, -2F, 4, 9, 4);
      Leg2.setRotationPoint(-6F, 15F, 1F);
      Leg2.setTextureSize(128, 128);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, 0F);
      Leg3 = new ModelRenderer(this, 0, 0);
      Leg3.addBox(-2F, 0F, -2F, 4, 9, 4);
      Leg3.setRotationPoint(6F, 15F, 18F);
      Leg3.setTextureSize(128, 128);
      Leg3.mirror = true;
      setRotation(Leg3, 0F, 0F, 0F);
      Leg4 = new ModelRenderer(this, 0, 0);
      Leg4.addBox(-2F, 0F, -2F, 4, 9, 4);
      Leg4.setRotationPoint(-6F, 15F, 18F);
      Leg4.setTextureSize(128, 128);
      Leg4.mirror = true;
      setRotation(Leg4, 0F, 0F, 0F);
      Head = new ModelRenderer(this, 0, 70);
      Head.addBox(0F, 0F, 0F, 9, 6, 5);
      Head.setRotationPoint(-5F, 4F, -7F);
      Head.setTextureSize(128, 128);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      Jaw = new ModelRenderer(this, 61, 0);
      Jaw.addBox(0F, 0F, 0F, 5, 1, 4);
      Jaw.setRotationPoint(-3F, 9F, -11F);
      Jaw.setTextureSize(128, 128);
      Jaw.mirror = true;
      setRotation(Jaw, 0F, 0F, 0F);
      Nose = new ModelRenderer(this, 61, 8);
      Nose.addBox(0F, 0F, 0F, 5, 2, 4);
      Nose.setRotationPoint(-3F, 6F, -11F);
      Nose.setTextureSize(128, 128);
      Nose.mirror = true;
      setRotation(Nose, 0F, 0F, 0F);
      Ear1 = new ModelRenderer(this, 100, 0);
      Ear1.addBox(0F, 0F, 0F, 2, 2, 1);
      Ear1.setRotationPoint(1F, 2F, -5F);
      Ear1.setTextureSize(128, 128);
      Ear1.mirror = true;
      setRotation(Ear1, 0F, 0F, 0F);
      Ear2 = new ModelRenderer(this, 100, 0);
      Ear2.addBox(0F, 0F, 0F, 2, 2, 1);
      Ear2.setRotationPoint(-4F, 2F, -5F);
      Ear2.setTextureSize(128, 128);
      Ear2.mirror = true;
      setRotation(Ear2, 0F, 0F, 0F);
      Tail = new ModelRenderer(this, 89, 0);
      Tail.addBox(-1F, 0F, 0F, 3, 2, 2);
      Tail.setRotationPoint(-1F, 5F, 21F);
      Tail.setTextureSize(128, 128);
      Tail.mirror = true;
      setRotation(Tail, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    if (this.isChild)
    {
        float var8 = 2.0F;
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, 5.0F * f5, 2.0F * f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glScalef(1.0F / var8, 1.0F / var8, 1.0F / var8);
        GL11.glTranslatef(0.0F, 24.0F * f5, 0.0F);
        MainBody.render(f5);
        Vet.render(f5);
        Leg1.render(f5);
        Leg2.render(f5);
        Leg3.render(f5);
        Leg4.render(f5);
        Head.render(f5);
        Jaw.render(f5);
        Nose.render(f5);
        Ear1.render(f5);
        Ear2.render(f5);
        Tail.render(f5);
        GL11.glPopMatrix();
        
    }
    else
    {
    
        MainBody.render(f5);
        Vet.render(f5);
        Leg1.render(f5);
        Leg2.render(f5);
        Leg3.render(f5);
        Leg4.render(f5);
        Head.render(f5);
        Jaw.render(f5);
        Nose.render(f5);
        Ear1.render(f5);
        Ear2.render(f5);
        Tail.render(f5);
    }
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
    Leg1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    Leg2.rotateAngleX = MathHelper.cos(f * 0.6662F ) * 1.4F * f1;
    Leg3.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    Leg4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    
  }

}
