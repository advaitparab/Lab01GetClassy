public class Product {
    private String name;
    private String description;
    private String ID;
    private double cost;

    // Constructor
    public Product(String name, String description, String ID, double cost) {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
    }

    // Methods
    public String toCSV() {
        return String.join(",", name, description, ID, String.valueOf(cost));
    }

    public String toJSON() {
        return String.format("{\"name\":\"%s\",\"description\":\"%s\",\"ID\":\"%s\",\"cost\":%.2f}",
                name, description, ID, cost);
    }

    public String toXML() {
        return String.format("<Product><Name>%s</Name><Description>%s</Description><ID>%s</ID><Cost>%.2f</Cost></Product>",
                name, description, ID, cost);
    }

    // Overrides
    @Override
    public String toString() {
        return String.format("%s (%s): %s - $%.2f", name, ID, description, cost);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return Double.compare(product.cost, cost) == 0 &&
                name.equals(product.name) &&
                description.equals(product.description) &&
                ID.equals(product.ID);
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getID() { return ID; }

    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
}

