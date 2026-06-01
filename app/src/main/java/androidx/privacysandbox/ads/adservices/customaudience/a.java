package androidx.privacysandbox.ads.adservices.customaudience;

import android.adservices.customaudience.CustomAudience;
import android.adservices.customaudience.JoinCustomAudienceRequest;
import android.adservices.customaudience.LeaveCustomAudienceRequest;
import android.adservices.customaudience.TrustedBiddingData;
import android.adservices.measurement.DeletionRequest;
import android.adservices.measurement.MeasurementManager;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ CustomAudience.Builder a() {
        return new CustomAudience.Builder();
    }

    public static /* synthetic */ JoinCustomAudienceRequest.Builder e() {
        return new JoinCustomAudienceRequest.Builder();
    }

    public static /* synthetic */ LeaveCustomAudienceRequest.Builder h() {
        return new LeaveCustomAudienceRequest.Builder();
    }

    public static /* synthetic */ TrustedBiddingData.Builder k() {
        return new TrustedBiddingData.Builder();
    }

    public static /* synthetic */ DeletionRequest.Builder o() {
        return new DeletionRequest.Builder();
    }

    public static /* bridge */ /* synthetic */ MeasurementManager u(Object obj) {
        return (MeasurementManager) obj;
    }

    public static /* bridge */ /* synthetic */ Class v() {
        return MeasurementManager.class;
    }
}
