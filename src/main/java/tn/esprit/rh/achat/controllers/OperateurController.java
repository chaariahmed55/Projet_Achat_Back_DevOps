package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.services.IOperateurService;

import java.util.List;

@RestController
@Api(tags = "Gestion des opérateurs")
@RequestMapping("/operateur")
@CrossOrigin("*")
public class OperateurController {

	@Autowired
	IOperateurService operateurService;
	


	/**
	 * http://localhost:8089/SpringMVC/operateur/retrieve-all-operateurs
	 * @return
	 */
	@GetMapping("/retrieve-all-operateurs")
	@ResponseBody
	public List<Operateur> getOperateurs() {
		return operateurService.retrieveAllOperateurs();
	}


	/**
	 * http://localhost:8089/SpringMVC/operateur/retrieve-operateur/8
 	 * @param operateurId
	 * @return
	 */
	@GetMapping("/retrieve-operateur/{operateur-id}")
	@ResponseBody
	public Operateur retrieveOperateur(@PathVariable("operateur-id") Long operateurId) {
		return operateurService.retrieveOperateur(operateurId);
	}


	/**
	 * http://localhost:8089/SpringMVC/operateur/add-operateur
	 * @param op
	 * @return
	 */
	@PostMapping("/add-operateur")
	@ResponseBody
	public Operateur addOperateur(@RequestBody Operateur op) {
		return operateurService.saveOperateur(op);
	}

	/**
	 * http://localhost:8089/SpringMVC/operateur/remove-operateur/{operateur-id}
 	 * @param operateurId
	 */
	@DeleteMapping("/remove-operateur/{operateur-id}")
	@ResponseBody
	public void removeOperateur(@PathVariable("operateur-id") Long operateurId) {
		operateurService.deleteOperateur(operateurId);
	}


	/**
	 * http://localhost:8089/SpringMVC/operateur/modify-operateur
	 * @param operateur
	 * @return
	 */
	@PutMapping("/modify-operateur")
	@ResponseBody
	public Operateur modifyOperateur(@RequestBody Operateur operateur) {
		return operateurService.saveOperateur(operateur);
	}

	
}
