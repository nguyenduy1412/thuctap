package com.thuctap.models;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Column;
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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="detailProductImg")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailProductImg {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(columnDefinition = "nvarchar(255)")
	private String image;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="productId",referencedColumnName = "id")
	@JsonIgnore
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Product product;
}
