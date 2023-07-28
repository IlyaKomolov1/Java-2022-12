package handler;

import model.Message;
import listener.Listener;

public interface Handler {
    Message handle(Message msg);

    void addListener(Listener listener);
    void removeListener(Listener listener);
}