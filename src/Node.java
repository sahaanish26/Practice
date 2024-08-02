import java.util.Objects;

class Node {
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int row;
    public int col;

    public Node(int row, int column) {
        this.row = row;
        this.col = column;
    }

    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Node)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Node c = (Node) o;

        // Compare the data members and return accordingly
        return Integer.compare(row, c.row) == 0
                && Integer.compare(col, c.col) == 0;
    }


    @Override
    public String toString() {
        return this.row + " + " + this.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}