package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {
			
			private Date manufacturedDate;
			private final SimpleDateFormat sdf = new SimpleDateFormat("DD/mm/yyyy");

			public UsedProduct(Date manufacturedDate) {
				super();
				this.manufacturedDate = manufacturedDate;
			}

			public UsedProduct(String name, Float price, Date manufacturedDate) {
				super(name, price);
				this.manufacturedDate = manufacturedDate;
			}

			public Date getManufacturedDate() {
				return manufacturedDate;
			}

			public void setManufacturedDate(Date manufacturedDate) {
				this.manufacturedDate = manufacturedDate;
			}
			
			@Override
			public String priceTag()
			{
				return this.name + " (used)" + " $ " + String.format("%,.2f", this.price) 
					  	  + " (Manufacture date: " + sdf.format(this.manufacturedDate) + ")";
			}
}
