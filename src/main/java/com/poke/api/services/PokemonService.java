package com.poke.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.poke.api.models.Pokemon;

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
	
	
	

}
