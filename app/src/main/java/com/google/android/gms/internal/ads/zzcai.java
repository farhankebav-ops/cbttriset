package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcai implements SharedPreferences.OnSharedPreferenceChangeListener {
    final /* synthetic */ zzcal zza;
    private final String zzb;

    public zzcai(zzcal zzcalVar, String str) {
        Objects.requireNonNull(zzcalVar);
        this.zza = zzcalVar;
        this.zzb = str;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        zzcal zzcalVar = this.zza;
        synchronized (zzcalVar) {
            try {
                Iterator it = zzcalVar.zzd().iterator();
                while (it.hasNext()) {
                    ((zzcaj) it.next()).zza(sharedPreferences, this.zzb, str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
