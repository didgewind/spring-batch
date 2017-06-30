package profe.springbatch.simplecatalogbatch.batch;

import org.springframework.batch.item.file.separator.RecordSeparatorPolicy;

/**
 * Detecta que se ha completado un registro contando las comas
 * (al llegar a 3)
 * @author made
 *
 */
public class ProdTwoLinesSeparatorPolicy implements RecordSeparatorPolicy {

	@Override
	public boolean isEndOfRecord(String record) {
		return this.getCommaCount(record) == 3;
	}

	@Override
	public String postProcess(String record) {
		return record;
	}

	@Override
	public String preProcess(String record) {
		return record;
	}

	private int getCommaCount(String s) {
		String tmp = s;
		int index = -1;
		int count = 0;
		while ((index = tmp.indexOf(",")) != -1) {
			tmp = tmp.substring(index + 1);
			count++;
		}
		return count;
	}
}
