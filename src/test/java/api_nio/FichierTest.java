package api_nio;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static org.assertj.core.api.Assertions.*;


class FichierTest {

    @Test
    void test1() throws IOException {

        Path path = Paths.get("oiseaux.txt");
        ArrayList<String> list = new ArrayList<>();
        list.add("Salut je suis un oiseau");
        list.add("Salut je suis un pigeon");
        list.add("Salut je suis un moineau");
        Fichier fichier = new Fichier(path);

        fichier.creerFichier();
        fichier.ajouterContenu(list);


        HashMap<String, Integer> goodValues = new HashMap<>();
        goodValues.put("Salut",3);
        goodValues.put("je",3);
        goodValues.put("suis",3);
        goodValues.put("un",3);
        goodValues.put("oiseau",1);
        goodValues.put("pigeon",1);
        goodValues.put("moineau",1);

        assertThat(fichier.countOccurrence()).isEqualTo(goodValues);

        Path pathToOccurence = Paths.get("occurrence.txt");
        Fichier occurence = new Fichier(pathToOccurence);

        occurence.creerFichier();

        occurence.ajouterContenu(fichier.mapOccurenceToList());

        String motLePlusRetrouve = fichier.motLePlusRetrouve();
        assertThat(motLePlusRetrouve).contains("Salut", "je", "suis", "un");
    }


}