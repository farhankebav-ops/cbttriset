package androidx.privacysandbox.ads.adservices.common;

import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.adselection.b;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.time.Duration;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalFeatures.Ext8OptIn
public final class KeyedFrequencyCap {
    private final int adCounterKey;
    private final Duration interval;
    private final int maxCount;

    public KeyedFrequencyCap(int i2, int i8, Duration interval) {
        k.e(interval, "interval");
        this.adCounterKey = i2;
        this.maxCount = i8;
        this.interval = interval;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 8), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.common.KeyedFrequencyCap convertToAdServices$ads_adservices_release() {
        b.C();
        android.adservices.common.KeyedFrequencyCap keyedFrequencyCapBuild = b.w(this.adCounterKey, this.maxCount, this.interval).build();
        k.d(keyedFrequencyCapBuild, "Builder(adCounterKey, ma…val)\n            .build()");
        return keyedFrequencyCapBuild;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyedFrequencyCap)) {
            return false;
        }
        KeyedFrequencyCap keyedFrequencyCap = (KeyedFrequencyCap) obj;
        return this.adCounterKey == keyedFrequencyCap.adCounterKey && this.maxCount == keyedFrequencyCap.maxCount && k.a(this.interval, keyedFrequencyCap.interval);
    }

    public final int getAdCounterKey() {
        return this.adCounterKey;
    }

    public final Duration getInterval() {
        return this.interval;
    }

    public final int getMaxCount() {
        return this.maxCount;
    }

    public int hashCode() {
        return this.interval.hashCode() + (((this.adCounterKey * 31) + this.maxCount) * 31);
    }

    public String toString() {
        return "KeyedFrequencyCap: adCounterKey=" + this.adCounterKey + ", maxCount=" + this.maxCount + ", interval=" + this.interval;
    }
}
