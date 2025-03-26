public class Item {
    private int id;
    private String name;
    private int quantity;
    private boolean isPurchased;
    private String addedAt;

    public Item(int id, String name, int quantity, boolean isPurchased, String addedAt) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.isPurchased = isPurchased;
        this.addedAt = addedAt;
    }

    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.isPurchased = false;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public boolean isPurchased() { return isPurchased; }
    public String getAddedAt() { return addedAt; }

    public void setName(String name) { this.name = name; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPurchased(boolean purchased) { isPurchased = purchased; }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", isPurchased=" + isPurchased +
                ", addedAt='" + addedAt + '\'' +
                '}';
    }
}
