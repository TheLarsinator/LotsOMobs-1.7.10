package com.lom.lotsomobsentity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.lom.lotsomobsinit.LotsOMobsItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityGazelle extends EntityTameable {
	private float field_70926_e;
	private float field_70924_f;
	/** true is the Gazelle is wet else false */
	private boolean isShaking;
	private boolean field_70928_h;
	/**
	 * This time increases while Gazelle is shaking and emitting water
	 * particles.
	 */
	private float timeGazelleIsShaking;
	private float prevTimeGazelleIsShaking;

	private static final IAttribute horseJumpStrength = (new RangedAttribute(
			"horse.jumpStrength", 0.7D, 0.0D, 2.0D)).setDescription(
			"Jump Strength").setShouldWatch(true);

	// private static final String __OBFID = "CL_00001654";

	public EntityGazelle(World par1World) {
		super(par1World);
		this.setSize(1.4F, 1.2F);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, this.aiSit);
		this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(5, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
		this.tasks.addTask(6, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(9, new EntityAIWatchClosest(this,
				EntityPlayer.class, 8.0F));
		this.tasks.addTask(9, new EntityAILookIdle(this));
		this.setTamed(false);
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setBaseValue(0.30000001192092896D);

		if (this.isTamed()) {
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
					.setBaseValue(16.0D);
		} else {
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
					.setBaseValue(8.0D);
		}
	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	public boolean isAIEnabled() {
		return true;
	}

	/**
	 * Sets the active target the Task system uses for tracking
	 */
	public void setAttackTarget(EntityLivingBase par1EntityLivingBase) {
		super.setAttackTarget(par1EntityLivingBase);

		if (par1EntityLivingBase == null) {
			this.setAngry(false);
		} else if (!this.isTamed()) {
			this.setAngry(true);
		}
	}

	/**
	 * main AI tick function, replaces updateEntityActionState
	 */
	protected void updateAITick() {
		this.dataWatcher.updateObject(18, Float.valueOf(this.getHealth()));
	}

	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(18, new Float(this.getHealth()));
		this.dataWatcher.addObject(19, new Byte((byte) 0));
		this.dataWatcher.addObject(20,
				new Byte((byte) BlockColored.func_150032_b(1)));
	}

	protected void func_145780_a(int p_145780_1_, int p_145780_2_,
			int p_145780_3_, Block p_145780_4_) {
		this.playSound("", 0.15F, 1.0F);
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
		this.setAngry(par1NBTTagCompound.getBoolean("Angry"));
	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound() {
		return this.isAngry() ? "" : (this.rand.nextInt(3) == 0 ? (this
				.isTamed()
				&& this.dataWatcher.getWatchableObjectFloat(18) < 10.0F ? ""
				: "") : "");
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound() {
		return "";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound() {
		return "";
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	protected float getSoundVolume() {
		return 0.4F;
	}

	protected Item getDropItem() {
		return Item.getItemById(-1);
	}

	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
	public void onLivingUpdate() {
		super.onLivingUpdate();

		if (!this.worldObj.isRemote && this.isShaking && !this.field_70928_h
				&& !this.hasPath() && this.onGround) {
			this.field_70928_h = true;
			this.timeGazelleIsShaking = 0.0F;
			this.prevTimeGazelleIsShaking = 0.0F;
			this.worldObj.setEntityState(this, (byte) 8);
		}

		if (this.riddenByEntity != null) {
			if (this.riddenByEntity instanceof EntityLivingBase) {
				EntityLivingBase entity = (EntityLivingBase) this.riddenByEntity;
				entity.moveForward = 0.2F;
				double cos = Math.cos(this.rotationYaw * Math.PI / 180.0f);
				double sin = Math.sin(this.rotationYaw * Math.PI / 180.0f);
				float speed = 0.2F;
				this.motionX = -sin * speed;
				this.motionZ = cos * speed;
			}
		}
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate() {
		super.onUpdate();

	}

	public void updateRiderPosition() {
		if (this.riddenByEntity != null) {
			double dZ = Math.cos((double) this.rotationYaw * Math.PI / 180.0D)
					* -0.1D;
			double dX = -Math.sin((double) this.rotationYaw * Math.PI / 180.0D)
					* -0.1D;
			this.riddenByEntity.setPosition(
					this.posX + dX,
					this.posY + this.getMountedYOffset()
							+ this.riddenByEntity.getYOffset(), this.posZ + dZ);
		}
	}

	@SideOnly(Side.CLIENT)
	public boolean getGazelleShaking() {
		return this.isShaking;
	}

	/**
	 * Used when calculating the amount of shading to apply while the Gazelle is
	 * shaking.
	 */
	@SideOnly(Side.CLIENT)
	public float getShadingWhileShaking(float par1) {
		return 0.75F + (this.prevTimeGazelleIsShaking + (this.timeGazelleIsShaking - this.prevTimeGazelleIsShaking)
				* par1) / 2.0F * 0.25F;
	}

	@SideOnly(Side.CLIENT)
	public float getShakeAngle(float par1, float par2) {
		float f2 = (this.prevTimeGazelleIsShaking
				+ (this.timeGazelleIsShaking - this.prevTimeGazelleIsShaking)
				* par1 + par2) / 1.8F;

		if (f2 < 0.0F) {
			f2 = 0.0F;
		} else if (f2 > 1.0F) {
			f2 = 1.0F;
		}

		return MathHelper.sin(f2 * (float) Math.PI)
				* MathHelper.sin(f2 * (float) Math.PI * 11.0F) * 0.15F
				* (float) Math.PI;
	}

	public float getEyeHeight() {
		return this.height * 0.8F;
	}

	@SideOnly(Side.CLIENT)
	public float getInterestedAngle(float par1) {
		return (this.field_70924_f + (this.field_70926_e - this.field_70924_f)
				* par1)
				* 0.15F * (float) Math.PI;
	}

	/**
	 * The speed it takes to move the entityliving's rotationPitch through the
	 * faceEntity method. This is only currently use in wolves.
	 */
	public int getVerticalFaceSpeed() {
		return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
	}

	/**
	 * Called when the entity is attacked.
	 */
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
		if (this.isEntityInvulnerable()) {
			return false;
		} else {
			Entity entity = par1DamageSource.getEntity();
			this.aiSit.setSitting(false);

			if (entity != null && !(entity instanceof EntityPlayer)
					&& !(entity instanceof EntityArrow)) {
				par2 = (par2 + 1.0F) / 2.0F;
			}

			return super.attackEntityFrom(par1DamageSource, par2);
		}
	}

	public boolean attackEntityAsMob(Entity par1Entity) {
		int i = this.isTamed() ? 15 : 10;
		return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this),
				(float) i);
	}

	public void setTamed(boolean par1) {
		super.setTamed(par1);

		if (par1) {
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
					.setBaseValue(20.0D);
		} else {
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
					.setBaseValue(8.0D);
		}
	}

	/**
	 * Called when a player interacts with a mob. e.g. gets milk from a cow,
	 * gets into the saddle on a pig.
	 */
	public boolean interact(EntityPlayer p_70085_1_) 
	{
		ItemStack itemstack = p_70085_1_.inventory.getCurrentItem();

		if (!this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == p_70085_1_) && itemstack.getItem() == LotsOMobsItems.Amber) {
			
			p_70085_1_.mountEntity(this);
			return true;
		}
		if (this.isTamed()) {
			if (itemstack != null) {
				if (itemstack.getItem() instanceof ItemFood) {
					ItemFood itemfood = (ItemFood) itemstack.getItem();

					if (itemfood.isWolfsFavoriteMeat()
							&& this.dataWatcher.getWatchableObjectFloat(18) < 20.0F) {
						if (!p_70085_1_.capabilities.isCreativeMode) {
							--itemstack.stackSize;
						}

						this.heal((float) itemfood.func_150905_g(itemstack));

						if (itemstack.stackSize <= 0) {
							p_70085_1_.inventory.setInventorySlotContents(
									p_70085_1_.inventory.currentItem,
									(ItemStack) null);
						}

						return true;
					}
				}
			}

			if (this.func_152114_e(p_70085_1_) && !this.worldObj.isRemote
					&& !this.isBreedingItem(itemstack)) {
				this.aiSit.setSitting(!this.isSitting());
				this.isJumping = false;
				this.setPathToEntity((PathEntity) null);
				this.setTarget((Entity) null);
				this.setAttackTarget((EntityLivingBase) null);
			}
		} else if (itemstack != null && itemstack.getItem() == Items.apple
				&& !this.isAngry()) {
			if (!p_70085_1_.capabilities.isCreativeMode) {
				--itemstack.stackSize;
			}

			if (itemstack.stackSize <= 0) {
				p_70085_1_.inventory.setInventorySlotContents(
						p_70085_1_.inventory.currentItem, (ItemStack) null);
			}

			if (!this.worldObj.isRemote) {
				if (this.rand.nextInt(3) == 0) {
					this.setTamed(true);
					this.setPathToEntity((PathEntity) null);
					this.setAttackTarget((EntityLivingBase) null);
					this.aiSit.setSitting(true);
					this.setHealth(20.0F);
					this.func_152115_b(p_70085_1_.getUniqueID().toString());
					this.playTameEffect(true);
					this.worldObj.setEntityState(this, (byte) 7);
				} else {
					this.playTameEffect(false);
					this.worldObj.setEntityState(this, (byte) 6);
				}
			}

			return true;
		}

		return super.interact(p_70085_1_);
	}

	@SideOnly(Side.CLIENT)
	public void handleHealthUpdate(byte par1) {
		if (par1 == 8) {
			this.field_70928_h = true;
			this.timeGazelleIsShaking = 0.0F;
			this.prevTimeGazelleIsShaking = 0.0F;
		} else {
			super.handleHealthUpdate(par1);
		}
	}

	@SideOnly(Side.CLIENT)
	public float getTailRotation() {
		return this.isAngry() ? 1.5393804F
				: (this.isTamed() ? (0.55F - (20.0F - this.dataWatcher
						.getWatchableObjectFloat(18)) * 0.02F)
						* (float) Math.PI : ((float) Math.PI / 5F));
	}

	/**
	 * Will return how many at most can spawn in a chunk at once.
	 */
	public int getMaxSpawnedInChunk() {
		return 8;
	}

	/**
	 * Determines whether this Gazelle is angry or not.
	 */
	public boolean isAngry() {
		return (this.dataWatcher.getWatchableObjectByte(16) & 2) != 0;
	}

	/**
	 * Sets whether this Gazelle is angry or not.
	 */
	public void setAngry(boolean par1) {
		byte b0 = this.dataWatcher.getWatchableObjectByte(16);

		if (par1) {
			this.dataWatcher.updateObject(16, Byte.valueOf((byte) (b0 | 2)));
		} else {
			this.dataWatcher.updateObject(16, Byte.valueOf((byte) (b0 & -3)));
		}
	}

	/**
	 * Return this Gazelle's collar color.
	 */
	public int getCollarColor() {
		return this.dataWatcher.getWatchableObjectByte(20) & 15;
	}

	/**
	 * Set this Gazelle's collar color.
	 */
	public void setCollarColor(int par1) {
		this.dataWatcher.updateObject(20, Byte.valueOf((byte) (par1 & 15)));
	}

	public EntityGazelle createChild(EntityAgeable p_90011_1_) {
		EntityGazelle entityGazelle = new EntityGazelle(this.worldObj);
		String s = this.func_152113_b();

		if (s != null && s.trim().length() > 0) {
			entityGazelle.func_152115_b(s);
			entityGazelle.setTamed(true);
		}

		return entityGazelle;
	}

	public void func_70918_i(boolean par1) {
		if (par1) {
			this.dataWatcher.updateObject(19, Byte.valueOf((byte) 1));
		} else {
			this.dataWatcher.updateObject(19, Byte.valueOf((byte) 0));
		}
	}

	/**
	 * Returns true if the mob is currently able to mate with the specified mob.
	 */
	public boolean canMateWith(EntityAnimal par1EntityAnimal) {
		if (par1EntityAnimal == this) {
			return false;
		} else if (!this.isTamed()) {
			return false;
		} else if (!(par1EntityAnimal instanceof EntityGazelle)) {
			return false;
		} else {
			EntityGazelle entityGazelle = (EntityGazelle) par1EntityAnimal;
			return !entityGazelle.isTamed() ? false : (entityGazelle
					.isSitting() ? false : this.isInLove()
					&& entityGazelle.isInLove());
		}
	}

	public boolean func_70922_bv() {
		return this.dataWatcher.getWatchableObjectByte(19) == 1;
	}

	/**
	 * Determines if an entity can be despawned, used on idle far away entities
	 */
	protected boolean canDespawn() {
		return false;
	}

	public boolean func_142018_a(EntityLivingBase par1EntityLivingBase,
			EntityLivingBase par2EntityLivingBase) {
		if (!(par1EntityLivingBase instanceof EntityCreeper)
				&& !(par1EntityLivingBase instanceof EntityGhast)) {
			if (par1EntityLivingBase instanceof EntityGazelle) {
				EntityGazelle entityGazelle = (EntityGazelle) par1EntityLivingBase;

				if (entityGazelle.isTamed()
						&& entityGazelle.getOwner() == par2EntityLivingBase) {
					return false;
				}
			}

			return par1EntityLivingBase instanceof EntityPlayer
					&& par2EntityLivingBase instanceof EntityPlayer
					&& !((EntityPlayer) par2EntityLivingBase)
							.canAttackPlayer((EntityPlayer) par1EntityLivingBase) ? false
					: !(par1EntityLivingBase instanceof EntityHorse)
							|| !((EntityHorse) par1EntityLivingBase).isTame();
		} else {
			return false;
		}
	}

	// LETS RIDE THIS THING!
	/**
	 * Dead and sleeping entities cannot move
	 */
	/*
	 * protected boolean isMovementBlocked() { return this.riddenByEntity !=
	 * null; }
	 * 
	 * protected float jumpPower; private boolean field_110294_bI; protected
	 * boolean horseJumping;
	 * 
	 * /** Moves the entity based on the specified heading. Args: strafe,
	 * forward
	 */
	/*
	 * public void moveEntityWithHeading(float par1, float par2) { if
	 * (this.riddenByEntity != null) { this.prevRotationYaw = this.rotationYaw =
	 * this.riddenByEntity.rotationYaw; this.rotationPitch =
	 * this.riddenByEntity.rotationPitch * 0.5F;
	 * this.setRotation(this.rotationYaw, this.rotationPitch);
	 * this.rotationYawHead = this.renderYawOffset = this.rotationYaw; par1 =
	 * ((EntityLivingBase)this.riddenByEntity).moveStrafing * 0.5F; par2 =
	 * ((EntityLivingBase)this.riddenByEntity).moveForward;
	 * 
	 * if (par2 <= 0.0F) { par2 *= 0.25F; }
	 * 
	 * if (this.onGround && this.jumpPower == 0.0F && !this.field_110294_bI) {
	 * par1 = 0.0F; par2 = 0.0F; }
	 * 
	 * if (this.jumpPower > 0.0F && !this.isHorseJumping() && this.onGround) {
	 * this.motionY = this.getHorseJumpStrength() * (double)this.jumpPower;
	 * 
	 * if (this.isPotionActive(Potion.jump)) { this.motionY +=
	 * (double)((float)(this.getActivePotionEffect(Potion.jump).getAmplifier() +
	 * 1) * 0.1F); }
	 * 
	 * this.setHorseJumping(true); this.isAirBorne = true;
	 * 
	 * if (par2 > 0.0F) { float f2 = MathHelper.sin(this.rotationYaw *
	 * (float)Math.PI / 180.0F); float f3 = MathHelper.cos(this.rotationYaw *
	 * (float)Math.PI / 180.0F); this.motionX += (double)(-0.4F * f2 *
	 * this.jumpPower); this.motionZ += (double)(0.4F * f3 * this.jumpPower);
	 * this.playSound("mob.horse.jump", 0.4F, 1.0F); }
	 * 
	 * this.jumpPower = 0.0F;
	 * net.minecraftforge.common.ForgeHooks.onLivingJump(this); }
	 * 
	 * this.stepHeight = 1.0F; this.jumpMovementFactor = this.getAIMoveSpeed() *
	 * 0.1F;
	 * 
	 * if (!this.worldObj.isRemote) {
	 * this.setAIMoveSpeed((float)this.getEntityAttribute
	 * (SharedMonsterAttributes.movementSpeed).getAttributeValue());
	 * super.moveEntityWithHeading(par1, par2); }
	 * 
	 * if (this.onGround) { this.jumpPower = 0.0F; this.setHorseJumping(false);
	 * }
	 * 
	 * this.prevLimbSwingAmount = this.limbSwingAmount; double d1 = this.posX -
	 * this.prevPosX; double d0 = this.posZ - this.prevPosZ; float f4 =
	 * MathHelper.sqrt_double(d1 * d1 + d0 * d0) * 4.0F;
	 * 
	 * if (f4 > 1.0F) { f4 = 1.0F; }
	 * 
	 * this.limbSwingAmount += (f4 - this.limbSwingAmount) * 0.4F;
	 * this.limbSwing += this.limbSwingAmount; } else { this.stepHeight = 0.5F;
	 * this.jumpMovementFactor = 0.02F; super.moveEntityWithHeading(par1, par2);
	 * } }
	 * 
	 * public void setJumpPower(int par1) { if (this.riddenByEntity != null) {
	 * if (par1 < 0) { par1 = 0; } else { this.field_110294_bI = true; }
	 * 
	 * if (par1 >= 90) { this.jumpPower = 1.0F; } else { this.jumpPower = 0.4F +
	 * 0.4F * (float)par1 / 90.0F; } } } public void setHorseJumping(boolean
	 * par1) { this.horseJumping = par1; } public boolean isHorseJumping() {
	 * return this.horseJumping; } public double getHorseJumpStrength() { return
	 * this.getEntityAttribute(horseJumpStrength).getAttributeValue(); }
	 */
}