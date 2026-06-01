package v1;

import android.graphics.Paint;
import android.graphics.Path;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f17596i = new int[3];
    public static final float[] j = {0.0f, 0.5f, 1.0f};
    public static final int[] k = new int[4];
    public static final float[] l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f17597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f17598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f17599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f17600d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f17601f;
    public final Path g = new Path();
    public final Paint h;

    public a() {
        Paint paint = new Paint();
        this.h = paint;
        this.f17597a = new Paint();
        a(ViewCompat.MEASURED_STATE_MASK);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f17598b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f17599c = new Paint(paint2);
    }

    public final void a(int i2) {
        this.f17600d = ColorUtils.setAlphaComponent(i2, 68);
        this.e = ColorUtils.setAlphaComponent(i2, 20);
        this.f17601f = ColorUtils.setAlphaComponent(i2, 0);
        this.f17597a.setColor(this.f17600d);
    }
}
