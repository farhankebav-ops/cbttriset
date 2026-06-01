package androidx.privacysandbox.ads.adservices.common;

import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class AdSelectionSignals {
    private final String signals;

    public AdSelectionSignals(String signals) {
        k.e(signals, "signals");
        this.signals = signals;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.common.AdSelectionSignals convertToAdServices$ads_adservices_release() {
        android.adservices.common.AdSelectionSignals adSelectionSignalsFromString = android.adservices.common.AdSelectionSignals.fromString(this.signals);
        k.d(adSelectionSignalsFromString, "fromString(signals)");
        return adSelectionSignalsFromString;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdSelectionSignals) {
            return k.a(this.signals, ((AdSelectionSignals) obj).signals);
        }
        return false;
    }

    public final String getSignals() {
        return this.signals;
    }

    public int hashCode() {
        return this.signals.hashCode();
    }

    public String toString() {
        return "AdSelectionSignals: " + this.signals;
    }
}
