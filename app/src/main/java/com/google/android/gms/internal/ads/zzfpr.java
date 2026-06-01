package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfpr extends zzfpu {
    private static final zzfpr zzb = new zzfpr();

    private zzfpr() {
    }

    public static zzfpr zza() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfpu
    public final boolean zzb() {
        Iterator it = zzfps.zza().zzf().iterator();
        while (it.hasNext()) {
            View viewZzi = ((zzfoy) it.next()).zzi();
            if (viewZzi != null && viewZzi.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfpu
    public final void zzc(boolean z2) {
        Iterator it = zzfps.zza().zze().iterator();
        while (it.hasNext()) {
            ((zzfoy) it.next()).zzg().zzf(z2);
        }
    }
}
