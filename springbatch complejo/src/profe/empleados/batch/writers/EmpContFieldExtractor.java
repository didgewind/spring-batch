package profe.empleados.batch.writers;

import org.springframework.batch.item.file.transform.FieldExtractor;

import profe.empleados.model.Empleado;

public class EmpContFieldExtractor implements FieldExtractor<Empleado> {

	private int contador;
	@Override
	public Object[] extract(Empleado emp) {
		contador++;
		Object[] aReturn = { "Empleado " + contador, emp.getCif(), emp.getNombre(), emp.getApellidos(),
				emp.getEdad(), "Fin Empleado " + contador};
		return aReturn;
	}

}
