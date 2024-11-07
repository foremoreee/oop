package functions;

import java.util.Arrays;

// Cплайн по Де Бура.
public class DeBoorAlgorithmFunction implements MathFunction {
    private double[] node; // Массив узлов
    private double[] controlP; // Массив контрольных точек
    private int splineD; // Степень сплайна

    public DeBoorAlgorithmFunction(double[] node, double[] controlP, int splineD) {
        if (node.length < splineD + 1 || controlP.length < splineD + 1) {
            throw new IllegalArgumentException("Insufficient number of nodes or control points.");
        }
        this.node = Arrays.copyOf(node, node.length);
        this.controlP = Arrays.copyOf(controlP, controlP.length);
        this.splineD = splineD;
    }

    // Алгоритм де Бура
    private double algorithm(double x) {
        int segmentIndex = findSegment(x); // Cегмент по  x
        double[] d = new double[splineD + 1]; // Массив d

        // Инициализируем значения d на основе контрольных точек
        for (int i = 0; i <= splineD; ++i) {
            d[i] = controlP[segmentIndex - splineD + i];
        }

        // Применяем де Бура
        for (int r = 1; r <= splineD; ++r) {
            for (int j = splineD; j >= r; --j) {
                int knotIndex = segmentIndex + j - splineD;
                double denominator = node[knotIndex + splineD - r + 1] - node[knotIndex];
                if (denominator == 0) {
                    throw new ArithmeticException("Деление на ноль: найдены одинаковые узлы.");
                }
                double alpha = (x - node[knotIndex]) / denominator;
                d[j] = (1 - alpha) * d[j - 1] + alpha * d[j];
            }
        }

        return d[splineD];
    }

    // Поиск индекса сегмента
    private int findSegment(double x) {
        int n = node.length - 1;
        if (x < node[splineD] || x > node[n - splineD]) {
            throw new IllegalArgumentException("The value of x goes beyond the acceptable boundaries of nodes.");
        }
        for (int i = splineD; i < n - splineD; ++i) {
            if (x >= node[i] && x < node[i + 1]) {
                return i;
            }
        }
        return n - splineD - 1; // Eсли x совпадает с последним узлом
    }

    // Вычисление сплайна в x
    @Override
    public double apply(double x) {
        return algorithm(x);
    }
}
