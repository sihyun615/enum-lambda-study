package sparta.enumtype;

import java.util.function.Function;

public enum OrderStatus {
	DELIVERY_COMPLETED(nextStatus -> false),
	PRODUCT_SHIPPED(nextStatus -> true),
	PURCHASE_ORDERED(nextStatus -> false),
	RESHIP(nextStatus -> true),
	ORDER_RECEIVED(nextStatus -> nextStatus == DELIVERY_COMPLETED || nextStatus == PRODUCT_SHIPPED),
	PURCHASE_DECIDED(nextStatus -> nextStatus == PURCHASE_ORDERED),
	EXCHANGE(nextStatus -> nextStatus == PURCHASE_DECIDED || nextStatus == RESHIP);


	private final Function<OrderStatus, Boolean> expression;

	OrderStatus(Function<OrderStatus, Boolean> expression) {
		this.expression = expression;
	}

	public Boolean canChangeTo(OrderStatus nextStatus) {
		return this.expression.apply(nextStatus);
	}
}