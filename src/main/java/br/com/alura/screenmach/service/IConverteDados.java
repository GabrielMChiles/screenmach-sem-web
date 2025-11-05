package br.com.alura.screenmach.service;

/*
    Interface que faz a gereneralizacao do metodo "ConverterDados"
    e possibilita que ele seja utilizado em quase qualquer contexto
*/
public interface IConverteDados {
    <T> T obterDados (String json, Class<T> classe);
}
