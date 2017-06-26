/*
 *     Copyright (C) 2016 boomboompower
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.boomboompower.autogg.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import java.util.regex.Pattern;

public class GlobalUtils {

    private static final String PREFIX = EnumChatFormatting.GOLD + "AutoGG" + EnumChatFormatting.AQUA + " > " + EnumChatFormatting.GRAY;

    public static boolean containsIgnoreCase(String message, String contains) {
        return Pattern.compile(Pattern.quote(contains), Pattern.CASE_INSENSITIVE).matcher(message).find();
    }

    public static boolean isEndOfGame(String message) {
        return (message.contains(":") ? message.replace(" ", "").startsWith("Damage Dealt:") : (containsIgnoreCase(message, "Winning Team") || containsIgnoreCase(message, "Winners") || containsIgnoreCase(message, "Winner")));
    }

    public static void sendMessage(String message) {
        Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(PREFIX + ChatColor.translateAlternateColorCodes(message)));
    }

    public static boolean isNotSpecial(String message) {
        return !(message.contains("joined") && !message.contains("quit") && !message.contains("killed") && !message.contains("thrown into") && !message.contains("logged"));
    }
}
