package api;

import model.Denomination;

import java.util.List;

public interface AtmCassette {
    Denomination denomination();

    void put(List<Bill> bills);

    Bill take();

    int count();
}