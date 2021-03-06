package profe.springbatch.simplecatalogbatch.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TestSCBatch {

	@Autowired
	private JobLauncher jobLauncher;
	
	@Resource(name="importProductsWithDiscount")
	private Job job;
	
	public static void main(String[] args) throws Exception {
		ApplicationContext context =
				new ClassPathXmlApplicationContext(new String[] {"job-context.xml"});
		TestSCBatch test = (TestSCBatch) context.getBean("testSCBatch");
		test.go();
	}

	private void go() throws Exception {
		jobLauncher.run(job, new JobParametersBuilder()
				.addString("targetDirectory", "./data/target/")
				.addString("targetFile", "products.txt")
				.addLong("timestamp", System.currentTimeMillis())
				.toJobParameters()
			);
	}

}


