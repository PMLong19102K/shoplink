package com.shop.management.shoplink.Entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Product
 * @author LongPM
 * @version 1.0
 * @since 2025-04-24
 */
@Entity
@Data
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product")
	@SequenceGenerator(name = "seq_product", sequenceName = "seq_product", allocationSize = 1)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "category")
	private String category;

	@Column(name = "price")
	private Double price;

	@Column(name = "unit")
	private String unit;

	@Column(name = "description")
	private String description;

	@Column(name = "link_product", nullable = false)
	private String linkProduct;

	@Column(name = "link_image_product", nullable = false)
	private String linkImageProduct;
}
