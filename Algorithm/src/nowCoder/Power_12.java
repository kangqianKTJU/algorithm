package nowCoder;


/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Power_12 {
    // 1. 考虑特俗情况，指数为0，底数为0

    public double Power(double base, int exponent) {
        if(base == 0){
            if(exponent <= 0) throw new IllegalArgumentException("base:0, exponet <= 0");
            return 0;
        }else{
            double res = 1.0;
            int positiveExp = exponent >= 0 ? exponent : -exponent;
            while(positiveExp-- > 0){
                res = res*base;
            }
            return exponent >= 0 ? res : 1 / res;
        }
    }

    // 2.  通过二分优化求幂指的过程，快速幂

    public double Power2(double base, int exponent) {
        if(base == 0){
            if(exponent <= 0) throw new IllegalArgumentException("base:0, exponent <= 0");
            return 0;
        }else{
            if(exponent > 0){
                return PowerWithUnsignedExponent(base, exponent);
            }else{
                return 1 / PowerWithUnsignedExponent(base, -exponent);
            }
        }
    }

    private double PowerWithUnsignedExponent(double base, int exponent) {
        if(exponent == 0){
            return 1;
        }

        double result = PowerWithUnsignedExponent(base, exponent >> 1);
        result *= result;
        if((exponent & 1) == 1){
            result *= base;
        }
        return  result;
    }
}
