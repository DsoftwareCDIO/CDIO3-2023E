package dtu;

public class Property extends Field {
    public enum Color {
        ORANGE, YELLOW, RED, PURPLE, GREEN, CYAN, BLUE, BROWN
    }

    private Player owner;
    private final int price;
    private final Color color;

    public Property(int price, Color color, int position) {
        super(Field.FieldType.PROPERTY, position);
        this.price = price;
        this.color = color;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getPrice() {
        return price;
    }

    public Color getColor() {
        return color;
    }
}
