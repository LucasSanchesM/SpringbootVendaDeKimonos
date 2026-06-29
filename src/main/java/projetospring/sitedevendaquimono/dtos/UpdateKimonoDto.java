package projetospring.sitedevendaquimono.dtos;

public record UpdateKimonoDto(String nome, String tamanho, String cor, String categoria, double preco, Integer quantidade, String caminhoImagem) {

}
