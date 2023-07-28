package processor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import model.Message;
import processor.homework.ChangingFieldsProcessor;


@DisplayName("Класс ChangingFieldsProcessor должен ")
class ChangingFieldsProcessorTest {

    @Test
    @DisplayName("поменять местами поля field11 и field12")
    void process() {
        var message = new Message.Builder(2)
                .field11("field11")
                .field12("field12")
                .build();

        var newMsg = new ChangingFieldsProcessor().process(message);

        Assertions.assertEquals("field11", newMsg.getField12());
        Assertions.assertEquals("field12", newMsg.getField11());
    }
}