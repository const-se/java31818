package org.itstep;

import java.util.HashMap;

public interface SubscriberInterface {
    // Enum - тип события, на которое подписан Subscriber
    // HandlerInterface - обработчик события
    public HashMap<Enum, HandlerInterface> getHandlers();
}
