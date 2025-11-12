package br.com.alura.screenmach.main;

import br.com.alura.screenmach.model.DadosSerie;
import br.com.alura.screenmach.model.DadosTemporada;
import br.com.alura.screenmach.service.ConsumoApi;
import br.com.alura.screenmach.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();


    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=a7773a13";



    public void exibirMenu(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("--- BEM VINDO AO SCREENMACH ---");
        System.out.println("Digite o nome da série que desejas buscar:");
        var nomeSerie = scanner.nextLine();

        // Obtendo os dados da API
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dados = converteDados.obterDados(json, DadosSerie.class);

        System.out.println(dados);


        List<DadosTemporada> temporadas = new ArrayList<>();

        System.out.println("");
        System.out.println("LISTA DE EPISÓDIOS POR TEMPORADA:");
        for(int i = 1; i <= dados.totalTemporadas(); i++){

            json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
            DadosTemporada dadosTemporada = converteDados.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);

        }

        temporadas.forEach(System.out::println);



    }
}
