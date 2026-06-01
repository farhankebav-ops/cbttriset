package w1;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class h extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f17705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c0 f17706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p1.a f17707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ColorStateList f17708d;
    public ColorStateList e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ColorStateList f17709f;
    public PorterDuff.Mode g;
    public Rect h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f17710i;
    public float j;
    public float k;
    public int l;
    public float m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f17711n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f17712o;
    public int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Paint.Style f17713q;

    public h(o oVar) {
        this.f17708d = null;
        this.e = null;
        this.f17709f = null;
        this.g = PorterDuff.Mode.SRC_IN;
        this.h = null;
        this.f17710i = 1.0f;
        this.j = 1.0f;
        this.l = 255;
        this.m = 0.0f;
        this.f17711n = 0.0f;
        this.f17712o = 0;
        this.p = 0;
        this.f17713q = Paint.Style.FILL_AND_STROKE;
        this.f17705a = oVar;
        this.f17707c = null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        k kVar = new k(this);
        kVar.f17719f = true;
        kVar.g = true;
        return kVar;
    }

    public h(h hVar) {
        this.f17708d = null;
        this.e = null;
        this.f17709f = null;
        this.g = PorterDuff.Mode.SRC_IN;
        this.h = null;
        this.f17710i = 1.0f;
        this.j = 1.0f;
        this.l = 255;
        this.m = 0.0f;
        this.f17711n = 0.0f;
        this.f17712o = 0;
        this.p = 0;
        this.f17713q = Paint.Style.FILL_AND_STROKE;
        this.f17705a = hVar.f17705a;
        this.f17706b = hVar.f17706b;
        this.f17707c = hVar.f17707c;
        this.k = hVar.k;
        this.f17708d = hVar.f17708d;
        this.e = hVar.e;
        this.g = hVar.g;
        this.f17709f = hVar.f17709f;
        this.l = hVar.l;
        this.f17710i = hVar.f17710i;
        this.p = hVar.p;
        this.j = hVar.j;
        this.m = hVar.m;
        this.f17711n = hVar.f17711n;
        this.f17712o = hVar.f17712o;
        this.f17713q = hVar.f17713q;
        if (hVar.h != null) {
            this.h = new Rect(hVar.h);
        }
    }
}
