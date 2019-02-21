package org.itstep;

public class Events {

    public static void main(String[] args) {
        // Сначала добавляем подписчика в Диспетчер (кладем в ArrayList subscribers)
		// System.out - это объект класса PrintStream, который пишет в консоль
        EventDispatcher.addSubscriber(new NewsMakersSubscriber(System.out));

	    SamsungSmartphoneEvent event1 = new SamsungSmartphoneEvent("Galaxy S10");
	    event1.setSource("Samsung");
	    EventDispatcher.dispatch(SamsungEventType.NEW_SMARTPHONE, event1);

	    SamsungSmartphoneEvent event2 = new SamsungSmartphoneEvent("Galaxy Fold");
	    event2.setSource("Samsung");
	    EventDispatcher.dispatch(SamsungEventType.FLEXIBLE_DISPLAY_RELEASE, event2);

	    Event event3 = new Event();
	    event3.setSource("Samsung");
	    EventDispatcher.dispatch(SamsungEventType.NEW_EMPLOYEE, event3);
    }
}
