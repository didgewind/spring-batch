package profe.springbatch.simplecatalogbatch.batch;

import org.springframework.batch.core.listener.SkipListenerSupport;
import org.springframework.batch.item.file.FlatFileParseException;

import profe.springbatch.simplecatalogbatch.model.Product;

public class ProductsSkipListener extends SkipListenerSupport<Product, Product> {

	@Override
	public void onSkipInRead(Throwable t) {
		FlatFileParseException exception = (FlatFileParseException) t;
		System.out.println("Error de parseo en la línea " + exception.getLineNumber());
	}

	
}
