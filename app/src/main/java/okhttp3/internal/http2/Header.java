package okhttp3.internal.http2;

import kotlin.jvm.internal.k;
import l7.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class Header {
    public static final Companion Companion = new Companion(null);
    public static final m PSEUDO_PREFIX;
    public static final m RESPONSE_STATUS;
    public static final String RESPONSE_STATUS_UTF8 = ":status";
    public static final m TARGET_AUTHORITY;
    public static final String TARGET_AUTHORITY_UTF8 = ":authority";
    public static final m TARGET_METHOD;
    public static final String TARGET_METHOD_UTF8 = ":method";
    public static final m TARGET_PATH;
    public static final String TARGET_PATH_UTF8 = ":path";
    public static final m TARGET_SCHEME;
    public static final String TARGET_SCHEME_UTF8 = ":scheme";
    public final int hpackSize;
    public final m name;
    public final m value;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        private Companion() {
        }
    }

    static {
        m mVar = m.f12880d;
        PSEUDO_PREFIX = r4.c.e(":");
        RESPONSE_STATUS = r4.c.e(RESPONSE_STATUS_UTF8);
        TARGET_METHOD = r4.c.e(TARGET_METHOD_UTF8);
        TARGET_PATH = r4.c.e(TARGET_PATH_UTF8);
        TARGET_SCHEME = r4.c.e(TARGET_SCHEME_UTF8);
        TARGET_AUTHORITY = r4.c.e(TARGET_AUTHORITY_UTF8);
    }

    public Header(m name, m value) {
        k.e(name, "name");
        k.e(value, "value");
        this.name = name;
        this.value = value;
        this.hpackSize = value.d() + name.d() + 32;
    }

    public static /* synthetic */ Header copy$default(Header header, m mVar, m mVar2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            mVar = header.name;
        }
        if ((i2 & 2) != 0) {
            mVar2 = header.value;
        }
        return header.copy(mVar, mVar2);
    }

    public final m component1() {
        return this.name;
    }

    public final m component2() {
        return this.value;
    }

    public final Header copy(m name, m value) {
        k.e(name, "name");
        k.e(value, "value");
        return new Header(name, value);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return k.a(this.name, header.name) && k.a(this.value, header.value);
    }

    public int hashCode() {
        return this.value.hashCode() + (this.name.hashCode() * 31);
    }

    public String toString() {
        return this.name.t() + ": " + this.value.t();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Header(String name, String value) {
        this(r4.c.e(name), r4.c.e(value));
        k.e(name, "name");
        k.e(value, "value");
        m mVar = m.f12880d;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Header(m name, String value) {
        this(name, r4.c.e(value));
        k.e(name, "name");
        k.e(value, "value");
        m mVar = m.f12880d;
    }
}
