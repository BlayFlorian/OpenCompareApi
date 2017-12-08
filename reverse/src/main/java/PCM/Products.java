package PCM;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Products {
    private String id;
    private LinkedHashMap<String,Cells> cells;

    public Products(String id, LinkedHashMap<String,Cells> cells){
        this.id = id;
        this.cells = cells;
    }

    public String toString() {
        return "id: "+ id;
    }

    public String getId() {
        return id;
    }
}
