package m4;

import com.ironsource.mediationsdk.logger.IronSourceError;
import l7.m;
import okhttp3.internal.http2.Header;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f12932d;
    public static final m e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final m f12933f;
    public static final m g;
    public static final m h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f12934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f12935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12936c;

    static {
        m mVar = m.f12880d;
        f12932d = r4.c.e(Header.RESPONSE_STATUS_UTF8);
        e = r4.c.e(Header.TARGET_METHOD_UTF8);
        f12933f = r4.c.e(Header.TARGET_PATH_UTF8);
        g = r4.c.e(Header.TARGET_SCHEME_UTF8);
        h = r4.c.e(Header.TARGET_AUTHORITY_UTF8);
        r4.c.e(":host");
        r4.c.e(":version");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(String str, String str2) {
        this(r4.c.e(str), r4.c.e(str2));
        m mVar = m.f12880d;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f12934a.equals(bVar.f12934a) && this.f12935b.equals(bVar.f12935b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f12935b.hashCode() + ((this.f12934a.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31);
    }

    public final String toString() {
        return a1.a.D(this.f12934a.t(), ": ", this.f12935b.t());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(m mVar, String str) {
        this(mVar, r4.c.e(str));
        m mVar2 = m.f12880d;
    }

    public b(m mVar, m mVar2) {
        this.f12934a = mVar;
        this.f12935b = mVar2;
        this.f12936c = mVar2.d() + mVar.d() + 32;
    }
}
