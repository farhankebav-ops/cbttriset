package com.unity3d.ads.core.data.model;

import androidx.camera.core.processing.util.a;
import com.unity3d.ads.UnityAds;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class LoadResult {
    public static final Companion Companion = new Companion(null);
    public static final String MSG_AD_MARKUP_PARSING = "[UnityAds] Could not parse Ad Markup";
    public static final String MSG_AD_OBJECT = "[UnityAds] Ad not found";
    public static final String MSG_COMMUNICATION_FAILURE = "[UnityAds] Internal communication failure";
    public static final String MSG_COMMUNICATION_FAILURE_WITH_DETAILS = "[UnityAds] Internal communication failure: %s";
    public static final String MSG_COMMUNICATION_TIMEOUT = "[UnityAds] Internal communication timeout";
    public static final String MSG_CREATE_REQUEST = "[UnityAds] Failed to create load request";
    public static final String MSG_INIT_FAILED = "[UnityAds] SDK Initialization Failed";
    public static final String MSG_INIT_FAILURE = "[UnityAds] SDK Initialization Failure";
    public static final String MSG_NOT_INITIALIZED = "[UnityAds] SDK not initialized";
    public static final String MSG_NO_FILL = "[UnityAds] No fill";
    public static final String MSG_OPPORTUNITY_ID_USED = "[UnityAds] Object ID already used";
    public static final String MSG_PLACEMENT_NULL = "[UnityAds] Placement ID cannot be null";
    public static final String MSG_TIMEOUT = "[UnityAds] Timeout while loading ";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Failure extends LoadResult {
        private final UnityAds.UnityAdsLoadError error;
        private final boolean isScarAd;
        private final String message;
        private final String reason;
        private final String reasonDebug;
        private final Throwable throwable;

        public /* synthetic */ Failure(UnityAds.UnityAdsLoadError unityAdsLoadError, String str, Throwable th, String str2, String str3, boolean z2, int i2, f fVar) {
            this(unityAdsLoadError, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : th, str2, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? false : z2);
        }

        public static /* synthetic */ Failure copy$default(Failure failure, UnityAds.UnityAdsLoadError unityAdsLoadError, String str, Throwable th, String str2, String str3, boolean z2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                unityAdsLoadError = failure.error;
            }
            if ((i2 & 2) != 0) {
                str = failure.message;
            }
            if ((i2 & 4) != 0) {
                th = failure.throwable;
            }
            if ((i2 & 8) != 0) {
                str2 = failure.reason;
            }
            if ((i2 & 16) != 0) {
                str3 = failure.reasonDebug;
            }
            if ((i2 & 32) != 0) {
                z2 = failure.isScarAd;
            }
            String str4 = str3;
            boolean z7 = z2;
            return failure.copy(unityAdsLoadError, str, th, str2, str4, z7);
        }

        public final UnityAds.UnityAdsLoadError component1() {
            return this.error;
        }

        public final String component2() {
            return this.message;
        }

        public final Throwable component3() {
            return this.throwable;
        }

        public final String component4() {
            return this.reason;
        }

        public final String component5() {
            return this.reasonDebug;
        }

        public final boolean component6() {
            return this.isScarAd;
        }

        public final Failure copy(UnityAds.UnityAdsLoadError error, String str, Throwable th, String reason, String str2, boolean z2) {
            k.e(error, "error");
            k.e(reason, "reason");
            return new Failure(error, str, th, reason, str2, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Failure)) {
                return false;
            }
            Failure failure = (Failure) obj;
            return this.error == failure.error && k.a(this.message, failure.message) && k.a(this.throwable, failure.throwable) && k.a(this.reason, failure.reason) && k.a(this.reasonDebug, failure.reasonDebug) && this.isScarAd == failure.isScarAd;
        }

        public final UnityAds.UnityAdsLoadError getError() {
            return this.error;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getReason() {
            return this.reason;
        }

        public final String getReasonDebug() {
            return this.reasonDebug;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        public int hashCode() {
            int iHashCode = this.error.hashCode() * 31;
            String str = this.message;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Throwable th = this.throwable;
            int iB = a.b((iHashCode2 + (th == null ? 0 : th.hashCode())) * 31, 31, this.reason);
            String str2 = this.reasonDebug;
            int iHashCode3 = (iB + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z2 = this.isScarAd;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode3 + r1;
        }

        public final boolean isScarAd() {
            return this.isScarAd;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Failure(error=");
            sb.append(this.error);
            sb.append(", message=");
            sb.append(this.message);
            sb.append(", throwable=");
            sb.append(this.throwable);
            sb.append(", reason=");
            sb.append(this.reason);
            sb.append(", reasonDebug=");
            sb.append(this.reasonDebug);
            sb.append(", isScarAd=");
            return a1.a.t(sb, this.isScarAd, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(UnityAds.UnityAdsLoadError error, String str, Throwable th, String reason, String str2, boolean z2) {
            super(null);
            k.e(error, "error");
            k.e(reason, "reason");
            this.error = error;
            this.message = str;
            this.throwable = th;
            this.reason = reason;
            this.reasonDebug = str2;
            this.isScarAd = z2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Success extends LoadResult {
        private final AdObject adObject;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(AdObject adObject) {
            super(null);
            k.e(adObject, "adObject");
            this.adObject = adObject;
        }

        public static /* synthetic */ Success copy$default(Success success, AdObject adObject, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                adObject = success.adObject;
            }
            return success.copy(adObject);
        }

        public final AdObject component1() {
            return this.adObject;
        }

        public final Success copy(AdObject adObject) {
            k.e(adObject, "adObject");
            return new Success(adObject);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && k.a(this.adObject, ((Success) obj).adObject);
        }

        public final AdObject getAdObject() {
            return this.adObject;
        }

        public int hashCode() {
            return this.adObject.hashCode();
        }

        public String toString() {
            return "Success(adObject=" + this.adObject + ')';
        }
    }

    public /* synthetic */ LoadResult(f fVar) {
        this();
    }

    private LoadResult() {
    }
}
