package net.akirabane.akiramod.networking;

import net.akirabane.akiramod.AkiraMod;
import net.akirabane.akiramod.networking.packet.DrinkingC2SPacket;
import net.akirabane.akiramod.networking.packet.ExampleC2SPackage;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class ModMessages {

    public static final Identifier DRINKING_ID = new Identifier(AkiraMod.MOD_ID, "driking");
    public static final Identifier THIRST_SYNC_ID = new Identifier(AkiraMod.MOD_ID, "thirst_sync");
    public static final Identifier EXAMPLE_ID = new Identifier(AkiraMod.MOD_ID, "example");

    //inputs from client-side to server in attend to server response.
    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(EXAMPLE_ID, ExampleC2SPackage::receive);
        ServerPlayNetworking.registerGlobalReceiver(DRINKING_ID, DrinkingC2SPacket::receive);
    }

    //inputs from server-side to client in attend to client response.
    public static void registerS2CPackets() {

    }
}
