package entities;

public class ProdutosImportados extends Produto {
	private Double taxaAlfandega;

	public ProdutosImportados() {
	}

	public ProdutosImportados(String nome, Double preco, Double taxaAlfandega) {
		super(nome, preco);
		this.taxaAlfandega = taxaAlfandega;
	}

	public Double getTaxaAlfandega() {
		return taxaAlfandega;
	}

	public void setTaxaAlfandega(Double taxaAlfandega) {
		this.taxaAlfandega = taxaAlfandega;
	}

	public Double precoTotal() {
		return super.getPreco() + taxaAlfandega;
	}

	@Override
	public String tagPreco() {
		return super.getNome() + " R$ " + String.format("%.2f", precoTotal()) + " (Taxa de alfândega: R$"
				+ getTaxaAlfandega() + ")";
	}
}
