package com.shop.management.shoplink.Repository;

import com.shop.management.shoplink.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Product Repository
 *
 * @author LongPM
 * @version 1.0
 * @since 2025-04-24
 */
public interface ProductRepository extends JpaRepository<Product, Long> {}
