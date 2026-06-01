package m7;

import e6.p;
import java.io.IOException;
import kotlin.jvm.internal.a0;
import l7.j0;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class l implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13030a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a0 f13031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j0 f13032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a0 f13033d;
    public final /* synthetic */ a0 e;

    public /* synthetic */ l(a0 a0Var, j0 j0Var, a0 a0Var2, a0 a0Var3) {
        this.f13031b = a0Var;
        this.f13032c = j0Var;
        this.f13033d = a0Var2;
        this.e = a0Var3;
    }

    @Override // e6.p
    public final Object invoke(Object obj, Object obj2) throws IOException {
        int i2 = this.f13030a;
        int iIntValue = ((Integer) obj).intValue();
        Long l = (Long) obj2;
        switch (i2) {
            case 0:
                long jLongValue = l.longValue();
                if (iIntValue == 21589) {
                    if (jLongValue < 1) {
                        throw new IOException("bad zip: extended timestamp extra too short");
                    }
                    j0 j0Var = this.f13032c;
                    byte b8 = j0Var.readByte();
                    boolean z2 = (b8 & 1) == 1;
                    boolean z7 = (b8 & 2) == 2;
                    boolean z8 = (b8 & 4) == 4;
                    long j = z2 ? 5L : 1L;
                    if (z7) {
                        j += 4;
                    }
                    if (z8) {
                        j += 4;
                    }
                    if (jLongValue < j) {
                        throw new IOException("bad zip: extended timestamp extra too short");
                    }
                    if (z2) {
                        this.f13031b.f12717a = Integer.valueOf(j0Var.b());
                    }
                    if (z7) {
                        this.f13033d.f12717a = Integer.valueOf(j0Var.b());
                    }
                    if (z8) {
                        this.e.f12717a = Integer.valueOf(j0Var.b());
                    }
                }
                return x.f13520a;
            default:
                long jLongValue2 = l.longValue();
                if (iIntValue == 1) {
                    a0 a0Var = this.f13031b;
                    if (a0Var.f12717a != null) {
                        throw new IOException("bad zip: NTFS extra attribute tag 0x0001 repeated");
                    }
                    if (jLongValue2 != 24) {
                        throw new IOException("bad zip: NTFS extra attribute tag 0x0001 size != 24");
                    }
                    j0 j0Var2 = this.f13032c;
                    a0Var.f12717a = Long.valueOf(j0Var2.e());
                    this.f13033d.f12717a = Long.valueOf(j0Var2.e());
                    this.e.f12717a = Long.valueOf(j0Var2.e());
                }
                return x.f13520a;
        }
    }

    public /* synthetic */ l(j0 j0Var, a0 a0Var, a0 a0Var2, a0 a0Var3) {
        this.f13032c = j0Var;
        this.f13031b = a0Var;
        this.f13033d = a0Var2;
        this.e = a0Var3;
    }
}
