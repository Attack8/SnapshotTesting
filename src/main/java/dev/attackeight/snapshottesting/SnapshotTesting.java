package dev.attackeight.snapshottesting;

import net.fabricmc.api.ModInitializer;

public class SnapshotTesting implements ModInitializer {

    public static String MODID = "snapshottesting";

    @Override
    public void onInitialize() {
        ModIncomingRpc.registerIncomingRPCs();
    }
}
