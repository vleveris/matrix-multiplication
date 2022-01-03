package task.matrix;

public class MatrixGenerator {
	private IMatrix matrix;

	public MatrixGenerator(IMatrix matrix) {
		this.matrix = matrix;
	}

	public void generateRandom(int from, int to) {
		int rows = matrix.getRows();
		int columns = matrix.getColumns();
		to--;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				int element = (int) (Math.random() * to + from);
				matrix.setElement(i, j, element);
			}
		}

	}

	public void setMatrix(IMatrix matrix) {
		this.matrix = matrix;
	}
}
