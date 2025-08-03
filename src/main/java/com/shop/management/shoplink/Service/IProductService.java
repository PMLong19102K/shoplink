package com.shop.management.shoplink.Service;

import com.shop.management.shoplink.Entity.Product;

import java.util.List;

/**
 * Product Service
 *
 * @author LongPM
 * @version 1.0
 * @since 2025-04-24
 */
public interface IProductService {
	public List<Product> getAllProducts();
	public Product addProduct(Product product);
	public void updateProduct(Product product);
	public Product getProduct(Long id);
	public void deleteProduct(Long id);
}
