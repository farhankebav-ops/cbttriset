package i4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11877a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f11878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f11879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object[][] f11880d;

    public /* synthetic */ j0() {
    }

    public static j0 c() {
        j0 j0Var = new j0();
        j0Var.f11879c = b.f11821b;
        j0Var.f11880d = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);
        return j0Var;
    }

    public void a(n0 n0Var) {
        j jVar;
        int length = 0;
        while (true) {
            Object[][] objArr = this.f11880d;
            int length2 = objArr.length;
            jVar = o0.f11923c;
            if (length >= length2) {
                length = -1;
                break;
            } else if (jVar.equals(objArr[length][0])) {
                break;
            } else {
                length++;
            }
        }
        if (length == -1) {
            Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, this.f11880d.length + 1, 2);
            Object[][] objArr3 = this.f11880d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f11880d = objArr2;
            length = objArr2.length - 1;
        }
        this.f11880d[length] = new Object[]{jVar, n0Var};
    }

    public Object b() {
        Object[][] objArr = this.f11880d;
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (o0.f11923c.equals(objArr[i2][0])) {
                return objArr[i2][1];
            }
        }
        return null;
    }

    public void d(List list) {
        r2.q.y(!list.isEmpty(), "addrs is empty");
        this.f11878b = Collections.unmodifiableList(new ArrayList(list));
    }

    public String toString() {
        switch (this.f11877a) {
            case 1:
                e2.i iVarY = a.a.Y(this);
                iVarY.c(this.f11878b, "addrs");
                iVarY.c(this.f11879c, "attrs");
                iVarY.c(Arrays.deepToString(this.f11880d), "customOptions");
                return iVarY.toString();
            default:
                return super.toString();
        }
    }

    public j0(List list, b bVar, Object[][] objArr) {
        r2.q.D(list, "addresses are not set");
        this.f11878b = list;
        r2.q.D(bVar, "attrs");
        this.f11879c = bVar;
        r2.q.D(objArr, "customOptions");
        this.f11880d = objArr;
    }
}
