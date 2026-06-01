package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzacw implements zzadg {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14, 17, 18, 19, 20, 21};
    private static final zzacv zzc = new zzacv(zzact.zza);
    private static final zzacv zzd = new zzacv(zzacs.zza);

    @Nullable
    private zzgpe zze;
    private final zzakg zzf = new zzakb();

    private final void zzc(int i2, List list) {
        switch (i2) {
            case 0:
                list.add(new zzamf());
                break;
            case 1:
                list.add(new zzami());
                break;
            case 2:
                list.add(new zzaml(0));
                break;
            case 3:
                list.add(new zzaeu(0));
                break;
            case 4:
                zzada zzadaVarZza = zzc.zza(0);
                if (zzadaVarZza == null) {
                    list.add(new zzafl(0));
                } else {
                    list.add(zzadaVarZza);
                }
                break;
            case 5:
                list.add(new zzafo());
                break;
            case 6:
                list.add(new zzahk(this.zzf, 0));
                break;
            case 7:
                list.add(new zzahs(0));
                break;
            case 8:
                zzakg zzakgVar = this.zzf;
                list.add(new zzair(zzakgVar, 0, null, null, zzgpe.zzi(), null));
                list.add(new zzaiz(zzakgVar, 0));
                break;
            case 9:
                list.add(new zzajp());
                break;
            case 10:
                list.add(new zzanp());
                break;
            case 11:
                if (this.zze == null) {
                    this.zze = zzgpe.zzi();
                }
                list.add(new zzaoa(1, 0, this.zzf, new zzem(0L), new zzamn(0, this.zze), 112800));
                break;
            case 12:
                list.add(new zzaon());
                break;
            case 14:
                list.add(new zzafu(0));
                break;
            case 15:
                zzada zzadaVarZza2 = zzd.zza(new Object[0]);
                if (zzadaVarZza2 != null) {
                    list.add(zzadaVarZza2);
                }
                break;
            case 16:
                list.add(new zzaey(0, this.zzf));
                break;
            case 17:
                list.add(new zzajz());
                break;
            case 18:
                list.add(new zzaos());
                break;
            case 19:
                list.add(new zzafg());
                break;
            case 20:
                list.add(new zzaft());
                break;
            case 21:
                list.add(new zzaff());
                break;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadg
    public final synchronized zzada[] zza() {
        return zzb(Uri.EMPTY, new HashMap());
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
    @Override // com.google.android.gms.internal.ads.zzadg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized com.google.android.gms.internal.ads.zzada[] zzb(android.net.Uri r24, java.util.Map r25) {
        /*
            Method dump skipped, instruction units count: 1028
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacw.zzb(android.net.Uri, java.util.Map):com.google.android.gms.internal.ads.zzada[]");
    }
}
