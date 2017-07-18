package profe.empleados.batch.readers;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;

import profe.empleados.batch.model.EmpleadosJobInfo;

public class SkippedItemsStepListener implements StepExecutionListener {

	@Autowired
	private EmpleadosJobInfo jobInfo;
	
	@Override
	public void beforeStep(StepExecution stepExecution) {
	}

	@Override
	/*
	 * Vamos a usar las líneas que acceden al jobInfo si usamos el holder para
	 * intercambiar información, o las que están comentadas si usamos el
	 * JobExecutionContext
	 */

	public ExitStatus afterStep(StepExecution stepExecution) {
		jobInfo.setSkipCount(stepExecution.getSkipCount());
//		stepExecution.getJobExecution().getExecutionContext().put("skipsCount", stepExecution.getSkipCount());
		if (!"FAILED".equals(stepExecution.getExitStatus().getExitCode()) && 
				stepExecution.getSkipCount() > 0) {
			jobInfo.setInfo("El primer paso se completó con skips, por lo que se han ejecutado 3 pasos en total");
/*			stepExecution.getJobExecution().getExecutionContext().put("info", 
						"El primer paso se completó con skips, por lo que se han ejecutado 3 pasos en total");*/
			return new ExitStatus("COMPLETED_WITH_SKIPS");
		} else if ("FAILED".equals(stepExecution.getExitStatus().getExitCode())) {
			jobInfo.setInfo("El primer paso abortó, por lo que se han ejecutado 2 pasos en total");
			/*stepExecution.getJobExecution().getExecutionContext().put("info", 
					"El primer paso abortó, por lo que se han ejecutado 2 pasos en total");*/
			return ExitStatus.FAILED;
		} else {
			jobInfo.setInfo("El primer paso completó sin skips, por lo que se han ejecutado todos los pasos");
			/*stepExecution.getJobExecution().getExecutionContext().put("info", 
					"El primer paso completó sin skips, por lo que se han ejecutado todos los pasos");*/
			return stepExecution.getExitStatus();
		}
	}
}