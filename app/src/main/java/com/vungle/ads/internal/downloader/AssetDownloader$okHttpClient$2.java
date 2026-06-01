package com.vungle.ads.internal.downloader;

import com.vungle.ads.internal.downloader.AssetDownloader;
import e6.a;
import kotlin.jvm.internal.l;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AssetDownloader$okHttpClient$2 extends l implements a {
    final /* synthetic */ AssetDownloader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssetDownloader$okHttpClient$2(AssetDownloader assetDownloader) {
        super(0);
        this.this$0 = assetDownloader;
    }

    @Override // e6.a
    public final OkHttpClient invoke() {
        return AssetDownloader.OkHttpSingleton.INSTANCE.createOkHttpClient(this.this$0.pathProvider);
    }
}
