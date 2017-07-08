package profe.empleados.batch.processors;

import java.math.BigDecimal;

import org.springframework.batch.item.ItemProcessor;

import profe.empleados.model.Empleado;
import profe.springbatch.simplecatalogbatch.model.Product;

public class EmpleadosProductosItemProcessor implements ItemProcessor<Empleado, Product> {

	@Override
	public Product process(Empleado emp) throws Exception {
		return new Product(emp.getCif(), emp.getNombre(), emp.getApellidos(), new BigDecimal(emp.getEdad()));
	}

}
