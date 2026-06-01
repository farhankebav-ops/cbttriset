package com.google.android.gms.internal.ads;

import android.hardware.display.DisplayManager;
import android.view.Display;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzabd implements DisplayManager.DisplayListener {
    final /* synthetic */ zzabf zza;
    private final DisplayManager zzb;

    public zzabd(zzabf zzabfVar, DisplayManager displayManager) {
        Objects.requireNonNull(zzabfVar);
        this.zza = zzabfVar;
        this.zzb = displayManager;
    }

    private final Display zzc() {
        return this.zzb.getDisplay(0);
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int i2) {
        if (i2 == 0) {
            this.zza.zzj(zzc());
        }
    }

    public final void zza() {
        this.zzb.registerDisplayListener(this, zzep.zzc(null));
        this.zza.zzj(zzc());
    }

    public final void zzb() {
        this.zzb.unregisterDisplayListener(this);
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int i2) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int i2) {
    }
}
