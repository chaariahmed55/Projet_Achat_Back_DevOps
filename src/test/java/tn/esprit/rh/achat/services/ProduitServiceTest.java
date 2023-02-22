package tn.esprit.rh.achat.services;

import jdk.internal.org.jline.utils.Log;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;

//classe de test produit
@ExtendWith(MockitoExtension.class)
public class ProduitServiceTest {

@Mock
    ProduitRepository produitRepository;
@InjectMocks
    ProduitServiceImpl produitService;
    Produit p1 = new Produit(2300L, "A50", "voiture", 35000);
    Produit p2 = new Produit(2305L, "A50", "voiture", 35000);
    List<Produit> listProduits = new ArrayList<Produit>() {
        {
            add(p1);
            add(new Produit(2301L, "A51", "Motors", 7000));
            add(new Produit(2302L, "A52", "Avion", 300000000));
        }
    };
   @Test
    public void retrieveAllProduits() {
       Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(p1));
       List<Produit> produit = produitService.retrieveAllProduits();
       assertNotNull(produit);
       Log.info("get ==> " + produit.toString());
    }

    @Test
    public void addProduit(Produit p) {

        Mockito.when(produitRepository.save(p)).thenReturn(p);
        Produit produit = produitService.addProduit(p);
        assertNotNull(produit);
        Mockito.verify(produitRepository, times(1)).save(Mockito.any(Produit.class));

    }

    @Test
    public void deleteProduit(Long produitId) {
        produitService.deleteProduit(2305L);
        Mockito.verify(produitRepository, times(0)).delete(p2);

    }



}
