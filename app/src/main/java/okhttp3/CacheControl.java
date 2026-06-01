package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import okhttp3.internal._CacheControlCommonKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CacheControl {
    public static final Companion Companion;
    public static final CacheControl FORCE_CACHE;
    public static final CacheControl FORCE_NETWORK;
    private String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {
        private boolean immutable;
        private int maxAgeSeconds = -1;
        private int maxStaleSeconds = -1;
        private int minFreshSeconds = -1;
        private boolean noCache;
        private boolean noStore;
        private boolean noTransform;
        private boolean onlyIfCached;

        public final CacheControl build() {
            return _CacheControlCommonKt.commonBuild(this);
        }

        public final boolean getImmutable$okhttp() {
            return this.immutable;
        }

        public final int getMaxAgeSeconds$okhttp() {
            return this.maxAgeSeconds;
        }

        public final int getMaxStaleSeconds$okhttp() {
            return this.maxStaleSeconds;
        }

        public final int getMinFreshSeconds$okhttp() {
            return this.minFreshSeconds;
        }

        public final boolean getNoCache$okhttp() {
            return this.noCache;
        }

        public final boolean getNoStore$okhttp() {
            return this.noStore;
        }

        public final boolean getNoTransform$okhttp() {
            return this.noTransform;
        }

        public final boolean getOnlyIfCached$okhttp() {
            return this.onlyIfCached;
        }

        public final Builder immutable() {
            return _CacheControlCommonKt.commonImmutable(this);
        }

        public final Builder maxAge(int i2, TimeUnit timeUnit) {
            k.e(timeUnit, "timeUnit");
            if (i2 < 0) {
                throw new IllegalArgumentException(a1.a.g(i2, "maxAge < 0: ").toString());
            }
            this.maxAgeSeconds = _CacheControlCommonKt.commonClampToInt(timeUnit.toSeconds(i2));
            return this;
        }

        /* JADX INFO: renamed from: maxAge-LRDsOJo, reason: not valid java name */
        public final Builder m3479maxAgeLRDsOJo(long j) {
            int i2 = o6.a.f13207d;
            long jI = o6.a.i(j, o6.c.f13212d);
            if (jI < 0) {
                throw new IllegalArgumentException(androidx.camera.core.processing.util.a.j("maxAge < 0: ", jI).toString());
            }
            this.maxAgeSeconds = _CacheControlCommonKt.commonClampToInt(jI);
            return this;
        }

        public final Builder maxStale(int i2, TimeUnit timeUnit) {
            k.e(timeUnit, "timeUnit");
            if (i2 < 0) {
                throw new IllegalArgumentException(a1.a.g(i2, "maxStale < 0: ").toString());
            }
            this.maxStaleSeconds = _CacheControlCommonKt.commonClampToInt(timeUnit.toSeconds(i2));
            return this;
        }

        /* JADX INFO: renamed from: maxStale-LRDsOJo, reason: not valid java name */
        public final Builder m3480maxStaleLRDsOJo(long j) {
            int i2 = o6.a.f13207d;
            long jI = o6.a.i(j, o6.c.f13212d);
            if (jI < 0) {
                throw new IllegalArgumentException(androidx.camera.core.processing.util.a.j("maxStale < 0: ", jI).toString());
            }
            this.maxStaleSeconds = _CacheControlCommonKt.commonClampToInt(jI);
            return this;
        }

        public final Builder minFresh(int i2, TimeUnit timeUnit) {
            k.e(timeUnit, "timeUnit");
            if (i2 < 0) {
                throw new IllegalArgumentException(a1.a.g(i2, "minFresh < 0: ").toString());
            }
            this.minFreshSeconds = _CacheControlCommonKt.commonClampToInt(timeUnit.toSeconds(i2));
            return this;
        }

        /* JADX INFO: renamed from: minFresh-LRDsOJo, reason: not valid java name */
        public final Builder m3481minFreshLRDsOJo(long j) {
            int i2 = o6.a.f13207d;
            long jI = o6.a.i(j, o6.c.f13212d);
            if (jI < 0) {
                throw new IllegalArgumentException(androidx.camera.core.processing.util.a.j("minFresh < 0: ", jI).toString());
            }
            this.minFreshSeconds = _CacheControlCommonKt.commonClampToInt(jI);
            return this;
        }

        public final Builder noCache() {
            return _CacheControlCommonKt.commonNoCache(this);
        }

        public final Builder noStore() {
            return _CacheControlCommonKt.commonNoStore(this);
        }

        public final Builder noTransform() {
            return _CacheControlCommonKt.commonNoTransform(this);
        }

        public final Builder onlyIfCached() {
            return _CacheControlCommonKt.commonOnlyIfCached(this);
        }

        public final void setImmutable$okhttp(boolean z2) {
            this.immutable = z2;
        }

        public final void setMaxAgeSeconds$okhttp(int i2) {
            this.maxAgeSeconds = i2;
        }

        public final void setMaxStaleSeconds$okhttp(int i2) {
            this.maxStaleSeconds = i2;
        }

        public final void setMinFreshSeconds$okhttp(int i2) {
            this.minFreshSeconds = i2;
        }

        public final void setNoCache$okhttp(boolean z2) {
            this.noCache = z2;
        }

        public final void setNoStore$okhttp(boolean z2) {
            this.noStore = z2;
        }

        public final void setNoTransform$okhttp(boolean z2) {
            this.noTransform = z2;
        }

        public final void setOnlyIfCached$okhttp(boolean z2) {
            this.onlyIfCached = z2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final CacheControl parse(Headers headers) {
            k.e(headers, "headers");
            return _CacheControlCommonKt.commonParse(this, headers);
        }

        private Companion() {
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        FORCE_NETWORK = _CacheControlCommonKt.commonForceNetwork(companion);
        FORCE_CACHE = _CacheControlCommonKt.commonForceCache(companion);
    }

    public CacheControl(boolean z2, boolean z7, int i2, int i8, boolean z8, boolean z9, boolean z10, int i9, int i10, boolean z11, boolean z12, boolean z13, String str) {
        this.noCache = z2;
        this.noStore = z7;
        this.maxAgeSeconds = i2;
        this.sMaxAgeSeconds = i8;
        this.isPrivate = z8;
        this.isPublic = z9;
        this.mustRevalidate = z10;
        this.maxStaleSeconds = i9;
        this.minFreshSeconds = i10;
        this.onlyIfCached = z11;
        this.noTransform = z12;
        this.immutable = z13;
        this.headerValue = str;
    }

    public static final CacheControl parse(Headers headers) {
        return Companion.parse(headers);
    }

    /* JADX INFO: renamed from: -deprecated_immutable, reason: not valid java name */
    public final boolean m3469deprecated_immutable() {
        return this.immutable;
    }

    /* JADX INFO: renamed from: -deprecated_maxAgeSeconds, reason: not valid java name */
    public final int m3470deprecated_maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    /* JADX INFO: renamed from: -deprecated_maxStaleSeconds, reason: not valid java name */
    public final int m3471deprecated_maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    /* JADX INFO: renamed from: -deprecated_minFreshSeconds, reason: not valid java name */
    public final int m3472deprecated_minFreshSeconds() {
        return this.minFreshSeconds;
    }

    /* JADX INFO: renamed from: -deprecated_mustRevalidate, reason: not valid java name */
    public final boolean m3473deprecated_mustRevalidate() {
        return this.mustRevalidate;
    }

    /* JADX INFO: renamed from: -deprecated_noCache, reason: not valid java name */
    public final boolean m3474deprecated_noCache() {
        return this.noCache;
    }

    /* JADX INFO: renamed from: -deprecated_noStore, reason: not valid java name */
    public final boolean m3475deprecated_noStore() {
        return this.noStore;
    }

    /* JADX INFO: renamed from: -deprecated_noTransform, reason: not valid java name */
    public final boolean m3476deprecated_noTransform() {
        return this.noTransform;
    }

    /* JADX INFO: renamed from: -deprecated_onlyIfCached, reason: not valid java name */
    public final boolean m3477deprecated_onlyIfCached() {
        return this.onlyIfCached;
    }

    /* JADX INFO: renamed from: -deprecated_sMaxAgeSeconds, reason: not valid java name */
    public final int m3478deprecated_sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public final String getHeaderValue$okhttp() {
        return this.headerValue;
    }

    public final boolean immutable() {
        return this.immutable;
    }

    public final boolean isPrivate() {
        return this.isPrivate;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public final boolean noCache() {
        return this.noCache;
    }

    public final boolean noStore() {
        return this.noStore;
    }

    public final boolean noTransform() {
        return this.noTransform;
    }

    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public final void setHeaderValue$okhttp(String str) {
        this.headerValue = str;
    }

    public String toString() {
        return _CacheControlCommonKt.commonToString(this);
    }
}
