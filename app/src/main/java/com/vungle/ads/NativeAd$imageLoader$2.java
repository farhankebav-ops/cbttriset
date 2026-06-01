package com.vungle.ads;

import com.vungle.ads.internal.util.ImageLoader;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NativeAd$imageLoader$2 extends l implements e6.a {
    final /* synthetic */ NativeAd this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeAd$imageLoader$2(NativeAd nativeAd) {
        super(0);
        this.this$0 = nativeAd;
    }

    @Override // e6.a
    public final ImageLoader invoke() {
        ImageLoader companion = ImageLoader.Companion.getInstance();
        companion.init(this.this$0.getExecutors().getIoExecutor());
        return companion;
    }
}
