package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgaz {

    @Nullable
    private MotionEvent zzb;
    private final ArrayDeque zza = new ArrayDeque();
    private zzgax zzc = new zzgax();

    public final synchronized void zza(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 1) {
                this.zzb = MotionEvent.obtain(motionEvent);
            }
            this.zzc.zza(motionEvent);
            ArrayDeque arrayDeque = this.zza;
            if (arrayDeque.size() >= 6) {
                arrayDeque.remove();
            }
            arrayDeque.add(new zzgay(motionEvent));
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzb(Map map) {
        try {
            MotionEvent motionEvent = this.zzb;
            if (motionEvent != null) {
                map.put("nv", motionEvent);
            }
            map.put("oe", this.zzc);
            ArrayDeque arrayDeque = this.zza;
            map.put("ro", arrayDeque.toArray(new zzgay[arrayDeque.size()]));
            this.zzc = new zzgax();
            arrayDeque.clear();
            MotionEvent motionEvent2 = this.zzb;
            if (motionEvent2 != null) {
                motionEvent2.recycle();
                this.zzb = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
