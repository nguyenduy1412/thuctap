package com.thuctap.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(columnDefinition = "nvarchar(255)")
	private String productName;
	private Double priceEnter;
	private Double price;
	private Double priceSale;
	private String image;
	private Double star;
	private Integer sale;
	private Integer profit;
	@Column(columnDefinition = "nvarchar(4000)")
	private String description;
	private Boolean status;
	@ManyToOne(fetch = FetchType.EAGER)
	
	@JoinColumn(name = "categoryId", referencedColumnName = "id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Category category;
	@ManyToOne(fetch = FetchType.EAGER)
	
	@JoinColumn(name = "brandId", referencedColumnName = "id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Brand brand;
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	@JsonIgnore
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Set<ProductColor> productColors;
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	@JsonIgnore 	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Set<ProductSize> productSizes;
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	@JsonIgnore
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Set<DetailProductImg> detailProductImgs;
}
