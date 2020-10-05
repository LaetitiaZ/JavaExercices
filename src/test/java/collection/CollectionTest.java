package collection;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Queue;

import static org.assertj.core.api.Assertions.*;

class CollectionTest {

    @Test
    public void test1() {

        //GIVEN
        Voyageur voyageur1 = new Voyageur(1,"2C", ClasseVoyage.BUSINESS);
        Voyageur voyageur2 = new Voyageur(2,"1C", ClasseVoyage.PREMIERE);
        Voyageur voyageur3 = new Voyageur(3,"3B", ClasseVoyage.ECO);
        Voyageur voyageur4 = new Voyageur(4,"1A", ClasseVoyage.PREMIERE);
        Voyageur voyageur5 = new Voyageur(5,"3C", ClasseVoyage.ECO);
        Voyageur voyageur6 = new Voyageur(6,"2B", ClasseVoyage.BUSINESS);
        Queue<Voyageur> fileAttente = new PriorityQueue<>(10, new VoyageComparator());

        //WHEN
        fileAttente.add(voyageur1);
        fileAttente.add(voyageur2);
        fileAttente.add(voyageur3);
        fileAttente.add(voyageur4);
        fileAttente.add(voyageur5);
        fileAttente.add(voyageur6);

        //THEN
        assertThat(fileAttente.poll().equals(voyageur4));
        assertThat(fileAttente.poll().equals(voyageur2));
        assertThat(fileAttente.poll().equals(voyageur6));
        assertThat(fileAttente.poll().equals(voyageur1));
        assertThat(fileAttente.poll().equals(voyageur3));
        assertThat(fileAttente.poll().equals(voyageur5));


    }
}