package code.yuki.init;

import code.yuki.game.valorant.InitalizeValorantSettings;
import code.yuki.game.valorant.LookUpValorantSettings;
import code.yuki.game.valorant.ValorantSetting;
import com.electronwill.nightconfig.core.file.FileConfig;

public class WriteAppSettingsFile {

    public void writeValorantSettings() {

        LookUpValorantSettings valorantLookUp = new LookUpValorantSettings();

        if (valorantLookUp.lookUpSettingValueDouble(ValorantSetting.RESOLUTION_QUALITY) == 0) new InitalizeValorantSettings();

        FileConfig config = FileConfig.of(AppSettingsFile.getConfigFile().getPath());
        config.load();
        System.out.println("Loaded config");

        for (ValorantSetting setting : ValorantSetting.values()) {
            if (setting.equals(ValorantSetting.SHADOWS_ENABLED) || setting.equals(ValorantSetting.RAW_INPUT_ENABLED)) {
                if (config.getOptional(saveValorantSettingInFileAs(setting)).isEmpty()) {
                    saveBooleanValorantSetting(setting, config, valorantLookUp);
                } else System.out.println(setting.getName() + " key already exists");
            }
            else if (setting.equals(ValorantSetting.RESOLUTION_QUALITY)) {
                if (config.getOptional(saveValorantSettingInFileAs(setting)).isEmpty()) {
                    System.out.println("Adding Resolution quality key");
                    config.set(saveValorantSettingInFileAs(setting), valorantLookUp.lookUpSettingValueDouble(ValorantSetting.RESOLUTION_QUALITY));
                } else System.out.println(setting.getName() + " key already exists");
            }
            else if(setting.equals(ValorantSetting.RIOT_SETTING_TEXTURE_QUALITY)) {
                if (config.getOptional(saveValorantSettingInFileAs(setting) + "_riotsetting").isEmpty()) {
                    saveIntValorantSetting(setting,config,valorantLookUp);
                } else {
                    System.out.println(setting.getName() + " key already exists!");
                }
            }
            else if (setting.equals(ValorantSetting.GAME_SETTING_TEXTURE_QUALITY)) {
                if (config.getOptional(saveValorantSettingInFileAs(setting) + "_gamesetting").isEmpty()) {
                    saveIntValorantSetting(setting,config,valorantLookUp);
                } else {
                    System.out.println(setting.getName() + " key already exists!");
                }
            }
            else {
                if (config.getOptional(saveValorantSettingInFileAs(setting)).isEmpty()) {
                    saveIntValorantSetting(setting,config,valorantLookUp);
                } else {
                    System.out.println(setting.getName() + " key already exists!");
                }
            }
        }
        config.save();
        System.out.println("Saving!");
        config.close();
        System.out.println("Closing!");
    }

    public void writeOverwatchSettings() {

    }

    public void writeDestinySettings() {

    }

    private String saveValorantSettingInFileAs(ValorantSetting setting) {
        return saveSettingWithPrefix("VALORANT.", setting.getLookUpName());
    }

    private String saveSettingWithPrefix(String prefix, String setting) {
        return prefix + setting;
    }

    private String saveSettingWithPrefixAndSuffix(String prefix, String setting, String suffix) {
        return saveSettingWithPrefix(prefix, setting) + suffix;
    }

    private void saveIntValorantSetting(ValorantSetting setting, FileConfig config, LookUpValorantSettings lookUp) {
        System.out.println("Adding " + setting.getName() + " key");
        if (setting.equals(ValorantSetting.GAME_SETTING_TEXTURE_QUALITY)) {
            config.set(saveSettingWithPrefixAndSuffix("VALORANT.", setting.getLookUpName(), "_gamesetting"), lookUp.lookUpSettingValueInt(setting));
        } else if (setting.equals(ValorantSetting.RIOT_SETTING_TEXTURE_QUALITY)) {
            config.set(saveSettingWithPrefixAndSuffix("VALORANT.", setting.getLookUpName(), "_riotsetting"), lookUp.lookUpSettingValueInt(setting));
        } else {
            config.set(saveValorantSettingInFileAs(setting), lookUp.lookUpSettingValueInt(setting));
        }
    }

    private void saveBooleanValorantSetting(ValorantSetting setting, FileConfig config, LookUpValorantSettings lookUp) {
        System.out.println("Adding " + setting.getName() + " key");
        config.set("VALORANT." + setting.getLookUpName(), lookUp.lookUpSettingValueBoolean(setting));
    }

}
