package code.yuki.servicedisabler;

public enum ServiceState {
    UNKNOWN(-1),
    STOPPED(1),
    PENDING_START(2),
    PENDING_STOP(3),
    RUNNING(4);

    private final int state;

    ServiceState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }
}
