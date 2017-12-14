package PCM;
import java.util.LinkedHashMap;

public class Products {
    private String id;
    private LinkedHashMap<String,Cells> cells;

    public Products(String id, LinkedHashMap<String,Cells> cells){
        this.id = id;
        this.cells = cells;
    }


    public String getId() {
        return id;
    }

    public LinkedHashMap<String,Cells> getCells() {
        return cells;
    }
}
