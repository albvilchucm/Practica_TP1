package utils;
import java.util.Objects;

public class Position {
	private int row;
	private int col;

	public Position(int f, int c) {
		this.row = f;
		this.col = c;
	}

	public int row() {
		return this.row;
	}

	public int col() {
		return this.col;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null || getClass() != obj.getClass())
			return false;

		Position position2 = (Position) obj;
		return this.row == position2.row && this.col == position2.col;
	}
	
	@Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}