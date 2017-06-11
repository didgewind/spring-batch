package profe.springbatch.simplecatalogbatch.test;

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
	
	@Autowired
	private Job job;
	
	public static void main(String[] args) throws Exception {
		ApplicationContext context =
				new ClassPathXmlApplicationContext(new String[] {"job-context.xml"});
		TestSCBatch test = (TestSCBatch) context.getBean("testSCBatch");
		test.go();
	}

	private void go() throws Exception {
		jobLauncher.run(job, new JobParametersBuilder()
				/*.addString("inputResource", "classpath:/input/products.zip")
				.addString("targetDirectory", "./target/importproductsbatch/")
				.addString("targetFile","products.txt")*/
				.addLong("timestamp", System.currentTimeMillis())
				.toJobParameters()
			);
	}


}
