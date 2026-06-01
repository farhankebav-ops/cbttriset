package com.google.firebase.inappmessaging.internal;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class p implements OnSuccessListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MetricsLoggerClient f5653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InAppMessage f5654c;

    public /* synthetic */ p(MetricsLoggerClient metricsLoggerClient, InAppMessage inAppMessage, int i2) {
        this.f5652a = i2;
        this.f5653b = metricsLoggerClient;
        this.f5654c = inAppMessage;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        switch (this.f5652a) {
            case 0:
                this.f5653b.lambda$logImpression$0(this.f5654c, (String) obj);
                break;
            default:
                this.f5653b.lambda$logMessageClick$1(this.f5654c, (String) obj);
                break;
        }
    }
}
