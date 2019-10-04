package pt.intellijente.scoreformat;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.text.DecimalFormat;

public class I extends JavaPlugin {

    private static Economy econ = null;
    private static String[] suffix = new String[0];
    static I i;

    static Economy getEconomy() {
        return econ;
    }

    static String format(double value) {
        int index = 0;
        while (value / 1000.0D >= 1.0D) {
            value /= 1000.0D;
            index++;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return String.format("%s %s", new Object[] { decimalFormat.format(value), suffix[index] });
    }

    @Override
    public void onEnable() {
        i = this;
        saveDefaultConfig();
        suffix = (String[])getConfig().getStringList("k").toArray(new String[0]);
        setupEconomy();
        if (getServer().getPluginManager().getPlugin("MVdWPlaceholderAPI")
                != null && getServer().getPluginManager().isPluginEnabled("MVdWPlaceholderAPI")) {
            K.load();
            getServer().getConsoleSender().sendMessage("§aPlaceHolder loaded...");
        }
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = (Economy)rsp.getProvider();
        return (econ != null);
    }
}
