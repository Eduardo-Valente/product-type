package model.entities;

public class Product {
		
		protected String name;
		protected Float price;
		
		public Product() {}
		
		public Product(String name, Float price) {
			this.name = name;
			this.price = price;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Float getPrice() {
			return price;
		}

		public void setPrice(Float price) {
			this.price = price;
		}	
		
		public String priceTag()
		{
			return name + " $ " + String.format("%,.2f", price);
		}
}
