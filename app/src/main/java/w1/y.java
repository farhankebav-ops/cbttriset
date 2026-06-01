package w1;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f17766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f17767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f17768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f17769d;
    public float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f17770f = new ArrayList();
    public final ArrayList g = new ArrayList();

    public y() {
        d(0.0f, 270.0f, 0.0f);
    }

    public final void a(float f4) {
        float f8 = this.f17769d;
        if (f8 == f4) {
            return;
        }
        float f9 = ((f4 - f8) + 360.0f) % 360.0f;
        if (f9 > 180.0f) {
            return;
        }
        float f10 = this.f17767b;
        float f11 = this.f17768c;
        u uVar = new u(f10, f11, f10, f11);
        uVar.f17760f = this.f17769d;
        uVar.g = f9;
        this.g.add(new s(uVar));
        this.f17769d = f4;
    }

    public final void b(Matrix matrix, Path path) {
        ArrayList arrayList = this.f17770f;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((w) arrayList.get(i2)).a(matrix, path);
        }
    }

    public final void c(float f4, float f8) {
        v vVar = new v();
        vVar.f17761b = f4;
        vVar.f17762c = f8;
        this.f17770f.add(vVar);
        t tVar = new t(vVar, this.f17767b, this.f17768c);
        float fB = tVar.b() + 270.0f;
        float fB2 = tVar.b() + 270.0f;
        a(fB);
        this.g.add(tVar);
        this.f17769d = fB2;
        this.f17767b = f4;
        this.f17768c = f8;
    }

    public final void d(float f4, float f8, float f9) {
        this.f17766a = f4;
        this.f17767b = 0.0f;
        this.f17768c = f4;
        this.f17769d = f8;
        this.e = (f8 + f9) % 360.0f;
        this.f17770f.clear();
        this.g.clear();
    }
}
