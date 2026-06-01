package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.settings.SettingsProvider;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CrashlyticsCore f5573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SettingsProvider f5574c;

    public /* synthetic */ d(CrashlyticsCore crashlyticsCore, SettingsProvider settingsProvider, int i2) {
        this.f5572a = i2;
        this.f5573b = crashlyticsCore;
        this.f5574c = settingsProvider;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5572a) {
            case 0:
                this.f5573b.lambda$doBackgroundInitializationAsync$0(this.f5574c);
                break;
            default:
                this.f5573b.lambda$finishInitSynchronously$9(this.f5574c);
                break;
        }
    }
}
