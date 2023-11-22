package dtu.game;

public class Field {
    //Enumeration of the different field types
    public enum FieldType{
        PROPERTY, START, CHANCE, JAIL, EMPTY
    }

    private FieldType type;
    public final int position;

    //Constructor for type field, takes fieldtype and position as arguments
    public Field(FieldType type, int position){
        this.type = type;
        this.position = position;
    }

    //Method to get fieldtype
    public FieldType getType() {
        return type;
    }

    //Method to get position
    public int getPosition() {
        return position;
    }
}
