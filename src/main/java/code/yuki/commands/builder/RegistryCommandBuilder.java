package code.yuki.commands.builder;

import code.yuki.commands.builder.util.CommandBuilderUtil;

public class RegistryCommandBuilder extends CommandBuilderUtil {
    public RegistryCommandBuilder() {
        commandParts.add("Reg.exe ");
    }

    public RegistryCommandBuilder add() {
        commandParts.add("add ");
        return this;
    }

    public RegistryCommandBuilder appContainer() {
        commandParts.add("appcontainer");
        return this;
    }

    public RegistryCommandBuilder classes() {
        commandParts.add("classes\\");
        return this;
    }

    public RegistryCommandBuilder currentVersion() {
        commandParts.add("currentversion\\");
        return this;
    }

    public RegistryCommandBuilder delete() {
        commandParts.add("delete ");
        return this;
    }

    public RegistryCommandBuilder hklm() {
        commandParts.add("\"hklm\\\"");
        return this;
    }

    public RegistryCommandBuilder currentControlSet() {
        commandParts.add("currentcontrolset\\");
        return this;
    }

    public RegistryCommandBuilder system() {
        commandParts.add("system\\");
        return this;
    }

    public RegistryCommandBuilder storage() {
        commandParts.add("storage\\");
        return this;
    }

    public RegistryCommandBuilder serviceUi() {
        commandParts.add("serviceui");
        return this;
    }

    public RegistryCommandBuilder services() {
        commandParts.add("services\\");
        return this;
    }

    public RegistryCommandBuilder software() {
        commandParts.add("software\\");
        return this;
    }

    public RegistryCommandBuilder settings() {
        commandParts.add("settings");
        return this;
    }

    public RegistryCommandBuilder parameters() {
        commandParts.add("parameters\\");
        return this;
    }

    public RegistryCommandBuilder microsoft() {
        commandParts.add("microsoft\\");
        return this;
    }

    public RegistryCommandBuilder weirdMicrosoftEdgeThing() {
        commandParts.add("microsoft.microsoftedge_8wekyb3d8bbwe");
        return this;
    }

    public RegistryCommandBuilder microsoftEdge() {
        commandParts.add("microsoftedge");
        return this;
    }

    public RegistryCommandBuilder policies() {
        commandParts.add("policies\\");
        return this;
    }

    public RegistryCommandBuilder tcpIp() {
        commandParts.add("tcpip\\");
        return this;
    }

    public RegistryCommandBuilder windows() {
        commandParts.add("windows\\");
        return this;
    }

    public RegistryCommandBuilder windowsSearch() {
        commandParts.add("windows search\\");
        return this;
    }

    public RegistryCommandBuilder speechOneCore() {
        commandParts.add("speech_onecore\\");
        return this;
    }

    public RegistryCommandBuilder preferences() {
        commandParts.add("preferences");
        return this;
    }

    public RegistryCommandBuilder personalization() {
        commandParts.add("personalization\\");
        return this;
    }

    public RegistryCommandBuilder inputPersonalization() {
        commandParts.add("inputpersonalization");
        return this;
    }

    public RegistryCommandBuilder trainedDataStore() {
        commandParts.add("traineddatastore");
        return this;
    }

    public RegistryCommandBuilder valueName(String valueName) {
        commandParts.add(valueName);
        return this;
    }

    public RegistryCommandBuilder valueType(String valueType) {
        commandParts.add(valueType);
        return this;
    }

    public RegistryCommandBuilder valueData(String valueData) {
        commandParts.add(valueData);
        return this;
    }

    public RegistryCommandBuilder changeWithoutPrompt() {
        commandParts.add("\\f");
        return this;
    }
}
