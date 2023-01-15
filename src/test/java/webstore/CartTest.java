package webstore;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import com.packt.webstore.domain.Cart;
import com.packt.webstore.domain.CartItem;
import com.packt.webstore.domain.Product;

public class CartTest {
	
	private Cart cart;
	
	@Before
	public void setup() {
		cart = new Cart("1");
	}
	
	@Test
	public void cart_total_grand_must_be_equal_cart_item_total_price_in_case_of_single_cart_item_with_single_quantity() {
		// Arrange
		CartItem cartItem = new CartItem("A");
		Product product = new Product("P1234", "iPhone 5S", new BigDecimal(500));
		cartItem.setProduct(product);
		cart.setCartItems(new ArrayList<CartItem>() {
			{
				add(cartItem);
			}
		});
		
		// Act
		BigDecimal grandTotal = cart.getGrandTotal();
		
		// Assert
		Assert.assertEquals(cartItem.getTotalPrice(), grandTotal);
	}
}
