package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.services.IProduitService;

import java.util.List;


@RestController
@CrossOrigin("*")
@Api(tags = "Gestion des produits")
@RequestMapping("/produit")
public class ProduitRestController {

	@Autowired
	IProduitService produitService;


	/**
	 * http://localhost:8089/SpringMVC/produit/retrieve-all-produits
 	 * @return
	 */
	@GetMapping("/retrieve-all-produits")
	@ResponseBody
	public List<Produit> getProduits() {
		return produitService.retrieveAllProduits();
	}

	/**
	 *
	 * http://localhost:8089/SpringMVC/produit/retrieve-produit/8
	 * @param produitId
	 * @return
	 */
	@GetMapping("/retrieve-produit/{produit-id}")
	@ResponseBody
	public Produit retrieveRayon(@PathVariable("produit-id") Long produitId) {
		return produitService.retrieveProduit(produitId);
	}


	/**
	 * Ajouter en produit tout en lui affectant la catégorie produit et le stock associés
	 * http://localhost:8089/SpringMVC/produit/add-produit/{idCategorieProduit}/{idStock}
	 * @param p
	 * @return
	 */
	@PostMapping("/add-produit")
	@ResponseBody
	public Produit addProduit(@RequestBody Produit p) {
		return produitService.addProduit(p);
	}


	/**
	 * http://localhost:8089/SpringMVC/produit/remove-produit/{produit-id}
	 * @param produitId
	 */
	@DeleteMapping("/remove-produit/{produit-id}")
	@ResponseBody
	public void removeProduit(@PathVariable("produit-id") Long produitId) {
		produitService.deleteProduit(produitId);
	}

	/**
	 *
	 * http://localhost:8089/SpringMVC/produit/modify-produit/{idCategorieProduit}/{idStock}
	 * @param p
	 * @return
	 */
	@PutMapping("/modify-produit")
	@ResponseBody
	public Produit modifyProduit(@RequestBody Produit p) {
		return produitService.updateProduit(p);
	}


	/**
	 * Si le responsable magasin souhaite modifier le stock du produit il peut
	 * le faire en l'affectant au stock en question
	 * http://localhost:8089/SpringMVC/produit/assignProduitToStock/1/5
	 * @param idProduit
	 * @param idStock
	 */
	@PutMapping(value = "/assignProduitToStock/{idProduit}/{idStock}")
	public void assignProduitToStock(@PathVariable("idProduit") Long idProduit, @PathVariable("idStock") Long idStock) {
		produitService.assignProduitToStock(idProduit, idStock);
	}


}
