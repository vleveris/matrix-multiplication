package task.matrix;

public class SquareMatrix1D extends SquareMatrix {
	private int[] table;

	public SquareMatrix1D(int size) {
		setSize(size);
	}

	@Override
	void recreateTable() {
		int size = getSize();
		table = new int[size * size];
	}

	@Override
	void setTableElement(int row, int col, int value) {
		table[row * getSize() + col] = value;
	}

	@Override
	int getTableElement(int row, int col) {
		return table[row * getSize() + col];
	}
}
