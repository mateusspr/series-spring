package api.series.series;

import api.series.series.model.DadosSerie;
import api.series.series.service.ConsumoApi;
import api.series.series.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SeriesApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SeriesApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?i=tt3896198&apikey=72d7ca45");
//		System.out.println(json);
//		json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}

}
