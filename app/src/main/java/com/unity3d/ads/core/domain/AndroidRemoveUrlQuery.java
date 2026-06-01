package com.unity3d.ads.core.domain;

import android.net.Uri;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidRemoveUrlQuery implements RemoveUrlQuery {
    @Override // com.unity3d.ads.core.domain.RemoveUrlQuery
    public String invoke(String url) {
        k.e(url, "url");
        String string = Uri.parse(url).buildUpon().clearQuery().build().toString();
        k.d(string, "parse(url).buildUpon().c…uery().build().toString()");
        return string;
    }
}
