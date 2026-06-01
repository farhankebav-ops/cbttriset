package androidx.privacysandbox.ads.adservices.common;

import android.adservices.common.AdFilters;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.adselection.b;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalFeatures.Ext8OptIn
public final class AdFilters {
    private final FrequencyCapFilters frequencyCapFilters;

    public AdFilters(FrequencyCapFilters frequencyCapFilters) {
        this.frequencyCapFilters = frequencyCapFilters;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 8), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.common.AdFilters convertToAdServices$ads_adservices_release() {
        AdFilters.Builder builderQ = b.q();
        FrequencyCapFilters frequencyCapFilters = this.frequencyCapFilters;
        android.adservices.common.AdFilters adFiltersBuild = builderQ.setFrequencyCapFilters(frequencyCapFilters != null ? frequencyCapFilters.convertToAdServices$ads_adservices_release() : null).build();
        k.d(adFiltersBuild, "Builder()\n            .s…s())\n            .build()");
        return adFiltersBuild;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdFilters) {
            return k.a(this.frequencyCapFilters, ((AdFilters) obj).frequencyCapFilters);
        }
        return false;
    }

    public final FrequencyCapFilters getFrequencyCapFilters() {
        return this.frequencyCapFilters;
    }

    public int hashCode() {
        FrequencyCapFilters frequencyCapFilters = this.frequencyCapFilters;
        if (frequencyCapFilters != null) {
            return frequencyCapFilters.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "AdFilters: frequencyCapFilters=" + this.frequencyCapFilters;
    }
}
