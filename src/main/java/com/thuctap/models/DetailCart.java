package com.thuctap.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "detail_cart")
public class DetailCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cartId",referencedColumnName = "id")
//	@JsonIgnore
	private Cart cart;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="productId",referencedColumnName = "id")
//	@JsonIgnore
	private Product product;
	private Integer quantity;
	private String size;
	private String color;
	
}