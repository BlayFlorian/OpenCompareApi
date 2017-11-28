package PCM;

import java.util.ArrayList;

public class Products {
    private String id;
    private ArrayList<Cells> cells;

    public Products(String id){
        this.id = id;
    }
    public String toString() {
        return "id: "+ id;
    }
}
