package m7;

import java.io.IOException;
import l7.o0;
import l7.w;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f13013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f13014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f13015c;

    public h(o0 o0Var, long j, boolean z2) {
        super(o0Var);
        this.f13013a = j;
        this.f13014b = z2;
    }

    @Override // l7.w, l7.o0
    public final long read(l7.j sink, long j) throws IOException {
        kotlin.jvm.internal.k.e(sink, "sink");
        long j3 = this.f13015c;
        long j8 = this.f13013a;
        if (j3 > j8) {
            j = 0;
        } else if (this.f13014b) {
            long j9 = j8 - j3;
            if (j9 == 0) {
                return -1L;
            }
            j = Math.min(j, j9);
        }
        long j10 = super.read(sink, j);
        if (j10 != -1) {
            this.f13015c += j10;
        }
        long j11 = this.f13015c;
        if ((j11 >= j8 || j10 != -1) && j11 <= j8) {
            return j10;
        }
        if (j10 > 0 && j11 > j8) {
            long j12 = sink.f12868b - (j11 - j8);
            l7.j jVar = new l7.j();
            jVar.H(sink);
            sink.write(jVar, j12);
            jVar.a();
        }
        StringBuilder sbT = androidx.camera.core.processing.util.a.t("expected ", j8, " bytes but got ");
        sbT.append(this.f13015c);
        throw new IOException(sbT.toString());
    }
}
