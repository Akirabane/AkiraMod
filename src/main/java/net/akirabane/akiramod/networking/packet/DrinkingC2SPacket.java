package net.akirabane.akiramod.networking.packet;

import net.akirabane.akiramod.util.IEntityDataSaver;
import net.akirabane.akiramod.util.ThirstData;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.block.Blocks;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;

public class DrinkingC2SPacket {
    private static final String MESSAGE_DRIKING_WATER = "message.akiramod.drank_water";
    private static final String MESSAGE_NO_WATER_NEARBY = "message.akiramod.no_water";
    private static final String MESSAGE_NOT_THIRSTY = "message.akiramod.not_thirsty";

    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        //Everything here happends only on the server
        ServerWorld world = player.getWorld();
        if(isWaterArroundPlayer(player, world, 1)) {
            if(((IEntityDataSaver) player).getPersistentData().getInt("thirst") >= 10) {
                player.sendMessage(Text.translatable(MESSAGE_NOT_THIRSTY)
                        .fillStyle(Style.EMPTY.withColor(Formatting.DARK_AQUA)), false);
            } else {
                player.sendMessage(Text.translatable(MESSAGE_DRIKING_WATER)
                        .fillStyle(Style.EMPTY.withColor(Formatting.DARK_AQUA)), false);
                world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_GENERIC_DRINK, SoundCategory.PLAYERS,
                        0.5f, world.random.nextFloat() * 0.1f + 0.9f);
                ThirstData.addThirst(((IEntityDataSaver) player), 1);
            }
        } else {
            player.sendMessage(Text.translatable(MESSAGE_NO_WATER_NEARBY)
                    .fillStyle(Style.EMPTY.withColor(Formatting.RED)), false);
            ThirstData.syncThirst(((IEntityDataSaver) player).getPersistentData().getInt("thirst"), player);
        };
    }

    private static boolean isWaterArroundPlayer(ServerPlayerEntity player, ServerWorld world, int size) {
        return BlockPos.stream(player.getBoundingBox().expand(size))
                .map(world::getBlockState).filter(state -> state.isOf(Blocks.WATER)).toArray().length > 0;
    }
}
