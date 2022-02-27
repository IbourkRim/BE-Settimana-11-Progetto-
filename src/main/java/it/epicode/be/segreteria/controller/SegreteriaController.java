package it.epicode.be.segreteria.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import it.epicode.be.segreteria.model.CorsoLaurea;
import it.epicode.be.segreteria.model.SegreteriaDB;
import it.epicode.be.segreteria.model.Studente;

@Controller
public class SegreteriaController {

	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	ApplicationContext ctx;

	public SegreteriaDB getSegreteriaDb() {
		return ctx.getBean(SegreteriaDB.class);
	}

	
	/**
	 * http://localhost:8080/segreteria
	 * Usare questo link per accedere al sito
	 * tranne per la delete, si usa la pathvariable indicata nel metodo 
	 */
	
	@GetMapping("/segreteria")
	public String showView(Model model) {
		return "formSegreteria";
	}

	
	@GetMapping("/stampastudenti")
	public ModelAndView stampaStudenti() {
		return new ModelAndView("studentiView", "listaStudenti", getSegreteriaDb().getAllStudenti());
	}
	
	
	@GetMapping("/stampacorsi")
	public ModelAndView stampaCorsi() {
		return new ModelAndView("corsiView", "listaCorsi", getSegreteriaDb().getAllCorsi());
	}

	
	@GetMapping("/eliminastudente/{matricola}")
	public ModelAndView eliminaStudente(@PathVariable("matricola") String matricola) {
		getSegreteriaDb().cancellaStudente(matricola);
		return new ModelAndView("studentiView", "listaStudenti", getSegreteriaDb().getAllStudenti());
	}
	
	
	@GetMapping("/eliminacorso/{codicecorso}")
	public ModelAndView eliminaCorso(@PathVariable("codicecorso") String codicecorso) {
		getSegreteriaDb().cancellaCorso(codicecorso);
		return new ModelAndView("corsiView", "listaCorsi", getSegreteriaDb().getAllCorsi());
	}


	@GetMapping("/studente/mostraformaggiungi")
	public ModelAndView mostraFormAggiungi(Studente studente) {

		ModelAndView modelandview = new ModelAndView("inseriscistudente", "listaCorsi",
				getSegreteriaDb().getAllCorsi());
		return modelandview;
	}

	
	@PostMapping("/studente/inserisci")
	public String inserisciStudente(Studente studente, BindingResult result, Model model) {

		getSegreteriaDb().aggiungiStudente(studente);
		model.addAttribute("listaStudenti", getSegreteriaDb().getAllStudenti());
		model.addAttribute("listaCorsi", getSegreteriaDb().getAllCorsi());
		return "studentiView";
	}
	
	
		@GetMapping("/corso/mostraformaggiungi")
	public ModelAndView mostraFormAggiungiCorso(CorsoLaurea corso) {

		ModelAndView modelandview = new ModelAndView("inseriscicorso", "listaCorsi",
				getSegreteriaDb().getAllCorsi());
		return modelandview;
	}
	
	
	@PostMapping("/corso/inserisci")
	public String inserisciCorso(CorsoLaurea corso, BindingResult result, Model model) {

		getSegreteriaDb().aggiungiCorso(corso);
		model.addAttribute("listaCorsi", getSegreteriaDb().getAllCorsi());
		return "corsiView";
	}
	
	
	
}
