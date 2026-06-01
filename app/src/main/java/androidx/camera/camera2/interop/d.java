package androidx.camera.camera2.interop;

import android.app.Activity;
import android.content.Context;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.core.impl.Config;
import androidx.camera.extensions.internal.RequestOptionConfig;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.UserMessagingPlatform;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient;
import com.mimikridev.ads.gdpr.GDPR;
import com.mimikridev.utilmanager.config.Statistik;
import com.mimikridev.utilmanager.dialog.DialogUtil;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import q.f;
import q6.f0;
import w0.g;
import w0.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Config.OptionMatcher, CallbackToFutureAdapter.Resolver, FirebaseInAppMessagingDisplay, Continuation, UserMessagingPlatform.OnConsentFormLoadSuccessListener, OnSuccessListener, f, x0.b, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3562c;

    public /* synthetic */ d(int i2, Object obj, Object obj2) {
        this.f3560a = i2;
        this.f3562c = obj;
        this.f3561b = obj2;
    }

    @Override // q.f
    public void a(q.g gVar) {
        DialogUtil.lambda$showSuccessDialogWithRedirect$1((Context) this.f3562c, (Class) this.f3561b, gVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0091 A[Catch: all -> 0x0117, TryCatch #0 {all -> 0x0117, blocks: (B:22:0x008b, B:24:0x0091, B:26:0x00a1, B:27:0x00ad), top: B:54:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cc  */
    @Override // w0.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object apply(java.lang.Object r14) {
        /*
            Method dump skipped, instruction units count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.interop.d.apply(java.lang.Object):java.lang.Object");
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return CoroutineAdapterKt.asListenableFuture$lambda$0((f0) this.f3562c, this.f3561b, completer);
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay
    public void displayMessage(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        ((com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay) this.f3562c).lambda$bindFiamToActivity$0((Activity) this.f3561b, inAppMessage, firebaseInAppMessagingDisplayCallbacks);
    }

    @Override // x0.b
    public Object execute() {
        switch (this.f3560a) {
            case 10:
                v0.f fVar = (v0.f) this.f3562c;
                Iterable iterable = (Iterable) this.f3561b;
                i iVar = (i) fVar.f17583c;
                iVar.getClass();
                if (iterable.iterator().hasNext()) {
                    iVar.a().compileStatement("DELETE FROM events WHERE _id in " + i.k(iterable)).execute();
                    break;
                }
                break;
            default:
                v0.f fVar2 = (v0.f) this.f3562c;
                for (Map.Entry entry : ((HashMap) this.f3561b).entrySet()) {
                    ((i) fVar2.f17586i).i(((Integer) entry.getValue()).intValue(), s0.c.INVALID_PAYLOD, (String) entry.getKey());
                }
                break;
        }
        return null;
    }

    @Override // com.google.android.ump.UserMessagingPlatform.OnConsentFormLoadSuccessListener
    public void onConsentFormLoadSuccess(ConsentForm consentForm) {
        ((GDPR) this.f3562c).lambda$loadForm$4((Activity) this.f3561b, consentForm);
    }

    @Override // androidx.camera.core.impl.Config.OptionMatcher
    public boolean onOptionMatched(Config.Option option) {
        switch (this.f3560a) {
            case 0:
                return CaptureRequestOptions.Builder.lambda$from$0((CaptureRequestOptions.Builder) this.f3562c, (Config) this.f3561b, option);
            default:
                return RequestOptionConfig.Builder.lambda$from$0((RequestOptionConfig.Builder) this.f3562c, (Config) this.f3561b, option);
        }
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        Statistik.lambda$postStatistik$1((String[]) this.f3562c, (CountDownLatch) this.f3561b, (String) obj);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        switch (this.f3560a) {
            case 4:
                return ((ConfigFetchHandler) this.f3562c).lambda$fetchIfCacheExpiredAndNotThrottled$3((Date) this.f3561b, task);
            case 5:
                return ((ConfigFetchHandler) this.f3562c).lambda$fetchNowWithTypeAndAttemptNumber$1((HashMap) this.f3561b, task);
            default:
                return ((ConfigRealtimeHttpClient) this.f3562c).lambda$beginRealtimeHttpStream$1((Task) this.f3561b, task);
        }
    }
}
