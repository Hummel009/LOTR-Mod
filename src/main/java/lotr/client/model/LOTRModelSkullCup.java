package lotr.client.model;

import net.minecraft.client.model.*;
import net.minecraft.entity.Entity;

public class LOTRModelSkullCup extends ModelBase {
    private ModelRenderer base = new ModelRenderer(this, 0, 0);
    private ModelRenderer cup;

    public LOTRModelSkullCup() {
        this.base.setRotationPoint(0.0f, -1.0f, 0.0f);
        this.base.addBox(-3.0f, 0.0f, -3.0f, 6, 1, 6);
        this.base.setTextureOffset(0, 7).addBox(-1.0f, -3.0f, -1.0f, 2, 3, 2);
        this.cup = new ModelRenderer(this, 32, 0);
        this.cup.setRotationPoint(0.0f, -5.0f, 0.0f);
        this.cup.addBox(-4.0f, 0.0f, -4.0f, 8, 1, 8);
        this.cup.setTextureOffset(0, 16).addBox(-4.0f, -5.0f, -4.0f, 1, 5, 8);
        this.cup.setTextureOffset(18, 23).addBox(-3.0f, -5.0f, -4.0f, 6, 5, 1);
        this.cup.setTextureOffset(32, 16).addBox(3.0f, -5.0f, -4.0f, 1, 5, 8);
        this.cup.setTextureOffset(50, 23).addBox(-3.0f, -5.0f, 3.0f, 6, 5, 1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.base.render(f5);
        this.cup.render(f5);
    }
}
