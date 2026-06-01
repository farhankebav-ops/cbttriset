package f2;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11311a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f11314d;

    public b(i4.d dVar, int i2, boolean z2) {
        r2.q.D(dVar, "callOptions");
        this.f11314d = dVar;
        this.f11312b = i2;
        this.f11313c = z2;
    }

    public static int d(int i2, int i8) {
        if (i8 < 0) {
            throw new IllegalArgumentException("cannot store more than Integer.MAX_VALUE elements");
        }
        if (i8 <= i2) {
            return i2;
        }
        int iHighestOneBit = i2 + (i2 >> 1) + 1;
        if (iHighestOneBit < i8) {
            iHighestOneBit = Integer.highestOneBit(i8 - 1) << 1;
        }
        if (iHighestOneBit < 0) {
            return Integer.MAX_VALUE;
        }
        return iHighestOneBit;
    }

    public void a(Object obj) {
        obj.getClass();
        c(1);
        Object[] objArr = (Object[]) this.f11314d;
        int i2 = this.f11312b;
        this.f11312b = i2 + 1;
        objArr[i2] = obj;
    }

    public void b(Object... objArr) {
        int length = objArr.length;
        r2.q.B(length, objArr);
        c(length);
        System.arraycopy(objArr, 0, (Object[]) this.f11314d, this.f11312b, length);
        this.f11312b += length;
    }

    public void c(int i2) {
        Object[] objArr = (Object[]) this.f11314d;
        int iD = d(objArr.length, this.f11312b + i2);
        if (iD > objArr.length || this.f11313c) {
            this.f11314d = Arrays.copyOf((Object[]) this.f11314d, iD);
            this.f11313c = false;
        }
    }

    public String toString() {
        switch (this.f11311a) {
            case 1:
                e2.i iVarY = a.a.Y(this);
                iVarY.c((i4.d) this.f11314d, "callOptions");
                iVarY.f("previousAttempts", String.valueOf(this.f11312b));
                iVarY.e("isTransparentRetry", this.f11313c);
                return iVarY.toString();
            default:
                return super.toString();
        }
    }

    public b() {
        a.a.o(4, "initialCapacity");
        this.f11314d = new Object[4];
        this.f11312b = 0;
    }
}
