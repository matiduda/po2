import java.util.ArrayList;

public class Category {
	
	ArrayList<String> productList;
	String categoryName;

	Category(String name) {
		this.categoryName = name;
		this.productList = new ArrayList<String>();
	}

	boolean add(String product) {
		return this.productList.add(product);
	}

	boolean remove(String product) {
		return this.productList.remove(product);
	}

}