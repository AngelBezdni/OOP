package ru.gb.oseminar;

public class HotBeverageMachine extends HotDrink {
    private int temperature;

    public HotBeverageMachine(String name, double volume, int temperature) {
        super(name, volume);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}