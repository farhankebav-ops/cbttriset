package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.internal.RateLimitProto;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.RateLimit;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements x4.a, x4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5620c;

    public /* synthetic */ a(int i2, Object obj, Object obj2) {
        this.f5618a = i2;
        this.f5619b = obj;
        this.f5620c = obj2;
    }

    @Override // x4.c
    public Object apply(Object obj) {
        switch (this.f5618a) {
            case 4:
                return ((ImpressionStorageClient) this.f5619b).lambda$storeImpression$1((r2.c) this.f5620c, (r2.f) obj);
            case 5:
                return ((ImpressionStorageClient) this.f5619b).lambda$clearImpressions$4((HashSet) this.f5620c, (r2.f) obj);
            case 6:
                return ((InAppMessageStreamManager) this.f5619b).lambda$createFirebaseInAppMessageStream$20((e5.g) this.f5620c, (r2.f) obj);
            case 7:
            default:
                return RateLimiterClient.lambda$increment$1((RateLimitProto.RateLimit) this.f5619b, (RateLimit) this.f5620c, (RateLimitProto.Counter) obj);
            case 8:
                return ((InAppMessageStreamManager) this.f5619b).lambda$createFirebaseInAppMessageStream$16((r2.f) this.f5620c, (InstallationIdResult) obj);
        }
    }

    @Override // x4.a
    public void run() throws Exception {
        switch (this.f5618a) {
            case 0:
                ((CampaignCacheClient) this.f5619b).lambda$put$0((r2.o) this.f5620c);
                break;
            case 1:
                ((DisplayCallbacksImpl) this.f5619b).lambda$messageDismissed$2((FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType) this.f5620c);
                break;
            case 2:
                ((DisplayCallbacksImpl) this.f5619b).lambda$logMessageClick$3((Action) this.f5620c);
                break;
            case 3:
                ((DisplayCallbacksImpl) this.f5619b).lambda$displayErrorEncountered$4((FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason) this.f5620c);
                break;
            default:
                ((RateLimiterClient) this.f5619b).lambda$increment$2((RateLimitProto.RateLimit) this.f5620c);
                break;
        }
    }
}
