package com.shop.management.shoplink.Service.impl;

import com.shop.management.shoplink.Entity.Product;
import com.shop.management.shoplink.Repository.ProductRepository;
import com.shop.management.shoplink.Service.IProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Product Service Impl
 *
 * @author LongPM
 * @version 1.0
 * @since 2025-04-24
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	private final ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		logger.info("Fetching all products");
		return productRepository.findAll();
	}

	@Override
	@Transactional
	public Product addProduct(Product product) {
		logger.info("Adding product: {}", product.getName());
		return productRepository.save(product);
	}

	@Override
	@Transactional
	public void updateProduct(Product product) {
		if (!productRepository.existsById(product.getId())) {
			throw new RuntimeException("Product not found");
		}
		logger.info("Update product: {}", product.getName());
		productRepository.save(product);
	}

	@Override
	public Product getProduct(Long id) {
		logger.info("Fetching product with id: {}", id);
		return productRepository.findById(id).orElseThrow(() -> {
			logger.error("Product not found with id: {}", id);
			return new RuntimeException("Product not found");
		});
	}

	@Override
	@Transactional
	public void deleteProduct(Long id) {
		logger.info("Deleting product with id: {}", id);
		productRepository.deleteById(id);
	}
}
