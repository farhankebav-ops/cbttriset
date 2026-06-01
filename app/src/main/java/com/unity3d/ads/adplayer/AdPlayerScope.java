package com.unity3d.ads.adplayer;

import kotlin.jvm.internal.k;
import q6.a0;
import q6.c0;
import q6.w;
import v5.h;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AdPlayerScope implements a0 {
    private final /* synthetic */ a0 $$delegate_0;
    private final w defaultDispatcher;

    public AdPlayerScope(w defaultDispatcher) {
        k.e(defaultDispatcher, "defaultDispatcher");
        this.defaultDispatcher = defaultDispatcher;
        this.$$delegate_0 = c0.b(defaultDispatcher);
    }

    @Override // q6.a0
    public h getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }
}
