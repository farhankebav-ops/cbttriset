package androidx.camera.camera2.internal.compat.workaround;

import android.content.Context;
import androidx.arch.core.util.Function;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.utils.RedirectableLiveData;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.constraintlayout.core.state.Interpolator;
import androidx.constraintlayout.core.state.Transition;
import androidx.work.impl.model.WorkSpec;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapFactory;
import com.bumptech.glide.util.GlideSuppliers;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import com.google.firebase.inappmessaging.internal.Logging;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import e5.v;
import java.util.List;
import m0.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Function, Interpolator, GlideSuppliers.GlideSupplier, LibraryVersionComponent.VersionExtractor, OnFailureListener, f, OnSuccessListener, x4.b, x4.a, x4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3418a;

    public /* synthetic */ c(int i2) {
        this.f3418a = i2;
    }

    @Override // x4.b
    public void accept(Object obj) throws Exception {
        switch (this.f3418a) {
            case 20:
                Logging.loge("Impression store write failure");
                break;
            case 22:
                Logging.loge("Rate limiter client write failure");
                break;
            case 27:
                InAppMessageStreamManager.lambda$getContentIfNotRateLimited$22((Boolean) obj);
                break;
            default:
                InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$15((Throwable) obj);
                break;
        }
    }

    @Override // androidx.arch.core.util.Function, m0.f, x4.c
    public Object apply(Object obj) {
        switch (this.f3418a) {
            case 0:
                return RequestMonitor.lambda$getRequestsProcessedFuture$0((List) obj);
            case 1:
                return ImageCapture.lambda$submitStillCaptureRequest$5((List) obj);
            case 2:
                return RedirectableLiveData._init_$lambda$0(obj);
            case 3:
                return new DefaultSurfaceProcessor((DynamicRange) obj);
            case 11:
                return WorkSpec.WORK_INFO_MAPPER$lambda$1((List) obj);
            case 18:
                return DataTransportCrashlyticsReportSender.lambda$static$0((CrashlyticsReport) obj);
            case 24:
                return ((r2.f) obj).c();
            case 25:
                List list = (List) obj;
                z4.b.a(list, "source is null");
                return new v(list, 1);
            default:
                return ((r2.c) obj).getCampaignId();
        }
    }

    @Override // com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor
    public String extract(Object obj) {
        Context context = (Context) obj;
        switch (this.f3418a) {
            case 13:
                return FirebaseCommonRegistrar.lambda$getComponents$0(context);
            case 14:
                return FirebaseCommonRegistrar.lambda$getComponents$1(context);
            case 15:
                return FirebaseCommonRegistrar.lambda$getComponents$2(context);
            default:
                return FirebaseCommonRegistrar.lambda$getComponents$3(context);
        }
    }

    @Override // com.bumptech.glide.util.GlideSuppliers.GlideSupplier
    public Object get() {
        return GlideBitmapFactory.GainmapDecoderWorkaroundStateCalculator.lambda$static$0();
    }

    @Override // androidx.constraintlayout.core.state.Interpolator
    public float getInterpolation(float f4) {
        switch (this.f3418a) {
            case 4:
                return Transition.lambda$getInterpolator$1(f4);
            case 5:
                return Transition.lambda$getInterpolator$2(f4);
            case 6:
                return Transition.lambda$getInterpolator$3(f4);
            case 7:
                return Transition.lambda$getInterpolator$4(f4);
            case 8:
                return Transition.lambda$getInterpolator$5(f4);
            case 9:
                return Transition.lambda$getInterpolator$6(f4);
            default:
                return Transition.lambda$getInterpolator$7(f4);
        }
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        FirebaseCrashlytics.lambda$init$0(exc);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        FirebaseInAppMessaging.lambda$new$0((String) obj);
    }

    @Override // x4.a
    public void run() {
        switch (this.f3418a) {
            case 21:
                Logging.logd("Impression store write success");
                break;
            default:
                Logging.logd("Rate limiter client write success");
                break;
        }
    }
}
