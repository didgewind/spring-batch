package profe.empleados.batch.writers;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import profe.empleados.model.Empleado;

public class EmpleadosConsoleItemWriter implements ItemWriter<Empleado> {

	@Override
	public void write(List<? extends Empleado> empleados) throws Exception {
		for (Empleado empleado : empleados) {
			System.out.println(empleado);
		}
		
	}

}
