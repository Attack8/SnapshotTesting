package dev.attackeight.snapshottesting;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.dedicated.management.dispatch.ManagementHandlerDispatcher;

public class ModInfoRpcDispatcher {

    public static String author(ManagementHandlerDispatcher dispatcher) {
        return FabricLoader.getInstance().getModContainer(SnapshotTesting.MODID).get().getMetadata()
                .getAuthors().iterator().next().getName();
    }
}
