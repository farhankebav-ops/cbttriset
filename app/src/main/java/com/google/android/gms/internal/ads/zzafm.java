package com.google.android.gms.internal.ads;

import androidx.camera.video.internal.workaround.DefaultEncoderProfilesProvider;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzafm extends zzafr {
    private static final int[] zzb = {5512, 11025, 22050, DefaultEncoderProfilesProvider.DEFAULT_AUDIO_SAMPLE_RATE};
    private boolean zzc;
    private boolean zzd;
    private int zze;

    public zzafm(zzaem zzaemVar) {
        super(zzaemVar);
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final boolean zza(zzeg zzegVar) throws zzafq {
        if (this.zzc) {
            zzegVar.zzk(1);
        } else {
            int iZzs = zzegVar.zzs();
            int i2 = iZzs >> 4;
            this.zze = i2;
            if (i2 == 2) {
                int i8 = zzb[(iZzs >> 2) & 3];
                zzt zztVar = new zzt();
                zztVar.zzl("video/x-flv");
                zztVar.zzm("audio/mpeg");
                zztVar.zzE(1);
                zztVar.zzF(i8);
                this.zza.zzu(zztVar.zzM());
                this.zzd = true;
            } else if (i2 == 7 || i2 == 8) {
                zzt zztVar2 = new zzt();
                zztVar2.zzl("video/x-flv");
                zztVar2.zzm(i2 == 7 ? "audio/g711-alaw" : "audio/g711-mlaw");
                zztVar2.zzE(1);
                zztVar2.zzF(8000);
                this.zza.zzu(zztVar2.zzM());
                this.zzd = true;
            } else if (i2 != 10) {
                throw new zzafq(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(i2).length() + 28), "Audio format not supported: ", i2));
            }
            this.zzc = true;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final boolean zzb(zzeg zzegVar, long j) throws zzat {
        if (this.zze == 2) {
            int iZzd = zzegVar.zzd();
            zzaem zzaemVar = this.zza;
            zzaemVar.zzz(zzegVar, iZzd);
            zzaemVar.zzx(j, 1, iZzd, 0, null);
            return true;
        }
        int iZzs = zzegVar.zzs();
        if (iZzs != 0 || this.zzd) {
            if (this.zze == 10 && iZzs != 1) {
                return false;
            }
            int iZzd2 = zzegVar.zzd();
            zzaem zzaemVar2 = this.zza;
            zzaemVar2.zzz(zzegVar, iZzd2);
            zzaemVar2.zzx(j, 1, iZzd2, 0, null);
            return true;
        }
        int iZzd3 = zzegVar.zzd();
        byte[] bArr = new byte[iZzd3];
        zzegVar.zzm(bArr, 0, iZzd3);
        zzaby zzabyVarZza = zzabz.zza(bArr);
        zzt zztVar = new zzt();
        zztVar.zzl("video/x-flv");
        zztVar.zzm(DefaultEncoderProfilesProvider.DEFAULT_AUDIO_MIME_TYPE);
        zztVar.zzj(zzabyVarZza.zzc);
        zztVar.zzE(zzabyVarZza.zzb);
        zztVar.zzF(zzabyVarZza.zza);
        zztVar.zzp(Collections.singletonList(bArr));
        this.zza.zzu(zztVar.zzM());
        this.zzd = true;
        return false;
    }
}
