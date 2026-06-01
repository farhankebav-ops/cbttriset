package com.unity3d.ads.core.data.model;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class CacheResult {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Failure extends CacheResult {
        private final CacheError error;
        private final Throwable reason;
        private final CacheSource source;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(CacheError error, CacheSource source, Throwable th) {
            super(null);
            k.e(error, "error");
            k.e(source, "source");
            this.error = error;
            this.source = source;
            this.reason = th;
        }

        public static /* synthetic */ Failure copy$default(Failure failure, CacheError cacheError, CacheSource cacheSource, Throwable th, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                cacheError = failure.error;
            }
            if ((i2 & 2) != 0) {
                cacheSource = failure.source;
            }
            if ((i2 & 4) != 0) {
                th = failure.reason;
            }
            return failure.copy(cacheError, cacheSource, th);
        }

        public final CacheError component1() {
            return this.error;
        }

        public final CacheSource component2() {
            return this.source;
        }

        public final Throwable component3() {
            return this.reason;
        }

        public final Failure copy(CacheError error, CacheSource source, Throwable th) {
            k.e(error, "error");
            k.e(source, "source");
            return new Failure(error, source, th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Failure)) {
                return false;
            }
            Failure failure = (Failure) obj;
            return this.error == failure.error && this.source == failure.source && k.a(this.reason, failure.reason);
        }

        public final CacheError getError() {
            return this.error;
        }

        public final Throwable getReason() {
            return this.reason;
        }

        public final CacheSource getSource() {
            return this.source;
        }

        public int hashCode() {
            int iHashCode = (this.source.hashCode() + (this.error.hashCode() * 31)) * 31;
            Throwable th = this.reason;
            return iHashCode + (th == null ? 0 : th.hashCode());
        }

        public String toString() {
            return "Failure(error=" + this.error + ", source=" + this.source + ", reason=" + this.reason + ')';
        }

        public /* synthetic */ Failure(CacheError cacheError, CacheSource cacheSource, Throwable th, int i2, f fVar) {
            this(cacheError, (i2 & 2) != 0 ? CacheSource.LOCAL : cacheSource, (i2 & 4) != 0 ? null : th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Success extends CacheResult {
        private final CachedFile cachedFile;
        private final CacheSource source;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(CachedFile cachedFile, CacheSource source) {
            super(null);
            k.e(cachedFile, "cachedFile");
            k.e(source, "source");
            this.cachedFile = cachedFile;
            this.source = source;
        }

        public static /* synthetic */ Success copy$default(Success success, CachedFile cachedFile, CacheSource cacheSource, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                cachedFile = success.cachedFile;
            }
            if ((i2 & 2) != 0) {
                cacheSource = success.source;
            }
            return success.copy(cachedFile, cacheSource);
        }

        public final CachedFile component1() {
            return this.cachedFile;
        }

        public final CacheSource component2() {
            return this.source;
        }

        public final Success copy(CachedFile cachedFile, CacheSource source) {
            k.e(cachedFile, "cachedFile");
            k.e(source, "source");
            return new Success(cachedFile, source);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Success)) {
                return false;
            }
            Success success = (Success) obj;
            return k.a(this.cachedFile, success.cachedFile) && this.source == success.source;
        }

        public final CachedFile getCachedFile() {
            return this.cachedFile;
        }

        public final CacheSource getSource() {
            return this.source;
        }

        public int hashCode() {
            return this.source.hashCode() + (this.cachedFile.hashCode() * 31);
        }

        public String toString() {
            return "Success(cachedFile=" + this.cachedFile + ", source=" + this.source + ')';
        }
    }

    public /* synthetic */ CacheResult(f fVar) {
        this();
    }

    private CacheResult() {
    }
}
