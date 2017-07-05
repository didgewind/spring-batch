package profe.empleados.batch.readers;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.JsonLineMapper;
import org.springframework.beans.factory.annotation.Autowired;

import profe.empleados.model.Empleado;

public class JSONWrapperEmpMapper implements LineMapper<Empleado> {

	@Autowired
	private JsonLineMapper jsonLineMapper;
	
	@Override
	public Empleado mapLine(String line, int numLine) throws Exception {
		Map<String, Object> empleadoAsMap = jsonLineMapper.mapLine(line, numLine);
		Empleado empleado = new Empleado();
		empleado.setCif((String) empleadoAsMap.get("cif"));
		empleado.setNombre((String) empleadoAsMap.get("nombre"));
		empleado.setApellidos((String) empleadoAsMap.get("apellidos"));
		empleado.setEdad((Integer) empleadoAsMap.get("edad"));
		
		return empleado;
	}

}
