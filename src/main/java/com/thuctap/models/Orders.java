package com.thuctap.models;

import java.util.Date;
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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double sumMoney;
	private Integer status;
	private Boolean statusPay;
	private Date dateOrder;
	
	private String phone;
	@Column(columnDefinition = "nvarchar(255)")
	private String note;
	
	@OneToMany(mappedBy = "orders", fetch = FetchType.EAGER)
	
	private Set<OrderDetail> orderDetails;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId",referencedColumnName = "id")
	@JsonIgnore
	private Users user;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "payId",referencedColumnName = "id")
	@JsonIgnore
	private MethodPay methodPay;
	@OneToMany(mappedBy = "orders", fetch = FetchType.EAGER)
	@JsonIgnore
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Set<AddressOrder> addressOrders;
}
