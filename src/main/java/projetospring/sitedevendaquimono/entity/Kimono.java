package projetospring.sitedevendaquimono.entity;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_ kimono")
public class Kimono {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    @Column(name= "kimono_id")
    private UUID kimonoId;
    
    @Column(name="nome")
    private String nome;

    @Column(name="tamanho")
    private String tamanho;

    @Column(name="cor")
    private String cor;

    @Column(name="categoria")
    private String categoria;

    @Column(name="preco")
    private double preco;
    
    @Column(name="quantidade")
    private Integer quantidade;

    @Column(name="caminho_imagem")
    private String caminhoImagem;

    @Column(name="created_time")
    private Instant createdTime;

    @Column(name="updated_time")
    private Instant updateTime;

    public Kimono() {
    }
    
    public Kimono(UUID kimonoId, String nome, String tamanho, String cor, String categoria, double preco,
            Integer quantidade, String caminhoImagem, Instant createdTime, Instant updateTime) {
        this.kimonoId = kimonoId;
        this.nome = nome;
        this.tamanho = tamanho;
        this.cor = cor;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidade = quantidade;
        this.caminhoImagem = caminhoImagem;
        this.createdTime = createdTime;
        this.updateTime = updateTime;
    }





    public Instant getCreatedTime() {
        return createdTime;
    }



    public void setCreatedTime(Instant createdTime) {
        this.createdTime = createdTime;
    }



    public Instant getUpdateTime() {
        return updateTime;
    }



    public void setUpdateTime(Instant updateTime) {
        this.updateTime = updateTime;
    }



    public UUID getKimonoId() {
        return kimonoId;
    }

    public void setKimonoId(UUID kimonoId) {
        this.kimonoId = kimonoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }


    

}
