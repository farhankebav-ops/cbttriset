package androidx.privacysandbox.ads.adservices.java.measurement;

import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import androidx.privacysandbox.ads.adservices.measurement.DeletionRequest;
import androidx.privacysandbox.ads.adservices.measurement.MeasurementManager;
import androidx.privacysandbox.ads.adservices.measurement.SourceRegistrationRequest;
import androidx.privacysandbox.ads.adservices.measurement.WebSourceRegistrationRequest;
import androidx.privacysandbox.ads.adservices.measurement.WebTriggerRegistrationRequest;
import j2.q;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q6.c0;
import q6.m0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MeasurementManagerFutures {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final MeasurementManagerFutures from(Context context) {
            k.e(context, "context");
            MeasurementManager measurementManagerObtain = MeasurementManager.Companion.obtain(context);
            if (measurementManagerObtain != null) {
                return new Api33Ext5JavaImpl(measurementManagerObtain);
            }
            return null;
        }

        private Companion() {
        }
    }

    public static final MeasurementManagerFutures from(Context context) {
        return Companion.from(context);
    }

    public abstract q deleteRegistrationsAsync(DeletionRequest deletionRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract q getMeasurementApiStatusAsync();

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract q registerSourceAsync(Uri uri, InputEvent inputEvent);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @ExperimentalFeatures.RegisterSourceOptIn
    public abstract q registerSourceAsync(SourceRegistrationRequest sourceRegistrationRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract q registerTriggerAsync(Uri uri);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract q registerWebSourceAsync(WebSourceRegistrationRequest webSourceRegistrationRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract q registerWebTriggerAsync(WebTriggerRegistrationRequest webTriggerRegistrationRequest);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Api33Ext5JavaImpl extends MeasurementManagerFutures {
        private final MeasurementManager mMeasurementManager;

        public Api33Ext5JavaImpl(MeasurementManager mMeasurementManager) {
            k.e(mMeasurementManager, "mMeasurementManager");
            this.mMeasurementManager = mMeasurementManager;
        }

        @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        public q deleteRegistrationsAsync(DeletionRequest deletionRequest) {
            k.e(deletionRequest, "deletionRequest");
            return CoroutineAdapterKt.asListenableFuture$default(c0.g(c0.b(m0.f13566a), null, new MeasurementManagerFutures$Api33Ext5JavaImpl$deleteRegistrationsAsync$1(this, deletionRequest, null), 3), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        public q getMeasurementApiStatusAsync() {
            return CoroutineAdapterKt.asListenableFuture$default(c0.g(c0.b(m0.f13566a), null, new MeasurementManagerFutures$Api33Ext5JavaImpl$getMeasurementApiStatusAsync$1(this, null), 3), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        public q registerSourceAsync(Uri attributionSource, InputEvent inputEvent) {
            k.e(attributionSource, "attributionSource");
            return CoroutineAdapterKt.asListenableFuture$default(c0.g(c0.b(m0.f13566a), null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1(this, attributionSource, inputEvent, null), 3), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        public q registerTriggerAsync(Uri trigger) {
            k.e(trigger, "trigger");
            return CoroutineAdapterKt.asListenableFuture$default(c0.g(c0.b(m0.f13566a), null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerTriggerAsync$1(this, trigger, null), 3), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        public q registerWebSourceAsync(WebSourceRegistrationRequest request) {
            k.e(request, "request");
            return CoroutineAdapterKt.asListenableFuture$default(c0.g(c0.b(m0.f13566a), null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebSourceAsync$1(this, request, null), 3), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        public q registerWebTriggerAsync(WebTriggerRegistrationRequest request) {
            k.e(request, "request");
            return CoroutineAdapterKt.asListenableFuture$default(c0.g(c0.b(m0.f13566a), null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebTriggerAsync$1(this, request, null), 3), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        @ExperimentalFeatures.RegisterSourceOptIn
        public q registerSourceAsync(SourceRegistrationRequest request) {
            k.e(request, "request");
            return CoroutineAdapterKt.asListenableFuture$default(c0.g(c0.b(m0.f13566a), null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$2(this, request, null), 3), null, 1, null);
        }
    }
}
