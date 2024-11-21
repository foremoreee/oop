package functions;

public class IdentityFunction implements MathFunction {

    @Override
    public double apply(double x) {
        return x;
    }

    @Override
    public String toString() {
        return "IdentityFunction: f(x) = x";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof IdentityFunction;
    }

    @Override
    public int hashCode() {
        int hash = 54;  // Можно использовать любое  число (все экземпляры считаются равными)
        return hash;
    }

    @Override
    public IdentityFunction clone(){
        return new IdentityFunction();
    }
}