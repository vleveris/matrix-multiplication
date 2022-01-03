package task.matrix;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class SquareMatrixTest {

	@Test
	void test2x2Ok() {
		int size = 2;
		SquareMatrix test1 = new SquareMatrix2D(size);
		SquareMatrix test2 = new SquareMatrix2D(size);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				test1.setElement(i, j, i * 2 + j + 1);
				test2.setElement(i, j, i * 2 + j + 1);
			}
		}
		List<IMatrix> matrices = new ArrayList<>();
		matrices.add(test1);
		matrices.add(test2);
		MatrixHandler handler = new MatrixHandler(matrices);
		IMatrix result = handler.multiply(true);
		int[][] table = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				table[i][j] = result.getElement(i, j);
			}
		}
		int[][] expected = { { 7, 10 }, { 15, 22 } };
		assertArrayEquals(expected, table);
	}

	@Test
	void test3x3Ok() {
		int size = 3;
		SquareMatrix test1 = new SquareMatrix2D(size);
		SquareMatrix test2 = new SquareMatrix2D(size);
		test1.setElement(0, 0, -4);
		test1.setElement(0, 1, 2);
		test1.setElement(0, 2, 1);
		test1.setElement(1, 0, 9);
		test1.setElement(1, 1, 5);
		test1.setElement(1, 2, 6);
		test1.setElement(2, 0, 3);
		test1.setElement(2, 1, 12);
		test1.setElement(2, 2, 7);
		test2.setElement(0, 0, 10);
		test2.setElement(0, 1, -3);
		test2.setElement(0, 2, -1);
		test2.setElement(1, 0, 8);
		test2.setElement(1, 1, 5);
		test2.setElement(1, 2, 3);
		test2.setElement(2, 0, 3);
		test2.setElement(2, 1, 0);
		test2.setElement(2, 2, 2);
		List<IMatrix> matrices = new ArrayList<>();
		matrices.add(test1);
		matrices.add(test2);
		MatrixHandler handler = new MatrixHandler(matrices);
		IMatrix result = handler.multiply(true);
		int[][] table = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				table[i][j] = result.getElement(i, j);
			}
		}
		int[][] expected = { { -21, 22, 12 }, { 148, -2, 18 }, { 147, 51, 47 } };
		assertArrayEquals(expected, table);
	}

	@Test
	void testIncorrectIndex() {
		SquareMatrix matrix = new SquareMatrix2D(4);
		assertThrows(IllegalArgumentException.class, () -> matrix.setElement(4, 2, 5));
	}

	@Test
	void testIncorrectSize() {
		SquareMatrix matrix = new SquareMatrix1D(1);
	assertThrows(IllegalArgumentException.class, () -> matrix.setSize(0));
	}

}