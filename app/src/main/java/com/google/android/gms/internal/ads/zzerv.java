package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.ext.SdkExtensions;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzerv implements zzexy {
    private final Integer zza;

    private zzerv(Integer num) {
        this.zza = num;
    }

    public static /* synthetic */ zzerv zzc(VersionInfoParcel versionInfoParcel) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlb)).booleanValue()) {
            return new zzerv(null);
        }
        com.google.android.gms.ads.internal.zzt.zzc();
        int extensionVersion = 0;
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 30 || SdkExtensions.getExtensionVersion(30) <= 3) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzle)).booleanValue()) {
                    if (versionInfoParcel.clientJarVersion >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzld)).intValue() && i2 >= 31 && SdkExtensions.getExtensionVersion(31) >= 9) {
                        extensionVersion = SdkExtensions.getExtensionVersion(31);
                    }
                }
            } else {
                extensionVersion = SdkExtensions.getExtensionVersion(1000000);
            }
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "AdUtil.getAdServicesExtensionVersion");
        }
        return new zzerv(Integer.valueOf(extensionVersion));
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Integer num = this.zza;
        zzcxq zzcxqVar = (zzcxq) obj;
        if (num != null) {
            zzcxqVar.zza.putInt("aos", num.intValue());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* synthetic */ void zzb(Object obj) {
        p.a(this, obj);
    }
}
