package tensor.operand.tensor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;

/**
 * even though tensor is indeed a general mathematical idea and there could be
 * a way of building an actual tensor class. But it is better kept as an interface
 * to keep customization available
 *
 * @param <T> the specific type of {@link Tensor}
 */
public interface Tensor<T extends Tensor<T>> extends Serializable {
    T scale(double scalar);

    /**
     * addition method
     *
     * <p>
     * for example the for matrix
     * </p>
     *
     * @return the addition result
     */
    T add(T tensor);

    Dimension dimension();

//    <B extends ByteTensor<? extends Tensor<?, Byte>>> B byteValue();
//
//    <D extends DoubleTensor<? extends Tensor<?, Double>>> D doubleValue();
//
//    <F extends FloatTensor<? extends Tensor<?, Float>>> F floatValue();
//
//    <I extends IntTensor<? extends Tensor<?>>> I intValue();


    abstract class Dimension implements Serializable {
        @Serial
        private static final long serialVersionUID = -5773981049140001959L;

        final int[] elementData;

        public Dimension(int[] elementData) {
            this.elementData = elementData;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Dimension dimension = (Dimension) o;
            return Arrays.equals(elementData, dimension.elementData);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(elementData);
        }
    }

    abstract class Index implements Serializable {
        @Serial
        private static final long serialVersionUID = 5423552936251701966L;

        final int[] elementData;

        public Index(int[] elementData) {
            this.elementData = elementData;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Index index = (Index) o;
            return Arrays.equals(elementData, index.elementData);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(elementData);
        }
    }
}
