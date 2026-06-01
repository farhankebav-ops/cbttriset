package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzapu implements Comparable {
    private final zzaqf zza;
    private final int zzb;
    private final String zzc;
    private final int zzd;
    private final Object zze;

    @Nullable
    @GuardedBy("mLock")
    private final zzapy zzf;
    private Integer zzg;
    private zzapx zzh;

    @GuardedBy("mLock")
    private boolean zzi;

    @Nullable
    private zzapd zzj;

    @GuardedBy("mLock")
    private zzapt zzk;
    private final zzapi zzl;

    public zzapu(int i2, String str, @Nullable zzapy zzapyVar) {
        Uri uri;
        String host;
        this.zza = zzaqf.zza ? new zzaqf() : null;
        this.zze = new Object();
        int iHashCode = 0;
        this.zzi = false;
        this.zzj = null;
        this.zzb = i2;
        this.zzc = str;
        this.zzf = zzapyVar;
        this.zzl = new zzapi();
        if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null && (host = uri.getHost()) != null) {
            iHashCode = host.hashCode();
        }
        this.zzd = iHashCode;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.zzg.intValue() - ((zzapu) obj).zzg.intValue();
    }

    public final String toString() {
        String strValueOf = String.valueOf(Integer.toHexString(this.zzd));
        zzl();
        Integer num = this.zzg;
        String str = this.zzc;
        int length = String.valueOf(str).length();
        int length2 = String.valueOf(num).length();
        String strConcat = "0x".concat(strValueOf);
        StringBuilder sb = new StringBuilder(strConcat.length() + length + 5 + 8 + length2);
        androidx.camera.core.processing.util.a.A(sb, "[ ] ", str, " ", strConcat);
        sb.append(" NORMAL ");
        sb.append(num);
        return sb.toString();
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzd;
    }

    public final void zzc(String str) {
        if (zzaqf.zza) {
            this.zza.zza(str, Thread.currentThread().getId());
        }
    }

    public final void zzd(String str) {
        zzapx zzapxVar = this.zzh;
        if (zzapxVar != null) {
            zzapxVar.zzc(this);
        }
        if (zzaqf.zza) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzaps(this, str, id));
                return;
            }
            zzaqf zzaqfVar = this.zza;
            zzaqfVar.zza(str, id);
            zzaqfVar.zzb(toString());
        }
    }

    public final void zze(int i2) {
        zzapx zzapxVar = this.zzh;
        if (zzapxVar != null) {
            zzapxVar.zzd(this, i2);
        }
    }

    public final zzapu zzf(zzapx zzapxVar) {
        this.zzh = zzapxVar;
        return this;
    }

    public final zzapu zzg(int i2) {
        this.zzg = Integer.valueOf(i2);
        return this;
    }

    public final String zzh() {
        return this.zzc;
    }

    public final String zzi() {
        int i2 = this.zzb;
        String str = this.zzc;
        if (i2 == 0) {
            return str;
        }
        String string = Integer.toString(1);
        return a1.a.s(new StringBuilder(String.valueOf(string).length() + 1 + String.valueOf(str).length()), string, "-", str);
    }

    public final zzapu zzj(zzapd zzapdVar) {
        this.zzj = zzapdVar;
        return this;
    }

    @Nullable
    public final zzapd zzk() {
        return this.zzj;
    }

    public final boolean zzl() {
        synchronized (this.zze) {
        }
        return false;
    }

    public Map zzm() throws zzapc {
        return Collections.EMPTY_MAP;
    }

    public byte[] zzn() throws zzapc {
        return null;
    }

    public final int zzo() {
        return this.zzl.zza();
    }

    public final void zzp() {
        synchronized (this.zze) {
            this.zzi = true;
        }
    }

    public final boolean zzq() {
        boolean z2;
        synchronized (this.zze) {
            z2 = this.zzi;
        }
        return z2;
    }

    public abstract zzaqa zzr(zzapq zzapqVar);

    public abstract void zzs(Object obj);

    public final void zzt(zzaqd zzaqdVar) {
        zzapy zzapyVar;
        synchronized (this.zze) {
            zzapyVar = this.zzf;
        }
        zzapyVar.zza(zzaqdVar);
    }

    public final void zzu(zzapt zzaptVar) {
        synchronized (this.zze) {
            this.zzk = zzaptVar;
        }
    }

    public final void zzv(zzaqa zzaqaVar) {
        zzapt zzaptVar;
        synchronized (this.zze) {
            zzaptVar = this.zzk;
        }
        if (zzaptVar != null) {
            zzaptVar.zza(this, zzaqaVar);
        }
    }

    public final void zzw() {
        zzapt zzaptVar;
        synchronized (this.zze) {
            zzaptVar = this.zzk;
        }
        if (zzaptVar != null) {
            zzaptVar.zzb(this);
        }
    }

    public final /* synthetic */ zzaqf zzx() {
        return this.zza;
    }

    public final zzapi zzy() {
        return this.zzl;
    }
}
