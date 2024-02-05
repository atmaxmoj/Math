package tensor.operand.vector;

import tensor.operand.tensor.Tensor;
import tensor.operand.matrix.Matrix;

import java.io.Serial;

public abstract class Vector<T extends Number> implements Tensor<Vector<T>> {
    @Serial
    private static final long serialVersionUID = 7669599959000120218L;

    public abstract Matrix<T> asMatrix();
}
