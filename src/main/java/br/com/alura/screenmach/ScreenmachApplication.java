package br.com.alura.screenmach;

import br.com.alura.screenmach.main.Main;
import br.com.alura.screenmach.model.DadosEpisodio;
import br.com.alura.screenmach.model.DadosSerie;
import br.com.alura.screenmach.model.DadosTemporada;
import br.com.alura.screenmach.service.ConsumoApi;
import br.com.alura.screenmach.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmachApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmachApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Main main = new Main();
        main.exibirMenu();
    }
}
