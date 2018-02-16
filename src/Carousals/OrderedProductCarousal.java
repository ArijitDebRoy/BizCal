package Carousals;

public class OrderedProductCarousal {
    public String qty[],prod[],rate[],value[];public int ProductCount;public double vat_rate,tax_amt,total,total_inc_tax;

    public OrderedProductCarousal( int ProductCount, String[] qty, String[] prod, String[] rate, String[] value, double vat_rate, double tax_amt, double total, double total_inc_tax) {
        this.qty = qty;
        this.prod = prod;
        this.rate = rate;
        this.value = value;
        this.ProductCount = ProductCount;
        this.vat_rate = vat_rate;
        this.tax_amt = tax_amt;
        this.total = total;
        this.total_inc_tax = total_inc_tax;
    }
    
}
