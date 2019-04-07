package practice3;

import java.math.BigDecimal;
import java.util.List;

public class OrderCalculate {

    private BigDecimal subtotal;

    private List<OrderLineItem> items;
    private List<BigDecimal> discounts;
    private BigDecimal tax;

    public OrderCalculate(List<OrderLineItem> items, List<BigDecimal> discounts, BigDecimal tax) {
        this.items = items;
        this.discounts = discounts;
        this.tax = tax;
        this.subtotal = new BigDecimal(0);
    }

    public BigDecimal calculate() {
        CalculateSubTotal();
        SubstractDiscounts();
        CalculateTax();
        return subtotal;
    }

    private void CalculateSubTotal() {
        for (OrderLineItem lineItem : items) {
            subtotal = subtotal.add(lineItem.getPrice());
        }
    }

    private void SubstractDiscounts() {
        for (BigDecimal discount : discounts) {
            subtotal = subtotal.subtract(discount);
        }
    }

    private void CalculateTax() {
        subtotal = subtotal.add(subtotal.multiply(tax));
    }
}
