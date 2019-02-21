package org.itstep;

public class SamsungSmartphoneEvent extends Event {
    private String model;

    public SamsungSmartphoneEvent(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}
