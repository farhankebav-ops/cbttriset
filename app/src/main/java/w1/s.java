package w1;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class s extends x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f17754c;

    public s(u uVar) {
        this.f17754c = uVar;
    }

    @Override // w1.x
    public final void a(Matrix matrix, v1.a aVar, int i2, Canvas canvas) {
        float f4;
        u uVar = this.f17754c;
        float f8 = uVar.f17760f;
        float f9 = uVar.g;
        RectF rectF = new RectF(uVar.f17757b, uVar.f17758c, uVar.f17759d, uVar.e);
        Paint paint = aVar.f17598b;
        boolean z2 = f9 < 0.0f;
        Path path = aVar.g;
        int[] iArr = v1.a.k;
        if (z2) {
            iArr[0] = 0;
            iArr[1] = aVar.f17601f;
            iArr[2] = aVar.e;
            iArr[3] = aVar.f17600d;
            f4 = 0.0f;
        } else {
            path.rewind();
            f4 = 0.0f;
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f8, f9);
            path.close();
            float f10 = -i2;
            rectF.inset(f10, f10);
            iArr[0] = 0;
            iArr[1] = aVar.f17600d;
            iArr[2] = aVar.e;
            iArr[3] = aVar.f17601f;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= f4) {
            return;
        }
        float f11 = 1.0f - (i2 / fWidth);
        float[] fArr = v1.a.l;
        fArr[1] = f11;
        fArr[2] = ((1.0f - f11) / 2.0f) + f11;
        paint.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, iArr, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z2) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, aVar.h);
        }
        canvas.drawArc(rectF, f8, f9, true, paint);
        canvas.restore();
    }
}
