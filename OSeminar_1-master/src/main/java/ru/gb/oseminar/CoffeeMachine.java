package ru.gb.oseminar;

public class CoffeeMachine implements VendingMachine {
    @Override
    public boolean addProduct(int id, HotBeverageMachine product) {
        if (!products.containsKey(id)) {
            products.put(id, product);
            return true;
        } else {
            System.out.println("ID уже существует");
            return false;
        }
    }

    @Override
    public HotBeverageMachine getProduct(int id) {
        return products.get(id);
    }
}