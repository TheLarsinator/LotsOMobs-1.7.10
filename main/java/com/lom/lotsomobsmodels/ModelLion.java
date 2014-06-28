package com.lom.lotsomobsmodels;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
@SideOnly(Side.CLIENT)
public class ModelLion extends ModelLOMBase
{
  //fields
    ModelRenderer Main;
    ModelRenderer Tail;
    ModelRenderer Nose2;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer horn1;
    ModelRenderer horn2;
    ModelRenderer Shape1;
  
  public ModelLion()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      Main = new ModelRenderer(this, 83, 0);
      Main.addBox(0F, 0F, 0F, 12, 12, 5);
      Main.setRotationPoint(-6F, -2F, -10F);
      Main.setTextureSize(64, 32);
      Main.mirror = true;
      setRotation(Main, 0F, 0F, 0F);
      Tail = new ModelRenderer(this, 0, 35);
      Tail.addBox(0F, 0F, 0F, 2, 10, 1);
      Tail.setRotationPoint(-1F, 7F, 9F);
      Tail.setTextureSize(64, 32);
      Tail.mirror = true;
      setRotation(Tail, 0.8179294F, 0F, 0F);
      Nose2 = new ModelRenderer(this, 62, 0);
      Nose2.addBox(0F, 0F, 0F, 4, 3, 3);
      Nose2.setRotationPoint(-2F, 3F, -16F);
      Nose2.setTextureSize(64, 32);
      Nose2.mirror = true;
      setRotation(Nose2, 0F, 0F, 0F);
      head = new ModelRenderer(this, 0, 49);
      head.addBox(-4F, -4F, -6F, 10, 8, 3);
      head.setRotationPoint(-1F, 4F, -7F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 86, 72);
      body.addBox(-6F, -10F, -7F, 8, 12, 9);
      body.setRotationPoint(2F, 6F, 8.1F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 1.570796F, 0F, 0F);
      leg1 = new ModelRenderer(this, 0, 16);
      leg1.addBox(-3F, 0F, -2F, 3, 12, 4);
      leg1.setRotationPoint(-2F, 10F, 7F);
      leg1.setTextureSize(64, 32);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      leg2 = new ModelRenderer(this, 0, 16);
      leg2.addBox(-1F, 0F, -2F, 3, 12, 4);
      leg2.setRotationPoint(3F, 10F, 7F);
      leg2.setTextureSize(64, 32);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
      leg3 = new ModelRenderer(this, 58, 16);
      leg3.addBox(-3F, 0F, -3F, 2, 9, 3);
      leg3.setRotationPoint(-3F, 13F, -5F);
      leg3.setTextureSize(64, 32);
      leg3.mirror = true;
      setRotation(leg3, 0F, 0F, 0F);
      leg4 = new ModelRenderer(this, 58, 16);
      leg4.addBox(-1F, 0F, -3F, 2, 9, 3);
      leg4.setRotationPoint(5F, 13F, -5F);
      leg4.setTextureSize(64, 32);
      leg4.mirror = true;
      setRotation(leg4, 0F, 0F, 0F);
      horn1 = new ModelRenderer(this, 2, 0);
      horn1.addBox(-4F, -5F, -4F, 2, 2, 1);
      horn1.setRotationPoint(-2F, 4F, -7.5F);
      horn1.setTextureSize(64, 32);
      horn1.mirror = true;
      setRotation(horn1, 0F, 0F, 0F);
      horn2 = new ModelRenderer(this, 11, 0);
      horn2.addBox(3F, -5F, -4F, 2, 2, 1);
      horn2.setRotationPoint(1F, 4F, -7.5F);
      horn2.setTextureSize(64, 32);
      horn2.mirror = true;
      setRotation(horn2, 0F, 0F, 0F);
      Shape1 = new ModelRenderer(this, 75, 100);
      Shape1.addBox(0F, 0F, 0F, 12, 11, 12);
      Shape1.setRotationPoint(-6F, 3F, -8F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      
      this.addChildTo(horn2, head);
      this.addChildTo(horn1, head);
      this.addChildTo(Nose2, head);
      this.addChildTo(Main, head);
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
        //Main.render(f5);
        Tail.render(f5);
        //Nose2.render(f5);
        head.render(f5);
        body.render(f5);
        leg1.render(f5);
        leg2.render(f5);
        leg3.render(f5);
        leg4.render(f5);
        //horn1.render(f5);
        //horn2.render(f5);
        Shape1.render(f5);
        GL11.glPopMatrix();
    }
    else
    {
    //Main.render(f5);
    Tail.render(f5);
    //Nose2.render(f5);
    head.render(f5);
    body.render(f5);
    leg1.render(f5);
    leg2.render(f5);
    leg3.render(f5);
    leg4.render(f5);
    //horn1.render(f5);
    //horn2.render(f5);
    Shape1.render(f5);
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
    this.head.rotateAngleX = f4 / (180F / (float)Math.PI);
    this.head.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.body.rotateAngleX = ((float)Math.PI / 2F);
    this.leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.leg3.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.leg4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
  }

}
