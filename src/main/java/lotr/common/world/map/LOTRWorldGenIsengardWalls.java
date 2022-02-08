/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  com.google.common.math.IntMath
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockGrass
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.World
 */
package lotr.common.world.map;

import com.google.common.math.IntMath;
import java.util.Random;
import lotr.common.LOTRMod;
import lotr.common.world.map.LOTRRoads;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.structure2.LOTRWorldGenStructureBase2;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class LOTRWorldGenIsengardWalls
extends LOTRWorldGenStructureBase2 {
    public static LOTRWorldGenIsengardWalls INSTANCE = new LOTRWorldGenIsengardWalls(false);
    private int centreX;
    private int centreZ;
    private int radius = 400;
    private int radiusSq = this.radius * this.radius;
    private double wallThick = 0.03;
    private int wallTop = 100;
    private int gateBottom = 80;
    private int gateTop = this.wallTop - 3;

    private LOTRWorldGenIsengardWalls(boolean flag) {
        super(flag);
        this.centreX = LOTRWaypoint.ISENGARD.getXCoord();
        this.centreZ = LOTRWaypoint.ISENGARD.getZCoord() - LOTRWaypoint.mapToWorldR(3.5);
    }

    private double isPosInWall(int i, int k) {
        int dx = i - this.centreX;
        int dz = k - this.centreZ;
        int distSq = dx * dx + dz * dz;
        double circleDist = Math.abs((double)distSq / (double)this.radiusSq - 1.0);
        return circleDist;
    }

    @Override
    public boolean generateWithSetRotation(World world, Random random, int i, int j, int k, int rotation) {
        if (this.isPosInWall(i + 8, k + 8) < this.wallThick * 3.0) {
            for (int i1 = i; i1 <= i + 15; ++i1) {
                block1: for (int k1 = k; k1 <= k + 15; ++k1) {
                    double circleDist = this.isPosInWall(i1, k1);
                    if (!(circleDist < 0.03)) continue;
                    int dx = i1 - this.centreX;
                    int dz = k1 - this.centreX;
                    float roadNear = LOTRRoads.isRoadNear(i1, k1, 9);
                    boolean gate = roadNear >= 0.0f;
                    boolean fences = false;
                    boolean wallEdge = circleDist > 0.025;
                    boolean ladder = wallEdge && Math.abs(dx) == 16 && dz < this.radius;
                    for (int j1 = this.wallTop; j1 > 0; --j1) {
                        if (fences) {
                            this.setBlockAndMetadata(world, i1, j1, k1, LOTRMod.fence, 3);
                        } else {
                            this.setBlockAndMetadata(world, i1, j1, k1, LOTRMod.brick2, 11);
                            if (wallEdge && j1 == this.wallTop && !ladder) {
                                this.setBlockAndMetadata(world, i1, j1 + 1, k1, LOTRMod.brick2, 11);
                                if (IntMath.mod((int)(i1 + k1), (int)2) == 1) {
                                    this.setBlockAndMetadata(world, i1, j1 + 2, k1, LOTRMod.slabSingle5, 3);
                                } else if (this.isTorchAt(i1, k1)) {
                                    this.setBlockAndMetadata(world, i1, j1 + 2, k1, LOTRMod.orcTorch, 0);
                                    this.setBlockAndMetadata(world, i1, j1 + 3, k1, LOTRMod.orcTorch, 1);
                                }
                            }
                            if (ladder) {
                                this.setBlockAndMetadata(world, i1, j1, k1 - 1, Blocks.ladder, 2);
                            }
                        }
                        Block below = this.getBlock(world, i1, j1 - 1, k1);
                        this.setGrassToDirt(world, i1, j1 - 1, k1);
                        if (below == Blocks.grass || below == Blocks.dirt || below == Blocks.stone) continue block1;
                        if (!gate) continue;
                        if (fences) {
                            if (j1 != this.gateBottom) continue;
                            continue block1;
                        }
                        int lerpGateTop = this.gateBottom + Math.round((float)(this.gateTop - this.gateBottom) * MathHelper.sqrt_float((float)(1.0f - roadNear)));
                        if (j1 != lerpGateTop) continue;
                        if (!(circleDist > 0.025)) continue block1;
                        fences = true;
                    }
                }
            }
        }
        return true;
    }

    private boolean isTorchAt(int i, int k) {
        int zmod;
        int torchRange = 12;
        int xmod = IntMath.mod((int)i, (int)torchRange);
        return IntMath.mod((int)(xmod + (zmod = IntMath.mod((int)k, (int)torchRange))), (int)torchRange) == 0;
    }

    @Override
    protected int getX(int x, int z) {
        return x;
    }

    @Override
    protected int getZ(int x, int z) {
        return z;
    }

    @Override
    protected int getY(int y) {
        return y;
    }

    @Override
    protected int rotateMeta(Block block, int meta) {
        return meta;
    }
}

