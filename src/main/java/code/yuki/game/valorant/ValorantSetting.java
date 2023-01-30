package code.yuki.game.valorant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ValorantSetting {

    ANTI_ALIASING_QUALITY("Anti Aliasing Quality", "EAresIntSettingName::AntiAliasing=0", "antialiasing","GameUserSettings.ini"),
    ANISOTROPIC_FILTERING("Anisotropic Filtering", "EAresIntSettingName::AnisotropicFiltering=0", "anisotropicfiltering","RiotUserSettings.ini"),
    SHADOW_QUALITY("Shadow Quality", "shadowquality", "GameUserSettings.ini"),
    SHADING_QUALITY("Shading Quality", "shadingquality", "GameUserSettings.ini"),
    FOLIAGE_QUALITY("Foliage Quality", "foliagequality", "GameUserSettings.ini"),
    EFFECTS_QUALITY("Effects Quality", "effectsquality", "GameUserSettings.ini"),
    POST_PROCESS_QUALITY("Post Process Quality", "postprocessquality", "GameUserSettings.ini"),
    VIEW_DISTANCE_QUALITY("View Distance Quality", "viewdistancequality", "GameUserSettings.ini"),
    RESOLUTION_QUALITY("Resolution Quality", "resolutionquality", "GameUserSettings.ini"),
    GAME_SETTING_TEXTURE_QUALITY("Texture Quality (Game User Setting)", "texturequality", "GameUserSettings.ini"),
    MATERIAL_QUALITY("Material Quality", "EAresIntSettingName::MaterialQuality=0", "materialquality","RiotUserSettings.ini"),
    RIOT_SETTING_TEXTURE_QUALITY("Texture Quality (Riot User Setting)", "EAresIntSettingName::TextureQuality=0", "texturequality","RiotUserSettings.ini"),
    DETAIL_QUALITY("Detail Quality", "EAresIntSettingName::DetailQuality=0", "detailquality","RiotUserSettings.ini"),
    UI_QUALITY("UI Quality", "EAresIntSettingName::UIQuality=0", "uiquality","RiotUserSettings.ini"),
    BLOOM_QUALITY("Bloom Quality", "EAresIntSettingName::BloomQuality=0", "bloomquality","RiotUserSettings.ini"),
    SHADOWS_ENABLED("Shadows Enabled", "EAresBoolSettingName::ShadowsEnabled=0", "shadowsenabled","RiotUserSettings.ini"),
    RAW_INPUT_ENABLED("Raw Input Enabled", "EAresBoolSettingName::RawInputBufferEnabled=0", "rawinput","RiotUserSettings.ini"),
    NVIDIA_REFLEX_LOW_LATENCY("NVIDIA Reflex Low Latency", "EAresIntSettingName::NvidiaReflexLowLatencySetting=0", "nvidiareflex","RiotUserSettings.ini"),
    NETWORK_SMOOTHING("Network Smoothing", "EAresIntSettingName::NetworkSmoothing=0", "networksmoothing", "RiotUserSettings.ini");

    @Getter
    private final String name;
    @Getter
    private String exactSettingName;

    @Getter
    private final String lookUpName;

    @Getter
    private final String settingsFileName;

    ValorantSetting(String name, String lookUpName, String settingsFileName) {
        this.name = name;
        this.lookUpName = lookUpName;
        this.settingsFileName = settingsFileName;
    }
}
