package com.lewo.zmail.cart.function;

import com.lewo.zmall.model.OmsCartItem;
import com.lewo.zmall.model.PmsSkuInfo;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class CartFunction {
    public OmsCartItem convert(PmsSkuInfo skuInfo,Integer quantity){
        OmsCartItem cartItem = new OmsCartItem();
        cartItem.setCreateDate(new Date());
        cartItem.setModifyDate(new Date());
        cartItem.setPrice(skuInfo.getPrice());
        cartItem.setProductCategoryId(skuInfo.getCatalog3Id());
        cartItem.setProductId(skuInfo.getSpuId());
        cartItem.setProductName(skuInfo.getSkuName());
        cartItem.setProductPic(skuInfo.getSkuDefaultImg());
        cartItem.setProductSkuId(skuInfo.getId());
        cartItem.setQuantity(quantity);
        cartItem.setProductSubTitle(skuInfo.getSkuDesc());
        return cartItem;
    }
    //突然高雅！
    public boolean itemExists(OmsCartItem cartItem, List<OmsCartItem> currentCart) {
        String skuId = cartItem.getProductSkuId();
        return currentCart.stream()
                .anyMatch(curItem -> curItem.getProductSkuId().equals(skuId));
    }
    //再度(强行)高雅！
    public BigDecimal getTotalAmount(List<OmsCartItem> cart) {
        BigDecimal[] a = new BigDecimal[1];
        a[0] = new BigDecimal("0");
        cart.stream()
                .filter(OmsCartItem::getIsChecked)
                .forEach(item->{
                    a[0] = a[0].add(item.getTotalPrice());
                });
        return a[0];
    }
}