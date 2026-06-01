package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.internal.ads.zzbfu;
import com.google.android.gms.internal.ads.zzbfv;
import com.google.android.gms.internal.ads.zzifx;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class zzk implements zzbfu {
    final /* synthetic */ zzbfv zza;
    final /* synthetic */ Bundle zzb;
    final /* synthetic */ Context zzc;
    final /* synthetic */ Uri zzd;

    public zzk(zzs zzsVar, zzbfv zzbfvVar, Bundle bundle, Context context, Uri uri) {
        this.zza = zzbfvVar;
        this.zzb = bundle;
        this.zzc = context;
        this.zzd = uri;
        Objects.requireNonNull(zzsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final void zza() {
        zzbfv zzbfvVar = this.zza;
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder(zzbfvVar.zzc());
        zzs.zzaj(builder, this.zzb);
        CustomTabsIntent customTabsIntentBuild = builder.build();
        Intent intent = customTabsIntentBuild.intent;
        Context context = this.zzc;
        intent.setPackage(zzifx.zza(context));
        customTabsIntentBuild.launchUrl(context, this.zzd);
        zzbfvVar.zzb((Activity) context);
    }
}
