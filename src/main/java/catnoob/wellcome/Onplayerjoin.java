package catnoob.wellcome;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Timer;
import java.util.TimerTask;

import static org.bukkit.Bukkit.getServer;

public class Onplayerjoin implements Listener {
    private static Main plugin;
    public Onplayerjoin(Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if (!player.hasPlayedBefore()){
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    try {
                        ByteArrayOutputStream b = new ByteArrayOutputStream();
                        DataOutputStream out = new DataOutputStream(b);
                        out.writeUTF("Catwellcomev2");
                        out.writeUTF("msg");
                        out.writeUTF(ChatColor.translateAlternateColorCodes('&',"&f[&6歡&e迎&6喵&e喵&f] 玩家：&6" + player.getName() + " &f首次加入了貓咪村~讓我們歡迎他owob"));
                        getServer().sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
                    }catch (Exception e){
                    }
                }
            };
            timer.schedule(task, 2000);
        }
    }
}
