package com.pluto.aplication.service.implementation;

import java.util.Date;
import com.pluto.aplication.model.entity.Items;
import com.pluto.aplication.model.entity.ShoppingStore;
import com.pluto.aplication.model.entity.User;
import com.pluto.aplication.service.interfaces.ShoppingStoreInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingStoreServiceImpl implements ShoppingStoreInterfaces{

    @Autowired
    private UserService userService;

    @Autowired
    private ItemsServiceImpl itemsService;

    @Override
    public ShoppingStore addProductToShoppingCar(long itemId, String username) {
        Items itemEntity = itemsService.findbyId(itemId);
        User currentUser = userService.findByUsername(username);
        ShoppingStore shoppingCar = new ShoppingStore();
        //validando el usuario tenga un carrito de compra
        if(currentUser.getShoppingStore() !=null){
            shoppingCar = currentUser.getShoppingStore();
        }
        shoppingCar.getItemsShoppingList().add(itemEntity);
        shoppingCar.setStatus(true);
        shoppingCar.setUpdate(new Date());
        currentUser.setShoppingStore(shoppingCar);
        currentUser = userService.updateUser(currentUser);
        return currentUser.getShoppingStore();
    }

    @Override
    public long removeProductToShoppingCar(long itemId, String username) {
        Items itemEntity = itemsService.findbyId(itemId);
        User currentUser = userService.findByUsername(username);
        ShoppingStore shop = currentUser.getShoppingStore();
        shop.getItemsShoppingList().remove(itemEntity);
        currentUser = userService.updateUser(currentUser);
        return currentUser.getShoppingStore().getId();
    }

    @Override
    public int currentNumberShoppingCar(String username) {
        int number = 0;
        User currentUser = userService.findByUsername(username);
        if(currentUser.getShoppingStore() !=null){
            number = currentUser.getShoppingStore().getItemsShoppingList().size();
        }
        return number;
    }

    @Override
    public ShoppingStore currentShoppingCarStatus(String username) {
        User currentUser = userService.findByUsername(username);
        return currentUser.getShoppingStore();
    }

    @Override
    public long removeAllProductToShoppingCar(String username) {
        User currentUser = userService.findByUsername(username);
        ShoppingStore shop = currentUser.getShoppingStore();
        shop.getItemsShoppingList().clear();
        currentUser = userService.updateUser(currentUser);
        return currentUser.getShoppingStore().getId();
    }

}