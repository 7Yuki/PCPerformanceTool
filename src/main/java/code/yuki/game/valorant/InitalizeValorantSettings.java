package code.yuki.game.valorant;

import lombok.Getter;

public class InitalizeValorantSettings {

    @Getter
    private final int antiAliasingQuality;
    @Getter
    private final int shadowQuality;
    @Getter
    private final int shadingQuality;
    @Getter
    private final int foliageQuality;
    @Getter
    private final int effectsQuality;
    @Getter
    private final int postProcessQuality;
    @Getter
    private final int viewDistanceQuality;
    @Getter
    private final double resolutionQuality;
    @Getter
    private final int gameSettingTextureQuality;
    @Getter
    private final int materialQuality;
    @Getter
    private final int riotSettingTextureQuality;
    @Getter
    private final int detailQuality;
    @Getter
    private final int uiQuality;
    @Getter
    private final int bloomQuality;
    @Getter
    private final boolean shadowsEnabled;
    @Getter
    private final boolean rawInputEnabled;
    @Getter
    private final int anisotropicFiltering;
    @Getter
    private final int nvidiaReflexLowLatency;


    public InitalizeValorantSettings() {
        LookUpValorantSettings lookUp = new LookUpValorantSettings();

        uiQuality = lookUp.lookUpSettingValueInt(ValorantSetting.UI_QUALITY);
        bloomQuality = lookUp.lookUpSettingValueInt(ValorantSetting.BLOOM_QUALITY);
        anisotropicFiltering = lookUp.lookUpSettingValueInt(ValorantSetting.ANISOTROPIC_FILTERING);
        nvidiaReflexLowLatency = lookUp.lookUpSettingValueInt(ValorantSetting.NVIDIA_REFLEX_LOW_LATENCY);
        detailQuality = lookUp.lookUpSettingValueInt(ValorantSetting.DETAIL_QUALITY);
        riotSettingTextureQuality = lookUp.lookUpSettingValueInt(ValorantSetting.RIOT_SETTING_TEXTURE_QUALITY);
        gameSettingTextureQuality = lookUp.lookUpSettingValueInt(ValorantSetting.GAME_SETTING_TEXTURE_QUALITY);
        materialQuality = lookUp.lookUpSettingValueInt(ValorantSetting.MATERIAL_QUALITY);
        resolutionQuality = lookUp.lookUpSettingValueDouble(ValorantSetting.RESOLUTION_QUALITY);
        viewDistanceQuality = lookUp.lookUpSettingValueInt(ValorantSetting.VIEW_DISTANCE_QUALITY);
        postProcessQuality = lookUp.lookUpSettingValueInt(ValorantSetting.POST_PROCESS_QUALITY);
        effectsQuality = lookUp.lookUpSettingValueInt(ValorantSetting.EFFECTS_QUALITY);
        foliageQuality = lookUp.lookUpSettingValueInt(ValorantSetting.FOLIAGE_QUALITY);
        shadingQuality = lookUp.lookUpSettingValueInt(ValorantSetting.SHADING_QUALITY);
        shadowQuality = lookUp.lookUpSettingValueInt(ValorantSetting.SHADOW_QUALITY);
        antiAliasingQuality = lookUp.lookUpSettingValueInt(ValorantSetting.ANTI_ALIASING_QUALITY);


        rawInputEnabled = lookUp.lookUpSettingValueBoolean(ValorantSetting.RAW_INPUT_ENABLED);
        shadowsEnabled = lookUp.lookUpSettingValueBoolean(ValorantSetting.SHADOWS_ENABLED);


    }


    public void listGameUserSettingsValues() {
        String riotUserSettingsValues =
                "\n[GAME USER SETTINGS]\nResolution Quality: " + resolutionQuality +
                        "\nView Distance Quality: " + viewDistanceQuality +
                        "\nAnti Aliasing Quality: " + antiAliasingQuality +
                        "\nShadow Quality: " + shadowQuality +
                        "\nPost Process Quality: " + postProcessQuality +
                        "\nGame Setting Texture Quality: " + gameSettingTextureQuality +
                        "\nEffects Quality: " + effectsQuality +
                        "\nFoliage Quality: " + foliageQuality +
                        "\nShading Quality: " + shadingQuality;
        System.out.println(riotUserSettingsValues);
    }

    public void listRiotUserSettingsValues() {
        String riotUserSettingsValues =
                "\n[RIOT USER SETTINGS]\nMaterial Quality: " + materialQuality +
                        "\nTexture Quality: " + riotSettingTextureQuality +
                        "\nDetail Quality: " + detailQuality +
                        "\nUI Quality: " + uiQuality +
                        "\nBloom Quality: " + bloomQuality +
                        "\nRaw Input Buffer Enabled: " + rawInputEnabled +
                        "\nShadows Enabled: " + shadowsEnabled +
                        "\nAnisotropic Filtering: " + anisotropicFiltering +
                        "\nNVIDIA Reflex Low Latency: " + nvidiaReflexLowLatency;
        System.out.println(riotUserSettingsValues);
    }

}
