package profe.empleados.negocio;

import java.math.BigDecimal;

import profe.empleados.model.Empleado;
import profe.springbatch.simplecatalogbatch.model.Product;

public class TransformEmpleadoEnProducto {

	public Product transforma(Empleado emp) throws Exception {
		return new Product(emp.getCif(), emp.getNombre(), emp.getApellidos(), new BigDecimal(emp.getEdad()));
	}

}
