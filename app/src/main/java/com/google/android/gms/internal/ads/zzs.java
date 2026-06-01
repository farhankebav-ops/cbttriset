package com.google.android.gms.internal.ads;

import android.os.Build;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzs {
    private final SparseBooleanArray zza;

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzs)) {
            return false;
        }
        zzs zzsVar = (zzs) obj;
        if (Build.VERSION.SDK_INT >= 24) {
            return this.zza.equals(zzsVar.zza);
        }
        SparseBooleanArray sparseBooleanArray = this.zza;
        if (sparseBooleanArray.size() != zzsVar.zza.size()) {
            return false;
        }
        for (int i2 = 0; i2 < sparseBooleanArray.size(); i2++) {
            if (zzc(i2) != zzsVar.zzc(i2)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.zza.hashCode();
        }
        SparseBooleanArray sparseBooleanArray = this.zza;
        int size = sparseBooleanArray.size();
        for (int i2 = 0; i2 < sparseBooleanArray.size(); i2++) {
            size = (size * 31) + zzc(i2);
        }
        return size;
    }

    public final boolean zza(int i2) {
        return this.zza.get(i2);
    }

    public final int zzb() {
        return this.zza.size();
    }

    public final int zzc(int i2) {
        SparseBooleanArray sparseBooleanArray = this.zza;
        zzgmd.zzm(i2, sparseBooleanArray.size(), FirebaseAnalytics.Param.INDEX);
        return sparseBooleanArray.keyAt(i2);
    }
}
