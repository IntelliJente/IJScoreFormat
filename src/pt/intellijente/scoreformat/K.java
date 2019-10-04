package pt.intellijente.scoreformat;


import be.maximvdw.placeholderapi.PlaceholderAPI;
import be.maximvdw.placeholderapi.PlaceholderReplaceEvent;
import be.maximvdw.placeholderapi.PlaceholderReplacer;
import org.bukkit.entity.Player;

class K {

    static void load() {
        PlaceholderAPI.registerPlaceholder(I.i, "ijformat", new PlaceholderReplacer() {
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent placeholderReplaceEvent) {
                Player player = placeholderReplaceEvent.getPlayer();
                if (player == null) {
                    return "§cLoading...";
                }
                return I.format(I.getEconomy().getBalance(player));
            }
        });
    }

}
