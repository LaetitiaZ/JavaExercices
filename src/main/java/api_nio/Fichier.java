package api_nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class Fichier {

    private Path path;

    public Fichier(Path path) {
        this.path = path;
    }

    public void creerFichier() throws IOException{
        Files.deleteIfExists(path);
        Files.createFile(path);
    }

    public void ajouterContenu(Iterable list) {
        try {
            Files.write(path, list);
        } catch (IOException e) {
            System.out.println("File does not exist");
        }
    }

    public HashMap<String, Integer> countOccurrence() {
        HashMap<String, Integer> motsOccurrence  = chaqueMot();
        ArrayList<String> mots = motArray();
        for(String motACompter : motsOccurrence.keySet()) {
            motsOccurrence.putIfAbsent(motACompter, compterMot(motACompter, mots));
        }
        return motsOccurrence;
    }

    private ArrayList<String> motArray() {
        ArrayList<String> mots = new ArrayList<>();
        try {
            BufferedReader bufferedReader = Files.newBufferedReader(path);
            String line;
            while((line = bufferedReader.readLine()) !=null) {
                for(String mot : line.split(" ")) {
                   mots.add(mot);
                }
            }
        } catch (IOException e) {
            System.out.println("No such file");
        }
        return mots;
    }

    private HashMap<String, Integer> chaqueMot() {
        ArrayList<String> motArray = motArray();
        HashMap<String, Integer> chaqueMot = new HashMap<>();
        for(String mot : motArray) {
            if(!chaqueMot.keySet().contains(mot)) {
                chaqueMot.put(mot, null);
            }
        }
        return chaqueMot;
    }

    private int compterMot(String motACompter, ArrayList<String> mots) {
        int compteur = 0;
        for (String mot : mots) {
            if (mot.equals(motACompter)) {
                compteur++;
            }
        }
        return compteur;
    }

    public String motLePlusRetrouve() {
        HashMap<String, Integer> mots = countOccurrence();
        int maxValue = 0;
        String motCherche = "";
        for(Map.Entry<String, Integer> entry : mots.entrySet()) {
            if(entry.getValue()>maxValue) {
                maxValue = entry.getValue();
                motCherche = entry.getKey();
            }
            else if(entry.getValue() == maxValue) {
                motCherche += " "+entry.getKey();
            }
        }
        return motCherche;
    }
    public List<String> mapOccurenceToList() {
        HashMap<String, Integer> map = countOccurrence();
        List<String> mapToList = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            mapToList.add("mot: "+entry.getKey()+ " occurrence: "+entry.getValue());
        }
        return mapToList;
    }
}
