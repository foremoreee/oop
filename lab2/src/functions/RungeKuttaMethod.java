package functions;

import java.util.function.BiFunction;

public class RungeKuttaMethod implements MathFunction
{

    //Коши
    
    private final BiFunction<Double, Double, Double> differentialUr; // Дифференциальное уравнение первого порядка
    private final double x0, y0; 


    // Конструктор иницализации 
    
    public RungeKuttaMethod(BiFunction<Double, Double, Double> differentialUr, double x0, double y0) 
    {
        if(differentialUr.apply(x0, y0) == Double.POSITIVE_INFINITY || Double.isNaN(differentialUr.apply(x0, y0)) || differentialUr.apply(x0, y0) == Double.NEGATIVE_INFINITY)
        {
            throw new IllegalArgumentException("It is impossible to calculate the solution of a differential equation at points where it is not defined!");
        }
        this.differentialUr = differentialUr;
        this.x0 = x0;
        this.y0 = y0;
    }

    @Override
    public double apply(double sizeofstep) 
    {
        // Вместо x в apply берём шаг по оси OX относительно x0 => x1 = x0 + sizeofstep
        double k1, k2, k3, k4;

        k1 = this.differentialUr.apply(this.x0, this.y0);
        k2 = this.differentialUr.apply(this.x0+sizeofstep/2, this.y0+sizeofstep*k1/2);
        k3 = this.differentialUr.apply(this.x0+sizeofstep/2, this.y0+sizeofstep*k2/2);
        k4 = this.differentialUr.apply(this.x0+sizeofstep, this.y0+sizeofstep*k3);

        double y1 = this.y0 + (sizeofstep/6) * (k1+2*k2+2*k3+k4);

        if(this.differentialUr.apply(x0+sizeofstep, y1) == Double.POSITIVE_INFINITY || Double.isNaN(this.differentialUr.apply(x0 + sizeofstep, y1)) || this.differentialUr.apply(x0+sizeofstep, y1) == Double.NEGATIVE_INFINITY)
        {
            throw new IllegalArgumentException("It is impossible to calculate the solution of a differential equation at points where it is not defined!");
        }

        // На выходе получаем ответ(y1)
        return y1;
    }
}