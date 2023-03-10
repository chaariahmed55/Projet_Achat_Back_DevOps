package tn.esprit.rh.achat.services;

import tn.esprit.rh.achat.entities.Operateur;

import java.util.List;


public interface IOperateurService {

	List<Operateur> retrieveAllOperateurs();

	Operateur saveOperateur(Operateur o);

	void deleteOperateur(Long id);

	Operateur retrieveOperateur(Long id);

}
