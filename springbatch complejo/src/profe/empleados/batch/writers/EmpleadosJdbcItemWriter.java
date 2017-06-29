package profe.empleados.batch.writers;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;

import profe.empleados.model.Empleado;

public class EmpleadosJdbcItemWriter implements ItemWriter<Empleado> {

	private interface ConstantesSQL {
		
		String INSERTA_EMPLEADO = 
				"INSERT INTO empleados (cif, nombre, apellidos, edad) VALUES(?,?,?,?)";
		
		String MODIFICA_EMPLEADO = 
				"UPDATE empleados SET nombre=?, apellidos=?, edad=? "
				+ "WHERE cif=?";
		
	}
	
	private JdbcTemplate jdbcTemplate;
	
	public EmpleadosJdbcItemWriter(DataSource ds) {
		jdbcTemplate = new JdbcTemplate(ds);
	}
	
	@Override
	public void write(List<? extends Empleado> empleados) throws Exception {
		for (Empleado empleado : empleados) {
			int updated = jdbcTemplate.update(ConstantesSQL.MODIFICA_EMPLEADO,
					empleado.getNombre(), empleado.getApellidos(), 
					empleado.getEdad(), empleado.getCif());
			if (updated==0) {
				jdbcTemplate.update(ConstantesSQL.INSERTA_EMPLEADO,
						empleado.getCif(),
						empleado.getNombre(), empleado.getApellidos(), 
						empleado.getEdad());
				System.out.println("Empleado insertado");
			} else {
				System.out.println("Empleado actualizado");

			}
		}
		
	}

}
