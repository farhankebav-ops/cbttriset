package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.Recorder;
import androidx.collection.ArrayMap;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;
import com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator;
import com.google.firebase.crashlytics.internal.metadata.EventMetadata;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.ironsource.sdk.controller.v;
import com.vungle.ads.internal.network.TpatRequest;
import com.vungle.ads.internal.network.TpatSender;
import j2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f3647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3649d;
    public final /* synthetic */ Object e;

    public /* synthetic */ d(v.r rVar, boolean z2, String str, String str2) {
        this.f3646a = 4;
        this.f3648c = rVar;
        this.f3647b = z2;
        this.f3649d = str;
        this.e = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3646a) {
            case 0:
                Futures.lambda$makeTimeoutFuture$4((CallbackToFutureAdapter.Completer) this.f3648c, this.f3649d, this.f3647b, (q) this.e);
                break;
            case 1:
                ((Recorder) this.f3648c).lambda$onSurfaceRequested$0((SurfaceRequest) this.f3649d, (Timebase) this.e, this.f3647b);
                break;
            case 2:
                DefaultSpecialEffectsController.startTransitions$lambda$9((SpecialEffectsController.Operation) this.f3648c, (SpecialEffectsController.Operation) this.f3649d, this.f3647b, (ArrayMap) this.e);
                break;
            case 3:
                ((SessionReportingCoordinator) this.f3648c).lambda$persistEvent$0((CrashlyticsReport.Session.Event) this.f3649d, (EventMetadata) this.e, this.f3647b);
                break;
            case 4:
                ((v.r) this.f3648c).a(this.f3647b, (String) this.f3649d, (String) this.e);
                break;
            default:
                TpatSender.m3329sendTpat$lambda1((TpatSender) this.f3648c, (TpatRequest) this.f3649d, (String) this.e, this.f3647b);
                break;
        }
    }

    public /* synthetic */ d(Object obj, Object obj2, Object obj3, boolean z2, int i2) {
        this.f3646a = i2;
        this.f3648c = obj;
        this.f3649d = obj2;
        this.e = obj3;
        this.f3647b = z2;
    }

    public /* synthetic */ d(Object obj, Object obj2, boolean z2, Object obj3, int i2) {
        this.f3646a = i2;
        this.f3648c = obj;
        this.f3649d = obj2;
        this.f3647b = z2;
        this.e = obj3;
    }
}
