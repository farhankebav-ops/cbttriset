package com.mimikridev.ads.initialization;

import com.mimikridev.ads.initialization.InitializeAd;
import com.unity3d.mediation.LevelPlayInitListener;
import com.unity3d.mediation.LevelPlayInitRequest;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LevelPlayInitRequest f10673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LevelPlayInitListener f10674c;

    public /* synthetic */ a(LevelPlayInitListener levelPlayInitListener, LevelPlayInitRequest levelPlayInitRequest, int i2) {
        this.f10672a = i2;
        this.f10674c = levelPlayInitListener;
        this.f10673b = levelPlayInitRequest;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10672a) {
            case 0:
                ((InitializeAd.AnonymousClass1) this.f10674c).lambda$onInitFailed$0(this.f10673b);
                break;
            default:
                ((InitializeAd.AnonymousClass3) this.f10674c).lambda$onInitFailed$0(this.f10673b);
                break;
        }
    }
}
