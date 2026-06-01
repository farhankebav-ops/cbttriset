package w1;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.BitSet;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y[] f17746a = new y[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix[] f17747b = new Matrix[4];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix[] f17748c = new Matrix[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PointF f17749d = new PointF();
    public final Path e = new Path();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f17750f = new Path();
    public final y g = new y();
    public final float[] h = new float[2];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float[] f17751i = new float[2];
    public final Path j = new Path();
    public final Path k = new Path();
    public final boolean l = true;

    public q() {
        for (int i2 = 0; i2 < 4; i2++) {
            this.f17746a[i2] = new y();
            this.f17747b[i2] = new Matrix();
            this.f17748c[i2] = new Matrix();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(o oVar, float[] fArr, float f4, RectF rectF, g gVar, Path path) {
        Matrix[] matrixArr;
        float[] fArr2;
        int i2;
        y[] yVarArr;
        Matrix[] matrixArr2;
        char c7;
        float f8;
        char c8;
        int i8;
        path.rewind();
        Path path2 = this.e;
        path2.rewind();
        Path path3 = this.f17750f;
        path3.rewind();
        path3.addRect(rectF, Path.Direction.CW);
        int i9 = 0;
        while (true) {
            matrixArr = this.f17748c;
            fArr2 = this.h;
            yVarArr = this.f17746a;
            matrixArr2 = this.f17747b;
            c7 = 0;
            if (i9 >= 4) {
                break;
            }
            d cVar = fArr == null ? i9 != 1 ? i9 != 2 ? i9 != 3 ? oVar.f17743f : oVar.e : oVar.h : oVar.g : new c(fArr[i9]);
            n7.b bVar = i9 != 1 ? i9 != 2 ? i9 != 3 ? oVar.f17740b : oVar.f17739a : oVar.f17742d : oVar.f17741c;
            y yVar = yVarArr[i9];
            bVar.getClass();
            bVar.t(yVar, f4, cVar.a(rectF));
            int i10 = i9 + 1;
            float f9 = (i10 % 4) * 90;
            matrixArr2[i9].reset();
            PointF pointF = this.f17749d;
            if (i9 == 1) {
                i8 = i9;
                pointF.set(rectF.right, rectF.bottom);
            } else if (i9 == 2) {
                i8 = i9;
                pointF.set(rectF.left, rectF.bottom);
            } else if (i9 != 3) {
                i8 = i9;
                pointF.set(rectF.right, rectF.top);
            } else {
                i8 = i9;
                pointF.set(rectF.left, rectF.top);
            }
            matrixArr2[i8].setTranslate(pointF.x, pointF.y);
            matrixArr2[i8].preRotate(f9);
            y yVar2 = yVarArr[i8];
            fArr2[0] = yVar2.f17767b;
            fArr2[1] = yVar2.f17768c;
            matrixArr2[i8].mapPoints(fArr2);
            matrixArr[i8].reset();
            matrixArr[i8].setTranslate(fArr2[0], fArr2[1]);
            matrixArr[i8].preRotate(f9);
            i9 = i10;
        }
        int i11 = 0;
        for (i2 = 4; i11 < i2; i2 = 4) {
            y yVar3 = yVarArr[i11];
            yVar3.getClass();
            fArr2[c7] = 0.0f;
            fArr2[1] = yVar3.f17766a;
            matrixArr2[i11].mapPoints(fArr2);
            if (i11 == 0) {
                path.moveTo(fArr2[c7], fArr2[1]);
            } else {
                path.lineTo(fArr2[c7], fArr2[1]);
            }
            yVarArr[i11].b(matrixArr2[i11], path);
            if (gVar != null) {
                y yVar4 = yVarArr[i11];
                Matrix matrix = matrixArr2[i11];
                k kVar = gVar.f17704a;
                f8 = 0.0f;
                BitSet bitSet = kVar.e;
                yVar4.getClass();
                bitSet.set(i11, (boolean) c7);
                x[] xVarArr = kVar.f17717c;
                yVar4.a(yVar4.e);
                xVarArr[i11] = new r(new ArrayList(yVar4.g), new Matrix(matrix));
            } else {
                f8 = 0.0f;
            }
            int i12 = i11 + 1;
            int i13 = i12 % 4;
            y yVar5 = yVarArr[i11];
            fArr2[0] = yVar5.f17767b;
            fArr2[1] = yVar5.f17768c;
            matrixArr2[i11].mapPoints(fArr2);
            y yVar6 = yVarArr[i13];
            yVar6.getClass();
            float[] fArr3 = this.f17751i;
            fArr3[0] = f8;
            fArr3[1] = yVar6.f17766a;
            matrixArr2[i13].mapPoints(fArr3);
            Matrix[] matrixArr3 = matrixArr;
            y[] yVarArr2 = yVarArr;
            float fMax = Math.max(((float) Math.hypot(fArr2[0] - fArr3[0], fArr2[1] - fArr3[1])) - 0.001f, f8);
            y yVar7 = yVarArr2[i11];
            fArr2[0] = yVar7.f17767b;
            fArr2[1] = yVar7.f17768c;
            matrixArr2[i11].mapPoints(fArr2);
            if (i11 == 1 || i11 == 3) {
                Math.abs(rectF.centerX() - fArr2[0]);
            } else {
                Math.abs(rectF.centerY() - fArr2[1]);
            }
            y yVar8 = this.g;
            yVar8.d(0.0f, 270.0f, 0.0f);
            (i11 != 1 ? i11 != 2 ? i11 != 3 ? oVar.j : oVar.f17744i : oVar.l : oVar.k).getClass();
            yVar8.c(fMax, 0.0f);
            Path path4 = this.j;
            path4.reset();
            yVar8.b(matrixArr3[i11], path4);
            if (this.l && (b(path4, i11) || b(path4, i13))) {
                path4.op(path4, path3, Path.Op.DIFFERENCE);
                fArr2[0] = 0.0f;
                fArr2[1] = yVar8.f17766a;
                matrixArr3[i11].mapPoints(fArr2);
                path2.moveTo(fArr2[0], fArr2[1]);
                yVar8.b(matrixArr3[i11], path2);
            } else {
                yVar8.b(matrixArr3[i11], path);
            }
            if (gVar != null) {
                Matrix matrix2 = matrixArr3[i11];
                k kVar2 = gVar.f17704a;
                c8 = 0;
                kVar2.e.set(i11 + 4, false);
                x[] xVarArr2 = kVar2.f17718d;
                yVar8.a(yVar8.e);
                xVarArr2[i11] = new r(new ArrayList(yVar8.g), new Matrix(matrix2));
            } else {
                c8 = 0;
            }
            matrixArr = matrixArr3;
            i11 = i12;
            c7 = c8;
            yVarArr = yVarArr2;
        }
        path.close();
        path2.close();
        if (path2.isEmpty()) {
            return;
        }
        path.op(path2, Path.Op.UNION);
    }

    public final boolean b(Path path, int i2) {
        Path path2 = this.k;
        path2.reset();
        this.f17746a[i2].b(this.f17747b[i2], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        return !rectF.isEmpty() || (rectF.width() > 1.0f && rectF.height() > 1.0f);
    }
}
