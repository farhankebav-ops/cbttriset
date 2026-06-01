package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzexo implements zzeya {
    private final zzgus zza;
    private final Context zzb;
    private final VersionInfoParcel zzc;

    @Nullable
    private final String zzd;

    public zzexo(zzgus zzgusVar, Context context, VersionInfoParcel versionInfoParcel, @Nullable String str) {
        this.zza = zzgusVar;
        this.zzb = context;
        this.zzc = versionInfoParcel;
        this.zzd = str;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        return this.zza.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzexn
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 35;
    }

    public final /* synthetic */ zzexp zzc() {
        Context context = this.zzb;
        boolean zIsCallerInstantApp = Wrappers.packageManager(context).isCallerInstantApp();
        com.google.android.gms.ads.internal.zzt.zzc();
        boolean zZzI = com.google.android.gms.ads.internal.util.zzs.zzI(context);
        String str = this.zzc.afmaVersion;
        com.google.android.gms.ads.internal.zzt.zzc();
        boolean zZzJ = com.google.android.gms.ads.internal.util.zzs.zzJ();
        com.google.android.gms.ads.internal.zzt.zzc();
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return new zzexp(zIsCallerInstantApp, zZzI, str, zZzJ, applicationInfo == null ? 0 : applicationInfo.targetSdkVersion, DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID), DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID), this.zzd);
    }
}
