package com.poke.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.poke.api.models.Pokemon;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PokemonService {
	
	
	@Autowired
	private WebClient webClient;
	
	public Optional<Pokemon> buscarPorId(Long id) {
		
		Mono<Pokemon> monoPokemon = this.webClient.get()
				.uri("/pokemon/{id}", id)
				.retrieve()
				.bodyToMono(Pokemon.class);
		
		
		Optional<Pokemon> pokemon = Optional.ofNullable(monoPokemon.block());
		
		return pokemon;
		
	}

	public List<Pokemon> buscarTodos() {
		
		List<Pokemon> lista = new ArrayList<>();
		
		Flux<Pokemon> fluxPokemon = this.webClient.get()
				.uri("/pokemon")
				.retrieve()
				.bodyToFlux(Pokemon.class);
			
		
		fluxPokemon.subscribe(r -> {
			
		});
			
		
		
		return lista;
	}
	
	
	

}
