/*
 * Decompiled with CFR 0.148.
 */
package lotr.common.fac;

import lotr.common.world.map.LOTRWaypoint;

public class LOTRControlZone {
    public final double mapX;
    public final double mapY;
    public final int radius;
    public final int xCoord;
    public final int zCoord;
    public final int radiusCoord;
    public final long radiusCoordSq;

    public LOTRControlZone(double x, double y, int r) {
        this.mapX = x;
        this.mapY = y;
        this.radius = r;
        this.xCoord = LOTRWaypoint.mapToWorldX(this.mapX);
        this.zCoord = LOTRWaypoint.mapToWorldZ(this.mapY);
        this.radiusCoord = LOTRWaypoint.mapToWorldR(this.radius);
        this.radiusCoordSq = (long)this.radiusCoord * (long)this.radiusCoord;
    }

    public LOTRControlZone(LOTRWaypoint wp, int r) {
        this(wp.getX(), wp.getY(), r);
    }

    public boolean inZone(double x, double y, double z, int extraMapRange) {
        double dx = x - (double)this.xCoord;
        double dz = z - (double)this.zCoord;
        double distSq = dx * dx + dz * dz;
        if (extraMapRange == 0) {
            return distSq <= (double)this.radiusCoordSq;
        }
        int checkRadius = LOTRWaypoint.mapToWorldR(this.radius + extraMapRange);
        long checkRadiusSq = (long)checkRadius * (long)checkRadius;
        return distSq <= (double)checkRadiusSq;
    }

    public boolean intersectsWith(LOTRControlZone other, int extraMapRadius) {
        double dx = other.xCoord - this.xCoord;
        double dz = other.zCoord - this.zCoord;
        double distSq = dx * dx + dz * dz;
        double r12 = this.radiusCoord + other.radiusCoord + LOTRWaypoint.mapToWorldR(extraMapRadius * 2);
        double r12Sq = r12 * r12;
        return distSq <= r12Sq;
    }
}

