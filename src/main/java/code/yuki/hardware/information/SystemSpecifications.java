package code.yuki.hardware.information;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;

import java.util.Arrays;

public class SystemSpecifications {
    private static final SystemInfo si = new SystemInfo();
    private static final HardwareAbstractionLayer hardware = si.getHardware();

    private static String processorBrand;
    private static String processorArchitechture;

    public static void getCPUInfo() {
        final String processorInfo = hardware.getProcessor().toString();
        final String[] processorInfoArray = processorInfo.split(" ");
        if (Arrays.stream(processorInfoArray).anyMatch(s -> s.toLowerCase().contains("intel"))) {
            processorBrand = "Intel";
            processorArchitechture = processorInfoArray[4];
        }else if (Arrays.stream(processorInfoArray).anyMatch(s -> s.toLowerCase().contains("amd"))) {
            processorBrand = "AMD";
            processorArchitechture = processorInfoArray[3];
        } else {
            System.out.println("????????? wtf cpu do u have");
        }


    }

    public static String getCPUBrand() {
        if (processorBrand == null) {
            System.out.println("CPU Brand null, getting info...");
            getCPUInfo();
            System.out.println("Done!");
        }
        return processorBrand;
    }

    public static String getCPUArchitechture() {
        if (processorArchitechture == null) {
            System.out.println("CPU Architecture null, getting info...");
            getCPUInfo();
            System.out.println("Done!");
        }
        return processorArchitechture;
    }

    public static String getGPU() {
        return hardware.getGraphicsCards().get(0).getName().split(" ")[0];
    }

}
