package profe.empleados.batch.readers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import profe.empleados.model.Empleado;

public class EmpleadoRowMapper implements RowMapper<Empleado> {

	public Empleado mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		Empleado empleado = new Empleado();
		empleado.setCif(rs.getString("cif"));
		empleado.setNombre(rs.getString("nombre"));
		empleado.setApellidos(rs.getString("apellidos"));
		empleado.setEdad(rs.getInt("edad"));
		return empleado;
	}
}
