/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.registry.GameRegistry
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockBush
 *  net.minecraft.block.BlockColored
 *  net.minecraft.block.BlockDoublePlant
 *  net.minecraft.block.BlockLeaves
 *  net.minecraft.block.BlockSand
 *  net.minecraft.block.BlockSlab
 *  net.minecraft.block.BlockStainedGlass
 *  net.minecraft.block.material.Material
 *  net.minecraft.entity.passive.EntitySheep
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.InventoryCrafting
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.crafting.CraftingManager
 *  net.minecraft.item.crafting.FurnaceRecipes
 *  net.minecraft.item.crafting.IRecipe
 *  net.minecraft.item.crafting.RecipesArmorDyes
 *  net.minecraft.util.RegistryNamespaced
 *  net.minecraft.world.World
 *  net.minecraftforge.oredict.OreDictionary
 *  net.minecraftforge.oredict.RecipeSorter
 *  net.minecraftforge.oredict.RecipeSorter$Category
 *  net.minecraftforge.oredict.ShapedOreRecipe
 *  net.minecraftforge.oredict.ShapelessOreRecipe
 */
package lotr.common.recipe;

import cpw.mods.fml.common.registry.GameRegistry;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import lotr.common.LOTRConfig;
import lotr.common.LOTRMod;
import lotr.common.block.LOTRBlockFallenLeaves;
import lotr.common.block.LOTRBlockLeavesBase;
import lotr.common.block.LOTRBlockPlanksBase;
import lotr.common.block.LOTRBlockSaplingBase;
import lotr.common.block.LOTRBlockSlabBase;
import lotr.common.block.LOTRBlockStairs;
import lotr.common.block.LOTRBlockTreasurePile;
import lotr.common.block.LOTRBlockWoodBase;
import lotr.common.item.LOTRItemBanner;
import lotr.common.item.LOTRItemBerry;
import lotr.common.item.LOTRItemBone;
import lotr.common.item.LOTRItemDaleCracker;
import lotr.common.item.LOTRItemHaradRobes;
import lotr.common.item.LOTRMaterial;
import lotr.common.recipe.LOTRRecipeFeatherDye;
import lotr.common.recipe.LOTRRecipeHaradRobesDye;
import lotr.common.recipe.LOTRRecipeHaradTurbanOrnament;
import lotr.common.recipe.LOTRRecipeHobbitPipe;
import lotr.common.recipe.LOTRRecipeLeatherHatDye;
import lotr.common.recipe.LOTRRecipeLeatherHatFeather;
import lotr.common.recipe.LOTRRecipePartyHatDye;
import lotr.common.recipe.LOTRRecipePoisonWeapon;
import lotr.common.recipe.LOTRRecipesArmorDyes;
import lotr.common.recipe.LOTRRecipesBanners;
import lotr.common.recipe.LOTRRecipesPoisonDrinks;
import lotr.common.recipe.LOTRRecipesPouch;
import lotr.common.recipe.LOTRRecipesTreasurePile;
import lotr.common.recipe.LOTRVesselRecipes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.material.Material;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.RecipesArmorDyes;
import net.minecraft.util.RegistryNamespaced;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class LOTRRecipes {
    public static List<IRecipe> woodenSlabRecipes = new ArrayList<IRecipe>();
    public static List<IRecipe> morgulRecipes = new ArrayList<IRecipe>();
    public static List<IRecipe> elvenRecipes = new ArrayList<IRecipe>();
    public static List<IRecipe> dwarvenRecipes = new ArrayList<IRecipe>();
    public static List<IRecipe> urukRecipes = new ArrayList<IRecipe>();
    public static List<IRecipe> woodElvenRecipes = new ArrayList<IRecipe>();
    public static List<IRecipe> gondorianRecipes = new ArrayList<IRecipe>();
    public static List<IRecipe> rohirricRecipes = new ArrayList<IRecipe>();
    public static List<IRecipe> dunlendingRecipes = new ArrayList<IRecipe>();
    public static List<IRecipe> angmarRecipes = new ArrayList<IRecipe>();
    public static List<IRecipe> nearHaradRecipes = new ArrayList<IRecipe>();
    public static List<IRecipe> highElvenRecipes = new ArrayList<IRecipe>();
    public static List<IRecipe> blueMountainsRecipes = new ArrayList<IRecipe>();
    public static List<IRecipe> rangerRecipes = new ArrayList<IRecipe>();
    public static List<IRecipe> dolGuldurRecipes = new ArrayList<IRecipe>();
    public static List<IRecipe> gundabadRecipes = new ArrayList<IRecipe>();
    public static List<IRecipe> halfTrollRecipes = new ArrayList<IRecipe>();
    public static List<IRecipe> dolAmrothRecipes = new ArrayList<IRecipe>();
    public static List<IRecipe> moredainRecipes = new ArrayList<IRecipe>();
    public static List<IRecipe> tauredainRecipes = new ArrayList<IRecipe>();
    public static List<IRecipe> daleRecipes = new ArrayList<IRecipe>();
    public static List<IRecipe> dorwinionRecipes = new ArrayList<IRecipe>();
    public static List<IRecipe> hobbitRecipes = new ArrayList<IRecipe>();
    public static List<IRecipe> rhunRecipes = new ArrayList<IRecipe>();
    public static List<IRecipe> rivendellRecipes = new ArrayList<IRecipe>();
    public static List<IRecipe> umbarRecipes = new ArrayList<IRecipe>();
    public static List<IRecipe> gulfRecipes = new ArrayList<IRecipe>();
    public static List<IRecipe> breeRecipes = new ArrayList<IRecipe>();
    public static List<IRecipe> uncraftableUnsmeltingRecipes = new ArrayList<IRecipe>();
    private static List[] commonOrcRecipes = new List[]{morgulRecipes, urukRecipes, angmarRecipes, dolGuldurRecipes, gundabadRecipes, halfTrollRecipes};
    private static List[] commonMorgulRecipes = new List[]{morgulRecipes, angmarRecipes, dolGuldurRecipes};
    private static List[] commonMorgulAndGundabadRecipes = new List[]{morgulRecipes, angmarRecipes, dolGuldurRecipes, gundabadRecipes};
    private static List[] commonElfRecipes = new List[]{elvenRecipes, woodElvenRecipes, highElvenRecipes, rivendellRecipes};
    private static List[] commonHighElfRecipes = new List[]{highElvenRecipes, rivendellRecipes};
    private static List[] commonDwarfRecipes = new List[]{dwarvenRecipes, blueMountainsRecipes};
    private static List[] commonDunedainRecipes = new List[]{gondorianRecipes, rangerRecipes, dolAmrothRecipes};
    private static List[] commonNumenoreanRecipes = new List[]{gondorianRecipes, dolAmrothRecipes, umbarRecipes};
    private static List[] commonNearHaradRecipes = new List[]{nearHaradRecipes, umbarRecipes, gulfRecipes};
    private static List[] commonHobbitRecipes = new List[]{hobbitRecipes, breeRecipes};
    private static final String[] dyeOreNames = new String[]{"dyeBlack", "dyeRed", "dyeGreen", "dyeBrown", "dyeBlue", "dyePurple", "dyeCyan", "dyeLightGray", "dyeGray", "dyePink", "dyeLime", "dyeYellow", "dyeLightBlue", "dyeMagenta", "dyeOrange", "dyeWhite"};

    public static void createAllRecipes() {
        LOTRRecipes.registerOres();
        RecipeSorter.register((String)"lotr:armorDyes", LOTRRecipesArmorDyes.class, (RecipeSorter.Category)RecipeSorter.Category.SHAPELESS, (String)"after:minecraft:shapeless");
        RecipeSorter.register((String)"lotr:hobbitPipe", LOTRRecipeHobbitPipe.class, (RecipeSorter.Category)RecipeSorter.Category.SHAPELESS, (String)"after:minecraft:shapeless");
        RecipeSorter.register((String)"lotr:pouch", LOTRRecipesPouch.class, (RecipeSorter.Category)RecipeSorter.Category.SHAPELESS, (String)"after:minecraft:shapeless");
        RecipeSorter.register((String)"lotr:leatherHatDye", LOTRRecipeLeatherHatDye.class, (RecipeSorter.Category)RecipeSorter.Category.SHAPELESS, (String)"after:minecraft:shapeless");
        RecipeSorter.register((String)"lotr:featherDye", LOTRRecipeFeatherDye.class, (RecipeSorter.Category)RecipeSorter.Category.SHAPELESS, (String)"after:minecraft:shapeless");
        RecipeSorter.register((String)"lotr:leatherHatFeather", LOTRRecipeLeatherHatFeather.class, (RecipeSorter.Category)RecipeSorter.Category.SHAPELESS, (String)"after:minecraft:shapeless");
        RecipeSorter.register((String)"lotr:haradRobesDye", LOTRRecipeHaradRobesDye.class, (RecipeSorter.Category)RecipeSorter.Category.SHAPELESS, (String)"after:minecraft:shapeless");
        RecipeSorter.register((String)"lotr:poisonWeapon", LOTRRecipePoisonWeapon.class, (RecipeSorter.Category)RecipeSorter.Category.SHAPELESS, (String)"after:minecraft:shapeless");
        RecipeSorter.register((String)"lotr:banners", LOTRRecipesBanners.class, (RecipeSorter.Category)RecipeSorter.Category.SHAPELESS, (String)"after:minecraft:shapeless");
        RecipeSorter.register((String)"lotr:poisonDrink", LOTRRecipesPoisonDrinks.class, (RecipeSorter.Category)RecipeSorter.Category.SHAPELESS, (String)"after:minecraft:shapeless");
        RecipeSorter.register((String)"lotr:treasurePile", LOTRRecipesTreasurePile.class, (RecipeSorter.Category)RecipeSorter.Category.SHAPELESS, (String)"after:minecraft:shapeless");
        RecipeSorter.register((String)"lotr:partyHatDye", LOTRRecipePartyHatDye.class, (RecipeSorter.Category)RecipeSorter.Category.SHAPELESS, (String)"after:minecraft:shapeless");
        LOTRRecipes.modifyStandardRecipes();
        LOTRRecipes.createStandardRecipes();
        LOTRRecipes.createPoisonedDaggerRecipes();
        LOTRRecipes.createPoisonedArrowRecipes();
        LOTRRecipes.createWoodenSlabRecipes();
        CraftingManager.getInstance().getRecipeList().addAll(0, woodenSlabRecipes);
        LOTRRecipes.createSmeltingRecipes();
        LOTRRecipes.createCommonOrcRecipes();
        LOTRRecipes.createCommonMorgulRecipes();
        LOTRRecipes.createCommonMorgulAndGundabadRecipes();
        LOTRRecipes.createCommonElfRecipes();
        LOTRRecipes.createCommonHighElfRecipes();
        LOTRRecipes.createCommonDwarfRecipes();
        LOTRRecipes.createCommonDunedainRecipes();
        LOTRRecipes.createCommonNumenoreanRecipes();
        LOTRRecipes.createCommonNearHaradRecipes();
        LOTRRecipes.createCommonHobbitRecipes();
        LOTRRecipes.createMorgulRecipes();
        LOTRRecipes.createElvenRecipes();
        LOTRRecipes.createDwarvenRecipes();
        LOTRRecipes.createUrukRecipes();
        LOTRRecipes.createWoodElvenRecipes();
        LOTRRecipes.createGondorianRecipes();
        LOTRRecipes.createRohirricRecipes();
        LOTRRecipes.createDunlendingRecipes();
        LOTRRecipes.createAngmarRecipes();
        LOTRRecipes.createNearHaradRecipes();
        LOTRRecipes.createHighElvenRecipes();
        LOTRRecipes.createBlueMountainsRecipes();
        LOTRRecipes.createRangerRecipes();
        LOTRRecipes.createDolGuldurRecipes();
        LOTRRecipes.createGundabadRecipes();
        LOTRRecipes.createHalfTrollRecipes();
        LOTRRecipes.createDolAmrothRecipes();
        LOTRRecipes.createMoredainRecipes();
        LOTRRecipes.createTauredainRecipes();
        LOTRRecipes.createDaleRecipes();
        LOTRRecipes.createDorwinionRecipes();
        LOTRRecipes.createHobbitRecipes();
        LOTRRecipes.createRhunRecipes();
        LOTRRecipes.createRivendellRecipes();
        LOTRRecipes.createUmbarRecipes();
        LOTRRecipes.createGulfRecipes();
        LOTRRecipes.createBreeRecipes();
        LOTRRecipes.createUnsmeltingRecipes();
    }

    private static void registerOres() {
        for (Object obj : Block.blockRegistry) {
            Block block = (Block)obj;
            if (block instanceof LOTRBlockPlanksBase) {
                OreDictionary.registerOre((String)"plankWood", (ItemStack)new ItemStack(block, 1, 32767));
            }
            if (block instanceof LOTRBlockSlabBase && block.getMaterial() == Material.wood) {
                OreDictionary.registerOre((String)"slabWood", (ItemStack)new ItemStack(block, 1, 32767));
            }
            if (block instanceof LOTRBlockStairs && block.getMaterial() == Material.wood) {
                OreDictionary.registerOre((String)"stairWood", (ItemStack)new ItemStack(block, 1, 32767));
            }
            if (block instanceof LOTRBlockWoodBase) {
                OreDictionary.registerOre((String)"logWood", (ItemStack)new ItemStack(block, 1, 32767));
            }
            if (block instanceof LOTRBlockLeavesBase) {
                OreDictionary.registerOre((String)"treeLeaves", (ItemStack)new ItemStack(block, 1, 32767));
            }
            if (!(block instanceof LOTRBlockSaplingBase)) continue;
            OreDictionary.registerOre((String)"treeSapling", (ItemStack)new ItemStack(block, 1, 32767));
        }
        OreDictionary.registerOre((String)"stickWood", (Item)LOTRMod.mallornStick);
        OreDictionary.registerOre((String)"stickWood", (Item)LOTRMod.blackrootStick);
        for (Object obj : Item.itemRegistry) {
            Item item = (Item)obj;
            if (item == Items.bone || item instanceof LOTRItemBone) {
                OreDictionary.registerOre((String)"bone", (Item)item);
            }
            if (!(item instanceof LOTRItemBerry)) continue;
            OreDictionary.registerOre((String)"berry", (Item)item);
        }
        OreDictionary.registerOre((String)"oreCopper", (Block)LOTRMod.oreCopper);
        OreDictionary.registerOre((String)"oreTin", (Block)LOTRMod.oreTin);
        OreDictionary.registerOre((String)"oreSilver", (Block)LOTRMod.oreSilver);
        OreDictionary.registerOre((String)"oreSulfur", (Block)LOTRMod.oreSulfur);
        OreDictionary.registerOre((String)"oreSaltpeter", (Block)LOTRMod.oreSaltpeter);
        OreDictionary.registerOre((String)"oreSalt", (Block)LOTRMod.oreSalt);
        OreDictionary.registerOre((String)"ingotCopper", (Item)LOTRMod.copper);
        OreDictionary.registerOre((String)"ingotTin", (Item)LOTRMod.tin);
        OreDictionary.registerOre((String)"ingotBronze", (Item)LOTRMod.bronze);
        OreDictionary.registerOre((String)"ingotSilver", (Item)LOTRMod.silver);
        OreDictionary.registerOre((String)"nuggetIron", (Item)LOTRMod.ironNugget);
        OreDictionary.registerOre((String)"nuggetSilver", (Item)LOTRMod.silverNugget);
        OreDictionary.registerOre((String)"sulfur", (Item)LOTRMod.sulfur);
        OreDictionary.registerOre((String)"saltpeter", (Item)LOTRMod.saltpeter);
        OreDictionary.registerOre((String)"salt", (Item)LOTRMod.salt);
        OreDictionary.registerOre((String)"clayBall", (Item)Items.clay_ball);
        OreDictionary.registerOre((String)"clayBall", (Item)LOTRMod.redClayBall);
        OreDictionary.registerOre((String)"dyeYellow", (ItemStack)new ItemStack(LOTRMod.dye, 1, 0));
        OreDictionary.registerOre((String)"dyeWhite", (ItemStack)new ItemStack(LOTRMod.dye, 1, 1));
        OreDictionary.registerOre((String)"dyeBlue", (ItemStack)new ItemStack(LOTRMod.dye, 1, 2));
        OreDictionary.registerOre((String)"dyeGreen", (ItemStack)new ItemStack(LOTRMod.dye, 1, 3));
        OreDictionary.registerOre((String)"dyeBlack", (ItemStack)new ItemStack(LOTRMod.dye, 1, 4));
        OreDictionary.registerOre((String)"dyeBrown", (ItemStack)new ItemStack(LOTRMod.dye, 1, 5));
        OreDictionary.registerOre((String)"sand", (ItemStack)new ItemStack(LOTRMod.whiteSand, 1, 32767));
        OreDictionary.registerOre((String)"sandstone", (ItemStack)new ItemStack(LOTRMod.redSandstone, 1, 32767));
        OreDictionary.registerOre((String)"sandstone", (ItemStack)new ItemStack(LOTRMod.whiteSandstone, 1, 32767));
        OreDictionary.registerOre((String)"apple", (Item)Items.apple);
        OreDictionary.registerOre((String)"apple", (Item)LOTRMod.appleGreen);
        OreDictionary.registerOre((String)"feather", (Item)Items.feather);
        OreDictionary.registerOre((String)"feather", (Item)LOTRMod.swanFeather);
        OreDictionary.registerOre((String)"horn", (Item)LOTRMod.rhinoHorn);
        OreDictionary.registerOre((String)"horn", (Item)LOTRMod.kineArawHorn);
        OreDictionary.registerOre((String)"horn", (Item)LOTRMod.horn);
        OreDictionary.registerOre((String)"arrowTip", (Item)Items.flint);
        OreDictionary.registerOre((String)"arrowTip", (Item)LOTRMod.rhinoHorn);
        OreDictionary.registerOre((String)"arrowTip", (Item)LOTRMod.kineArawHorn);
        OreDictionary.registerOre((String)"arrowTip", (Item)LOTRMod.horn);
        OreDictionary.registerOre((String)"poison", (Item)LOTRMod.bottlePoison);
        OreDictionary.registerOre((String)"vine", (Block)Blocks.vine);
        OreDictionary.registerOre((String)"vine", (Block)LOTRMod.willowVines);
        OreDictionary.registerOre((String)"vine", (Block)LOTRMod.mirkVines);
    }

    /*
     * Opcode count of 21774 triggered aggressive code reduction.  Override with --aggressivesizethreshold.
     */
    private static void createStandardRecipes() {
        int i;
        int i2;
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.goldRing), new Object[]{"XXX", "X X", "XXX", Character.valueOf('X'), "nuggetGold"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Items.saddle), new Object[]{"XXX", "Y Y", Character.valueOf('X'), Items.leather, Character.valueOf('Y'), "ingotIron"}));
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.bronze, 1), (Object[])new Object[]{LOTRMod.copper, LOTRMod.tin});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.shovelBronze), new Object[]{"X", "Y", "Y", Character.valueOf('X'), LOTRMod.bronze, Character.valueOf('Y'), "stickWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pickaxeBronze), new Object[]{"XXX", " Y ", " Y ", Character.valueOf('X'), LOTRMod.bronze, Character.valueOf('Y'), "stickWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.axeBronze), new Object[]{"XX", "XY", " Y", Character.valueOf('X'), LOTRMod.bronze, Character.valueOf('Y'), "stickWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.swordBronze), new Object[]{"X", "X", "Y", Character.valueOf('X'), LOTRMod.bronze, Character.valueOf('Y'), "stickWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hoeBronze), new Object[]{"XX", " Y", " Y", Character.valueOf('X'), LOTRMod.bronze, Character.valueOf('Y'), "stickWood"}));
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.helmetBronze), (Object[])new Object[]{"XXX", "X X", Character.valueOf('X'), LOTRMod.bronze});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.bodyBronze), (Object[])new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), LOTRMod.bronze});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.legsBronze), (Object[])new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), LOTRMod.bronze});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.bootsBronze), (Object[])new Object[]{"X X", "X X", Character.valueOf('X'), LOTRMod.bronze});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks, 4, 0), (Object[])new Object[]{new ItemStack(LOTRMod.wood, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsShirePine, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 0)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.silverNugget, 9), (Object[])new Object[]{LOTRMod.silver});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.silver), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.silverNugget});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.silverRing), new Object[]{"XXX", "X X", "XXX", Character.valueOf('X'), "nuggetSilver"}));
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.mithrilNugget, 9), (Object[])new Object[]{LOTRMod.mithril});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.mithril), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.mithrilNugget});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.mithrilRing), (Object[])new Object[]{"XXX", "X X", "XXX", Character.valueOf('X'), LOTRMod.mithrilNugget});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(Items.dye, 1, 13), (Object[])new Object[]{LOTRMod.shireHeather});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.mug, 2), new Object[]{"X", "Y", "X", Character.valueOf('X'), "ingotTin", Character.valueOf('Y'), "plankWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.clayMug, 2), new Object[]{"X", "Y", "X", Character.valueOf('X'), "ingotTin", Character.valueOf('Y'), "clayBall"}));
        LOTRVesselRecipes.addRecipes(new ItemStack(LOTRMod.mugChocolate), LOTRMod.mugMilk, new Object[]{Items.sugar, new ItemStack(Items.dye, 1, 3)});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.appleCrumbleItem), new Object[]{"AAA", "BCB", "DDD", Character.valueOf('A'), Items.milk_bucket, Character.valueOf('B'), "apple", Character.valueOf('C'), Items.sugar, Character.valueOf('D'), Items.wheat}));
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.copper, 9), (Object[])new Object[]{new ItemStack(LOTRMod.blockOreStorage, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.blockOreStorage, 1, 0), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.copper});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.tin, 9), (Object[])new Object[]{new ItemStack(LOTRMod.blockOreStorage, 1, 1)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.blockOreStorage, 1, 1), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.tin});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.bronze, 9), (Object[])new Object[]{new ItemStack(LOTRMod.blockOreStorage, 1, 2)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.blockOreStorage, 1, 2), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.bronze});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.silver, 9), (Object[])new Object[]{new ItemStack(LOTRMod.blockOreStorage, 1, 3)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.blockOreStorage, 1, 3), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.silver});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.mithril, 9), (Object[])new Object[]{new ItemStack(LOTRMod.blockOreStorage, 1, 4)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.blockOreStorage, 1, 4), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.mithril});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.chandelier, 2, 0), new Object[]{" X ", "YZY", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), Blocks.torch, Character.valueOf('Z'), "ingotBronze"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.chandelier, 2, 1), new Object[]{" X ", "YZY", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), Blocks.torch, Character.valueOf('Z'), "ingotIron"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.chandelier, 2, 2), new Object[]{" X ", "YZY", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), Blocks.torch, Character.valueOf('Z'), "ingotSilver"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.chandelier, 2, 3), new Object[]{" X ", "YZY", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), Blocks.torch, Character.valueOf('Z'), "ingotGold"}));
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.pipeweedSeeds, 2), (Object[])new Object[]{LOTRMod.pipeweedPlant});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.pipeweedSeeds), (Object[])new Object[]{LOTRMod.pipeweedLeaf});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.shovelMithril), new Object[]{"X", "Y", "Y", Character.valueOf('X'), LOTRMod.mithril, Character.valueOf('Y'), "stickWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pickaxeMithril), new Object[]{"XXX", " Y ", " Y ", Character.valueOf('X'), LOTRMod.mithril, Character.valueOf('Y'), "stickWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.axeMithril), new Object[]{"XX", "XY", " Y", Character.valueOf('X'), LOTRMod.mithril, Character.valueOf('Y'), "stickWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.swordMithril), new Object[]{"X", "X", "Y", Character.valueOf('X'), LOTRMod.mithril, Character.valueOf('Y'), "stickWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hoeMithril), new Object[]{"XX", " Y", " Y", Character.valueOf('X'), LOTRMod.mithril, Character.valueOf('Y'), "stickWood"}));
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.helmetMithril), (Object[])new Object[]{"XXX", "X X", Character.valueOf('X'), LOTRMod.mithrilMail});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.bodyMithril), (Object[])new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), LOTRMod.mithrilMail});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.legsMithril), (Object[])new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), LOTRMod.mithrilMail});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.bootsMithril), (Object[])new Object[]{"X X", "X X", Character.valueOf('X'), LOTRMod.mithrilMail});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.spearBronze), new Object[]{"  X", " Y ", "Y  ", Character.valueOf('X'), LOTRMod.bronze, Character.valueOf('Y'), "stickWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.spearIron), new Object[]{"  X", " Y ", "Y  ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.spearMithril), new Object[]{"  X", " Y ", "Y  ", Character.valueOf('X'), LOTRMod.mithril, Character.valueOf('Y'), "stickWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.silverCoin, 4), new Object[]{"XX", "XX", Character.valueOf('X'), "nuggetSilver"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.clayPlate, 2), new Object[]{"XX", Character.valueOf('X'), "clayBall"}));
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.helmetFur), (Object[])new Object[]{"XXX", "X X", Character.valueOf('X'), LOTRMod.fur});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.bodyFur), (Object[])new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), LOTRMod.fur});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.legsFur), (Object[])new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), LOTRMod.fur});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.bootsFur), (Object[])new Object[]{"X X", "X X", Character.valueOf('X'), LOTRMod.fur});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.chandelier, 2, 4), new Object[]{" X ", "YZY", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), Blocks.torch, Character.valueOf('Z'), LOTRMod.mithril}));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipeHobbitPipe());
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(Items.dye, 4, 15), (Object[])new Object[]{LOTRMod.wargBone});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks, 4, 4), (Object[])new Object[]{new ItemStack(LOTRMod.fruitWood, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsApple, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 4)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks, 4, 5), (Object[])new Object[]{new ItemStack(LOTRMod.fruitWood, 1, 1)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsPear, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 5)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks, 4, 6), (Object[])new Object[]{new ItemStack(LOTRMod.fruitWood, 1, 2)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsCherry, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 6)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.dye, 1, 2), (Object[])new Object[]{LOTRMod.bluebell});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.hearth, 3), (Object[])new Object[]{"XXX", "YYY", Character.valueOf('X'), new ItemStack(Items.coal, 1, 32767), Character.valueOf('Y'), Items.brick});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerBronze), new Object[]{"X", "Y", Character.valueOf('X'), LOTRMod.bronze, Character.valueOf('Y'), "stickWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerIron), new Object[]{"X", "Y", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerMithril), new Object[]{"X", "Y", Character.valueOf('X'), LOTRMod.mithril, Character.valueOf('Y'), "stickWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.battleaxeMithril), new Object[]{"XXX", "XYX", " Y ", Character.valueOf('X'), LOTRMod.mithril, Character.valueOf('Y'), "stickWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hammerMithril), new Object[]{"XYX", "XYX", " Y ", Character.valueOf('X'), LOTRMod.mithril, Character.valueOf('Y'), "stickWood"}));
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(Items.dye, 3, 15), (Object[])new Object[]{LOTRMod.orcBone});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(Items.dye, 3, 15), (Object[])new Object[]{LOTRMod.elfBone});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(Items.dye, 2, 15), (Object[])new Object[]{LOTRMod.dwarfBone});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(Items.dye, 2, 15), (Object[])new Object[]{LOTRMod.hobbitBone});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.commandHorn), new Object[]{"XYX", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), "horn"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Items.arrow, 4), new Object[]{"X", "Y", "Z", Character.valueOf('X'), "arrowTip", Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "feather"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.crossbowBolt, 4), new Object[]{"X", "Y", "Z", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "feather"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.crossbowBolt, 4), new Object[]{"X", "Y", "Z", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "feather"}));
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.cherryPieItem), (Object[])new Object[]{"AAA", "BCB", "DDD", Character.valueOf('A'), Items.milk_bucket, Character.valueOf('B'), LOTRMod.cherry, Character.valueOf('C'), Items.sugar, Character.valueOf('D'), Items.wheat});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(Items.dye, 6, 15), (Object[])new Object[]{LOTRMod.trollBone});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.ironCrossbow), new Object[]{"XXY", "ZYX", "YZX", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), Items.string}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.mithrilCrossbow), new Object[]{"XXY", "ZYX", "YZX", Character.valueOf('X'), LOTRMod.mithril, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), Items.string}));
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsMirkOak, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 2)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks, 4, 2), (Object[])new Object[]{new ItemStack(LOTRMod.wood, 1, 2)});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.horseArmorIron), new Object[]{"X  ", "XYX", "XXX", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.horseArmorGold), new Object[]{"X  ", "XYX", "XXX", Character.valueOf('X'), "ingotGold", Character.valueOf('Y'), Items.leather}));
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.horseArmorDiamond), (Object[])new Object[]{"X  ", "XYX", "XXX", Character.valueOf('X'), Items.diamond, Character.valueOf('Y'), Items.leather});
        GameRegistry.addRecipe((IRecipe)new LOTRRecipesPouch());
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.ancientItem, 1, 0), (Object[])new Object[]{"X", "Y", "Z", Character.valueOf('X'), new ItemStack(LOTRMod.ancientItemParts, 1, 0), Character.valueOf('Y'), new ItemStack(LOTRMod.ancientItemParts, 1, 1), Character.valueOf('Z'), new ItemStack(LOTRMod.ancientItemParts, 1, 2)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.ancientItem, 1, 1), (Object[])new Object[]{"X", "Y", Character.valueOf('X'), new ItemStack(LOTRMod.ancientItemParts, 1, 0), Character.valueOf('Y'), new ItemStack(LOTRMod.ancientItemParts, 1, 2)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.ancientItem, 1, 2), (Object[])new Object[]{"XXX", "X X", Character.valueOf('X'), new ItemStack(LOTRMod.ancientItemParts, 1, 3)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.ancientItem, 1, 3), (Object[])new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.ancientItemParts, 1, 3)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.ancientItem, 1, 4), (Object[])new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), new ItemStack(LOTRMod.ancientItemParts, 1, 3)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.ancientItem, 1, 5), (Object[])new Object[]{"X X", "X X", Character.valueOf('X'), new ItemStack(LOTRMod.ancientItemParts, 1, 3)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsCharred, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 3)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks, 4, 3), (Object[])new Object[]{new ItemStack(LOTRMod.wood, 1, 3)});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.barrel), new Object[]{"XXX", "YZY", "XXX", Character.valueOf('X'), "plankWood", Character.valueOf('Y'), "ingotIron", Character.valueOf('Z'), Items.bucket}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.armorStandItem), new Object[]{" X ", " X ", "YYY", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), Blocks.stone}));
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.pebble, 4), (Object[])new Object[]{Blocks.gravel});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.sling), new Object[]{"XYX", "XZX", " X ", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), Items.leather, Character.valueOf('Z'), Items.string}));
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks, 4, 8), (Object[])new Object[]{new ItemStack(LOTRMod.wood2, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsLebethron, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 8)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.dye, 1, 1), (Object[])new Object[]{LOTRMod.asphodel});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.orcSteel, 9), (Object[])new Object[]{new ItemStack(LOTRMod.blockOreStorage, 1, 5)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.blockOreStorage, 1, 5), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.orcSteel});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.pressurePlateMordorRock), (Object[])new Object[]{"XX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 0)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.buttonMordorRock), (Object[])new Object[]{new ItemStack(LOTRMod.rock, 1, 0)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.nauriteGem, 9), (Object[])new Object[]{new ItemStack(LOTRMod.blockOreStorage, 1, 10)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.blockOreStorage, 1, 10), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.nauriteGem});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.guldurilCrystal, 9), (Object[])new Object[]{new ItemStack(LOTRMod.blockOreStorage, 1, 11)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.blockOreStorage, 1, 11), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.guldurilCrystal});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.dye, 1, 0), (Object[])new Object[]{LOTRMod.elanor});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.dye, 1, 1), (Object[])new Object[]{LOTRMod.niphredil});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.quenditeCrystal, 9), (Object[])new Object[]{new ItemStack(LOTRMod.blockOreStorage, 1, 6)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.blockOreStorage, 1, 6), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.quenditeCrystal});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.galvorn, 9), (Object[])new Object[]{new ItemStack(LOTRMod.blockOreStorage, 1, 8)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.blockOreStorage, 1, 8), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.galvorn});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.dwarfSteel, 9), (Object[])new Object[]{new ItemStack(LOTRMod.blockOreStorage, 1, 7)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.blockOreStorage, 1, 7), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.dwarfSteel});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.urukSteel, 9), (Object[])new Object[]{new ItemStack(LOTRMod.blockOreStorage, 1, 9)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.blockOreStorage, 1, 9), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.urukSteel});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.pressurePlateGondorRock), (Object[])new Object[]{"XX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 1)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.buttonGondorRock), (Object[])new Object[]{new ItemStack(LOTRMod.rock, 1, 1)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.pressurePlateRohanRock), (Object[])new Object[]{"XX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 2)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.buttonRohanRock), (Object[])new Object[]{new ItemStack(LOTRMod.rock, 1, 2)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks, 4, 9), (Object[])new Object[]{new ItemStack(LOTRMod.wood2, 1, 1)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsBeech, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 9)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.morgulSteel, 9), (Object[])new Object[]{new ItemStack(LOTRMod.blockOreStorage, 1, 12)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.blockOreStorage, 1, 12), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.morgulSteel});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.leatherHat), (Object[])new Object[]{" X ", "XXX", Character.valueOf('X'), Items.leather});
        GameRegistry.addRecipe((IRecipe)new LOTRRecipeLeatherHatDye());
        GameRegistry.addRecipe((IRecipe)new LOTRRecipeFeatherDye());
        GameRegistry.addRecipe((IRecipe)new LOTRRecipeLeatherHatFeather());
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.pressurePlateBlueRock), (Object[])new Object[]{"XX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 3)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.buttonBlueRock), (Object[])new Object[]{new ItemStack(LOTRMod.rock, 1, 3)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingle11, 6, 5), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 3)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.smoothStone, 2, 3), (Object[])new Object[]{"X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 3)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingle3, 6, 0), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.smoothStone, 1, 3)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.brick, 4, 14), (Object[])new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 3)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.wall, 6, 13), (Object[])new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 3)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingle3, 6, 1), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 14)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsBlueRockBrick, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 14)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.wall, 6, 14), (Object[])new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 14)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks, 4, 10), (Object[])new Object[]{new ItemStack(LOTRMod.wood2, 1, 2)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsHolly, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 10)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.rabbitStew), (Object[])new Object[]{Items.bowl, LOTRMod.rabbitCooked, Items.potato, Items.potato});
        for (i = 0; i <= 15; ++i) {
            if (i == 1) continue;
            GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fence, 3, i), new Object[]{"XYX", "XYX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, i), Character.valueOf('Y'), "stickWood"}));
        }
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.dye, 2, 0), (Object[])new Object[]{new ItemStack(LOTRMod.doubleFlower, 1, 1)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.pillar, 3, 3), (Object[])new Object[]{"X", "X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 3)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingle3, 6, 2), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar, 1, 3)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(Items.gunpowder, 2), (Object[])new Object[]{LOTRMod.sulfur, LOTRMod.saltpeter, new ItemStack(Items.coal, 1, 1)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(Items.dye, 2, 15), (Object[])new Object[]{LOTRMod.saltpeter, Blocks.dirt});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.commandSword), new Object[]{"X", "Y", "Z", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "ingotBronze", Character.valueOf('Z'), "stickWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.sulfurMatch, 4), new Object[]{"X", "Y", Character.valueOf('X'), "sulfur", Character.valueOf('Y'), "stickWood"}));
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.blockOreStorage, 1, 13), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.sulfur});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.blockOreStorage, 1, 14), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.saltpeter});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.sulfur, 9), (Object[])new Object[]{new ItemStack(LOTRMod.blockOreStorage, 1, 13)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.saltpeter, 9), (Object[])new Object[]{new ItemStack(LOTRMod.blockOreStorage, 1, 14)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks, 4, 7), (Object[])new Object[]{new ItemStack(LOTRMod.fruitWood, 1, 3)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsMango, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 7)});
        LOTRVesselRecipes.addRecipes(new ItemStack(LOTRMod.mugMangoJuice), new Object[]{LOTRMod.mango, LOTRMod.mango});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks, 4, 11), (Object[])new Object[]{new ItemStack(LOTRMod.wood2, 1, 3)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsBanana, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 11)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.bananaCakeItem), (Object[])new Object[]{"AAA", "BCB", "DDD", Character.valueOf('A'), Items.milk_bucket, Character.valueOf('B'), LOTRMod.banana, Character.valueOf('C'), Items.egg, Character.valueOf('D'), Items.wheat});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.bananaBread), (Object[])new Object[]{"XYX", Character.valueOf('X'), Items.wheat, Character.valueOf('Y'), LOTRMod.banana});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.lionBedItem), new Object[]{"XXX", "YYY", Character.valueOf('X'), LOTRMod.lionFur, Character.valueOf('Y'), "plankWood"}));
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(Items.dye, 2, 13), (Object[])new Object[]{new ItemStack(LOTRMod.doubleFlower, 1, 2)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(Items.dye, 2, 1), (Object[])new Object[]{new ItemStack(LOTRMod.doubleFlower, 1, 3)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks, 4, 12), (Object[])new Object[]{new ItemStack(LOTRMod.wood3, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsMaple, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 12)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.mapleSyrup), (Object[])new Object[]{new ItemStack(LOTRMod.wood3, 1, 0), Items.bowl});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks, 4, 13), (Object[])new Object[]{new ItemStack(LOTRMod.wood3, 1, 1)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsLarch, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 13)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.helmetGemsbok), (Object[])new Object[]{"Y Y", "XXX", "X X", Character.valueOf('X'), LOTRMod.gemsbokHide, Character.valueOf('Y'), LOTRMod.gemsbokHorn});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.bodyGemsbok), (Object[])new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), LOTRMod.gemsbokHide});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.legsGemsbok), (Object[])new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), LOTRMod.gemsbokHide});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.bootsGemsbok), (Object[])new Object[]{"X X", "X X", Character.valueOf('X'), LOTRMod.gemsbokHide});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.pressurePlateRedRock), (Object[])new Object[]{"XX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 4)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.buttonRedRock), (Object[])new Object[]{new ItemStack(LOTRMod.rock, 1, 4)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingle11, 6, 6), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 4)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.smoothStone, 2, 4), (Object[])new Object[]{"X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 4)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingle3, 6, 5), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.smoothStone, 1, 4)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.brick2, 4, 2), (Object[])new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 4)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.wall2, 6, 2), (Object[])new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 4)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingle3, 6, 6), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 2)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsRedRockBrick, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 2)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.wall2, 6, 3), (Object[])new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 2)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.pillar, 3, 4), (Object[])new Object[]{"X", "X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 4)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingle3, 6, 7), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar, 1, 4)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks, 4, 14), (Object[])new Object[]{new ItemStack(LOTRMod.wood3, 1, 2)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsDatePalm, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 14)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.blueDwarfSteel, 9), (Object[])new Object[]{new ItemStack(LOTRMod.blockOreStorage, 1, 15)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.blockOreStorage, 1, 15), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.blueDwarfSteel});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.thatch, 6, 0), (Object[])new Object[]{"XYX", "YXY", "XYX", Character.valueOf('X'), Items.wheat, Character.valueOf('Y'), Blocks.dirt});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingleThatch, 6, 0), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.thatch, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsThatch, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.thatch, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.horseArmorMithril), (Object[])new Object[]{"X  ", "XYX", "XXX", Character.valueOf('X'), LOTRMod.mithrilMail, Character.valueOf('Y'), Items.leather});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.strawBedItem), new Object[]{"XXX", "YYY", Character.valueOf('X'), Items.wheat, Character.valueOf('Y'), "plankWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.thatchFloor, 3), new Object[]{"XX", Character.valueOf('X'), new ItemStack(LOTRMod.thatch, 1, 0)}));
        GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.redBook), new Object[]{Items.book, new ItemStack(Items.dye, 1, 1), "nuggetGold"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.termiteMound, 1, 1), new Object[]{" X ", "XYX", " X ", Character.valueOf('X'), LOTRMod.termite, Character.valueOf('Y'), Blocks.stone}));
        GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(Items.gunpowder, 2), new Object[]{LOTRMod.termite}));
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks, 4, 15), (Object[])new Object[]{new ItemStack(LOTRMod.wood3, 1, 3)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsMangrove, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 15)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(Items.dye, 1, 1), (Object[])new Object[]{new ItemStack(LOTRMod.haradFlower, 1, 0)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.dye, 1, 0), (Object[])new Object[]{new ItemStack(LOTRMod.haradFlower, 1, 1)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(Items.dye, 1, 9), (Object[])new Object[]{new ItemStack(LOTRMod.haradFlower, 1, 2)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(Items.dye, 1, 13), (Object[])new Object[]{new ItemStack(LOTRMod.haradFlower, 1, 3)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.flaxSeeds, 2), (Object[])new Object[]{LOTRMod.flaxPlant});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(Items.string), (Object[])new Object[]{LOTRMod.flax});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks2, 4, 0), (Object[])new Object[]{new ItemStack(LOTRMod.wood4, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsChestnut, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 0)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks2, 4, 1), (Object[])new Object[]{new ItemStack(LOTRMod.wood4, 1, 1)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsBaobab, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 1)});
        for (i = 0; i <= 15; ++i) {
            GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fence2, 3, i), new Object[]{"XYX", "XYX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, i), Character.valueOf('Y'), "stickWood"}));
        }
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks2, 4, 2), (Object[])new Object[]{new ItemStack(LOTRMod.wood4, 1, 2)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsCedar, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 2)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.blackUrukSteel, 9), (Object[])new Object[]{new ItemStack(LOTRMod.blockOreStorage2, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.blockOreStorage2, 1, 0), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.blackUrukSteel});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.utumnoKey, 1, 0), (Object[])new Object[]{new ItemStack(LOTRMod.utumnoKey, 1, 2), new ItemStack(LOTRMod.utumnoKey, 1, 3), new ItemStack(LOTRMod.utumnoKey, 1, 4)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.utumnoKey, 1, 1), (Object[])new Object[]{new ItemStack(LOTRMod.utumnoKey, 1, 5), new ItemStack(LOTRMod.utumnoKey, 1, 6), new ItemStack(LOTRMod.utumnoKey, 1, 7)});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.battleaxeIron), new Object[]{"XXX", "XYX", " Y ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.battleaxeBronze), new Object[]{"XXX", "XYX", " Y ", Character.valueOf('X'), LOTRMod.bronze, Character.valueOf('Y'), "stickWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bronzeCrossbow), new Object[]{"XXY", "ZYX", "YZX", Character.valueOf('X'), LOTRMod.bronze, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), Items.string}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.commandTable), new Object[]{"XXX", "YYY", "ZZZ", Character.valueOf('X'), Items.paper, Character.valueOf('Y'), "plankWood", Character.valueOf('Z'), "ingotBronze"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.butterflyJar), new Object[]{"X", "Y", Character.valueOf('X'), "plankWood", Character.valueOf('Y'), Blocks.glass}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.berryPieItem), new Object[]{"AAA", "BBB", "CCC", Character.valueOf('A'), Items.milk_bucket, Character.valueOf('B'), "berry", Character.valueOf('C'), Items.wheat}));
        LOTRVesselRecipes.addRecipes(new ItemStack(LOTRMod.mugBlueberryJuice), new Object[]{LOTRMod.blueberry, LOTRMod.blueberry, LOTRMod.blueberry});
        LOTRVesselRecipes.addRecipes(new ItemStack(LOTRMod.mugBlackberryJuice), new Object[]{LOTRMod.blackberry, LOTRMod.blackberry, LOTRMod.blackberry});
        LOTRVesselRecipes.addRecipes(new ItemStack(LOTRMod.mugRaspberryJuice), new Object[]{LOTRMod.raspberry, LOTRMod.raspberry, LOTRMod.raspberry});
        LOTRVesselRecipes.addRecipes(new ItemStack(LOTRMod.mugCranberryJuice), new Object[]{LOTRMod.cranberry, LOTRMod.cranberry, LOTRMod.cranberry});
        LOTRVesselRecipes.addRecipes(new ItemStack(LOTRMod.mugElderberryJuice), new Object[]{LOTRMod.elderberry, LOTRMod.elderberry, LOTRMod.elderberry});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.brick3, 1, 0), (Object[])new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 14)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.brick3, 1, 1), (Object[])new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 2)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.elfSteel, 9), (Object[])new Object[]{new ItemStack(LOTRMod.blockOreStorage2, 1, 1)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.blockOreStorage2, 1, 1), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.elfSteel});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks2, 4, 3), (Object[])new Object[]{new ItemStack(LOTRMod.wood4, 1, 3)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsFir, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 3)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks2, 4, 4), (Object[])new Object[]{new ItemStack(LOTRMod.wood5, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsPine, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 4)});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetBone), new Object[]{"XXX", "X X", Character.valueOf('X'), "bone"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyBone), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), "bone"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsBone), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), "bone"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsBone), new Object[]{"X X", "X X", Character.valueOf('X'), "bone"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.unsmeltery), new Object[]{"X X", "YXY", "ZZZ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), Blocks.cobblestone}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.throwingAxeBronze), new Object[]{" X ", " YX", "Y  ", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), "stickWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.throwingAxeIron), new Object[]{" X ", " YX", "Y  ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bronzeBars, 16), new Object[]{"XXX", "XXX", Character.valueOf('X'), "ingotBronze"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.goldBars, 16), new Object[]{"XXX", "XXX", Character.valueOf('X'), "ingotGold"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.silverBars, 16), new Object[]{"XXX", "XXX", Character.valueOf('X'), "ingotSilver"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.mithrilBars, 16), new Object[]{"XXX", "XXX", Character.valueOf('X'), LOTRMod.mithril}));
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planksRotten, 4, 0), (Object[])new Object[]{new ItemStack(LOTRMod.rottenLog, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsRotten, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planksRotten, 1, 0)});
        for (i = 0; i <= 0; ++i) {
            GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceRotten, 3, i), new Object[]{"XYX", "XYX", Character.valueOf('X'), new ItemStack(LOTRMod.planksRotten, 1, i), Character.valueOf('Y'), "stickWood"}));
        }
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.scorchedSlabSingle, 6, 0), (Object[])new Object[]{"XXX", Character.valueOf('X'), LOTRMod.scorchedStone});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsScorchedStone, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), LOTRMod.scorchedStone});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.scorchedWall, 6), (Object[])new Object[]{"XXX", "XXX", Character.valueOf('X'), LOTRMod.scorchedStone});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks2, 4, 5), (Object[])new Object[]{new ItemStack(LOTRMod.wood5, 1, 1)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsLemon, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 5)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.lemonCakeItem), (Object[])new Object[]{"AAA", "BCB", "DDD", Character.valueOf('A'), Items.milk_bucket, Character.valueOf('B'), LOTRMod.lemon, Character.valueOf('C'), Items.sugar, Character.valueOf('D'), Items.wheat});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks2, 4, 6), (Object[])new Object[]{new ItemStack(LOTRMod.wood5, 1, 2)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsOrange, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 6)});
        LOTRVesselRecipes.addRecipes(new ItemStack(LOTRMod.mugOrangeJuice), new Object[]{LOTRMod.orange, LOTRMod.orange});
        LOTRVesselRecipes.addRecipes(new ItemStack(LOTRMod.mugLemonade), LOTRMod.mugWater, new Object[]{LOTRMod.lemon, Items.sugar});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.alloyForge), (Object[])new Object[]{"XXX", "X X", "XXX", Character.valueOf('X'), Blocks.stonebrick});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks2, 4, 7), (Object[])new Object[]{new ItemStack(LOTRMod.wood5, 1, 3)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsLime, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 7)});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Items.compass), new Object[]{" X ", "XYX", " X ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "ingotCopper"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Items.clock), new Object[]{" X ", "XYX", " X ", Character.valueOf('X'), "ingotGold", Character.valueOf('Y'), "ingotCopper"}));
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.obsidianShard, 9), (Object[])new Object[]{Blocks.obsidian});
        GameRegistry.addRecipe((ItemStack)new ItemStack(Blocks.obsidian, 1), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.obsidianShard});
        GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(Blocks.mossy_cobblestone, 1, 0), new Object[]{new ItemStack(Blocks.cobblestone, 1, 0), "vine"}));
        GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(Blocks.stonebrick, 1, 1), new Object[]{new ItemStack(Blocks.stonebrick, 1, 0), "vine"}));
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks2, 4, 8), (Object[])new Object[]{new ItemStack(LOTRMod.wood6, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsMahogany, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 8)});
        GameRegistry.addRecipe((IRecipe)new LOTRRecipesBanners());
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.redSandstone, 1, 0), (Object[])new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack((Block)Blocks.sand, 1, 1)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingle7, 6, 5), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.redSandstone, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsRedSandstone, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.redSandstone, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.thatch, 4, 1), (Object[])new Object[]{"XX", "XX", Character.valueOf('X'), LOTRMod.driedReeds});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingleThatch, 6, 1), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.thatch, 1, 1)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsReed, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.thatch, 1, 1)});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pikeIron), new Object[]{"  X", " YX", "Y  ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        for (i = 0; i <= 3; ++i) {
            GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodBeamV1, 3, i), new Object[]{"X", "X", "X", Character.valueOf('X'), new ItemStack(Blocks.log, 1, i)}));
        }
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.reedBars, 16), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.thatch, 1, 1)}));
        for (i = 0; i <= 1; ++i) {
            GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodBeamV2, 3, i), new Object[]{"X", "X", "X", Character.valueOf('X'), new ItemStack(Blocks.log2, 1, i)}));
        }
        for (i = 0; i <= 3; ++i) {
            if (i == 1) continue;
            GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodBeam1, 3, i), new Object[]{"X", "X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.wood, 1, i)}));
        }
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Items.paper, 3), new Object[]{"XXX", Character.valueOf('X'), LOTRMod.reeds}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Items.paper, 3), new Object[]{"XXX", Character.valueOf('X'), LOTRMod.cornStalk}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.weaponRack), new Object[]{"X X", "YYY", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), "plankWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wasteBlock, 4), new Object[]{"XY", "YZ", Character.valueOf('X'), Items.rotten_flesh, Character.valueOf('Y'), Blocks.dirt, Character.valueOf('Z'), "bone"}));
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.dirtPath, 2, 0), (Object[])new Object[]{"XX", Character.valueOf('X'), Blocks.dirt});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks2, 4, 9), (Object[])new Object[]{new ItemStack(LOTRMod.wood6, 1, 1)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsWillow, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 9)});
        for (i = 0; i <= 3; ++i) {
            GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodBeam2, 3, i), new Object[]{"X", "X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.wood2, 1, i)}));
        }
        for (i = 0; i <= 3; ++i) {
            GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodBeamFruit, 3, i), new Object[]{"X", "X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.fruitWood, 1, i)}));
        }
        for (i = 0; i <= 3; ++i) {
            GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodBeam3, 3, i), new Object[]{"X", "X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.wood3, 1, i)}));
        }
        for (i = 0; i <= 3; ++i) {
            GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodBeam4, 3, i), new Object[]{"X", "X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.wood4, 1, i)}));
        }
        for (i = 0; i <= 3; ++i) {
            GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodBeam5, 3, i), new Object[]{"X", "X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.wood5, 1, i)}));
        }
        for (i = 0; i <= 3; ++i) {
            GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodBeam6, 3, i), new Object[]{"X", "X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.wood6, 1, i)}));
        }
        for (i = 0; i <= 0; ++i) {
            GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodBeamRotten, 3, i), new Object[]{"X", "X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.rottenLog, 1, i)}));
        }
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.brick4, 4, 15), (Object[])new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 5)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsChalkBrick, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 1, 15)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.wall3, 6, 6), (Object[])new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 5)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.wall3, 6, 7), (Object[])new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 1, 15)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingle11, 6, 7), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 5)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.smoothStone, 2, 5), (Object[])new Object[]{"X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 5)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingle8, 6, 7), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.smoothStone, 1, 5)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingle9, 6, 0), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 1, 15)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.pillar2, 3, 1), (Object[])new Object[]{"X", "X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 5)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingle9, 6, 1), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar2, 1, 1)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.pressurePlateChalk), (Object[])new Object[]{"XX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 5)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.buttonChalk), (Object[])new Object[]{new ItemStack(LOTRMod.rock, 1, 5)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.wallStoneV, 6, 0), (Object[])new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(Blocks.stone, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.wallStoneV, 6, 1), (Object[])new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(Blocks.stonebrick, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.wallStoneV, 6, 2), (Object[])new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(Blocks.stonebrick, 1, 1)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.wallStoneV, 6, 3), (Object[])new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(Blocks.stonebrick, 1, 2)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.wallStoneV, 6, 4), (Object[])new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(Blocks.sandstone, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.wallStoneV, 6, 5), (Object[])new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.redSandstone, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.wallStoneV, 6, 6), (Object[])new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(Blocks.brick_block, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsStoneBrickMossy, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(Blocks.stonebrick, 1, 1)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsStoneBrickCracked, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(Blocks.stonebrick, 1, 2)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingleV, 6, 0), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(Blocks.stonebrick, 1, 1)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingleV, 6, 1), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(Blocks.stonebrick, 1, 2)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsStone, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(Blocks.stone, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsBlueRock, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 3)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsRedRock, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 4)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsChalk, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 5)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.dye, 1, 3), (Object[])new Object[]{new ItemStack(LOTRMod.clover, 1, 32767)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.clayTile, 4, 0), (Object[])new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(Blocks.hardened_clay, 1, 0)});
        for (i = 0; i <= 15; ++i) {
            GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.clayTileDyed, 8, i), new Object[]{"XXX", "XYX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.clayTile, 1, 0), Character.valueOf('Y'), dyeOreNames[BlockColored.func_150032_b((int)i)]}));
            GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.clayTileDyed, 4, i), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(Blocks.stained_hardened_clay, 1, i)}));
        }
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabClayTileSingle, 6, 0), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.clayTile, 1, 0)});
        for (i = 0; i <= 7; ++i) {
            GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabClayTileDyedSingle, 6, i), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.clayTileDyed, 1, i)});
            GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabClayTileDyedSingle2, 6, i), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.clayTileDyed, 1, i + 8)});
        }
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsClayTile, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.clayTile, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsClayTileDyedWhite, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.clayTileDyed, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsClayTileDyedOrange, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.clayTileDyed, 1, 1)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsClayTileDyedMagenta, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.clayTileDyed, 1, 2)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsClayTileDyedLightBlue, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.clayTileDyed, 1, 3)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsClayTileDyedYellow, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.clayTileDyed, 1, 4)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsClayTileDyedLime, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.clayTileDyed, 1, 5)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsClayTileDyedPink, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.clayTileDyed, 1, 6)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsClayTileDyedGray, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.clayTileDyed, 1, 7)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsClayTileDyedLightGray, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.clayTileDyed, 1, 8)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsClayTileDyedCyan, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.clayTileDyed, 1, 9)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsClayTileDyedPurple, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.clayTileDyed, 1, 10)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsClayTileDyedBlue, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.clayTileDyed, 1, 11)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsClayTileDyedBrown, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.clayTileDyed, 1, 12)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsClayTileDyedGreen, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.clayTileDyed, 1, 13)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsClayTileDyedRed, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.clayTileDyed, 1, 14)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsClayTileDyedBlack, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.clayTileDyed, 1, 15)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.pillar2, 3, 2), (Object[])new Object[]{"X", "X", "X", Character.valueOf('X'), new ItemStack(Blocks.stone, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingle9, 6, 2), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar2, 1, 2)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.dye, 1, 4), (Object[])new Object[]{new ItemStack(Items.coal, 1, 1)});
        GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.dye, 3, 5), new Object[]{"dyeRed", "dyeYellow", "dyeBlack"}));
        GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.dye, 2, 5), new Object[]{"dyeOrange", "dyeBlack"}));
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.dye, 1, 1), (Object[])new Object[]{LOTRMod.simbelmyne});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(Items.dye, 1, 12), (Object[])new Object[]{LOTRMod.dwarfHerb});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(Items.dye, 1, 10), (Object[])new Object[]{new ItemStack(LOTRMod.fangornPlant, 1, 0)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.dye, 1, 5), (Object[])new Object[]{new ItemStack(LOTRMod.fangornPlant, 1, 1)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.dye, 1, 0), (Object[])new Object[]{new ItemStack(LOTRMod.fangornPlant, 1, 2)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.dye, 1, 0), (Object[])new Object[]{new ItemStack(LOTRMod.fangornPlant, 1, 3)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(Items.dye, 1, 14), (Object[])new Object[]{new ItemStack(LOTRMod.fangornPlant, 1, 4)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(Items.dye, 1, 7), (Object[])new Object[]{new ItemStack(LOTRMod.fangornPlant, 1, 5)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.pillar2, 3, 3), (Object[])new Object[]{"X", "X", "X", Character.valueOf('X'), Blocks.brick_block});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingle9, 6, 3), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar2, 1, 3)});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gateGear, 4), new Object[]{" X ", "XYX", " X ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "plankWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gateWooden, 4), new Object[]{"ZYZ", "YXY", "ZYZ", Character.valueOf('X'), LOTRMod.gateGear, Character.valueOf('Y'), "plankWood", Character.valueOf('Z'), "ingotIron"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gateIronBars, 4), new Object[]{"YYY", "YXY", "YYY", Character.valueOf('X'), LOTRMod.gateGear, Character.valueOf('Y'), "ingotIron"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gateBronzeBars, 4), new Object[]{"YYY", "YXY", "YYY", Character.valueOf('X'), LOTRMod.gateGear, Character.valueOf('Y'), "ingotBronze"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gateWoodenCross, 4), new Object[]{"YYY", "YXY", "YYY", Character.valueOf('X'), LOTRMod.gateGear, Character.valueOf('Y'), "stickWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Items.saddle), new Object[]{"XXX", "Y Y", Character.valueOf('X'), LOTRMod.fur, Character.valueOf('Y'), "ingotIron"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.furBedItem), new Object[]{"XXX", "YYY", Character.valueOf('X'), LOTRMod.fur, Character.valueOf('Y'), "plankWood"}));
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabUtumnoSingle, 6, 0), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.utumnoBrick, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabUtumnoSingle, 6, 1), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.utumnoBrick, 1, 2)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabUtumnoSingle, 6, 2), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.utumnoBrick, 1, 4)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabUtumnoSingle, 6, 3), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.utumnoPillar, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabUtumnoSingle, 6, 4), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.utumnoPillar, 1, 1)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabUtumnoSingle, 6, 5), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.utumnoPillar, 1, 2)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsUtumnoBrickFire, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.utumnoBrick, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsUtumnoBrickIce, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.utumnoBrick, 1, 2)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsUtumnoBrickObsidian, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.utumnoBrick, 1, 4)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.wallUtumno, 6, 0), (Object[])new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.utumnoBrick, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.wallUtumno, 6, 1), (Object[])new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.utumnoBrick, 1, 2)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.wallUtumno, 6, 2), (Object[])new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.utumnoBrick, 1, 4)});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.halberdMithril), new Object[]{" XX", " YX", "Y  ", Character.valueOf('X'), LOTRMod.mithril, Character.valueOf('Y'), "stickWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gateSilver, 4), new Object[]{"YYY", "YXY", "YYY", Character.valueOf('X'), LOTRMod.gateGear, Character.valueOf('Y'), "ingotSilver"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gateGold, 4), new Object[]{"YYY", "YXY", "YYY", Character.valueOf('X'), LOTRMod.gateGear, Character.valueOf('Y'), "ingotGold"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gateMithril, 4), new Object[]{"YYY", "YXY", "YYY", Character.valueOf('X'), LOTRMod.gateGear, Character.valueOf('Y'), LOTRMod.mithril}));
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.brick5, 4, 0), (Object[])new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.mud, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsMudBrick, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.wall3, 6, 8), (Object[])new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingle9, 6, 5), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 0)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.leekSoup), (Object[])new Object[]{Items.bowl, LOTRMod.leek, LOTRMod.leek, Items.potato});
        GameRegistry.addRecipe((IRecipe)new LOTRRecipesPoisonDrinks());
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks2, 4, 10), (Object[])new Object[]{new ItemStack(LOTRMod.wood6, 1, 2)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsCypress, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 10)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks2, 4, 11), (Object[])new Object[]{new ItemStack(LOTRMod.wood6, 1, 3)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsOlive, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 11)});
        LOTRVesselRecipes.addRecipes(new ItemStack(LOTRMod.mugAppleJuice), new Object[]{"apple", "apple"});
        GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.redBrick, 1, 0), new Object[]{new ItemStack(Blocks.brick_block, 1, 0), "vine"}));
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingleV, 6, 2), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.redBrick, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingleV, 6, 3), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.redBrick, 1, 1)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsBrickMossy, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.redBrick, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsBrickCracked, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.redBrick, 1, 1)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.wallStoneV, 6, 7), (Object[])new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.redBrick, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.wallStoneV, 6, 8), (Object[])new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.redBrick, 1, 1)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(Blocks.dirt, 4, 1), (Object[])new Object[]{"XY", "YX", Character.valueOf('X'), new ItemStack(Blocks.dirt, 1, 0), Character.valueOf('Y'), Blocks.gravel});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.oliveBread), (Object[])new Object[]{"XYX", Character.valueOf('X'), Items.wheat, Character.valueOf('Y'), LOTRMod.olive});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.rollingPin), new Object[]{"XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), "plankWood"}));
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.seedsGrapeRed), (Object[])new Object[]{LOTRMod.grapeRed});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.seedsGrapeWhite), (Object[])new Object[]{LOTRMod.grapeWhite});
        LOTRVesselRecipes.addRecipes(new ItemStack(LOTRMod.mugRedGrapeJuice), new Object[]{LOTRMod.grapeRed, LOTRMod.grapeRed, LOTRMod.grapeRed});
        LOTRVesselRecipes.addRecipes(new ItemStack(LOTRMod.mugWhiteGrapeJuice), new Object[]{LOTRMod.grapeWhite, LOTRMod.grapeWhite, LOTRMod.grapeWhite});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.grapevine), new Object[]{"X", "X", "X", Character.valueOf('X'), "stickWood"}));
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.melonSoup), (Object[])new Object[]{Items.bowl, Items.melon, Items.melon, Items.sugar});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks2, 4, 12), (Object[])new Object[]{new ItemStack(LOTRMod.wood7, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsAspen, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 12)});
        for (i = 0; i <= 3; ++i) {
            GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodBeam7, 3, i), new Object[]{"X", "X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.wood7, 1, i)}));
        }
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks2, 4, 13), (Object[])new Object[]{new ItemStack(LOTRMod.wood7, 1, 1)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsGreenOak, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 13)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks2, 4, 14), (Object[])new Object[]{new ItemStack(LOTRMod.wood7, 1, 2)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsLairelosse, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 14)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks2, 4, 15), (Object[])new Object[]{new ItemStack(LOTRMod.wood7, 1, 3)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsAlmond, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 15)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.bottlePoison), (Object[])new Object[]{Items.glass_bottle, LOTRMod.wildberry});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingleDirt, 6, 0), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(Blocks.dirt, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingleDirt, 6, 1), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.dirtPath, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingleDirt, 6, 2), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.mud, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingleDirt, 6, 3), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.mordorDirt, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingleSand, 6, 0), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack((Block)Blocks.sand, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingleSand, 6, 1), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack((Block)Blocks.sand, 1, 1)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingleGravel, 6, 0), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(Blocks.gravel, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingleGravel, 6, 1), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.mordorGravel, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingleGravel, 6, 2), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.obsidianGravel, 1, 0)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.blackrootStick, 2), (Object[])new Object[]{LOTRMod.blackroot});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks3, 4, 0), (Object[])new Object[]{new ItemStack(LOTRMod.wood8, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsPlum, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks3, 1, 0)});
        for (i = 0; i <= 5; ++i) {
            GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fence3, 3, i), new Object[]{"XYX", "XYX", Character.valueOf('X'), new ItemStack(LOTRMod.planks3, 1, i), Character.valueOf('Y'), "stickWood"}));
        }
        for (i = 0; i <= 3; ++i) {
            GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodBeam8, 3, i), new Object[]{"X", "X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.wood8, 1, i)}));
        }
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.whiteSandstone, 1, 0), (Object[])new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.whiteSand, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingle10, 6, 6), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.whiteSandstone, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsWhiteSandstone, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.whiteSandstone, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.wall3, 6, 14), (Object[])new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.whiteSandstone, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingleSand, 6, 2), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.whiteSand, 1, 0)});
        LOTRBlockTreasurePile.generateTreasureRecipes(LOTRMod.treasureCopper, LOTRMod.copper);
        LOTRBlockTreasurePile.generateTreasureRecipes(LOTRMod.treasureSilver, LOTRMod.silver);
        LOTRBlockTreasurePile.generateTreasureRecipes(LOTRMod.treasureGold, Items.gold_ingot);
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.chestBasket), (Object[])new Object[]{"XXX", "X X", "XXX", Character.valueOf('X'), LOTRMod.driedReeds});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(Items.dye, 1, 14), (Object[])new Object[]{LOTRMod.marigold});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.dye, 1, 2), (Object[])new Object[]{new ItemStack(LOTRMod.rhunFlower, 1, 0)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(Items.dye, 1, 14), (Object[])new Object[]{new ItemStack(LOTRMod.rhunFlower, 1, 1)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(Items.dye, 1, 9), (Object[])new Object[]{new ItemStack(LOTRMod.rhunFlower, 1, 2)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.dye, 1, 0), (Object[])new Object[]{new ItemStack(LOTRMod.rhunFlower, 1, 3)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.dye, 1, 1), (Object[])new Object[]{new ItemStack(LOTRMod.rhunFlower, 1, 4)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingleV, 6, 4), (Object[])new Object[]{"XXX", Character.valueOf('X'), Blocks.mossy_cobblestone});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsCobblestoneMossy, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), Blocks.mossy_cobblestone});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(Items.dye, 2, 5), (Object[])new Object[]{new ItemStack(LOTRMod.doubleFlower, 1, 0)});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.spearStone), new Object[]{"  X", " Y ", "Y  ", Character.valueOf('X'), "cobblestone", Character.valueOf('Y'), "stickWood"}));
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.marzipan), (Object[])new Object[]{LOTRMod.almond, LOTRMod.almond, Items.sugar});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.marzipanChocolate), (Object[])new Object[]{LOTRMod.marzipan, new ItemStack(Items.dye, 1, 3)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.marzipanBlock), (Object[])new Object[]{"XXX", Character.valueOf('X'), LOTRMod.marzipan});
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePartyHatDye());
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.wallClayTile, 6, 0), (Object[])new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.clayTile, 1, 0)});
        for (i = 0; i <= 15; ++i) {
            GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.wallClayTileDyed, 6, i), (Object[])new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.clayTileDyed, 1, i)});
        }
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gobletGold, 2), new Object[]{"X X", " X ", " X ", Character.valueOf('X'), "ingotGold"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gobletSilver, 2), new Object[]{"X X", " X ", " X ", Character.valueOf('X'), "ingotSilver"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gobletCopper, 2), new Object[]{"X X", " X ", " X ", Character.valueOf('X'), "ingotCopper"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gobletWood, 2), new Object[]{"X X", " X ", " X ", Character.valueOf('X'), "plankWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.skullCup), new Object[]{"X", "Y", Character.valueOf('X'), new ItemStack(Items.skull, 1, 0), Character.valueOf('Y'), "ingotTin"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wineGlass, 2), new Object[]{"X X", " X ", " X ", Character.valueOf('X'), Blocks.glass}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.waterskin, 2), new Object[]{" Y ", "X X", " X ", Character.valueOf('X'), Items.leather, Character.valueOf('Y'), Items.string}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.waterskin, 2), new Object[]{" Y ", "X X", " X ", Character.valueOf('X'), LOTRMod.gemsbokHide, Character.valueOf('Y'), Items.string}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.waterskin, 2), new Object[]{" Y ", "X X", " X ", Character.valueOf('X'), LOTRMod.fur, Character.valueOf('Y'), Items.string}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.waterskin, 2), new Object[]{" Y ", "X X", " X ", Character.valueOf('X'), LOTRMod.lionFur, Character.valueOf('Y'), Items.string}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.aleHorn), new Object[]{"X", "Y", Character.valueOf('X'), "horn", Character.valueOf('Y'), "ingotTin"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.aleHornGold), new Object[]{"X", "Y", Character.valueOf('X'), "horn", Character.valueOf('Y'), "ingotGold"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.oreGlowstone), new Object[]{"XXX", "XYX", "XXX", Character.valueOf('X'), Items.glowstone_dust, Character.valueOf('Y'), new ItemStack(Blocks.stone, 1, 0)}));
        GameRegistry.addRecipe((ItemStack)new ItemStack(Blocks.stonebrick, 1, 3), (Object[])new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(Blocks.stonebrick, 1, 0)});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.birdCage, 1, 0), new Object[]{"YYY", "Y Y", "XXX", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), LOTRMod.bronzeBars}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.birdCage, 1, 1), new Object[]{"YYY", "Y Y", "XXX", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Blocks.iron_bars}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.birdCage, 1, 2), new Object[]{"YYY", "Y Y", "XXX", Character.valueOf('X'), "ingotSilver", Character.valueOf('Y'), LOTRMod.silverBars}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.birdCage, 1, 3), new Object[]{"YYY", "Y Y", "XXX", Character.valueOf('X'), "ingotGold", Character.valueOf('Y'), LOTRMod.goldBars}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.birdCageWood, 1, 0), new Object[]{"YYY", "Y Y", "XXX", Character.valueOf('X'), "plankWood", Character.valueOf('Y'), "stickWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.chisel), new Object[]{"XY", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingleV, 6, 5), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(Blocks.stone, 1, 0)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.smoothStoneV, 2, 0), new Object[]{"X", "X", Character.valueOf('X'), new ItemStack(Blocks.stone, 1, 0)}));
        for (LOTRBlockFallenLeaves fallenLeafBlock : LOTRBlockFallenLeaves.allFallenLeaves) {
            for (Block leafBlock : fallenLeafBlock.getLeafBlocks()) {
                if (!(leafBlock instanceof LOTRBlockLeavesBase)) continue;
                String[] leafNames = ((LOTRBlockLeavesBase)leafBlock).getAllLeafNames();
                for (int leafMeta = 0; leafMeta < leafNames.length; ++leafMeta) {
                    Object[] fallenBlockMeta = LOTRBlockFallenLeaves.fallenBlockMetaFromLeafBlockMeta(leafBlock, leafMeta);
                    if (fallenBlockMeta == null) continue;
                    Block fallenBlock = (Block)fallenBlockMeta[0];
                    int fallenMeta = (Integer)fallenBlockMeta[1];
                    if (fallenBlock == null) continue;
                    GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(fallenBlock, 6, fallenMeta), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(leafBlock, 1, leafMeta)}));
                }
            }
        }
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks3, 4, 1), (Object[])new Object[]{new ItemStack(LOTRMod.wood8, 1, 1)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsRedwood, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks3, 1, 1)});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daub, 4), new Object[]{"XYX", "YXY", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), Blocks.dirt}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daub, 4), new Object[]{"XYX", "YXY", "XYX", Character.valueOf('X'), LOTRMod.driedReeds, Character.valueOf('Y'), Blocks.dirt}));
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.kebabBlock, 1, 0), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.kebab});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.kebab, 9), (Object[])new Object[]{new ItemStack(LOTRMod.kebabBlock, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.blockOreStorage2, 1, 2), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.gildedIron});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.gildedIron, 9), (Object[])new Object[]{new ItemStack(LOTRMod.blockOreStorage2, 1, 2)});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks3, 4, 2), (Object[])new Object[]{new ItemStack(LOTRMod.wood8, 1, 2)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsPomegranate, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks3, 1, 2)});
        LOTRVesselRecipes.addRecipes(new ItemStack(LOTRMod.mugPomegranateJuice), new Object[]{LOTRMod.pomegranate, LOTRMod.pomegranate});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Items.item_frame), new Object[]{"XXX", "XYX", "XXX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), LOTRMod.fur}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.mattockMithril), new Object[]{"XXX", "XY ", " Y ", Character.valueOf('X'), LOTRMod.mithril, Character.valueOf('Y'), "stickWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.gammon), new Object[]{Items.cooked_porkchop, "salt"}));
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.blockOreStorage2, 1, 3), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.salt});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.salt, 9), (Object[])new Object[]{new ItemStack(LOTRMod.blockOreStorage2, 1, 3)});
        GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.saltedFlesh), new Object[]{Items.rotten_flesh, "salt"}));
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.cornBread), (Object[])new Object[]{"XXX", Character.valueOf('X'), LOTRMod.corn});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateSpruce, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(Blocks.planks, 1, 1)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateBirch, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(Blocks.planks, 1, 2)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateJungle, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(Blocks.planks, 1, 3)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateAcacia, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(Blocks.planks, 1, 4)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateDarkOak, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(Blocks.planks, 1, 5)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateShirePine, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks, 1, 0)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateMirkOak, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks, 1, 2)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateCharred, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks, 1, 3)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateApple, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks, 1, 4)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGatePear, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks, 1, 5)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateCherry, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks, 1, 6)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateMango, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks, 1, 7)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateLebethron, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks, 1, 8)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateBeech, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks, 1, 9)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateHolly, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks, 1, 10)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateBanana, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks, 1, 11)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateMaple, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks, 1, 12)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateLarch, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks, 1, 13)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateDatePalm, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks, 1, 14)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateMangrove, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks, 1, 15)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateChestnut, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks2, 1, 0)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateBaobab, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks2, 1, 1)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateCedar, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks2, 1, 2)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateFir, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks2, 1, 3)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGatePine, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks2, 1, 4)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateLemon, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks2, 1, 5)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateOrange, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks2, 1, 6)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateLime, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks2, 1, 7)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateMahogany, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks2, 1, 8)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateWillow, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks2, 1, 9)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateCypress, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks2, 1, 10)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateOlive, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks2, 1, 11)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateAspen, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks2, 1, 12)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateGreenOak, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks2, 1, 13)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateLairelosse, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks2, 1, 14)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateAlmond, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks2, 1, 15)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateRotten, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planksRotten, 1, 0)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGatePlum, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks3, 1, 0)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateRedwood, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks3, 1, 1)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGatePomegranate, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks3, 1, 2)}));
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabUtumnoSingle2, 6, 0), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.utumnoBrick, 1, 6)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabUtumnoSingle2, 6, 1), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.utumnoBrick, 1, 7)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabUtumnoSingle2, 6, 2), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.utumnoBrick, 1, 8)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsUtumnoTileIce, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.utumnoBrick, 1, 6)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsUtumnoTileObsidian, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.utumnoBrick, 1, 7)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsUtumnoTileFire, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.utumnoBrick, 1, 8)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.wallUtumno, 6, 3), (Object[])new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.utumnoBrick, 1, 6)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.wallUtumno, 6, 4), (Object[])new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.utumnoBrick, 1, 7)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.wallUtumno, 6, 5), (Object[])new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.utumnoBrick, 1, 8)});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.millstone), new Object[]{"XYX", "XZX", "XXX", Character.valueOf('X'), Blocks.cobblestone, Character.valueOf('Y'), "ingotIron", Character.valueOf('Z'), "stickWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.millstone), new Object[]{"XYX", "XZX", "XXX", Character.valueOf('X'), Blocks.cobblestone, Character.valueOf('Y'), "ingotBronze", Character.valueOf('Z'), "stickWood"}));
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.topaz, 9), (Object[])new Object[]{new ItemStack(LOTRMod.blockGem, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.blockGem, 1, 0), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.topaz});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.amethyst, 9), (Object[])new Object[]{new ItemStack(LOTRMod.blockGem, 1, 1)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.blockGem, 1, 1), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.amethyst});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.sapphire, 9), (Object[])new Object[]{new ItemStack(LOTRMod.blockGem, 1, 2)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.blockGem, 1, 2), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.sapphire});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.ruby, 9), (Object[])new Object[]{new ItemStack(LOTRMod.blockGem, 1, 3)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.blockGem, 1, 3), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.ruby});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.amber, 9), (Object[])new Object[]{new ItemStack(LOTRMod.blockGem, 1, 4)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.blockGem, 1, 4), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.amber});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.diamond, 9), (Object[])new Object[]{new ItemStack(LOTRMod.blockGem, 1, 5)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.blockGem, 1, 5), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.diamond});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.pearl, 9), (Object[])new Object[]{new ItemStack(LOTRMod.blockGem, 1, 6)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.blockGem, 1, 6), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.pearl});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.opal, 9), (Object[])new Object[]{new ItemStack(LOTRMod.blockGem, 1, 7)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.blockGem, 1, 7), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.opal});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.mushroomPie), (Object[])new Object[]{Items.egg, Blocks.red_mushroom, Blocks.brown_mushroom});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.coral, 4), (Object[])new Object[]{new ItemStack(LOTRMod.blockGem, 1, 8)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.blockGem, 1, 8), (Object[])new Object[]{"XX", "XX", Character.valueOf('X'), LOTRMod.coral});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.emerald, 9), (Object[])new Object[]{new ItemStack(LOTRMod.blockGem, 1, 9)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.blockGem, 1, 9), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.emerald});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.glass, 4), (Object[])new Object[]{"XX", "XX", Character.valueOf('X'), Blocks.glass});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.glassPane, 16), (Object[])new Object[]{"XXX", "XXX", Character.valueOf('X'), LOTRMod.glass});
        for (i2 = 0; i2 <= 15; ++i2) {
            GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stainedGlass, 4, i2), (Object[])new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack((Block)Blocks.stained_glass, 1, i2)});
            GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stainedGlass, 8, i2), new Object[]{"XXX", "XYX", "XXX", Character.valueOf('X'), LOTRMod.glass, Character.valueOf('Y'), dyeOreNames[BlockColored.func_150031_c((int)i2)]}));
            GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stainedGlassPane, 16, i2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.stainedGlass, 1, i2)}));
        }
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.rope, 3), (Object[])new Object[]{"X", "X", "X", Character.valueOf('X'), Items.string});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.mithrilMail, 8), (Object[])new Object[]{"XX", "XX", Character.valueOf('X'), LOTRMod.mithril});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.mithril, 2), (Object[])new Object[]{"XX", "XX", Character.valueOf('X'), LOTRMod.mithrilMail});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks3, 4, 3), (Object[])new Object[]{new ItemStack(LOTRMod.wood8, 1, 3)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsPalm, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks3, 1, 3)});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGatePalm, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks3, 1, 3)}));
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks3, 4, 4), (Object[])new Object[]{new ItemStack(LOTRMod.wood9, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsDragon, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks3, 1, 4)});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateDragon, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks3, 1, 4)}));
        for (i2 = 0; i2 <= 1; ++i2) {
            GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodBeam9, 3, i2), new Object[]{"X", "X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.wood9, 1, i2)}));
        }
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(Items.dye, 4, 1), (Object[])new Object[]{new ItemStack(LOTRMod.wood9, 1, 0), new ItemStack(LOTRMod.wood9, 1, 0)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(Blocks.packed_ice), (Object[])new Object[]{"XX", "XX", Character.valueOf('X'), Blocks.ice});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodPlate, 2), new Object[]{"XX", Character.valueOf('X'), "logWood"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Items.item_frame), new Object[]{"XXX", "XYX", "XXX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), LOTRMod.gemsbokHide}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorSpruce), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(Blocks.planks, 1, 1)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorBirch), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(Blocks.planks, 1, 2)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorJungle), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(Blocks.planks, 1, 3)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorAcacia), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(Blocks.planks, 1, 4)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorDarkOak), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(Blocks.planks, 1, 5)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorShirePine), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 0)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorMirkOak), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 2)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorCharred), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 3)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorApple), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 4)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorPear), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 5)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorCherry), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 6)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorMango), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 7)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorLebethron), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 8)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorBeech), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 9)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorHolly), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 10)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorBanana), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 11)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorMaple), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 12)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorLarch), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 13)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorDatePalm), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 14)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorMangrove), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 15)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorChestnut), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 0)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorBaobab), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 1)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorCedar), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 2)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorFir), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 3)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorPine), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 4)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorLemon), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 5)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorOrange), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 6)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorLime), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 7)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorMahogany), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 8)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorWillow), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 9)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorCypress), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 10)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorOlive), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 11)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorAspen), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 12)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorGreenOak), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 13)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorLairelosse), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 14)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorAlmond), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 15)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorPlum), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks3, 1, 0)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorRedwood), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks3, 1, 1)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorPomegranate), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks3, 1, 2)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorPalm), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks3, 1, 3)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorDragon), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks3, 1, 4)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorRotten), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planksRotten, 1, 0)}));
        GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(Blocks.dirt, 1, 0), new Object[]{new ItemStack(Blocks.dirt, 1, 1), Items.wheat_seeds}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.boneBlock, 1, 0), new Object[]{"XX", "XX", Character.valueOf('X'), "bone"}));
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(Items.dye, 8, 15), (Object[])new Object[]{LOTRMod.boneBlock});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabBoneSingle, 6, 0), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.boneBlock, 1, 0)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsBone, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.boneBlock, 1, 0)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wallBone, 6, 0), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.boneBlock, 1, 0)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.redClay), new Object[]{"XX", "XX", Character.valueOf('X'), LOTRMod.redClayBall}));
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.planks3, 4, 5), (Object[])new Object[]{new ItemStack(LOTRMod.wood9, 1, 1)});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.stairsKanuka, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks3, 1, 5)});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateKanuka, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(LOTRMod.planks3, 1, 5)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorKanuka), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks3, 1, 5)}));
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.mud, 4, 1), (Object[])new Object[]{"XY", "YX", Character.valueOf('X'), new ItemStack(LOTRMod.mud, 1, 0), Character.valueOf('Y'), Blocks.gravel});
        GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.mud, 1, 0), new Object[]{new ItemStack(LOTRMod.mud, 1, 1), Items.wheat_seeds}));
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.dirtPath, 2, 1), (Object[])new Object[]{"XX", Character.valueOf('X'), LOTRMod.mud});
        GameRegistry.addRecipe((ItemStack)new ItemStack(LOTRMod.slabSingleDirt, 6, 4), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.dirtPath, 1, 1)});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Items.saddle), new Object[]{"XXX", "Y Y", Character.valueOf('X'), LOTRMod.gemsbokHide, Character.valueOf('Y'), "ingotIron"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brandingIron), new Object[]{"  X", " Y ", "X  ", Character.valueOf('X'), Items.iron_ingot, Character.valueOf('Y'), Items.leather}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brandingIron), new Object[]{"  X", " Y ", "X  ", Character.valueOf('X'), Items.iron_ingot, Character.valueOf('Y'), LOTRMod.gemsbokHide}));
        GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.brandingIron), new Object[]{new ItemStack(LOTRMod.brandingIron, 1, 32767), Items.iron_ingot}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.cobblebrick, 4, 0), new Object[]{"XX", "XX", Character.valueOf('X'), Blocks.cobblestone}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorSpruce, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(Blocks.planks, 1, 1)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorBirch, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(Blocks.planks, 1, 2)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorJungle, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(Blocks.planks, 1, 3)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorAcacia, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(Blocks.planks, 1, 4)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorDarkOak, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(Blocks.planks, 1, 5)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorShirePine, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 0)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorMirkOak, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 2)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorCharred, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 3)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorApple, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 4)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorPear, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 5)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorCherry, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 6)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorMango, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 7)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorLebethron, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 8)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorBeech, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 9)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorHolly, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 10)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorBanana, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 11)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorMaple, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 12)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorLarch, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 13)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorDatePalm, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 14)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorMangrove, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 15)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorChestnut, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 0)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorBaobab, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 1)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorCedar, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 2)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorFir, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 3)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorPine, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 4)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorLemon, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 5)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorOrange, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 6)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorLime, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 7)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorMahogany, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 8)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorWillow, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 9)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorCypress, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 10)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorOlive, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 11)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorAspen, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 12)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorGreenOak, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 13)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorLairelosse, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 14)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorAlmond, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 15)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorPlum, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks3, 1, 0)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorRedwood, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks3, 1, 1)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorPomegranate, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks3, 1, 2)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorPalm, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks3, 1, 3)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorDragon, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks3, 1, 4)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorKanuka, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks3, 1, 5)}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorRotten, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planksRotten, 1, 0)}));
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(Items.dye, 1, 5), (Object[])new Object[]{LOTRMod.lavender});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(LOTRMod.ironNugget, 9), (Object[])new Object[]{Items.iron_ingot});
        GameRegistry.addRecipe((ItemStack)new ItemStack(Items.iron_ingot), (Object[])new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), LOTRMod.ironNugget});
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack((Item)Items.chainmail_helmet), new Object[]{"XXX", "Y Y", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "nuggetIron"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack((Item)Items.chainmail_chestplate), new Object[]{"X X", "YYY", "XXX", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "nuggetIron"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack((Item)Items.chainmail_leggings), new Object[]{"XXX", "Y Y", "X X", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "nuggetIron"}));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack((Item)Items.chainmail_boots), new Object[]{"Y Y", "X X", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "nuggetIron"}));
    }

    private static void createPoisonedDaggerRecipes() {
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerOrc, LOTRMod.daggerOrcPoisoned));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerUruk, LOTRMod.daggerUrukPoisoned));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerBronze, LOTRMod.daggerBronzePoisoned));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerIron, LOTRMod.daggerIronPoisoned));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerMithril, LOTRMod.daggerMithrilPoisoned));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerGondor, LOTRMod.daggerGondorPoisoned));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerElven, LOTRMod.daggerElvenPoisoned));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerDwarven, LOTRMod.daggerDwarvenPoisoned));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerRohan, LOTRMod.daggerRohanPoisoned));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerWoodElven, LOTRMod.daggerWoodElvenPoisoned));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerAngmar, LOTRMod.daggerAngmarPoisoned));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerHighElven, LOTRMod.daggerHighElvenPoisoned));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerNearHarad, LOTRMod.daggerNearHaradPoisoned));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerBlueDwarven, LOTRMod.daggerBlueDwarvenPoisoned));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerDolGuldur, LOTRMod.daggerDolGuldurPoisoned));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerBlackUruk, LOTRMod.daggerBlackUrukPoisoned));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerUtumno, LOTRMod.daggerUtumnoPoisoned));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerHalfTroll, LOTRMod.daggerHalfTrollPoisoned));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerMoredain, LOTRMod.daggerMoredainPoisoned));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerTauredain, LOTRMod.daggerTauredainPoisoned));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerBarrow, LOTRMod.daggerBarrowPoisoned));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerDolAmroth, LOTRMod.daggerDolAmrothPoisoned));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerDale, LOTRMod.daggerDalePoisoned));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerGundabadUruk, LOTRMod.daggerGundabadUrukPoisoned));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerDorwinionElf, LOTRMod.daggerDorwinionElfPoisoned));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerRhun, LOTRMod.daggerRhunPoisoned));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerRivendell, LOTRMod.daggerRivendellPoisoned));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerArnor, LOTRMod.daggerArnorPoisoned));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerCorsair, LOTRMod.daggerCorsairPoisoned));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerHarad, LOTRMod.daggerHaradPoisoned));
        GameRegistry.addRecipe((IRecipe)new LOTRRecipePoisonWeapon(LOTRMod.daggerBlackNumenorean, LOTRMod.daggerBlackNumenoreanPoisoned));
    }

    private static void createPoisonedArrowRecipes() {
        ArrayList<List> recipeLists = new ArrayList<List>();
        recipeLists.addAll(Arrays.asList(commonOrcRecipes));
        recipeLists.addAll(Arrays.asList(commonNearHaradRecipes));
        for (Object obj : recipeLists) {
            List recipes = (List)obj;
            recipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.arrowPoisoned, 4), new Object[]{" X ", "XYX", " X ", Character.valueOf('X'), Items.arrow, Character.valueOf('Y'), "poison"}));
            recipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.crossbowBoltPoisoned, 4), new Object[]{" X ", "XYX", " X ", Character.valueOf('X'), LOTRMod.crossbowBolt, Character.valueOf('Y'), "poison"}));
        }
    }

    private static void createWoodenSlabRecipes() {
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle, 6, 0), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 0)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle, 6, 2), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 2)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle, 6, 3), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 3)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle, 6, 4), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 4)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle, 6, 5), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 5)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle, 6, 6), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 6)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle, 6, 7), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 7)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle2, 6, 0), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 8)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle2, 6, 1), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 9)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle2, 6, 2), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 10)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle2, 6, 3), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 11)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle2, 6, 4), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 12)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle2, 6, 5), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 13)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle2, 6, 6), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 14)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle2, 6, 7), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 15)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle3, 6, 0), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 0)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle3, 6, 1), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 1)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle3, 6, 2), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 2)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle3, 6, 3), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 3)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle3, 6, 4), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 4)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle3, 6, 5), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 5)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle3, 6, 6), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 6)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle3, 6, 7), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 7)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle4, 6, 0), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 8)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle4, 6, 1), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 9)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle4, 6, 2), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 10)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle4, 6, 3), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 11)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle4, 6, 4), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 12)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle4, 6, 5), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 13)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle4, 6, 6), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 14)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle4, 6, 7), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks2, 1, 15)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle5, 6, 0), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks3, 1, 0)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle5, 6, 1), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks3, 1, 1)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle5, 6, 2), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks3, 1, 2)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle5, 6, 3), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks3, 1, 3)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle5, 6, 4), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks3, 1, 4)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle5, 6, 5), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks3, 1, 5)}));
        woodenSlabRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.rottenSlabSingle, 6, 0), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planksRotten, 1, 0)}));
    }

    private static void modifyStandardRecipes() {
        List recipeList = CraftingManager.getInstance().getRecipeList();
        LOTRRecipes.removeRecipesItem(recipeList, Item.getItemFromBlock((Block)Blocks.fence));
        for (int i = 0; i <= 5; ++i) {
            GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Blocks.fence, 3, i), new Object[]{"XYX", "XYX", Character.valueOf('X'), new ItemStack(Blocks.planks, 1, i), Character.valueOf('Y'), "stickWood"}));
        }
        LOTRRecipes.removeRecipesItem(recipeList, Item.getItemFromBlock((Block)Blocks.fence_gate));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Blocks.fence_gate, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), new ItemStack(Blocks.planks, 1, 0)}));
        LOTRRecipes.removeRecipesItem(recipeList, Items.wooden_door);
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Items.wooden_door), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(Blocks.planks, 1, 0)}));
        LOTRRecipes.removeRecipesItem(recipeList, Item.getItemFromBlock((Block)Blocks.trapdoor));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Blocks.trapdoor, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(Blocks.planks, 1, 0)}));
        if (LOTRConfig.removeGoldenAppleRecipes) {
            LOTRRecipes.removeRecipesItem(recipeList, Items.golden_apple);
        }
        if (LOTRConfig.removeDiamondArmorRecipes) {
            LOTRRecipes.removeRecipesItem(recipeList, (Item)Items.diamond_helmet);
            LOTRRecipes.removeRecipesItem(recipeList, (Item)Items.diamond_chestplate);
            LOTRRecipes.removeRecipesItem(recipeList, (Item)Items.diamond_leggings);
            LOTRRecipes.removeRecipesItem(recipeList, (Item)Items.diamond_boots);
        }
        LOTRRecipes.removeRecipesItemStack(recipeList, new ItemStack((Block)Blocks.stone_slab, 1, 0));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack((Block)Blocks.stone_slab, 6, 0), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.smoothStoneV, 1, 0)}));
        LOTRRecipes.removeRecipesItemStack(recipeList, new ItemStack((Block)Blocks.stone_slab, 1, 5));
        GameRegistry.addRecipe((ItemStack)new ItemStack((Block)Blocks.stone_slab, 6, 5), (Object[])new Object[]{"XXX", Character.valueOf('X'), new ItemStack(Blocks.stonebrick, 1, 0)});
        LOTRRecipes.removeRecipesItem(recipeList, Item.getItemFromBlock((Block)Blocks.stone_brick_stairs));
        GameRegistry.addRecipe((ItemStack)new ItemStack(Blocks.stone_brick_stairs, 4), (Object[])new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(Blocks.stonebrick, 1, 0)});
        LOTRRecipes.removeRecipesItem(recipeList, Item.getItemFromBlock((Block)Blocks.anvil));
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Blocks.anvil), new Object[]{"XXX", " Y ", "XXX", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "blockIron"}));
        LOTRRecipes.removeRecipesClass(recipeList, RecipesArmorDyes.class);
        GameRegistry.addRecipe((IRecipe)new LOTRRecipesArmorDyes());
    }

    private static void removeRecipesItem(List recipeList, Item outputItem) {
        ArrayList<IRecipe> recipesToRemove = new ArrayList<IRecipe>();
        for (Object obj : recipeList) {
            IRecipe recipe = (IRecipe)obj;
            ItemStack output = recipe.getRecipeOutput();
            if (output == null || output.getItem() != outputItem) continue;
            recipesToRemove.add(recipe);
        }
        recipeList.removeAll(recipesToRemove);
    }

    private static void removeRecipesItemStack(List recipeList, ItemStack outputItemStack) {
        ArrayList<IRecipe> recipesToRemove = new ArrayList<IRecipe>();
        for (Object obj : recipeList) {
            IRecipe recipe = (IRecipe)obj;
            ItemStack output = recipe.getRecipeOutput();
            if (output == null || !output.isItemEqual(outputItemStack)) continue;
            recipesToRemove.add(recipe);
        }
        recipeList.removeAll(recipesToRemove);
    }

    private static void removeRecipesClass(List recipeList, Class<? extends IRecipe> recipeClass) {
        ArrayList<IRecipe> recipesToRemove = new ArrayList<IRecipe>();
        for (Object obj : recipeList) {
            IRecipe recipe = (IRecipe)obj;
            if (!recipeClass.isAssignableFrom(recipe.getClass())) continue;
            recipesToRemove.add(recipe);
        }
        recipeList.removeAll(recipesToRemove);
    }

    private static void createSmeltingRecipes() {
        for (Object obj : Block.blockRegistry) {
            Block block = (Block)obj;
            if (!(block instanceof LOTRBlockWoodBase)) continue;
            GameRegistry.addSmelting((Block)block, (ItemStack)new ItemStack(Items.coal, 1, 1), (float)0.15f);
        }
        GameRegistry.addSmelting((Block)Blocks.stone, (ItemStack)new ItemStack(LOTRMod.scorchedStone), (float)0.1f);
        GameRegistry.addSmelting((Block)LOTRMod.rock, (ItemStack)new ItemStack(LOTRMod.scorchedStone), (float)0.1f);
        GameRegistry.addSmelting((Block)LOTRMod.whiteSand, (ItemStack)new ItemStack(Blocks.glass), (float)0.1f);
        GameRegistry.addSmelting((Block)LOTRMod.oreCopper, (ItemStack)new ItemStack(LOTRMod.copper), (float)0.35f);
        GameRegistry.addSmelting((Block)LOTRMod.oreTin, (ItemStack)new ItemStack(LOTRMod.tin), (float)0.35f);
        GameRegistry.addSmelting((Block)LOTRMod.oreSilver, (ItemStack)new ItemStack(LOTRMod.silver), (float)0.8f);
        GameRegistry.addSmelting((Block)LOTRMod.oreNaurite, (ItemStack)new ItemStack(LOTRMod.nauriteGem), (float)1.0f);
        GameRegistry.addSmelting((Block)LOTRMod.oreQuendite, (ItemStack)new ItemStack(LOTRMod.quenditeCrystal), (float)1.0f);
        GameRegistry.addSmelting((Block)LOTRMod.oreGlowstone, (ItemStack)new ItemStack(Items.glowstone_dust), (float)1.0f);
        GameRegistry.addSmelting((Block)LOTRMod.oreGulduril, (ItemStack)new ItemStack(LOTRMod.guldurilCrystal), (float)1.0f);
        GameRegistry.addSmelting((Block)LOTRMod.oreSulfur, (ItemStack)new ItemStack(LOTRMod.sulfur), (float)1.0f);
        GameRegistry.addSmelting((Block)LOTRMod.oreSaltpeter, (ItemStack)new ItemStack(LOTRMod.saltpeter), (float)1.0f);
        GameRegistry.addSmelting((Block)LOTRMod.oreSalt, (ItemStack)new ItemStack(LOTRMod.salt), (float)1.0f);
        GameRegistry.addSmelting((Item)LOTRMod.clayMug, (ItemStack)new ItemStack(LOTRMod.ceramicMug), (float)0.3f);
        GameRegistry.addSmelting((Item)LOTRMod.clayPlate, (ItemStack)new ItemStack(LOTRMod.ceramicPlate), (float)0.3f);
        GameRegistry.addSmelting((Item)LOTRMod.ceramicPlate, (ItemStack)new ItemStack(LOTRMod.plate), (float)0.3f);
        GameRegistry.addSmelting((Item)LOTRMod.redClayBall, (ItemStack)new ItemStack(Items.brick), (float)0.3f);
        GameRegistry.addSmelting((Block)LOTRMod.redClay, (ItemStack)new ItemStack(Blocks.hardened_clay), (float)0.35f);
        GameRegistry.addSmelting((Item)LOTRMod.rabbitRaw, (ItemStack)new ItemStack(LOTRMod.rabbitCooked), (float)0.35f);
        GameRegistry.addSmelting((Item)LOTRMod.lionRaw, (ItemStack)new ItemStack(LOTRMod.lionCooked), (float)0.35f);
        GameRegistry.addSmelting((Item)LOTRMod.zebraRaw, (ItemStack)new ItemStack(LOTRMod.zebraCooked), (float)0.35f);
        GameRegistry.addSmelting((Item)LOTRMod.rhinoRaw, (ItemStack)new ItemStack(LOTRMod.rhinoCooked), (float)0.35f);
        GameRegistry.addSmelting((Item)LOTRMod.muttonRaw, (ItemStack)new ItemStack(LOTRMod.muttonCooked), (float)0.35f);
        GameRegistry.addSmelting((Item)LOTRMod.deerRaw, (ItemStack)new ItemStack(LOTRMod.deerCooked), (float)0.35f);
        GameRegistry.addSmelting((Item)LOTRMod.camelRaw, (ItemStack)new ItemStack(LOTRMod.camelCooked), (float)0.35f);
        GameRegistry.addSmelting((ItemStack)new ItemStack(LOTRMod.reeds, 1, 0), (ItemStack)new ItemStack(LOTRMod.driedReeds), (float)0.25f);
        GameRegistry.addSmelting((Item)LOTRMod.pipeweedLeaf, (ItemStack)new ItemStack(LOTRMod.pipeweed), (float)0.25f);
        GameRegistry.addSmelting((Item)LOTRMod.chestnut, (ItemStack)new ItemStack(LOTRMod.chestnutRoast), (float)0.3f);
        GameRegistry.addSmelting((Item)LOTRMod.corn, (ItemStack)new ItemStack(LOTRMod.cornCooked), (float)0.3f);
        GameRegistry.addSmelting((Item)LOTRMod.turnip, (ItemStack)new ItemStack(LOTRMod.turnipCooked), (float)0.3f);
        GameRegistry.addSmelting((Item)LOTRMod.yam, (ItemStack)new ItemStack(LOTRMod.yamRoast), (float)0.3f);
        GameRegistry.addSmelting((Item)LOTRMod.grapeRed, (ItemStack)new ItemStack(LOTRMod.raisins), (float)0.3f);
        GameRegistry.addSmelting((Item)LOTRMod.grapeWhite, (ItemStack)new ItemStack(LOTRMod.raisins), (float)0.3f);
        LOTRRecipes.addSmeltingXPForItem(LOTRMod.bronze, 0.7f);
        LOTRRecipes.addSmeltingXPForItem(LOTRMod.mithril, 1.0f);
        LOTRRecipes.addSmeltingXPForItem(LOTRMod.orcSteel, 0.7f);
        LOTRRecipes.addSmeltingXPForItem(LOTRMod.dwarfSteel, 0.7f);
        LOTRRecipes.addSmeltingXPForItem(LOTRMod.galvorn, 0.8f);
        LOTRRecipes.addSmeltingXPForItem(LOTRMod.urukSteel, 0.7f);
        LOTRRecipes.addSmeltingXPForItem(LOTRMod.morgulSteel, 0.8f);
        LOTRRecipes.addSmeltingXPForItem(LOTRMod.blueDwarfSteel, 0.7f);
        LOTRRecipes.addSmeltingXPForItem(LOTRMod.blackUrukSteel, 0.7f);
        LOTRRecipes.addSmeltingXPForItem(LOTRMod.elfSteel, 0.7f);
        LOTRRecipes.addSmeltingXPForItem(LOTRMod.ithildin, 0.8f);
        LOTRRecipes.addSmeltingXPForItem(LOTRMod.gildedIron, 0.7f);
    }

    private static void addSmeltingXPForItem(Item item, float xp) {
        try {
            Field field = FurnaceRecipes.class.getDeclaredFields()[2];
            field.setAccessible(true);
            HashMap map = (HashMap)field.get((Object)FurnaceRecipes.smelting());
            map.put(new ItemStack(item, 1, 32767), Float.valueOf(xp));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addRecipeTo(List[] recipeLists, IRecipe recipe) {
        for (List list : recipeLists) {
            list.add(recipe);
        }
    }

    private static void createCommonOrcRecipes() {
        LOTRRecipes.addRecipeTo(commonOrcRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.orcBedItem), new Object[]{"XXX", "YYY", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "plankWood"}));
        LOTRRecipes.addRecipeTo(commonOrcRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.maggotyBread), new Object[]{"XXX", Character.valueOf('X'), Items.wheat}));
        for (int i = 0; i <= 2; ++i) {
            LOTRRecipes.addRecipeTo(commonOrcRecipes, (IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.orcBomb, 1, i + 8), new Object[]{new ItemStack(LOTRMod.orcBomb, 1, i), Items.lava_bucket}));
        }
        LOTRRecipes.addRecipeTo(commonOrcRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.orcSkullStaff), new Object[]{"X", "Y", "Y", Character.valueOf('X'), Items.skull, Character.valueOf('Y'), "stickWood"}));
        LOTRRecipes.addRecipeTo(commonOrcRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.orcChain, 8), new Object[]{"X", "X", "X", Character.valueOf('X'), LOTRMod.orcSteel}));
        LOTRRecipes.addRecipeTo(commonOrcRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.orcPlating, 8, 0), new Object[]{"XX", "XX", Character.valueOf('X'), LOTRMod.orcSteel}));
        LOTRRecipes.addRecipeTo(commonOrcRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.orcPlating, 8, 1), new Object[]{"XXX", "XYX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.orcPlating, 1, 0), Character.valueOf('Y'), Items.water_bucket}));
    }

    private static void createCommonMorgulRecipes() {
        LOTRRecipes.addRecipeTo(commonMorgulRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.morgulBlade), new Object[]{"X", "X", "Y", Character.valueOf('X'), LOTRMod.morgulSteel, Character.valueOf('Y'), "stickWood"}));
        LOTRRecipes.addRecipeTo(commonMorgulRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetMorgul), new Object[]{"XXX", "X X", Character.valueOf('X'), LOTRMod.morgulSteel}));
        LOTRRecipes.addRecipeTo(commonMorgulRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyMorgul), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), LOTRMod.morgulSteel}));
        LOTRRecipes.addRecipeTo(commonMorgulRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsMorgul), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), LOTRMod.morgulSteel}));
        LOTRRecipes.addRecipeTo(commonMorgulRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsMorgul), new Object[]{"X X", "X X", Character.valueOf('X'), LOTRMod.morgulSteel}));
        LOTRRecipes.addRecipeTo(commonMorgulRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.morgulTorch, 4), new Object[]{"X", "Y", Character.valueOf('X'), LOTRMod.guldurilCrystal, Character.valueOf('Y'), "stickWood"}));
        LOTRRecipes.addRecipeTo(commonMorgulRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.horseArmorMorgul), new Object[]{"X  ", "XYX", "XXX", Character.valueOf('X'), LOTRMod.morgulSteel, Character.valueOf('Y'), Items.leather}));
        LOTRRecipes.addRecipeTo(commonMorgulRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.orcBomb, 4), new Object[]{"XYX", "YXY", "XYX", Character.valueOf('X'), Items.gunpowder, Character.valueOf('Y'), LOTRMod.orcSteel}));
        LOTRRecipes.addRecipeTo(commonMorgulRecipes, (IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.orcBomb, 1, 1), new Object[]{new ItemStack(LOTRMod.orcBomb, 1, 0), Items.gunpowder, LOTRMod.orcSteel}));
        LOTRRecipes.addRecipeTo(commonMorgulRecipes, (IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.orcBomb, 1, 2), new Object[]{new ItemStack(LOTRMod.orcBomb, 1, 1), Items.gunpowder, LOTRMod.orcSteel}));
        LOTRRecipes.addRecipeTo(commonMorgulRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.chandelier, 2, 12), new Object[]{" X ", "YZY", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), LOTRMod.morgulTorch, Character.valueOf('Z'), LOTRMod.morgulSteel}));
    }

    private static void createCommonMorgulAndGundabadRecipes() {
        LOTRRecipes.addRecipeTo(commonMorgulAndGundabadRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.chandelier, 2, 7), new Object[]{" X ", "YZY", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), LOTRMod.orcTorchItem, Character.valueOf('Z'), LOTRMod.orcSteel}));
        LOTRRecipes.addRecipeTo(commonMorgulAndGundabadRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.orcSteelBars, 16), new Object[]{"XXX", "XXX", Character.valueOf('X'), LOTRMod.orcSteel}));
        LOTRRecipes.addRecipeTo(commonMorgulAndGundabadRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.orcBow), new Object[]{" XY", "X Y", " XY", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), Items.string}));
        LOTRRecipes.addRecipeTo(commonMorgulAndGundabadRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gateOrc, 4), new Object[]{"YYY", "YXY", "YYY", Character.valueOf('X'), LOTRMod.gateGear, Character.valueOf('Y'), LOTRMod.orcSteel}));
        LOTRRecipes.addRecipeTo(commonMorgulAndGundabadRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.mechanism), new Object[]{" X ", "YZY", " X ", Character.valueOf('X'), "ingotCopper", Character.valueOf('Y'), Items.flint, Character.valueOf('Z'), LOTRMod.orcSteel}));
    }

    private static void createCommonElfRecipes() {
        LOTRRecipes.addRecipeTo(commonElfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetGalvorn), new Object[]{"XXX", "X X", Character.valueOf('X'), LOTRMod.galvorn}));
        LOTRRecipes.addRecipeTo(commonElfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyGalvorn), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), LOTRMod.galvorn}));
        LOTRRecipes.addRecipeTo(commonElfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsGalvorn), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), LOTRMod.galvorn}));
        LOTRRecipes.addRecipeTo(commonElfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsGalvorn), new Object[]{"X X", "X X", Character.valueOf('X'), LOTRMod.galvorn}));
        LOTRRecipes.addRecipeTo(commonElfRecipes, new LOTRRecipePoisonWeapon(LOTRMod.chisel, LOTRMod.chiselIthildin, (Object)new ItemStack(LOTRMod.ithildin, 1, 0)));
    }

    private static void createCommonHighElfRecipes() {
        LOTRRecipes.addRecipeTo(commonHighElfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.highElvenTorch, 4), new Object[]{"X", "Y", Character.valueOf('X'), LOTRMod.quenditeCrystal, Character.valueOf('Y'), "stickWood"}));
        LOTRRecipes.addRecipeTo(commonHighElfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.chandelier, 2, 10), new Object[]{" X ", "YZY", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), LOTRMod.highElvenTorch, Character.valueOf('Z'), LOTRMod.elfSteel}));
        LOTRRecipes.addRecipeTo(commonHighElfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.highElvenBedItem), new Object[]{"XXX", "YYY", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "plankWood"}));
        LOTRRecipes.addRecipeTo(commonHighElfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick3, 4, 2), new Object[]{"XX", "XX", Character.valueOf('X'), Blocks.stone}));
        LOTRRecipes.addRecipeTo(commonHighElfRecipes, (IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.brick3, 1, 3), new Object[]{new ItemStack(LOTRMod.brick3, 1, 2), "vine"}));
        LOTRRecipes.addRecipeTo(commonHighElfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle5, 6, 5), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 4, 2)}));
        LOTRRecipes.addRecipeTo(commonHighElfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle5, 6, 6), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 4, 3)}));
        LOTRRecipes.addRecipeTo(commonHighElfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle5, 6, 7), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 4, 4)}));
        LOTRRecipes.addRecipeTo(commonHighElfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsHighElvenBrick, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 1, 2)}));
        LOTRRecipes.addRecipeTo(commonHighElfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsHighElvenBrickMossy, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 1, 3)}));
        LOTRRecipes.addRecipeTo(commonHighElfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsHighElvenBrickCracked, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 1, 4)}));
        LOTRRecipes.addRecipeTo(commonHighElfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall2, 6, 11), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 1, 2)}));
        LOTRRecipes.addRecipeTo(commonHighElfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall2, 6, 12), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 1, 3)}));
        LOTRRecipes.addRecipeTo(commonHighElfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall2, 6, 13), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 1, 4)}));
        LOTRRecipes.addRecipeTo(commonHighElfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pillar, 3, 10), new Object[]{"X", "X", "X", Character.valueOf('X'), Blocks.stone}));
        LOTRRecipes.addRecipeTo(commonHighElfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle6, 6, 0), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar, 1, 10)}));
        LOTRRecipes.addRecipeTo(commonHighElfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle6, 6, 1), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar, 1, 11)}));
        LOTRRecipes.addRecipeTo(commonHighElfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick2, 1, 13), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 1, 2)}));
        LOTRRecipes.addRecipeTo(commonHighElfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.elvenForge), new Object[]{"XXX", "X X", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 1, 2)}));
        LOTRRecipes.addRecipeTo(commonHighElfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.highElfBars, 16), new Object[]{"XXX", "XXX", Character.valueOf('X'), LOTRMod.elfSteel}));
        LOTRRecipes.addRecipeTo(commonHighElfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.highElfWoodBars, 8), new Object[]{"XXX", "XXX", Character.valueOf('X'), "stickWood"}));
        LOTRRecipes.addRecipeTo(commonHighElfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick4, 1, 8), new Object[]{" X ", "XYX", " X ", Character.valueOf('X'), "nuggetSilver", Character.valueOf('Y'), new ItemStack(LOTRMod.brick3, 1, 2)}));
        LOTRRecipes.addRecipeTo(commonHighElfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick4, 1, 11), new Object[]{" X ", "XYX", " X ", Character.valueOf('X'), "nuggetGold", Character.valueOf('Y'), new ItemStack(LOTRMod.brick3, 1, 2)}));
        LOTRRecipes.addRecipeTo(commonHighElfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gateHighElven, 4), new Object[]{"ZYZ", "YXY", "ZYZ", Character.valueOf('X'), LOTRMod.gateGear, Character.valueOf('Y'), "plankWood", Character.valueOf('Z'), LOTRMod.elfSteel}));
    }

    private static void createCommonDwarfRecipes() {
        LOTRRecipes.addRecipeTo(commonDwarfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 4, 6), new Object[]{"XX", "XX", Character.valueOf('X'), Blocks.stone}));
        LOTRRecipes.addRecipeTo(commonDwarfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsDwarvenBrick, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 6)}));
        LOTRRecipes.addRecipeTo(commonDwarfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle, 6, 7), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 6)}));
        LOTRRecipes.addRecipeTo(commonDwarfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall, 6, 7), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 6)}));
        LOTRRecipes.addRecipeTo(commonDwarfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pillar, 3, 0), new Object[]{"X", "X", "X", Character.valueOf('X'), Blocks.stone}));
        LOTRRecipes.addRecipeTo(commonDwarfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenForge), new Object[]{"XXX", "X X", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 6)}));
        LOTRRecipes.addRecipeTo(commonDwarfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle2, 6, 0), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar, 1, 0)}));
        LOTRRecipes.addRecipeTo(commonDwarfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenDoor), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), Blocks.stone}));
        LOTRRecipes.addRecipeTo(commonDwarfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenDoorIthildin), new Object[]{"XX", "XY", "XX", Character.valueOf('X'), Blocks.stone, Character.valueOf('Y'), new ItemStack(LOTRMod.ithildin, 1, 0)}));
        LOTRRecipes.addRecipeTo(commonDwarfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenBedItem), new Object[]{"XXX", "YYY", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "plankWood"}));
        LOTRRecipes.addRecipeTo(commonDwarfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 1, 8), new Object[]{" X ", "XYX", " X ", Character.valueOf('X'), "nuggetSilver", Character.valueOf('Y'), new ItemStack(LOTRMod.brick, 1, 6)}));
        LOTRRecipes.addRecipeTo(commonDwarfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 1, 9), new Object[]{" X ", "XYX", " X ", Character.valueOf('X'), "nuggetGold", Character.valueOf('Y'), new ItemStack(LOTRMod.brick, 1, 6)}));
        LOTRRecipes.addRecipeTo(commonDwarfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 1, 10), new Object[]{" X ", "XYX", " X ", Character.valueOf('X'), LOTRMod.mithrilNugget, Character.valueOf('Y'), new ItemStack(LOTRMod.brick, 1, 6)}));
        LOTRRecipes.addRecipeTo(commonDwarfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick2, 1, 12), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 6)}));
        LOTRRecipes.addRecipeTo(commonDwarfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick3, 1, 12), new Object[]{" X ", "XYX", " X ", Character.valueOf('X'), Items.glowstone_dust, Character.valueOf('Y'), new ItemStack(LOTRMod.brick, 1, 6)}));
        LOTRRecipes.addRecipeTo(commonDwarfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsDwarvenBrickCracked, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 1, 5)}));
        LOTRRecipes.addRecipeTo(commonDwarfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle7, 6, 6), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 1, 5)}));
        LOTRRecipes.addRecipeTo(commonDwarfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 5), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 1, 5)}));
        LOTRRecipes.addRecipeTo(commonDwarfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle7, 6, 7), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar2, 1, 0)}));
        LOTRRecipes.addRecipeTo(commonDwarfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick4, 4, 14), new Object[]{"XX", "XX", Character.valueOf('X'), LOTRMod.obsidianShard}));
        LOTRRecipes.addRecipeTo(commonDwarfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsDwarvenBrickObsidian, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 1, 14)}));
        LOTRRecipes.addRecipeTo(commonDwarfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle8, 6, 6), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 1, 14)}));
        LOTRRecipes.addRecipeTo(commonDwarfRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 6), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 1, 14)}));
        LOTRRecipes.addRecipeTo(commonDwarfRecipes, new LOTRRecipePoisonWeapon(LOTRMod.chisel, LOTRMod.chiselIthildin, (Object)new ItemStack(LOTRMod.ithildin, 1, 0)));
    }

    private static void createCommonDunedainRecipes() {
    }

    private static void createCommonNumenoreanRecipes() {
        LOTRRecipes.addRecipeTo(commonNumenoreanRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick2, 4, 11), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 0)}));
        LOTRRecipes.addRecipeTo(commonNumenoreanRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle5, 6, 3), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 11)}));
        LOTRRecipes.addRecipeTo(commonNumenoreanRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsBlackGondorBrick, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 11)}));
        LOTRRecipes.addRecipeTo(commonNumenoreanRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall2, 6, 10), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 11)}));
        LOTRRecipes.addRecipeTo(commonNumenoreanRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pillar, 3, 9), new Object[]{"X", "X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 0)}));
        LOTRRecipes.addRecipeTo(commonNumenoreanRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle5, 6, 4), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar, 1, 9)}));
    }

    private static void createCommonNearHaradRecipes() {
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 4, 15), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(Blocks.sandstone, 1, 0)}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle4, 6, 0), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 15)}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsNearHaradBrick, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 15)}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall, 6, 15), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 15)}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pillar, 3, 5), new Object[]{"X", "X", "X", Character.valueOf('X'), new ItemStack(Blocks.sandstone, 1, 0)}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle4, 6, 7), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar, 1, 5)}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick3, 1, 8), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 15)}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle7, 6, 1), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 1, 11)}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsNearHaradBrickCracked, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 1, 11)}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall3, 6, 3), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 1, 11)}));
        LOTRRecipes.addDyeableWoolRobeRecipes(commonNearHaradRecipes, new ItemStack(LOTRMod.helmetHaradRobes), new Object[]{"XXX", "X X", Character.valueOf('X'), Blocks.wool});
        LOTRRecipes.addDyeableWoolRobeRecipes(commonNearHaradRecipes, new ItemStack(LOTRMod.bodyHaradRobes), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), Blocks.wool});
        LOTRRecipes.addDyeableWoolRobeRecipes(commonNearHaradRecipes, new ItemStack(LOTRMod.legsHaradRobes), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), Blocks.wool});
        LOTRRecipes.addDyeableWoolRobeRecipes(commonNearHaradRecipes, new ItemStack(LOTRMod.bootsHaradRobes), new Object[]{"X X", "X X", Character.valueOf('X'), Blocks.wool});
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, new LOTRRecipeHaradRobesDye());
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, new LOTRRecipeHaradTurbanOrnament());
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick3, 4, 13), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.redSandstone, 1, 0)}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle7, 6, 2), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 1, 13)}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsNearHaradBrickRed, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 1, 13)}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall3, 6, 4), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 1, 13)}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick3, 1, 15), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 1, 13)}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle7, 6, 3), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 1, 14)}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsNearHaradBrickRedCracked, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 1, 14)}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall3, 6, 5), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 1, 14)}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pillar, 3, 15), new Object[]{"X", "X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.redSandstone, 1, 0)}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle7, 6, 4), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar, 1, 15)}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick4, 1, 7), new Object[]{" X ", "XYX", " X ", Character.valueOf('X'), "gemLapis", Character.valueOf('Y'), new ItemStack(LOTRMod.brick, 1, 15)}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gateNearHarad, 4), new Object[]{"ZYZ", "YXY", "ZYZ", Character.valueOf('X'), LOTRMod.gateGear, Character.valueOf('Y'), "plankWood", Character.valueOf('Z'), "ingotBronze"}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.kebabStand), new Object[]{" X ", " Y ", "ZZZ", Character.valueOf('X'), "plankWood", Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), Blocks.cobblestone}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.shishKebab, 2), new Object[]{"  X", " X ", "Y  ", Character.valueOf('X'), LOTRMod.kebab, Character.valueOf('Y'), "stickWood"}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.nearHaradBow), new Object[]{" XY", "X Y", " XY", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), Items.string}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetNomad), new Object[]{"XXX", "X X", Character.valueOf('X'), LOTRMod.driedReeds}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyNomad), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), LOTRMod.driedReeds}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsNomad), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), LOTRMod.driedReeds}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsNomad), new Object[]{"X X", "X X", Character.valueOf('X'), LOTRMod.driedReeds}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.swordHarad), new Object[]{"X", "X", "Y", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), "stickWood"}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerHarad), new Object[]{"X", "Y", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), "stickWood"}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.spearHarad), new Object[]{"  X", " Y ", "Y  ", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), "stickWood"}));
        LOTRRecipes.addRecipeTo(commonNearHaradRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pikeHarad), new Object[]{"  X", " YX", "Y  ", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), "stickWood"}));
    }

    private static void createCommonHobbitRecipes() {
        LOTRRecipes.addRecipeTo(commonHobbitRecipes, (IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hobbitOven), new Object[]{"XXX", "X X", "XXX", Character.valueOf('X'), Blocks.brick_block}));
    }

    private static void createMorgulRecipes() {
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 4, 0), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 0)}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.morgulTable), new Object[]{"XX", "YY", Character.valueOf('X'), "plankWood", Character.valueOf('Y'), new ItemStack(LOTRMod.rock, 1, 0)}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle10, 6, 7), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 0)}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.smoothStone, 2, 0), new Object[]{"X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 0)}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle, 6, 0), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.smoothStone, 1, 0)}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle, 6, 1), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 0)}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsMordorBrick, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 0)}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall, 6, 0), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 0)}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall, 6, 1), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 0)}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.orcTorchItem, 2), new Object[]{"X", "Y", "Y", Character.valueOf('X'), LOTRMod.nauriteGem, Character.valueOf('Y'), "stickWood"}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle2, 6, 2), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 7)}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsMordorBrickCracked, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 7)}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall, 6, 9), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 7)}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.orcForge), new Object[]{"XXX", "X X", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 0)}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.MORDOR.bannerID), new Object[]{"X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wargArmorMordor), new Object[]{"X  ", "XYX", "XXX", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), Items.leather}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.scimitarOrc), new Object[]{"X", "X", "Y", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.battleaxeOrc), new Object[]{"XXX", "XYX", " Y ", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerOrc), new Object[]{"X", "Y", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetOrc), new Object[]{"XXX", "X X", Character.valueOf('X'), LOTRMod.orcSteel}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyOrc), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), LOTRMod.orcSteel}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsOrc), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), LOTRMod.orcSteel}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsOrc), new Object[]{"X X", "X X", Character.valueOf('X'), LOTRMod.orcSteel}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.spearOrc), new Object[]{"  X", " Y ", "Y  ", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.shovelOrc), new Object[]{"X", "Y", "Y", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pickaxeOrc), new Object[]{"XXX", " Y ", " Y ", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.axeOrc), new Object[]{"XX", "XY", " Y", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hoeOrc), new Object[]{"XX", " Y", " Y", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hammerOrc), new Object[]{"XYX", "XYX", " Y ", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pillar, 3, 7), new Object[]{"X", "X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 0)}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle5, 6, 1), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar, 1, 7)}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick2, 1, 10), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 0)}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.scimitarBlackUruk), new Object[]{"X", "X", "Y", Character.valueOf('X'), LOTRMod.blackUrukSteel, Character.valueOf('Y'), "stickWood"}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerBlackUruk), new Object[]{"X", "Y", Character.valueOf('X'), LOTRMod.blackUrukSteel, Character.valueOf('Y'), "stickWood"}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.spearBlackUruk), new Object[]{"  X", " Y ", "Y  ", Character.valueOf('X'), LOTRMod.blackUrukSteel, Character.valueOf('Y'), "stickWood"}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.battleaxeBlackUruk), new Object[]{"XXX", "XYX", " Y ", Character.valueOf('X'), LOTRMod.blackUrukSteel, Character.valueOf('Y'), "stickWood"}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hammerBlackUruk), new Object[]{"XYX", "XYX", " Y ", Character.valueOf('X'), LOTRMod.blackUrukSteel, Character.valueOf('Y'), "stickWood"}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetBlackUruk), new Object[]{"XXX", "X X", Character.valueOf('X'), LOTRMod.blackUrukSteel}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyBlackUruk), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), LOTRMod.blackUrukSteel}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsBlackUruk), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), LOTRMod.blackUrukSteel}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsBlackUruk), new Object[]{"X X", "X X", Character.valueOf('X'), LOTRMod.blackUrukSteel}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.blackUrukBow), new Object[]{" XY", "X Y", " XY", Character.valueOf('X'), LOTRMod.blackUrukSteel, Character.valueOf('Y'), Items.string}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.polearmOrc), new Object[]{" XX", " YX", "Y  ", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsMordorRock, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 0)}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.MINAS_MORGUL.bannerID), new Object[]{"XA", "Y ", "Z ", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood", Character.valueOf('A'), new ItemStack(Items.skull, 1, 0)}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.BLACK_URUK.bannerID), new Object[]{"XA", "Y ", "Z ", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood", Character.valueOf('A'), LOTRMod.blackUrukSteel}));
        morgulRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.NAN_UNGOL.bannerID), new Object[]{"XA", "Y ", "Z ", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood", Character.valueOf('A'), Items.string}));
    }

    private static void createElvenRecipes() {
        elvenRecipes.add((IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.planks, 4, 1), new Object[]{new ItemStack(LOTRMod.wood, 1, 1)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodSlabSingle, 6, 1), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 1)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsMallorn, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 1)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.elvenTable), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 1)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.mallornStick, 4), new Object[]{"X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 1)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.shovelMallorn), new Object[]{"X", "Y", "Y", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 1), Character.valueOf('Y'), LOTRMod.mallornStick}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pickaxeMallorn), new Object[]{"XXX", " Y ", " Y ", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 1), Character.valueOf('Y'), LOTRMod.mallornStick}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.axeMallorn), new Object[]{"XX", "XY", " Y", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 1), Character.valueOf('Y'), LOTRMod.mallornStick}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.swordMallorn), new Object[]{"X", "X", "Y", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 1), Character.valueOf('Y'), LOTRMod.mallornStick}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hoeMallorn), new Object[]{"XX", " Y", " Y", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 1), Character.valueOf('Y'), LOTRMod.mallornStick}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.shovelElven), new Object[]{"X", "Y", "Y", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), LOTRMod.mallornStick}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pickaxeElven), new Object[]{"XXX", " Y ", " Y ", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), LOTRMod.mallornStick}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.axeElven), new Object[]{"XX", "XY", " Y", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), LOTRMod.mallornStick}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.swordElven), new Object[]{"X", "X", "Y", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), LOTRMod.mallornStick}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hoeElven), new Object[]{"XX", " Y", " Y", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), LOTRMod.mallornStick}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.spearElven), new Object[]{"  X", " Y ", "Y  ", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), LOTRMod.mallornStick}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.mallornBow), new Object[]{" XY", "X Y", " XY", Character.valueOf('X'), LOTRMod.mallornStick, Character.valueOf('Y'), Items.string}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetElven), new Object[]{"XXX", "X X", Character.valueOf('X'), LOTRMod.elfSteel}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyElven), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), LOTRMod.elfSteel}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsElven), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), LOTRMod.elfSteel}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsElven), new Object[]{"X X", "X X", Character.valueOf('X'), LOTRMod.elfSteel}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.mallornLadder, 3), new Object[]{"X X", "XXX", "X X", Character.valueOf('X'), LOTRMod.mallornStick}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.elvenBow), new Object[]{" XY", "X Y", " XY", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), Items.string}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerElven), new Object[]{"X", "Y", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), LOTRMod.mallornStick}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.elvenBedItem), new Object[]{"XXX", "YYY", Character.valueOf('X'), LOTRMod.hithlain, Character.valueOf('Y'), new ItemStack(LOTRMod.planks, 1, 1)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fence, 3, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 1), Character.valueOf('Y'), LOTRMod.mallornStick}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.GALADHRIM.bannerID), new Object[]{"X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), LOTRMod.mallornStick, Character.valueOf('Z'), new ItemStack(LOTRMod.planks, 1, 1)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.horseArmorGaladhrim), new Object[]{"X  ", "XYX", "XXX", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), Items.leather}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 4, 11), new Object[]{"XX", "XX", Character.valueOf('X'), Blocks.stone}));
        elvenRecipes.add((IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.brick, 1, 12), new Object[]{new ItemStack(LOTRMod.brick, 1, 11), "vine"}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle2, 6, 3), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 4, 11)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle2, 6, 4), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 4, 12)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle2, 6, 5), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 4, 13)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsElvenBrick, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 11)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsElvenBrickMossy, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 12)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsElvenBrickCracked, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 13)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall, 6, 10), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 11)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall, 6, 11), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 12)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall, 6, 12), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 13)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pillar, 3, 1), new Object[]{"X", "X", "X", Character.valueOf('X'), Blocks.stone}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle2, 6, 6), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar, 1, 1)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle2, 6, 7), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar, 1, 2)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick2, 1, 15), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 11)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.elvenForge), new Object[]{"XXX", "X X", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 11)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.galadhrimBars, 16), new Object[]{"XXX", "XXX", Character.valueOf('X'), LOTRMod.elfSteel}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.galadhrimWoodBars, 8), new Object[]{"XXX", "XXX", Character.valueOf('X'), LOTRMod.mallornStick}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.polearmElven), new Object[]{"  X", " Y ", "X  ", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), LOTRMod.mallornStick}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hithlain, 3), new Object[]{"XXX", Character.valueOf('X'), Items.string}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetHithlain), new Object[]{"XXX", "X X", Character.valueOf('X'), LOTRMod.hithlain}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyHithlain), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), LOTRMod.hithlain}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsHithlain), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), LOTRMod.hithlain}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsHithlain), new Object[]{"X X", "X X", Character.valueOf('X'), LOTRMod.hithlain}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hithlainLadder, 3), new Object[]{"X", "X", "X", Character.valueOf('X'), LOTRMod.hithlain}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodBeam1, 3, 1), new Object[]{"X", "X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.wood, 1, 1)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick4, 1, 9), new Object[]{" X ", "XYX", " X ", Character.valueOf('X'), "nuggetSilver", Character.valueOf('Y'), new ItemStack(LOTRMod.brick, 1, 11)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick4, 1, 12), new Object[]{" X ", "XYX", " X ", Character.valueOf('X'), "nuggetGold", Character.valueOf('Y'), new ItemStack(LOTRMod.brick, 1, 11)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gateElven, 4), new Object[]{"ZYZ", "YXY", "ZYZ", Character.valueOf('X'), LOTRMod.gateGear, Character.valueOf('Y'), new ItemStack(LOTRMod.planks, 1, 1), Character.valueOf('Z'), LOTRMod.elfSteel}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.longspearElven), new Object[]{"  X", " YX", "Y  ", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), LOTRMod.mallornStick}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.chestMallorn), new Object[]{"XXX", "XYX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 1)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.mallornTorchSilver, 4), new Object[]{"Z", "X", "Y", Character.valueOf('X'), new ItemStack(Items.coal, 1, 32767), Character.valueOf('Y'), LOTRMod.mallornStick, Character.valueOf('Z'), new ItemStack(LOTRMod.leaves7, 1, 2)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.mallornTorchSilver, 4), new Object[]{"Z", "X", "Y", Character.valueOf('X'), new ItemStack(Items.coal, 1, 32767), Character.valueOf('Y'), LOTRMod.mallornStick, Character.valueOf('Z'), new ItemStack(LOTRMod.niphredil, 1, 0)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.chandelier, 2, 5), new Object[]{" X ", "YZY", Character.valueOf('X'), LOTRMod.mallornStick, Character.valueOf('Y'), LOTRMod.mallornTorchSilver, Character.valueOf('Z'), new ItemStack(LOTRMod.planks, 1, 1)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.mallornTorchBlue, 4), new Object[]{"Z", "X", "Y", Character.valueOf('X'), new ItemStack(Items.coal, 1, 32767), Character.valueOf('Y'), LOTRMod.mallornStick, Character.valueOf('Z'), LOTRMod.quenditeCrystal}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.mallornTorchBlue, 4), new Object[]{"Z", "X", "Y", Character.valueOf('X'), new ItemStack(Items.coal, 1, 32767), Character.valueOf('Y'), LOTRMod.mallornStick, Character.valueOf('Z'), new ItemStack(LOTRMod.bluebell, 1, 0)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.chandelier, 2, 13), new Object[]{" X ", "YZY", Character.valueOf('X'), LOTRMod.mallornStick, Character.valueOf('Y'), LOTRMod.mallornTorchBlue, Character.valueOf('Z'), new ItemStack(LOTRMod.planks, 1, 1)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.mallornTorchGold, 4), new Object[]{"Z", "X", "Y", Character.valueOf('X'), new ItemStack(Items.coal, 1, 32767), Character.valueOf('Y'), LOTRMod.mallornStick, Character.valueOf('Z'), new ItemStack(LOTRMod.leaves, 1, 1)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.mallornTorchGold, 4), new Object[]{"Z", "X", "Y", Character.valueOf('X'), new ItemStack(Items.coal, 1, 32767), Character.valueOf('Y'), LOTRMod.mallornStick, Character.valueOf('Z'), new ItemStack(LOTRMod.elanor, 1, 0)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.chandelier, 2, 14), new Object[]{" X ", "YZY", Character.valueOf('X'), LOTRMod.mallornStick, Character.valueOf('Y'), LOTRMod.mallornTorchGold, Character.valueOf('Z'), new ItemStack(LOTRMod.planks, 1, 1)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.mallornTorchGreen, 4), new Object[]{"Z", "X", "Y", Character.valueOf('X'), new ItemStack(Items.coal, 1, 32767), Character.valueOf('Y'), LOTRMod.mallornStick, Character.valueOf('Z'), new ItemStack((Block)Blocks.leaves, 1, 0)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.mallornTorchGreen, 4), new Object[]{"Z", "X", "Y", Character.valueOf('X'), new ItemStack(Items.coal, 1, 32767), Character.valueOf('Y'), LOTRMod.mallornStick, Character.valueOf('Z'), LOTRMod.clover}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.chandelier, 2, 15), new Object[]{" X ", "YZY", Character.valueOf('X'), LOTRMod.mallornStick, Character.valueOf('Y'), LOTRMod.mallornTorchGreen, Character.valueOf('Z'), new ItemStack(LOTRMod.planks, 1, 1)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.fenceGateMallorn, 1), new Object[]{"XYX", "XYX", Character.valueOf('X'), LOTRMod.mallornStick, Character.valueOf('Y'), new ItemStack(LOTRMod.planks, 1, 1)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.doorMallorn), new Object[]{"XX", "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 1)}));
        elvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.trapdoorMallorn, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 1)}));
    }

    private static void createDwarvenRecipes() {
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenTable), new Object[]{"XX", "YY", Character.valueOf('X'), "plankWood", Character.valueOf('Y'), new ItemStack(LOTRMod.brick, 1, 6)}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.shovelDwarven), new Object[]{"X", "Y", "Y", Character.valueOf('X'), LOTRMod.dwarfSteel, Character.valueOf('Y'), "stickWood"}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pickaxeDwarven), new Object[]{"XXX", " Y ", " Y ", Character.valueOf('X'), LOTRMod.dwarfSteel, Character.valueOf('Y'), "stickWood"}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.axeDwarven), new Object[]{"XX", "XY", " Y", Character.valueOf('X'), LOTRMod.dwarfSteel, Character.valueOf('Y'), "stickWood"}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.swordDwarven), new Object[]{"X", "X", "Y", Character.valueOf('X'), LOTRMod.dwarfSteel, Character.valueOf('Y'), "stickWood"}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hoeDwarven), new Object[]{"XX", " Y", " Y", Character.valueOf('X'), LOTRMod.dwarfSteel, Character.valueOf('Y'), "stickWood"}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerDwarven), new Object[]{"X", "Y", Character.valueOf('X'), LOTRMod.dwarfSteel, Character.valueOf('Y'), "stickWood"}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.battleaxeDwarven), new Object[]{"XXX", "XYX", " Y ", Character.valueOf('X'), LOTRMod.dwarfSteel, Character.valueOf('Y'), "stickWood"}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hammerDwarven), new Object[]{"XYX", "XYX", " Y ", Character.valueOf('X'), LOTRMod.dwarfSteel, Character.valueOf('Y'), "stickWood"}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetDwarven), new Object[]{"XXX", "X X", Character.valueOf('X'), LOTRMod.dwarfSteel}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyDwarven), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), LOTRMod.dwarfSteel}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsDwarven), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), LOTRMod.dwarfSteel}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsDwarven), new Object[]{"X X", "X X", Character.valueOf('X'), LOTRMod.dwarfSteel}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.throwingAxeDwarven), new Object[]{" X ", " YX", "Y  ", Character.valueOf('X'), LOTRMod.dwarfSteel, Character.valueOf('Y'), "stickWood"}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.chandelier, 2, 8), new Object[]{" X ", "YZY", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), Blocks.torch, Character.valueOf('Z'), LOTRMod.dwarfSteel}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.mattockDwarven), new Object[]{"XXX", "XY ", " Y ", Character.valueOf('X'), LOTRMod.dwarfSteel, Character.valueOf('Y'), "stickWood"}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.DWARF.bannerID), new Object[]{"X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.spearDwarven), new Object[]{"  X", " Y ", "Y  ", Character.valueOf('X'), LOTRMod.dwarfSteel, Character.valueOf('Y'), "stickWood"}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetDwarvenSilver), new Object[]{"XXX", "XYX", "XXX", Character.valueOf('X'), "nuggetSilver", Character.valueOf('Y'), LOTRMod.helmetDwarven}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyDwarvenSilver), new Object[]{"XXX", "XYX", "XXX", Character.valueOf('X'), "nuggetSilver", Character.valueOf('Y'), LOTRMod.bodyDwarven}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsDwarvenSilver), new Object[]{"XXX", "XYX", "XXX", Character.valueOf('X'), "nuggetSilver", Character.valueOf('Y'), LOTRMod.legsDwarven}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsDwarvenSilver), new Object[]{"XXX", "XYX", "XXX", Character.valueOf('X'), "nuggetSilver", Character.valueOf('Y'), LOTRMod.bootsDwarven}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetDwarvenGold), new Object[]{"XXX", "XYX", "XXX", Character.valueOf('X'), "nuggetGold", Character.valueOf('Y'), LOTRMod.helmetDwarven}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyDwarvenGold), new Object[]{"XXX", "XYX", "XXX", Character.valueOf('X'), "nuggetGold", Character.valueOf('Y'), LOTRMod.bodyDwarven}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsDwarvenGold), new Object[]{"XXX", "XYX", "XXX", Character.valueOf('X'), "nuggetGold", Character.valueOf('Y'), LOTRMod.legsDwarven}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsDwarvenGold), new Object[]{"XXX", "XYX", "XXX", Character.valueOf('X'), "nuggetGold", Character.valueOf('Y'), LOTRMod.bootsDwarven}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetDwarvenMithril), new Object[]{"XXX", "XYX", "XXX", Character.valueOf('X'), LOTRMod.mithrilNugget, Character.valueOf('Y'), LOTRMod.helmetDwarven}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyDwarvenMithril), new Object[]{"XXX", "XYX", "XXX", Character.valueOf('X'), LOTRMod.mithrilNugget, Character.valueOf('Y'), LOTRMod.bodyDwarven}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsDwarvenMithril), new Object[]{"XXX", "XYX", "XXX", Character.valueOf('X'), LOTRMod.mithrilNugget, Character.valueOf('Y'), LOTRMod.legsDwarven}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsDwarvenMithril), new Object[]{"XXX", "XYX", "XXX", Character.valueOf('X'), LOTRMod.mithrilNugget, Character.valueOf('Y'), LOTRMod.bootsDwarven}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.dwarfBars, 16), new Object[]{"XXX", "XXX", Character.valueOf('X'), LOTRMod.dwarfSteel}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.boarArmorDwarven), new Object[]{"X  ", "XYX", "XXX", Character.valueOf('X'), LOTRMod.dwarfSteel, Character.valueOf('Y'), Items.leather}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pikeDwarven), new Object[]{"  X", " YX", "Y  ", Character.valueOf('X'), LOTRMod.dwarfSteel, Character.valueOf('Y'), "stickWood"}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gateDwarven, 4), new Object[]{"ZYZ", "YXY", "ZYZ", Character.valueOf('X'), LOTRMod.gateGear, Character.valueOf('Y'), new ItemStack(LOTRMod.brick, 1, 6), Character.valueOf('Z'), LOTRMod.dwarfSteel}));
        dwarvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.mechanism), new Object[]{" X ", "YZY", " X ", Character.valueOf('X'), "ingotCopper", Character.valueOf('Y'), Items.flint, Character.valueOf('Z'), LOTRMod.dwarfSteel}));
    }

    private static void createUrukRecipes() {
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.urukTable), new Object[]{"XX", "YY", Character.valueOf('X'), "plankWood", Character.valueOf('Y'), new ItemStack(LOTRMod.brick2, 1, 7)}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.orcTorchItem, 2), new Object[]{"X", "Y", "Y", Character.valueOf('X'), new ItemStack(Items.coal, 1, 32767), Character.valueOf('Y'), "stickWood"}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.shovelUruk), new Object[]{"X", "Y", "Y", Character.valueOf('X'), LOTRMod.urukSteel, Character.valueOf('Y'), "stickWood"}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pickaxeUruk), new Object[]{"XXX", " Y ", " Y ", Character.valueOf('X'), LOTRMod.urukSteel, Character.valueOf('Y'), "stickWood"}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.axeUruk), new Object[]{"XX", "XY", " Y", Character.valueOf('X'), LOTRMod.urukSteel, Character.valueOf('Y'), "stickWood"}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.scimitarUruk), new Object[]{"X", "X", "Y", Character.valueOf('X'), LOTRMod.urukSteel, Character.valueOf('Y'), "stickWood"}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hoeUruk), new Object[]{"XX", " Y", " Y", Character.valueOf('X'), LOTRMod.urukSteel, Character.valueOf('Y'), "stickWood"}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerUruk), new Object[]{"X", "Y", Character.valueOf('X'), LOTRMod.urukSteel, Character.valueOf('Y'), "stickWood"}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.battleaxeUruk), new Object[]{"XXX", "XYX", " Y ", Character.valueOf('X'), LOTRMod.urukSteel, Character.valueOf('Y'), "stickWood"}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hammerUruk), new Object[]{"XYX", "XYX", " Y ", Character.valueOf('X'), LOTRMod.urukSteel, Character.valueOf('Y'), "stickWood"}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.spearUruk), new Object[]{"  X", " Y ", "Y  ", Character.valueOf('X'), LOTRMod.urukSteel, Character.valueOf('Y'), "stickWood"}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetUruk), new Object[]{"XXX", "X X", Character.valueOf('X'), LOTRMod.urukSteel}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyUruk), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), LOTRMod.urukSteel}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsUruk), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), LOTRMod.urukSteel}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsUruk), new Object[]{"X X", "X X", Character.valueOf('X'), LOTRMod.urukSteel}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.urukCrossbow), new Object[]{"XXY", "ZYX", "YZX", Character.valueOf('X'), LOTRMod.urukSteel, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), Items.string}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.chandelier, 2, 9), new Object[]{" X ", "YZY", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), LOTRMod.orcTorchItem, Character.valueOf('Z'), LOTRMod.urukSteel}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.orcForge), new Object[]{"XXX", "X X", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 7)}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.orcBomb, 4), new Object[]{"XYX", "YXY", "XYX", Character.valueOf('X'), Items.gunpowder, Character.valueOf('Y'), LOTRMod.urukSteel}));
        urukRecipes.add((IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.orcBomb, 1, 1), new Object[]{new ItemStack(LOTRMod.orcBomb, 1, 0), Items.gunpowder, LOTRMod.urukSteel}));
        urukRecipes.add((IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.orcBomb, 1, 2), new Object[]{new ItemStack(LOTRMod.orcBomb, 1, 1), Items.gunpowder, LOTRMod.urukSteel}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.ISENGARD.bannerID), new Object[]{"X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wargArmorUruk), new Object[]{"X  ", "XYX", "XXX", Character.valueOf('X'), LOTRMod.urukSteel, Character.valueOf('Y'), Items.leather}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick2, 4, 7), new Object[]{"XX", "XX", Character.valueOf('X'), Blocks.stone}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle4, 6, 4), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 7)}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsUrukBrick, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 7)}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall2, 6, 7), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 7)}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.urukBars, 16), new Object[]{"XXX", "XXX", Character.valueOf('X'), LOTRMod.urukSteel}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pikeUruk), new Object[]{"  X", " YX", "Y  ", Character.valueOf('X'), LOTRMod.urukSteel, Character.valueOf('Y'), "stickWood"}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.scimitarUrukBerserker), new Object[]{"XXX", " X ", " Y ", Character.valueOf('X'), LOTRMod.urukSteel, Character.valueOf('Y'), "stickWood"}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetUrukBerserker), new Object[]{"XYX", " Z ", Character.valueOf('X'), LOTRMod.urukSteel, Character.valueOf('Y'), "dyeWhite", Character.valueOf('Z'), new ItemStack(LOTRMod.helmetUruk, 1, 0)}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gateUruk, 4), new Object[]{"YYY", "YXY", "YYY", Character.valueOf('X'), LOTRMod.gateGear, Character.valueOf('Y'), LOTRMod.urukSteel}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pillar2, 3, 15), new Object[]{"X", "X", "X", Character.valueOf('X'), Blocks.stone}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle14, 6, 3), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar2, 1, 15)}));
        urukRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.mechanism), new Object[]{" X ", "YZY", " X ", Character.valueOf('X'), "ingotCopper", Character.valueOf('Y'), Items.flint, Character.valueOf('Z'), LOTRMod.urukSteel}));
    }

    private static void createWoodElvenRecipes() {
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodElvenTable), new Object[]{"XX", "XX", Character.valueOf('X'), "plankWood"}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodElvenBedItem), new Object[]{"XXX", "YYY", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "plankWood"}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetWoodElvenScout), new Object[]{"XXX", "X X", Character.valueOf('X'), Items.leather}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyWoodElvenScout), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), Items.leather}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsWoodElvenScout), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), Items.leather}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsWoodElvenScout), new Object[]{"X X", "X X", Character.valueOf('X'), Items.leather}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.mirkwoodBow), new Object[]{" XY", "X Y", " XY", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), Items.string}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodElvenTorch, 4), new Object[]{"X", "Y", "Z", Character.valueOf('X'), new ItemStack(LOTRMod.leaves, 1, 3), Character.valueOf('Y'), new ItemStack(Items.coal, 1, 32767), Character.valueOf('Z'), "stickWood"}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.chandelier, 2, 6), new Object[]{" X ", "YZY", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), LOTRMod.woodElvenTorch, Character.valueOf('Z'), "plankWood"}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.shovelWoodElven), new Object[]{"X", "Y", "Y", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pickaxeWoodElven), new Object[]{"XXX", " Y ", " Y ", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.axeWoodElven), new Object[]{"XX", "XY", " Y", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.swordWoodElven), new Object[]{"X", "X", "Y", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hoeWoodElven), new Object[]{"XX", " Y", " Y", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerWoodElven), new Object[]{"X", "Y", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.spearWoodElven), new Object[]{"  X", " Y ", "Y  ", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetWoodElven), new Object[]{"XXX", "X X", Character.valueOf('X'), LOTRMod.elfSteel}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyWoodElven), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), LOTRMod.elfSteel}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsWoodElven), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), LOTRMod.elfSteel}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsWoodElven), new Object[]{"X X", "X X", Character.valueOf('X'), LOTRMod.elfSteel}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.WOOD_ELF.bannerID), new Object[]{"X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.elkArmorWoodElven), new Object[]{"X  ", "XYX", "XXX", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), Items.leather}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick3, 4, 5), new Object[]{"XX", "XX", Character.valueOf('X'), Blocks.stone}));
        woodElvenRecipes.add((IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.brick3, 1, 6), new Object[]{new ItemStack(LOTRMod.brick3, 1, 5), "vine"}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle6, 6, 2), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 4, 5)}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle6, 6, 3), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 4, 6)}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle6, 6, 4), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 4, 7)}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsWoodElvenBrick, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 1, 5)}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsWoodElvenBrickMossy, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 1, 6)}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsWoodElvenBrickCracked, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 1, 7)}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall3, 6, 0), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 1, 5)}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall3, 6, 1), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 1, 6)}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall3, 6, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 1, 7)}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pillar, 3, 12), new Object[]{"X", "X", "X", Character.valueOf('X'), Blocks.stone}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle6, 6, 5), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar, 1, 12)}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle6, 6, 6), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar, 1, 13)}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick2, 1, 14), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 1, 5)}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.elvenForge), new Object[]{"XXX", "X X", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 1, 5)}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodElfBars, 16), new Object[]{"XXX", "XXX", Character.valueOf('X'), LOTRMod.elfSteel}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodElfWoodBars, 8), new Object[]{"XXX", "XXX", Character.valueOf('X'), "stickWood"}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.polearmWoodElven), new Object[]{"  X", " Y ", "X  ", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick4, 1, 10), new Object[]{" X ", "XYX", " X ", Character.valueOf('X'), "nuggetSilver", Character.valueOf('Y'), new ItemStack(LOTRMod.brick3, 1, 5)}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick4, 1, 13), new Object[]{" X ", "XYX", " X ", Character.valueOf('X'), "nuggetGold", Character.valueOf('Y'), new ItemStack(LOTRMod.brick3, 1, 5)}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gateWoodElven, 4), new Object[]{"ZYZ", "YXY", "ZYZ", Character.valueOf('X'), LOTRMod.gateGear, Character.valueOf('Y'), "plankWood", Character.valueOf('Z'), LOTRMod.elfSteel}));
        woodElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.longspearWoodElven), new Object[]{"  X", " YX", "Y  ", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"}));
    }

    private static void createGondorianRecipes() {
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gondorianTable), new Object[]{"XX", "YY", Character.valueOf('X'), "plankWood", Character.valueOf('Y'), new ItemStack(LOTRMod.rock, 1, 1)}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.beacon), new Object[]{"XXX", "XXX", "YYY", Character.valueOf('X'), "logWood", Character.valueOf('Y'), Blocks.cobblestone}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle11, 6, 3), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 1)}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.smoothStone, 2, 1), new Object[]{"X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 1)}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle, 6, 2), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.smoothStone, 1, 1)}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 4, 1), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 1)}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle, 6, 3), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 1)}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsGondorBrick, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 1)}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall, 6, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 1)}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall, 6, 3), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 1)}));
        gondorianRecipes.add((IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.brick, 1, 2), new Object[]{new ItemStack(LOTRMod.brick, 1, 1), "vine"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle, 6, 4), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 2)}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsGondorBrickMossy, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 2)}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall, 6, 4), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 2)}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle, 6, 5), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 3)}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsGondorBrickCracked, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 3)}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall, 6, 5), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 3)}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 1, 5), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 1)}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetGondor), new Object[]{"XXX", "X X", Character.valueOf('X'), "ingotIron"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyGondor), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), "ingotIron"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsGondor), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), "ingotIron"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsGondor), new Object[]{"X X", "X X", Character.valueOf('X'), "ingotIron"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.swordGondor), new Object[]{"X", "X", "Y", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.spearGondor), new Object[]{"  X", " Y ", "Y  ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerGondor), new Object[]{"X", "Y", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hammerGondor), new Object[]{"XYX", "XYX", " Y ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gondorBow), new Object[]{" XY", "X Y", " XY", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), Items.string}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetGondorWinged), new Object[]{"XYX", Character.valueOf('X'), "feather", Character.valueOf('Y'), new ItemStack(LOTRMod.helmetGondor, 1, 0)}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.GONDOR.bannerID), new Object[]{"X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.horseArmorGondor), new Object[]{"X  ", "XYX", "XXX", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pillar, 3, 6), new Object[]{"X", "X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 1)}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle5, 6, 0), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar, 1, 6)}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.lanceGondor), new Object[]{"  X", " X ", "Y  ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsGondorRock, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 1)}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gateGondor, 4), new Object[]{"ZYZ", "YXY", "ZYZ", Character.valueOf('X'), LOTRMod.gateGear, Character.valueOf('Y'), "plankWood", Character.valueOf('Z'), "ingotIron"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetRangerIthilien), new Object[]{"XXX", "X X", Character.valueOf('X'), Items.leather}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyRangerIthilien), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), Items.leather}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsRangerIthilien), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), Items.leather}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsRangerIthilien), new Object[]{"X X", "X X", Character.valueOf('X'), Items.leather}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.ANORIEN.bannerID), new Object[]{"XA", "Y ", "Z ", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood", Character.valueOf('A'), "nuggetGold"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.ITHILIEN.bannerID), new Object[]{"XA", "Y ", "Z ", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood", Character.valueOf('A'), "nuggetSilver"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.LOSSARNACH.bannerID), new Object[]{"XA", "Y ", "Z ", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood", Character.valueOf('A'), new ItemStack((Block)Blocks.double_plant, 1, 4)}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.PINNATH_GELIN.bannerID), new Object[]{"XA", "Y ", "Z ", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood", Character.valueOf('A'), "dyeGreen"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.LEBENNIN.bannerID), new Object[]{"XA", "Y ", "Z ", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood", Character.valueOf('A'), "dyeLightBlue"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.PELARGIR.bannerID), new Object[]{"XA", "Y ", "Z ", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood", Character.valueOf('A'), "dyeCyan"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.BLACKROOT_VALE.bannerID), new Object[]{"XA", "Y ", "Z ", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood", Character.valueOf('A'), LOTRMod.blackroot}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.LAMEDON.bannerID), new Object[]{"XA", "Y ", "Z ", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood", Character.valueOf('A'), "dyeBlue"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetLossarnach), new Object[]{"XXX", "Y Y", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyLossarnach), new Object[]{"X X", "YYY", "XXX", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsLossarnach), new Object[]{"XXX", "Y Y", "X X", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsLossarnach), new Object[]{"Y Y", "X X", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetPinnathGelin), new Object[]{"XXX", "YZY", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather, Character.valueOf('Z'), "dyeGreen"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyPinnathGelin), new Object[]{"XZX", "YYY", "XXX", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather, Character.valueOf('Z'), "dyeGreen"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsPinnathGelin), new Object[]{"XXX", "YZY", "X X", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather, Character.valueOf('Z'), "dyeGreen"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsPinnathGelin), new Object[]{"YZY", "X X", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather, Character.valueOf('Z'), "dyeGreen"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.battleaxeLossarnach), new Object[]{"XXX", "XYX", " Y ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.throwingAxeLossarnach), new Object[]{" X ", " YX", "Y  ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetPelargir), new Object[]{"XXX", "XYX", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "dyeCyan"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyPelargir), new Object[]{"XYX", "XXX", "XXX", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "dyeCyan"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsPelargir), new Object[]{"XXX", "XYX", "X X", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "dyeCyan"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsPelargir), new Object[]{"XYX", "X X", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "dyeCyan"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.tridentPelargir), new Object[]{" XX", " YX", "Y  ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.swordPelargir), new Object[]{" X", "X ", "Y ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick5, 4, 8), new Object[]{"XY", "YX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 1), Character.valueOf('Y'), Blocks.cobblestone}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle11, 6, 0), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 8)}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsGondorBrickRustic, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 8)}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 7), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 8)}));
        gondorianRecipes.add((IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.brick5, 1, 9), new Object[]{new ItemStack(LOTRMod.brick5, 1, 8), "vine"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle11, 6, 1), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 9)}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsGondorBrickRusticMossy, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 9)}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 8), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 9)}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle11, 6, 2), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 10)}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsGondorBrickRusticCracked, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 10)}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 9), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 10)}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.GONDOR_STEWARD.bannerID), new Object[]{"XA", "Y ", "Z ", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood", Character.valueOf('A'), "dyeWhite"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetBlackroot), new Object[]{"XXX", "XYX", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "dyeBlack"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyBlackroot), new Object[]{"XYX", "XXX", "XXX", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "dyeBlack"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsBlackroot), new Object[]{"XXX", "XYX", "X X", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "dyeBlack"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsBlackroot), new Object[]{"XYX", "X X", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "dyeBlack"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.blackrootBow), new Object[]{" XY", "Z Y", " XY", Character.valueOf('X'), LOTRMod.blackrootStick, Character.valueOf('Y'), Items.string, Character.valueOf('Z'), LOTRMod.blackroot}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pikeGondor), new Object[]{"  X", " YX", "Y  ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.chestLebethron), new Object[]{"XXX", "XYX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 8), Character.valueOf('Y'), "nuggetSilver"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyGondorGambeson), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), Blocks.wool}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyLebenninGambeson), new Object[]{"XYX", "XXX", "XXX", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "dyeLightBlue"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetLamedon), new Object[]{"XXX", "YZY", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather, Character.valueOf('Z'), "dyeBlue"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyLamedon), new Object[]{"XZX", "YYY", "XXX", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather, Character.valueOf('Z'), "dyeBlue"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsLamedon), new Object[]{"XXX", "YZY", "X X", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather, Character.valueOf('Z'), "dyeBlue"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsLamedon), new Object[]{"YZY", "X X", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather, Character.valueOf('Z'), "dyeBlue"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.horseArmorLamedon), new Object[]{"XZ ", "XYX", "XXX", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather, Character.valueOf('Z'), "dyeBlue"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyLamedonJacket), new Object[]{"XYX", "XXX", "XXX", Character.valueOf('X'), Items.leather, Character.valueOf('Y'), "dyeBlue"}));
        gondorianRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick4, 1, 6), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 11)}));
    }

    private static void createRohirricRecipes() {
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.rohirricTable), new Object[]{"XX", "XX", Character.valueOf('X'), "plankWood"}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle11, 6, 4), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 2)}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.smoothStone, 2, 2), new Object[]{"X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 2)}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle2, 6, 1), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.smoothStone, 1, 2)}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 4, 4), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 2)}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle, 6, 6), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 4)}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsRohanBrick, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 4)}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall, 6, 8), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 2)}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall, 6, 6), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 4)}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.swordRohan), new Object[]{"X", "X", "Y", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerRohan), new Object[]{"X", "Y", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.spearRohan), new Object[]{"  X", " Y ", "Y  ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetRohan), new Object[]{"XXX", "Y Y", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyRohan), new Object[]{"X X", "YYY", "XXX", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsRohan), new Object[]{"XXX", "Y Y", "X X", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsRohan), new Object[]{"Y Y", "X X", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.ROHAN.bannerID), new Object[]{"X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.battleaxeRohan), new Object[]{"XXX", "XYX", " Y ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.horseArmorRohan), new Object[]{"X  ", "XYX", "XXX", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pillar, 3, 8), new Object[]{"X", "X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 2)}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle5, 6, 2), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar, 1, 8)}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.rohanBow), new Object[]{" XY", "X Y", " XY", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), Items.string}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetRohanMarshal), new Object[]{" X ", "YAY", " X ", Character.valueOf('X'), "nuggetGold", Character.valueOf('Y'), Items.leather, Character.valueOf('A'), new ItemStack(LOTRMod.helmetRohan, 1, 0)}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyRohanMarshal), new Object[]{" X ", "YAY", " X ", Character.valueOf('X'), "nuggetGold", Character.valueOf('Y'), Items.leather, Character.valueOf('A'), new ItemStack(LOTRMod.bodyRohan, 1, 0)}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsRohanMarshal), new Object[]{" X ", "YAY", " X ", Character.valueOf('X'), "nuggetGold", Character.valueOf('Y'), Items.leather, Character.valueOf('A'), new ItemStack(LOTRMod.legsRohan, 1, 0)}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsRohanMarshal), new Object[]{" X ", "YAY", " X ", Character.valueOf('X'), "nuggetGold", Character.valueOf('Y'), Items.leather, Character.valueOf('A'), new ItemStack(LOTRMod.bootsRohan, 1, 0)}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsRohanRock, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 2)}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.lanceRohan), new Object[]{"  X", " X ", "Y  ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick5, 1, 3), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 4)}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodBeamS, 3, 0), new Object[]{"X", "X", "X", Character.valueOf('X'), "logWood"}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.woodBeamS, 1, 1), new Object[]{" X ", "XYX", " X ", Character.valueOf('X'), "nuggetGold", Character.valueOf('Y'), new ItemStack(LOTRMod.woodBeamS, 1, 0)}));
        rohirricRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gateRohan, 4), new Object[]{"ZYZ", "YXY", "ZYZ", Character.valueOf('X'), LOTRMod.gateGear, Character.valueOf('Y'), "plankWood", Character.valueOf('Z'), "ingotIron"}));
    }

    private static void createDunlendingRecipes() {
        dunlendingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.dunlendingTable), new Object[]{"XX", "YY", Character.valueOf('X'), "plankWood", Character.valueOf('Y'), Blocks.cobblestone}));
        dunlendingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetDunlending), new Object[]{"XXX", "Y Y", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather}));
        dunlendingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyDunlending), new Object[]{"X X", "YYY", "XXX", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather}));
        dunlendingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsDunlending), new Object[]{"XXX", "Y Y", "X X", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather}));
        dunlendingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsDunlending), new Object[]{"Y Y", "X X", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather}));
        dunlendingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.dunlendingClub), new Object[]{"X", "X", "X", Character.valueOf('X'), "plankWood"}));
        dunlendingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.dunlendingTrident), new Object[]{" XX", " YX", "Y  ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        dunlendingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.DUNLAND.bannerID), new Object[]{"X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"}));
    }

    private static void createAngmarRecipes() {
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick2, 4, 0), new Object[]{"XX", "XX", Character.valueOf('X'), Blocks.stone}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.angmarTable), new Object[]{"XX", "YY", Character.valueOf('X'), "plankWood", Character.valueOf('Y'), new ItemStack(LOTRMod.brick2, 1, 0)}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.swordAngmar), new Object[]{"X", "X", "Y", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.battleaxeAngmar), new Object[]{"XXX", "XYX", " Y ", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerAngmar), new Object[]{"X", "Y", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetAngmar), new Object[]{"XXX", "X X", Character.valueOf('X'), LOTRMod.orcSteel}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyAngmar), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), LOTRMod.orcSteel}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsAngmar), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), LOTRMod.orcSteel}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsAngmar), new Object[]{"X X", "X X", Character.valueOf('X'), LOTRMod.orcSteel}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle3, 6, 3), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 0)}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsAngmarBrick, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 0)}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall2, 6, 0), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 0)}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.orcTorchItem, 2), new Object[]{"X", "Y", "Y", Character.valueOf('X'), new ItemStack(Items.coal, 1, 32767), Character.valueOf('Y'), "stickWood"}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.spearAngmar), new Object[]{"  X", " Y ", "Y  ", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.shovelAngmar), new Object[]{"X", "Y", "Y", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pickaxeAngmar), new Object[]{"XXX", " Y ", " Y ", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.axeAngmar), new Object[]{"XX", "XY", " Y", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hoeAngmar), new Object[]{"XX", " Y", " Y", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hammerAngmar), new Object[]{"XYX", "XYX", " Y ", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle3, 6, 4), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 1)}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsAngmarBrickCracked, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 1)}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall2, 6, 1), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 1)}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.orcForge), new Object[]{"XXX", "X X", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 0)}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.ANGMAR.bannerID), new Object[]{"X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wargArmorAngmar), new Object[]{"X  ", "XYX", "XXX", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), Items.leather}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pillar2, 3, 4), new Object[]{"X", "X", "X", Character.valueOf('X'), Blocks.stone}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle9, 6, 4), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar2, 1, 4)}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.polearmAngmar), new Object[]{" XX", " YX", "Y  ", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.RHUDAUR.bannerID), new Object[]{"XA", "Y ", "Z ", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood", Character.valueOf('A'), "stickWood"}));
        angmarRecipes.add((IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.brick6, 1, 10), new Object[]{new ItemStack(LOTRMod.brick2, 4, 0), Items.snowball}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle12, 6, 7), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick6, 1, 10)}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsAngmarBrickSnow, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick6, 1, 10)}));
        angmarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall5, 6, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick6, 1, 10)}));
    }

    private static void createNearHaradRecipes() {
        nearHaradRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.nearHaradTable), new Object[]{"XX", "YY", Character.valueOf('X'), "plankWood", Character.valueOf('Y'), new ItemStack(Blocks.sandstone, 1, 0)}));
        nearHaradRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.NEAR_HARAD.bannerID), new Object[]{"X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"}));
        nearHaradRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.HARAD_NOMAD.bannerID), new Object[]{"XA", "Y ", "Z ", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood", Character.valueOf('A'), Blocks.sand}));
        nearHaradRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetNearHarad), new Object[]{"XXX", "X X", Character.valueOf('X'), "ingotBronze"}));
        nearHaradRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyNearHarad), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), "ingotBronze"}));
        nearHaradRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsNearHarad), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), "ingotBronze"}));
        nearHaradRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsNearHarad), new Object[]{"X X", "X X", Character.valueOf('X'), "ingotBronze"}));
        nearHaradRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetNearHaradWarlord), new Object[]{"XYX", " Z ", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), Items.leather, Character.valueOf('Z'), new ItemStack(LOTRMod.helmetNearHarad, 1, 0)}));
        nearHaradRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.horseArmorNearHarad), new Object[]{"X  ", "XYX", "XXX", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), Items.leather}));
        nearHaradRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetHarnedor), new Object[]{"XXX", "Y Y", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), Items.leather}));
        nearHaradRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyHarnedor), new Object[]{"X X", "YYY", "XXX", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), Items.leather}));
        nearHaradRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsHarnedor), new Object[]{"XXX", "Y Y", "X X", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), Items.leather}));
        nearHaradRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsHarnedor), new Object[]{"Y Y", "X X", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), Items.leather}));
    }

    private static void createHighElvenRecipes() {
        highElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.highElvenTable), new Object[]{"XX", "XX", Character.valueOf('X'), "plankWood"}));
        highElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.shovelHighElven), new Object[]{"X", "Y", "Y", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"}));
        highElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pickaxeHighElven), new Object[]{"XXX", " Y ", " Y ", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"}));
        highElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.axeHighElven), new Object[]{"XX", "XY", " Y", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"}));
        highElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hoeHighElven), new Object[]{"XX", " Y", " Y", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"}));
        highElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.swordHighElven), new Object[]{"X", "X", "Y", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"}));
        highElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerHighElven), new Object[]{"X", "Y", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"}));
        highElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.spearHighElven), new Object[]{"  X", " Y ", "Y  ", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"}));
        highElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetHighElven), new Object[]{"XXX", "X X", Character.valueOf('X'), LOTRMod.elfSteel}));
        highElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyHighElven), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), LOTRMod.elfSteel}));
        highElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsHighElven), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), LOTRMod.elfSteel}));
        highElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsHighElven), new Object[]{"X X", "X X", Character.valueOf('X'), LOTRMod.elfSteel}));
        highElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.HIGH_ELF.bannerID), new Object[]{"X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"}));
        highElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.horseArmorHighElven), new Object[]{"X  ", "XYX", "XXX", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), Items.leather}));
        highElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.polearmHighElven), new Object[]{"  X", " Y ", "X  ", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"}));
        highElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.longspearHighElven), new Object[]{"  X", " YX", "Y  ", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"}));
        highElvenRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.highElvenBow), new Object[]{" XY", "X Y", " XY", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), Items.string}));
    }

    private static void createBlueMountainsRecipes() {
        blueMountainsRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.blueDwarvenTable), new Object[]{"XX", "YY", Character.valueOf('X'), "plankWood", Character.valueOf('Y'), new ItemStack(LOTRMod.brick, 1, 14)}));
        blueMountainsRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.shovelBlueDwarven), new Object[]{"X", "Y", "Y", Character.valueOf('X'), LOTRMod.blueDwarfSteel, Character.valueOf('Y'), "stickWood"}));
        blueMountainsRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pickaxeBlueDwarven), new Object[]{"XXX", " Y ", " Y ", Character.valueOf('X'), LOTRMod.blueDwarfSteel, Character.valueOf('Y'), "stickWood"}));
        blueMountainsRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.axeBlueDwarven), new Object[]{"XX", "XY", " Y", Character.valueOf('X'), LOTRMod.blueDwarfSteel, Character.valueOf('Y'), "stickWood"}));
        blueMountainsRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.swordBlueDwarven), new Object[]{"X", "X", "Y", Character.valueOf('X'), LOTRMod.blueDwarfSteel, Character.valueOf('Y'), "stickWood"}));
        blueMountainsRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hoeBlueDwarven), new Object[]{"XX", " Y", " Y", Character.valueOf('X'), LOTRMod.blueDwarfSteel, Character.valueOf('Y'), "stickWood"}));
        blueMountainsRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerBlueDwarven), new Object[]{"X", "Y", Character.valueOf('X'), LOTRMod.blueDwarfSteel, Character.valueOf('Y'), "stickWood"}));
        blueMountainsRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.battleaxeBlueDwarven), new Object[]{"XXX", "XYX", " Y ", Character.valueOf('X'), LOTRMod.blueDwarfSteel, Character.valueOf('Y'), "stickWood"}));
        blueMountainsRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hammerBlueDwarven), new Object[]{"XYX", "XYX", " Y ", Character.valueOf('X'), LOTRMod.blueDwarfSteel, Character.valueOf('Y'), "stickWood"}));
        blueMountainsRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetBlueDwarven), new Object[]{"XXX", "X X", Character.valueOf('X'), LOTRMod.blueDwarfSteel}));
        blueMountainsRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyBlueDwarven), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), LOTRMod.blueDwarfSteel}));
        blueMountainsRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsBlueDwarven), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), LOTRMod.blueDwarfSteel}));
        blueMountainsRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsBlueDwarven), new Object[]{"X X", "X X", Character.valueOf('X'), LOTRMod.blueDwarfSteel}));
        blueMountainsRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.throwingAxeBlueDwarven), new Object[]{" X ", " YX", "Y  ", Character.valueOf('X'), LOTRMod.blueDwarfSteel, Character.valueOf('Y'), "stickWood"}));
        blueMountainsRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.chandelier, 2, 11), new Object[]{" X ", "YZY", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), Blocks.torch, Character.valueOf('Z'), LOTRMod.blueDwarfSteel}));
        blueMountainsRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.mattockBlueDwarven), new Object[]{"XXX", "XY ", " Y ", Character.valueOf('X'), LOTRMod.blueDwarfSteel, Character.valueOf('Y'), "stickWood"}));
        blueMountainsRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.BLUE_MOUNTAINS.bannerID), new Object[]{"X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"}));
        blueMountainsRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.spearBlueDwarven), new Object[]{"  X", " Y ", "Y  ", Character.valueOf('X'), LOTRMod.blueDwarfSteel, Character.valueOf('Y'), "stickWood"}));
        blueMountainsRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.blueDwarfBars, 16), new Object[]{"XXX", "XXX", Character.valueOf('X'), LOTRMod.blueDwarfSteel}));
        blueMountainsRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.boarArmorBlueDwarven), new Object[]{"X  ", "XYX", "XXX", Character.valueOf('X'), LOTRMod.blueDwarfSteel, Character.valueOf('Y'), Items.leather}));
        blueMountainsRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pikeBlueDwarven), new Object[]{"  X", " YX", "Y  ", Character.valueOf('X'), LOTRMod.blueDwarfSteel, Character.valueOf('Y'), "stickWood"}));
        blueMountainsRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gateDwarven, 4), new Object[]{"ZYZ", "YXY", "ZYZ", Character.valueOf('X'), LOTRMod.gateGear, Character.valueOf('Y'), new ItemStack(LOTRMod.brick, 1, 6), Character.valueOf('Z'), LOTRMod.blueDwarfSteel}));
        blueMountainsRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.mechanism), new Object[]{" X ", "YZY", " X ", Character.valueOf('X'), "ingotCopper", Character.valueOf('Y'), Items.flint, Character.valueOf('Z'), LOTRMod.blueDwarfSteel}));
    }

    private static void createRangerRecipes() {
        rangerRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.rangerTable), new Object[]{"XX", "XX", Character.valueOf('X'), "plankWood"}));
        rangerRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.RANGER_NORTH.bannerID), new Object[]{"X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"}));
        rangerRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick2, 4, 3), new Object[]{"XX", "XX", Character.valueOf('X'), Blocks.stone}));
        rangerRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle4, 6, 1), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 3)}));
        rangerRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsArnorBrick, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 3)}));
        rangerRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall2, 6, 4), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 3)}));
        rangerRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick2, 1, 6), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 3)}));
        rangerRecipes.add((IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.brick2, 1, 4), new Object[]{new ItemStack(LOTRMod.brick2, 1, 3), "vine"}));
        rangerRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle4, 6, 2), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 4)}));
        rangerRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsArnorBrickMossy, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 4)}));
        rangerRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall2, 6, 5), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 4)}));
        rangerRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle4, 6, 3), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 5)}));
        rangerRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsArnorBrickCracked, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 5)}));
        rangerRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall2, 6, 6), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 5)}));
        rangerRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetRanger), new Object[]{"XXX", "X X", Character.valueOf('X'), Items.leather}));
        rangerRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyRanger), new Object[]{"X X", "YYY", "XXX", Character.valueOf('X'), Items.leather, Character.valueOf('Y'), "ingotIron"}));
        rangerRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsRanger), new Object[]{"XXX", "Y Y", "X X", Character.valueOf('X'), Items.leather, Character.valueOf('Y'), "ingotIron"}));
        rangerRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsRanger), new Object[]{"X X", "X X", Character.valueOf('X'), Items.leather}));
        rangerRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.rangerBow), new Object[]{" XY", "X Y", " XY", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), Items.string}));
        rangerRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pillar2, 3, 13), new Object[]{"X", "X", "X", Character.valueOf('X'), Blocks.stone}));
        rangerRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle13, 6, 7), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar2, 1, 13)}));
        rangerRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle14, 6, 0), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar2, 1, 14)}));
    }

    private static void createDolGuldurRecipes() {
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick2, 4, 8), new Object[]{"XX", "XX", Character.valueOf('X'), Blocks.stone}));
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.dolGuldurTable), new Object[]{"XX", "YY", Character.valueOf('X'), "plankWood", Character.valueOf('Y'), new ItemStack(LOTRMod.brick2, 1, 8)}));
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle4, 6, 5), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 8)}));
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsDolGuldurBrick, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 8)}));
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall2, 6, 8), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 8)}));
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.orcTorchItem, 2), new Object[]{"X", "Y", "Y", Character.valueOf('X'), new ItemStack(Items.coal, 1, 32767), Character.valueOf('Y'), "stickWood"}));
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle4, 6, 6), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 9)}));
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsDolGuldurBrickCracked, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 9)}));
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall2, 6, 9), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 9)}));
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.orcForge), new Object[]{"XXX", "X X", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 8)}));
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.DOL_GULDUR.bannerID), new Object[]{"X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"}));
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.swordDolGuldur), new Object[]{"X", "X", "Y", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.battleaxeDolGuldur), new Object[]{"XXX", "XYX", " Y ", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerDolGuldur), new Object[]{"X", "Y", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetDolGuldur), new Object[]{"XXX", "X X", Character.valueOf('X'), LOTRMod.orcSteel}));
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyDolGuldur), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), LOTRMod.orcSteel}));
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsDolGuldur), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), LOTRMod.orcSteel}));
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsDolGuldur), new Object[]{"X X", "X X", Character.valueOf('X'), LOTRMod.orcSteel}));
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.spearDolGuldur), new Object[]{"  X", " Y ", "Y  ", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.shovelDolGuldur), new Object[]{"X", "Y", "Y", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pickaxeDolGuldur), new Object[]{"XXX", " Y ", " Y ", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.axeDolGuldur), new Object[]{"XX", "XY", " Y", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hoeDolGuldur), new Object[]{"XX", " Y", " Y", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hammerDolGuldur), new Object[]{"XYX", "XYX", " Y ", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pikeDolGuldur), new Object[]{"  X", " YX", "Y  ", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        dolGuldurRecipes.add((IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.brick6, 1, 11), new Object[]{new ItemStack(LOTRMod.brick2, 1, 8), "vine"}));
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick6, 1, 12), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 8)}));
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle14, 6, 1), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick6, 1, 11)}));
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsDolGuldurBrickMossy, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick6, 1, 11)}));
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall5, 6, 3), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick6, 1, 11)}));
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pillar3, 3, 0), new Object[]{"X", "X", "X", Character.valueOf('X'), Blocks.stone}));
        dolGuldurRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle14, 6, 4), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar3, 1, 0)}));
    }

    private static void createGundabadRecipes() {
        gundabadRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gundabadTable), new Object[]{"XX", "YY", Character.valueOf('X'), "plankWood", Character.valueOf('Y'), Blocks.cobblestone}));
        gundabadRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.orcTorchItem, 2), new Object[]{"X", "Y", "Y", Character.valueOf('X'), new ItemStack(Items.coal, 1, 32767), Character.valueOf('Y'), "stickWood"}));
        gundabadRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.orcForge), new Object[]{"XXX", "X X", "XXX", Character.valueOf('X'), Blocks.cobblestone}));
        gundabadRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.GUNDABAD.bannerID), new Object[]{"X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"}));
        gundabadRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetGundabadUruk), new Object[]{"XXX", "X X", Character.valueOf('X'), LOTRMod.urukSteel}));
        gundabadRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyGundabadUruk), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), LOTRMod.urukSteel}));
        gundabadRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsGundabadUruk), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), LOTRMod.urukSteel}));
        gundabadRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsGundabadUruk), new Object[]{"X X", "X X", Character.valueOf('X'), LOTRMod.urukSteel}));
        gundabadRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.swordGundabadUruk), new Object[]{"X", "X", "Y", Character.valueOf('X'), LOTRMod.urukSteel, Character.valueOf('Y'), "bone"}));
        gundabadRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.battleaxeGundabadUruk), new Object[]{"XXX", "XYX", " Y ", Character.valueOf('X'), LOTRMod.urukSteel, Character.valueOf('Y'), "bone"}));
        gundabadRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hammerGundabadUruk), new Object[]{"XYX", "XYX", " Y ", Character.valueOf('X'), LOTRMod.urukSteel, Character.valueOf('Y'), "bone"}));
        gundabadRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerGundabadUruk), new Object[]{"X", "Y", Character.valueOf('X'), LOTRMod.urukSteel, Character.valueOf('Y'), "bone"}));
        gundabadRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.spearGundabadUruk), new Object[]{"  X", " Y ", "Y  ", Character.valueOf('X'), LOTRMod.urukSteel, Character.valueOf('Y'), "bone"}));
        gundabadRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pikeGundabadUruk), new Object[]{"  X", " YX", "Y  ", Character.valueOf('X'), LOTRMod.urukSteel, Character.valueOf('Y'), "bone"}));
        gundabadRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gundabadUrukBow), new Object[]{" XY", "X Y", " XY", Character.valueOf('X'), LOTRMod.urukSteel, Character.valueOf('Y'), Items.string}));
    }

    private static void createHalfTrollRecipes() {
        halfTrollRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.halfTrollTable), new Object[]{"XX", "YY", Character.valueOf('X'), "plankWood", Character.valueOf('Y'), Blocks.cobblestone}));
        halfTrollRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.HALF_TROLL.bannerID), new Object[]{"X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"}));
        halfTrollRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetHalfTroll), new Object[]{"XXX", "Y Y", Character.valueOf('X'), LOTRMod.gemsbokHide, Character.valueOf('Y'), Items.string}));
        halfTrollRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyHalfTroll), new Object[]{"X X", "XYX", "XYX", Character.valueOf('X'), LOTRMod.gemsbokHide, Character.valueOf('Y'), Items.string}));
        halfTrollRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsHalfTroll), new Object[]{"XXX", "Y Y", "X X", Character.valueOf('X'), LOTRMod.gemsbokHide, Character.valueOf('Y'), Items.string}));
        halfTrollRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsHalfTroll), new Object[]{"Y Y", "X X", Character.valueOf('X'), LOTRMod.gemsbokHide, Character.valueOf('Y'), Items.string}));
        halfTrollRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.scimitarHalfTroll), new Object[]{"X", "X", "Y", Character.valueOf('X'), Items.flint, Character.valueOf('Y'), "stickWood"}));
        halfTrollRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.battleaxeHalfTroll), new Object[]{"XXX", "XYX", " Y ", Character.valueOf('X'), Items.flint, Character.valueOf('Y'), "stickWood"}));
        halfTrollRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerHalfTroll), new Object[]{"X", "Y", Character.valueOf('X'), Items.flint, Character.valueOf('Y'), "stickWood"}));
        halfTrollRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hammerHalfTroll), new Object[]{"XYX", "XYX", " Y ", Character.valueOf('X'), Items.flint, Character.valueOf('Y'), "stickWood"}));
        halfTrollRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.maceHalfTroll), new Object[]{" XX", " XX", "Y  ", Character.valueOf('X'), Items.flint, Character.valueOf('Y'), "stickWood"}));
        halfTrollRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.rhinoArmorHalfTroll), new Object[]{"X  ", "XYX", "XXX", Character.valueOf('X'), LOTRMod.gemsbokHide, Character.valueOf('Y'), Items.string}));
        halfTrollRecipes.add((IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.torogStew), new Object[]{Items.bowl, Items.rotten_flesh, "bone", Blocks.dirt}));
        halfTrollRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pikeHalfTroll), new Object[]{"  X", " YX", "Y  ", Character.valueOf('X'), Items.flint, Character.valueOf('Y'), "stickWood"}));
    }

    private static void createDolAmrothRecipes() {
        dolAmrothRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.dolAmrothTable), new Object[]{"XX", "YY", Character.valueOf('X'), "plankWood", Character.valueOf('Y'), new ItemStack(LOTRMod.rock, 1, 1)}));
        dolAmrothRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.DOL_AMROTH.bannerID), new Object[]{"X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"}));
        dolAmrothRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetDolAmroth), new Object[]{"Y Y", "XXX", "X X", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), LOTRMod.swanFeather}));
        dolAmrothRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyDolAmroth), new Object[]{"YXY", "XXX", "XXX", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), LOTRMod.swanFeather}));
        dolAmrothRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsDolAmroth), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), "ingotIron"}));
        dolAmrothRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsDolAmroth), new Object[]{"X X", "X X", Character.valueOf('X'), "ingotIron"}));
        dolAmrothRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.swordDolAmroth), new Object[]{"X", "X", "Y", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        dolAmrothRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.horseArmorDolAmroth), new Object[]{"X  ", "XYX", "XXX", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather}));
        dolAmrothRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick3, 4, 9), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 1)}));
        dolAmrothRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle6, 6, 7), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 4, 9)}));
        dolAmrothRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsDolAmrothBrick, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 4, 9)}));
        dolAmrothRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall2, 6, 14), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 4, 9)}));
        dolAmrothRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.lanceDolAmroth), new Object[]{"  X", " X ", "Y  ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        dolAmrothRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerDolAmroth), new Object[]{"X", "Y", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        dolAmrothRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gateDolAmroth, 4), new Object[]{"ZYZ", "YXY", "ZYZ", Character.valueOf('X'), LOTRMod.gateGear, Character.valueOf('Y'), "plankWood", Character.valueOf('Z'), "ingotIron"}));
        dolAmrothRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.longspearDolAmroth), new Object[]{"  X", " YX", "Y  ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        dolAmrothRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyDolAmrothGambeson), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), Blocks.wool}));
        dolAmrothRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsDolAmrothGambeson), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), Blocks.wool}));
        dolAmrothRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gondorBow), new Object[]{" XY", "X Y", " XY", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), Items.string}));
        dolAmrothRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick4, 1, 6), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 11)}));
    }

    private static void createMoredainRecipes() {
        moredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.moredainTable), new Object[]{"XX", "YY", Character.valueOf('X'), "plankWood", Character.valueOf('Y'), LOTRMod.redClay}));
        moredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.MOREDAIN.bannerID), new Object[]{"X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"}));
        moredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetMoredain), new Object[]{"XXX", "X X", Character.valueOf('X'), LOTRMod.gemsbokHide}));
        moredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyMoredain), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), LOTRMod.gemsbokHide}));
        moredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsMoredain), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), LOTRMod.gemsbokHide}));
        moredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsMoredain), new Object[]{"X X", "X X", Character.valueOf('X'), LOTRMod.gemsbokHide}));
        moredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick3, 4, 10), new Object[]{"XX", "XX", Character.valueOf('X'), LOTRMod.redClay}));
        moredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle7, 6, 0), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 4, 10)}));
        moredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsMoredainBrick, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 4, 10)}));
        moredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall2, 6, 15), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick3, 4, 10)}));
        moredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.battleaxeMoredain), new Object[]{"XXX", "XYX", " Y ", Character.valueOf('X'), LOTRMod.rhinoHorn, Character.valueOf('Y'), "stickWood"}));
        moredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerMoredain), new Object[]{"X", "Y", Character.valueOf('X'), LOTRMod.rhinoHorn, Character.valueOf('Y'), "stickWood"}));
        moredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.spearMoredain), new Object[]{"  X", " X ", "X  ", Character.valueOf('X'), LOTRMod.gemsbokHorn}));
        moredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetMoredainLion), new Object[]{"XXX", "X X", Character.valueOf('X'), LOTRMod.lionFur}));
        moredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyMoredainLion), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), LOTRMod.lionFur}));
        moredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsMoredainLion), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), LOTRMod.lionFur}));
        moredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsMoredainLion), new Object[]{"X X", "X X", Character.valueOf('X'), LOTRMod.lionFur}));
        moredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.clubMoredain), new Object[]{"X", "X", "X", Character.valueOf('X'), "plankWood"}));
        moredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.swordMoredain), new Object[]{"X", "X", "Y", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), "stickWood"}));
        moredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle14, 6, 2), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick6, 1, 13)}));
        moredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsMorwaithBrickCracked, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick6, 4, 13)}));
        moredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall5, 6, 4), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick6, 1, 13)}));
    }

    private static void createTauredainRecipes() {
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.tauredainTable), new Object[]{"XX", "YY", Character.valueOf('X'), "plankWood", Character.valueOf('Y'), new ItemStack(LOTRMod.brick4, 1, 0)}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.TAUREDAIN.bannerID), new Object[]{"X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick4, 4, 0), new Object[]{"XX", "XX", Character.valueOf('X'), Blocks.stone}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle8, 6, 0), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 4, 0)}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsTauredainBrick, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 4, 0)}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 0), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 4, 0)}));
        tauredainRecipes.add((IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.brick4, 1, 1), new Object[]{new ItemStack(LOTRMod.brick4, 1, 0), "vine"}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle8, 6, 1), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 4, 1)}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsTauredainBrickMossy, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 4, 1)}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 1), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 4, 1)}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle8, 6, 2), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 4, 2)}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsTauredainBrickCracked, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 4, 2)}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 2), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 4, 2)}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick4, 4, 3), new Object[]{"XX", "XX", Character.valueOf('X'), "ingotGold"}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle8, 6, 3), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 4, 3)}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsTauredainBrickGold, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 4, 3)}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 3), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 4, 3)}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick4, 4, 4), new Object[]{"XX", "XX", Character.valueOf('X'), LOTRMod.obsidianShard}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle8, 6, 4), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 4, 4)}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsTauredainBrickObsidian, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 4, 4)}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 4), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 4, 4)}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.shovelTauredain), new Object[]{"X", "Y", "Y", Character.valueOf('X'), LOTRMod.obsidianShard, Character.valueOf('Y'), "stickWood"}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pickaxeTauredain), new Object[]{"XXX", " Y ", " Y ", Character.valueOf('X'), LOTRMod.obsidianShard, Character.valueOf('Y'), "stickWood"}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.axeTauredain), new Object[]{"XX", "XY", " Y", Character.valueOf('X'), LOTRMod.obsidianShard, Character.valueOf('Y'), "stickWood"}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hoeTauredain), new Object[]{"XX", " Y", " Y", Character.valueOf('X'), LOTRMod.obsidianShard, Character.valueOf('Y'), "stickWood"}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerTauredain), new Object[]{"X", "Y", Character.valueOf('X'), LOTRMod.obsidianShard, Character.valueOf('Y'), "stickWood"}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.spearTauredain), new Object[]{"  X", " Y ", "Y  ", Character.valueOf('X'), LOTRMod.obsidianShard, Character.valueOf('Y'), "stickWood"}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.swordTauredain), new Object[]{"XZX", "XZX", " Y ", Character.valueOf('X'), LOTRMod.obsidianShard, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetTauredain), new Object[]{"XXX", "X X", Character.valueOf('X'), "ingotBronze"}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyTauredain), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), "ingotBronze"}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsTauredain), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), "ingotBronze"}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsTauredain), new Object[]{"X X", "X X", Character.valueOf('X'), "ingotBronze"}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetTauredainChieftain), new Object[]{"X", "Y", Character.valueOf('X'), new ItemStack(LOTRMod.doubleFlower, 1, 3), Character.valueOf('Y'), new ItemStack(LOTRMod.helmetTauredain, 1, 0)}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.tauredainBlowgun), new Object[]{"XYY", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), LOTRMod.reeds}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.tauredainDart, 4), new Object[]{"X", "Y", "Z", Character.valueOf('X'), LOTRMod.obsidianShard, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "feather"}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.tauredainDartPoisoned, 4), new Object[]{" X ", "XYX", " X ", Character.valueOf('X'), LOTRMod.tauredainDart, Character.valueOf('Y'), "poison"}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.tauredainDartTrap), new Object[]{"XXX", "XYX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 1, 0), Character.valueOf('Y'), new ItemStack(LOTRMod.tauredainBlowgun, 1, 0)}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pillar, 3, 14), new Object[]{"X", "X", "X", Character.valueOf('X'), Blocks.stone}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle8, 6, 5), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar, 1, 14)}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.tauredainDoubleTorchItem, 2), new Object[]{"X", "Y", "Y", Character.valueOf('X'), new ItemStack(Items.coal, 1, 32767), Character.valueOf('Y'), "stickWood"}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.tauredainDartTrapGold), new Object[]{"XXX", "XYX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 1, 3), Character.valueOf('Y'), new ItemStack(LOTRMod.tauredainBlowgun, 1, 0)}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gateTauredain, 4), new Object[]{"ZYZ", "YXY", "ZYZ", Character.valueOf('X'), LOTRMod.gateGear, Character.valueOf('Y'), "plankWood", Character.valueOf('Z'), "ingotGold"}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hammerTauredain), new Object[]{"XYX", "XYX", " Y ", Character.valueOf('X'), LOTRMod.obsidianShard, Character.valueOf('Y'), "stickWood"}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.battleaxeTauredain), new Object[]{"XXX", "XYX", " Y ", Character.valueOf('X'), LOTRMod.obsidianShard, Character.valueOf('Y'), "stickWood"}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pikeTauredain), new Object[]{"  X", " YX", "Y  ", Character.valueOf('X'), LOTRMod.obsidianShard, Character.valueOf('Y'), "stickWood"}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.tauredainDartTrapObsidian), new Object[]{"XXX", "XYX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 1, 4), Character.valueOf('Y'), new ItemStack(LOTRMod.tauredainBlowgun, 1, 0)}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pillar2, 3, 11), new Object[]{"X", "X", "X", Character.valueOf('X'), "ingotGold"}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pillar2, 3, 12), new Object[]{"X", "X", "X", Character.valueOf('X'), LOTRMod.obsidianShard}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle13, 6, 5), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar2, 1, 11)}));
        tauredainRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle13, 6, 6), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar2, 1, 12)}));
    }

    private static void createDaleRecipes() {
        daleRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daleTable), new Object[]{"XX", "XX", Character.valueOf('X'), "plankWood"}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.DALE.bannerID), new Object[]{"X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick5, 4, 1), new Object[]{"XX", "XX", Character.valueOf('X'), Blocks.stone}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle9, 6, 6), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 1)}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsDaleBrick, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 1)}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall3, 6, 9), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 1)}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.dalishPastryItem), new Object[]{"ABA", "CDC", "EEE", Character.valueOf('A'), LOTRMod.mapleSyrup, Character.valueOf('B'), Items.milk_bucket, Character.valueOf('C'), LOTRMod.raisins, Character.valueOf('D'), Items.egg, Character.valueOf('E'), Items.wheat}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.cram), new Object[]{"XYX", Character.valueOf('X'), Items.wheat, Character.valueOf('Y'), LOTRMod.salt}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.swordDale), new Object[]{"X", "X", "Y", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerDale), new Object[]{"X", "Y", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.spearDale), new Object[]{"  X", " Y ", "Y  ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.battleaxeDale), new Object[]{"XXX", "XYX", " Y ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetDale), new Object[]{"XXX", "X X", Character.valueOf('X'), "ingotIron"}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyDale), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), "ingotIron"}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsDale), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), "ingotIron"}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsDale), new Object[]{"X X", "X X", Character.valueOf('X'), "ingotIron"}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daleBow), new Object[]{" XY", "X Y", " XY", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), Items.string}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pillar2, 3, 5), new Object[]{"X", "X", "X", Character.valueOf('X'), Blocks.stone}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle10, 6, 0), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar2, 1, 5)}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.horseArmorDale), new Object[]{"X  ", "XYX", "XXX", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pikeDale), new Object[]{"  X", " YX", "Y  ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyDaleGambeson), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), Blocks.wool}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(LOTRItemDaleCracker.setEmpty(new ItemStack(LOTRMod.daleCracker, 1, 0), true), new Object[]{" Z ", "XYX", Character.valueOf('X'), Items.paper, Character.valueOf('Y'), Items.gunpowder, Character.valueOf('Z'), "dyeRed"}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(LOTRItemDaleCracker.setEmpty(new ItemStack(LOTRMod.daleCracker, 1, 1), true), new Object[]{" Z ", "XYX", Character.valueOf('X'), Items.paper, Character.valueOf('Y'), Items.gunpowder, Character.valueOf('Z'), "dyeBlue"}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(LOTRItemDaleCracker.setEmpty(new ItemStack(LOTRMod.daleCracker, 1, 2), true), new Object[]{" Z ", "XYX", Character.valueOf('X'), Items.paper, Character.valueOf('Y'), Items.gunpowder, Character.valueOf('Z'), "dyeGreen"}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(LOTRItemDaleCracker.setEmpty(new ItemStack(LOTRMod.daleCracker, 1, 3), true), new Object[]{" Z ", "XYX", Character.valueOf('X'), Items.paper, Character.valueOf('Y'), Items.gunpowder, Character.valueOf('Z'), "dyeWhite"}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(LOTRItemDaleCracker.setEmpty(new ItemStack(LOTRMod.daleCracker, 1, 4), true), new Object[]{" Z ", "XYX", Character.valueOf('X'), Items.paper, Character.valueOf('Y'), Items.gunpowder, Character.valueOf('Z'), "dyeYellow"}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.ESGAROTH.bannerID), new Object[]{"XA", "Y ", "Z ", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood", Character.valueOf('A'), Items.fish}));
        daleRecipes.add((IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.brick6, 1, 3), new Object[]{new ItemStack(LOTRMod.brick5, 1, 1), "vine"}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle13, 6, 0), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick6, 1, 3)}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsDaleBrickMossy, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick6, 1, 3)}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 14), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick6, 1, 3)}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle13, 6, 1), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick6, 1, 4)}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsDaleBrickCracked, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick6, 1, 4)}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 15), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick6, 1, 4)}));
        daleRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick6, 1, 5), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 1)}));
    }

    private static void createDorwinionRecipes() {
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.dorwinionTable), new Object[]{"XX", "YY", Character.valueOf('X'), "plankWood", Character.valueOf('Y'), new ItemStack(LOTRMod.rock, 1, 5)}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.DORWINION.bannerID), new Object[]{"X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick5, 4, 2), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 5)}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle9, 6, 7), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 2)}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsDorwinionBrick, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 2)}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall3, 6, 10), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 2)}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetDorwinion), new Object[]{"XXX", "X X", Character.valueOf('X'), "ingotIron"}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyDorwinion), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), "ingotIron"}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsDorwinion), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), "ingotIron"}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsDorwinion), new Object[]{"X X", "X X", Character.valueOf('X'), "ingotIron"}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetDorwinionElf), new Object[]{"XXX", "X X", Character.valueOf('X'), LOTRMod.elfSteel}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyDorwinionElf), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), LOTRMod.elfSteel}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsDorwinionElf), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), LOTRMod.elfSteel}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsDorwinionElf), new Object[]{"X X", "X X", Character.valueOf('X'), LOTRMod.elfSteel}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.spearBladorthin), new Object[]{"  X", " Y ", "Y  ", Character.valueOf('X'), LOTRMod.dwarfSteel, Character.valueOf('Y'), "stickWood"}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.swordDorwinionElf), new Object[]{"X", "X", "Y", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerDorwinionElf), new Object[]{"X", "Y", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.elvenForge), new Object[]{"XXX", "X X", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 2)}));
        dorwinionRecipes.add((IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.brick5, 1, 4), new Object[]{new ItemStack(LOTRMod.brick5, 1, 2), "vine"}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle10, 6, 1), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 4)}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsDorwinionBrickMossy, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 4)}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall3, 6, 11), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 4)}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle10, 6, 2), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 5)}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsDorwinionBrickCracked, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 5)}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall3, 6, 12), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 5)}));
        dorwinionRecipes.add((IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.brick5, 1, 7), new Object[]{new ItemStack(LOTRMod.brick5, 1, 2), new ItemStack(LOTRMod.rhunFlower, 1, 2)}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle10, 6, 3), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 7)}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsDorwinionBrickFlowers, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 7)}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall3, 6, 13), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 7)}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick5, 1, 6), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 2)}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pillar2, 3, 6), new Object[]{"X", "X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 5)}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle10, 6, 4), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar2, 1, 6)}));
        dorwinionRecipes.add((IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.pillar2, 1, 7), new Object[]{new ItemStack(LOTRMod.pillar2, 1, 6), "vine"}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle10, 6, 5), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar2, 1, 7)}));
        dorwinionRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.dorwinionElfBow), new Object[]{" XY", "X Y", " XY", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), Items.string}));
    }

    private static void createHobbitRecipes() {
        hobbitRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hobbitTable), new Object[]{"XX", "YY", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "plankWood"}));
        hobbitRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.HOBBIT.bannerID), new Object[]{"X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"}));
        hobbitRecipes.add((IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.hobbitPancake), new Object[]{Items.wheat, Items.egg, Items.milk_bucket}));
        for (int i = 1; i <= 8; ++i) {
            Object[] ingredients = new Object[i + 1];
            ingredients[0] = LOTRMod.mapleSyrup;
            for (int j = 1; j < ingredients.length; ++j) {
                ingredients[j] = LOTRMod.hobbitPancake;
            }
            hobbitRecipes.add((IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.hobbitPancakeMapleSyrup, i), ingredients));
        }
        hobbitRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gateHobbitGreen, 4), new Object[]{"YYY", "ZXZ", "YYY", Character.valueOf('X'), LOTRMod.gateGear, Character.valueOf('Y'), "plankWood", Character.valueOf('Z'), "dyeGreen"}));
        hobbitRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gateHobbitBlue, 4), new Object[]{"YYY", "ZXZ", "YYY", Character.valueOf('X'), LOTRMod.gateGear, Character.valueOf('Y'), "plankWood", Character.valueOf('Z'), "dyeBlue"}));
        hobbitRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gateHobbitRed, 4), new Object[]{"YYY", "ZXZ", "YYY", Character.valueOf('X'), LOTRMod.gateGear, Character.valueOf('Y'), "plankWood", Character.valueOf('Z'), "dyeRed"}));
        hobbitRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gateHobbitYellow, 4), new Object[]{"YYY", "ZXZ", "YYY", Character.valueOf('X'), LOTRMod.gateGear, Character.valueOf('Y'), "plankWood", Character.valueOf('Z'), "dyeYellow"}));
    }

    private static void createRhunRecipes() {
        OreDictionary.registerOre((String)"rhunStone", (ItemStack)new ItemStack(Blocks.stone, 1, 0));
        OreDictionary.registerOre((String)"rhunStone", (ItemStack)new ItemStack(Blocks.sandstone, 1, 0));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.rhunTable), new Object[]{"XX", "YY", Character.valueOf('X'), "plankWood", Character.valueOf('Y'), new ItemStack(LOTRMod.brick5, 1, 11)}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.RHUN.bannerID), new Object[]{"X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick5, 4, 11), new Object[]{"XX", "XX", Character.valueOf('X'), "rhunStone"}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle12, 6, 0), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 11)}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsRhunBrick, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 11)}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall3, 6, 15), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 11)}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick5, 1, 12), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 11)}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pillar2, 3, 8), new Object[]{"X", "X", "X", Character.valueOf('X'), "rhunStone"}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle12, 6, 4), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar2, 1, 8)}));
        rhunRecipes.add((IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.brick5, 1, 13), new Object[]{new ItemStack(LOTRMod.brick5, 1, 11), "vine"}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle12, 6, 1), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 13)}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsRhunBrickMossy, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 13)}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 10), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 13)}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle12, 6, 2), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 14)}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsRhunBrickCracked, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 14)}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 11), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 14)}));
        rhunRecipes.add((IRecipe)new ShapelessOreRecipe(new ItemStack(LOTRMod.brick5, 1, 15), new Object[]{new ItemStack(LOTRMod.brick5, 1, 11), new ItemStack(LOTRMod.rhunFlower, 1, 1)}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle12, 6, 3), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 15)}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsRhunBrickFlowers, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 15)}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 12), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 15)}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick6, 1, 0), new Object[]{" X ", "XYX", " X ", Character.valueOf('X'), "nuggetGold", Character.valueOf('Y'), new ItemStack(LOTRMod.brick5, 1, 11)}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick6, 4, 1), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 4)}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle12, 6, 5), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick6, 1, 1)}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsRhunBrickRed, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick6, 1, 1)}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 13), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick6, 1, 1)}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick6, 1, 2), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.brick6, 1, 1)}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pillar2, 3, 9), new Object[]{"X", "X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 4)}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle12, 6, 6), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar2, 1, 9)}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.swordRhun), new Object[]{"X", "X", "Y", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerRhun), new Object[]{"X", "Y", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.spearRhun), new Object[]{"  X", " Y ", "Y  ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.polearmRhun), new Object[]{" XX", " YX", "Y  ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pikeRhun), new Object[]{"  X", " YX", "Y  ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetRhun), new Object[]{"XXX", "Y Y", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyRhun), new Object[]{"X X", "YYY", "XXX", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsRhun), new Object[]{"XXX", "Y Y", "X X", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsRhun), new Object[]{"Y Y", "X X", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.rhunBow), new Object[]{" XY", "X Y", " XY", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), Items.string}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.horseArmorRhunGold), new Object[]{"X  ", "XYX", "XXX", Character.valueOf('X'), LOTRMod.gildedIron, Character.valueOf('Y'), Items.leather}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.rhunFireJar), new Object[]{"XYX", "YZY", "XYX", Character.valueOf('X'), LOTRMod.gildedIron, Character.valueOf('Y'), Items.gunpowder, Character.valueOf('Z'), LOTRMod.nauriteGem}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.rhunFirePot, 4), new Object[]{"Z", "Y", "X", Character.valueOf('X'), LOTRMod.gildedIron, Character.valueOf('Y'), Items.gunpowder, Character.valueOf('Z'), LOTRMod.nauriteGem}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gateRhun, 4), new Object[]{"ZYZ", "YXY", "ZYZ", Character.valueOf('X'), LOTRMod.gateGear, Character.valueOf('Y'), "plankWood", Character.valueOf('Z'), LOTRMod.gildedIron}));
        LOTRRecipes.addDyeableWoolRobeRecipes(rhunRecipes, new ItemStack(LOTRMod.bodyKaftan), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), Blocks.wool});
        LOTRRecipes.addDyeableWoolRobeRecipes(rhunRecipes, new ItemStack(LOTRMod.legsKaftan), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), Blocks.wool});
        rhunRecipes.add(new LOTRRecipeHaradRobesDye(LOTRMaterial.KAFTAN));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetRhunGold), new Object[]{"XXX", "X X", Character.valueOf('X'), LOTRMod.gildedIron}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyRhunGold), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), LOTRMod.gildedIron}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsRhunGold), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), LOTRMod.gildedIron}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsRhunGold), new Object[]{"X X", "X X", Character.valueOf('X'), LOTRMod.gildedIron}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetRhunWarlord), new Object[]{"XYX", Character.valueOf('X'), LOTRMod.kineArawHorn, Character.valueOf('Y'), new ItemStack(LOTRMod.helmetRhunGold, 1, 0)}));
        rhunRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.battleaxeRhun), new Object[]{"XXX", "XYX", " Y ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
    }

    private static void createRivendellRecipes() {
        rivendellRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.rivendellTable), new Object[]{"XX", "XX", Character.valueOf('X'), "plankWood"}));
        rivendellRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.shovelRivendell), new Object[]{"X", "Y", "Y", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"}));
        rivendellRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pickaxeRivendell), new Object[]{"XXX", " Y ", " Y ", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"}));
        rivendellRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.axeRivendell), new Object[]{"XX", "XY", " Y", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"}));
        rivendellRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hoeRivendell), new Object[]{"XX", " Y", " Y", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"}));
        rivendellRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.swordRivendell), new Object[]{"X", "X", "Y", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"}));
        rivendellRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerRivendell), new Object[]{"X", "Y", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"}));
        rivendellRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.spearRivendell), new Object[]{"  X", " Y ", "Y  ", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"}));
        rivendellRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetRivendell), new Object[]{"XXX", "X X", Character.valueOf('X'), LOTRMod.elfSteel}));
        rivendellRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyRivendell), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), LOTRMod.elfSteel}));
        rivendellRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsRivendell), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), LOTRMod.elfSteel}));
        rivendellRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsRivendell), new Object[]{"X X", "X X", Character.valueOf('X'), LOTRMod.elfSteel}));
        rivendellRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.RIVENDELL.bannerID), new Object[]{"X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"}));
        rivendellRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.horseArmorRivendell), new Object[]{"X  ", "XYX", "XXX", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), Items.leather}));
        rivendellRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.polearmRivendell), new Object[]{"  X", " Y ", "X  ", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"}));
        rivendellRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.longspearRivendell), new Object[]{"  X", " YX", "Y  ", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"}));
        rivendellRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.rivendellBow), new Object[]{" XY", "X Y", " XY", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), Items.string}));
    }

    private static void createUmbarRecipes() {
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.umbarTable), new Object[]{"XX", "YY", Character.valueOf('X'), "plankWood", Character.valueOf('Y'), new ItemStack(Blocks.sandstone, 1, 0)}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.UMBAR.bannerID), new Object[]{"X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetCorsair), new Object[]{"XXX", "Y Y", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), Items.leather}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyCorsair), new Object[]{"X X", "YYY", "XXX", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), Items.leather}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsCorsair), new Object[]{"XXX", "Y Y", "X X", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), Items.leather}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsCorsair), new Object[]{"Y Y", "X X", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), Items.leather}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.swordCorsair), new Object[]{"X ", "X ", "YA", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood", Character.valueOf('A'), Items.string}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerCorsair), new Object[]{"X ", "YA", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood", Character.valueOf('A'), Items.string}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.spearCorsair), new Object[]{"  X", " Y ", "YA ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood", Character.valueOf('A'), Items.string}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.battleaxeCorsair), new Object[]{"XXX", "XYX", " YA", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood", Character.valueOf('A'), Items.string}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.scimitarNearHarad), new Object[]{"X", "X", "Y", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerNearHarad), new Object[]{"X", "Y", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.spearNearHarad), new Object[]{"  X", " Y ", "Y  ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.maceNearHarad), new Object[]{" XX", " XX", "Y  ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pikeNearHarad), new Object[]{"  X", " YX", "Y  ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.poleaxeNearHarad), new Object[]{" XX", " YX", "Y  ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetUmbar), new Object[]{"XXX", "X X", Character.valueOf('X'), "ingotIron"}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyUmbar), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), "ingotIron"}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsUmbar), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), "ingotIron"}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsUmbar), new Object[]{"X X", "X X", Character.valueOf('X'), "ingotIron"}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick6, 4, 6), new Object[]{"XX", "XX", Character.valueOf('X'), Blocks.stone}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle13, 6, 2), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick6, 1, 6)}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsUmbarBrick, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick6, 1, 6)}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall5, 6, 0), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick6, 1, 6)}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle13, 6, 3), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick6, 1, 7)}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.stairsUmbarBrickCracked, 4), new Object[]{"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick6, 1, 7)}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.wall5, 6, 1), new Object[]{"XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick6, 1, 7)}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick6, 1, 8), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.brick6, 1, 6)}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.brick6, 1, 9), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 11)}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.pillar2, 3, 10), new Object[]{"X", "X", "X", Character.valueOf('X'), Blocks.stone}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle13, 6, 4), new Object[]{"XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar2, 1, 10)}));
        umbarRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.horseArmorUmbar), new Object[]{"X  ", "XYX", "XXX", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather}));
    }

    private static void createGulfRecipes() {
        gulfRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.gulfTable), new Object[]{"XX", "YY", Character.valueOf('X'), "plankWood", Character.valueOf('Y'), new ItemStack(Blocks.sandstone, 1, 0)}));
        gulfRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.HARAD_GULF.bannerID), new Object[]{"X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"}));
        gulfRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetGulfHarad), new Object[]{"XXX", "Y Y", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), LOTRMod.driedReeds}));
        gulfRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyGulfHarad), new Object[]{"X X", "YYY", "XXX", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), LOTRMod.driedReeds}));
        gulfRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsGulfHarad), new Object[]{"XXX", "Y Y", "X X", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), LOTRMod.driedReeds}));
        gulfRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsGulfHarad), new Object[]{"Y Y", "X X", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), LOTRMod.driedReeds}));
        gulfRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.swordGulfHarad), new Object[]{" X", "X ", "Y ", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), "stickWood"}));
    }

    private static void createBreeRecipes() {
        breeRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.breeTable), new Object[]{"XX", "XX", Character.valueOf('X'), "plankWood"}));
        breeRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.BREE.bannerID), new Object[]{"X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"}));
    }

    private static void createUnsmeltingRecipes() {
        LOTRRecipes.createUtumnoUnsmeltingRecipes();
        LOTRRecipes.createGondolinUnsmeltingRecipes();
        LOTRRecipes.createTauredainUnsmeltingRecipes();
        LOTRRecipes.createArnorUnsmeltingRecipes();
        LOTRRecipes.createBNUnsmeltingRecipes();
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.blacksmithHammer), new Object[]{"XYX", "XYX", " Y ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerAncientHarad), new Object[]{"X", "Y", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
    }

    private static void createUtumnoUnsmeltingRecipes() {
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetUtumno), new Object[]{"XXX", "X X", Character.valueOf('X'), LOTRMod.orcSteel}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyUtumno), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), LOTRMod.orcSteel}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsUtumno), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), LOTRMod.orcSteel}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsUtumno), new Object[]{"X X", "X X", Character.valueOf('X'), LOTRMod.orcSteel}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.swordUtumno), new Object[]{"X", "X", "Y", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerUtumno), new Object[]{"X", "Y", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.spearUtumno), new Object[]{"  X", " Y ", "Y  ", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.battleaxeUtumno), new Object[]{"XXX", "XYX", " Y ", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.hammerUtumno), new Object[]{"XYX", "XYX", " Y ", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.utumnoBow), new Object[]{" XY", "X Y", " XY", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), Items.string}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.utumnoPickaxe), new Object[]{"XXX", " Y ", " Y ", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"}));
    }

    private static void createGondolinUnsmeltingRecipes() {
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetGondolin), new Object[]{"XXX", "X X", Character.valueOf('X'), LOTRMod.elfSteel}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyGondolin), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), LOTRMod.elfSteel}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsGondolin), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), LOTRMod.elfSteel}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsGondolin), new Object[]{"X X", "X X", Character.valueOf('X'), LOTRMod.elfSteel}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.swordGondolin), new Object[]{"X", "X", "Y", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"}));
    }

    private static void createTauredainUnsmeltingRecipes() {
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetTauredainGold), new Object[]{"XXX", "X X", Character.valueOf('X'), "ingotGold"}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyTauredainGold), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), "ingotGold"}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsTauredainGold), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), "ingotGold"}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsTauredainGold), new Object[]{"X X", "X X", Character.valueOf('X'), "ingotGold"}));
    }

    private static void createArnorUnsmeltingRecipes() {
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerBarrow), new Object[]{"X", "Y", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetArnor), new Object[]{"XXX", "X X", Character.valueOf('X'), "ingotIron"}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyArnor), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), "ingotIron"}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsArnor), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), "ingotIron"}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsArnor), new Object[]{"X X", "X X", Character.valueOf('X'), "ingotIron"}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.swordArnor), new Object[]{"X", "X", "Y", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerArnor), new Object[]{"X", "Y", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.spearArnor), new Object[]{"  X", " Y ", "Y  ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
    }

    private static void createBNUnsmeltingRecipes() {
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.helmetBlackNumenorean), new Object[]{"XXX", "X X", Character.valueOf('X'), "ingotIron"}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bodyBlackNumenorean), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), "ingotIron"}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.legsBlackNumenorean), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), "ingotIron"}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.bootsBlackNumenorean), new Object[]{"X X", "X X", Character.valueOf('X'), "ingotIron"}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.swordBlackNumenorean), new Object[]{"X", "X", "Y", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.daggerBlackNumenorean), new Object[]{"X", "Y", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.spearBlackNumenorean), new Object[]{"  X", " Y ", "Y  ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
        uncraftableUnsmeltingRecipes.add((IRecipe)new ShapedOreRecipe(new ItemStack(LOTRMod.maceBlackNumenorean), new Object[]{" XX", " XX", "Y  ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"}));
    }

    public static ItemStack findMatchingRecipe(List recipeList, InventoryCrafting inv, World world) {
        for (int i = 0; i < recipeList.size(); ++i) {
            IRecipe recipe = (IRecipe)recipeList.get(i);
            if (!recipe.matches(inv, world)) continue;
            return recipe.getCraftingResult(inv);
        }
        return null;
    }

    public static boolean checkItemEquals(ItemStack target, ItemStack input) {
        return target.getItem().equals((Object)input.getItem()) && (target.getItemDamage() == 32767 || target.getItemDamage() == input.getItemDamage());
    }

    private static void addDyeableWoolRobeRecipes(List[] recipeLists, ItemStack result, Object ... params) {
        for (List list : recipeLists) {
            LOTRRecipes.addDyeableWoolRobeRecipes(list, result, params);
        }
    }

    private static void addDyeableWoolRobeRecipes(List recipeList, ItemStack result, Object ... params) {
        for (int i = 0; i <= 15; ++i) {
            Object[] paramsDyed = Arrays.copyOf(params, params.length);
            ItemStack wool = new ItemStack(Blocks.wool, 1, i);
            for (int l = 0; l < paramsDyed.length; ++l) {
                Object param = paramsDyed[l];
                if (param instanceof Block && (Block)param == Block.getBlockFromItem((Item)wool.getItem())) {
                    paramsDyed[l] = wool.copy();
                    continue;
                }
                if (!(param instanceof ItemStack) || ((ItemStack)param).getItem() != wool.getItem()) continue;
                paramsDyed[l] = wool.copy();
            }
            ItemStack resultDyed = result.copy();
            float[] colors = EntitySheep.fleeceColorTable[i];
            float r = colors[0];
            float g = colors[1];
            float b = colors[2];
            if (r != 1.0f || g != 1.0f || b != 1.0f) {
                int rI = (int)(r * 255.0f);
                int gI = (int)(g * 255.0f);
                int bI = (int)(b * 255.0f);
                int rgb = rI << 16 | gI << 8 | bI;
                LOTRItemHaradRobes.setRobesColor(resultDyed, rgb);
            }
            recipeList.add(new ShapedOreRecipe(resultDyed, paramsDyed));
        }
    }
}

