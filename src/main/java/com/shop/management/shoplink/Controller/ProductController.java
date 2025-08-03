package com.shop.management.shoplink.Controller;

import com.shop.management.shoplink.Entity.Product;
import com.shop.management.shoplink.Service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Product Controller
 *
 * @author LongPM
 * @version 1.0
 * @since 2025-04-24
 */
@RestController
@RequestMapping("/products")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private IProductService productService;

	@GetMapping
	public List<Product> getAllProducts() {
		logger.info("API call: GET /api/products");
		return productService.getAllProducts();
	}

	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		logger.info("API call: POST /api/products, product: {}", product.getName());
		return productService.addProduct(product);
	}

	@GetMapping("/{id}")
	public Product getProduct(@PathVariable Long id) {
		logger.info("API call: GET /api/products/{}", id);
		return productService.getProduct(id);
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		logger.info("API call: DELETE /api/products/{}", id);
		productService.deleteProduct(id);
	}

	@GetMapping("/view")
	public String viewProducts(Model model) {
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "product/index";
	}
}
