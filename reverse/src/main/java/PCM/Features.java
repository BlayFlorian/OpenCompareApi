package PCM;

public class Features {

    String name;
    String type;

    public Features(){ }
    public Features(String name, String type) {
        this.name = name;
        this.type = type;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return " name " + name + " type " + type;
    }
}
