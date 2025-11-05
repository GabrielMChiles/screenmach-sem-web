package br.com.alura.screenmach.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

    public String obterDados(String endereco){

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                // Erro genérico, pode ser um erro do servidor da API
                throw new RuntimeException("Falha na comunicação com a API de CEP. Código de status: " + response.statusCode());
            }

            String json = response.body();
            return json;

            // Se a verificação passou, o endereço é válido
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (RuntimeException e) {
            // Lança de novo a exceção que criamos para que a Main possa pegá-la
            throw e;
        } catch (Exception e) {
            // Captura qualquer outro erro inesperado (ex: JSON mal formatado)
            throw new RuntimeException("Ocorreu um erro inesperado durante a busca.");
        }
    }
    }