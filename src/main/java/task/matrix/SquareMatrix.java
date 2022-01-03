package task.matrix;

public abstract class SquareMatrix implements IMatrix, ISquareMatrix {
	private int size;
	private static final int minSize = 1, maxSize = 10000;

	@Override
	public void setSize(int size) throws IllegalArgumentException {
		validateSize(size);
		this.size = size;
		recreateTable();
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void setElement(int row, int col, int value) throws IllegalArgumentException {
		validateIndex(row, col);
		setTableElement(row, col, value);
	}

	@Override
	public int getElement(int row, int col) throws IllegalArgumentException {
		validateIndex(row, col);
		return getTableElement(row, col);
	}

	@Override
	public int getRows() {
		return size;
	}

	@Override
	public int getColumns() {
		return size;
	}

	private void validateSize(int size) {
		ValidationResult result = new ValidationResult();
		if (size < minSize) {
			result.setErrorMessage("Minimum size can be " + minSize + ".");
		} else if (size > maxSize) {
			result.setErrorMessage("Maximum size can be " + maxSize + ".");
		} else {
			result.setStatus(true);
		}
		if (!result.isValid()) {
			throw new IllegalArgumentException(result.getErrorMessage());
		}
	}

	private void validateIndex(int row, int col) {
		ValidationResult result = new ValidationResult();
		row++;
		col++;
		if (row < minSize || row > size) {
			result.setErrorMessage("Row must be in a range from " + minSize + " to " + size + ".");
		} else if (col < minSize || col > size) {
			result.setErrorMessage("Column must be in a range from " + minSize + " to " + size + ".");
		} else {
			result.setStatus(true);
		}
		if (!result.isValid()) {
			throw new IllegalArgumentException(result.getErrorMessage());
		}
	}

	abstract void recreateTable();

	abstract void setTableElement(int row, int col, int value);

	abstract int getTableElement(int row, int col);
}
