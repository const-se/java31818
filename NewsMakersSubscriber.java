package org.itstep;

import java.io.PrintStream;
import java.util.HashMap;

public class NewsMakersSubscriber implements SubscriberInterface {
    public String message;
    private PrintStream out;

    public NewsMakersSubscriber(PrintStream out) {
        this.out = out;
    }

    @Override
    public HashMap<Enum, HandlerInterface> getHandlers() {
        // Создаем список обработчиков
        HashMap<Enum, HandlerInterface> handlers = new HashMap<>();
        // Добавляем обработчик для типа события NEW_SMARTPHONE,
        // который представляет собой лямбду-наш собственный метод handleNewSmartphone
        // Т.к. метод динамический, то и обращаемся к нему через this
        handlers.put(SamsungEventType.NEW_SMARTPHONE, this::handleNewSmartphone);
        // Точно так же добавляем обработчик для события FLEXIBLE_DISPLAY_RELEASE
        handlers.put(SamsungEventType.FLEXIBLE_DISPLAY_RELEASE, this::handleFlexibleDisplayRelease);

        return handlers;
    }

    // Обрабатываем событие типа NEW_SMARTPHONE
    public void handleNewSmartphone(Event event) {
        // Если событие - не самсунговское, то игнорируем
        if (!(event instanceof SamsungSmartphoneEvent)) {
            return;
        }

        message = "Samsung выпустил новый флагман "
            + ((SamsungSmartphoneEvent) event).getModel();
        out.println(message);
    }

    // Обрабатываем событие типа FLEXIBLE_DISPLAY_RELEASE
    public void handleFlexibleDisplayRelease(Event event) {
        // Если событие - не самсунговское, то игнорируем
        if (!(event instanceof SamsungSmartphoneEvent)) {
            return;
        }

        message = "Ура! Гибкий экран смартфона - теперь реальность. "
            + "Встречайте детище Samsung - "
            + ((SamsungSmartphoneEvent) event).getModel();
        out.println(message);
    }
}
