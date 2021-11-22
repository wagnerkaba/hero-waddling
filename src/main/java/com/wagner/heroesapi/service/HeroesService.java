package com.wagner.heroesapi.service;


import com.wagner.heroesapi.document.Heroes;
import com.wagner.heroesapi.repository.HeroesRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HeroesService {

    private final HeroesRepository heroesRepository;

    public HeroesService(HeroesRepository heroesRepository){
        this.heroesRepository =  heroesRepository;
    }

    public Flux<Heroes> findAll(){

        Iterable<Heroes> iterable = this.heroesRepository.findAll();

        return Flux.fromIterable(iterable);
    }

    public Mono<Heroes>  findByHero(String id){
        return Mono.justOrEmpty(this.heroesRepository.findById(id));
    }

    public Mono<Heroes> save(Heroes heroes){
        return Mono.justOrEmpty(this.heroesRepository.save(heroes));
    }

    public Mono<Boolean> deleteByIdHero(String id){
        heroesRepository.deleteById(id);
        return Mono.just(true);
    }

}
