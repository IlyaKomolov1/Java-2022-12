package processor;

import processor.homework.DateTimeProvider;

public class DateTimeProviderImplStub implements DateTimeProvider {
    private boolean isReturned = false;

    @Override
    public int getSecond() {
        if (isReturned) {
            return 3;
        } else {
            isReturned = true;
            return 4;
        }
    }
}