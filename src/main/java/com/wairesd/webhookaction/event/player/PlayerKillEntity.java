package com.wairesd.webhookaction.event.player;

import com.wairesd.webhookaction.discord.webhook.Send;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Map;

public class PlayerKillEntity implements Listener {
    private final Map<EntityType, String> entityKillMessages = Map.<EntityType, String>ofEntries(
            Map.entry(EntityType.ZOMBIE, "зомби"),
            Map.entry(EntityType.SKELETON, "скелета"),
            Map.entry(EntityType.CREEPER, "крипера"),
            Map.entry(EntityType.SPIDER, "паука"),
            Map.entry(EntityType.ENDERMAN, "эндермена"),
            Map.entry(EntityType.WITCH, "ведьму"),
            Map.entry(EntityType.BLAZE, "блейза"),
            Map.entry(EntityType.ZOMBIFIED_PIGLIN, "зомби-свинью"),
            Map.entry(EntityType.CAVE_SPIDER, "пещерного паука"),
            Map.entry(EntityType.SILVERFISH, "серебрянную рыбку"),
            Map.entry(EntityType.GHAST, "гаста"),
            Map.entry(EntityType.MAGMA_CUBE, "магмовый куб"),
            Map.entry(EntityType.SLIME, "слайма"),
            Map.entry(EntityType.ENDERMITE, "эндермита"),
            Map.entry(EntityType.GUARDIAN, "стража"),
            Map.entry(EntityType.ELDER_GUARDIAN, "древнего стража"),
            Map.entry(EntityType.SHULKER, "шалкера"),
            Map.entry(EntityType.PHANTOM, "фантома"),
            Map.entry(EntityType.PILLAGER, "налётчика"),
            Map.entry(EntityType.RAVAGER, "разорителя"),
            Map.entry(EntityType.VINDICATOR, "мстителя"),
            Map.entry(EntityType.EVOKER, "чародея"),
            Map.entry(EntityType.DROWNED, "утопленника"),
            Map.entry(EntityType.HUSK, "хаска"),
            Map.entry(EntityType.STRAY, "блуждающегося"),
            Map.entry(EntityType.WARDEN, "вардена"),
            Map.entry(EntityType.AXOLOTL, "аксолотля"),
            Map.entry(EntityType.ALLAY, "аллея"),
            Map.entry(EntityType.GOAT, "козла"),
            Map.entry(EntityType.PIGLIN, "пиглина"),
            Map.entry(EntityType.PIGLIN_BRUTE, "брутального пиглина"),
            Map.entry(EntityType.WOLF, "волка"),
            Map.entry(EntityType.CAT, "кошку"),
            Map.entry(EntityType.FOX, "лису"),
            Map.entry(EntityType.BEE, "пчелу"),
            Map.entry(EntityType.RABBIT, "кролика"),
            Map.entry(EntityType.TURTLE, "черепаху"),
            Map.entry(EntityType.PARROT, "попугая"),
            Map.entry(EntityType.HORSE, "лошадь"),
            Map.entry(EntityType.DONKEY, "осла"),
            Map.entry(EntityType.MULE, "мула"),
            Map.entry(EntityType.LLAMA, "ламу"),
            Map.entry(EntityType.TRADER_LLAMA, "торговую ламу"),
            Map.entry(EntityType.COW, "корову"),
            Map.entry(EntityType.PIG, "свинью"),
            Map.entry(EntityType.SHEEP, "овцу"),
            Map.entry(EntityType.CHICKEN, "курицу"),
            Map.entry(EntityType.SQUID, "кальмара"),
            Map.entry(EntityType.GLOW_SQUID, "светящегося кальмара"),
            Map.entry(EntityType.COD, "треску"),
            Map.entry(EntityType.SALMON, "лосося"),
            Map.entry(EntityType.PUFFERFISH, "рыбу-фугу"),
            Map.entry(EntityType.TROPICAL_FISH, "тропическую рыбу"),
            Map.entry(EntityType.VILLAGER, "жителя"),
            Map.entry(EntityType.WANDERING_TRADER, "странствующего торговца"),
            Map.entry(EntityType.IRON_GOLEM, "железного голема"),
            Map.entry(EntityType.SNOWMAN, "снеговика"),
            Map.entry(EntityType.BAT, "летучую мышь"),
            Map.entry(EntityType.MUSHROOM_COW, "грибную корову"),
            Map.entry(EntityType.POLAR_BEAR, "белого медведя"),
            Map.entry(EntityType.DOLPHIN, "дельфина"),
            Map.entry(EntityType.STRIDER, "верхового скелета"),
            Map.entry(EntityType.CAMEL, "верблюда"),
            Map.entry(EntityType.TADPOLE, "головастика"),
            Map.entry(EntityType.FROG, "лягушку")
    );


    @EventHandler
    public void onPlayerKillEntity(EntityDeathEvent event) {
        if (event.getEntity().getKiller() == null) return;

        String playerName = event.getEntity().getKiller().getName();
        EntityType type = event.getEntityType();

        String entityName = entityKillMessages.get(type);
        if (entityName != null) {
            Send.send("Игрок " + playerName + " убил " + entityName);
        }
    }
}
