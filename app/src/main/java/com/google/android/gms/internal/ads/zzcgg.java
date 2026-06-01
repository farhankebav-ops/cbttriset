package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcgg extends zzcdi implements zzgz, zzml {
    public static final /* synthetic */ int zza = 0;
    private final Context zzb;
    private final zzcfq zzc;
    private final zzyi zzd;
    private final zzcdq zze;
    private final WeakReference zzf;
    private final zzwb zzg;

    @Nullable
    private zzim zzh;
    private ByteBuffer zzi;
    private boolean zzj;
    private zzcdh zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private final String zzo;
    private final int zzp;

    @Nullable
    private Integer zzr;
    private final ArrayList zzs;

    @Nullable
    private volatile zzcft zzt;
    private final Object zzq = new Object();
    private final Set zzu = new HashSet();

    /* JADX WARN: Removed duplicated region for block: B:22:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzcgg(android.content.Context r4, com.google.android.gms.internal.ads.zzcdq r5, com.google.android.gms.internal.ads.zzcdr r6, @androidx.annotation.Nullable java.lang.Integer r7) {
        /*
            Method dump skipped, instruction units count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcgg.<init>(android.content.Context, com.google.android.gms.internal.ads.zzcdq, com.google.android.gms.internal.ads.zzcdr, java.lang.Integer):void");
    }

    private final boolean zzY() {
        return this.zzt != null && this.zzt.zzl();
    }

    public final void finalize() {
        zzcdi.zzf().decrementAndGet();
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("SimpleExoPlayerAdapter finalize ".concat(toString()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdi
    public final void zzA(int i2) {
        Iterator it = this.zzu.iterator();
        while (it.hasNext()) {
            zzcfp zzcfpVar = (zzcfp) ((WeakReference) it.next()).get();
            if (zzcfpVar != null) {
                zzcfpVar.zzk(i2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdi
    public final boolean zzB() {
        return this.zzh != null;
    }

    @Override // com.google.android.gms.internal.ads.zzcdi
    public final int zzC() {
        return this.zzh.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzcdi
    public final long zzD() {
        return this.zzh.zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzcdi
    public final void zzE(boolean z2) {
        this.zzh.zzj(z2);
    }

    @Override // com.google.android.gms.internal.ads.zzcdi
    public final void zzF(int i2) {
        this.zzc.zzk(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzcdi
    public final void zzG(int i2) {
        this.zzc.zzl(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzcdi
    public final long zzH() {
        return this.zzh.zzt();
    }

    @Override // com.google.android.gms.internal.ads.zzcdi
    public final long zzI() {
        if (zzY()) {
            return 0L;
        }
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzcdi
    public final long zzJ() {
        if (zzY() && this.zzt.zzm()) {
            return Math.min(this.zzl, this.zzt.zzo());
        }
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzcdi
    public final long zzK() {
        if (zzY()) {
            return this.zzt.zzp();
        }
        synchronized (this.zzq) {
            while (true) {
                ArrayList arrayList = this.zzs;
                if (!arrayList.isEmpty()) {
                    long j = this.zzn;
                    Map mapZzj = ((zzgu) arrayList.remove(0)).zzj();
                    long j3 = 0;
                    if (mapZzj != null) {
                        Iterator it = mapZzj.entrySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Map.Entry entry = (Map.Entry) it.next();
                            if (entry != null) {
                                try {
                                    if (entry.getKey() != null && zzglm.zze("content-length", (CharSequence) entry.getKey()) && entry.getValue() != null && ((List) entry.getValue()).get(0) != null) {
                                        j3 = Long.parseLong((String) ((List) entry.getValue()).get(0));
                                        break;
                                    }
                                } catch (NumberFormatException unused) {
                                    continue;
                                }
                            }
                        }
                    }
                    this.zzn = j + j3;
                }
            }
        }
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzcdi
    public final int zzL() {
        return this.zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzcdi
    public final void zzM(boolean z2) {
        if (this.zzh == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            this.zzh.zzF();
            if (i2 >= 2) {
                return;
            }
            zzyi zzyiVar = this.zzd;
            zzxs zzxsVarZzd = zzyiVar.zzc().zzd();
            zzxsVarZzd.zzy(i2, !z2);
            zzyiVar.zzf(zzxsVarZzd);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdi
    public final long zzN() {
        return this.zzh.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzcdi
    public final long zzO() {
        return this.zzl;
    }

    @VisibleForTesting
    public final zzuw zzR(Uri uri) {
        zzz zzzVar = new zzz();
        zzzVar.zzb(uri);
        zzak zzakVarZzc = zzzVar.zzc();
        zzwb zzwbVar = this.zzg;
        zzwbVar.zza(this.zze.zzf);
        return zzwbVar.zzb(zzakVarZzc);
    }

    public final /* synthetic */ zzgb zzS(String str, boolean z2) {
        zzcgg zzcggVar = true != z2 ? null : this;
        zzcdq zzcdqVar = this.zze;
        return new zzcgj(str, zzcggVar, zzcdqVar.zzd, zzcdqVar.zze, zzcdqVar.zzm, zzcdqVar.zzn);
    }

    public final /* synthetic */ zzgb zzT(String str, boolean z2) {
        zzgi zzgiVar = new zzgi();
        zzgiVar.zzb(str);
        zzgiVar.zzf(true != z2 ? null : this);
        zzcdq zzcdqVar = this.zze;
        zzgiVar.zzc(zzcdqVar.zzd);
        zzgiVar.zzd(zzcdqVar.zze);
        zzgiVar.zze(true);
        return zzgiVar.zza();
    }

    public final /* synthetic */ zzgb zzU(String str, boolean z2) {
        zzcgg zzcggVar = true != z2 ? null : this;
        zzcdq zzcdqVar = this.zze;
        zzcfp zzcfpVar = new zzcfp(str, zzcggVar, zzcdqVar.zzd, zzcdqVar.zze, zzcdqVar.zzh);
        this.zzu.add(new WeakReference(zzcfpVar));
        return zzcfpVar;
    }

    public final /* synthetic */ zzgb zzV(zzga zzgaVar) {
        zzgb zzgbVarZza = zzgaVar.zza();
        zzcfr zzcfrVar = new zzcfr() { // from class: com.google.android.gms.internal.ads.zzcge
            @Override // com.google.android.gms.internal.ads.zzcfr
            public final /* synthetic */ void zza(boolean z2, long j) {
                this.zza.zzX(z2, j);
            }
        };
        return new zzcft(this.zzb, zzgbVarZza, this.zzo, this.zzp, this, zzcfrVar);
    }

    public final /* synthetic */ zzln[] zzW(Handler handler, zzabs zzabsVar, zzqa zzqaVar, zzwy zzwyVar, zzts zztsVar) {
        zztg zztgVar = zztg.zzb;
        Context context = this.zzb;
        zzrl zzrlVar = new zzrl(context, new zzsn(context, null, null), zztgVar, false, handler, zzqaVar, new zzqp(context).zza());
        zzaai zzaaiVar = new zzaai(context);
        zzaaiVar.zza(zztgVar);
        zzaaiVar.zzb(handler);
        zzaaiVar.zzc(zzabsVar);
        return new zzln[]{zzrlVar, zzaaiVar.zzd()};
    }

    public final /* synthetic */ void zzX(boolean z2, long j) {
        zzcdh zzcdhVar = this.zzk;
        if (zzcdhVar != null) {
            zzcdhVar.zzr(z2, j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgz
    public final void zzb(zzgb zzgbVar, zzgf zzgfVar, boolean z2) {
        if (zzgbVar instanceof zzgu) {
            synchronized (this.zzq) {
                this.zzs.add((zzgu) zzgbVar);
            }
        } else if (zzgbVar instanceof zzcft) {
            this.zzt = (zzcft) zzgbVar;
            final zzcdr zzcdrVar = (zzcdr) this.zzf.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzch)).booleanValue() && zzcdrVar != null && this.zzt.zzk()) {
                final HashMap map = new HashMap();
                map.put("gcacheHit", String.valueOf(this.zzt.zzm()));
                map.put("gcacheDownloaded", String.valueOf(this.zzt.zzn()));
                com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgf
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        int i2 = zzcgg.zza;
                        zzcdrVar.zze("onGcacheInfoEvent", map);
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgz
    public final void zzc(zzgb zzgbVar, zzgf zzgfVar, boolean z2, int i2) {
        this.zzl += i2;
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final /* synthetic */ void zzdj(zzmj zzmjVar, zzba zzbaVar, zzba zzbaVar2, int i2) {
        i0.a(this, zzmjVar, zzbaVar, zzbaVar2, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final /* synthetic */ void zzdk(zzmj zzmjVar, zzuq zzuqVar) {
        i0.b(this, zzmjVar, zzuqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final /* synthetic */ void zzdl(zzmj zzmjVar, int i2, long j, long j3) {
        i0.c(this, zzmjVar, i2, j, j3);
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final /* synthetic */ void zzdm(zzmj zzmjVar, zzhs zzhsVar) {
        i0.d(this, zzmjVar, zzhsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final /* synthetic */ void zzdn(zzbb zzbbVar, zzmk zzmkVar) {
        i0.e(this, zzbbVar, zzmkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final void zze(zzmj zzmjVar, int i2) {
        zzcdh zzcdhVar = this.zzk;
        if (zzcdhVar != null) {
            zzcdhVar.zzs(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final void zzg(zzmj zzmjVar, zzau zzauVar) {
        zzcdh zzcdhVar = this.zzk;
        if (zzcdhVar != null) {
            zzcdhVar.zzu("onPlayerError", zzauVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final void zzh(zzmj zzmjVar, zzul zzulVar, zzuq zzuqVar, IOException iOException, boolean z2) {
        zzcdh zzcdhVar = this.zzk;
        if (zzcdhVar != null) {
            if (this.zze.zzj) {
                zzcdhVar.zzv("onLoadException", iOException);
            } else {
                zzcdhVar.zzu("onLoadError", iOException);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdi
    @Nullable
    public final Integer zzj() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final void zzk(zzmj zzmjVar, zzv zzvVar, @Nullable zzht zzhtVar) {
        zzcdr zzcdrVar = (zzcdr) this.zzf.get();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzch)).booleanValue() || zzcdrVar == null) {
            return;
        }
        HashMap map = new HashMap();
        String str = zzvVar.zzn;
        if (str != null) {
            map.put("audioMime", str);
        }
        String str2 = zzvVar.zzo;
        if (str2 != null) {
            map.put("audioSampleMime", str2);
        }
        String str3 = zzvVar.zzk;
        if (str3 != null) {
            map.put("audioCodec", str3);
        }
        zzcdrVar.zze("onMetadataEvent", map);
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final void zzl(zzmj zzmjVar, zzv zzvVar, @Nullable zzht zzhtVar) {
        zzcdr zzcdrVar = (zzcdr) this.zzf.get();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzch)).booleanValue() || zzcdrVar == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("frameRate", String.valueOf(zzvVar.zzz));
        map.put("bitRate", String.valueOf(zzvVar.zzj));
        int i2 = zzvVar.zzv;
        int i8 = zzvVar.zzw;
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 1 + String.valueOf(i8).length());
        sb.append(i2);
        sb.append("x");
        sb.append(i8);
        map.put("resolution", sb.toString());
        String str = zzvVar.zzn;
        if (str != null) {
            map.put("videoMime", str);
        }
        String str2 = zzvVar.zzo;
        if (str2 != null) {
            map.put("videoSampleMime", str2);
        }
        String str3 = zzvVar.zzk;
        if (str3 != null) {
            map.put("videoCodec", str3);
        }
        zzcdrVar.zze("onMetadataEvent", map);
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final void zzm(zzmj zzmjVar, int i2, long j) {
        this.zzm += i2;
    }

    @Override // com.google.android.gms.internal.ads.zzcdi
    public final void zzn(@Nullable Integer num) {
        this.zzr = num;
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final void zzo(zzmj zzmjVar, Object obj, long j) {
        zzcdh zzcdhVar = this.zzk;
        if (zzcdhVar != null) {
            zzcdhVar.zzD();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final void zzp(zzmj zzmjVar, zzbv zzbvVar) {
        zzcdh zzcdhVar = this.zzk;
        if (zzcdhVar != null) {
            zzcdhVar.zzt(zzbvVar.zzb, zzbvVar.zzc);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdi
    public final void zzq(Uri[] uriArr, String str) {
        zzr(uriArr, str, ByteBuffer.allocate(0), false);
    }

    @Override // com.google.android.gms.internal.ads.zzcdi
    public final void zzr(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z2) {
        zzuw zzvlVar;
        if (this.zzh != null) {
            this.zzi = byteBuffer;
            this.zzj = z2;
            int length = uriArr.length;
            if (length == 1) {
                zzvlVar = zzR(uriArr[0]);
            } else {
                zzuw[] zzuwVarArr = new zzuw[length];
                for (int i2 = 0; i2 < uriArr.length; i2++) {
                    zzuwVarArr[i2] = zzR(uriArr[i2]);
                }
                zzvlVar = new zzvl(false, false, new zzuf(), zzuwVarArr);
            }
            this.zzh.zzG(zzvlVar);
            this.zzh.zzg();
            zzcdi.zzi().incrementAndGet();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdi
    public final void zzs(zzcdh zzcdhVar) {
        this.zzk = zzcdhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcdi
    public final void zzt() {
        zzim zzimVar = this.zzh;
        if (zzimVar != null) {
            zzimVar.zzE(this);
            this.zzh.zzH();
            this.zzh = null;
            zzcdi.zzi().decrementAndGet();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdi
    public final void zzu(Surface surface, boolean z2) {
        zzim zzimVar = this.zzh;
        if (zzimVar != null) {
            zzimVar.zzC(surface);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdi
    public final void zzv(float f4, boolean z2) {
        zzim zzimVar = this.zzh;
        if (zzimVar != null) {
            zzimVar.zzB(f4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdi
    public final void zzw() {
        this.zzh.zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzcdi
    public final void zzx(long j) {
        this.zzh.zzb(j);
    }

    @Override // com.google.android.gms.internal.ads.zzcdi
    public final void zzy(int i2) {
        this.zzc.zzm(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzcdi
    public final void zzz(int i2) {
        this.zzc.zzn(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzgz
    public final void zza(zzgb zzgbVar, zzgf zzgfVar, boolean z2) {
    }

    @Override // com.google.android.gms.internal.ads.zzgz
    public final void zzd(zzgb zzgbVar, zzgf zzgfVar, boolean z2) {
    }
}
