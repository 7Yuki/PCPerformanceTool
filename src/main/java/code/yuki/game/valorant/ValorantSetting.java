package code.yuki.game.valorant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

@AllArgsConstructor
public enum ValorantSetting {

    ANTI_ALIASING_QUALITY("Anti Aliasing Quality", "antialiasingquality", GameSettingsFile.RIOT_USER),
    ANISOTROPIC_FILTERING("Anisotropic Filtering", "anisotropicfiltering", GameSettingsFile.RIOT_USER),
    SHADOW_QUALITY("Shadow Quality", "shadowquality", GameSettingsFile.GAME_USER),
    SHADING_QUALITY("Shading Quality", "shadingquality", GameSettingsFile.GAME_USER),
    FOLIAGE_QUALITY("Foliage Quality", "foliagequality", GameSettingsFile.GAME_USER),
    EFFECTS_QUALITY("Effects Quality", "effectsquality", GameSettingsFile.GAME_USER),
    POST_PROCESS_QUALITY("Post Process Quality", "postprocessquality", GameSettingsFile.GAME_USER),
    VIEW_DISTANCE_QUALITY("View Distance Quality", "viewdistancequality", GameSettingsFile.GAME_USER),
    RESOLUTION_QUALITY("Resolution Quality", "resolutionquality", GameSettingsFile.GAME_USER),
    GAME_SETTING_TEXTURE_QUALITY("Texture Quality (Game User Setting)", "texturequality", GameSettingsFile.GAME_USER),
    MATERIAL_QUALITY("Material Quality", "materialquality", GameSettingsFile.RIOT_USER),
    RIOT_SETTING_TEXTURE_QUALITY("Texture Quality", "texturequality", GameSettingsFile.RIOT_USER),
    DETAIL_QUALITY("Detail Quality", "detailquality", GameSettingsFile.RIOT_USER),
    UI_QUALITY("UI Quality", "uiquality", GameSettingsFile.RIOT_USER),
    BLOOM_QUALITY("Bloom Quality", "bloomquality", GameSettingsFile.RIOT_USER),
    SHADOWS_ENABLED("Shadows Enabled", "shadowsenabled", GameSettingsFile.RIOT_USER),
    RAW_INPUT_ENABLED("Raw Input Enabled", "rawinputbufferenabled", GameSettingsFile.RIOT_USER);

    @Getter
    private String name;

    @Getter
    private String lookUpName;

    @Getter @Setter
    private GameSettingsFile settingsFile;


}
