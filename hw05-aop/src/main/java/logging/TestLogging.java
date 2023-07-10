package logging;

public class TestLogging implements TestLoggingInterface {
    @Log
    public int calculation(int param) {
        return param;
    }
    @Log
    public int calculation(int param1, int param2) {
        return param1+param2;
    }
    @Log
    public int calculation(int param1, int param2, String param3) {
        return param1+param2;
    }

}