package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class ArcCurveFit extends CurveFit {
    public static final int ARC_ABOVE = 5;
    public static final int ARC_BELOW = 4;
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    private static final int DOWN_ARC = 4;
    private static final int START_HORIZONTAL = 2;
    private static final int START_LINEAR = 3;
    private static final int START_VERTICAL = 1;
    private static final int UP_ARC = 5;
    Arc[] mArcs;
    private boolean mExtrapolate = true;
    private final double[] mTime;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Arc {
        private static final double EPSILON = 0.001d;
        private static final String TAG = "Arc";
        private static double[] sOurPercent = new double[91];
        double mArcDistance;
        double mArcVelocity;
        double mEllipseA;
        double mEllipseB;
        double mEllipseCenterX;
        double mEllipseCenterY;
        boolean mLinear;
        double[] mLut;
        double mOneOverDeltaTime;
        double mTime1;
        double mTime2;
        double mTmpCosAngle;
        double mTmpSinAngle;
        boolean mVertical;
        double mX1;
        double mX2;
        double mY1;
        double mY2;

        public Arc(int i2, double d8, double d9, double d10, double d11, double d12, double d13) {
            this.mLinear = false;
            double d14 = d12 - d10;
            double d15 = d13 - d11;
            if (i2 == 1) {
                this.mVertical = true;
            } else if (i2 == 4) {
                this.mVertical = d15 > 0.0d;
            } else if (i2 != 5) {
                this.mVertical = false;
            } else {
                this.mVertical = d15 < 0.0d;
            }
            this.mTime1 = d8;
            this.mTime2 = d9;
            this.mOneOverDeltaTime = 1.0d / (d9 - d8);
            if (3 == i2) {
                this.mLinear = true;
            }
            if (!this.mLinear && Math.abs(d14) >= EPSILON && Math.abs(d15) >= EPSILON) {
                this.mLut = new double[101];
                boolean z2 = this.mVertical;
                this.mEllipseA = d14 * ((double) (z2 ? -1 : 1));
                this.mEllipseB = d15 * ((double) (z2 ? 1 : -1));
                this.mEllipseCenterX = z2 ? d12 : d10;
                this.mEllipseCenterY = z2 ? d11 : d13;
                buildTable(d10, d11, d12, d13);
                this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
                return;
            }
            this.mLinear = true;
            this.mX1 = d10;
            this.mX2 = d12;
            this.mY1 = d11;
            this.mY2 = d13;
            double dHypot = Math.hypot(d15, d14);
            this.mArcDistance = dHypot;
            this.mArcVelocity = dHypot * this.mOneOverDeltaTime;
            double d16 = this.mTime2;
            double d17 = this.mTime1;
            this.mEllipseCenterX = d14 / (d16 - d17);
            this.mEllipseCenterY = d15 / (d16 - d17);
        }

        private void buildTable(double d8, double d9, double d10, double d11) {
            double d12 = d10 - d8;
            double d13 = d9 - d11;
            int i2 = 0;
            double dHypot = 0.0d;
            double d14 = 0.0d;
            double d15 = 0.0d;
            while (true) {
                if (i2 >= sOurPercent.length) {
                    break;
                }
                int i8 = i2;
                double radians = Math.toRadians((((double) i2) * 90.0d) / ((double) (r15.length - 1)));
                double dSin = Math.sin(radians) * d12;
                double dCos = Math.cos(radians) * d13;
                if (i8 > 0) {
                    dHypot += Math.hypot(dSin - d14, dCos - d15);
                    sOurPercent[i8] = dHypot;
                }
                i2 = i8 + 1;
                d14 = dSin;
                d15 = dCos;
            }
            this.mArcDistance = dHypot;
            int i9 = 0;
            while (true) {
                double[] dArr = sOurPercent;
                if (i9 >= dArr.length) {
                    break;
                }
                dArr[i9] = dArr[i9] / dHypot;
                i9++;
            }
            int i10 = 0;
            while (true) {
                if (i10 >= this.mLut.length) {
                    return;
                }
                double length = ((double) i10) / ((double) (r1.length - 1));
                int iBinarySearch = Arrays.binarySearch(sOurPercent, length);
                if (iBinarySearch >= 0) {
                    this.mLut[i10] = ((double) iBinarySearch) / ((double) (sOurPercent.length - 1));
                } else if (iBinarySearch == -1) {
                    this.mLut[i10] = 0.0d;
                } else {
                    int i11 = -iBinarySearch;
                    int i12 = i11 - 2;
                    double[] dArr2 = sOurPercent;
                    double d16 = dArr2[i12];
                    this.mLut[i10] = (((length - d16) / (dArr2[i11 - 1] - d16)) + ((double) i12)) / ((double) (dArr2.length - 1));
                }
                i10++;
            }
        }

        public double getDX() {
            double d8 = this.mEllipseA * this.mTmpCosAngle;
            double dHypot = this.mArcVelocity / Math.hypot(d8, (-this.mEllipseB) * this.mTmpSinAngle);
            return this.mVertical ? (-d8) * dHypot : d8 * dHypot;
        }

        public double getDY() {
            double d8 = this.mEllipseA * this.mTmpCosAngle;
            double d9 = (-this.mEllipseB) * this.mTmpSinAngle;
            double dHypot = this.mArcVelocity / Math.hypot(d8, d9);
            return this.mVertical ? (-d9) * dHypot : d9 * dHypot;
        }

        public double getLinearDX(double d8) {
            return this.mEllipseCenterX;
        }

        public double getLinearDY(double d8) {
            return this.mEllipseCenterY;
        }

        public double getLinearX(double d8) {
            double d9 = (d8 - this.mTime1) * this.mOneOverDeltaTime;
            double d10 = this.mX1;
            return ((this.mX2 - d10) * d9) + d10;
        }

        public double getLinearY(double d8) {
            double d9 = (d8 - this.mTime1) * this.mOneOverDeltaTime;
            double d10 = this.mY1;
            return ((this.mY2 - d10) * d9) + d10;
        }

        public double getX() {
            return (this.mEllipseA * this.mTmpSinAngle) + this.mEllipseCenterX;
        }

        public double getY() {
            return (this.mEllipseB * this.mTmpCosAngle) + this.mEllipseCenterY;
        }

        public double lookup(double d8) {
            if (d8 <= 0.0d) {
                return 0.0d;
            }
            if (d8 >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.mLut;
            double length = d8 * ((double) (dArr.length - 1));
            int i2 = (int) length;
            double d9 = length - ((double) i2);
            double d10 = dArr[i2];
            return ((dArr[i2 + 1] - d10) * d9) + d10;
        }

        public void setPoint(double d8) {
            double dLookup = lookup((this.mVertical ? this.mTime2 - d8 : d8 - this.mTime1) * this.mOneOverDeltaTime) * 1.5707963267948966d;
            this.mTmpSinAngle = Math.sin(dLookup);
            this.mTmpCosAngle = Math.cos(dLookup);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ArcCurveFit(int[] r24, double[] r25, double[][] r26) {
        /*
            r23 = this;
            r0 = r23
            r1 = r25
            r0.<init>()
            r2 = 1
            r0.mExtrapolate = r2
            r0.mTime = r1
            int r3 = r1.length
            int r3 = r3 - r2
            androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc[] r3 = new androidx.constraintlayout.core.motion.utils.ArcCurveFit.Arc[r3]
            r0.mArcs = r3
            r3 = 0
            r5 = r2
            r6 = r5
            r4 = r3
        L16:
            androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc[] r7 = r0.mArcs
            int r8 = r7.length
            if (r4 >= r8) goto L5b
            r8 = r24[r4]
            r9 = 3
            if (r8 == 0) goto L38
            if (r8 == r2) goto L36
            r10 = 2
            if (r8 == r10) goto L34
            if (r8 == r9) goto L2f
            r9 = 4
            if (r8 == r9) goto L38
            r9 = 5
            if (r8 == r9) goto L38
            r9 = r6
            goto L38
        L2f:
            if (r5 != r2) goto L36
            goto L34
        L32:
            r9 = r5
            goto L38
        L34:
            r5 = r10
            goto L32
        L36:
            r5 = r2
            goto L32
        L38:
            androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc r8 = new androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc
            r10 = r1[r4]
            int r6 = r4 + 1
            r12 = r1[r6]
            r14 = r26[r4]
            r15 = r14[r3]
            r17 = r14[r2]
            r14 = r26[r6]
            r19 = r14[r3]
            r21 = r14[r2]
            r14 = r15
            r16 = r17
            r18 = r19
            r20 = r21
            r8.<init>(r9, r10, r12, r14, r16, r18, r20)
            r7[r4] = r8
            r4 = r6
            r6 = r9
            goto L16
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.ArcCurveFit.<init>(int[], double[], double[][]):void");
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d8, double[] dArr) {
        if (this.mExtrapolate) {
            Arc[] arcArr = this.mArcs;
            Arc arc = arcArr[0];
            double d9 = arc.mTime1;
            if (d8 < d9) {
                double d10 = d8 - d9;
                if (arc.mLinear) {
                    dArr[0] = (this.mArcs[0].getLinearDX(d9) * d10) + arc.getLinearX(d9);
                    dArr[1] = (d10 * this.mArcs[0].getLinearDY(d9)) + this.mArcs[0].getLinearY(d9);
                    return;
                }
                arc.setPoint(d9);
                dArr[0] = (this.mArcs[0].getDX() * d10) + this.mArcs[0].getX();
                dArr[1] = (d10 * this.mArcs[0].getDY()) + this.mArcs[0].getY();
                return;
            }
            if (d8 > arcArr[arcArr.length - 1].mTime2) {
                double d11 = arcArr[arcArr.length - 1].mTime2;
                double d12 = d8 - d11;
                int length = arcArr.length - 1;
                Arc arc2 = arcArr[length];
                if (arc2.mLinear) {
                    dArr[0] = (this.mArcs[length].getLinearDX(d11) * d12) + arc2.getLinearX(d11);
                    dArr[1] = (d12 * this.mArcs[length].getLinearDY(d11)) + this.mArcs[length].getLinearY(d11);
                    return;
                }
                arc2.setPoint(d8);
                dArr[0] = (this.mArcs[length].getDX() * d12) + this.mArcs[length].getX();
                dArr[1] = (d12 * this.mArcs[length].getDY()) + this.mArcs[length].getY();
                return;
            }
        } else {
            Arc[] arcArr2 = this.mArcs;
            double d13 = arcArr2[0].mTime1;
            if (d8 < d13) {
                d8 = d13;
            }
            if (d8 > arcArr2[arcArr2.length - 1].mTime2) {
                d8 = arcArr2[arcArr2.length - 1].mTime2;
            }
        }
        int i2 = 0;
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i2 >= arcArr3.length) {
                return;
            }
            Arc arc3 = arcArr3[i2];
            if (d8 <= arc3.mTime2) {
                if (arc3.mLinear) {
                    dArr[0] = arc3.getLinearX(d8);
                    dArr[1] = this.mArcs[i2].getLinearY(d8);
                    return;
                } else {
                    arc3.setPoint(d8);
                    dArr[0] = this.mArcs[i2].getX();
                    dArr[1] = this.mArcs[i2].getY();
                    return;
                }
            }
            i2++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double d8, double[] dArr) {
        Arc[] arcArr = this.mArcs;
        double d9 = arcArr[0].mTime1;
        if (d8 < d9) {
            d8 = d9;
        } else if (d8 > arcArr[arcArr.length - 1].mTime2) {
            d8 = arcArr[arcArr.length - 1].mTime2;
        }
        int i2 = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i2 >= arcArr2.length) {
                return;
            }
            Arc arc = arcArr2[i2];
            if (d8 <= arc.mTime2) {
                if (arc.mLinear) {
                    dArr[0] = arc.getLinearDX(d8);
                    dArr[1] = this.mArcs[i2].getLinearDY(d8);
                    return;
                } else {
                    arc.setPoint(d8);
                    dArr[0] = this.mArcs[i2].getDX();
                    dArr[1] = this.mArcs[i2].getDY();
                    return;
                }
            }
            i2++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mTime;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double d8, int i2) {
        Arc[] arcArr = this.mArcs;
        int i8 = 0;
        double d9 = arcArr[0].mTime1;
        if (d8 < d9) {
            d8 = d9;
        }
        if (d8 > arcArr[arcArr.length - 1].mTime2) {
            d8 = arcArr[arcArr.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i8 >= arcArr2.length) {
                return Double.NaN;
            }
            Arc arc = arcArr2[i8];
            if (d8 <= arc.mTime2) {
                if (arc.mLinear) {
                    if (i2 == 0) {
                        return arc.getLinearDX(d8);
                    }
                    return arc.getLinearDY(d8);
                }
                arc.setPoint(d8);
                if (i2 == 0) {
                    return this.mArcs[i8].getDX();
                }
                return this.mArcs[i8].getDY();
            }
            i8++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d8, float[] fArr) {
        if (this.mExtrapolate) {
            Arc[] arcArr = this.mArcs;
            Arc arc = arcArr[0];
            double d9 = arc.mTime1;
            if (d8 < d9) {
                double d10 = d8 - d9;
                if (arc.mLinear) {
                    fArr[0] = (float) ((this.mArcs[0].getLinearDX(d9) * d10) + arc.getLinearX(d9));
                    fArr[1] = (float) ((d10 * this.mArcs[0].getLinearDY(d9)) + this.mArcs[0].getLinearY(d9));
                    return;
                }
                arc.setPoint(d9);
                fArr[0] = (float) ((this.mArcs[0].getDX() * d10) + this.mArcs[0].getX());
                fArr[1] = (float) ((d10 * this.mArcs[0].getDY()) + this.mArcs[0].getY());
                return;
            }
            if (d8 > arcArr[arcArr.length - 1].mTime2) {
                double d11 = arcArr[arcArr.length - 1].mTime2;
                double d12 = d8 - d11;
                int length = arcArr.length - 1;
                Arc arc2 = arcArr[length];
                if (arc2.mLinear) {
                    fArr[0] = (float) ((this.mArcs[length].getLinearDX(d11) * d12) + arc2.getLinearX(d11));
                    fArr[1] = (float) ((d12 * this.mArcs[length].getLinearDY(d11)) + this.mArcs[length].getLinearY(d11));
                    return;
                }
                arc2.setPoint(d8);
                fArr[0] = (float) this.mArcs[length].getX();
                fArr[1] = (float) this.mArcs[length].getY();
                return;
            }
        } else {
            Arc[] arcArr2 = this.mArcs;
            double d13 = arcArr2[0].mTime1;
            if (d8 < d13) {
                d8 = d13;
            } else if (d8 > arcArr2[arcArr2.length - 1].mTime2) {
                d8 = arcArr2[arcArr2.length - 1].mTime2;
            }
        }
        int i2 = 0;
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i2 >= arcArr3.length) {
                return;
            }
            Arc arc3 = arcArr3[i2];
            if (d8 <= arc3.mTime2) {
                if (arc3.mLinear) {
                    fArr[0] = (float) arc3.getLinearX(d8);
                    fArr[1] = (float) this.mArcs[i2].getLinearY(d8);
                    return;
                } else {
                    arc3.setPoint(d8);
                    fArr[0] = (float) this.mArcs[i2].getX();
                    fArr[1] = (float) this.mArcs[i2].getY();
                    return;
                }
            }
            i2++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double d8, int i2) {
        int i8 = 0;
        if (this.mExtrapolate) {
            Arc[] arcArr = this.mArcs;
            Arc arc = arcArr[0];
            double d9 = arc.mTime1;
            if (d8 < d9) {
                double d10 = d8 - d9;
                if (arc.mLinear) {
                    if (i2 == 0) {
                        return (d10 * this.mArcs[0].getLinearDX(d9)) + arc.getLinearX(d9);
                    }
                    return (d10 * this.mArcs[0].getLinearDY(d9)) + arc.getLinearY(d9);
                }
                arc.setPoint(d9);
                if (i2 == 0) {
                    return (d10 * this.mArcs[0].getDX()) + this.mArcs[0].getX();
                }
                return (d10 * this.mArcs[0].getDY()) + this.mArcs[0].getY();
            }
            if (d8 > arcArr[arcArr.length - 1].mTime2) {
                double d11 = arcArr[arcArr.length - 1].mTime2;
                double d12 = d8 - d11;
                int length = arcArr.length - 1;
                if (i2 == 0) {
                    return (d12 * this.mArcs[length].getLinearDX(d11)) + arcArr[length].getLinearX(d11);
                }
                return (d12 * this.mArcs[length].getLinearDY(d11)) + arcArr[length].getLinearY(d11);
            }
        } else {
            Arc[] arcArr2 = this.mArcs;
            double d13 = arcArr2[0].mTime1;
            if (d8 < d13) {
                d8 = d13;
            } else if (d8 > arcArr2[arcArr2.length - 1].mTime2) {
                d8 = arcArr2[arcArr2.length - 1].mTime2;
            }
        }
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i8 >= arcArr3.length) {
                return Double.NaN;
            }
            Arc arc2 = arcArr3[i8];
            if (d8 <= arc2.mTime2) {
                if (arc2.mLinear) {
                    if (i2 == 0) {
                        return arc2.getLinearX(d8);
                    }
                    return arc2.getLinearY(d8);
                }
                arc2.setPoint(d8);
                if (i2 == 0) {
                    return this.mArcs[i8].getX();
                }
                return this.mArcs[i8].getY();
            }
            i8++;
        }
    }
}
