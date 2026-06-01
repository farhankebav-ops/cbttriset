package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzckc implements zzifh {
    private zzckc(zzcjp zzcjpVar) {
    }

    public static zzckc zza(zzcjp zzcjpVar) {
        return new zzckc(zzcjpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setPackage("com.android.vending");
        intent.setData(Uri.parse("https://play.google.com/d"));
        return intent;
    }
}
