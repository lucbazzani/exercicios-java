package entities;

public class ImportedProduct extends Product {

	// TAXA DE ALFÂNDEGA
	public Double customsFee;
	
	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}

	public Double totalPrice() {
		return getCustomsFee() + getPrice();
	}
	
	@Override
	public String priceTag() {
		return getName() 
				+ " $ " 
				+ String.format("%.2f", totalPrice()) 
				+ " (Customs fee: $ " 
				+ String.format("%.2f", getCustomsFee())
				+ ")";
	}
}
