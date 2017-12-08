package PCM;

import org.json.JSONObject;

import java.util.ArrayList;

public class Products {
    private String id;
    private ArrayList<Cells> cells;

    public Products(String id, ArrayList<Cells> cells){
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
