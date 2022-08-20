package net.akirabane.akiramod;

import net.akirabane.akiramod.client.ThirstHudOverlay;
import net.akirabane.akiramod.event.KeyInputHandler;
import net.akirabane.akiramod.networking.ModMessages;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class AkiraModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        KeyInputHandler.register();
        ModMessages.registerS2CPackets();

        HudRenderCallback.EVENT.register(new ThirstHudOverlay());

    }
}
