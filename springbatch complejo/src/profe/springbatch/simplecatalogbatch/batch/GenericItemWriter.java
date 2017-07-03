package profe.springbatch.simplecatalogbatch.batch;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.batch.item.ItemWriter;

import profe.empleados.model.Empleado;
import profe.springbatch.simplecatalogbatch.model.Item;
import profe.springbatch.simplecatalogbatch.model.Product;

public class GenericItemWriter implements ItemWriter<Item> {

	@Resource(name="empleadosJdbcItemWriter")
	private ItemWriter<Empleado> empleadosJdbcItemWriter;
	
	@Resource(name="productsJdbcWriter")
	private ItemWriter<Product> productsJdbcItemWriter;
	
	@Override
	public void write(List<? extends Item> items) throws Exception {
		List<Product> lProducts = new ArrayList<Product>();
		List<Empleado> lEmpleados = new ArrayList<Empleado>();
		for (Item item : items) {
			if (item instanceof Product) {
				lProducts.add((Product) item);
			} else {
				lEmpleados.add((Empleado) item);
			}
		}
		productsJdbcItemWriter.write(lProducts);
		empleadosJdbcItemWriter.write(lEmpleados);
	}

}
