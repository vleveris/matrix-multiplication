package task;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import task.matrix.IMatrix;
import task.matrix.MatrixGenerator;
import task.matrix.MatrixHandler;
import task.matrix.SquareMatrix;
import task.matrix.SquareMatrix2D;

public class CalculationThread implements Runnable {
	private final int size;

	public CalculationThread(int size) {
		this.size = size;
	}

	@Override
	public void run() {
		Instant start = Instant.now();
		SquareMatrix matrix1 = new SquareMatrix2D(size), matrix2 = new SquareMatrix2D(size);
		List<IMatrix> matrices = new ArrayList<>();
		matrices.add(matrix1);
		matrices.add(matrix2);
		MatrixGenerator generator = new MatrixGenerator(matrix1);
		generator.generateRandom(1, 100);
		generator.setMatrix(matrix2);
		generator.generateRandom(1, 100);
		MatrixHandler operations = new MatrixHandler(matrices);
		 operations.multiply(true);
		Instant finish = Instant.now();
		long duration = Duration.between(start, finish).toMillis();
		System.out.println("size = " + size + ", duration: " + duration / 1000 + " s " + duration % 1000 + " ms.");

	}
}
