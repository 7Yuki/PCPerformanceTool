package code.yuki.hardware.information;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;

public class SystemSpecifications {
    private static final SystemInfo si = new SystemInfo();
    private static final HardwareAbstractionLayer hardware = si.getHardware();

    private static String processorBrand;
    private static String processorArchitechture;

    public static void getCPUInfo() {
        final String processorInfo = hardware.getProcessor().toString();
        final String[] processorInfoArray = processorInfo.split(" ");
        processorBrand = processorInfoArray[0];
        processorArchitechture = processorInfoArray[1];
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
