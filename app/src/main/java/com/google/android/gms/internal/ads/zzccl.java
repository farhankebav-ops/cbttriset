package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzccl {
    private final WeakReference zza;

    public zzccl(View view) {
        this.zza = new WeakReference(view);
    }

    public abstract void zza(ViewTreeObserver viewTreeObserver);

    public abstract void zzb(ViewTreeObserver viewTreeObserver);

    public final void zzc() {
        ViewTreeObserver viewTreeObserverZze = zze();
        if (viewTreeObserverZze != null) {
            zza(viewTreeObserverZze);
        }
    }

    public final void zzd() {
        ViewTreeObserver viewTreeObserverZze = zze();
        if (viewTreeObserverZze != null) {
            zzb(viewTreeObserverZze);
        }
    }

    @Nullable
    public final ViewTreeObserver zze() {
        ViewTreeObserver viewTreeObserver;
        View view = (View) this.zza.get();
        if (view == null || (viewTreeObserver = view.getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return null;
        }
        return viewTreeObserver;
    }
}
