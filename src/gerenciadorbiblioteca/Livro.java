/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciadorbiblioteca;

import java.time.Year;
import java.time.LocalDate;
/**
 *
 * @author mathe
 */
public class Livro {
    private String isbn;
    private String titulo;
    private String autorPrincipal;
    private Year anoPublicacao;
    private Integer quantidadeDisponivel;

    //<editor-fold defaultstate="collapsed" desc="gettersSetters">
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {    
        if(isbn.length() > 13){
            System.out.println("ERRO! ISBN tem mais de 13 digitos");
            return;
        }
        
        Boolean verificacao = verificarIsbn(isbn);
        if(verificacao){
            this.isbn = isbn;
        } else{
            System.out.println("ERRO! Codigo invalido");
        }
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if(titulo.length() == 0){
            System.out.println("ERRO! Titulo nao pode ser nulo.");
        } else{
            this.titulo = titulo;
        }
    }

    public String getAutorPrincipal() {
        return autorPrincipal;
    }

    public void setAutorPrincipal(String autorPrincipal) {
        if(autorPrincipal.length() == 0){
            System.out.println("ERRO! Autor nao pode ser nulo.");
        } else{
            this.autorPrincipal = autorPrincipal;
        }
    }

    public Year getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Year anoPublicacao) {
        LocalDate hoje = LocalDate.now();
        if(anoPublicacao.isAfter(Year.of(hoje.getYear())) ||
                anoPublicacao.isBefore(Year.of(0))){
            System.out.println("ERRO! Ano de publicacao deve "
                    + "ser positivo e antes do ano atual");
        }
        this.anoPublicacao = anoPublicacao;
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        if(quantidadeDisponivel < 0){
            System.out.println("ERRO! Quantidade disponivel deve ser "
                    + "positiva");
        }
        this.quantidadeDisponivel = quantidadeDisponivel;
    }
//</editor-fold>
    
    public Boolean verificarIsbn(String isbn){
        
        Integer[] digitos = new Integer[13];
        Integer soma=0;
        for(int i = 0; i<12; i++){
            digitos[i] = Character.getNumericValue(isbn.charAt(i));
            if(i%2 == 0){
                soma += digitos[i]*1;
            } else {
                soma += digitos[i]*3;
            }
        }
        
        Integer digitoVerificador;
        digitoVerificador = (10 - (soma%10)) % 10;
 
        digitos[12] = Character.getNumericValue(isbn.charAt(12));
        return digitoVerificador == digitos[12];
    }
    
    public Boolean verificarDisponibilidade(){
        return quantidadeDisponivel > 0; 
    }
    public void realizarEmprestimo(){
        quantidadeDisponivel--;
    }
    public void devolverLivro(){
        quantidadeDisponivel++;
    }
    
    @Override 
    public String toString(){
        return "ISBN: " + isbn + '\n' + "Titulo: " + titulo + '\n' +
                "Autor: " + autorPrincipal + '\n' + "Ano de Publicacao: " + 
                anoPublicacao.toString() + '\n' + "Quantidade Disponivel: " +
                quantidadeDisponivel.toString(); 
    }
}
