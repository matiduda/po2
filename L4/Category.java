import java.util.ArrayList;

public class Category {
	
	ArrayList<String> productList;
	String categoryName;

	Category(String name) {
		this.categoryName = name;
		this.productList = new ArrayList<String>();
	}

	void add(String product) {
		this.productList.add(product);
	}

}