package processor;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import model.Message;
import processor.homework.DateTimeProvider;
import processor.homework.ExceptionProcessor;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Класс EvenSecondExceptionProcessor должен ")
class ExceptionProcessorTest {
    private final DateTimeProvider dateTimeProviderImplStub = new DateTimeProviderImplStub();

    @Test()
    @DisplayName("выбрасывать исключение в четную секунду")
    void evenSecondExceptionTest() {
        var message = new Message.Builder(1L).field1("field1").build();
        var exceptionProcessor = new ExceptionProcessor(dateTimeProviderImplStub);

        Assertions.assertThatThrownBy(() -> exceptionProcessor.process(message))
                .isInstanceOf(RuntimeException.class);

        var actualMessage = exceptionProcessor.process(message);
        assertEquals(message, actualMessage);
    }
}