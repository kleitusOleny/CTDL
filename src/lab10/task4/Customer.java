package lab10.task4;

public class Customer {
    private Long cid;
    private String name;
    private int tier;
    
    public Customer(Long cid, String name, int tier) {
        this.cid = cid;
        this.name = name;
        this.tier = tier;
    }
    
    public Long getCid() {
        return cid;
    }
    
    public String getName() {
        return name;
    }
    
    public int getTier() {
        return tier;
    }
    
    @Override
    public String toString() {
        return "Customer{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", tier=" + tier +
                '}';
    }
}
