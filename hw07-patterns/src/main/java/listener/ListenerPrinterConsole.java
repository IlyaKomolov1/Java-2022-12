package listener;

import model.Message;

public class ListenerPrinterConsole implements Listener {

    @Override
    public void onUpdated(Message msg) {
        var logString = String.format("oldMsg:", msg);
        System.out.println(logString);
    }
}