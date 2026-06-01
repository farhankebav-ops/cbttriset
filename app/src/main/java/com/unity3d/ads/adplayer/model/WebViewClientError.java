package com.unity3d.ads.adplayer.model;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class WebViewClientError {
    private final ErrorReason reason;
    private final Integer statusCode;
    private final String url;

    public WebViewClientError(String str, ErrorReason reason, Integer num) {
        k.e(reason, "reason");
        this.url = str;
        this.reason = reason;
        this.statusCode = num;
    }

    public static /* synthetic */ WebViewClientError copy$default(WebViewClientError webViewClientError, String str, ErrorReason errorReason, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = webViewClientError.url;
        }
        if ((i2 & 2) != 0) {
            errorReason = webViewClientError.reason;
        }
        if ((i2 & 4) != 0) {
            num = webViewClientError.statusCode;
        }
        return webViewClientError.copy(str, errorReason, num);
    }

    public final String component1() {
        return this.url;
    }

    public final ErrorReason component2() {
        return this.reason;
    }

    public final Integer component3() {
        return this.statusCode;
    }

    public final WebViewClientError copy(String str, ErrorReason reason, Integer num) {
        k.e(reason, "reason");
        return new WebViewClientError(str, reason, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebViewClientError)) {
            return false;
        }
        WebViewClientError webViewClientError = (WebViewClientError) obj;
        return k.a(this.url, webViewClientError.url) && this.reason == webViewClientError.reason && k.a(this.statusCode, webViewClientError.statusCode);
    }

    public final ErrorReason getReason() {
        return this.reason;
    }

    public final Integer getStatusCode() {
        return this.statusCode;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.url;
        int iHashCode = (this.reason.hashCode() + ((str == null ? 0 : str.hashCode()) * 31)) * 31;
        Integer num = this.statusCode;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "WebViewClientError(url=" + this.url + ", reason=" + this.reason + ", statusCode=" + this.statusCode + ')';
    }

    public /* synthetic */ WebViewClientError(String str, ErrorReason errorReason, Integer num, int i2, f fVar) {
        this((i2 & 1) != 0 ? null : str, errorReason, (i2 & 4) != 0 ? null : num);
    }
}
