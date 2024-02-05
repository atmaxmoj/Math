package tensor.operand.matrix;

import tensor.exception.DimensionException;
import tensor.operand.tensor.*;
import tensor.operand.vector.Vector;

import java.io.Serial;

/**
 * byte -> int -> long -> float -> double
 */
public class Matrix<N extends Number> implements Tensor<Matrix<N>> {
    @Serial
    private static final long serialVersionUID = -5447869687953019834L;

    transient Number[][] elementData;

    Dimension dimension;

    Vector<N>[] rows;

    Vector<N>[] columns;

    Integer rank;

    N trace;

    Double determinant;

    public Matrix() {
    }

    public Matrix(N[][] elementData) {
        this.elementData = elementData;
    }

    public Matrix(N[] elementData, int rowDimension, int columnDimension) {
        if (rowDimension * columnDimension != elementData.length) {
            throw new DimensionException();
        }
        this.dimension = new Dimension(rowDimension, columnDimension);
        this.elementData = new Number[rowDimension][columnDimension];
        for (int rowIndex = 0; rowIndex < rowDimension; rowIndex++) {
            Number[] row = this.elementData[rowIndex];
            for (int columnIndex = 0; columnIndex < columnDimension; columnIndex++) {
                row[columnDimension] = elementData[rowIndex * columnIndex + columnIndex];
            }
        }
    }

    public Dimension size() {
        return dimension;
    }

    @Override
    public Matrix<N> scale(double scalar) {

        return null;
    }

    @Override
    public Matrix<N> add(Matrix<N> tensor) {
        return null;
    }

    @Override
    public Tensor.Dimension dimension() {
        return dimension;
    }


    public static class Dimension extends Tensor.Dimension {
        @Serial
        private static final long serialVersionUID = 6749490106886410562L;

        public Dimension(int rowDimension, int columnDimension) {
            super(new int[]{rowDimension, columnDimension});
        }
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
