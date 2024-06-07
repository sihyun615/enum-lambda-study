package sparta.service;

import sparta.enumtype.DiscountEvent;

public class Coupon {
    private final String name;
    private final int couponPrice;

    public Coupon(String name, int couponPrice) {
        this.name = name;
        this.couponPrice = couponPrice;
    }

    public int calcPrice(DiscountEvent event, int price) {
        return price + event.calc(price);
    }

    public int getCouponPrice() {
        return couponPrice;
    }
}
