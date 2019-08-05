package com.visa.training.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductDAO {

	public Product findById(int id) {
		Product p = null;
		try (Connection c = JdbcUtil.getConnection()) {
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("select * from product where product_id=" + id);
			
			if (rs.next()) {
				p = mapRow(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	private Product mapRow(ResultSet rs) throws SQLException {
		Product p = new Product();
		p.setId(rs.getInt("product_id"));
		p.setName(rs.getString("product_name"));
		p.setPrice(rs.getFloat("product_price"));
		p.setQoh(rs.getInt("product_qoh"));
		return p;
	}

	public List<Product> findAll() {
		List<Product> prodList = new ArrayList<>();
		Product p = null;
		try (Connection c = JdbcUtil.getConnection()) {
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("select * from product");
			while (rs.next()) {
				p = mapRow(rs);
				prodList.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return prodList;
	}

	public Product save(Product toBeSaved) {
		try (Connection c = JdbcUtil.getConnection()) {
			PreparedStatement pstmt = c.prepareStatement("insert into product (product_name,product_price,product_qoh) values(?,?,?)", 
					Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1,  toBeSaved.getName());
			pstmt.setFloat(2, toBeSaved.getPrice());
			pstmt.setInt(3,  toBeSaved.getQoh());
			pstmt.executeUpdate();
			
			// for auto-generated keys
			ResultSet keys = pstmt.getGeneratedKeys();
			keys.next();
			toBeSaved.setId(keys.getInt(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toBeSaved;
	}

}
