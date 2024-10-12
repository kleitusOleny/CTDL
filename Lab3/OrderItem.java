package Lab3;

public class OrderItem {
    private Product p;
    private int quality;

    public OrderItem(Product p, int quality) {
        this.p = p;
        this.quality = quality;
    }
    public Product getP() {
        return p;
    }

    public double cost() {
        return this.p.getPrice() * this.quality;
    }

    public boolean contain(Product p) {
        if (this.p.equals(p)) {
            return true;
        }
        return false;
    }

    public boolean containType(String type) {
        if (this.p.getType().equals(type)){
            return true;
        }
        return false;
    }
}
