package task.matrix;

public interface IMatrix {
	public void setElement(int row, int col, int value) throws IllegalArgumentException;

	public int getElement(int row, int col) throws IllegalArgumentException;

	public int getRows();

	public int getColumns();
}
