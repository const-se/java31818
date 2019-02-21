package org.itstep;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.Assert.*;

public class NewsMakersSubscriberTest {

    @Test
    public void getHandlers() {
        // Arrange
        NewsMakersSubscriber subscriber = new NewsMakersSubscriber(getPrintStream());
        HashMap<Enum, HandlerInterface> expected = new HashMap<>();
        expected.put(SamsungEventType.NEW_SMARTPHONE, null);
        expected.put(SamsungEventType.FLEXIBLE_DISPLAY_RELEASE, null);

        // Action
        HashMap<Enum, HandlerInterface> actual = subscriber.getHandlers();

        // Assert
        Assert.assertEquals(expected.keySet(), actual.keySet());
    }

    @Test
    public void handleNewSmartphone() {
        // Arrange
        NewsMakersSubscriber subscriber = new NewsMakersSubscriber(getPrintStream());
        SamsungSmartphoneEvent event = new SamsungSmartphoneEvent("Test");
        String expected = "Samsung выпустил новый флагман Test";

        // Action
        subscriber.handleNewSmartphone(event);
        String actual = subscriber.message;

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void handleFlexibleDisplayRelease() {
        // Arrange
        NewsMakersSubscriber subscriber = new NewsMakersSubscriber(getPrintStream());
        SamsungSmartphoneEvent event = new SamsungSmartphoneEvent("Test");
        String expected = "Ура! Гибкий экран смартфона - теперь реальность. "
            + "Встречайте детище Samsung - Test";

        // Action
        subscriber.handleFlexibleDisplayRelease(event);
        String actual = subscriber.message;

        // Assert
        Assert.assertEquals(expected, actual);
    }

    // Создаем фиктивный поток вывода данных, который, на самом деле, никуда ничего не пишет
    // (Анонимный класс OutputStream)
    private PrintStream getPrintStream() {
        return new PrintStream(
            new OutputStream() {
                @Override
                public void write(int b) throws IOException {
                    // Ничего не делаем, потому что в данных тестах нам это и не нужно
                }
            }
        );
    }
}
