package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.util.zzat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@VisibleForTesting
final class zzi extends RelativeLayout {

    @VisibleForTesting
    final zzat zza;

    @VisibleForTesting
    boolean zzb;

    public zzi(Context context, String str, String str2, String str3) {
        super(context);
        zzat zzatVar = new zzat(context, str);
        this.zza = zzatVar;
        zzatVar.zzd(str2);
        zzatVar.zzc(str3);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.zzb) {
            return false;
        }
        this.zza.zza(motionEvent);
        return false;
    }
}
