package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Rect;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzalo {
    private boolean zzb;
    private boolean zzc;
    private int[] zzd;
    private int zze;
    private int zzf;

    @Nullable
    private Rect zzg;
    private final int[] zza = new int[4];
    private int zzh = -1;
    private int zzi = -1;

    private static int zze(int[] iArr, int i2) {
        if (i2 >= iArr.length) {
            i2 = 0;
        }
        return iArr[i2];
    }

    private static int zzf(int i2, int i8) {
        return (i2 & ViewCompat.MEASURED_SIZE_MASK) | ((i8 * 17) << 24);
    }

    private final void zzg(zzef zzefVar, boolean z2, Rect rect, int[] iArr) {
        int i2;
        int i8;
        int i9 = !z2 ? 1 : 0;
        int iWidth = rect.width();
        int i10 = i9 * iWidth;
        int iHeight = rect.height();
        while (true) {
            int i11 = 0;
            do {
                int iZzj = 0;
                for (int i12 = 1; iZzj < i12 && i12 <= 64; i12 <<= 2) {
                    if (zzefVar.zzc() < 4) {
                        i2 = -1;
                        i8 = 0;
                        break;
                    }
                    iZzj = (iZzj << 4) | zzefVar.zzj(4);
                }
                i2 = iZzj & 3;
                i8 = iZzj < 4 ? iWidth : iZzj >> 2;
                int iMin = Math.min(i8, iWidth - i11);
                if (iMin > 0) {
                    int i13 = i10 + iMin;
                    Arrays.fill(iArr, i10, i13, this.zza[i2]);
                    i11 += iMin;
                    i10 = i13;
                }
            } while (i11 < iWidth);
            i9 += 2;
            if (i9 >= iHeight) {
                return;
            }
            i10 = i9 * iWidth;
            zzefVar.zzm();
        }
    }

    public final void zza(String str) {
        int i2;
        String strTrim = str.trim();
        String str2 = zzep.zza;
        for (String str3 : strTrim.split("\\r?\\n", -1)) {
            if (str3.startsWith("palette: ")) {
                String[] strArrSplit = str3.substring(9).split(",", -1);
                this.zzd = new int[strArrSplit.length];
                for (int i8 = 0; i8 < strArrSplit.length; i8++) {
                    int[] iArr = this.zzd;
                    try {
                        i2 = Integer.parseInt(strArrSplit[i8].trim(), 16);
                    } catch (RuntimeException unused) {
                        i2 = 0;
                    }
                    iArr[i8] = i2;
                }
            } else if (str3.startsWith("size: ")) {
                String[] strArrSplit2 = str3.substring(6).trim().split("x", -1);
                if (strArrSplit2.length == 2) {
                    try {
                        this.zze = Integer.parseInt(strArrSplit2[0]);
                        this.zzf = Integer.parseInt(strArrSplit2[1]);
                        this.zzb = true;
                    } catch (RuntimeException e) {
                        zzdt.zzd("VobsubParser", "Parsing IDX failed", e);
                    }
                }
            }
        }
    }

    public final void zzb(zzeg zzegVar) {
        int[] iArr = this.zzd;
        if (iArr == null || !this.zzb) {
            return;
        }
        zzegVar.zzk(zzegVar.zzt() - 2);
        int iZzt = zzegVar.zzt();
        while (zzegVar.zzg() < iZzt && zzegVar.zzd() > 0) {
            switch (zzegVar.zzs()) {
                case 0:
                case 1:
                case 2:
                    break;
                case 3:
                    if (zzegVar.zzd() < 2) {
                        return;
                    }
                    int iZzs = zzegVar.zzs();
                    int iZzs2 = zzegVar.zzs();
                    int[] iArr2 = this.zza;
                    iArr2[3] = zze(iArr, iZzs >> 4);
                    iArr2[2] = zze(iArr, iZzs & 15);
                    iArr2[1] = zze(iArr, iZzs2 >> 4);
                    iArr2[0] = zze(iArr, iZzs2 & 15);
                    this.zzc = true;
                    break;
                case 4:
                    if (zzegVar.zzd() < 2 || !this.zzc) {
                        return;
                    }
                    int iZzs3 = zzegVar.zzs();
                    int iZzs4 = zzegVar.zzs();
                    int[] iArr3 = this.zza;
                    iArr3[3] = zzf(iArr3[3], iZzs3 >> 4);
                    iArr3[2] = zzf(iArr3[2], iZzs3 & 15);
                    iArr3[1] = zzf(iArr3[1], iZzs4 >> 4);
                    iArr3[0] = zzf(iArr3[0], iZzs4 & 15);
                    break;
                case 5:
                    if (zzegVar.zzd() < 6) {
                        return;
                    }
                    int iZzs5 = zzegVar.zzs();
                    int iZzs6 = zzegVar.zzs();
                    int i2 = iZzs6 >> 4;
                    int iZzs7 = ((iZzs6 & 15) << 8) | zzegVar.zzs();
                    int iZzs8 = zzegVar.zzs();
                    int iZzs9 = zzegVar.zzs();
                    this.zzg = new Rect((iZzs5 << 4) | i2, (iZzs8 << 4) | (iZzs9 >> 4), iZzs7 + 1, (((iZzs9 & 15) << 8) | zzegVar.zzs()) + 1);
                    break;
                case 6:
                    if (zzegVar.zzd() < 4) {
                        return;
                    }
                    this.zzh = zzegVar.zzt();
                    this.zzi = zzegVar.zzt();
                    break;
                default:
                    return;
            }
        }
    }

    @Nullable
    public final zzcm zzc(zzeg zzegVar) {
        Rect rect;
        if (this.zzd == null || !this.zzb || !this.zzc || (rect = this.zzg) == null || this.zzh == -1 || this.zzi == -1 || rect.width() < 2 || this.zzg.height() < 2) {
            return null;
        }
        Rect rect2 = this.zzg;
        int[] iArr = new int[rect2.height() * rect2.width()];
        zzef zzefVar = new zzef();
        zzegVar.zzh(this.zzh);
        zzefVar.zza(zzegVar);
        zzg(zzefVar, true, rect2, iArr);
        zzegVar.zzh(this.zzi);
        zzefVar.zza(zzegVar);
        zzg(zzefVar, false, rect2, iArr);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, rect2.width(), rect2.height(), Bitmap.Config.ARGB_8888);
        zzcl zzclVar = new zzcl();
        zzclVar.zzc(bitmapCreateBitmap);
        zzclVar.zzi(rect2.left / this.zze);
        zzclVar.zzj(0);
        zzclVar.zzf(rect2.top / this.zzf, 0);
        zzclVar.zzg(0);
        zzclVar.zzm(rect2.width() / this.zze);
        zzclVar.zzn(rect2.height() / this.zzf);
        return zzclVar.zzr();
    }

    public final void zzd() {
        this.zzc = false;
        this.zzg = null;
        this.zzh = -1;
        this.zzi = -1;
    }
}
