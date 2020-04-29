package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutosUsados extends Produto{
	private Date dataFabricacao;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public ProdutosUsados() {
	}

	public ProdutosUsados(String nome, Double preco, Date dataFabricacao) {
		super(nome, preco);
		this.dataFabricacao = dataFabricacao;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	
	@Override
	public String tagPreco() {
		return super.getNome() + " (usado) R$ " + super.getPreco() + " (Data da fabricação: " + sdf.format(dataFabricacao) + ")";	
	}
}
