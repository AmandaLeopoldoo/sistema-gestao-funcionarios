package aplication;

import entities.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        List<Funcionario> listaDeFuncionarios = new ArrayList<>();

        System.out.print("Quantos funcionários serão registrados? ");
        int n = sc.nextInt();

        for (int i=0; i<n;i++){
            System.out.println("Funcionário #" + (i + 1));
            System.out.print("Id: ");
            int id = sc.nextInt();

            // Verificar se o ID já existe
            boolean idExistente = listaDeFuncionarios.stream().anyMatch(func -> func.getId() == id);

            if (idExistente){
                System.out.println("Este ID já está sendo utilizado!");
                i--; // Permite que o usuário tente novamente
                continue;
            }

            System.out.print("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Salário: ");
            double salario = sc.nextDouble();

            listaDeFuncionarios.add(new Funcionario(id, nome, salario));
        }

        System.out.print("\nDigite o id do funcionário que receberá aumento salarial: ");
        int idEscolhido = sc.nextInt();

        Funcionario escolhido = listaDeFuncionarios.stream().filter(x -> x.getId() == idEscolhido).findFirst().orElse(null);
        if (escolhido == null){
            System.out.println("Esse Id não existe!");
        } else {
            System.out.print("Digite a porcentagem: ");
            double porcentagem = sc.nextDouble();
            escolhido.aumentoSalario(porcentagem);
        }

        System.out.println("\nLista de funcionários: ");
        for (Funcionario funcionarios:listaDeFuncionarios) {
            System.out.println(funcionarios);
        }
        sc.close();
    }
}
