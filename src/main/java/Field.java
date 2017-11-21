public class Field {
    public Field(String input) {

    }

    public Field nextGen() {
        return new Field(".");
    }

    public String toString() {
        return ".";
    }
}
