import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leitura dos nomes e sexos separados por vírgula
        System.out.print("Digite os nomes e sexos no formato 'Nome-Sexo' separados por vírgula: ");
        String input = scanner.nextLine();

        // Separação dos nomes e sexos usando o método split
        String[] pessoasArray = input.split("\\s*,\\s*");

        // Lista para armazenar objetos Pessoa
        List<Pessoa> listaPessoas = new ArrayList<>();

        // Criando objetos Pessoa e adicionando à lista
        for (String p : pessoasArray) {
            String[] partes = p.split("-");
            String nome = partes[0];
            String sexo = partes[1];
            listaPessoas.add(new Pessoa(nome, sexo));
        }

        // Ordenação alfabética dos nomes
        listaPessoas.sort((p1, p2) -> p1.getNome().compareToIgnoreCase(p2.getNome()));

        // Impressão da lista ordenada completa
        System.out.println("Lista ordenada completa:");
        for (Pessoa pessoa : listaPessoas) {
            System.out.println(pessoa.getNome() + "-" + pessoa.getSexo());
        }

        // Criação de listas separadas para masculino e feminino
        List<Pessoa> masculino = new ArrayList<>();
        List<Pessoa> feminino = new ArrayList<>();

        // Separação em grupos de masculino e feminino
        for (Pessoa pessoa : listaPessoas) {
            if (pessoa.getSexo().equalsIgnoreCase("M")) {
                masculino.add(pessoa);
            } else if (pessoa.getSexo().equalsIgnoreCase("F")) {
                feminino.add(pessoa);
            }
        }

        // Impressão dos grupos separados por sexo
        System.out.println("\nGrupo Masculino:");
        for (Pessoa pessoa : masculino) {
            System.out.println(pessoa.getNome());
        }

        System.out.println("\nGrupo Feminino:");
        for (Pessoa pessoa : feminino) {
            System.out.println(pessoa.getNome());
        }

        scanner.close();
    }
}
