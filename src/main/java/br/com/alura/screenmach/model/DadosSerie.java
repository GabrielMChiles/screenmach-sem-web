package br.com.alura.screenmach.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Propriedade necessária para que o jakson ignore os dados que não foram descritas aqui
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String titulo,
                            @JsonAlias("totalSeasons") Integer totalTemporadas,
                            @JsonAlias("imdbRating")String avaliacoes) {
}
