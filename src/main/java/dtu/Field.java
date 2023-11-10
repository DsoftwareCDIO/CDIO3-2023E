package dtu;

public class Field {
    public enum FieldType{
        PROPERTY, START, CHANCE, JAIL, EMPTY
    }

    private FieldType type;
    private final int position;

    public Field(FieldType type, int position){
        this.type = type;
        this.position = position;
    }

    public FieldType getType() {
        return type;
    }

    public int getPosition() {
        return position;
    }
}
