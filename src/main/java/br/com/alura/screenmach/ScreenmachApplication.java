package br.com.alura.screenmach;

import br.com.alura.screenmach.model.DadosSerie;
import br.com.alura.screenmach.service.ConsumoApi;
import br.com.alura.screenmach.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmachApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmachApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        ConsumoApi consumoApi = new ConsumoApi();
        // Obtendo os dados da API
        var json = consumoApi.obterDados("https://www.omdbapi.com/?t=peaky+blinders&apikey=a7773a13");

        // Convertendo e filtrando os dados que eu quero que seja exibido da API
        ConverteDados converteDados = new ConverteDados();
        DadosSerie dados = converteDados.obterDados(json, DadosSerie.class);

        System.out.println(dados);
    }
}
