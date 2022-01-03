package task.matrix;

public class MatrixType {
	public static IMatrix identify(int row, int column, boolean d2) throws UnsupportedOperationException {
		if (row != column) {
			throw new UnsupportedOperationException("Only square matrices are supported at this time.");
		}
		if (d2) {
			return new SquareMatrix2D(row);
		} else {
			return new SquareMatrix1D(row);
		}
	}
}
