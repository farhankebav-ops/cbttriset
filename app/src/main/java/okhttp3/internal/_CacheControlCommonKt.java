package okhttp3.internal;

import kotlin.jvm.internal.k;
import n6.m;
import o6.a;
import o6.c;
import okhttp3.CacheControl;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class _CacheControlCommonKt {
    public static final CacheControl commonBuild(CacheControl.Builder builder) {
        k.e(builder, "<this>");
        return new CacheControl(builder.getNoCache$okhttp(), builder.getNoStore$okhttp(), builder.getMaxAgeSeconds$okhttp(), -1, false, false, false, builder.getMaxStaleSeconds$okhttp(), builder.getMinFreshSeconds$okhttp(), builder.getOnlyIfCached$okhttp(), builder.getNoTransform$okhttp(), builder.getImmutable$okhttp(), null);
    }

    public static final int commonClampToInt(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j;
    }

    public static final CacheControl commonForceCache(CacheControl.Companion companion) {
        k.e(companion, "<this>");
        CacheControl.Builder builderOnlyIfCached = new CacheControl.Builder().onlyIfCached();
        int i2 = a.f13207d;
        return builderOnlyIfCached.m3480maxStaleLRDsOJo(q.A0(Integer.MAX_VALUE, c.f13212d)).build();
    }

    public static final CacheControl commonForceNetwork(CacheControl.Companion companion) {
        k.e(companion, "<this>");
        return new CacheControl.Builder().noCache().build();
    }

    public static final CacheControl.Builder commonImmutable(CacheControl.Builder builder) {
        k.e(builder, "<this>");
        builder.setImmutable$okhttp(true);
        return builder;
    }

    public static final CacheControl.Builder commonNoCache(CacheControl.Builder builder) {
        k.e(builder, "<this>");
        builder.setNoCache$okhttp(true);
        return builder;
    }

    public static final CacheControl.Builder commonNoStore(CacheControl.Builder builder) {
        k.e(builder, "<this>");
        builder.setNoStore$okhttp(true);
        return builder;
    }

    public static final CacheControl.Builder commonNoTransform(CacheControl.Builder builder) {
        k.e(builder, "<this>");
        builder.setNoTransform$okhttp(true);
        return builder;
    }

    public static final CacheControl.Builder commonOnlyIfCached(CacheControl.Builder builder) {
        k.e(builder, "<this>");
        builder.setOnlyIfCached$okhttp(true);
        return builder;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final okhttp3.CacheControl commonParse(okhttp3.CacheControl.Companion r23, okhttp3.Headers r24) {
        /*
            Method dump skipped, instruction units count: 397
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal._CacheControlCommonKt.commonParse(okhttp3.CacheControl$Companion, okhttp3.Headers):okhttp3.CacheControl");
    }

    public static final String commonToString(CacheControl cacheControl) {
        k.e(cacheControl, "<this>");
        String headerValue$okhttp = cacheControl.getHeaderValue$okhttp();
        if (headerValue$okhttp != null) {
            return headerValue$okhttp;
        }
        StringBuilder sb = new StringBuilder();
        if (cacheControl.noCache()) {
            sb.append("no-cache, ");
        }
        if (cacheControl.noStore()) {
            sb.append("no-store, ");
        }
        if (cacheControl.maxAgeSeconds() != -1) {
            sb.append("max-age=");
            sb.append(cacheControl.maxAgeSeconds());
            sb.append(", ");
        }
        if (cacheControl.sMaxAgeSeconds() != -1) {
            sb.append("s-maxage=");
            sb.append(cacheControl.sMaxAgeSeconds());
            sb.append(", ");
        }
        if (cacheControl.isPrivate()) {
            sb.append("private, ");
        }
        if (cacheControl.isPublic()) {
            sb.append("public, ");
        }
        if (cacheControl.mustRevalidate()) {
            sb.append("must-revalidate, ");
        }
        if (cacheControl.maxStaleSeconds() != -1) {
            sb.append("max-stale=");
            sb.append(cacheControl.maxStaleSeconds());
            sb.append(", ");
        }
        if (cacheControl.minFreshSeconds() != -1) {
            sb.append("min-fresh=");
            sb.append(cacheControl.minFreshSeconds());
            sb.append(", ");
        }
        if (cacheControl.onlyIfCached()) {
            sb.append("only-if-cached, ");
        }
        if (cacheControl.noTransform()) {
            sb.append("no-transform, ");
        }
        if (cacheControl.immutable()) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        k.d(sb.delete(sb.length() - 2, sb.length()), "delete(...)");
        String string = sb.toString();
        cacheControl.setHeaderValue$okhttp(string);
        return string;
    }

    private static final int indexOfElement(String str, String str2, int i2) {
        int length = str.length();
        while (i2 < length) {
            if (m.r0(str2, str.charAt(i2))) {
                return i2;
            }
            i2++;
        }
        return str.length();
    }

    public static /* synthetic */ int indexOfElement$default(String str, String str2, int i2, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i2 = 0;
        }
        return indexOfElement(str, str2, i2);
    }
}
