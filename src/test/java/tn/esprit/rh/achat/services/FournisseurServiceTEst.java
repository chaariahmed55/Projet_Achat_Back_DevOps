package tn.esprit.rh.achat.services;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.CategorieFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static tn.esprit.rh.achat.entities.CategorieFournisseur.ORDINAIRE;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class FournisseurServiceTEst {

    @Mock
    FournisseurRepository fournisseurRepository;
    @InjectMocks
    FournisseurServiceImpl fournisseurService;
    Fournisseur f1 = new Fournisseur(12L, "Code Safa", "Libelle HLK", CategorieFournisseur.ORDINAIRE);
    Fournisseur f2 = new Fournisseur(22L, "Code Safa2", "Libelle HLK2", CategorieFournisseur.ORDINAIRE);
    List<Fournisseur> listFournisseurs = new ArrayList<Fournisseur>() {
        {
            add(f1);
            add(new Fournisseur(10L, "code 1", "libelle 1", CategorieFournisseur.ORDINAIRE));
            add(new Fournisseur(20L, "code 2", "libelle 2", CategorieFournisseur.ORDINAIRE));
        }
    };
    @Test
    public void retrieveFournisseurs() {
        System.out.println("retrieveFournisseurs");
        Mockito.when(fournisseurRepository.findById(12L)).thenReturn(Optional.of(f1));
        Fournisseur fournisseur1 = fournisseurService.retrieveFournisseur(12L);
        assertNotNull(fournisseur1);
    }
    @Test
    public void testretrieveAllFournisseurs() {
        System.out.println("retrieveAllFournisseurs");
        Mockito.when(fournisseurRepository.findAll()).thenReturn(listFournisseurs);
        List<Fournisseur> fournisseurList3 = fournisseurService.retrieveAllFournisseurs();
        assertEquals(3, fournisseurList3.size());
    }
    @Test
    public void testaddFournisseur() {
        System.out.println("testaddFournisseur");
        Mockito.when(fournisseurRepository.save(f1)).thenReturn(f1);
        Fournisseur fournisseur1 = fournisseurService.addFournisseur(f1);
        assertNotNull(fournisseur1);
        Mockito.verify(fournisseurRepository, times(1)).save(Mockito.any(Fournisseur.class));
    }
    @Test
    public void testdeleteFournisseur() {
        System.out.println("testdeleteFournisseur");
        fournisseurService.deleteFournisseur(66L);
        Mockito.verify(fournisseurRepository, times(0)).delete(f2);
    }


}
