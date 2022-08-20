package net.akirabane.akiramod.event;

import net.akirabane.akiramod.util.IEntityDataSaver;
import net.akirabane.akiramod.util.ThirstData;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.Random;

public class PlayerTickHandler implements ServerTickEvents.StartTick {

    private static final String MESSAGE_THIRST_DECREASED = "message.akiramod.thirst_decreased";

    @Override
    public void onStartTick(MinecraftServer server) {
        for(ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
            if(new Random().nextFloat() <= 0.005f) {
                IEntityDataSaver dataPlayer = ((IEntityDataSaver) player);
                ThirstData.removeThirst(dataPlayer, 1);
                player.sendMessage(Text.translatable(MESSAGE_THIRST_DECREASED));
            }
        }
    }
}
