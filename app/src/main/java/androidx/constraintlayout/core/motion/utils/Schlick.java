package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class Schlick extends Easing {
    private static final boolean DEBUG = false;
    double mEps;
    double mS;
    double mT;

    public Schlick(String str) {
        this.mStr = str;
        int iIndexOf = str.indexOf(40);
        int iIndexOf2 = str.indexOf(44, iIndexOf);
        this.mS = Double.parseDouble(str.substring(iIndexOf + 1, iIndexOf2).trim());
        int i2 = iIndexOf2 + 1;
        this.mT = Double.parseDouble(str.substring(i2, str.indexOf(44, i2)).trim());
    }

    private double dfunc(double d8) {
        double d9 = this.mT;
        if (d8 < d9) {
            double d10 = this.mS;
            return ((d10 * d9) * d9) / ((((d9 - d8) * d10) + d8) * (((d9 - d8) * d10) + d8));
        }
        double d11 = this.mS;
        return ((d9 - 1.0d) * ((d9 - 1.0d) * d11)) / (((((d9 - d8) * (-d11)) - d8) + 1.0d) * ((((d9 - d8) * (-d11)) - d8) + 1.0d));
    }

    private double func(double d8) {
        double d9 = this.mT;
        if (d8 < d9) {
            return (d9 * d8) / (((d9 - d8) * this.mS) + d8);
        }
        return ((d8 - 1.0d) * (1.0d - d9)) / ((1.0d - d8) - ((d9 - d8) * this.mS));
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double get(double d8) {
        return func(d8);
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double getDiff(double d8) {
        return dfunc(d8);
    }
}
