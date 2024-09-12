package ru.gb.oseminar;
import java.util.HashMap;
import java.util.Map;

public interface VendingMachine {
    Map<Integer, HotBeverageMachine> products = new HashMap<>();

    boolean addProduct(int id, HotBeverageMachine product);
    HotBeverageMachine getProduct(int id);
}