package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationManagerCompat;
import androidx.work.WorkRequest;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzrl extends zzte implements zzko {
    private final Context zzb;
    private final zzpz zzc;
    private final zzqh zzd;

    @Nullable
    private final zzsr zze;
    private int zzf;
    private boolean zzg;
    private boolean zzh;

    @Nullable
    private zzv zzi;

    @Nullable
    private zzv zzj;
    private long zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private int zzo;
    private boolean zzp;
    private long zzq;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzrl(Context context, zzst zzstVar, zztg zztgVar, boolean z2, @Nullable Handler handler, @Nullable zzqa zzqaVar, zzqh zzqhVar) {
        super(1, zzstVar, zztgVar, false, 44100.0f);
        byte[] bArr = null;
        zzsr zzsrVar = Build.VERSION.SDK_INT >= 35 ? new zzsr(zzsq.zzb) : null;
        this.zzb = context.getApplicationContext();
        this.zzd = zzqhVar;
        this.zze = zzsrVar;
        this.zzo = NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
        this.zzc = new zzpz(handler, zzqaVar);
        this.zzq = -9223372036854775807L;
        zzqhVar.zza(new zzrk(this, bArr));
    }

    private static List zzbf(zztg zztgVar, zzv zzvVar, boolean z2, zzqh zzqhVar) throws zzti {
        zzsy zzsyVarZza;
        return zzvVar.zzo == null ? zzgpe.zzi() : (!zzqhVar.zzd(zzvVar) || (zzsyVarZza = zztq.zza()) == null) ? zztq.zzc(zztgVar, zzvVar, false, false) : zzgpe.zzj(zzsyVarZza);
    }

    private final int zzbg(zzsy zzsyVar, zzv zzvVar) {
        if ("OMX.google.raw.decoder".equals(zzsyVar.zza) && Build.VERSION.SDK_INT == 23 && !zzep.zzN(this.zzb)) {
            return -1;
        }
        return zzvVar.zzp;
    }

    private final void zzbh() {
        long jZzg = this.zzd.zzg(zzZ());
        if (jZzg != Long.MIN_VALUE) {
            if (!this.zzl) {
                jZzg = Math.max(this.zzk, jZzg);
            }
            this.zzk = jZzg;
            this.zzl = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzhr
    public final void zzA(long j, boolean z2, boolean z7) throws zzib {
        super.zzA(j, z2, z7);
        this.zzd.zzz();
        this.zzk = j;
        this.zzq = -9223372036854775807L;
        this.zzn = false;
        this.zzl = true;
    }

    @Override // com.google.android.gms.internal.ads.zzhr
    public final void zzB() {
        this.zzd.zzi();
        this.zzp = true;
    }

    @Override // com.google.android.gms.internal.ads.zzhr
    public final void zzC() {
        zzbh();
        this.zzp = false;
        this.zzd.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzhr
    public final void zzD() {
        this.zzm = true;
        this.zzi = null;
        this.zzq = -9223372036854775807L;
        try {
            this.zzd.zzz();
            super.zzD();
        } catch (Throwable th) {
            super.zzD();
            throw th;
        } finally {
            this.zzc.zzg(((zzte) this).zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzhr
    public final void zzE() {
        this.zzn = false;
        this.zzq = -9223372036854775807L;
        try {
            super.zzE();
            if (this.zzm) {
                this.zzm = false;
                this.zzd.zzA();
            }
        } catch (Throwable th) {
            if (this.zzm) {
                this.zzm = false;
                this.zzd.zzA();
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhr
    public final void zzF() {
        zzsr zzsrVar;
        this.zzd.zzB();
        if (Build.VERSION.SDK_INT < 35 || (zzsrVar = this.zze) == null) {
            return;
        }
        zzsrVar.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzln, com.google.android.gms.internal.ads.zzlp
    public final String zzS() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzln
    public final boolean zzY() {
        return this.zzd.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzln
    public final boolean zzZ() {
        return super.zzZ() && this.zzd.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final int zzac(zztg zztgVar, zzv zzvVar) throws zzti {
        int i2;
        boolean z2;
        String str = zzvVar.zzo;
        if (!zzas.zza(str)) {
            return 128;
        }
        int i8 = zzvVar.zzN;
        boolean zZzbd = zzte.zzbd(zzvVar);
        int i9 = 1;
        if (!zZzbd || (i8 != 0 && zztq.zza() == null)) {
            i2 = 0;
        } else {
            zzqh zzqhVar = this.zzd;
            zzpl zzplVarZzf = zzqhVar.zzf(zzvVar);
            if (zzplVarZzf.zzb) {
                i2 = true != zzplVarZzf.zzc ? 512 : 1536;
                if (zzplVarZzf.zzd) {
                    i2 |= 2048;
                }
            } else {
                i2 = 0;
            }
            if (zzqhVar.zzd(zzvVar)) {
                return i2 | 172;
            }
        }
        if (!"audio/raw".equals(str) || this.zzd.zzd(zzvVar)) {
            zzqh zzqhVar2 = this.zzd;
            if (zzqhVar2.zzd(zzep.zzy(2, zzvVar.zzG, zzvVar.zzH))) {
                List listZzbf = zzbf(zztgVar, zzvVar, false, zzqhVar2);
                if (!listZzbf.isEmpty()) {
                    if (zZzbd) {
                        zzsy zzsyVar = (zzsy) listZzbf.get(0);
                        boolean zZzc = zzsyVar.zzc(zzvVar);
                        if (zZzc) {
                            z2 = true;
                        } else {
                            for (int i10 = 1; i10 < listZzbf.size(); i10++) {
                                zzsy zzsyVar2 = (zzsy) listZzbf.get(i10);
                                if (zzsyVar2.zzc(zzvVar)) {
                                    z2 = false;
                                    zZzc = true;
                                    zzsyVar = zzsyVar2;
                                    break;
                                }
                            }
                            z2 = true;
                        }
                        int i11 = true != zZzc ? 3 : 4;
                        int i12 = 8;
                        if (zZzc && zzsyVar.zze(zzvVar)) {
                            i12 = 16;
                        }
                        return i11 | i12 | 32 | (true != zzsyVar.zzg ? 0 : 64) | (true != z2 ? 0 : 128) | i2;
                    }
                    i9 = 2;
                }
            }
        }
        return i9 | 128;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final List zzad(zztg zztgVar, zzv zzvVar, boolean z2) throws zzti {
        return zztq.zze(zzbf(zztgVar, zzvVar, false, this.zzd), zzvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final boolean zzae(zzv zzvVar) {
        zzJ();
        return this.zzd.zzd(zzvVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cd  */
    @Override // com.google.android.gms.internal.ads.zzte
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.ads.zzss zzaf(com.google.android.gms.internal.ads.zzsy r10, com.google.android.gms.internal.ads.zzv r11, @androidx.annotation.Nullable android.media.MediaCrypto r12, float r13) {
        /*
            Method dump skipped, instruction units count: 338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrl.zzaf(com.google.android.gms.internal.ads.zzsy, com.google.android.gms.internal.ads.zzv, android.media.MediaCrypto, float):com.google.android.gms.internal.ads.zzss");
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final zzht zzag(zzsy zzsyVar, zzv zzvVar, zzv zzvVar2) {
        int i2;
        int i8;
        zzht zzhtVarZzf = zzsyVar.zzf(zzvVar, zzvVar2);
        int i9 = zzhtVarZzf.zze;
        if (zzaB(zzvVar2)) {
            i9 |= 32768;
        }
        if (zzbg(zzsyVar, zzvVar2) > this.zzf) {
            i9 |= 64;
        }
        String str = zzsyVar.zza;
        if (i9 != 0) {
            i8 = 0;
            i2 = i9;
        } else {
            i2 = 0;
            i8 = zzhtVarZzf.zzd;
        }
        return new zzht(str, zzvVar, zzvVar2, i8, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final long zzah(long j, long j3, boolean z2) {
        zzqh zzqhVar = this.zzd;
        boolean z7 = false;
        if (zzqhVar.zzn() && this.zzq != -9223372036854775807L) {
            z7 = true;
        }
        if (!this.zzp) {
            if (z7 || super.zzZ()) {
                return 1000000L;
            }
            return WorkRequest.MIN_BACKOFF_MILLIS;
        }
        long jZzv = zzqhVar.zzv();
        if (!z7 || jZzv == -9223372036854775807L) {
            return WorkRequest.MIN_BACKOFF_MILLIS;
        }
        return Math.max(WorkRequest.MIN_BACKOFF_MILLIS, ((long) ((Math.min(jZzv, this.zzq - j) / (zzj() != null ? zzj().zzb : 1.0f)) / 2.0f)) - (zzep.zzq(zzL().zzb()) - j3));
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final float zzai(float f4, zzv zzvVar, zzv[] zzvVarArr) {
        int iMax = -1;
        for (zzv zzvVar2 : zzvVarArr) {
            int i2 = zzvVar2.zzH;
            if (i2 != -1) {
                iMax = Math.max(iMax, i2);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return iMax * f4;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final void zzaj(String str, zzss zzssVar, long j, long j3) {
        this.zzc.zzb(str, j, j3);
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final void zzak(String str) {
        this.zzc.zzf(str);
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final void zzal(Exception exc) {
        zzdt.zzf("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.zzc.zzj(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzte
    @Nullable
    public final zzht zzam(zzkj zzkjVar) throws zzib {
        zzv zzvVar = zzkjVar.zzb;
        zzvVar.getClass();
        this.zzi = zzvVar;
        zzht zzhtVarZzam = super.zzam(zzkjVar);
        this.zzc.zzc(zzvVar, zzhtVarZzam);
        return zzhtVarZzam;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final void zzan(zzv zzvVar, @Nullable MediaFormat mediaFormat) throws zzib {
        int i2;
        zzv zzvVar2 = this.zzj;
        int[] iArr = null;
        boolean z2 = true;
        if (zzvVar2 != null) {
            zzvVar = zzvVar2;
        } else if (zzaE() != null) {
            mediaFormat.getClass();
            int iZzz = "audio/raw".equals(zzvVar.zzo) ? zzvVar.zzI : (Build.VERSION.SDK_INT < 24 || !mediaFormat.containsKey("pcm-encoding")) ? mediaFormat.containsKey("v-bits-per-sample") ? zzep.zzz(mediaFormat.getInteger("v-bits-per-sample"), ByteOrder.LITTLE_ENDIAN) : 2 : mediaFormat.getInteger("pcm-encoding");
            zzt zztVar = new zzt();
            zztVar.zzm("audio/raw");
            zztVar.zzG(iZzz);
            zztVar.zzH(zzvVar.zzJ);
            zztVar.zzI(zzvVar.zzK);
            zztVar.zzk(zzvVar.zzl);
            zztVar.zza(zzvVar.zza);
            zztVar.zzc(zzvVar.zzb);
            zztVar.zzd(zzvVar.zzc);
            zztVar.zze(zzvVar.zzd);
            zztVar.zzf(zzvVar.zze);
            zztVar.zzg(zzvVar.zzf);
            zztVar.zzE(mediaFormat.getInteger("channel-count"));
            zztVar.zzF(mediaFormat.getInteger("sample-rate"));
            zzv zzvVarZzM = zztVar.zzM();
            if (this.zzg && zzvVarZzM.zzG == 6 && (i2 = zzvVar.zzG) < 6) {
                iArr = new int[i2];
                for (int i8 = 0; i8 < i2; i8++) {
                    iArr[i8] = i8;
                }
            } else if (this.zzh) {
                int i9 = zzvVarZzM.zzG;
                if (i9 == 3) {
                    iArr = new int[]{0, 2, 1};
                } else if (i9 == 5) {
                    iArr = new int[]{0, 2, 1, 3, 4};
                } else if (i9 == 6) {
                    iArr = new int[]{0, 2, 1, 5, 3, 4};
                } else if (i9 == 7) {
                    iArr = new int[]{0, 2, 1, 6, 5, 3, 4};
                } else if (i9 == 8) {
                    iArr = new int[]{0, 2, 1, 7, 5, 6, 3, 4};
                }
            }
            zzvVar = zzvVarZzM;
        }
        try {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 29) {
                if (zzaD()) {
                    zzJ();
                }
                if (i10 < 29) {
                    z2 = false;
                }
                zzgmd.zzh(z2);
            }
            this.zzd.zzh(zzvVar, 0, iArr);
        } catch (zzqc e) {
            throw zzN(e, e.zza, false, IronSourceConstants.errorCode_biddingDataException);
        }
    }

    @CallSuper
    public final void zzao() {
        this.zzl = true;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final void zzap() {
        this.zzd.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final boolean zzaq(long j, long j3, @Nullable zzsv zzsvVar, @Nullable ByteBuffer byteBuffer, int i2, int i8, int i9, long j8, boolean z2, boolean z7, zzv zzvVar) throws zzib {
        byteBuffer.getClass();
        this.zzq = -9223372036854775807L;
        if (this.zzj != null && (i8 & 2) != 0) {
            zzsvVar.getClass();
            zzsvVar.zzc(i2, false);
            return true;
        }
        if (z2) {
            if (zzsvVar != null) {
                zzsvVar.zzc(i2, false);
            }
            ((zzte) this).zza.zzf += i9;
            this.zzd.zzj();
            return true;
        }
        try {
            if (!this.zzd.zzk(byteBuffer, j8, i9)) {
                this.zzq = j8;
                return false;
            }
            if (zzsvVar != null) {
                zzsvVar.zzc(i2, false);
            }
            ((zzte) this).zza.zze += i9;
            return true;
        } catch (zzqd e) {
            zzv zzvVar2 = this.zzi;
            if (zzaD()) {
                zzJ();
            }
            throw zzN(e, zzvVar2, e.zzb, IronSourceConstants.errorCode_biddingDataException);
        } catch (zzqg e4) {
            if (zzaD()) {
                zzJ();
            }
            throw zzN(e4, zzvVar, e4.zzb, IronSourceConstants.errorCode_isReadyException);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final void zzar() throws zzib {
        try {
            this.zzd.zzl();
            if (zzba() != -9223372036854775807L) {
                this.zzq = zzba();
            }
        } catch (zzqg e) {
            throw zzN(e, e.zzc, e.zzb, true != zzaD() ? IronSourceConstants.errorCode_isReadyException : IronSourceConstants.errorCode_loadInProgress);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final void zzas(zzhh zzhhVar) {
        zzv zzvVar;
        if (Build.VERSION.SDK_INT < 29 || (zzvVar = zzhhVar.zza) == null || !Objects.equals(zzvVar.zzo, "audio/opus") || !zzaD()) {
            return;
        }
        ByteBuffer byteBuffer = zzhhVar.zzf;
        byteBuffer.getClass();
        zzv zzvVar2 = zzhhVar.zza;
        zzvVar2.getClass();
        int i2 = zzvVar2.zzJ;
        if (byteBuffer.remaining() == 8) {
            this.zzd.zzw(i2, (int) ((byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong() * 48000) / 1000000000));
        }
    }

    public final /* synthetic */ zzpz zzaw() {
        return this.zzc;
    }

    public final /* synthetic */ zzsr zzax() {
        return this.zze;
    }

    public final /* synthetic */ void zzay(boolean z2) {
        this.zzn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzko
    public final long zzg() {
        if (zze() == 2) {
            zzbh();
        }
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzko
    public final boolean zzh() {
        boolean z2 = this.zzn;
        this.zzn = false;
        return z2;
    }

    @Override // com.google.android.gms.internal.ads.zzko
    public final void zzi(zzav zzavVar) {
        this.zzd.zzo(zzavVar);
    }

    @Override // com.google.android.gms.internal.ads.zzko
    public final zzav zzj() {
        return this.zzd.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzhr, com.google.android.gms.internal.ads.zzli
    public final void zzx(int i2, @Nullable Object obj) throws zzib {
        zzsr zzsrVar;
        if (i2 == 2) {
            zzqh zzqhVar = this.zzd;
            obj.getClass();
            zzqhVar.zzx(((Float) obj).floatValue());
            return;
        }
        if (i2 == 3) {
            zzd zzdVar = (zzd) obj;
            zzqh zzqhVar2 = this.zzd;
            zzdVar.getClass();
            zzqhVar2.zzr(zzdVar);
            return;
        }
        if (i2 == 6) {
            zze zzeVar = (zze) obj;
            zzqh zzqhVar3 = this.zzd;
            zzeVar.getClass();
            zzqhVar3.zzt(zzeVar);
            return;
        }
        if (i2 == 12) {
            this.zzd.zzu((AudioDeviceInfo) obj);
            return;
        }
        if (i2 == 16) {
            obj.getClass();
            this.zzo = ((Integer) obj).intValue();
            zzsv zzsvVarZzaE = zzaE();
            if (zzsvVarZzaE == null || Build.VERSION.SDK_INT < 35) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("importance", Math.max(0, -this.zzo));
            zzsvVarZzaE.zzo(bundle);
            return;
        }
        if (i2 == 9) {
            zzqh zzqhVar4 = this.zzd;
            obj.getClass();
            zzqhVar4.zzq(((Boolean) obj).booleanValue());
        } else {
            if (i2 != 10) {
                super.zzx(i2, obj);
                return;
            }
            obj.getClass();
            int iIntValue = ((Integer) obj).intValue();
            this.zzd.zzs(iIntValue);
            if (Build.VERSION.SDK_INT < 35 || (zzsrVar = this.zze) == null) {
                return;
            }
            zzsrVar.zza(iIntValue);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzhr
    public final void zzy(boolean z2, boolean z7) throws zzib {
        super.zzy(z2, z7);
        this.zzc.zza(((zzte) this).zza);
        zzJ();
        zzqh zzqhVar = this.zzd;
        zzqhVar.zzb(zzK());
        zzqhVar.zzc(zzL());
    }

    @Override // com.google.android.gms.internal.ads.zzhr, com.google.android.gms.internal.ads.zzln
    @Nullable
    public final zzko zzd() {
        return this;
    }
}
