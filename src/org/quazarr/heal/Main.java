package org.quazarr.heal;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.quazarr.heal.command.Heal;

public class Main extends JavaPlugin {
	
    private File customConfigFile;
    private FileConfiguration customConfig;
    
    private void createCustomConfig() {
        customConfigFile = new File(getDataFolder(), "config.yml");
        if (!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdirs();
            saveResource("config.yml", false);
         }

        customConfig= new YamlConfiguration();
        try {
            customConfig.load(customConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
    
    public FileConfiguration getCustomConfig() {
        return this.customConfig;
    }

	@Override
	public void onEnable() {
	    createCustomConfig();
		new Heal(this);
	}
}
