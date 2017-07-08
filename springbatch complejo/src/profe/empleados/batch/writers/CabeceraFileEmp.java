package profe.empleados.batch.writers;

import java.io.IOException;
import java.io.Writer;

import org.springframework.batch.item.file.FlatFileHeaderCallback;

public class CabeceraFileEmp implements FlatFileHeaderCallback {

	@Override
	public void writeHeader(Writer writer) throws IOException {
		writer.write("Cabecera de empleados\n");
		writer.write("---------------------");
		writer.flush();
	}

}
