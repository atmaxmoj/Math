package tensor.operand.matrix;

import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;

public class MatrixContext {
    private static final int DEFAULT_DIGITS = 9;
    private static final RoundingMode DEFAULT_ROUNDING_MODE = RoundingMode.HALF_UP;
    private static final int MIN_DIGITS = 0;
    final RoundingMode roundingMode;
    final int precision;


    public MatrixContext(int setPrecision) {
        this(setPrecision, DEFAULT_ROUNDING_MODE);
    }

    public MatrixContext(int setPrecision, RoundingMode setRoundingMode) {
        if (setPrecision < MIN_DIGITS) throw new IllegalArgumentException("Digits < 0");
        if (setRoundingMode == null) throw new NullPointerException("null RoundingMode");
        precision = setPrecision;
        roundingMode = setRoundingMode;
    }

    public MatrixContext() {
        this(DEFAULT_DIGITS);
    }

    public MatrixContext(MathContext mathContext) {
        this();
    }

    enum MetaData {
        TRACE,
        RANK,
        DETERMINANT,
        ROW,
        COLUMN,
        EIGENVALUE,
        EIGENVECTOR,
        INVERSE
    }
}
