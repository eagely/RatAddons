package me.mlg.rat.commands;

import me.mlg.rat.handlers.GUIHandler;
import me.mlg.rat.RatAddons;
import me.mlg.rat.handlers.ConfigHandler;
import me.mlg.rat.modules.Timer;
import me.mlg.rat.utils.Utils;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

//0.3 added breaks to switch case
public class RatCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "rat";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "rat help/reload/setpos/toggle value(module) value(x) value(y)";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {

        switch (args[0].toLowerCase()) {
            case "help":
                Utils.printRatMessage("Usage: /" + getCommandUsage(sender));
                break;

            case "reload":
                ConfigHandler.reloadConfig();
                Utils.printRatMessage("Successfully reloaded Config!");
                break;

            case "setpos":
                int x;
                int y;
                try {
                    x = Integer.parseInt(args[2]);
                    y = Integer.parseInt(args[3]);
                } catch (IllegalArgumentException exception) {
                    Utils.printErrorMessage("Illegal argument");
                    return;
                }
                ConfigHandler.writeIntConfig("x-position", args[1], x);
                ConfigHandler.writeIntConfig("y-position", args[1], y);
                if (args[1].equals("rabbit"))
                    Utils.printRatMessage("Set Position of Rabbit Reminder to x " + args[2] + " y " + args[3]);
                else if (args[1].equals("watcher"))
                    Utils.printRatMessage("Set Position of Watcher Display to x " + args[2] + " y " + args[3]);
                else if (args[1].equals("lavafishingloot"))
                    Utils.printRatMessage("Set Position of Lava Fishing Loot Tracker to x " + args[2] + " y " + args[3]);
                else {
                    Utils.printErrorMessage("Invalid Module Name");
                    return;
                }
                break;

            case "timer":
                switch (args[1].toLowerCase()) {
                    case "init":
                        try {
                            Timer.tick = Integer.parseInt(args[2]);
                        } catch (IllegalArgumentException exception) {
                            Utils.printErrorMessage("Illegal Argument");
                            break;
                        }
                        Utils.printRatMessage("Initialized Timer with " + Timer.tick + "s");
                        break;
                    case "reset":

                }
            case "toggle":
                switch (args[1].toLowerCase()) {
                    case "copylatest":
                        RatAddons.copyLatestToggle = !RatAddons.copyLatestToggle;
                        ConfigHandler.writeBooleanConfig("toggle", "copylatest", RatAddons.copyLatestToggle);
                        Utils.printRatMessage("Toggled Copy Latest to " + RatAddons.copyLatestToggle);
                        break;
                    case "copyraredrops":
                        RatAddons.copyRareDropsToggle = !RatAddons.copyRareDropsToggle;
                        ConfigHandler.writeBooleanConfig("toggle", "copyraredrops", RatAddons.copyRareDropsToggle);
                        Utils.printRatMessage("Toggled Copy Rare Drops to " + RatAddons.copyRareDropsToggle);
                        break;
                    case "debug":
                        RatAddons.debugToggle = !RatAddons.debugToggle;
                        ConfigHandler.writeBooleanConfig("toggle", "debug", RatAddons.debugToggle);
                        Utils.printRatMessage("Toggled Debug to " + RatAddons.debugToggle);
                        break;
                    case "greet":
                        RatAddons.greetToggle = !RatAddons.greetToggle;
                        ConfigHandler.writeBooleanConfig("toggle", "greet", RatAddons.greetToggle);
                        Utils.printRatMessage("Toggled Greet to " + RatAddons.greetToggle);
                        break;
                    case "lavafishingloot":
                        RatAddons.lavaFishingLootToggle = !RatAddons.lavaFishingLootToggle;
                        ConfigHandler.writeBooleanConfig("toggle", "lavafishingloot", RatAddons.lavaFishingLootToggle);
                        Utils.printRatMessage("Toggle Lava Fishiing Loot Tracker to " + RatAddons.lavaFishingLootToggle);
                        break;
                    case "nicepb":
                        RatAddons.nicePbToggle = !RatAddons.nicePbToggle;
                        ConfigHandler.writeBooleanConfig("toggle", "nicepb", RatAddons.nicePbToggle);
                        Utils.printRatMessage("Toggled Auto nice pb to " + RatAddons.nicePbToggle);
                        break;
                    case "overflowskilldisplay":
                        RatAddons.overflowSkillDislayToggle = !RatAddons.overflowSkillDislayToggle;
                        ConfigHandler.writeBooleanConfig("toggle", "overflowskilldisplay", RatAddons.overflowSkillDislayToggle);
                        Utils.printRatMessage("Toggled overflowskilldisplay to " + RatAddons.overflowSkillDislayToggle);
                        break;
                    case "responder":
                        RatAddons.responderToggle = !RatAddons.responderToggle;
                        ConfigHandler.writeBooleanConfig("toggle", "responder", RatAddons.responderToggle);
                        Utils.printRatMessage("Toggled Responder to " + RatAddons.responderToggle);
                        break;
                    case "seacreaturekilltimer":
                        RatAddons.seaCreatureKillTimerToggle = !RatAddons.seaCreatureKillTimerToggle;
                        ConfigHandler.writeBooleanConfig("toggle", "seacreaturekilltimer", RatAddons.seaCreatureKillTimerToggle);
                        Utils.printRatMessage("Toggled Sea Creature Kill timer to " + RatAddons.seaCreatureKillTimerToggle);
                        break;
                    case "seacreaturelasthit":
                        RatAddons.seaCreatureLastHitToggle = !RatAddons.seaCreatureLastHitToggle;
                        ConfigHandler.writeBooleanConfig("toggle", "seacreaturelasthit", RatAddons.seaCreatureLastHitToggle);
                        Utils.printRatMessage("Toggled Sea Creature Last Hit to " + RatAddons.seaCreatureLastHitToggle);
                        break;
                    case "timer":
                        RatAddons.timerToggle = !RatAddons.timerToggle;
                        ConfigHandler.writeBooleanConfig("toggle", "timer", RatAddons.timerToggle);
                        Utils.printRatMessage("Toggled Timer to " + RatAddons.timerToggle);
                        break;
                    case "watcher":
                        RatAddons.responderToggle = !RatAddons.responderToggle;
                        ConfigHandler.writeBooleanConfig("toggle", "watcher", RatAddons.watcherToggle);
                        Utils.printRatMessage("Toggled Watcher to " + RatAddons.watcherToggle);
                        break;
                    default:
                        Utils.printErrorMessage("Invalid module name");
                        break;
                }
                break;
            default:
                GUIHandler.open();
                break;
        }
    }
}
