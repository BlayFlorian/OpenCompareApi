package PCM;

public class Features {
    String name;
    String type;

    public Features(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return " name " + name + " type " + type;
    }
}
