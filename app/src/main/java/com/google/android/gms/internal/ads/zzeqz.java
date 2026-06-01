package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeqz implements zzeya {
    private final Context zza;
    private final zzgus zzb;

    public zzeqz(zzgus zzgusVar, Context context) {
        this.zzb = zzgusVar;
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zznU)).booleanValue()) {
            return zzgui.zza(new zzera(null, false));
        }
        final ContentResolver contentResolver = this.zza.getContentResolver();
        return contentResolver == null ? zzgui.zza(new zzera(null, false)) : this.zzb.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzeqy
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                ContentResolver contentResolver2 = contentResolver;
                return new zzera(Settings.Secure.getString(contentResolver2, "advertising_id"), Settings.Secure.getInt(contentResolver2, "limit_ad_tracking", 0) == 1);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 61;
    }
}
