package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbwr;
import com.google.android.gms.internal.ads.zzbzt;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzb {
    private final Context zza;
    private boolean zzb;

    @Nullable
    private final zzbzt zzc;
    private final zzbwr zzd = new zzbwr(false, Collections.EMPTY_LIST);

    public zzb(Context context, @Nullable zzbzt zzbztVar, @Nullable zzbwr zzbwrVar) {
        this.zza = context;
        this.zzc = zzbztVar;
    }

    private final boolean zzd() {
        zzbzt zzbztVar = this.zzc;
        return (zzbztVar != null && zzbztVar.zza().zzf) || this.zzd.zza;
    }

    public final void zza() {
        this.zzb = true;
    }

    public final boolean zzb() {
        return !zzd() || this.zzb;
    }

    public final void zzc(@Nullable String str) {
        List<String> list;
        if (zzd()) {
            if (str == null) {
                str = "";
            }
            zzbzt zzbztVar = this.zzc;
            if (zzbztVar != null) {
                zzbztVar.zze(str, null, 3);
                return;
            }
            zzbwr zzbwrVar = this.zzd;
            if (!zzbwrVar.zza || (list = zzbwrVar.zzb) == null) {
                return;
            }
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2)) {
                    String strReplace = str2.replace("{NAVIGATION_URL}", Uri.encode(str));
                    Context context = this.zza;
                    zzt.zzc();
                    com.google.android.gms.ads.internal.util.zzs.zzP(context, "", strReplace);
                }
            }
        }
    }
}
