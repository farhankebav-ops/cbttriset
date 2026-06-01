package com.google.firebase.inappmessaging.internal;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.internal.ProxyAnalyticsConnector;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class r implements Deferred.DeferredHandler, OnSuccessListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f5661d;

    public /* synthetic */ r(Object obj, Object obj2, Object obj3, int i2) {
        this.f5658a = i2;
        this.f5659b = obj;
        this.f5660c = obj2;
        this.f5661d = obj3;
    }

    @Override // com.google.firebase.inject.Deferred.DeferredHandler
    public void handle(Provider provider) {
        ((ProxyAnalyticsConnector.ProxyAnalyticsConnectorHandle) this.f5659b).lambda$new$0((String) this.f5660c, (AnalyticsConnector.AnalyticsConnectorListener) this.f5661d, provider);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        switch (this.f5658a) {
            case 1:
                ((MetricsLoggerClient) this.f5659b).lambda$logRenderError$2((InAppMessage) this.f5660c, (FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason) this.f5661d, (String) obj);
                break;
            default:
                ((MetricsLoggerClient) this.f5659b).lambda$logDismiss$3((InAppMessage) this.f5660c, (FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType) this.f5661d, (String) obj);
                break;
        }
    }
}
