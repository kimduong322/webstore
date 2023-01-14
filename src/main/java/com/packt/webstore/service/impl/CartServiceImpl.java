package com.packt.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Cart;
import com.packt.webstore.domain.repository.CartRepository;
import com.packt.webstore.dto.CartDto;
import com.packt.webstore.exception.InvalidCartException;
import com.packt.webstore.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public void create(CartDto cartDto) {
		cartRepository.create(cartDto);
	}

	@Override
	public Cart read(String CartId) {
		return cartRepository.read(CartId);
	}

	@Override
	public void update(String cartId, CartDto cartDto) {
		cartRepository.update(cartId, cartDto);
	}

	@Override
	public void delete(String id) {
		cartRepository.delete(id);
	}

	@Override
	public void addItem(String cartId, String productId) {
		cartRepository.addItem(cartId, productId);
	}

	@Override
	public void removeItem(String cartId, String productId) {
		cartRepository.removeItem(cartId, productId);
	}

	@Override
	public Cart validate(String cartId) {
		Cart cart = cartRepository.read(cartId);
		if(cart == null || cart.getCartItems().size() == 0) {
			throw new InvalidCartException(cartId);
		}
		return cart;
	}

	@Override
	public void clearCart(String cartId) {
		cartRepository.clearCart(cartId);
	}

}
