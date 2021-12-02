package com.wagner.heroesapi;

import com.wagner.heroesapi.document.Heroes;
import com.wagner.heroesapi.repository.HeroesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static com.wagner.heroesapi.constants.HeroesConstant.HEROES_ENDPOINT_LOCAL;

@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
public class HeroesapiApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Autowired
	HeroesRepository heroesRepository;


	@org.junit.Test
	public void createHero(){
		Heroes batman = new Heroes("45", "Batman", "DC", 10);

		webTestClient.post().uri(HEROES_ENDPOINT_LOCAL)
				.body(Mono.just(batman), Heroes.class)
				.exchange()
					.expectStatus().isCreated()
					.expectBody();


	}



	@org.junit.Test
	public void getOneHeroeById(){

		webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"),"2")
				.exchange()
				.expectStatus().isOk()
				.expectBody();


	}

	@org.junit.Test
	public void getOneHeronotFound(){

		webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"),"99999")
				.exchange()
				.expectStatus().isNotFound();

	}




	@Test
	public void deleteHero(){

		webTestClient.delete().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"),"45")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isNotFound()
				.expectBody(Void.class);

	}

}
