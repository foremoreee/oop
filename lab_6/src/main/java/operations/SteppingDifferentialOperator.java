package operations;

import functions.MathFunction;

public abstract class SteppingDifferentialOperator implements DifferentialOperator<MathFunction> {

    protected double step;

    public SteppingDifferentialOperator(double step) {
        validateStep(step);
        this.step = step;
    }

    private void validateStep(double step) {
        if (Double.isNaN(step) || Double.isInfinite(step) || step <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        validateStep(step);
        this.step = step;
    }
}