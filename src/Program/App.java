package Program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Produto;
import entities.ProdutosImportados;
import entities.ProdutosUsados;

public class App {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Produto> produtos = new ArrayList<>();

		System.out.print("Digite a quantidade de produtos: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("------------------------------------------");
			System.out.println("Produto #" + i + ":");
			System.out.print("Comum(c)/Usado(u)/Importado(i): ");
			char ch = sc.next().charAt(0);
			System.out.print("Nome do produto: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Preço: R$");
			Double preco = sc.nextDouble();

			if (ch == 'c') {
				produtos.add(new Produto(nome, preco));
			}

			else if (ch == 'i') {
				System.out.print("Insira a taxa alfândegária: R$");
				Double taxa = sc.nextDouble();
				produtos.add(new ProdutosImportados(nome, preco, taxa));
			}

			else {
				System.out.print("Data de fabricação: (DD/MM/YYYY): ");
				Date data = sdf.parse(sc.next());
				produtos.add(new ProdutosUsados(nome, preco, data));
			}
		}
		
		System.out.println();
		System.out.println("----------------------- Etiquetas de preço -----------------------");
		
		for (Produto y : produtos) {
			System.out.println(y.tagPreco());
		}
		
		sc.close();
	}
}
