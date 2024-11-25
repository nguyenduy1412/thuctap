package com.thuctap.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "addressOrder")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(columnDefinition = "nvarchar(255)")
	private String firstName;
	@Column(columnDefinition = "nvarchar(255)")
	private String lastName;
	private String email;
	@Column(columnDefinition = "nvarchar(255)")
	private String address;
	@Column(columnDefinition = "nvarchar(255)")
	private String city;
	@Column(columnDefinition = "nvarchar(255)")
	private String country;
	private String codeZip;
	private String phone;
	@ManyToOne(fetch = FetchType.EAGER)

	@JoinColumn(name = "orderId", referencedColumnName = "id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Orders orders;
	@ManyToOne(fetch = FetchType.EAGER)

	@JoinColumn(name = "userId", referencedColumnName = "id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Users users;
}
