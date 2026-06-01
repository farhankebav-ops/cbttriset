package com.unity3d.ads.adplayer;

import com.unity3d.ads.adplayer.model.WebViewClientError;
import java.util.List;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LoadWebViewError extends AdPlayerError {
    private final List<WebViewClientError> errors;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadWebViewError(List<WebViewClientError> errors) {
        super("AdPlayer was not able to load the webview.", null);
        k.e(errors, "errors");
        this.errors = errors;
    }

    public final List<WebViewClientError> getErrors() {
        return this.errors;
    }
}
