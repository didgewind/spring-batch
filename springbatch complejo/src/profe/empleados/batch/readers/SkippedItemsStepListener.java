package profe.empleados.batch.readers;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;

public class SkippedItemsStepListener implements StepExecutionListener {

	@Override
	public void beforeStep(StepExecution stepExecution) {
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		if (!"FAILED".equals(stepExecution.getExitStatus().getExitCode()) && 
				stepExecution.getSkipCount() > 0) {
			return new ExitStatus("COMPLETED_WITH_SKIPS");
		} else if ("FAILED".equals(stepExecution.getExitStatus().getExitCode())) {
			return ExitStatus.FAILED;
		} else {
			return stepExecution.getExitStatus();
		}
	}
}