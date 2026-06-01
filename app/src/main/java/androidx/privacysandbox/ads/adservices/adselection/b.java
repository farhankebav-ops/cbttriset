package androidx.privacysandbox.ads.adservices.adselection;

import android.adservices.adselection.GetAdSelectionDataRequest;
import android.adservices.adselection.PersistAdSelectionResultRequest;
import android.adservices.adselection.ReportEventRequest;
import android.adservices.adselection.UpdateAdCounterHistogramRequest;
import android.adservices.common.AdFilters;
import android.adservices.common.AdTechIdentifier;
import android.adservices.common.FrequencyCapFilters;
import android.adservices.common.KeyedFrequencyCap;
import java.time.Duration;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class b {
    public static /* synthetic */ void A() {
    }

    public static /* synthetic */ void C() {
    }

    public static /* synthetic */ GetAdSelectionDataRequest.Builder a() {
        return new GetAdSelectionDataRequest.Builder();
    }

    public static /* synthetic */ PersistAdSelectionResultRequest.Builder c() {
        return new PersistAdSelectionResultRequest.Builder();
    }

    public static /* synthetic */ ReportEventRequest.Builder h(long j, String str, String str2, int i2) {
        return new ReportEventRequest.Builder(j, str, str2, i2);
    }

    public static /* synthetic */ android.adservices.adselection.ReportImpressionRequest k(long j) {
        return new android.adservices.adselection.ReportImpressionRequest(j);
    }

    public static /* synthetic */ UpdateAdCounterHistogramRequest.Builder l(long j, int i2, AdTechIdentifier adTechIdentifier) {
        return new UpdateAdCounterHistogramRequest.Builder(j, i2, adTechIdentifier);
    }

    public static /* synthetic */ AdFilters.Builder q() {
        return new AdFilters.Builder();
    }

    public static /* synthetic */ FrequencyCapFilters.Builder t() {
        return new FrequencyCapFilters.Builder();
    }

    public static /* synthetic */ KeyedFrequencyCap.Builder w(int i2, int i8, Duration duration) {
        return new KeyedFrequencyCap.Builder(i2, i8, duration);
    }

    public static /* synthetic */ void y() {
    }
}
