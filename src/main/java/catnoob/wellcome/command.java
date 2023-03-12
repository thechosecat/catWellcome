package catnoob.wellcome;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import static org.bukkit.Bukkit.getServer;

public class command implements CommandExecutor {
    private static Main plugin;
    public command(Main plugin){
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = sender.getServer().getPlayer(sender.getName());
        try {
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(b);
            out.writeUTF("Catwellcomev2");
            out.writeUTF("msg");
            out.writeUTF(ChatColor.translateAlternateColorCodes('&',"&7玩家：&6" + player.getName() + " &7首次加入了貓咪村~讓我們歡迎他"));
            getServer().sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
            System.out.println("1");
        }catch (Exception e){

        }
        return true;
    }
}
