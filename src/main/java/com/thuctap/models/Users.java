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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "Tên đăng nhập được không rỗng")
	@Column(columnDefinition = "nvarchar(255)",unique = true)
	private String userName;
	@Size(min = 6, message = "Mật khẩu có ít nhất 6 kí tự")
	@Column(columnDefinition = "nvarchar(255)")
	private String passWord;
	@Column(columnDefinition = "nvarchar(255)")
	private String address;
	@Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$", message = "Số điện thoại không đúng định dạng")
	private String phone;
	@Column(columnDefinition = "Date")
	private Date birthday;
	private Integer gender;
	private String img;
	private String codeOtp;
	private String email;
	@Column(columnDefinition = "nvarchar(255)")
	private String fullName;
	private Boolean enabled;
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<UserRole> userRoles;
	@OneToMany(mappedBy = "users", fetch = FetchType.EAGER)
	@JsonIgnore
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Set<AddressOrder> addressOrders;
}
