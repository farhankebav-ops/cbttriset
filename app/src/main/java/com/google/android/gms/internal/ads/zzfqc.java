package com.google.android.gms.internal.ads;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.IntentFilter;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfqc {
    private static final zzfqc zza = new zzfqc();
    private WeakReference zzb;
    private boolean zzc = false;
    private boolean zzd = false;

    public static zzfqc zza() {
        return zza;
    }

    public final void zzb(Context context) {
        if (context == null) {
            return;
        }
        this.zzb = new WeakReference(context);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        context.registerReceiver(new zzfqb(this), intentFilter);
    }

    public final void zzc() {
        KeyguardManager keyguardManager;
        Context context = (Context) this.zzb.get();
        if (context == null || (keyguardManager = (KeyguardManager) context.getSystemService("keyguard")) == null) {
            return;
        }
        boolean zIsDeviceLocked = keyguardManager.isDeviceLocked();
        zzd(this.zzc, zIsDeviceLocked);
        this.zzd = zIsDeviceLocked;
    }

    public final void zzd(boolean z2, boolean z7) {
        if ((z7 || z2) == (this.zzd || this.zzc)) {
            return;
        }
        Iterator it = zzfps.zza().zze().iterator();
        while (it.hasNext()) {
            ((zzfoy) it.next()).zzg().zzg(z7 || z2);
        }
    }

    public final /* synthetic */ void zze(boolean z2) {
        this.zzc = z2;
    }

    public final /* synthetic */ boolean zzf() {
        return this.zzd;
    }
}
