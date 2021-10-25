package com.poke.api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poke.api.models.Pokemon;
import com.poke.api.models.Results;
import com.poke.api.services.PokemonService;

import reactor.core.publisher.Flux;

@Controller
@RequestMapping("/pokemons")
public class PokemonController {
	
	@Autowired
	private PokemonService pokemonService;
	
	@GetMapping
	public ResponseEntity<Flux<Results>> buscarTodos() {
		
		Flux<Results> listaPokemon = pokemonService.buscarTodos();
		
		return ResponseEntity.ok(listaPokemon);
			
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Pokemon>> buscarPorId(@PathVariable Long id) {
		Optional<Pokemon> pokemon = pokemonService.buscarPorId(id);
		return ResponseEntity.ok(pokemon);
	}
	

}
