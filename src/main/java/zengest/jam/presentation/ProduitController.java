package zengest.jam.presentation;




import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.google.common.collect.Lists;

import zengest.jam.domaine.entities.Notification;
import zengest.jam.domaine.entities.Produit;
import zengest.jam.domaine.entities.Ravitailler;
import zengest.jam.domaine.entities.User;
import zengest.jam.domaine.entities.Vente;
import zengest.jam.dto.ProduitDto;
import zengest.jam.dto.RavitaillerDto;
import zengest.jam.dto.UserDto;
import zengest.jam.dto.VenteDto;
import zengest.jam.service.INotification;
import zengest.jam.service.IProduit;
import zengest.jam.service.IRavitailler;
import zengest.jam.service.IVente;
import zengest.jam.service.Userservice;


@Controller
public class ProduitController {
	
	//on injecte la couche service
	@Autowired
	private IProduit service;
	@Autowired
	private IRavitailler service_depot ;
	@Autowired
	private IVente service_vente;
	@Autowired
	private Userservice userService;
	@Autowired
	private INotification service_notif;
	
	
	
	
	@PostMapping("/creerdepot.asp")
	public String enregistrercreation(@ModelAttribute RavitaillerDto  ravitaillerDto,Model model) {
		
		Produit req= service.rechercherparid(ravitaillerDto.getProd_id());
		
		
		
		Ravitailler ravit = new Ravitailler();
		
		ravit.setDate(ravitaillerDto.getDate());
		ravit.setProduit(req);
		ravit.setQte(ravitaillerDto.getQte());
		
		req = service.ravitaillerproduit(ravit);
		
		service.creer_modifierProduit(req);
		Notification notif = new Notification();
		
		notif.setDate(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		notif.setObjet("Vous avez fait un depot de :"+ravit.getQte()+' '+req.getNom()+" le "+ravit.getDate());
		service_notif.creer_notif(notif);
		
		return "redirect:/creerdepots";
	}
	@GetMapping("/creerdepots")
	public String afficherlistedepot(Model model) {
		
		List<Ravitailler> listedepots = service_depot.affichertous();
		
		
		List<Produit> listeproduit = service.affichertous();
		model.addAttribute("listedepots", listedepots);
		model.addAttribute("listeproduit", listeproduit);
		model.addAttribute("produit", new Produit());
		
			
		return "depot";
	}
	@GetMapping("/produits.asp")
	public String afficherlistesommation(Model model) {
		
		
		// recupere la liste des produit de la base de donnees
		List<Produit> listeproduit = service.affichertous();
		
		// transforme la liste des produits en liste des produitDto que je vais manipuler sur la vue
		List<ProduitDto> listeproduitDto = Lists.transform(listeproduit, (Produit input) -> new ProduitDto(input.getId(), input.getNom(),input.getPrix(),input.getPv(),input.getImage(),input.getDescription(),input.getStock()));
		
		model.addAttribute("listeproduitDto", listeproduitDto);
		
		model.addAttribute("produitDto", new ProduitDto());
		
		model.addAttribute("ravitaillerDto", new RavitaillerDto());
		
		
		//recupere les informations de connection
	//	final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		//final User user = userService.findUserByEmail(auth.getName());
		//recuperation de la liste des sommation
		
		
		
		
		
		//enregistrement de la liste des agriculteurs dans le model pour pouvoir la passer à la vue
		//model.addAttribute("listesommationDTO", listesommationsDTO);
		//model.addAttribute("sommationDto", sommationDto);
		//model.addAttribute("userconnecton",user.getName() );
			
		return "tables";
	}
	@PostMapping("/creerproduit")
	public String enregistrerSommation(@ModelAttribute ProduitDto  produitDto, Model model) {
		
		Produit req= new Produit();
		req.setNom(produitDto.getNom());
		req.setPrix(produitDto.getPrix());
		req.setPv(produitDto.getPv());
		req.setDescription(produitDto.getDesc());
		
		req.setImage("vide");
		
		service.creer_modifierProduit(req);
		Notification notif = new Notification();
		
		notif.setDate(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		notif.setObjet("Vous avez crée un nouveau produit :"+req.getNom()+" le "+notif.getDate());
		service_notif.creer_notif(notif);
		
		return "redirect:/produits.asp";
	}
	
	
	@GetMapping("/creerventes")
	public String afficherlistevente(Model model) {
		int somme=0;
		
		List<Vente> listeventes = service_vente.affichertous();
		int nbre_vente =listeventes.size();
		Long montant_vendu = (long) 0;
		int qte_prod =0;
	
		List<User> listesusers = userService.findUserByStatus(2);
		int nbre_pers = listesusers.size();
		
		
		for(int i=0;i<listeventes.size();i++) {
			
			somme = somme + listeventes.get(i).getTotal_pv();
			montant_vendu = montant_vendu + listeventes.get(i).getTotal_montant();
			qte_prod = qte_prod + listeventes.get(i).getQte();
			
		}
		
		
		List<Produit> listeproduit = service.affichertous();
		model.addAttribute("listeventes", listeventes);
		model.addAttribute("listeproduit", listeproduit);
		model.addAttribute("produit", new Produit());
		model.addAttribute("vente", new Vente());
		model.addAttribute("user", new User());
		model.addAttribute("somme", somme);
		model.addAttribute("montant_vendu", montant_vendu);
		model.addAttribute("qte_prod", qte_prod);
		model.addAttribute("nbre_vente", nbre_vente);
		model.addAttribute("listesusers", listesusers);
		model.addAttribute("nbre_vente", nbre_vente);
		model.addAttribute("nbre_pers", nbre_pers);
		
			
		return "vente";
	}
	@PostMapping("/creervente.asp")
	public String enregistrervente(@ModelAttribute VenteDto  venteDto,Model model) {
		
		Produit req= service.rechercherparid(venteDto.getProd_id());
		User acheteur = userService.findUserByEmail(venteDto.getAch_email());
		
		
		
		Vente vente = new Vente();
		
		if(req.getStock()>=venteDto.getQte()) {
			
			vente.setUser(acheteur);
			vente.setDate(venteDto.getDate());
			vente.setProduit(req);
			vente.setQte(venteDto.getQte());
			vente.setTotal_montant(vente.getProduit().getPrix()*vente.getQte());
			vente.setTotal_pv(vente.getProduit().getPv()*vente.getQte());
			
			req = service.faireunevente(vente);
			
			
			
			service.creer_modifierProduit(req);
			Notification notif = new Notification();
			
			notif.setDate(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			notif.setObjet("Nouvelle vente : Nom du  produit  :"+req.getNom()+" date de la vente :"+notif.getDate()+" qte vendu :"+vente.getQte()+" client :"+vente.getUser().getName());
			service_notif.creer_notif(notif);
			
		}
		
		
		
		return "redirect:/creerventes";
	}
	
	@GetMapping("/supv/{id}")
	public String supprimervente(@PathVariable("id") Long id) {
		
		Vente v = service_vente.afficherparid(id);
	Produit pro =v.getProduit();
	int st =pro.getStock();
	pro.setStock(v.getQte()+st);
	service.creer_modifierProduit(pro);
		
	
	service_vente.suprimer(id);
		
		
		
		return "redirect:/creerventes";
		
	}
	@GetMapping("/supd/{id}")
	public String supprimerdepot(@PathVariable("id") Long id) {
		
		Ravitailler v = service_depot.afficherparid(id);
	Produit pro =v.getProduit();
	int st =pro.getStock();
	if(st<v.getQte()) {
		
		pro.setStock(st);
		
	}else {
		
		pro.setStock(st-v.getQte());
		
	}

	service.creer_modifierProduit(pro);
		
	service_depot.supprimer(id);
	
		
		
		
		return "redirect:/creerdepots";
		
	}
	
	@GetMapping("/connexion")
	public String connexionform(@ModelAttribute UserDto userDto, Model model) {
		
		
			
		return "login";
	}
	@GetMapping("/creer_admin")
	public String formadmin(@ModelAttribute UserDto userDto, Model model) {
		
		
			
		return "logup_admin";
	}
	@PostMapping("/creerform")
	public String creerform(@ModelAttribute UserDto userDto, Model model) {
		
		
		
		final User userExistant = userService.findUserByEmail(userDto.getEmail());
		
		if (userExistant != null) {
			
			return "logup_admin";
		}
		else {
			
			User us = new User();
			
			us.setName(userDto.getName());
			us.setLastName(userDto.getLastName());
			us.setEmail(userDto.getEmail());
			us.setPassword(userDto.getPassword());
			 
			//us.setRoles((Set<Role>) roleRepository.findByRole("ADMIN"));
			userService.saveUser(us);
			

		}
		
			
		return "login";
	}
	@GetMapping("/client.asp")
	public String afficherlistesommation(@ModelAttribute UserDto userDto, Model model) {
		
		
		
		//recupere les informations de connection
		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		final User user = userService.findUserByEmail(auth.getName());
		//recuperation de la liste des users
		
		List<User> listesusers = userService.findUserByStatus(2);
		
		//transformation en dto des users
		List<UserDto> listesusersDto = Lists.transform(listesusers, (User input)->new UserDto(input.getEmail(),input.getPassword(),input.getName(),input.getLastName(),input.getTelephone()));
		
		
		//pour ne pas faire circuler l'entité requerant dans le reseau, on mappe la liste d'entité avec celle de DTO pour n'avoir que des requerant DTO( ie sans Id)
		
		//enregistrement de la liste des agriculteurs dans le model pour pouvoir la passer à la vue
		model.addAttribute("listesusersDto", listesusersDto);
		model.addAttribute("userDto", userDto);
		model.addAttribute("userconnecton",user.getName() );
			
		return "client";
	}
	@PostMapping("/creerclient")
	public String creeraux(@ModelAttribute UserDto userDto, Model model) {
		
		
		
		final User userExistant = userService.findUserByEmail(userDto.getEmail());
		
		if (userExistant != null) {
			
			return "redirect:/client.asp";
		}
		else {
			
			User us = new User();
			
			us.setName(userDto.getName());
			us.setLastName(userDto.getLastName());
			us.setEmail(userDto.getEmail());
			us.setPassword(userDto.getPassword());
			us.setTelephone(userDto.getTelephone());
			 
			//us.setRoles((Set<Role>) roleRepository.findByRole("AUX"));
			userService.saveUserAux(us);
			

		}
		
Notification notif = new Notification();
		
		notif.setDate(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		notif.setObjet("Enregistrement d'un nouveau client au nom de :"+userDto.getName()+' '+userDto.getLastName()+' '+userDto.getTelephone()+" le "+notif.getDate());
		service_notif.creer_notif(notif);
			
		return "redirect:/client.asp";
	}
	
	@PostMapping("/auxr/{ref}")
	public String updateRequerant(@PathVariable("ref") String ref,UserDto userDto, Model model) {
		
		 //Long j = (Long) id ;


		
		
User us1 = userService.findUserByEmail(ref);

us1.setName(userDto.getName());
us1.setLastName(userDto.getLastName());
us1.setEmail(userDto.getEmail());
us1.setPassword(userDto.getPassword());
 
//us.setRoles((Set<Role>) roleRepository.findByRole("AUX"));
userService.saveUserAux(us1);
		
		
		
		
		
		
	
		return "redirect:/sommation.asp";		
		}
	@GetMapping("/notification")
	public String listenotification(@ModelAttribute UserDto userDto, Model model) {
		List<Notification> listenotification = service_notif.affichertous();
		
		
		model.addAttribute("listenotification", listenotification);
		model.addAttribute("notification", new Notification());
		
		return "notif";
	}

}
