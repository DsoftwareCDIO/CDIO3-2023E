package dtu;

public class Property extends Field {
    public enum Color {
        ORANGE, YELLOW, RED, PURPLE, GREEN, CYAN, BLUE, BROWN
    }

    private Player owner;
    private final int price;
    private final Color color;

    private Property sameColor;

    public Property(int price, Color color, int position) {
        super(FieldType.PROPERTY, position);
        this.price = price;
        this.color = color;
    }

    public void setSameColor(Property sameColor) {
        this.sameColor = sameColor;
    }

    public Property getSameColor() {
        return sameColor;
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
