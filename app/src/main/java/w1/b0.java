package w1;

import android.util.StateSet;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o f17687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[][] f17688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public o[] f17689d;
    public a0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a0 f17690f;
    public a0 g;
    public a0 h;

    public b0(o oVar) {
        b();
        a(StateSet.WILD_CARD, oVar);
    }

    public final void a(int[] iArr, o oVar) {
        int i2 = this.f17686a;
        if (i2 == 0 || iArr.length == 0) {
            this.f17687b = oVar;
        }
        int[][] iArr2 = this.f17688c;
        if (i2 >= iArr2.length) {
            int i8 = i2 + 10;
            int[][] iArr3 = new int[i8][];
            System.arraycopy(iArr2, 0, iArr3, 0, i2);
            this.f17688c = iArr3;
            o[] oVarArr = new o[i8];
            System.arraycopy(this.f17689d, 0, oVarArr, 0, i2);
            this.f17689d = oVarArr;
        }
        int[][] iArr4 = this.f17688c;
        int i9 = this.f17686a;
        iArr4[i9] = iArr;
        this.f17689d[i9] = oVar;
        this.f17686a = i9 + 1;
    }

    public final void b() {
        this.f17687b = new o();
        this.f17688c = new int[10][];
        this.f17689d = new o[10];
    }
}
