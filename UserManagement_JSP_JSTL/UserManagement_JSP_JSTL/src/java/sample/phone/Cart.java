/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.phone;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author PC
 */
public class Cart {
    private Map<String, Phone> cart;

    public Cart() {
    }

    public Cart(Map<String, Phone> cart) {
        this.cart = cart;
    }

    public Map<String, Phone> getCart() {
        return cart;
    }

    public void setCart(Map<String, Phone> cart) {
        this.cart = cart;
    }
    
    public boolean add(Phone phone){
        boolean check = false;
        if(this.cart == null){
            this.cart = new HashMap<>();
        }
        if(this.cart.containsKey(phone.getId())){
            int currentQuantity = this.cart.get((phone.getId())).getQuantity();
            phone.setQuantity(currentQuantity + phone.getQuantity());
        }
        this.cart.put(phone.getId(), phone);
        return check;
    }

    public boolean update(String id, Phone phone) {
        boolean checkUpdate= false;
        if(this.cart != null){
            if(this.cart.containsKey(id)){
                this.cart.replace(id, phone);
                checkUpdate = true;
            }
        }
        return checkUpdate;
    }

    public boolean remove(String id) {
        boolean checkRemove = false;
        if(this.cart != null){
            if(this.cart.containsKey(id)){
                this.cart.remove(id);
                checkRemove = true;
            }
        }
        return checkRemove;
    }
}
