package PCM;
import java.util.LinkedHashMap;

/**
 * @author Lucile FLOC, Florian BLAY, Nicolas RANNOU, Briac PERRIN, Othmane WAFI
 * Classe Product qui gère les products
 */
public class Product {

    /**
     * Propriétés privées
     */
    private String id;
    private LinkedHashMap<String, Cell> cells;

    /**
     * Constructeur de la classe Product
     * @param id
     * @param cells
     */
    public Product(String id, LinkedHashMap<String, Cell> cells){
        this.id = id;
        this.cells = cells;
    }

    /**
     * Getter
     * @return l'id
     */
    public String getId() {
        return id;
    }

    /**
     * Getter
     * @return cells
     */
    public LinkedHashMap<String, Cell> getCells() {
        return cells;
    }
}
