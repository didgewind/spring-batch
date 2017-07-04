package profe.springbatch.simplecatalogbatch.batch;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import profe.springbatch.simplecatalogbatch.model.Product;

public class ProductRowMapper implements RowMapper<Product> {

	public Product mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		Product product = new Product();
		product.setId(rs.getString("id"));
		product.setName(rs.getString("name"));
		product.setDescription(rs.getString("description"));
		product.setPrice(rs.getBigDecimal("price"));
		return product;
	}
}
