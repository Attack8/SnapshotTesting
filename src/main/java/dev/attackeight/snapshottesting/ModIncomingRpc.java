package dev.attackeight.snapshottesting;

import com.mojang.serialization.Codec;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.dedicated.management.IncomingRpcMethod;
import net.minecraft.server.dedicated.management.RpcResponseResult;
import net.minecraft.server.dedicated.management.schema.RpcSchema;
import net.minecraft.util.Identifier;

public class ModIncomingRpc {
    public static final IncomingRpcMethod MOD_AUTHOR = registerIncoming("author",
            IncomingRpcMethod.createParameterlessBuilder(ModInfoRpcDispatcher::author, Codec.STRING)
                    .description("Get the author of the Snapshot Testing mod")
                    .result(new RpcResponseResult("author", RpcSchema.STRING)));

    private static IncomingRpcMethod registerIncoming(String name, IncomingRpcMethod.Builder method) {
        return Registry.register(
                Registries.INCOMING_RPC_METHOD,
                Identifier.of(SnapshotTesting.MODID, name),
                method.build(SnapshotTesting.MODID, name));
    }

    public static void registerIncomingRPCs() {}
}
