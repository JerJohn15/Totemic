package totemic_commons.pokefenn.client.rendering.tileentity;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import totemic_commons.pokefenn.ModBlocks;
import totemic_commons.pokefenn.client.rendering.model.ModelTotemTorch;
import totemic_commons.pokefenn.lib.Resources;
import totemic_commons.pokefenn.tileentity.TileTotemTorch;

/**
 * Created by Pokefenn.
 * Licensed under MIT (If this is one of my Mods)
 */
public class TileTotemTorchRenderer extends TileEntitySpecialRenderer
{
    private final ModelTotemTorch modelTotemSocket = new ModelTotemTorch();

    public void renderTileEntityAt(TileEntity tileEntity, double d, double d1, double d2, float f)
    {
        GL11.glPushMatrix();

        GL11.glTranslatef((float) d, (float) d1, (float) d2);
        TileTotemTorch tile = (TileTotemTorch) tileEntity;

        renderBlockYour(tile, tileEntity.getWorldObj(), tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord, ModBlocks.totemTorch);
        GL11.glPopMatrix();
    }

    public void renderBlockYour(TileTotemTorch tl, World world, int i, int j, int k, Block block)
    {
        Tessellator tessellator = Tessellator.instance;
        float f = block.getMixedBrightnessForBlock(world, i, j, k);
        int l = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
        int l1 = l % 65536;
        int l2 = l / 65536;
        tessellator.setColorOpaque_F(f, f, f);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) l1, (float) l2);

        int dir = world.getBlockMetadata(i, j, k);

        GL11.glPushMatrix();
        GL11.glTranslatef(0.5F, 1.47F, 0.5F);
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        //GL11.glTranslatef(-0.5F, 0, -0.5F);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(Resources.TEXTURE_TOTEM_TORCH);

        this.modelTotemSocket.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);

        GL11.glPopMatrix();
    }
}

