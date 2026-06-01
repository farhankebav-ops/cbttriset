package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.impl.R;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbuk extends zzbun {
    private final Map zza;
    private final Context zzb;

    public zzbuk(zzcgy zzcgyVar, Map map) {
        super(zzcgyVar, "storePicture");
        this.zza = map;
        this.zzb = zzcgyVar.zzj();
    }

    public final void zza() {
        Context context = this.zzb;
        if (context == null) {
            zzg("Activity context is not available");
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzc();
        if (!new zzbeb(context).zza()) {
            zzg("Feature is not supported by the device.");
            return;
        }
        String str = (String) this.zza.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzg("Image url cannot be empty.");
            return;
        }
        if (!URLUtil.isValidUrl(str)) {
            zzg("Invalid image url: ".concat(String.valueOf(str)));
            return;
        }
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        com.google.android.gms.ads.internal.zzt.zzc();
        if (TextUtils.isEmpty(lastPathSegment) || !lastPathSegment.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)")) {
            zzg("Image type not recognized: ".concat(String.valueOf(lastPathSegment)));
            return;
        }
        Resources resourcesZzf = com.google.android.gms.ads.internal.zzt.zzh().zzf();
        com.google.android.gms.ads.internal.zzt.zzc();
        AlertDialog.Builder builderZzO = com.google.android.gms.ads.internal.util.zzs.zzO(context);
        builderZzO.setTitle(resourcesZzf != null ? resourcesZzf.getString(R.string.f5214s1) : "Save image");
        builderZzO.setMessage(resourcesZzf != null ? resourcesZzf.getString(R.string.f5215s2) : "Allow Ad to store image in Picture gallery?");
        builderZzO.setPositiveButton(resourcesZzf != null ? resourcesZzf.getString(R.string.f5216s3) : "Accept", new zzbui(this, str, lastPathSegment));
        builderZzO.setNegativeButton(resourcesZzf != null ? resourcesZzf.getString(R.string.f5217s4) : "Decline", new zzbuj(this));
        builderZzO.create().show();
    }

    public final /* synthetic */ Context zzb() {
        return this.zzb;
    }
}
