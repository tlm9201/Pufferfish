package gg.pufferfish.pufferfish.tracker;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;

import java.util.Arrays;
import java.util.Comparator;

public class TrackerUtil {

    public static void sortPlayersLimited(Vec3 origin, ServerPlayer[] players, int limit) {
        if (players.length > limit) {
            Arrays.sort(players, Comparator.comparingDouble(player -> {
                if (player == null) {
                    return Double.MAX_VALUE;
                }

                return player.distanceToSqr(origin.x, player.getY(), origin.z);
            }));
        }
    }
}
