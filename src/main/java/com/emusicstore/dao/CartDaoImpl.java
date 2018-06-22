package com.emusicstore.dao;

import com.emusicstore.model.Cart;

import java.util.HashMap;
import java.util.Map;

public class CartDaoImpl implements CartDao {

    private Map<String, Cart> listOfCarts;


    public CartDaoImpl(){
        listOfCarts = new HashMap<String, Cart>();
    }


    public Cart create(Cart cart) {
        if(listOfCarts.keySet().contains(cart.getCartId())){
            throw  new IllegalArgumentException(String.format("Cannot create a cart. A cart with the given id(%)" + "already "+"exists" , cart.getCartId()));
        }

        listOfCarts.put(cart.getCartId(), cart);

        return cart;
    }


    public Cart read(String cardId) {

        return listOfCarts.get(cardId);
    }


    public void update(String cartId, Cart cart) {
       if(!listOfCarts.keySet().contains(cartId)){
           throw  new IllegalArgumentException(String.format("Cannot update a cart. A cart with the given id(%)" + "doesn't "+"exist" , cart.getCartId()));
       }
       listOfCarts.put(cartId, cart);
    }


    public void delete(String cartId) {

        if(listOfCarts.keySet().contains(cartId)){
            throw  new IllegalArgumentException(String.format("Cannot delete a cart. A cart with the given id(%)" + "doesn't "+"exist" , cartId));
        }

        listOfCarts.remove(cartId);
    }
}
