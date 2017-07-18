package profe.empleados.batch.readers;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;

import profe.empleados.batch.model.EmpleadosJobInfo;

public class WriteInfoStepListener implements StepExecutionListener {

	@Autowired
	private EmpleadosJobInfo jobInfo;
	

	@Override
	public void beforeStep(StepExecution stepExecution) {
		/*
		 * Vamos a usar las dos primeras líneas si usamos el holder para
		 * intercambiar información, o las dos siguientes si usamos el
		 * JobExecutionContext
		 */
		System.out.println("Registros skipeados: " + jobInfo.getSkipCount());
		System.out.println(jobInfo.getInfo());
		
/*		System.out.println("Registros skipeados: " + stepExecution.getJobExecution().getExecutionContext().get("skipsCount"));
		System.out.println(stepExecution.getJobExecution().getExecutionContext().get("info"));
*/	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		return stepExecution.getExitStatus();
	}
}