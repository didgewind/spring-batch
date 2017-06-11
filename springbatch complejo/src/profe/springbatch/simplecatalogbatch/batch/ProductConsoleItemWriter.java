package profe.springbatch.simplecatalogbatch.batch;
/**
 * 
 */


import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;

import profe.springbatch.simplecatalogbatch.model.Product;

/**
 * @author acogoluegnes
 *
 */
public class ProductConsoleItemWriter implements ItemWriter<Product> {
	

	/* (non-Javadoc)
	 * @see org.springframework.batch.item.ItemWriter#write(java.util.List)
	 */
	public void write(List<? extends Product> items) throws Exception {
		for(Product item : items) {
			System.out.println(item);						
		}
	}

}
