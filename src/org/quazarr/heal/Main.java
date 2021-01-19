package org.quazarr.heal;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.quazarr.heal.command.Heal;

public class Main extends JavaPlugin {
	
    private File ccf;
    private FileConfiguration cc;
    
    private void createCustomConfig() {
        ccf = new File(getDataFolder(), "config.yml");
        if (!ccf.exists()) {
            ccf.getParentFile().mkdirs();
            saveResource("config.yml", false);
         }

        cc= new YamlConfiguration();
        try {
            cc.load(ccf);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
    
    public FileConfiguration getCustomConfig() {
        return this.cc;
    }

	@Override
	public void onEnable() {
	    createCustomConfig();
		new Heal(this);
	}
}
