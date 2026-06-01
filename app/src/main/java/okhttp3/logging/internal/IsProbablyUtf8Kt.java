package okhttp3.logging.internal;

import java.io.EOFException;
import kotlin.jvm.internal.k;
import l7.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class IsProbablyUtf8Kt {
    public static final boolean isProbablyUtf8(j jVar) {
        j jVar2;
        int i2;
        k.e(jVar, "<this>");
        try {
            jVar2 = new j();
            long j = jVar.f12868b;
            long j3 = 64;
            if (j <= 64) {
                j3 = j;
            }
            jVar.g(0L, jVar2, j3);
        } catch (EOFException unused) {
        }
        for (i2 = 0; i2 < 16; i2++) {
            if (jVar2.M()) {
                return true;
            }
            int iS = jVar2.s();
            if (Character.isISOControl(iS) && !Character.isWhitespace(iS)) {
                return false;
            }
        }
        return true;
    }
}
