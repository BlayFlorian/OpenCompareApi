package PCM;

import org.json.JSONObject;

public class Features {

    String name;
    String type;
    String id;

    public Features(String name, String type, String id) {
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "id " + id + " name " + name + " type " + type;
    }

    public JSONObject toJson() {
        return new JSONObject(this);
    }
}
