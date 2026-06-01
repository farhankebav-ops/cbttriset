package com.ironsource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
final class L4 implements X3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final L4 f7088a = new L4();

    private L4() {
    }

    @Override // com.ironsource.X3
    public InputStream a(String url) throws IOException {
        kotlin.jvm.internal.k.e(url, "url");
        InputStream inputStreamOpenStream = new URL(url).openStream();
        kotlin.jvm.internal.k.d(inputStreamOpenStream, "URL(url).openStream()");
        return inputStreamOpenStream;
    }
}
