package totemic_commons.pokefenn.totempedia.page;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;
import totemic_commons.pokefenn.api.ceremony.CeremonyRegistry;
import totemic_commons.pokefenn.api.music.MusicHandler;
import totemic_commons.pokefenn.util.TotemUtil;
import vazkii.botania.totemic_custom.api.internal.IGuiLexiconEntry;

/**
 * Created by Pokefenn.
 * Licensed under MIT (If this is one of my Mods)
 */
public class PageCeremony extends PageRecipe
{
    public ResourceLocation ceremonyOverlay = new ResourceLocation("totemic:textures/gui/ceremonyOverlay.png");

    public CeremonyRegistry ceremony;

    public PageCeremony(String unlocalizedName, CeremonyRegistry ceremony)
    {
        super(unlocalizedName);
        this.ceremony = ceremony;
    }

    @Override
    public void renderScreen(IGuiLexiconEntry gui, int mx, int my)
    {
        if(ceremony.getCeremonyID() >= 0)
        {
            TextureManager render = Minecraft.getMinecraft().renderEngine;
            FontRenderer font = Minecraft.getMinecraft().fontRenderer;
            int[] instruemnts = ceremony.getCeremonyEffect().getMusicIds();
            String musicNeeded = TotemUtil.getMusicNeeded(ceremony.getCeremonyActivation().getMusicNeeded());
            String time = Integer.toString(ceremony.getCeremonyActivation().getMaximumStartupTime().getTime() / 20);

            if(MusicHandler.musicHandler.get(ceremony.getCeremonyEffect().getMusicIds(0)).getItem(0) != null && MusicHandler.musicHandler.get(ceremony.getCeremonyEffect().getMusicIds(1)).getItem(0) != null && MusicHandler.musicHandler.get(ceremony.getCeremonyEffect().getMusicIds(2)).getItem(0) != null && MusicHandler.musicHandler.get(ceremony.getCeremonyEffect().getMusicIds(3)).getItem(0) != null)
            {
                renderItem(gui, gui.getLeft() + gui.getWidth() / 2 - 40, gui.getTop() + 31, MusicHandler.musicHandler.get(ceremony.getCeremonyEffect().getMusicIds(0)).getItem(0), false);
                renderItem(gui, gui.getLeft() + gui.getWidth() / 2 - 20, gui.getTop() + 31, MusicHandler.musicHandler.get(ceremony.getCeremonyEffect().getMusicIds(1)).getItem(0), false);
                renderItem(gui, gui.getLeft() + gui.getWidth() / 2, gui.getTop() + 31, MusicHandler.musicHandler.get(ceremony.getCeremonyEffect().getMusicIds(2)).getItem(0), false);
                renderItem(gui, gui.getLeft() + gui.getWidth() / 2 - -21, gui.getTop() + 31, MusicHandler.musicHandler.get(ceremony.getCeremonyEffect().getMusicIds(0)).getItem(3), false);
            }

            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

            PageText.renderText(gui.getLeft() + gui.getWidth() / 2 - font.getStringWidth(musicNeeded) / 2, gui.getTop() + 90, font.getStringWidth(musicNeeded) / 2, 150, musicNeeded);

            font.drawString(StatCollector.translateToLocal("totemicmisc.musicSelector"), gui.getLeft() + gui.getWidth() / 2 - font.getStringWidth(StatCollector.translateToLocal("totemicmisc.musicSelector")) / 2, gui.getTop() + 14, 0x66000000);
            /*font.drawString(musicNeeded, gui.getLeft() + gui.getWidth() / 2 - font.getStringWidth(musicNeeded) / 2, gui.getTop() + 90, 0x66000000);
            font.drawString(StatCollector.translateToLocal("totemicmisc.timeForCeremony") + time + StatCollector.translateToLocal("totemicmisc.seconds"), gui.getLeft() + gui.getWidth() / 2 - font.getStringWidth(StatCollector.translateToLocal("totemicmisc.timeForCeremony") + time + StatCollector.translateToLocal("totemicmisc.seconds")) / 2, gui.getTop() + 105, 0x66000000);
            font.drawString(StatCollector.translateToLocal("totemicmisc.overTime") + " " + (ceremony.getCeremonyActivation().getTimeState() == TimeStateEnum.OVER_TIME ? StatCollector.translateToLocal("totemicmisc.capitalTrue") : StatCollector.translateToLocal("totemicmisc.capitalFalse")), gui.getLeft() + gui.getWidth() / 2 - font.getStringWidth(StatCollector.translateToLocal("totemicmisc.overTime") + " " + (ceremony.getCeremonyActivation().getTimeState() == TimeStateEnum.OVER_TIME)) / 2, gui.getTop() + 120, 0x66000000);
            //font.drawString(StatCollector.translateToLocal(reference), gui.getLeft() + gui.getWidth() / 2 - font.getStringWidth(StatCollector.translateToLocal(reference)) / 2, gui.getTop() + 161, 0x66000000);
            */

            PageText.renderText(gui.getLeft() + gui.getWidth() / 2 - font.getStringWidth(StatCollector.translateToLocal(getUnlocalizedName())) / 3, gui.getTop() + 150, 150, 150, StatCollector.translateToLocal(getUnlocalizedName()));

            GL11.glDisable(GL11.GL_BLEND);

            render.bindTexture(ceremonyOverlay);

            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            GL11.glColor4f(1F, 1F, 1F, 1F);
            ((GuiScreen) gui).drawTexturedModalRect(gui.getLeft(), gui.getTop(), 0, 0, gui.getWidth(), gui.getHeight());
            GL11.glDisable(GL11.GL_BLEND);

        }
    }
}
