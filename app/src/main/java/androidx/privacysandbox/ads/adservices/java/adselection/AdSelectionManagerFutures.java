package androidx.privacysandbox.ads.adservices.java.adselection;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionConfig;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionFromOutcomesConfig;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager;
import androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataRequest;
import androidx.privacysandbox.ads.adservices.adselection.PersistAdSelectionResultRequest;
import androidx.privacysandbox.ads.adservices.adselection.ReportEventRequest;
import androidx.privacysandbox.ads.adservices.adselection.ReportImpressionRequest;
import androidx.privacysandbox.ads.adservices.adselection.UpdateAdCounterHistogramRequest;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import j2.q;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q6.c0;
import q6.m0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AdSelectionManagerFutures {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final AdSelectionManagerFutures from(Context context) {
            k.e(context, "context");
            AdSelectionManager adSelectionManagerObtain = AdSelectionManager.Companion.obtain(context);
            if (adSelectionManagerObtain != null) {
                return new Api33Ext4JavaImpl(adSelectionManagerObtain);
            }
            return null;
        }

        private Companion() {
        }
    }

    public static final AdSelectionManagerFutures from(Context context) {
        return Companion.from(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext10OptIn
    public abstract q getAdSelectionDataAsync(GetAdSelectionDataRequest getAdSelectionDataRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext10OptIn
    public abstract q persistAdSelectionResultAsync(PersistAdSelectionResultRequest persistAdSelectionResultRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext8OptIn
    public abstract q reportEventAsync(ReportEventRequest reportEventRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    public abstract q reportImpressionAsync(ReportImpressionRequest reportImpressionRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    public abstract q selectAdsAsync(AdSelectionConfig adSelectionConfig);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext10OptIn
    public abstract q selectAdsAsync(AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext8OptIn
    public abstract q updateAdCounterHistogramAsync(UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Api33Ext4JavaImpl extends AdSelectionManagerFutures {
        private final AdSelectionManager mAdSelectionManager;

        public Api33Ext4JavaImpl(AdSelectionManager adSelectionManager) {
            this.mAdSelectionManager = adSelectionManager;
        }

        @Override // androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public q getAdSelectionDataAsync(GetAdSelectionDataRequest getAdSelectionDataRequest) {
            k.e(getAdSelectionDataRequest, "getAdSelectionDataRequest");
            return CoroutineAdapterKt.asListenableFuture$default(c0.g(c0.b(m0.f13566a), null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$getAdSelectionDataAsync$1(this, getAdSelectionDataRequest, null), 3), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public q persistAdSelectionResultAsync(PersistAdSelectionResultRequest persistAdSelectionResultRequest) {
            k.e(persistAdSelectionResultRequest, "persistAdSelectionResultRequest");
            return CoroutineAdapterKt.asListenableFuture$default(c0.g(c0.b(m0.f13566a), null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$persistAdSelectionResultAsync$1(this, persistAdSelectionResultRequest, null), 3), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public q reportEventAsync(ReportEventRequest reportEventRequest) {
            k.e(reportEventRequest, "reportEventRequest");
            return CoroutineAdapterKt.asListenableFuture$default(c0.g(c0.b(m0.f13566a), null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$reportEventAsync$1(this, reportEventRequest, null), 3), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public q reportImpressionAsync(ReportImpressionRequest reportImpressionRequest) {
            k.e(reportImpressionRequest, "reportImpressionRequest");
            return CoroutineAdapterKt.asListenableFuture$default(c0.g(c0.b(m0.f13566a), null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$reportImpressionAsync$1(this, reportImpressionRequest, null), 3), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public q selectAdsAsync(AdSelectionConfig adSelectionConfig) {
            k.e(adSelectionConfig, "adSelectionConfig");
            return CoroutineAdapterKt.asListenableFuture$default(c0.g(c0.b(m0.f13566a), null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$selectAdsAsync$1(this, adSelectionConfig, null), 3), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public q updateAdCounterHistogramAsync(UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest) {
            k.e(updateAdCounterHistogramRequest, "updateAdCounterHistogramRequest");
            return CoroutineAdapterKt.asListenableFuture$default(c0.g(c0.b(m0.f13566a), null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$updateAdCounterHistogramAsync$1(this, updateAdCounterHistogramRequest, null), 3), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public q selectAdsAsync(AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig) {
            k.e(adSelectionFromOutcomesConfig, "adSelectionFromOutcomesConfig");
            return CoroutineAdapterKt.asListenableFuture$default(c0.g(c0.b(m0.f13566a), null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$selectAdsAsync$2(this, adSelectionFromOutcomesConfig, null), 3), null, 1, null);
        }
    }
}
