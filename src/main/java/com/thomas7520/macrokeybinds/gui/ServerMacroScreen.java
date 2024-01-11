package com.thomas7520.macrokeybinds.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import com.thomas7520.macrokeybinds.gui.other.MacroList;
import com.thomas7520.macrokeybinds.util.MacroUtil;
import net.minecraft.client.Options;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.OptionsSubScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;

public class ServerMacroScreen extends OptionsSubScreen {

    private MacroList macroList;

    public ServerMacroScreen(Screen p_97519_, Options p_97520_) {
        super(p_97519_, p_97520_, Component.translatable("text.servermacros.title"));
    }

    protected void init() {
        this.macroList = new MacroList(this, this.minecraft, new ArrayList<>(MacroUtil.getServerKeybinds().values()), true);
        this.addWidget(this.macroList);

        this.addRenderableWidget(Button.builder(Component.translatable("text.createmacro"), p_93751_ -> this.minecraft.setScreen(new EditMacroScreen(this, null, true)))
                .bounds(this.width / 2 - 155, this.height - 29, 150, 20)
                .build());

        this.addRenderableWidget(Button.builder(CommonComponents.GUI_DONE, p_93751_ -> this.minecraft.setScreen(this.lastScreen))
                .bounds(this.width / 2 - 155 + 160, this.height - 29, 150, 20)
                .build());
    }

    public void render(PoseStack p_97530_, int p_97531_, int p_97532_, float p_97533_) {
        this.renderBackground(p_97530_);
        this.macroList.render(p_97530_, p_97531_, p_97532_, p_97533_);
        drawCenteredString(p_97530_, this.font, this.title, this.width / 2, 8, 16777215);

        super.render(p_97530_, p_97531_, p_97532_, p_97533_);
    }
}
