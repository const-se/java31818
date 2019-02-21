package org.itstep;

import java.util.ArrayList;
import java.util.HashMap;

public class EventDispatcher {
    private static ArrayList<SubscriberInterface> subscribers = new ArrayList<>();

    // Добавить подписчик
    public static void addSubscriber(SubscriberInterface subscriber) {
        subscribers.add(subscriber);
    }

    // Опублковать событие event с типом eventType
    // Подписчики на такой тип события eventType смогут обработать event
    public static void dispatch(Enum eventType, Event event) {
        for (SubscriberInterface subscriber : subscribers) {
            // Получаем от подписчика все обработчики событий
            HashMap<Enum, HandlerInterface> handlers = subscriber.getHandlers();

            // Если среди этих обработчиков найдется тот,
            // который поставлен в соответствие с текущим типом события eventType,...
            if (handlers.containsKey(eventType)) {
                // ...то берем этот обработчик и...
                HandlerInterface handler = handlers.get(eventType);
                // ...выполняем его для события event
                // (т.е. обрабатываем данное событие)
                handler.handle(event);
            }
        }
    }
}
