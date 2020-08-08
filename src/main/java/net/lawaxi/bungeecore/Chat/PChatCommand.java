package net.lawaxi.bungeecore.Chat;

import net.lawaxi.bungeecore.Party.PartyUtils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class PChatCommand extends Command {

    public PChatCommand() {
        super("pchat",null);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {


        if(args.length==0) {
            sender.sendMessage("§c没有输入任何消息.");
            return;
        }

        if(!(sender instanceof ProxiedPlayer))
            return;

        if(!PartyUtils.playersParty.containsKey(sender))
        {
            sender.sendMessage("§c您不在任何队伍中,无法发送组队消息.");
        }
        else {
            ChatUtils.sendPartyMessage((ProxiedPlayer) sender,AChatCommand.toMessage(args));
        }
    }
}
