package com.pluto.aplication.service.interfaces;

import com.pluto.aplication.model.entity.ShoppingStore;

public interface ShoppingStoreInterfaces {

    ShoppingStore addProductToShoppingCar(long itemId, String username);

    long removeProductToShoppingCar(long itemId, String username);

    long removeAllProductToShoppingCar(String username);

    int currentNumberShoppingCar(String username);

    ShoppingStore currentShoppingCarStatus(String username);

}