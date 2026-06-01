package j4;

import java.io.OutputStream;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b3 extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f12130a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k4.u f12131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d3 f12132c;

    public b3(d3 d3Var) {
        this.f12132c = d3Var;
    }

    @Override // java.io.OutputStream
    public final void write(int i2) {
        k4.u uVar = this.f12131b;
        if (uVar == null || uVar.f12689b <= 0) {
            write(new byte[]{(byte) i2}, 0, 1);
            return;
        }
        uVar.f12688a.x((byte) i2);
        uVar.f12689b--;
        uVar.f12690c++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i2, int i8) {
        w1.f fVar = this.f12132c.g;
        k4.u uVar = this.f12131b;
        ArrayList arrayList = this.f12130a;
        if (uVar == null) {
            fVar.getClass();
            k4.u uVarB = w1.f.b(i8);
            this.f12131b = uVarB;
            arrayList.add(uVarB);
        }
        while (i8 > 0) {
            int iMin = Math.min(i8, this.f12131b.f12689b);
            if (iMin == 0) {
                int iMax = Math.max(i8, this.f12131b.f12690c * 2);
                fVar.getClass();
                k4.u uVarB2 = w1.f.b(iMax);
                this.f12131b = uVarB2;
                arrayList.add(uVarB2);
            } else {
                this.f12131b.a(bArr, i2, iMin);
                i2 += iMin;
                i8 -= iMin;
            }
        }
    }
}
