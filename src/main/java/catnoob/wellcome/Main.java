package catnoob.wellcome;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Onplayerjoin(this), this);
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        getCommand("cwellcome").setExecutor(new command(this));
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
