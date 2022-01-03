package task.matrix;

public class ValidationResult {
	private boolean status = false;
	private String errorMessage;

	public boolean isValid() {
		return status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
