package com.mimikridev.ads.nativead;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NativeAd f10676b;

    public /* synthetic */ a(NativeAd nativeAd, int i2) {
        this.f10675a = i2;
        this.f10676b = nativeAd;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f10675a) {
            case 0:
                this.f10676b.lambda$loadBackupNativeAd$2(view);
                break;
            default:
                this.f10676b.lambda$loadNativeAd$0(view);
                break;
        }
    }
}
