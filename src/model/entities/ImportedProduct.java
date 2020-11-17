package model.entities;

public class ImportedProduct extends Product {

		private Float customsFee;

		public ImportedProduct() {
			super();
		}
		
		public ImportedProduct(String name, Float price, Float customsFee) {
			super(name, price);
			this.customsFee = customsFee;
		}

		public Float getCustomsFee() {
			return customsFee;
		}

		public void setCustomsFee(Float customsFee) {
			this.customsFee = customsFee;
		}
		
		@Override
		public String priceTag()
		{
		   return getName() + " $ " + String.format("%,.2f", totalPrice() ) + 
				  " (Customs fee: $ " + String.format("%,.2f", this.customsFee) + ")"; 
		}
		
		public Float totalPrice()
		{
			return getPrice() + this.customsFee;
		}
}
