package code.yuki.servicedisabler;

import lombok.Getter;

public enum ServiceState {
    UNKNOWN(-1),
    STOPPED(1),
    PENDING_START(2),
    PENDING_STOP(3),
    RUNNING(4);

    @Getter
    private final int state;

    ServiceState(int state) {
        this.state = state;
    }

}
