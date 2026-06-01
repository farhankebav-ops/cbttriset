package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.util.LogEntry;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class VungleError extends Exception {
    private final int code;
    private final String errorMessage;
    private LogEntry logEntry;
    private final Sdk.SDKError.Reason loggableReason;

    public /* synthetic */ VungleError(Sdk.SDKError.Reason reason, String str, f fVar) {
        this(reason, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getClass().equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        k.c(obj, "null cannot be cast to non-null type com.vungle.ads.VungleError");
        VungleError vungleError = (VungleError) obj;
        return this.loggableReason == vungleError.loggableReason && k.a(this.errorMessage, vungleError.errorMessage) && k.a(this.logEntry, vungleError.logEntry);
    }

    public final int getCode() {
        return this.code;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return this.errorMessage;
    }

    public int hashCode() {
        int iB = androidx.camera.core.processing.util.a.b(this.loggableReason.hashCode() * 31, 31, this.errorMessage);
        LogEntry logEntry = this.logEntry;
        return iB + (logEntry != null ? logEntry.hashCode() : 0);
    }

    public final VungleError logError$vungle_ads_release() {
        logErrorNoReturnValue$vungle_ads_release();
        return this;
    }

    public final void logErrorNoReturnValue$vungle_ads_release() {
        AnalyticsClient.INSTANCE.logError$vungle_ads_release(this.loggableReason, this.errorMessage, this.logEntry);
    }

    public final VungleError setLogEntry$vungle_ads_release(LogEntry logEntry) {
        this.logEntry = logEntry;
        return this;
    }

    private VungleError(Sdk.SDKError.Reason reason, String str) {
        super(str);
        this.loggableReason = reason;
        this.errorMessage = str;
        this.code = reason.getNumber();
    }
}
