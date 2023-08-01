package listener;

import model.Message;
import model.ObjectForMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class HistoryListener implements Listener, HistoryReader {
    private static final Logger logger = LoggerFactory.getLogger(HistoryListener.class);
    private final HashMap<Long, Optional<Message>> historyHashMap = new HashMap<>();

    @Override
    public void onUpdated(Message msg) {
        logger.info("info level:{}", msg);

        ObjectForMessage newObjectForMessage = new ObjectForMessage();
        List<String> newDataList = new ArrayList<>(msg.getField13().getData());
        newObjectForMessage.setData(newDataList);

        Message newMsg = new Message.Builder(msg.getId())
                .field1(msg.getField1())
                .field2(msg.getField2())
                .field3(msg.getField3())
                .field4(msg.getField4())
                .field5(msg.getField5())
                .field6(msg.getField6())
                .field7(msg.getField7())
                .field8(msg.getField8())
                .field9(msg.getField9())
                .field10(msg.getField10())
                .field11(msg.getField11())
                .field12(msg.getField12())
                .field13(newObjectForMessage)
                .build();

        Optional<Message> optionalMessage = Optional.of(newMsg);
        historyHashMap.put(newMsg.getId(), optionalMessage);
    }

    @Override
    public Optional<Message> findMessageById(long id) {
        return historyHashMap.get(id);
    }
}