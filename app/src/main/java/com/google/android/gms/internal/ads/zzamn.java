package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzamn implements zzaod {
    private final List zza;

    public zzamn(int i2, List list) {
        this.zza = list;
    }

    private final zzant zzc(zzaoc zzaocVar) {
        return new zzant(zze(zzaocVar), "video/mp2t");
    }

    private final zzaoi zzd(zzaoc zzaocVar) {
        return new zzaoi(zze(zzaocVar), "video/mp2t");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v4 */
    private final List zze(zzaoc zzaocVar) {
        String str;
        int i2;
        List listSingletonList;
        zzeg zzegVar = new zzeg(zzaocVar.zze);
        ArrayList arrayList = this.zza;
        while (zzegVar.zzd() > 0) {
            int iZzs = zzegVar.zzs();
            int iZzg = zzegVar.zzg() + zzegVar.zzs();
            if (iZzs == 134) {
                arrayList = new ArrayList();
                int iZzs2 = zzegVar.zzs() & 31;
                for (int i8 = 0; i8 < iZzs2; i8++) {
                    String strZzK = zzegVar.zzK(3, StandardCharsets.UTF_8);
                    int iZzs3 = zzegVar.zzs();
                    boolean z2 = (iZzs3 & 128) != 0;
                    if (z2) {
                        i2 = iZzs3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i2 = 1;
                    }
                    byte bZzs = (byte) zzegVar.zzs();
                    zzegVar.zzk(1);
                    if (z2) {
                        int i9 = bZzs & 64;
                        int i10 = zzdd.zza;
                        listSingletonList = Collections.singletonList(i9 != 0 ? new byte[]{1} : new byte[]{0});
                    } else {
                        listSingletonList = null;
                    }
                    zzt zztVar = new zzt();
                    zztVar.zzm(str);
                    zztVar.zze(strZzK);
                    zztVar.zzJ(i2);
                    zztVar.zzp(listSingletonList);
                    arrayList.add(zztVar.zzM());
                }
            }
            zzegVar.zzh(iZzg);
            arrayList = arrayList;
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzaod
    public final SparseArray zza() {
        return new SparseArray();
    }

    @Override // com.google.android.gms.internal.ads.zzaod
    @Nullable
    public final zzaof zzb(int i2, zzaoc zzaocVar) {
        if (i2 != 2) {
            if (i2 == 3 || i2 == 4) {
                return new zzanj(new zzanc(zzaocVar.zzb, zzaocVar.zza(), "video/mp2t"));
            }
            if (i2 == 21) {
                return new zzanj(new zzana("video/mp2t"));
            }
            if (i2 == 27) {
                return new zzanj(new zzamx(zzc(zzaocVar), false, false, "video/mp2t"));
            }
            if (i2 == 36) {
                return new zzanj(new zzamz(zzc(zzaocVar), "video/mp2t"));
            }
            if (i2 == 45) {
                return new zzanj(new zzand("video/mp2t"));
            }
            if (i2 == 89) {
                return new zzanj(new zzamp(zzaocVar.zzd, "video/mp2t"));
            }
            if (i2 == 172) {
                return new zzanj(new zzamj(zzaocVar.zzb, zzaocVar.zza(), "video/mp2t"));
            }
            if (i2 == 257) {
                return new zzanr(new zzani("application/vnd.dvb.ait", "video/mp2t"));
            }
            if (i2 != 128) {
                if (i2 != 129) {
                    if (i2 != 138) {
                        if (i2 == 139) {
                            return new zzanj(new zzamo(zzaocVar.zzb, zzaocVar.zza(), 5408, "video/mp2t"));
                        }
                        switch (i2) {
                            case 15:
                                return new zzanj(new zzamm(false, zzaocVar.zzb, zzaocVar.zza(), "video/mp2t"));
                            case 16:
                                return new zzanj(new zzamv(zzd(zzaocVar), "video/mp2t"));
                            case 17:
                                return new zzanj(new zzanb(zzaocVar.zzb, zzaocVar.zza(), "video/mp2t"));
                            default:
                                switch (i2) {
                                    case STORE_REGION_CODE_ERROR_VALUE:
                                        return new zzanr(new zzani("application/x-scte35", "video/mp2t"));
                                    case INVALID_CONFIG_RESPONSE_VALUE:
                                        break;
                                    case PRIVACY_URL_ERROR_VALUE:
                                        break;
                                    default:
                                        return null;
                                }
                                break;
                        }
                    }
                    return new zzanj(new zzamo(zzaocVar.zzb, zzaocVar.zza(), 4096, "video/mp2t"));
                }
                return new zzanj(new zzamg(zzaocVar.zzb, zzaocVar.zza(), "video/mp2t"));
            }
        }
        return new zzanj(new zzams(zzd(zzaocVar), "video/mp2t"));
    }

    public zzamn() {
        this(0);
    }

    public zzamn(int i2) {
        this.zza = zzgpe.zzi();
    }
}
