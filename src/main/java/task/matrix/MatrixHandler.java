package task.matrix;

import java.util.List;

public class MatrixHandler {
	private final IMatrix first, second;

	public MatrixHandler(List<IMatrix> matrices) throws UnsupportedOperationException {
		if (matrices.size() != 2) {
			throw new UnsupportedOperationException("Exactly 2 matrices should be given.");
		}
		first = matrices.get(0);
		second = matrices.get(1);
	}

	public IMatrix multiply(boolean d2) throws IllegalArgumentException {
		if (!areCompatible(first, second)) {
			throw new IllegalArgumentException("Matrices are not compatible.");
		}
		int rows = first.getRows();
		int columns = second.getColumns();
		IMatrix result = MatrixType.identify(rows, columns, d2);
		int sum;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				sum = 0;
				for (int k = 0; k < first.getColumns(); k++) {
					sum += first.getElement(i, k) * second.getElement(k, j);
				}
				result.setElement(i, j, sum);
			}
		}
		return result;
	}

	private boolean areCompatible(IMatrix matrix1, IMatrix matrix2) {
		return matrix1.getColumns() == matrix2.getRows();
	}
}
