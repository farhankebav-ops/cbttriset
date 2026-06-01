package w1;

import android.graphics.Canvas;
import android.graphics.Matrix;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class r extends x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList f17752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Matrix f17753d;

    public r(ArrayList arrayList, Matrix matrix) {
        this.f17752c = arrayList;
        this.f17753d = matrix;
    }

    @Override // w1.x
    public final void a(Matrix matrix, v1.a aVar, int i2, Canvas canvas) {
        ArrayList arrayList = this.f17752c;
        int size = arrayList.size();
        int i8 = 0;
        while (i8 < size) {
            Object obj = arrayList.get(i8);
            i8++;
            ((x) obj).a(this.f17753d, aVar, i2, canvas);
        }
    }
}
