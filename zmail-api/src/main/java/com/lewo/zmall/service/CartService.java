package com.lewo.zmall.service;

import com.lewo.zmall.model.OmsCartItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface CartService {
    OmsCartItem getUsersItem(String userId, String skuId);

    void addUsersItem(OmsCartItem cartItem);

    void updateUsersItem(OmsCartItem usersItem);

    List<OmsCartItem> flushCache(String userId);

    List<OmsCartItem> getUsersCart(String userId);

    void checkCart(String userId, Boolean isChecked, String productSkuId);

    void delItems(List<OmsCartItem> checkedCartItems);
}
