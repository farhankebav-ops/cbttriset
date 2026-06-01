package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class Easing {
    private static final String ACCELERATE = "cubic(0.4, 0.05, 0.8, 0.7)";
    private static final String ANTICIPATE = "cubic(0.36, 0, 0.66, -0.56)";
    private static final String ANTICIPATE_NAME = "anticipate";
    private static final String DECELERATE = "cubic(0.0, 0.0, 0.2, 0.95)";
    private static final String LINEAR = "cubic(1, 1, 0, 0)";
    private static final String OVERSHOOT = "cubic(0.34, 1.56, 0.64, 1)";
    private static final String OVERSHOOT_NAME = "overshoot";
    private static final String STANDARD = "cubic(0.4, 0.0, 0.2, 1)";
    String mStr = "identity";
    static Easing sDefault = new Easing();
    private static final String STANDARD_NAME = "standard";
    private static final String ACCELERATE_NAME = "accelerate";
    private static final String DECELERATE_NAME = "decelerate";
    private static final String LINEAR_NAME = "linear";
    public static String[] NAMED_EASING = {STANDARD_NAME, ACCELERATE_NAME, DECELERATE_NAME, LINEAR_NAME};

    public static Easing getInterpolator(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new CubicEasing(str);
        }
        if (str.startsWith("spline")) {
            return new StepCurve(str);
        }
        if (str.startsWith("Schlick")) {
            return new Schlick(str);
        }
        switch (str) {
            case "accelerate":
                return new CubicEasing(ACCELERATE);
            case "decelerate":
                return new CubicEasing(DECELERATE);
            case "anticipate":
                return new CubicEasing(ANTICIPATE);
            case "linear":
                return new CubicEasing(LINEAR);
            case "overshoot":
                return new CubicEasing(OVERSHOOT);
            case "standard":
                return new CubicEasing(STANDARD);
            default:
                System.err.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(NAMED_EASING));
                return sDefault;
        }
    }

    public double getDiff(double d8) {
        return 1.0d;
    }

    public String toString() {
        return this.mStr;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class CubicEasing extends Easing {
        private static double sDError = 1.0E-4d;
        private static double sError = 0.01d;
        double mX1;
        double mX2;
        double mY1;
        double mY2;

        public CubicEasing(String str) {
            this.mStr = str;
            int iIndexOf = str.indexOf(40);
            int iIndexOf2 = str.indexOf(44, iIndexOf);
            this.mX1 = Double.parseDouble(str.substring(iIndexOf + 1, iIndexOf2).trim());
            int i2 = iIndexOf2 + 1;
            int iIndexOf3 = str.indexOf(44, i2);
            this.mY1 = Double.parseDouble(str.substring(i2, iIndexOf3).trim());
            int i8 = iIndexOf3 + 1;
            int iIndexOf4 = str.indexOf(44, i8);
            this.mX2 = Double.parseDouble(str.substring(i8, iIndexOf4).trim());
            int i9 = iIndexOf4 + 1;
            this.mY2 = Double.parseDouble(str.substring(i9, str.indexOf(41, i9)).trim());
        }

        private double getDiffX(double d8) {
            double d9 = 1.0d - d8;
            double d10 = this.mX1;
            double d11 = d9 * 3.0d * d9 * d10;
            double d12 = this.mX2;
            return ((1.0d - d12) * 3.0d * d8 * d8) + ((d12 - d10) * d9 * 6.0d * d8) + d11;
        }

        private double getDiffY(double d8) {
            double d9 = 1.0d - d8;
            double d10 = this.mY1;
            double d11 = d9 * 3.0d * d9 * d10;
            double d12 = this.mY2;
            return ((1.0d - d12) * 3.0d * d8 * d8) + ((d12 - d10) * d9 * 6.0d * d8) + d11;
        }

        private double getX(double d8) {
            double d9 = 1.0d - d8;
            double d10 = 3.0d * d9;
            double d11 = d9 * d10 * d8;
            double d12 = d10 * d8 * d8;
            return (this.mX2 * d12) + (this.mX1 * d11) + (d8 * d8 * d8);
        }

        private double getY(double d8) {
            double d9 = 1.0d - d8;
            double d10 = 3.0d * d9;
            double d11 = d9 * d10 * d8;
            double d12 = d10 * d8 * d8;
            return (this.mY2 * d12) + (this.mY1 * d11) + (d8 * d8 * d8);
        }

        @Override // androidx.constraintlayout.core.motion.utils.Easing
        public double get(double d8) {
            if (d8 <= 0.0d) {
                return 0.0d;
            }
            if (d8 >= 1.0d) {
                return 1.0d;
            }
            double d9 = 0.5d;
            double d10 = 0.5d;
            while (d9 > sError) {
                d9 *= 0.5d;
                d10 = getX(d10) < d8 ? d10 + d9 : d10 - d9;
            }
            double d11 = d10 - d9;
            double x2 = getX(d11);
            double d12 = d10 + d9;
            double x7 = getX(d12);
            double y = getY(d11);
            return (((d8 - x2) * (getY(d12) - y)) / (x7 - x2)) + y;
        }

        @Override // androidx.constraintlayout.core.motion.utils.Easing
        public double getDiff(double d8) {
            double d9 = 0.5d;
            double d10 = 0.5d;
            while (d9 > sDError) {
                d9 *= 0.5d;
                d10 = getX(d10) < d8 ? d10 + d9 : d10 - d9;
            }
            double d11 = d10 - d9;
            double d12 = d10 + d9;
            return (getY(d12) - getY(d11)) / (getX(d12) - getX(d11));
        }

        public void setup(double d8, double d9, double d10, double d11) {
            this.mX1 = d8;
            this.mY1 = d9;
            this.mX2 = d10;
            this.mY2 = d11;
        }

        public CubicEasing(double d8, double d9, double d10, double d11) {
            setup(d8, d9, d10, d11);
        }
    }

    public double get(double d8) {
        return d8;
    }
}
