package d1;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f11045d;

    public void a(u4.b bVar) {
        Object obj;
        Object obj2;
        Object[] objArr = (Object[]) this.f11045d;
        int i2 = this.f11042a;
        int iHashCode = bVar.hashCode() * (-1640531527);
        int i8 = (iHashCode ^ (iHashCode >>> 16)) & i2;
        Object obj3 = objArr[i8];
        if (obj3 != null) {
            if (obj3.equals(bVar)) {
                return;
            }
            do {
                i8 = (i8 + 1) & i2;
                obj2 = objArr[i8];
                if (obj2 == null) {
                }
            } while (!obj2.equals(bVar));
            return;
        }
        objArr[i8] = bVar;
        int i9 = this.f11043b + 1;
        this.f11043b = i9;
        if (i9 < this.f11044c) {
            return;
        }
        Object[] objArr2 = (Object[]) this.f11045d;
        int length = objArr2.length;
        int i10 = length << 1;
        int i11 = i10 - 1;
        Object[] objArr3 = new Object[i10];
        while (true) {
            int i12 = i9 - 1;
            if (i9 == 0) {
                this.f11042a = i11;
                this.f11044c = (int) (i10 * 0.75f);
                this.f11045d = objArr3;
                return;
            }
            do {
                length--;
                obj = objArr2[length];
            } while (obj == null);
            int iHashCode2 = obj.hashCode() * (-1640531527);
            int i13 = (iHashCode2 ^ (iHashCode2 >>> 16)) & i11;
            if (objArr3[i13] != null) {
                do {
                    i13 = (i13 + 1) & i11;
                } while (objArr3[i13] != null);
            }
            objArr3[i13] = objArr2[length];
            i9 = i12;
        }
    }

    public void b() {
        View view = (View) this.f11045d;
        ViewCompat.offsetTopAndBottom(view, this.f11044c - (view.getTop() - this.f11042a));
        ViewCompat.offsetLeftAndRight(view, 0 - (view.getLeft() - this.f11043b));
    }

    public void c(int i2, int i8, Object[] objArr) {
        int i9;
        Object obj;
        this.f11043b--;
        while (true) {
            int i10 = i2 + 1;
            while (true) {
                i9 = i10 & i8;
                obj = objArr[i9];
                if (obj == null) {
                    objArr[i2] = null;
                    return;
                }
                int iHashCode = obj.hashCode() * (-1640531527);
                int i11 = (iHashCode ^ (iHashCode >>> 16)) & i8;
                if (i2 <= i9) {
                    if (i2 >= i11 || i11 > i9) {
                        break;
                    } else {
                        i10 = i9 + 1;
                    }
                } else if (i2 < i11 || i11 <= i9) {
                    i10 = i9 + 1;
                }
            }
            objArr[i2] = obj;
            i2 = i9;
        }
    }
}
