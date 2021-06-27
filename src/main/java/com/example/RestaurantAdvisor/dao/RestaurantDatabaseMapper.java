package com.example.RestaurantAdvisor.dao;

import java.util.List;

import com.example.RestaurantAdvisor.domain.Customer;
import com.example.RestaurantAdvisor.domain.Restaurant;
import com.example.RestaurantAdvisor.domain.Order;
import com.example.RestaurantAdvisor.domain.OrderItem;
import com.example.RestaurantAdvisor.domain.Menu;
import com.example.RestaurantAdvisor.domain.Review;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.jdbc.Null;

@Mapper
public interface RestaurantDatabaseMapper {

	// CUSTOMER
	@Select("SELECT EMAIL, FNAME, LNAME, PHONE, STREETNO, STREETNAME, CITY, STATE, ZIP, PASSWORD FROM RESTAURANT_CUSTOMER")
	List<Customer> getCustomers();

	@Insert("INSERT INTO RESTAURANT_CUSTOMER (EMAIL, FNAME, LNAME, PASSWORD) VALUES(#{email}, #{fName}, #{lName}, #{password})")
	void addCustomer(Customer customer);

	@Update("UPDATE RESTAURANT_CUSTOMER SET FNAME=#{fName}, LNAME=#{lName}, PASSWORD=#{password} WHERE EMAIL = #{email}")
	void updateCustomer(Customer customer);

	@Update("UPDATE RESTAURANT_CUSTOMER SET PHONE = #{phone} WHERE EMAIL = #{email}")
	void updateCustPhone(Customer customer);
	
	@Update("UPDATE RESTAURANT_CUSTOMER SET STREETNO=#{streetNo}, STREETNAME=#{streetName}, CITY=#{city}, STATE=#{state}, ZIP=#{zip} WHERE EMAIL = #{email}")
	void updateCustAddress(Customer customer);

	// RESTAURANT
	@Select("SELECT RESTID, RNAME, PHONE, EMAIL, HOURS, DININGTYPE, STREETNO, STREETNAME, CITY, STATE, ZIP, PRICERANGE, DELIVERYFLAG, OUTDOORSEATINGFLAG FROM RESTAURANT")
	List<Restaurant> getRestaurants();

	// ORDER
	@Select("SELECT ONO, ORDERDATE FROM RESTAURANT_ORDER WHERE CUSTEMAIL = #{email}")
	List<Order> getOrders(Customer customer);

	@Insert("INSERT INTO RESTAURANT_ORDER (ONO, ORDERDATE, CUSTEMAIL, ORDERDINEINFLAG, ORDERDELIVERYFLAG, ORDERPICKUPFLAG) VALUES(#{ono}, #{orderDate}, #{custEmail}, #{dineIn}, #{delivery}, #{pickUp})")
	void addOrder(Order order);

	@Select("SELECT MAX(ONO) FROM RESTAURANT_ORDER")
	String lastOrder();

	// ORDER DETAILS
	@Insert("INSERT INTO RESTAURANT_ODETAILS (ONO, FOODNAME, RESTID, QTY) VALUES(#{ono}, #{foodName}, #{restID}, #{qty})")
	void addDetails(OrderItem orderItem);

	@Select("SELECT FOODNAME, RESTID, QTY FROM RESTAURANT_ODETAILS WHERE ONO = #{ono}")
	List<OrderItem> getDetails(Order order);

	// MENU
	@Select("SELECT FOODNAME, PRICE FROM MENU WHERE RESTID = #{restID}")
	List<Menu> getMenu(Restaurant restaurant);

	// REVIEW
	@Insert("INSERT INTO CUST_REVIEW VALUES(#{reviewID}, #{custEmail}, #{restID}, #{reviewTitle}, #{reviewDescr}, #{reviewDate}, #{rating})")
	void addReview(Review review);

	@Select("SELECT REVIEWTITLE, REVIEWDESCR, CUSTEMAIL, REVIEWDATE, RATING FROM CUST_REVIEW WHERE RESTID = #{restID}")
	List<Review> getReviewsRest(Restaurant restaurant);

	@Select("SELECT REVIEWTITLE, REVIEWDESCR, RESTID, REVIEWDATE, RATING FROM CUST_REVIEW WHERE CUSTEMAIL = #{email}")
	List<Review> getReviewsCust(Customer customer);
}