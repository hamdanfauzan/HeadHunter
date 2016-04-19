package com.coba.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.coba.model.Customer;

public interface CustomerMapper {
	final String update = "UPDATE CUSTOMER SET nik = #{nik}, first_name = #{firstname},last_name = #{lastname},"
			+ "username = #{username}, password = #{password}, address "
			+ "= #{address}, no_telp = #{noTelp}, email = #{email}, dob = #{dob}, employee_id = #{employeeId}"
			+ "WHERE nik = #{nik}";
	
	final String updatePass = "update customer set password = #{username}||(select to_char(dob, 'ddmm') from customer where username = #{username}) where username = #{username}";
	
	final String deactiveCust = "update customer set status = 'deactive' where username = #{username}";

	final String insert = "insert into customer (nik, first_name, last_name, "
			+ "username, password, no_telp, address, email, dob, employee_id) "
			+ "values (#{nik} , #{firstname},#{lastname},"
			+ "#{username}, #{password}, #{noTelp}, #{address}, #{email}, #{dob}, #{employeeId})";

	@Insert(insert)
	void insert(Customer customer);

	///////////////////////////////////////////////////

	@Select("select * from customer where nik = #{nik}")
	@Results(value = { @Result(property = "nik", column = "nik"),
			@Result(property = "firstname", column = "FIRST_NAME"),
			@Result(property = "lastname", column = "LAST_NAME"), @Result(property = "username", column = "USERNAME"),
			@Result(property = "password", column = "PASSWORD"), @Result(property = "dob", column = "DOB"),
			@Result(property = "address", column = "ADDRESS"), @Result(property = "email", column = "EMAIL"),
			@Result(property = "noTelp", column = "NO_TELP"), @Result(property = "status", column = "STATUS"),
			@Result(property = "employeeId", column = "EMPLOYEE_ID") })

	Customer selectByNik(String nik);
	
	@Select("select * from customer where username = #{username}")
	@Results(value = { @Result(property = "nik", column = "nik"),
			@Result(property = "firstname", column = "FIRST_NAME"),
			@Result(property = "lastname", column = "LAST_NAME"), @Result(property = "username", column = "USERNAME"),
			@Result(property = "password", column = "PASSWORD"), @Result(property = "dob", column = "DOB"),
			@Result(property = "address", column = "ADDRESS"), @Result(property = "email", column = "EMAIL"),
			@Result(property = "noTelp", column = "NO_TELP"), @Result(property = "status", column = "STATUS"),
			@Result(property = "employeeId", column = "EMPLOYEE_ID") })

	Customer selectByUserName(String username);

	//////////////////////////////////////////////////
	@Update(update)
	void updateById(Customer customer);

	@Delete("DELETE from customer WHERE nik = #{id}")
	void deleteById(int id);

	//////////////////////////////////////////////////
	@Select("select * from customer")
	@Results(value = { @Result(property = "nik", column = "nik"),
			@Result(property = "firstname", column = "FIRST_NAME"),
			@Result(property = "lastname", column = "LAST_NAME"), @Result(property = "username", column = "USERNAME"),
			@Result(property = "password", column = "PASSWORD"), @Result(property = "dob", column = "DOB"),
			@Result(property = "address", column = "ADDRESS"), @Result(property = "email", column = "EMAIL"),
			@Result(property = "noTelp", column = "NO_TELP"), @Result(property = "status", column = "STATUS"),
			@Result(property = "employeeId", column = "EMPLOYEE_ID") })

	List<Customer> selectAllCustomer();
	
	/////////////////////////////////////////////////
	//=== Get customer from username for log in ===//
	
	@Select("SELECT * from customer WHERE username = #{username}")
	@Results(value = { @Result(property = "nik", column = "nik"),
			@Result(property = "firstname", column = "FIRST_NAME"),
			@Result(property = "lastname", column = "LAST_NAME"), @Result(property = "username", column = "USERNAME"),
			@Result(property = "password", column = "PASSWORD"), @Result(property = "dob", column = "DOB"),
			@Result(property = "address", column = "ADDRESS"), @Result(property = "email", column = "EMAIL"),
			@Result(property = "noTelp", column = "NO_TELP"), @Result(property = "status", column = "STATUS"),
			@Result(property = "employeeId", column = "EMPLOYEE_ID") })
	
	
	public Customer getCustomerByUserName(String username);
	
	@Update(updatePass)
	void updatePass(String username);
	
	@Update(deactiveCust)
	void deactiveCust(String username);
	
}
