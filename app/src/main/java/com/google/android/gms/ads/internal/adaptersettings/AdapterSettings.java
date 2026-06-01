package com.google.android.gms.ads.internal.adaptersettings;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzbed;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class AdapterSettings {

    @Nullable
    private static volatile AdapterSettings instance;
    private final zzbed adapterSettingsInternal = zzbd.zzd();

    @KeepForSdk
    private boolean getBoolean(String str, boolean z2) {
        return this.adapterSettingsInternal.zzf(str, z2);
    }

    @KeepForSdk
    private float getFloat(String str, float f4) {
        return this.adapterSettingsInternal.zze(str, f4);
    }

    public static AdapterSettings getInstance() {
        if (instance == null) {
            synchronized (AdapterSettings.class) {
                try {
                    if (instance == null) {
                        instance = new AdapterSettings();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    @KeepForSdk
    private int getInt(String str, int i2) {
        return this.adapterSettingsInternal.zzd(str, i2);
    }

    @KeepForSdk
    private long getLong(String str, long j) {
        return this.adapterSettingsInternal.zzc(str, j);
    }

    @KeepForSdk
    private String getString(String str, String str2) {
        return this.adapterSettingsInternal.zzb(str, str2);
    }
}
