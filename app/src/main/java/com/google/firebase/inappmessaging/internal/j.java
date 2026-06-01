package com.google.firebase.inappmessaging.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;
import com.google.firebase.messaging.FcmBroadcastProcessor;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.mimikridev.ads.gdpr.GDPR;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class j implements x4.d, x4.b, x4.a, x4.c, Continuation, m0.f, SuccessContinuation, ObjectConstructor, UserMessagingPlatform.OnConsentFormLoadFailureListener, ConsentInformation.OnConsentInfoUpdateFailureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5639a;

    public /* synthetic */ j(int i2) {
        this.f5639a = i2;
    }

    @Override // x4.b
    public void accept(Object obj) throws Exception {
        switch (this.f5639a) {
            case 1:
                InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$17((r2.o) obj);
                break;
            case 2:
            case 5:
            case 7:
            case 9:
            default:
                InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$2((Throwable) obj);
                break;
            case 3:
                InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$19((Throwable) obj);
                break;
            case 4:
                InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$0((String) obj);
                break;
            case 6:
                InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$4((Throwable) obj);
                break;
            case 8:
                InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$7((Throwable) obj);
                break;
            case 10:
                Logging.logd("Fetched from cache");
                break;
        }
    }

    @Override // x4.c
    public Object apply(Object obj) {
        switch (this.f5639a) {
            case 7:
                return InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$5((Throwable) obj);
            case 12:
                return InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$13((q2.f) obj);
            default:
                return ((MessagingClientEventExtension) obj).toByteArray();
        }
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        switch (this.f5639a) {
            case 19:
                return ConstructorConstructor.lambda$newMapConstructor$14();
            case 20:
                return ConstructorConstructor.lambda$newMapConstructor$15();
            case 21:
                return ConstructorConstructor.lambda$newMapConstructor$16();
            case 22:
                return ConstructorConstructor.lambda$newMapConstructor$17();
            case 23:
                return ConstructorConstructor.lambda$newMapConstructor$18();
            case 24:
                return ConstructorConstructor.lambda$newCollectionConstructor$10();
            case 25:
                return ConstructorConstructor.lambda$newCollectionConstructor$11();
            case 26:
                return ConstructorConstructor.lambda$newCollectionConstructor$12();
            default:
                return ConstructorConstructor.lambda$newCollectionConstructor$13();
        }
    }

    @Override // com.google.android.ump.UserMessagingPlatform.OnConsentFormLoadFailureListener
    public void onConsentFormLoadFailure(FormError formError) {
        GDPR.lambda$loadForm$5(formError);
    }

    @Override // com.google.android.ump.ConsentInformation.OnConsentInfoUpdateFailureListener
    public void onConsentInfoUpdateFailure(FormError formError) {
        GDPR.lambda$updateGDPRConsentStatus$1(formError);
    }

    @Override // x4.a
    public void run() {
        Logging.logd("Wrote to cache");
    }

    @Override // x4.d
    public boolean test(Object obj) {
        switch (this.f5639a) {
            case 0:
                return InAppMessageStreamManager.validIID((InstallationIdResult) obj);
            case 1:
            default:
                return InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$9((Boolean) obj);
            case 2:
                return InAppMessageStreamManager.lambda$getContentIfNotRateLimited$23((Boolean) obj);
        }
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public Task then(Object obj) {
        switch (this.f5639a) {
            case 16:
                return FirebaseRemoteConfig.lambda$fetch$3((ConfigFetchHandler.FetchResponse) obj);
            case 17:
                return FirebaseRemoteConfig.lambda$setDefaultsWithStringsMapAsync$7((ConfigContainer) obj);
            default:
                return FirebaseRemoteConfig.lambda$fetch$4((ConfigFetchHandler.FetchResponse) obj);
        }
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        switch (this.f5639a) {
            case 13:
                return FcmBroadcastProcessor.lambda$startMessagingService$1(task);
            default:
                return FcmBroadcastProcessor.lambda$bindToMessagingService$3(task);
        }
    }
}
