package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.model.WebViewConfiguration;
import java.io.File;
import java.util.Map;
import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface CacheWebViewAssets {
    Map<String, File> getCached();

    Object invoke(WebViewConfiguration webViewConfiguration, c<? super x> cVar);
}
