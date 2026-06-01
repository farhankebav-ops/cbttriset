package com.google.android.gms.internal.ads;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import com.unity3d.services.core.device.MimeTypes;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfpo extends ContentObserver {
    private final Handler zza;
    private final Context zzb;
    private final AudioManager zzc;
    private final AtomicReference zzd;
    private final AtomicBoolean zze;
    private final ExecutorService zzf;
    private final zzfqa zzg;

    public zzfpo(Handler handler, Context context, zzfpk zzfpkVar, zzfqa zzfqaVar) {
        super(handler);
        this.zzd = new AtomicReference(Float.valueOf(-1.0f));
        this.zze = new AtomicBoolean(false);
        this.zzf = Executors.newSingleThreadExecutor();
        this.zza = handler;
        this.zzb = context;
        this.zzc = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.zzg = zzfqaVar;
    }

    private final void zzh() {
        this.zzf.submit(new zzfpn(this));
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z2) {
        if (this.zze.getAndSet(true)) {
            return;
        }
        zzh();
    }

    public final void zza() {
        zzh();
        this.zzb.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public final void zzb() {
        this.zzb.getContentResolver().unregisterContentObserver(this);
    }

    public final /* synthetic */ float zzc() {
        AudioManager audioManager = this.zzc;
        int streamVolume = audioManager.getStreamVolume(3);
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        float f4 = 0.0f;
        if (streamMaxVolume > 0) {
            if (streamVolume <= 0) {
                return 0.0f;
            }
            f4 = streamVolume / streamMaxVolume;
            if (f4 > 1.0f) {
                return 1.0f;
            }
        }
        return f4;
    }

    public final /* synthetic */ Handler zzd() {
        return this.zza;
    }

    public final /* synthetic */ AtomicReference zze() {
        return this.zzd;
    }

    public final /* synthetic */ AtomicBoolean zzf() {
        return this.zze;
    }

    public final /* synthetic */ zzfqa zzg() {
        return this.zzg;
    }
}
