package PCM;

public class Features {

    private String name;
    private String type;
    private String id;

    public Features(String name, String type, String id) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
