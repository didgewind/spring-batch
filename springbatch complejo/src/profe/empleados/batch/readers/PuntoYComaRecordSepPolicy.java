package profe.empleados.batch.readers;

import org.springframework.batch.item.file.separator.RecordSeparatorPolicy;

public class PuntoYComaRecordSepPolicy implements RecordSeparatorPolicy {

	@Override
	public boolean isEndOfRecord(String record) {
		return (record.indexOf(';') != - 1 ? true : false);
	}

	@Override
	public String postProcess(String record) {
		return record.substring(0, record.length() - 1);
	}

	@Override
	public String preProcess(String record) {
		return record;
	}

}
