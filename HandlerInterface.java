package org.itstep;

@FunctionalInterface
public interface HandlerInterface {
    // Обработка какого-то события
    public void handle(Event event);
}
