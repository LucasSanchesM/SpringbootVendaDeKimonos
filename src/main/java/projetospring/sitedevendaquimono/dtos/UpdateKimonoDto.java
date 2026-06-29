package projetospring.sitedevendaquimono.dtos;

public record UpdateKimonoDto(String nome, String tamanho, String cor, String categoria, Double preco, Integer quantidade, String caminhoImagem) {

}
