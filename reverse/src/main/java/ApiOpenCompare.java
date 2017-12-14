import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import webService.ApiCall;
import PCM.*;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Lucile FLOC, Florian BLAY, Nicolas RANNOU, Briac PERRIN, Othmane WAFI
 * Classe ApiOpenCompare qui est exécuté
 */
public class ApiOpenCompare
{
    public static void main(String[] args) throws IOException {
        while(true) {
            System.out.println("Quelques exemples: ");
            System.out.println("5a17ec1e086cfd088ff72de9, 59c3d669384f2b07bbda544d, 59c3d669384f2b07bbda5450");
            System.out.println("Entrez un id");
            Scanner sc = new Scanner(System.in);
            String id = sc.nextLine();
            String myURL = "https://opencompare.org/api/" + id;

            ApiCall call = new ApiCall(myURL);
            JSONObject json = call.getJsonObj();

            PCM pcm = new PCM(json);
            PCMExport pcmExport = new PCMExport(pcm);
            JSONObject json2 = pcmExport.getJson();

            System.out.println("Json généré:");
            System.out.println(json2.toString());
            //Comparaison
            ObjectMapper mapper = new ObjectMapper();
            JsonNode tree1 = mapper.readTree(json.toString());
            JsonNode tree2 = mapper.readTree(json2.toString());
            System.out.println("Identique: " + tree1.equals(tree2));
            System.out.println("x pour quitter, entrer pour continuer, m pour modifier");
            Scanner scF = new Scanner(System.in);
            String t = scF.nextLine();
            if(t.equals("x")) {
                System.out.println("Bonne journée");
                return;
            } else if(t.equals("m")) {
                System.out.println("Modification de l'auteur");
                Scanner scA = new Scanner(System.in);
                String auteur = scA.nextLine();
                pcm.getMetadata().setAuthor(auteur);
                PCMExport pcmExport2 = new PCMExport(pcm);
                JSONObject json3 = pcmExport2.getJson();

                System.out.println("Json généré:");
                System.out.println(json3.toString());
                //Comparaison
                JsonNode tree3 = mapper.readTree(json.toString());
                JsonNode tree4 = mapper.readTree(json3.toString());
                System.out.println("Identique: " + tree3.equals(tree4));
            }
        }
    }
}
