/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  net.minecraft.launchwrapper.IClassTransformer
 *  net.minecraft.nbt.CompressedStreamTools
 *  net.minecraft.nbt.NBTTagCompound
 *  org.objectweb.asm.ClassReader
 *  org.objectweb.asm.ClassVisitor
 *  org.objectweb.asm.ClassWriter
 *  org.objectweb.asm.tree.AbstractInsnNode
 *  org.objectweb.asm.tree.ClassNode
 *  org.objectweb.asm.tree.FieldInsnNode
 *  org.objectweb.asm.tree.InsnList
 *  org.objectweb.asm.tree.InsnNode
 *  org.objectweb.asm.tree.JumpInsnNode
 *  org.objectweb.asm.tree.LabelNode
 *  org.objectweb.asm.tree.LdcInsnNode
 *  org.objectweb.asm.tree.MethodInsnNode
 *  org.objectweb.asm.tree.MethodNode
 *  org.objectweb.asm.tree.TypeInsnNode
 *  org.objectweb.asm.tree.VarInsnNode
 */
package lotr.common.coremod;

import java.io.DataInputStream;
import java.util.Iterator;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TypeInsnNode;
import org.objectweb.asm.tree.VarInsnNode;

import lotr.compatibility.LOTRModChecker;
import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;

public class LOTRClassTransformer
implements IClassTransformer {
    private static final String cls_AABB = "net/minecraft/util/AxisAlignedBB";
    private static final String cls_AABB_obf = "azt";
    private static final String cls_AttributeModifier = "net/minecraft/entity/ai/attributes/AttributeModifier";
    private static final String cls_AttributeModifier_obf = "tj";
    private static final String cls_Block = "net/minecraft/block/Block";
    private static final String cls_Block_obf = "aji";
    private static final String cls_BlockDoor = "net/minecraft/block/BlockDoor";
    private static final String cls_BlockDoor_obf = "akn";
    private static final String cls_BlockPistonBase = "net/minecraft/block/BlockPistonBase";
    private static final String cls_BlockPistonBase_obf = "app";
    private static final String cls_Blocks = "net/minecraft/init/Blocks";
    private static final String cls_Blocks_obf = "ajn";
    private static final String cls_CreativeTabs = "net/minecraft/creativetab/CreativeTabs";
    private static final String cls_CreativeTabs_obf = "abt";
    private static final String cls_DamageSource = "net/minecraft/util/DamageSource";
    private static final String cls_DamageSource_obf = "ro";
    private static final String cls_Entity = "net/minecraft/entity/Entity";
    private static final String cls_Entity_obf = "sa";
    private static final String cls_EntityLivingBase = "net/minecraft/entity/EntityLivingBase";
    private static final String cls_EntityLivingBase_obf = "sv";
    private static final String cls_EntityPlayer = "net/minecraft/entity/player/EntityPlayer";
    private static final String cls_EntityPlayer_obf = "yz";
    private static final String cls_EnumCreatureAttribute = "net/minecraft/entity/EnumCreatureAttribute";
    private static final String cls_EnumCreatureAttribute_obf = "sz";
    private static final String cls_IBlockAccess = "net/minecraft/world/IBlockAccess";
    private static final String cls_IBlockAccess_obf = "ahl";
    private static final String cls_IIcon = "net/minecraft/util/IIcon";
    private static final String cls_IIcon_obf = "rf";
    private static final String cls_Item = "net/minecraft/item/Item";
    private static final String cls_Item_obf = "adb";
    private static final String cls_ItemArmor = "net/minecraft/item/ItemArmor";
    private static final String cls_ItemArmor_obf = "abb";
    private static final String cls_ItemStack = "net/minecraft/item/ItemStack";
    private static final String cls_ItemStack_obf = "add";
    private static final String cls_Packet = "net/minecraft/network/Packet";
    private static final String cls_Packet_obf = "ft";
    private static final String cls_PacketS14 = "net/minecraft/network/play/server/S14PacketEntity";
    private static final String cls_PacketS14_obf = "hf";
    private static final String cls_PacketS18 = "net/minecraft/network/play/server/S18PacketEntityTeleport";
    private static final String cls_PacketS18_obf = "ik";
    private static final String cls_PathPoint = "net/minecraft/pathfinding/PathPoint";
    private static final String cls_PathPoint_obf = "aye";
    private static final String cls_RenderBlocks = "net/minecraft/client/renderer/RenderBlocks";
    private static final String cls_RenderBlocks_obf = "blm";
    private static final String cls_World = "net/minecraft/world/World";
    private static final String cls_World_obf = "ahb";
    private static final String cls_WorldServer = "net/minecraft/world/WorldServer";
    private static final String cls_WorldServer_obf = "mt";

    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if (name.equals("anv") || name.equals("net.minecraft.block.BlockStone")) {
            return this.patchBlockStone(name, basicClass);
        }
        if (name.equals("alh") || name.equals("net.minecraft.block.BlockGrass")) {
            return this.patchBlockGrass(name, basicClass);
        }
        if (name.equals("akl") || name.equals("net.minecraft.block.BlockDirt")) {
            return this.patchBlockDirt(name, basicClass);
        }
        if (name.equals("ant") || name.equals("net.minecraft.block.BlockStaticLiquid")) {
            return this.patchBlockStaticLiquid(name, basicClass);
        }
        if (name.equals("alb") || name.equals("net.minecraft.block.BlockFire")) {
            return this.patchBlockFire(name, basicClass);
        }
        if (name.equals("akz") || name.equals("net.minecraft.block.BlockFence")) {
            return this.patchBlockFence(name, basicClass);
        }
        if (name.equals("amw") || name.equals("net.minecraft.block.BlockPumpkin")) {
            // empty if block
        }
        if (name.equals("aoe") || name.equals("net.minecraft.block.BlockTrapDoor")) {
            return this.patchBlockTrapdoor(name, basicClass);
        }
        if (name.equals("aoi") || name.equals("net.minecraft.block.BlockWall")) {
            return this.patchBlockWall(name, basicClass);
        }
        if (name.equals(cls_BlockPistonBase_obf) || name.equals("net.minecraft.block.BlockPistonBase")) {
            return this.patchBlockPistonBase(name, basicClass);
        }
        if (name.equals("ajw") || name.equals("net.minecraft.block.BlockCauldron")) {
            return this.patchBlockCauldron(name, basicClass);
        }
        if (name.equals("ajb") || name.equals("net.minecraft.block.BlockAnvil")) {
            return this.patchBlockAnvil(name, basicClass);
        }
        if (name.equals(cls_EntityPlayer_obf) || name.equals("net.minecraft.entity.player.EntityPlayer")) {
            return this.patchEntityPlayer(name, basicClass);
        }
        if (name.equals(cls_EntityLivingBase_obf) || name.equals("net.minecraft.entity.EntityLivingBase")) {
            return this.patchEntityLivingBase(name, basicClass);
        }
        if (name.equals("wi") || name.equals("net.minecraft.entity.passive.EntityHorse")) {
            return this.patchEntityHorse(name, basicClass);
        }
        if (name.equals("xh") || name.equals("net.minecraft.entity.effect.EntityLightningBolt")) {
            return this.patchEntityLightningBolt(name, basicClass);
        }
        if (name.equals("xl") || name.equals("net.minecraft.entity.item.EntityMinecart")) {
            return this.patchEntityMinecart(name, basicClass);
        }
        if (name.equals("net.minecraftforge.common.ISpecialArmor$ArmorProperties")) {
            return this.patchArmorProperties(name, basicClass);
        }
        if (name.equals("zr") || name.equals("net.minecraft.util.FoodStats")) {
            return this.patchFoodStats(name, basicClass);
        }
        if (name.equals("aho") || name.equals("net.minecraft.world.SpawnerAnimals")) {
            return this.patchSpawnerAnimals(name, basicClass);
        }
        if (name.equals("ayg") || name.equals("net.minecraft.pathfinding.PathFinder")) {
            return this.patchPathFinder(name, basicClass);
        }
        if (name.equals("uc") || name.equals("net.minecraft.entity.ai.EntityAIDoorInteract")) {
            return this.patchDoorInteract(name, basicClass);
        }
        if (name.equals("afv") || name.equals("net.minecraft.enchantment.EnchantmentHelper")) {
            return this.patchEnchantmentHelper(name, basicClass);
        }
        if (name.equals(cls_ItemStack_obf) || name.equals("net.minecraft.item.ItemStack")) {
            return this.patchItemStack(name, basicClass);
        }
        if (name.equals("agi") || name.equals("net.minecraft.enchantment.EnchantmentProtection")) {
            return this.patchEnchantmentProtection(name, basicClass);
        }
        if (name.equals("rs") || name.equals("net.minecraft.potion.PotionAttackDamage")) {
            return this.patchPotionDamage(name, basicClass);
        }
        if (name.equals(cls_RenderBlocks_obf) || name.equals("net.minecraft.client.renderer.RenderBlocks")) {
            return this.patchRenderBlocks(name, basicClass);
        }
        if (name.equals("bjk") || name.equals("net.minecraft.client.entity.EntityClientPlayerMP")) {
            return this.patchEntityClientPlayerMP(name, basicClass);
        }
        if (name.equals("bjb") || name.equals("net.minecraft.client.network.NetHandlerPlayClient")) {
            return this.patchNetHandlerClient(name, basicClass);
        }
        if (name.equals("cpw.mods.fml.common.network.internal.FMLNetworkHandler")) {
            return this.patchFMLNetworkHandler(name, basicClass);
        }
        return basicClass;
    }

    private byte[] patchBlockStone(String name, byte[] bytes) {
        String targetMethodDesc;
        boolean isObf = !name.startsWith("net.minecraft");
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept((ClassVisitor)classNode, 0);
        String targetMethodName = "getIcon";
        String targetMethodNameObf = "func_149673_e";
        String targetMethodDescObf = targetMethodDesc = "(Lnet/minecraft/world/IBlockAccess;IIII)Lnet/minecraft/util/IIcon;";
        MethodNode newMethod = isObf ? new MethodNode(1, targetMethodNameObf, targetMethodDescObf, null, null) : new MethodNode(1, targetMethodName, targetMethodDesc, null, null);
        newMethod.instructions.add((AbstractInsnNode)new VarInsnNode(25, 0));
        newMethod.instructions.add((AbstractInsnNode)new VarInsnNode(25, 1));
        newMethod.instructions.add((AbstractInsnNode)new VarInsnNode(21, 2));
        newMethod.instructions.add((AbstractInsnNode)new VarInsnNode(21, 3));
        newMethod.instructions.add((AbstractInsnNode)new VarInsnNode(21, 4));
        newMethod.instructions.add((AbstractInsnNode)new VarInsnNode(21, 5));
        newMethod.instructions.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Stone", "getIconWorld", "(Lnet/minecraft/block/Block;Lnet/minecraft/world/IBlockAccess;IIII)Lnet/minecraft/util/IIcon;", false));
        newMethod.instructions.add((AbstractInsnNode)new InsnNode(176));
        classNode.methods.add(newMethod);
        System.out.println("LOTRCore: Added method " + newMethod.name);
        targetMethodName = "getIcon";
        targetMethodNameObf = "func_149691_a";
        targetMethodDescObf = targetMethodDesc = "(II)Lnet/minecraft/util/IIcon;";
        newMethod = isObf ? new MethodNode(1, targetMethodNameObf, targetMethodDescObf, null, null) : new MethodNode(1, targetMethodName, targetMethodDesc, null, null);
        newMethod.instructions.add((AbstractInsnNode)new VarInsnNode(25, 0));
        newMethod.instructions.add((AbstractInsnNode)new FieldInsnNode(180, cls_Block, isObf ? "field_149761_L" : "blockIcon", "Lnet/minecraft/util/IIcon;"));
        newMethod.instructions.add((AbstractInsnNode)new VarInsnNode(58, 3));
        newMethod.instructions.add((AbstractInsnNode)new VarInsnNode(25, 0));
        newMethod.instructions.add((AbstractInsnNode)new VarInsnNode(25, 3));
        newMethod.instructions.add((AbstractInsnNode)new VarInsnNode(21, 1));
        newMethod.instructions.add((AbstractInsnNode)new VarInsnNode(21, 2));
        newMethod.instructions.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Stone", "getIconSideMeta", "(Lnet/minecraft/block/Block;Lnet/minecraft/util/IIcon;II)Lnet/minecraft/util/IIcon;", false));
        newMethod.instructions.add((AbstractInsnNode)new InsnNode(176));
        classNode.methods.add(newMethod);
        System.out.println("LOTRCore: Added method " + newMethod.name);
        ClassWriter writer = new ClassWriter(1);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] patchBlockGrass(String name, byte[] bytes) {
        String targetMethodName = "updateTick";
        String targetMethodNameObf = "func_149674_a";
        String targetMethodSign = "(Lnet/minecraft/world/World;IIILjava/util/Random;)V";
        String targetMethodSignObf = "(Lahb;IIILjava/util/Random;)V";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept((ClassVisitor)classNode, 0);
        for (MethodNode method : classNode.methods) {
            if (!method.name.equals(targetMethodName) && !method.name.equals(targetMethodNameObf) || !method.desc.equals(targetMethodSign) && !method.desc.equals(targetMethodSignObf)) continue;
            method.instructions.clear();
            InsnList newIns = new InsnList();
            newIns.add((AbstractInsnNode)new VarInsnNode(25, 1));
            newIns.add((AbstractInsnNode)new VarInsnNode(21, 2));
            newIns.add((AbstractInsnNode)new VarInsnNode(21, 3));
            newIns.add((AbstractInsnNode)new VarInsnNode(21, 4));
            newIns.add((AbstractInsnNode)new VarInsnNode(25, 5));
            newIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Grass", "updateTick_optimised", "(Lnet/minecraft/world/World;IIILjava/util/Random;)V", false));
            newIns.add((AbstractInsnNode)new InsnNode(177));
            method.instructions.insert(newIns);
            System.out.println("LOTRCore: Patched method " + method.name);
        }
        ClassWriter writer = new ClassWriter(1);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] patchBlockDirt(String name, byte[] bytes) {
        String targetMethodName = "damageDropped";
        String targetMethodNameObf = "func_149692_a";
        String targetMethodSign = "(I)I";
        String targetMethodName2 = "createStackedBlock";
        String targetMethodNameObf2 = "func_149644_j";
        String targetMethodSign2 = "(I)Lnet/minecraft/item/ItemStack;";
        String targetMethodSignObf2 = "(I)Ladd;";
        String targetMethodName3 = "getSubBlocks";
        String targetMethodNameObf3 = "func_149666_a";
        String targetMethodSign3 = "(Lnet/minecraft/item/Item;Lnet/minecraft/creativetab/CreativeTabs;Ljava/util/List;)V";
        String targetMethodSignObf3 = "(Ladb;Labt;Ljava/util/List;)V";
        String targetMethodName4 = "getDamageValue";
        String targetMethodNameObf4 = "func_149643_k";
        String targetMethodSign4 = "(Lnet/minecraft/world/World;III)I";
        String targetMethodSignObf4 = "(Lahb;III)I";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept((ClassVisitor)classNode, 0);
        for (MethodNode method : classNode.methods) {
            InsnList newIns;
            if (method.name.equals("<clinit>")) {
                LdcInsnNode nodeNameIndex1 = LOTRClassTransformer.findNodeInMethod(method, new LdcInsnNode((Object)"default"), 1);
                method.instructions.set((AbstractInsnNode)nodeNameIndex1, (AbstractInsnNode)new LdcInsnNode((Object)LOTRReplacedMethods.Dirt.nameIndex1));
                System.out.println("LOTRCore: Patched method " + method.name);
            }
            if ((method.name.equals(targetMethodName) || method.name.equals(targetMethodNameObf)) && method.desc.equals(targetMethodSign)) {
                method.instructions.clear();
                newIns = new InsnList();
                newIns.add((AbstractInsnNode)new VarInsnNode(21, 1));
                newIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Dirt", "damageDropped", "(I)I", false));
                newIns.add((AbstractInsnNode)new InsnNode(172));
                method.instructions.insert(newIns);
                System.out.println("LOTRCore: Patched method " + method.name);
            }
            if ((method.name.equals(targetMethodName2) || method.name.equals(targetMethodNameObf2)) && (method.desc.equals(targetMethodSign2) || method.desc.equals(targetMethodSignObf2))) {
                method.instructions.clear();
                newIns = new InsnList();
                newIns.add((AbstractInsnNode)new VarInsnNode(25, 0));
                newIns.add((AbstractInsnNode)new VarInsnNode(21, 1));
                newIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Dirt", "createStackedBlock", "(Lnet/minecraft/block/Block;I)Lnet/minecraft/item/ItemStack;", false));
                newIns.add((AbstractInsnNode)new InsnNode(176));
                method.instructions.insert(newIns);
                System.out.println("LOTRCore: Patched method " + method.name);
            }
            if ((method.name.equals(targetMethodName3) || method.name.equals(targetMethodNameObf3)) && (method.desc.equals(targetMethodSign3) || method.desc.equals(targetMethodSignObf3))) {
                method.instructions.clear();
                newIns = new InsnList();
                newIns.add((AbstractInsnNode)new VarInsnNode(25, 0));
                newIns.add((AbstractInsnNode)new VarInsnNode(25, 1));
                newIns.add((AbstractInsnNode)new VarInsnNode(25, 2));
                newIns.add((AbstractInsnNode)new VarInsnNode(25, 3));
                newIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Dirt", "getSubBlocks", "(Lnet/minecraft/block/Block;Lnet/minecraft/item/Item;Lnet/minecraft/creativetab/CreativeTabs;Ljava/util/List;)V", false));
                newIns.add((AbstractInsnNode)new InsnNode(177));
                method.instructions.insert(newIns);
                System.out.println("LOTRCore: Patched method " + method.name);
            }
            if (!method.name.equals(targetMethodName4) && !method.name.equals(targetMethodNameObf4) || !method.desc.equals(targetMethodSign4) && !method.desc.equals(targetMethodSignObf4)) continue;
            method.instructions.clear();
            newIns = new InsnList();
            newIns.add((AbstractInsnNode)new VarInsnNode(25, 1));
            newIns.add((AbstractInsnNode)new VarInsnNode(21, 2));
            newIns.add((AbstractInsnNode)new VarInsnNode(21, 3));
            newIns.add((AbstractInsnNode)new VarInsnNode(21, 4));
            newIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Dirt", "getDamageValue", "(Lnet/minecraft/world/World;III)I", false));
            newIns.add((AbstractInsnNode)new InsnNode(172));
            method.instructions.insert(newIns);
            System.out.println("LOTRCore: Patched method " + method.name);
        }
        ClassWriter writer = new ClassWriter(1);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] patchBlockStaticLiquid(String name, byte[] bytes) {
        String targetMethodName = "updateTick";
        String targetMethodNameObf = "func_149674_a";
        String targetMethodSign = "(Lnet/minecraft/world/World;IIILjava/util/Random;)V";
        String targetMethodSignObf = "(Lahb;IIILjava/util/Random;)V";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept((ClassVisitor)classNode, 0);
        for (MethodNode method : classNode.methods) {
            if (!method.name.equals(targetMethodName) && !method.name.equals(targetMethodNameObf) || !method.desc.equals(targetMethodSign) && !method.desc.equals(targetMethodSignObf)) continue;
            method.instructions.clear();
            InsnList newIns = new InsnList();
            newIns.add((AbstractInsnNode)new VarInsnNode(25, 0));
            newIns.add((AbstractInsnNode)new VarInsnNode(25, 1));
            newIns.add((AbstractInsnNode)new VarInsnNode(21, 2));
            newIns.add((AbstractInsnNode)new VarInsnNode(21, 3));
            newIns.add((AbstractInsnNode)new VarInsnNode(21, 4));
            newIns.add((AbstractInsnNode)new VarInsnNode(25, 5));
            newIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$StaticLiquid", "updateTick_optimised", "(Lnet/minecraft/block/Block;Lnet/minecraft/world/World;IIILjava/util/Random;)V", false));
            newIns.add((AbstractInsnNode)new InsnNode(177));
            method.instructions.insert(newIns);
            System.out.println("LOTRCore: Patched method " + method.name);
        }
        ClassWriter writer = new ClassWriter(1);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] patchBlockFire(String name, byte[] bytes) {
        String targetMethodName2;
        String targetMethodName = "updateTick";
        String targetMethodNameObf = "func_149674_a";
        String targetMethodSign = "(Lnet/minecraft/world/World;IIILjava/util/Random;)V";
        String targetMethodSignObf = "(Lahb;IIILjava/util/Random;)V";
        String targetMethodNameObf2 = targetMethodName2 = "tryCatchFire";
        String targetMethodSign2 = "(Lnet/minecraft/world/World;IIIILjava/util/Random;ILnet/minecraftforge/common/util/ForgeDirection;)V";
        String targetMethodSignObf2 = "(Lahb;IIIILjava/util/Random;ILnet/minecraftforge/common/util/ForgeDirection;)V";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept(classNode, 0);
        for (MethodNode method : classNode.methods) {
            MethodInsnNode mNod;
            InsnList newIns;
            if ((method.name.equals(targetMethodName) || method.name.equals(targetMethodNameObf)) && (method.desc.equals(targetMethodSign) || method.desc.equals(targetMethodSignObf))) {
                MethodInsnNode lastTryCatchFire = null;
                for (AbstractInsnNode nod : method.instructions.toArray()) {
                    if (!(nod instanceof MethodInsnNode) || nod.getOpcode() != 183) continue;
                    mNod = (MethodInsnNode)nod;
                    if (!mNod.name.equals("tryCatchFire")) continue;
                    lastTryCatchFire = (MethodInsnNode)nod;
                }
                JumpInsnNode jumpToReturn = null;
                for (AbstractInsnNode nod : method.instructions.toArray()) {
                    if (!(nod instanceof MethodInsnNode) || nod.getOpcode() != 182) continue;
                    MethodInsnNode mNod2 = (MethodInsnNode)nod;
                    if (!mNod2.name.equals("getGameRuleBooleanValue") && !mNod2.name.equals("func_82766_b")) continue;
                    jumpToReturn = (JumpInsnNode)mNod2.getNext();
                }
                LabelNode labelReturn = jumpToReturn.label;
                if (jumpToReturn.getOpcode() != 153) {
                    System.out.println("WARNING! WARNING! THIS OPCODE SHOULD HAVE BEEN IFEQ!");
                    System.out.println("WARNING! INSTEAD IT WAS " + jumpToReturn.getOpcode());
                    System.out.println("WARNING! NOT SURE WHAT TO DO HERE! THINGS MIGHT BREAK!");
                }
                newIns = new InsnList();
                newIns.add(new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Fire", "isFireSpreadDisabled", "()Z", false));
                newIns.add(new JumpInsnNode(154, labelReturn));
                method.instructions.insert(lastTryCatchFire, newIns);
                System.out.println("LOTRCore: Patched method " + method.name);
            }
            if (!method.name.equals(targetMethodName2) && !method.name.equals(targetMethodNameObf2) || !method.desc.equals(targetMethodSign2) && !method.desc.equals(targetMethodSignObf2)) continue;
            MethodInsnNode canLightning = null;
            for (AbstractInsnNode nod : method.instructions.toArray()) {
                if (!(nod instanceof MethodInsnNode) || nod.getOpcode() != 182) continue;
                mNod = (MethodInsnNode)nod;
                if (!mNod.name.equals("canLightningStrikeAt") && !mNod.name.equals("func_72951_B")) continue;
                canLightning = mNod;
                break;
            }
            JumpInsnNode jumpToSetAir = (JumpInsnNode)canLightning.getNext();
            LabelNode labelSetAir = jumpToSetAir.label;
            if (jumpToSetAir.getOpcode() != 154) {
                System.out.println("WARNING! WARNING! THIS OPCODE SHOULD HAVE BEEN IFNE!");
                System.out.println("WARNING! INSTEAD IT WAS " + jumpToSetAir.getOpcode());
                System.out.println("WARNING! NOT SURE WHAT TO DO HERE! THINGS MIGHT BREAK!");
            }
            newIns = new InsnList();
            newIns.add(new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Fire", "isFireSpreadDisabled", "()Z", false));
            newIns.add(new JumpInsnNode(154, labelSetAir));
            method.instructions.insert(jumpToSetAir, newIns);
            method.instructions.resetLabels();
            System.out.println("LOTRCore: Patched method " + method.name);
        }
        ClassWriter writer = new ClassWriter(3);
        classNode.accept(writer);
        return writer.toByteArray();
    }

    private byte[] patchBlockFence(String name, byte[] bytes) {
        String targetMethodName2;
        String targetMethodName = "canConnectFenceTo";
        String targetMethodNameObf = "func_149826_e";
        String targetMethodSign = "(Lnet/minecraft/world/IBlockAccess;III)Z";
        String targetMethodSignObf = "(Lahl;III)Z";
        String targetMethodNameObf2 = targetMethodName2 = "func_149825_a";
        String targetMethodSign2 = "(Lnet/minecraft/block/Block;)Z";
        String targetMethodSignObf2 = "(Laji;)Z";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept((ClassVisitor)classNode, 0);
        for (MethodNode method : classNode.methods) {
            InsnList newIns;
            if ((method.name.equals(targetMethodName) || method.name.equals(targetMethodNameObf)) && (method.desc.equals(targetMethodSign) || method.desc.equals(targetMethodSignObf))) {
                method.instructions.clear();
                newIns = new InsnList();
                newIns.add((AbstractInsnNode)new VarInsnNode(25, 1));
                newIns.add((AbstractInsnNode)new VarInsnNode(21, 2));
                newIns.add((AbstractInsnNode)new VarInsnNode(21, 3));
                newIns.add((AbstractInsnNode)new VarInsnNode(21, 4));
                newIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Fence", "canConnectFenceTo", "(Lnet/minecraft/world/IBlockAccess;III)Z", false));
                newIns.add((AbstractInsnNode)new InsnNode(172));
                method.instructions.insert(newIns);
                System.out.println("LOTRCore: Patched method " + method.name);
            }
            if (!method.name.equals(targetMethodName2) && !method.name.equals(targetMethodNameObf2) || !method.desc.equals(targetMethodSign2) && !method.desc.equals(targetMethodSignObf2)) continue;
            method.instructions.clear();
            newIns = new InsnList();
            newIns.add((AbstractInsnNode)new VarInsnNode(25, 0));
            newIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Fence", "canPlacePressurePlate", "(Lnet/minecraft/block/Block;)Z", false));
            newIns.add((AbstractInsnNode)new InsnNode(172));
            method.instructions.insert(newIns);
            System.out.println("LOTRCore: Patched method " + method.name);
        }
        ClassWriter writer = new ClassWriter(1);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] patchBlockPumpkin(String name, byte[] bytes) {
        String targetMethodName = "getIcon";
        String targetMethodNameObf = "func_149691_a";
        String targetMethodSign = "(II)Lnet/minecraft/util/IIcon;";
        String targetMethodSignObf = "(II)Lrf;";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept((ClassVisitor)classNode, 0);
        for (MethodNode method : classNode.methods) {
            if (!method.name.equals(targetMethodName) && !method.name.equals(targetMethodNameObf) || !method.desc.equals(targetMethodSign) && !method.desc.equals(targetMethodSignObf)) continue;
            InsnList newIns = new InsnList();
            newIns.add((AbstractInsnNode)new VarInsnNode(25, 0));
            newIns.add((AbstractInsnNode)new VarInsnNode(21, 1));
            newIns.add((AbstractInsnNode)new VarInsnNode(21, 2));
            newIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Pumpkin", "alterIconSideParam", "(Lnet/minecraft/block/Block;II)I", false));
            newIns.add((AbstractInsnNode)new VarInsnNode(54, 1));
            method.instructions.insertBefore(method.instructions.getFirst(), newIns);
            System.out.println("LOTRCore: Patched method " + method.name);
        }
        ClassWriter writer = new ClassWriter(1);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] patchBlockTrapdoor(String name, byte[] bytes) {
        String targetMethodName2;
        String targetMethodSign3;
        String targetMethodName = "canPlaceBlockOnSide";
        String targetMethodNameObf = "func_149707_d";
        String targetMethodSign = "(Lnet/minecraft/world/World;IIII)Z";
        String targetMethodSignObf = "(Lahb;IIII)Z";
        String targetMethodNameObf2 = targetMethodName2 = "func_150119_a";
        String targetMethodSign2 = "(Lnet/minecraft/block/Block;)Z";
        String targetMethodSignObf2 = "(Laji;)Z";
        String targetMethodName3 = "getRenderType";
        String targetMethodNameObf3 = "func_149645_b";
        String targetMethodSignObf3 = targetMethodSign3 = "()I";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept((ClassVisitor)classNode, 0);
        for (MethodNode method : classNode.methods) {
            InsnList newIns;
            if ((method.name.equals(targetMethodName) || method.name.equals(targetMethodNameObf)) && (method.desc.equals(targetMethodSign) || method.desc.equals(targetMethodSignObf))) {
                method.instructions.clear();
                newIns = new InsnList();
                newIns.add((AbstractInsnNode)new VarInsnNode(25, 1));
                newIns.add((AbstractInsnNode)new VarInsnNode(21, 2));
                newIns.add((AbstractInsnNode)new VarInsnNode(21, 3));
                newIns.add((AbstractInsnNode)new VarInsnNode(21, 4));
                newIns.add((AbstractInsnNode)new VarInsnNode(21, 5));
                newIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Trapdoor", "canPlaceBlockOnSide", "(Lnet/minecraft/world/World;IIII)Z", false));
                newIns.add((AbstractInsnNode)new InsnNode(172));
                method.instructions.insert(newIns);
                System.out.println("LOTRCore: Patched method " + method.name);
            }
            if ((method.name.equals(targetMethodName2) || method.name.equals(targetMethodNameObf2)) && (method.desc.equals(targetMethodSign2) || method.desc.equals(targetMethodSignObf2))) {
                method.instructions.clear();
                newIns = new InsnList();
                newIns.add((AbstractInsnNode)new VarInsnNode(25, 0));
                newIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Trapdoor", "isValidSupportBlock", "(Lnet/minecraft/block/Block;)Z", false));
                newIns.add((AbstractInsnNode)new InsnNode(172));
                method.instructions.insert(newIns);
                System.out.println("LOTRCore: Patched method " + method.name);
            }
            if (!method.name.equals(targetMethodName3) && !method.name.equals(targetMethodNameObf3) || !method.desc.equals(targetMethodSign3) && !method.desc.equals(targetMethodSignObf3)) continue;
            method.instructions.clear();
            newIns = new InsnList();
            newIns.add((AbstractInsnNode)new VarInsnNode(25, 0));
            newIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Trapdoor", "getRenderType", "(Lnet/minecraft/block/Block;)I", false));
            newIns.add((AbstractInsnNode)new InsnNode(172));
            method.instructions.insert(newIns);
            System.out.println("LOTRCore: Patched method " + method.name);
        }
        ClassWriter writer = new ClassWriter(1);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] patchBlockWall(String name, byte[] bytes) {
        String targetMethodName = "canConnectWallTo";
        String targetMethodNameObf = "func_150091_e";
        String targetMethodSign = "(Lnet/minecraft/world/IBlockAccess;III)Z";
        String targetMethodSignObf = "(Lahl;III)Z";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept((ClassVisitor)classNode, 0);
        for (MethodNode method : classNode.methods) {
            if (!method.name.equals(targetMethodName) && !method.name.equals(targetMethodNameObf) || !method.desc.equals(targetMethodSign) && !method.desc.equals(targetMethodSignObf)) continue;
            method.instructions.clear();
            InsnList newIns = new InsnList();
            newIns.add((AbstractInsnNode)new VarInsnNode(25, 1));
            newIns.add((AbstractInsnNode)new VarInsnNode(21, 2));
            newIns.add((AbstractInsnNode)new VarInsnNode(21, 3));
            newIns.add((AbstractInsnNode)new VarInsnNode(21, 4));
            newIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Wall", "canConnectWallTo", "(Lnet/minecraft/world/IBlockAccess;III)Z", false));
            newIns.add((AbstractInsnNode)new InsnNode(172));
            method.instructions.insert(newIns);
            System.out.println("LOTRCore: Patched method " + method.name);
        }
        ClassWriter writer = new ClassWriter(1);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] patchBlockPistonBase(String name, byte[] bytes) {
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept((ClassVisitor)classNode, 0);
        for (MethodNode method : classNode.methods) {
            int skip = 0;
            do {
                MethodInsnNode nodeFound = null;
                block2: for (boolean pistonObf : new boolean[]{false, true}) {
                    for (boolean canPushObf : new boolean[]{false, true}) {
                        for (boolean blockObf : new boolean[]{false, true}) {
                            for (boolean worldObf : new boolean[]{false, true}) {
                                String _piston = pistonObf ? cls_BlockPistonBase_obf : cls_BlockPistonBase;
                                String _canPush = canPushObf ? "func_150080_a" : "canPushBlock";
                                String _block = blockObf ? cls_Block_obf : cls_Block;
                                String _world = worldObf ? cls_World_obf : cls_World;
                                MethodInsnNode nodeInvokeCanPush = new MethodInsnNode(184, _piston, _canPush, "(L" + _block + ";L" + _world + ";IIIZ)Z", false);
                                nodeFound = LOTRClassTransformer.findNodeInMethod(method, nodeInvokeCanPush, skip);
                                if (nodeFound != null) break block2;
                            }
                        }
                    }
                }
                if (nodeFound == null) break;
                nodeFound.setOpcode(184);
                nodeFound.owner = "lotr/common/coremod/LOTRReplacedMethods$Piston";
                nodeFound.name = "canPushBlock";
                nodeFound.desc = "(Lnet/minecraft/block/Block;Lnet/minecraft/world/World;IIIZ)Z";
                nodeFound.itf = false;
                ++skip;
            } while (true);
            if (skip <= 0) continue;
            System.out.println("LOTRCore: Patched method " + method.name + " " + skip + " times");
        }
        ClassWriter writer = new ClassWriter(1);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] patchBlockCauldron(String name, byte[] bytes) {
        String targetMethodName = "getRenderType";
        String targetMethodNameObf = "func_149645_b";
        String targetMethodSign = "()I";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept((ClassVisitor)classNode, 0);
        for (MethodNode method : classNode.methods) {
            if (!method.name.equals(targetMethodName) && !method.name.equals(targetMethodNameObf) || !method.desc.equals(targetMethodSign)) continue;
            method.instructions.clear();
            InsnList newIns = new InsnList();
            newIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Cauldron", "getRenderType", "()I", false));
            newIns.add((AbstractInsnNode)new InsnNode(172));
            method.instructions.insert(newIns);
            System.out.println("LOTRCore: Patched method " + method.name);
        }
        ClassWriter writer = new ClassWriter(1);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] patchBlockAnvil(String name, byte[] bytes) {
        String targetMethodDesc;
        boolean isObf = !name.startsWith("net.minecraft");
        String targetMethodName = "getCollisionBoundingBoxFromPool";
        String targetMethodNameObf = "func_149668_a";
        String targetMethodDescObf = targetMethodDesc = "(Lnet/minecraft/world/World;III)Lnet/minecraft/util/AxisAlignedBB;";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept((ClassVisitor)classNode, 0);
        MethodNode newMethod = isObf ? new MethodNode(1, targetMethodNameObf, targetMethodDescObf, null, null) : new MethodNode(1, targetMethodName, targetMethodDesc, null, null);
        newMethod.instructions.add((AbstractInsnNode)new VarInsnNode(25, 0));
        newMethod.instructions.add((AbstractInsnNode)new VarInsnNode(25, 1));
        newMethod.instructions.add((AbstractInsnNode)new VarInsnNode(21, 2));
        newMethod.instructions.add((AbstractInsnNode)new VarInsnNode(21, 3));
        newMethod.instructions.add((AbstractInsnNode)new VarInsnNode(21, 4));
        newMethod.instructions.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Anvil", "getCollisionBoundingBoxFromPool", "(Lnet/minecraft/block/Block;Lnet/minecraft/world/World;III)Lnet/minecraft/util/AxisAlignedBB;", false));
        newMethod.instructions.add((AbstractInsnNode)new InsnNode(176));
        classNode.methods.add(newMethod);
        System.out.println("LOTRCore: Added method " + newMethod.name);
        ClassWriter writer = new ClassWriter(1);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] patchEntityPlayer(String name, byte[] bytes) {
        String targetMethodName = "canEat";
        String targetMethodNameObf = "func_71043_e";
        String targetMethodSign = "(Z)Z";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept((ClassVisitor)classNode, 0);
        for (MethodNode method : classNode.methods) {
            if (!method.name.equals(targetMethodName) && !method.name.equals(targetMethodNameObf) || !method.desc.equals(targetMethodSign)) continue;
            method.instructions.clear();
            InsnList newIns = new InsnList();
            newIns.add((AbstractInsnNode)new VarInsnNode(25, 0));
            newIns.add((AbstractInsnNode)new VarInsnNode(21, 1));
            newIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Player", "canEat", "(Lnet/minecraft/entity/player/EntityPlayer;Z)Z", false));
            newIns.add((AbstractInsnNode)new InsnNode(172));
            method.instructions.insert(newIns);
            System.out.println("LOTRCore: Patched method " + method.name);
        }
        ClassWriter writer = new ClassWriter(1);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] patchEntityLivingBase(String name, byte[] bytes) {
		String targetMethodName = "getTotalArmorValue";
		String targetMethodNameObf = "func_70658_aO";
		String targetMethodSign = "()I";
		String targetMethodName2 = "onDeath";
		String targetMethodNameObf2 = "func_70645_a";
		String targetMethodSign2 = "(Lnet/minecraft/util/DamageSource;)V";
		String targetMethodSignObf2 = "(Lro;)V";
		ClassNode classNode = new ClassNode();
		ClassReader classReader = new ClassReader(bytes);
		classReader.accept(classNode, 0);
		for (MethodNode method : classNode.methods) {
			if ((method.name.equals(targetMethodName) || method.name.equals(targetMethodNameObf)) && method.desc.equals(targetMethodSign)) {
				VarInsnNode nodeStore = findNodeInMethod(method, new VarInsnNode(54, 6));
				for (int l = 0; l < 3; l++) {
					method.instructions.remove(nodeStore.getPrevious());
				}
				AbstractInsnNode newPrev = nodeStore.getPrevious();
				if (!(newPrev instanceof VarInsnNode) || ((VarInsnNode) newPrev).getOpcode() != 25 || ((VarInsnNode) newPrev).var != 5) {
					System.out.println("WARNING! Expected ALOAD 5! Instead got " + newPrev);
					System.out.println("WARNING! Things may break!");
				}
				InsnList newIns = new InsnList();
				newIns.add(new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Enchants", "getDamageReduceAmount", "(Lnet/minecraft/item/ItemStack;)I", false));
				method.instructions.insertBefore(nodeStore, newIns);
				System.out.println("LOTRCore: Patched method " + method.name);
			}
			if ((method.name.equals(targetMethodName2) || method.name.equals(targetMethodNameObf2)) && (method.desc.equals(targetMethodSign2) || method.desc.equals(targetMethodSignObf2))) {
				TypeInsnNode nodeIsInstance = null;
				for (boolean playerObf : new boolean[] { false, true }) {
					nodeIsInstance = findNodeInMethod(method, new TypeInsnNode(193, playerObf ? "yz" : "net/minecraft/entity/player/EntityPlayer"));
					if (nodeIsInstance != null) {
						break;
					}
				}
				VarInsnNode nodeLoadEntity = (VarInsnNode) nodeIsInstance.getPrevious();
				method.instructions.remove(nodeIsInstance);
				InsnList newIns = new InsnList();
				newIns.add(new VarInsnNode(25, 1));
				newIns.add(new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Enchants", "isPlayerMeleeKill", "(Lnet/minecraft/entity/Entity;Lnet/minecraft/util/DamageSource;)Z", false));
				method.instructions.insert(nodeLoadEntity, newIns);
				System.out.println("LOTRCore: Patched method " + method.name);
			}
		}
		ClassWriter writer = new ClassWriter(1);
		classNode.accept(writer);
		return writer.toByteArray();
	}

    private byte[] patchEntityHorse(String name, byte[] bytes) {
        String targetMethodName = "moveEntityWithHeading";
        String targetMethodNameObf = "func_70612_e";
        String targetMethodSign = "(FF)V";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept((ClassVisitor)classNode, 0);
        for (MethodNode method : classNode.methods) {
            if (!method.name.equals(targetMethodName) && !method.name.equals(targetMethodNameObf) || !method.desc.equals(targetMethodSign)) continue;
            FieldInsnNode nodeIsRemote = null;
            block1: for (boolean worldObf : new boolean[]{false, true}) {
                boolean[] arrbl = new boolean[]{false, true};
                int n = arrbl.length;
                for (int i = 0; i < n; ++i) {
                    String _remote;
                    boolean isRemoteObf;
                    String _world = worldObf ? cls_World_obf : cls_World;
                    nodeIsRemote = LOTRClassTransformer.findNodeInMethod(method, new FieldInsnNode(180, _world, _remote = (isRemoteObf = arrbl[i]) ? "field_72995_K" : "isRemote", "Z"));
                    if (nodeIsRemote != null) break block1;
                }
            }
            VarInsnNode nodeLoadThisEntity = (VarInsnNode)nodeIsRemote.getPrevious().getPrevious();
            for (int l = 0; l < 2; ++l) {
                method.instructions.remove(nodeLoadThisEntity.getNext());
            }
            JumpInsnNode nodeIfTest = (JumpInsnNode)nodeLoadThisEntity.getNext();
            if (nodeIfTest.getOpcode() == 154) {
                nodeIfTest.setOpcode(153);
            } else {
                System.out.println("WARNING! Expected IFNE! Instead got " + nodeIfTest.getOpcode());
                System.out.println("WARNING! Things may break!");
            }
            InsnList newIns = new InsnList();
            newIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/entity/LOTRMountFunctions", "canRiderControl_elseNoMotion", "(Lnet/minecraft/entity/EntityLiving;)Z", false));
            method.instructions.insert((AbstractInsnNode)nodeLoadThisEntity, newIns);
            System.out.println("LOTRCore: Patched method " + method.name);
        }
        ClassWriter writer = new ClassWriter(1);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] patchEntityLightningBolt(String name, byte[] bytes) {
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept(classNode, 0);
        for (MethodNode method : classNode.methods) {
			if (method.name.equals("<init>")) {
				AbstractInsnNode nodeSuperConstructor = null;
				Iterator<AbstractInsnNode> it = method.instructions.iterator();
				while (it.hasNext()) {
					AbstractInsnNode node = it.next();
					if (node instanceof MethodInsnNode && node.getOpcode() == 183) {
						nodeSuperConstructor = node;
						break;
					}
				}
				InsnList newIns = new InsnList();
				newIns.add(new VarInsnNode(25, 0));
				newIns.add(new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Lightning", "init", "(Lnet/minecraft/entity/effect/EntityLightningBolt;)V", false));
				method.instructions.insert(nodeSuperConstructor, newIns);
				System.out.println("LOTRCore: Patched method " + method.name);
			}
		}
        for (MethodNode method : classNode.methods) {
            int count = 0;
            do {
                MethodInsnNode nodeSetBlock = null;
                block4: for (boolean worldObf : new boolean[]{false, true}) {
                    for (boolean setBlockObf : new boolean[]{false, true}) {
                        for (boolean blockObf : new boolean[]{false, true}) {
                            String _world = worldObf ? cls_World_obf : cls_World;
                            String _setBlock = setBlockObf ? "func_147449_b" : "setBlock";
                            String _block = blockObf ? cls_Block_obf : cls_Block;
                            nodeSetBlock = LOTRClassTransformer.findNodeInMethod(method, new MethodInsnNode(182, _world, _setBlock, "(IIIL" + _block + ";)Z", false));
                            if (nodeSetBlock != null) break block4;
                        }
                    }
                }
                if (nodeSetBlock == null) break;
                AbstractInsnNode nextNode = nodeSetBlock.getNext();
                if (nextNode.getOpcode() == 87) {
                    method.instructions.remove(nodeSetBlock.getNext());
                }
                method.instructions.set(nodeSetBlock, new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Lightning", "doSetBlock", "(Lnet/minecraft/world/World;IIILnet/minecraft/block/Block;)V", false));
                ++count;
            } while (true);
            if (count <= 0) continue;
            System.out.println("LOTRCore: Patched method " + method.name + ": " + count + " instances of World.setBlock()");
        }
        ClassWriter writer = new ClassWriter(1);
        classNode.accept(writer);
        return writer.toByteArray();
    }

    private byte[] patchEntityMinecart(String name, byte[] bytes) {
        String targetMethodName;
        String targetMethodNameObf = targetMethodName = "func_145821_a";
        String targetMethodSign = "(IIIDDLnet/minecraft/block/Block;I)V";
        String targetMethodSignObf = "(IIIDDLaji;I)V";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept((ClassVisitor)classNode, 0);
        for (MethodNode method : classNode.methods) {
            if (!method.name.equals(targetMethodName) && !method.name.equals(targetMethodNameObf) || !method.desc.equals(targetMethodSign) && !method.desc.equals(targetMethodSignObf)) continue;
            VarInsnNode nodeLoadRailBlockForPoweredCheck = LOTRClassTransformer.findNodeInMethod(method, new VarInsnNode(25, 8), 1);
            AbstractInsnNode nextNode = nodeLoadRailBlockForPoweredCheck.getNext();
            if (!(nextNode instanceof TypeInsnNode) || ((TypeInsnNode)nextNode).getOpcode() != 192) {
                System.out.println("WARNING! Expected CHECKCAST! Instead got " + (Object)nextNode);
                System.out.println("WARNING! Things may break!");
            }
            InsnList newIns = new InsnList();
            newIns.add((AbstractInsnNode)new VarInsnNode(25, 0));
            newIns.add((AbstractInsnNode)new VarInsnNode(21, 1));
            newIns.add((AbstractInsnNode)new VarInsnNode(21, 2));
            newIns.add((AbstractInsnNode)new VarInsnNode(21, 3));
            newIns.add((AbstractInsnNode)new VarInsnNode(25, 8));
            newIns.add((AbstractInsnNode)new VarInsnNode(21, 11));
            newIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Minecart", "checkForPoweredRail", "(Lnet/minecraft/entity/item/EntityMinecart;IIILnet/minecraft/block/Block;Z)Z", false));
            newIns.add((AbstractInsnNode)new VarInsnNode(54, 11));
            newIns.add((AbstractInsnNode)new VarInsnNode(25, 0));
            newIns.add((AbstractInsnNode)new VarInsnNode(21, 1));
            newIns.add((AbstractInsnNode)new VarInsnNode(21, 2));
            newIns.add((AbstractInsnNode)new VarInsnNode(21, 3));
            newIns.add((AbstractInsnNode)new VarInsnNode(25, 8));
            newIns.add((AbstractInsnNode)new VarInsnNode(21, 12));
            newIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Minecart", "checkForDepoweredRail", "(Lnet/minecraft/entity/item/EntityMinecart;IIILnet/minecraft/block/Block;Z)Z", false));
            newIns.add((AbstractInsnNode)new VarInsnNode(54, 12));
            method.instructions.insertBefore((AbstractInsnNode)nodeLoadRailBlockForPoweredCheck, newIns);
            System.out.println("LOTRCore: Patched method " + method.name);
        }
        ClassWriter writer = new ClassWriter(1);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] patchArmorProperties(String name, byte[] bytes) {
        String targetMethodName;
        String targetMethodSign;
        boolean isCauldron = LOTRModChecker.isCauldronServer();
        String targetMethodNameObf = targetMethodName = "ApplyArmor";
        String targetMethodSignObf = targetMethodSign = "(Lnet/minecraft/entity/EntityLivingBase;[Lnet/minecraft/item/ItemStack;Lnet/minecraft/util/DamageSource;D)F";
        if (isCauldron) {
            targetMethodNameObf = "ApplyArmor";
            targetMethodName = "ApplyArmor";
            targetMethodSignObf = "(Lnet/minecraft/entity/EntityLivingBase;[Lnet/minecraft/item/ItemStack;Lnet/minecraft/util/DamageSource;DZ)F";
            targetMethodSign = "(Lnet/minecraft/entity/EntityLivingBase;[Lnet/minecraft/item/ItemStack;Lnet/minecraft/util/DamageSource;DZ)F";
        }
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept((ClassVisitor)classNode, 0);
        for (MethodNode method : classNode.methods) {
            AbstractInsnNode nodePrev;
            if (!method.name.equals(targetMethodName) && !method.name.equals(targetMethodNameObf) || !method.desc.equals(targetMethodSign) && !method.desc.equals(targetMethodSignObf)) continue;
            FieldInsnNode nodeFound = null;
            block1: for (boolean armorObf : new boolean[]{false, true}) {
                for (int dmgObf = 0; dmgObf < 3; ++dmgObf) {
                    String _armor = armorObf ? cls_ItemArmor_obf : cls_ItemArmor;
                    String _dmg = new String[]{"field_77879_b", "damageReduceAmount", "c"}[dmgObf];
                    FieldInsnNode nodeDmg = new FieldInsnNode(180, _armor, _dmg, "I");
                    nodeFound = LOTRClassTransformer.findNodeInMethod(method, nodeDmg);
                    if (nodeFound != null) break block1;
                }
            }
            if (!((nodePrev = nodeFound.getPrevious()) instanceof VarInsnNode) || ((VarInsnNode)nodePrev).getOpcode() != 25 || ((VarInsnNode)nodePrev).var != 9) {
                System.out.println("WARNING! Expected ALOAD 9! Instead got " + (Object)nodePrev);
                System.out.println("WARNING! Things may break!");
            }
            method.instructions.remove(nodePrev);
            InsnList newIns = new InsnList();
            if (!isCauldron) {
                newIns.add((AbstractInsnNode)new VarInsnNode(25, 7));
                newIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Enchants", "getDamageReduceAmount", "(Lnet/minecraft/item/ItemStack;)I", false));
            } else {
                newIns.add((AbstractInsnNode)new VarInsnNode(25, 8));
                newIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Enchants", "getDamageReduceAmount", "(Lnet/minecraft/item/ItemStack;)I", false));
            }
            method.instructions.insert((AbstractInsnNode)nodeFound, newIns);
            method.instructions.remove((AbstractInsnNode)nodeFound);
            if (!isCauldron) {
                System.out.println("LOTRCore: Patched method " + method.name);
                continue;
            }
            System.out.println("LOTRCore: Patched method " + method.name + " for Cauldron");
        }
        ClassWriter writer = new ClassWriter(1);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] patchFoodStats(String name, byte[] bytes) {
        String targetMethodName = "addExhaustion";
        String targetMethodNameObf = "func_75113_a";
        String targetMethodSign = "(F)V";
        String targetMethodName2 = "needFood";
        String targetMethodNameObf2 = "func_75121_c";
        String targetMethodSign2 = "()Z";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept((ClassVisitor)classNode, 0);
        for (MethodNode method : classNode.methods) {
            if (!method.name.equals(targetMethodName) && !method.name.equals(targetMethodNameObf) || !method.desc.equals(targetMethodSign)) continue;
            InsnList newIns = new InsnList();
            newIns.add((AbstractInsnNode)new VarInsnNode(23, 1));
            newIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Food", "getExhaustionFactor", "()F", false));
            newIns.add((AbstractInsnNode)new InsnNode(106));
            newIns.add((AbstractInsnNode)new VarInsnNode(56, 1));
            VarInsnNode nodeAfter = LOTRClassTransformer.findNodeInMethod(method, new VarInsnNode(25, 0));
            method.instructions.insertBefore((AbstractInsnNode)nodeAfter, newIns);
            System.out.println("LOTRCore: Patched method " + method.name);
        }
        ClassWriter writer = new ClassWriter(1);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] patchSpawnerAnimals(String name, byte[] bytes) {
        String targetMethodName = "findChunksForSpawning";
        String targetMethodNameObf = "func_77192_a";
        String targetMethodSign = "(Lnet/minecraft/world/WorldServer;ZZZ)I";
        String targetMethodSignObf = "(Lmt;ZZZ)I";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept((ClassVisitor)classNode, 0);
        for (MethodNode method : classNode.methods) {
            if (!method.name.equals(targetMethodName) && !method.name.equals(targetMethodNameObf) || !method.desc.equals(targetMethodSign) && !method.desc.equals(targetMethodSignObf)) continue;
            method.instructions.clear();
            method.tryCatchBlocks.clear();
            method.localVariables.clear();
            InsnList newIns = new InsnList();
            newIns.add((AbstractInsnNode)new VarInsnNode(25, 1));
            newIns.add((AbstractInsnNode)new VarInsnNode(21, 2));
            newIns.add((AbstractInsnNode)new VarInsnNode(21, 3));
            newIns.add((AbstractInsnNode)new VarInsnNode(21, 4));
            newIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Spawner", "performSpawning_optimised", "(Lnet/minecraft/world/WorldServer;ZZZ)I", false));
            newIns.add((AbstractInsnNode)new InsnNode(172));
            method.instructions.insert(newIns);
            System.out.println("LOTRCore: Patched method " + method.name);
        }
        ClassWriter writer = new ClassWriter(1);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] patchPathFinder(String name, byte[] bytes) {
		String targetMethodName = "func_82565_a";
		String targetMethodNameObf = targetMethodName;
		String targetMethodSign = "(Lnet/minecraft/entity/Entity;IIILnet/minecraft/pathfinding/PathPoint;ZZZ)I";
		String targetMethodSignObf = "(Lsa;IIILaye;ZZZ)I";
		ClassNode classNode = new ClassNode();
		ClassReader classReader = new ClassReader(bytes);
		classReader.accept(classNode, 0);
		for (MethodNode method : classNode.methods) {
			if ((method.name.equals(targetMethodName) || method.name.equals(targetMethodNameObf)) && (method.desc.equals(targetMethodSign) || method.desc.equals(targetMethodSignObf))) {
				FieldInsnNode nodeFound1 = null;
				FieldInsnNode nodeFound2 = null;
				for (int pass = 0; pass <= 1; pass++) {
					label97: for (boolean blocksObf : new boolean[] { false, true }) {
						for (boolean doorObf : new boolean[] { false, true }) {
							for (boolean blockObf : new boolean[] { false, true }) {
								String _blocks = blocksObf ? "ajn" : "net/minecraft/init/Blocks";
								String _door = doorObf ? "field_150466_ao" : "wooden_door";
								FieldInsnNode nodeGetDoor = new FieldInsnNode(178, _blocks, _door, "Lnet/minecraft/block/Block;");
								if (pass == 0) {
									nodeFound1 = findNodeInMethod(method, nodeGetDoor, 0);
									if (nodeFound1 != null) {
										break label97;
									}
								} else if (pass == 1) {
									nodeFound2 = findNodeInMethod(method, nodeGetDoor, 1);
									if (nodeFound2 != null) {
										break label97;
									}
								}
							}
						}
					}
				}
				MethodInsnNode nodeCheckDoor1 = new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$PathFinder", "isWoodenDoor", "(Lnet/minecraft/block/Block;)Z", false);
				method.instructions.set(nodeFound1, nodeCheckDoor1);
				JumpInsnNode nodeIf1 = (JumpInsnNode) nodeCheckDoor1.getNext();
				nodeIf1.setOpcode(153);
				MethodInsnNode nodeCheckDoor2 = new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$PathFinder", "isWoodenDoor", "(Lnet/minecraft/block/Block;)Z", false);
				method.instructions.set(nodeFound2, nodeCheckDoor2);
				JumpInsnNode nodeIf2 = (JumpInsnNode) nodeCheckDoor2.getNext();
				if (nodeIf2.getOpcode() != 165) {
					System.out.println("WARNING! WARNING! THIS OPCODE SHOULD HAVE BEEN IF_ACMPEQ!");
					System.out.println("WARNING! INSTEAD IT WAS " + nodeIf2.getOpcode());
					if (nodeIf2.getOpcode() == 166) {
						System.out.println("WARNING! Opcode is IF_ACMPNE instead of expected IF_ACMPEQ, so setting it to IFEQ instead of IFNE");
						System.out.println("WARNING! Hopefully this works...");
						nodeIf2.setOpcode(153);
					} else {
						System.out.println("WARNING! NOT SURE WHAT TO DO HERE! THINGS MIGHT BREAK!");
					}
				} else {
					nodeIf2.setOpcode(154);
				}
				FieldInsnNode nodeFoundGate = null;
				label95: for (boolean blocksObf : new boolean[] { false, true }) {
					for (boolean gateObf : new boolean[] { false, true }) {
						for (boolean blockObf : new boolean[] { false, true }) {
							String _blocks = blocksObf ? "ajn" : "net/minecraft/init/Blocks";
							String _gate = gateObf ? "field_150396_be" : "fence_gate";
							FieldInsnNode nodeGetGate = new FieldInsnNode(178, _blocks, _gate, "Lnet/minecraft/block/Block;");
							nodeFoundGate = findNodeInMethod(method, nodeGetGate, 0);
							if (nodeFoundGate != null) {
								break label95;
							}
						}
					}
				}
				MethodInsnNode nodeCheckGate = new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$PathFinder", "isFenceGate", "(Lnet/minecraft/block/Block;)Z", false);
				method.instructions.set(nodeFoundGate, nodeCheckGate);
				JumpInsnNode nodeIfGate = (JumpInsnNode) nodeCheckGate.getNext();
				if (nodeIfGate.getOpcode() != 165) {
					System.out.println("WARNING! WARNING! THIS OPCODE SHOULD HAVE BEEN IF_ACMPEQ!");
					System.out.println("WARNING! INSTEAD IT WAS " + nodeIfGate.getOpcode());
					System.out.println("WARNING! NOT SURE WHAT TO DO HERE! THINGS MIGHT BREAK!");
				} else {
					nodeIfGate.setOpcode(154);
				}
				System.out.println("LOTRCore: Patched method " + method.name);
			}
		}
		ClassWriter writer = new ClassWriter(1);
		classNode.accept(writer);
		return writer.toByteArray();
	}

    private byte[] patchDoorInteract(String name, byte[] bytes) {
        String targetMethodName;
        String targetMethodNameObf = targetMethodName = "func_151503_a";
        String targetMethodSign = "(III)Lnet/minecraft/block/BlockDoor;";
        String targetMethodSignObf = "(III)Lakn;";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept((ClassVisitor)classNode, 0);
        for (MethodNode method : classNode.methods) {
            if (!method.name.equals(targetMethodName) && !method.name.equals(targetMethodNameObf) || !method.desc.equals(targetMethodSign) && !method.desc.equals(targetMethodSignObf)) continue;
            FieldInsnNode nodeFound = null;
            block1: for (boolean blocksObf : new boolean[]{false, true}) {
                for (boolean doorObf : new boolean[]{false, true}) {
                    for (boolean blockObf : new boolean[]{false, true}) {
                        String _blocks = blocksObf ? cls_Blocks_obf : cls_Blocks;
                        String _door = doorObf ? "field_150466_ao" : "wooden_door";
                        String _block = blockObf ? cls_Block_obf : cls_Block;
                        FieldInsnNode nodeGetDoor = new FieldInsnNode(178, _blocks, _door, "Lnet/minecraft/block/Block;");
                        nodeFound = LOTRClassTransformer.findNodeInMethod(method, nodeGetDoor);
                        if (nodeFound != null) break block1;
                    }
                }
            }
            MethodInsnNode nodeCheckDoor = new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$PathFinder", "isWoodenDoor", "(Lnet/minecraft/block/Block;)Z", false);
            method.instructions.set(nodeFound, (AbstractInsnNode)nodeCheckDoor);
            JumpInsnNode nodeIf = (JumpInsnNode)nodeCheckDoor.getNext();
            if (nodeIf.getOpcode() != 165) {
                System.out.println("WARNING! WARNING! THIS OPCODE SHOULD HAVE BEEN IF_ACMPEQ!");
                System.out.println("WARNING! INSTEAD IT WAS " + nodeIf.getOpcode());
                System.out.println("WARNING! Setting it to IF_NE anyway");
            }
            nodeIf.setOpcode(154);
            System.out.println("LOTRCore: Patched method " + method.name);
        }
        ClassWriter writer = new ClassWriter(1);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] patchEnchantmentHelper(String name, byte[] bytes) {
        String targetMethodName2;
        String targetMethodName = "getEnchantmentModifierLiving";
        String targetMethodNameObf = "func_77512_a";
        String targetMethodSign = "(Lnet/minecraft/entity/EntityLivingBase;Lnet/minecraft/entity/EntityLivingBase;)F";
        String targetMethodSignObf = "(Lsv;Lsv;)F";
        String targetMethodNameObf2 = targetMethodName2 = "func_152377_a";
        String targetMethodSign2 = "(Lnet/minecraft/item/ItemStack;Lnet/minecraft/entity/EnumCreatureAttribute;)F";
        String targetMethodSignObf2 = "(Ladd;Lsz;)F";
        String targetMethodName3 = "getSilkTouchModifier";
        String targetMethodNameObf3 = "func_77502_d";
        String targetMethodSign3 = "(Lnet/minecraft/entity/EntityLivingBase;)Z";
        String targetMethodSignObf3 = "(Lsv;)Z";
        String targetMethodName4 = "getKnockbackModifier";
        String targetMethodNameObf4 = "func_77507_b";
        String targetMethodSign4 = "(Lnet/minecraft/entity/EntityLivingBase;Lnet/minecraft/entity/EntityLivingBase;)I";
        String targetMethodSignObf4 = "(Lsv;Lsv;)I";
        String targetMethodName5 = "getFortuneModifier";
        String targetMethodNameObf5 = "func_77517_e";
        String targetMethodSign5 = "(Lnet/minecraft/entity/EntityLivingBase;)I";
        String targetMethodSignObf5 = "(Lsv;)I";
        String targetMethodName6 = "getLootingModifier";
        String targetMethodNameObf6 = "func_77519_f";
        String targetMethodSign6 = "(Lnet/minecraft/entity/EntityLivingBase;)I";
        String targetMethodSignObf6 = "(Lsv;)I";
        String targetMethodName7 = "getEnchantmentModifierDamage";
        String targetMethodNameObf7 = "func_77508_a";
        String targetMethodSign7 = "([Lnet/minecraft/item/ItemStack;Lnet/minecraft/util/DamageSource;)I";
        String targetMethodSignObf7 = "([Ladd;Lro;)I";
        String targetMethodName8 = "getFireAspectModifier";
        String targetMethodNameObf8 = "func_90036_a";
        String targetMethodSign8 = "(Lnet/minecraft/entity/EntityLivingBase;)I";
        String targetMethodSignObf8 = "(Lsv;)I";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept((ClassVisitor)classNode, 0);
        for (MethodNode method : classNode.methods) {
            InsnNode nodeReturn;
            InsnList extraIns;
            if ((method.name.equals(targetMethodName) || method.name.equals(targetMethodNameObf)) && (method.desc.equals(targetMethodSign) || method.desc.equals(targetMethodSignObf))) {
                nodeReturn = LOTRClassTransformer.findNodeInMethod(method, new InsnNode(174));
                extraIns = new InsnList();
                extraIns.add((AbstractInsnNode)new VarInsnNode(25, 0));
                extraIns.add((AbstractInsnNode)new VarInsnNode(25, 1));
                extraIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Enchants", "getEnchantmentModifierLiving", "(FLnet/minecraft/entity/EntityLivingBase;Lnet/minecraft/entity/EntityLivingBase;)F", false));
                method.instructions.insertBefore((AbstractInsnNode)nodeReturn, extraIns);
                System.out.println("LOTRCore: Patched method " + method.name);
            }
            if ((method.name.equals(targetMethodName2) || method.name.equals(targetMethodNameObf2)) && (method.desc.equals(targetMethodSign2) || method.desc.equals(targetMethodSignObf2))) {
                nodeReturn = LOTRClassTransformer.findNodeInMethod(method, new InsnNode(174));
                extraIns = new InsnList();
                extraIns.add((AbstractInsnNode)new VarInsnNode(25, 0));
                extraIns.add((AbstractInsnNode)new VarInsnNode(25, 1));
                extraIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Enchants", "func_152377_a", "(FLnet/minecraft/item/ItemStack;Lnet/minecraft/entity/EnumCreatureAttribute;)F", false));
                method.instructions.insertBefore((AbstractInsnNode)nodeReturn, extraIns);
                System.out.println("LOTRCore: Patched method " + method.name);
            }
            if ((method.name.equals(targetMethodName3) || method.name.equals(targetMethodNameObf3)) && (method.desc.equals(targetMethodSign3) || method.desc.equals(targetMethodSignObf3))) {
                nodeReturn = LOTRClassTransformer.findNodeInMethod(method, new InsnNode(172));
                extraIns = new InsnList();
                extraIns.add((AbstractInsnNode)new VarInsnNode(25, 0));
                extraIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Enchants", "getSilkTouchModifier", "(ZLnet/minecraft/entity/EntityLivingBase;)Z", false));
                method.instructions.insertBefore((AbstractInsnNode)nodeReturn, extraIns);
                System.out.println("LOTRCore: Patched method " + method.name);
            }
            if ((method.name.equals(targetMethodName4) || method.name.equals(targetMethodNameObf4)) && (method.desc.equals(targetMethodSign4) || method.desc.equals(targetMethodSignObf4))) {
                nodeReturn = LOTRClassTransformer.findNodeInMethod(method, new InsnNode(172));
                extraIns = new InsnList();
                extraIns.add((AbstractInsnNode)new VarInsnNode(25, 0));
                extraIns.add((AbstractInsnNode)new VarInsnNode(25, 1));
                extraIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Enchants", "getKnockbackModifier", "(ILnet/minecraft/entity/EntityLivingBase;Lnet/minecraft/entity/EntityLivingBase;)I", false));
                method.instructions.insertBefore((AbstractInsnNode)nodeReturn, extraIns);
                System.out.println("LOTRCore: Patched method " + method.name);
            }
            if ((method.name.equals(targetMethodName5) || method.name.equals(targetMethodNameObf5)) && (method.desc.equals(targetMethodSign5) || method.desc.equals(targetMethodSignObf5))) {
                nodeReturn = LOTRClassTransformer.findNodeInMethod(method, new InsnNode(172));
                extraIns = new InsnList();
                extraIns.add((AbstractInsnNode)new VarInsnNode(25, 0));
                extraIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Enchants", "getFortuneModifier", "(ILnet/minecraft/entity/EntityLivingBase;)I", false));
                method.instructions.insertBefore((AbstractInsnNode)nodeReturn, extraIns);
                System.out.println("LOTRCore: Patched method " + method.name);
            }
            if ((method.name.equals(targetMethodName6) || method.name.equals(targetMethodNameObf6)) && (method.desc.equals(targetMethodSign6) || method.desc.equals(targetMethodSignObf6))) {
                nodeReturn = LOTRClassTransformer.findNodeInMethod(method, new InsnNode(172));
                extraIns = new InsnList();
                extraIns.add((AbstractInsnNode)new VarInsnNode(25, 0));
                extraIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Enchants", "getLootingModifier", "(ILnet/minecraft/entity/EntityLivingBase;)I", false));
                method.instructions.insertBefore((AbstractInsnNode)nodeReturn, extraIns);
                System.out.println("LOTRCore: Patched method " + method.name);
            }
            if ((method.name.equals(targetMethodName7) || method.name.equals(targetMethodNameObf7)) && (method.desc.equals(targetMethodSign7) || method.desc.equals(targetMethodSignObf7))) {
                nodeReturn = LOTRClassTransformer.findNodeInMethod(method, new InsnNode(172));
                extraIns = new InsnList();
                extraIns.add((AbstractInsnNode)new VarInsnNode(25, 0));
                extraIns.add((AbstractInsnNode)new VarInsnNode(25, 1));
                extraIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Enchants", "getSpecialArmorProtection", "(I[Lnet/minecraft/item/ItemStack;Lnet/minecraft/util/DamageSource;)I", false));
                method.instructions.insertBefore((AbstractInsnNode)nodeReturn, extraIns);
                System.out.println("LOTRCore: Patched method " + method.name);
            }
            if (!method.name.equals(targetMethodName8) && !method.name.equals(targetMethodNameObf8) || !method.desc.equals(targetMethodSign8) && !method.desc.equals(targetMethodSignObf8)) continue;
            nodeReturn = LOTRClassTransformer.findNodeInMethod(method, new InsnNode(172));
            extraIns = new InsnList();
            extraIns.add((AbstractInsnNode)new VarInsnNode(25, 0));
            extraIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Enchants", "getFireAspectModifier", "(ILnet/minecraft/entity/EntityLivingBase;)I", false));
            method.instructions.insertBefore((AbstractInsnNode)nodeReturn, extraIns);
            System.out.println("LOTRCore: Patched method " + method.name);
        }
        ClassWriter writer = new ClassWriter(1);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] patchItemStack(String name, byte[] bytes) {
		boolean isCauldron = LOTRModChecker.isCauldronServer();
		String targetMethodName = "attemptDamageItem";
		String targetMethodNameObf = "func_96631_a";
		String targetMethodSign = "(ILjava/util/Random;)Z";
		String targetMethodSignObf = targetMethodSign;
		if (isCauldron) {
			targetMethodName = targetMethodNameObf = "isDamaged";
			targetMethodSign = "(ILjava/util/Random;Lnet/minecraft/entity/EntityLivingBase;)Z";
			targetMethodSignObf = "(ILjava/util/Random;Lsv;)Z";
		}
		ClassNode classNode = new ClassNode();
		ClassReader classReader = new ClassReader(bytes);
		classReader.accept(classNode, 0);
		for (MethodNode method : classNode.methods) {
			if ((method.name.equals(targetMethodName) || method.name.equals(targetMethodNameObf)) && (method.desc.equals(targetMethodSign) || method.desc.equals(targetMethodSignObf))) {
				if (!isCauldron) {
					method.instructions.clear();
					InsnList newIns = new InsnList();
					newIns.add(new VarInsnNode(25, 0));
					newIns.add(new VarInsnNode(21, 1));
					newIns.add(new VarInsnNode(25, 2));
					newIns.add(new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Enchants", "attemptDamageItem", "(Lnet/minecraft/item/ItemStack;ILjava/util/Random;)Z", false));
					newIns.add(new InsnNode(172));
					method.instructions.insert(newIns);
					System.out.println("LOTRCore: Patched method " + method.name);
					continue;
				}
				for (AbstractInsnNode n : method.instructions.toArray()) {
					if (n.getOpcode() == 100) {
						InsnList insns = new InsnList();
						insns.add(new VarInsnNode(25, 0));
						insns.add(new VarInsnNode(21, 1));
						insns.add(new VarInsnNode(25, 2));
						insns.add(new VarInsnNode(25, 3));
						insns.add(new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Enchants", "c_attemptDamageItem", "(ILnet/minecraft/item/ItemStack;ILjava/util/Random;Lnet/minecraft/entity/EntityLivingBase;)I", false));
						method.instructions.insert(n, insns);
						System.out.println("LOTRCore: Patched method " + method.name + " for Cauldron");
					}
				}
			}
		}
		ClassWriter writer = new ClassWriter(1);
		classNode.accept(writer);
		return writer.toByteArray();
	}

    private byte[] patchEnchantmentProtection(String name, byte[] bytes) {
        String targetMethodName = "getFireTimeForEntity";
        String targetMethodNameObf = "func_92093_a";
        String targetMethodSign = "(Lnet/minecraft/entity/Entity;I)I";
        String targetMethodSignObf = "(Lsa;I)I";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept((ClassVisitor)classNode, 0);
        for (MethodNode method : classNode.methods) {
            if (!method.name.equals(targetMethodName) && !method.name.equals(targetMethodNameObf) || !method.desc.equals(targetMethodSign) && !method.desc.equals(targetMethodSignObf)) continue;
            VarInsnNode nodeIStore = LOTRClassTransformer.findNodeInMethod(method, new VarInsnNode(54, 2));
            InsnList newIns = new InsnList();
            newIns.add((AbstractInsnNode)new VarInsnNode(25, 0));
            newIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Enchants", "getMaxFireProtectionLevel", "(ILnet/minecraft/entity/Entity;)I", false));
            method.instructions.insertBefore((AbstractInsnNode)nodeIStore, newIns);
            System.out.println("LOTRCore: Patched method " + method.name);
        }
        ClassWriter writer = new ClassWriter(1);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] patchPotionDamage(String name, byte[] bytes) {
        String targetMethodName;
        String targetMethodNameObf = targetMethodName = "func_111183_a";
        String targetMethodSign = "(ILnet/minecraft/entity/ai/attributes/AttributeModifier;)D";
        String targetMethodSignObf = "(ILtj;)D";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept((ClassVisitor)classNode, 0);
        for (MethodNode method : classNode.methods) {
            if (!method.name.equals(targetMethodName) && !method.name.equals(targetMethodNameObf) || !method.desc.equals(targetMethodSign) && !method.desc.equals(targetMethodSignObf)) continue;
            method.instructions.clear();
            InsnList newIns = new InsnList();
            newIns.add((AbstractInsnNode)new VarInsnNode(25, 0));
            newIns.add((AbstractInsnNode)new VarInsnNode(21, 1));
            newIns.add((AbstractInsnNode)new VarInsnNode(25, 2));
            newIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$Potions", "getStrengthModifier", "(Lnet/minecraft/potion/Potion;ILnet/minecraft/entity/ai/attributes/AttributeModifier;)D", false));
            newIns.add((AbstractInsnNode)new InsnNode(175));
            method.instructions.insert(newIns);
            System.out.println("LOTRCore: Patched method " + method.name);
        }
        ClassWriter writer = new ClassWriter(1);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] patchRenderBlocks(String name, byte[] bytes) {
        try {
            String s = this.getClass().getPackage().getName() + ".RandomTexturePatchCheck";
            Class<?> enableClass = Class.forName(s);
            if (enableClass == null) {
                return bytes;
            }
        }
        catch (ClassNotFoundException e) {
            return bytes;
        }
        String targetMethodName = "renderBlockByRenderType";
        String targetMethodNameObf = "func_147805_b";
        String targetMethodSign = "(Lnet/minecraft/block/Block;III)Z";
        String targetMethodSignObf = "(Laji;III)Z";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept((ClassVisitor)classNode, 0);
        for (MethodNode method : classNode.methods) {
            if (!method.name.equals(targetMethodName) && !method.name.equals(targetMethodNameObf) || !method.desc.equals(targetMethodSign) && !method.desc.equals(targetMethodSignObf)) continue;
            MethodInsnNode nodeFound = null;
            block3: for (boolean rbObf : new boolean[]{false, true}) {
                for (boolean renderObf : new boolean[]{false, true}) {
                    for (boolean blockObf : new boolean[]{false, true}) {
                        String _rb = rbObf ? cls_RenderBlocks_obf : cls_RenderBlocks;
                        String _render = renderObf ? "func_147784_q" : "renderStandardBlock";
                        String _block = blockObf ? cls_Block_obf : cls_Block;
                        MethodInsnNode nodeRender = new MethodInsnNode(182, _rb, _render, "(L" + _block + ";III)Z", false);
                        nodeFound = LOTRClassTransformer.findNodeInMethod(method, nodeRender);
                        if (nodeFound != null) break block3;
                    }
                }
            }
            MethodInsnNode nodeRSB = new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$BlockRendering", "renderStandardBlock", "(Lnet/minecraft/client/renderer/RenderBlocks;Lnet/minecraft/block/Block;III)Z", false);
            method.instructions.set(nodeFound, (AbstractInsnNode)nodeRSB);
            System.out.println("LOTRCore: Patched method " + method.name);
        }
        ClassWriter writer = new ClassWriter(1);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] patchEntityClientPlayerMP(String name, byte[] bytes) {
        String targetMethodName;
        String targetMethodNameObf = targetMethodName = "func_110318_g";
        String targetMethodSign = "()V";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept((ClassVisitor)classNode, 0);
        for (MethodNode method : classNode.methods) {
            if (!method.name.equals(targetMethodName) && !method.name.equals(targetMethodNameObf) || !method.desc.equals(targetMethodSign)) continue;
            method.instructions.clear();
            InsnList newIns = new InsnList();
            newIns.add((AbstractInsnNode)new VarInsnNode(25, 0));
            newIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$ClientPlayer", "horseJump", "(Lnet/minecraft/client/entity/EntityClientPlayerMP;)V", false));
            newIns.add((AbstractInsnNode)new InsnNode(177));
            method.instructions.insert(newIns);
            System.out.println("LOTRCore: Patched method " + method.name);
        }
        ClassWriter writer = new ClassWriter(1);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] patchNetHandlerClient(String name, byte[] bytes) {
        String targetMethodName = "handleEntityTeleport";
        String targetMethodNameObf = "func_147275_a";
        String targetMethodSign = "(Lnet/minecraft/network/play/server/S18PacketEntityTeleport;)V";
        String targetMethodSignObf = "(Lik;)V";
        String targetMethodName2 = "handleEntityMovement";
        String targetMethodNameObf2 = "func_147259_a";
        String targetMethodSign2 = "(Lnet/minecraft/network/play/server/S14PacketEntity;)V";
        String targetMethodSignObf2 = "(Lhf;)V";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept((ClassVisitor)classNode, 0);
        for (MethodNode method : classNode.methods) {
            InsnList newIns;
            if ((method.name.equals(targetMethodName) || method.name.equals(targetMethodNameObf)) && (method.desc.equals(targetMethodSign) || method.desc.equals(targetMethodSignObf))) {
                method.instructions.clear();
                newIns = new InsnList();
                newIns.add((AbstractInsnNode)new VarInsnNode(25, 0));
                newIns.add((AbstractInsnNode)new VarInsnNode(25, 1));
                newIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$NetHandlerClient", "handleEntityTeleport", "(Lnet/minecraft/client/network/NetHandlerPlayClient;Lnet/minecraft/network/play/server/S18PacketEntityTeleport;)V", false));
                newIns.add((AbstractInsnNode)new InsnNode(177));
                method.instructions.insert(newIns);
                System.out.println("LOTRCore: Patched method " + method.name);
            }
            if (!method.name.equals(targetMethodName2) && !method.name.equals(targetMethodNameObf2) || !method.desc.equals(targetMethodSign2) && !method.desc.equals(targetMethodSignObf2)) continue;
            method.instructions.clear();
            newIns = new InsnList();
            newIns.add((AbstractInsnNode)new VarInsnNode(25, 0));
            newIns.add((AbstractInsnNode)new VarInsnNode(25, 1));
            newIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$NetHandlerClient", "handleEntityMovement", "(Lnet/minecraft/client/network/NetHandlerPlayClient;Lnet/minecraft/network/play/server/S14PacketEntity;)V", false));
            newIns.add((AbstractInsnNode)new InsnNode(177));
            method.instructions.insert(newIns);
            System.out.println("LOTRCore: Patched method " + method.name);
        }
        ClassWriter writer = new ClassWriter(1);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] patchFMLNetworkHandler(String name, byte[] bytes) {
        String targetMethodName;
        String targetMethodNameObf = targetMethodName = "getEntitySpawningPacket";
        String targetMethodSign = "(Lnet/minecraft/entity/Entity;)Lnet/minecraft/network/Packet;";
        String targetMethodSignObf = "(Lsa;)Lft;";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept((ClassVisitor)classNode, 0);
        for (MethodNode method : classNode.methods) {
            if (!method.name.equals(targetMethodName) && !method.name.equals(targetMethodNameObf) || !method.desc.equals(targetMethodSign) && !method.desc.equals(targetMethodSignObf)) continue;
            method.instructions.clear();
            InsnList newIns = new InsnList();
            newIns.add((AbstractInsnNode)new VarInsnNode(25, 0));
            newIns.add((AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRReplacedMethods$EntityPackets", "getMobSpawnPacket", "(Lnet/minecraft/entity/Entity;)Lnet/minecraft/network/Packet;", false));
            newIns.add((AbstractInsnNode)new InsnNode(176));
            method.instructions.insert(newIns);
            System.out.println("LOTRCore: Patched method " + method.name);
        }
        ClassWriter writer = new ClassWriter(1);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] patchAnvilChunkLoader(String name, byte[] bytes) {
        String targetMethodName;
        String targetMethodNameObf = targetMethodName = "loadChunk__Async";
        String targetMethodSign = "(Lnet/minecraft/world/World;II)[Ljava/lang/Object;";
        String targetMethodSignObf = "(Lahb;II)[Ljava/lang/Object;";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept((ClassVisitor)classNode, 0);
        for (MethodNode method : classNode.methods) {
            if (!method.name.equals(targetMethodName) && !method.name.equals(targetMethodNameObf) || !method.desc.equals(targetMethodSign) && !method.desc.equals(targetMethodSignObf)) continue;
            AbstractInsnNode methodNod = null;
            for (AbstractInsnNode nod : method.instructions.toArray()) {
                if (!(nod instanceof MethodInsnNode) || nod.getOpcode() != 184 || !((MethodInsnNode)nod).owner.equals("net/minecraft/nbt/CompressedStreamTools")) continue;
                methodNod = nod;
                break;
            }
            method.instructions.insertBefore(methodNod, (AbstractInsnNode)new VarInsnNode(21, 2));
            method.instructions.insertBefore(methodNod, (AbstractInsnNode)new VarInsnNode(21, 3));
            method.instructions.set(methodNod, (AbstractInsnNode)new MethodInsnNode(184, "lotr/common/coremod/LOTRClassTransformer", "doDebug", "(Ljava/io/DataInputStream;II)Lnet/minecraft/nbt/NBTTagCompound;", false));
            System.out.println("LOTRCore: Patched method " + method.name);
        }
        ClassWriter writer = new ClassWriter(1);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    public static NBTTagCompound doDebug(DataInputStream stream, int i, int k) {
        try {
            return CompressedStreamTools.read((DataInputStream)stream);
        }
        catch (Exception e) {
            System.out.println("Error loading chunk: " + i + ", " + k);
            e.printStackTrace();
            return new NBTTagCompound();
        }
    }

    private static <N extends AbstractInsnNode> N findNodeInMethod(MethodNode method, N target) {
        return LOTRClassTransformer.findNodeInMethod(method, target, 0);
    }

    private static <N extends AbstractInsnNode> N findNodeInMethod(MethodNode method, N targetAbstract, int skip) {
		int skipped = 0;
		Iterator<AbstractInsnNode> it = method.instructions.iterator();
		while (it.hasNext()) {
			AbstractInsnNode nextAbstract = it.next();
			boolean matched = false;
			if (nextAbstract.getClass() == targetAbstract.getClass()) {
				if (targetAbstract.getClass() == InsnNode.class) {
					InsnNode next = (InsnNode) nextAbstract;
					InsnNode target = (InsnNode) targetAbstract;
					if (next.getOpcode() == target.getOpcode()) {
						matched = true;
					}
				} else if (targetAbstract.getClass() == VarInsnNode.class) {
					VarInsnNode next = (VarInsnNode) nextAbstract;
					VarInsnNode target = (VarInsnNode) targetAbstract;
					if (next.getOpcode() == target.getOpcode() && next.var == target.var) {
						matched = true;
					}
				} else if (targetAbstract.getClass() == LdcInsnNode.class) {
					LdcInsnNode next = (LdcInsnNode) nextAbstract;
					LdcInsnNode target = (LdcInsnNode) targetAbstract;
					if (next.cst.equals(target.cst)) {
						matched = true;
					}
				} else if (targetAbstract.getClass() == TypeInsnNode.class) {
					TypeInsnNode next = (TypeInsnNode) nextAbstract;
					TypeInsnNode target = (TypeInsnNode) targetAbstract;
					if (next.getOpcode() == target.getOpcode() && next.desc.equals(target.desc)) {
						matched = true;
					}
				} else if (targetAbstract.getClass() == FieldInsnNode.class) {
					FieldInsnNode next = (FieldInsnNode) nextAbstract;
					FieldInsnNode target = (FieldInsnNode) targetAbstract;
					if (next.getOpcode() == target.getOpcode() && next.owner.equals(target.owner) && next.name.equals(target.name) && next.desc.equals(target.desc)) {
						matched = true;
					}
				} else if (targetAbstract.getClass() == MethodInsnNode.class) {
					MethodInsnNode next = (MethodInsnNode) nextAbstract;
					MethodInsnNode target = (MethodInsnNode) targetAbstract;
					if (next.getOpcode() == target.getOpcode() && next.owner.equals(target.owner) && next.name.equals(target.name) && next.desc.equals(target.desc) && next.itf == target.itf) {
						matched = true;
					}
				}
			}
			if (matched) {
				if (skipped >= skip) {
					return (N) nextAbstract;
				}
				skipped++;
			}
		}
		return null;
	}
}

