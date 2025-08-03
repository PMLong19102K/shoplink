package com.shop.management.shoplink.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_post")
	@SequenceGenerator(name = "seq_post", sequenceName = "seq_post", allocationSize = 1)
	private Long id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "content")
	private String content;

	@Column(name = "price")
	private Double price;

	@Column(name = "tags")
	private String tags;

	@Column(name = "slug")
	private String slug;

	@Column(name = "publish_date", nullable = false)
	private LocalDateTime publishDate;
}
