package sparta.enumtype;

import java.util.function.Function;

public enum OrderStatus {
	DELIVERY_COMPLETED(nextStatus -> false),  // 배송완료
	PRODUCT_SHIPPED(nextStatus -> nextStatus == DELIVERY_COMPLETED),  // 상품발송
	ORDER_RECEIVED(nextStatus -> nextStatus == DELIVERY_COMPLETED || nextStatus == PRODUCT_SHIPPED),  // 주문접수
	PRODUCT_ORDERED(nextStatus -> nextStatus == ORDER_RECEIVED),  // 상품 주문
	RESHIP(nextStatus -> nextStatus == DELIVERY_COMPLETED),  // 재발송
	PURCHASE_DECIDED(nextStatus -> nextStatus == PRODUCT_ORDERED),  // 구매 결정
	EXCHANGE(nextStatus -> nextStatus == PURCHASE_DECIDED || nextStatus == RESHIP);  //교환


	private final Function<OrderStatus, Boolean> expression;

	OrderStatus(Function<OrderStatus, Boolean> expression) {
		this.expression = expression;
	}

	public Boolean canChangeTo(OrderStatus nextStatus) {
		return this.expression.apply(nextStatus);
	}
}