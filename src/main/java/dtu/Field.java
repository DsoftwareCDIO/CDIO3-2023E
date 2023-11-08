package dtu;

public class Field {
    public enum FieldType{
        PROPERTY, START, CHANCE, JAIL, EMPTY
    }

    private FieldType type;

    public Field(FieldType type){
        this.type = type;
    }

    public FieldType getType() {
        return type;
    }
}
