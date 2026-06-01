package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ironsource.C2300e4;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgh implements zzgb {
    private final Context zza;
    private final List zzb = new ArrayList();
    private final zzgb zzc;

    @Nullable
    private zzgb zzd;

    @Nullable
    private zzgb zze;

    @Nullable
    private zzgb zzf;

    @Nullable
    private zzgb zzg;

    @Nullable
    private zzgb zzh;

    @Nullable
    private zzgb zzi;

    @Nullable
    private zzgb zzj;

    @Nullable
    private zzgb zzk;

    public zzgh(Context context, zzgb zzgbVar) {
        this.zza = context.getApplicationContext();
        this.zzc = zzgbVar;
    }

    private final zzgb zzf() {
        if (this.zze == null) {
            zzfs zzfsVar = new zzfs(this.zza);
            this.zze = zzfsVar;
            zzg(zzfsVar);
        }
        return this.zze;
    }

    private final void zzg(zzgb zzgbVar) {
        int i2 = 0;
        while (true) {
            List list = this.zzb;
            if (i2 >= list.size()) {
                return;
            }
            zzgbVar.zze((zzgz) list.get(i2));
            i2++;
        }
    }

    private static final void zzh(@Nullable zzgb zzgbVar, zzgz zzgzVar) {
        if (zzgbVar != null) {
            zzgbVar.zze(zzgzVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i2, int i8) throws IOException {
        zzgb zzgbVar = this.zzk;
        zzgbVar.getClass();
        return zzgbVar.zza(bArr, i2, i8);
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final long zzb(zzgf zzgfVar) throws IOException {
        zzgb zzgbVar;
        zzgmd.zzh(this.zzk == null);
        Uri uri = zzgfVar.zza;
        String scheme = uri.getScheme();
        String str = zzep.zza;
        String scheme2 = uri.getScheme();
        if (TextUtils.isEmpty(scheme2) || Objects.equals(scheme2, C2300e4.h.f8363b)) {
            String path = uri.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                if (this.zzd == null) {
                    zzgo zzgoVar = new zzgo();
                    this.zzd = zzgoVar;
                    zzg(zzgoVar);
                }
                this.zzk = this.zzd;
            } else {
                this.zzk = zzf();
            }
        } else if ("asset".equals(scheme)) {
            this.zzk = zzf();
        } else if ("content".equals(scheme)) {
            if (this.zzf == null) {
                zzfy zzfyVar = new zzfy(this.zza);
                this.zzf = zzfyVar;
                zzg(zzfyVar);
            }
            this.zzk = this.zzf;
        } else if ("rtmp".equals(scheme)) {
            if (this.zzg == null) {
                try {
                    zzgb zzgbVar2 = (zzgb) Class.forName("androidx.media3.datasource.rtmp.RtmpDataSource").getConstructor(null).newInstance(null);
                    this.zzg = zzgbVar2;
                    zzg(zzgbVar2);
                } catch (ClassNotFoundException unused) {
                    zzdt.zzc("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                } catch (Exception e) {
                    throw new RuntimeException("Error instantiating RTMP extension", e);
                }
                if (this.zzg == null) {
                    this.zzg = this.zzc;
                }
            }
            this.zzk = this.zzg;
        } else if ("udp".equals(scheme)) {
            if (this.zzh == null) {
                zzhb zzhbVar = new zzhb(2000);
                this.zzh = zzhbVar;
                zzg(zzhbVar);
            }
            this.zzk = this.zzh;
        } else if ("data".equals(scheme)) {
            if (this.zzi == null) {
                zzfz zzfzVar = new zzfz();
                this.zzi = zzfzVar;
                zzg(zzfzVar);
            }
            this.zzk = this.zzi;
        } else {
            if ("rawresource".equals(scheme) || "android.resource".equals(scheme)) {
                if (this.zzj == null) {
                    zzgx zzgxVar = new zzgx(this.zza);
                    this.zzj = zzgxVar;
                    zzg(zzgxVar);
                }
                zzgbVar = this.zzj;
            } else {
                zzgbVar = this.zzc;
            }
            this.zzk = zzgbVar;
        }
        return this.zzk.zzb(zzgfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    @Nullable
    public final Uri zzc() {
        zzgb zzgbVar = this.zzk;
        if (zzgbVar == null) {
            return null;
        }
        return zzgbVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final void zzd() throws IOException {
        zzgb zzgbVar = this.zzk;
        if (zzgbVar != null) {
            try {
                zzgbVar.zzd();
            } finally {
                this.zzk = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final void zze(zzgz zzgzVar) {
        zzgzVar.getClass();
        this.zzc.zze(zzgzVar);
        this.zzb.add(zzgzVar);
        zzh(this.zzd, zzgzVar);
        zzh(this.zze, zzgzVar);
        zzh(this.zzf, zzgzVar);
        zzh(this.zzg, zzgzVar);
        zzh(this.zzh, zzgzVar);
        zzh(this.zzi, zzgzVar);
        zzh(this.zzj, zzgzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final Map zzj() {
        zzgb zzgbVar = this.zzk;
        return zzgbVar == null ? Collections.EMPTY_MAP : zzgbVar.zzj();
    }
}
