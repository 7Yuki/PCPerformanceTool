package code.yuki.game.valorant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ValorantSetting {

    ANTI_ALIASING_QUALITY("Anti Aliasing Quality", "antialiasingquality", "GameUserSettings.ini"),
    ANISOTROPIC_FILTERING("Anisotropic Filtering", "anisotropicfiltering", "RiotUserSettings.ini"),
    SHADOW_QUALITY("Shadow Quality", "shadowquality", "GameUserSettings.ini"),
    SHADING_QUALITY("Shading Quality", "shadingquality", "GameUserSettings.ini"),
    FOLIAGE_QUALITY("Foliage Quality", "foliagequality", "GameUserSettings.ini"),
    EFFECTS_QUALITY("Effects Quality", "effectsquality", "GameUserSettings.ini"),
    POST_PROCESS_QUALITY("Post Process Quality", "postprocessquality", "GameUserSettings.ini"),
    VIEW_DISTANCE_QUALITY("View Distance Quality", "viewdistancequality", "GameUserSettings.ini"),
    RESOLUTION_QUALITY("Resolution Quality", "resolutionquality", "GameUserSettings.ini"),
    GAME_SETTING_TEXTURE_QUALITY("Texture Quality (Game User Setting)", "texturequality", "GameUserSettings.ini"),
    MATERIAL_QUALITY("Material Quality", "materialquality", "RiotUserSettings.ini"),
    RIOT_SETTING_TEXTURE_QUALITY("Texture Quality (Riot User Setting)", "texturequality", "RiotUserSettings.ini"),
    DETAIL_QUALITY("Detail Quality", "detailquality", "RiotUserSettings.ini"),
    UI_QUALITY("UI Quality", "uiquality", "RiotUserSettings.ini"),
    BLOOM_QUALITY("Bloom Quality", "bloomquality", "RiotUserSettings.ini"),
    SHADOWS_ENABLED("Shadows Enabled", "shadowsenabled", "RiotUserSettings.ini"),
    RAW_INPUT_ENABLED("Raw Input Enabled", "rawinputbufferenabled", "RiotUserSettings.ini"),
    NVIDIA_REFLEX_LOW_LATENCY("NVIDIA Reflex Low Latency", "nvidiareflex", "RiotUserSettings.ini"),
    NETWORK_SMOOTHING("Network Smoothing", "networksmoothing", "RiotUserSettings.ini");

    @Getter
    private final String name;

    @Getter
    private final String lookUpName;

    @Getter
    private final String settingsFileName;

}
