package ru.gb.oseminar;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        
        
        coffeeMachine.addProduct(101, new HotBeverageMachine("Кофе", 250, 80));
        coffeeMachine.addProduct(102, new HotBeverageMachine("Чай", 300, 90));
        
        
        for (Map.Entry<Integer, HotBeverageMachine> entry : coffeeMachine.products.entrySet()) {
            Integer key = entry.getKey();
            HotBeverageMachine value = entry.getValue();
            
            System.out.printf("%d: %s, объем: %.1f мл, температура: %d °C\n", 
                              key, value.getName(), value.getVolume(), value.getTemperature());
        }
    }
}