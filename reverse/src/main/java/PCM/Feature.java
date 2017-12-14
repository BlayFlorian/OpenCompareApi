package PCM;

/**
 * @author Lucile FLOC, Florian BLAY, Nicolas RANNOU, Briac PERRIN, Othmane WAFI
 * Classe qui gère les features du PCM
 */
public class Feature {

    /**
     * Propriétés privées
     */
    private String name;
    private String type;
    private String id;

    /**
     * Constructeur de la classe Feature
     * @param name
     * @param type
     * @param id
     */
    public Feature(String name, String type, String id) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    /**
     * Getter
     * @return nom du feature
     */
    public String getName() {
        return name;
    }

    /**
     * Getter
     * @return le type du feature
     */
    public String getType() {
        return type;
    }

    /**
     * Getter
     * @return l'ID du feature
     */
    public String getId() {
        return id;
    }

    /**
     * Setter qui modifie l'id du feature
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }
    
}
