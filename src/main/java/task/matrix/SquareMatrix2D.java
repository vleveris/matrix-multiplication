package task.matrix;

public class SquareMatrix2D extends SquareMatrix {
	private int[][] table;

	public SquareMatrix2D(int size) {
		setSize(size);
	}

	@Override
	void recreateTable() {
		int size = getSize();
		table = new int[size][size];
	}

	@Override
	void setTableElement(int row, int col, int value) {
		table[row][col] = value;
	}

	@Override
	int getTableElement(int row, int col) {
		return table[row][col];
	}

}
