package code.yuki.game.overwatch;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum OverwatchSetting {
    HIGH_TICK_INPUT("High Tick Input", "hightickinput", "0"),
    CPU_FORCE_SYNC_ENABLED("CPU Force Sync Enabled", "cpuforcesyncenabled", "0"),
    ANISOTROPIC_FILTERING("Anisotropic Filtering", "anisotropicfiltering", "0"),
    ANTI_ALIASING_DETAIL("Anti Aliasing Detail", "aadetail", "0"),
    DESIRED_FRAMERATE("Desired Framerate", "desiredframerate", "0"),
    LIGHT_QUALITY("Light Quality", "lightquality", "0"),
    LOCAL_FOG_DETAIL("Local Fog Detail", "localfogdetail", "0"),
    LOCAL_REFLECTIONS("Local Reflections", "localreflections", "0"),
    MAX_ANISOTROPY("Max Anisotropy", "maxanisotropy", "0"),
    MAX_EFFECTS_ANISOTROPY("Max Effects Anisotropy", "maxeffectsanisotropy", "0"),
    MAX_EXTRA_QUALITY_ANISOTROPY("Max Extra Quality Anisotropy", "maxextraqualityanisotropy", "0"),
    MODEL_QUALITY("Model Quality", "modelquality", "0"),
    SHADER_QUALITY("Shader Quality", "shaderquality", "0"),
    REFLEX_MODE("NVIDIA Reflex Mode", "reflexmode", "0"),
    PHYSICS_QUALITY("Physics Quality", "physicsquality", "0"),
    TEXTURE_DETAIL("Texture Quality", "texturequality", "0"),
    VSYNC_ENABLED("VSync Enabled", "verticalsyncenabled", "0"),
    USE_CUSTOM_FRAMERATES("Use Custom Framerates", "customframerates", "0");


    @Getter
    private final String cleanSettingName;
    @Getter
    private final String settingName;
    @Getter @Setter
    private String settingValue;


}
