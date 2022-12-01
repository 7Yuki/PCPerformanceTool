package code.yuki.servicedisabler;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ServiceDisabler {
    public int startService(String name) throws Exception {
        return execServiceController("start", name);
    }

    public int stopService(String name) throws Exception {
        return execServiceController("stop", name);
    }

    public int stateOfService(String name) throws Exception {
        return execServiceController("query", name);
    }

    private int execServiceController(String cmd, String name) throws Exception {
        final Process process = Runtime.getRuntime().exec("sc " + cmd + " " + name);
        final BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        int state = ServiceState.UNKNOWN.getState();

        while ((line = br.readLine()) != null) {
            int p;
            if((p = line.indexOf(" STATE ")) != ServiceState.UNKNOWN.getState()) {
                if ((p = line.indexOf(" : ", p)) != -1) {
                    state = Integer.parseInt(line.substring(p + 3, p + 4));
                }
            }
        }
        int returnCode = process.waitFor();

        if (returnCode != 0) {
            throw new Exception("Error Code: " + returnCode);
        }
        return state;
    }
}
