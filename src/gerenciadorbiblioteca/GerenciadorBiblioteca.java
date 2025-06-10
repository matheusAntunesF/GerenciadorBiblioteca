/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gerenciadorbiblioteca;
import java.time.Year;

/**
 *
 * @author mathe
 */
public class GerenciadorBiblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Livro livro = new Livro();
        livro.setIsbn("9780306406157");
        livro.setTitulo("Harry Potter");
        livro.setAutorPrincipal("JK Rolling");
        livro.setAnoPublicacao(Year.of(2005));
        livro.setQuantidadeDisponivel(100);
        
        System.out.println(">> " + livro);
        livro.realizarEmprestimo();
        System.out.println(">> Quantidade Disponivel: " + livro.getQuantidadeDisponivel());
        livro.devolverLivro();
        System.out.println(">> Quantidade Disponivel: " + 
                livro.getQuantidadeDisponivel());
        System.out.println(">> Disponibilidade: " + 
                livro.verificarDisponibilidade());
    }
    
}
