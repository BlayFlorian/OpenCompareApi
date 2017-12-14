package PCM;

import org.json.JSONObject;

/**
 * @author Lucile FLOC, Florian BLAY, Nicolas RANNOU, Briac PERRIN, Othmane WAFI
 * Classe qui gère l'exportation du PCM
 */
public class PCMExport {
    /**
     * Propriétés privées
     */
    PCM pcm;
    JSONObject json;

    /**
     * Constructeur de la classe PCMExport
     * @param pcm
     */
    public PCMExport(PCM pcm) {
        this.pcm = pcm;
        JSONObject jsonObject = pcm.metadata.toJson();
        jsonObject = pcm.featureToJson(jsonObject);
        json = pcm.productToJson(jsonObject);
    }

    /**
     * Getter
     * @return l'objet JSON
     */
    public JSONObject getJson(){
        return json;
    }

}
