package w1;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class t extends x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f17755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f17756d;
    public final float e;

    public t(v vVar, float f4, float f8) {
        this.f17755c = vVar;
        this.f17756d = f4;
        this.e = f8;
    }

    @Override // w1.x
    public final void a(Matrix matrix, v1.a aVar, int i2, Canvas canvas) {
        v vVar = this.f17755c;
        float f4 = vVar.f17762c;
        float f8 = this.e;
        float f9 = vVar.f17761b;
        float f10 = this.f17756d;
        RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(f4 - f8, f9 - f10), 0.0f);
        Matrix matrix2 = this.f17765a;
        matrix2.set(matrix);
        matrix2.preTranslate(f10, f8);
        matrix2.preRotate(b());
        aVar.getClass();
        rectF.bottom += i2;
        rectF.offset(0.0f, -i2);
        int i8 = aVar.f17601f;
        int[] iArr = v1.a.f17596i;
        iArr[0] = i8;
        iArr[1] = aVar.e;
        iArr[2] = aVar.f17600d;
        Paint paint = aVar.f17599c;
        float f11 = rectF.left;
        paint.setShader(new LinearGradient(f11, rectF.top, f11, rectF.bottom, iArr, v1.a.j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix2);
        canvas.drawRect(rectF, paint);
        canvas.restore();
    }

    public final float b() {
        v vVar = this.f17755c;
        return (float) Math.toDegrees(Math.atan((vVar.f17762c - this.e) / (vVar.f17761b - this.f17756d)));
    }
}
