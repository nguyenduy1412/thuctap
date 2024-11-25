package com.thuctap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thuctap.models.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
	List<Orders> findByUserId(Integer id);

	List<Orders> findAllByOrderByIdDesc();
	List<Orders> findByStatusOrderByIdDesc(Integer status);
	List<Orders> findByUserIdOrderByIdDesc(long id);

	List<Orders> findByStatusAndUserIdOrderByIdDesc(Integer status, long userId);

	@Query("SELECT o FROM Orders o WHERE FUNCTION('YEAR', o.dateOrder) = :year AND FUNCTION('MONTH', o.dateOrder) = :month")
	List<Orders> findByMonthAndYear(@Param("month") int month, @Param("year") int year);
	@Query("SELECT o FROM Orders o WHERE FUNCTION('YEAR', o.dateOrder) = :year AND FUNCTION('MONTH', o.dateOrder) = :month AND FUNCTION('DAY', o.dateOrder) = :day ORDER BY o.id DESC")
    List<Orders> findByDayMonthAndYear(@Param("day") int day, @Param("month") int month, @Param("year") int year);
	@Query("SELECT o FROM Orders o WHERE FUNCTION('YEAR', o.dateOrder) = :year AND FUNCTION('MONTH', o.dateOrder) = :month AND FUNCTION('DAY', o.dateOrder) = :day AND o.status = :status ORDER BY o.id DESC")
    List<Orders> findByDayMonthYearAndStatus(@Param("day") int day, @Param("month") int month, @Param("year") int year, @Param("status") int status);
}
