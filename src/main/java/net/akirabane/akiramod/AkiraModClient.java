package net.akirabane.akiramod;

import net.akirabane.akiramod.event.KeyInputHandler;
import net.akirabane.akiramod.networking.ModMessages;
import net.fabricmc.api.ClientModInitializer;

public class AkiraModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        KeyInputHandler.register();
        ModMessages.registerS2CPackets();

    }
}
