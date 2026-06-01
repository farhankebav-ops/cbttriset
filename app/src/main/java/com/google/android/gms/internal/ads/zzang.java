package com.google.android.gms.internal.ads;

import androidx.camera.video.internal.workaround.DefaultEncoderProfilesProvider;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzang {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean zza(com.google.android.gms.internal.ads.zzef r18, com.google.android.gms.internal.ads.zzane r19) throws com.google.android.gms.internal.ads.zzat {
        /*
            r0 = r18
            r1 = r19
            r0.zze()
            r2 = 3
            r3 = 8
            int r2 = zzf(r0, r2, r3, r3)
            r1.zza = r2
            r4 = 0
            r5 = -1
            if (r2 == r5) goto Lc1
            r2 = 2
            int r6 = java.lang.Math.max(r2, r3)
            r7 = 32
            int r6 = java.lang.Math.max(r6, r7)
            r8 = 63
            r9 = 1
            if (r6 > r8) goto L26
            r6 = r9
            goto L27
        L26:
            r6 = r4
        L27:
            com.google.android.gms.internal.ads.zzgmd.zza(r6)
            int r6 = r0.zzc()
            r10 = -1
            if (r6 >= r2) goto L34
        L32:
            r12 = r10
            goto L5f
        L34:
            long r12 = r0.zzk(r2)
            r14 = 3
            int r6 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r6 != 0) goto L5f
            int r6 = r0.zzc()
            if (r6 >= r3) goto L45
            goto L32
        L45:
            long r12 = r0.zzk(r3)
            long r14 = r14 + r12
            r16 = 255(0xff, double:1.26E-321)
            int r3 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r3 != 0) goto L5e
            int r3 = r0.zzc()
            if (r3 >= r7) goto L57
            goto L32
        L57:
            long r6 = r0.zzk(r7)
            long r12 = r6 + r14
            goto L5f
        L5e:
            r12 = r14
        L5f:
            r1.zzb = r12
            int r3 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r3 != 0) goto L66
            return r4
        L66:
            r6 = 16
            int r3 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r3 > 0) goto La1
            r6 = 0
            int r3 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r3 != 0) goto L93
            int r3 = r1.zza
            r6 = 0
            if (r3 == r9) goto L8c
            if (r3 == r2) goto L85
            r2 = 17
            if (r3 == r2) goto L7e
            goto L93
        L7e:
            java.lang.String r0 = "AudioTruncation packet with invalid packet label 0"
            com.google.android.gms.internal.ads.zzat r0 = com.google.android.gms.internal.ads.zzat.zzb(r0, r6)
            throw r0
        L85:
            java.lang.String r0 = "Mpegh3daFrame packet with invalid packet label 0"
            com.google.android.gms.internal.ads.zzat r0 = com.google.android.gms.internal.ads.zzat.zzb(r0, r6)
            throw r0
        L8c:
            java.lang.String r0 = "Mpegh3daConfig packet with invalid packet label 0"
            com.google.android.gms.internal.ads.zzat r0 = com.google.android.gms.internal.ads.zzat.zzb(r0, r6)
            throw r0
        L93:
            r2 = 11
            r3 = 24
            int r0 = zzf(r0, r2, r3, r3)
            r1.zzc = r0
            if (r0 == r5) goto La0
            return r9
        La0:
            return r4
        La1:
            java.lang.String r0 = java.lang.String.valueOf(r12)
            int r0 = r0.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r0 = r0 + 49
            r1.<init>(r0)
            java.lang.String r0 = "Contains sub-stream with an invalid packet label "
            r1.append(r0)
            r1.append(r12)
            java.lang.String r0 = r1.toString()
            com.google.android.gms.internal.ads.zzat r0 = com.google.android.gms.internal.ads.zzat.zzc(r0)
            throw r0
        Lc1:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzang.zza(com.google.android.gms.internal.ads.zzef, com.google.android.gms.internal.ads.zzane):boolean");
    }

    public static zzanf zzb(zzef zzefVar) throws zzat {
        int iZzj;
        int i2;
        char c7;
        int i8;
        int i9;
        int iZzj2;
        char c8;
        int iZzj3 = zzefVar.zzj(8);
        int i10 = 5;
        int iZzj4 = zzefVar.zzj(5);
        if (iZzj4 != 31) {
            switch (iZzj4) {
                case 0:
                    iZzj = DefaultEncoderProfilesProvider.DEFAULT_AUDIO_BITRATE;
                    break;
                case 1:
                    iZzj = 88200;
                    break;
                case 2:
                    iZzj = 64000;
                    break;
                case 3:
                    iZzj = 48000;
                    break;
                case 4:
                    iZzj = DefaultEncoderProfilesProvider.DEFAULT_AUDIO_SAMPLE_RATE;
                    break;
                case 5:
                    iZzj = 32000;
                    break;
                case 6:
                    iZzj = 24000;
                    break;
                case 7:
                    iZzj = 22050;
                    break;
                case 8:
                    iZzj = 16000;
                    break;
                case 9:
                    iZzj = 12000;
                    break;
                case 10:
                    iZzj = 11025;
                    break;
                case 11:
                    iZzj = 8000;
                    break;
                case 12:
                    iZzj = 7350;
                    break;
                case 13:
                case 14:
                default:
                    StringBuilder sb = new StringBuilder(String.valueOf(iZzj4).length() + 32);
                    sb.append("Unsupported sampling rate index ");
                    sb.append(iZzj4);
                    throw zzat.zzc(sb.toString());
                case 15:
                    iZzj = 57600;
                    break;
                case 16:
                    iZzj = 51200;
                    break;
                case 17:
                    iZzj = 40000;
                    break;
                case 18:
                    iZzj = 38400;
                    break;
                case 19:
                    iZzj = 34150;
                    break;
                case 20:
                    iZzj = 28800;
                    break;
                case 21:
                    iZzj = 25600;
                    break;
                case 22:
                    iZzj = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
                    break;
                case 23:
                    iZzj = 19200;
                    break;
                case 24:
                    iZzj = 17075;
                    break;
                case 25:
                    iZzj = 14400;
                    break;
                case 26:
                    iZzj = 12800;
                    break;
                case 27:
                    iZzj = 9600;
                    break;
            }
        } else {
            iZzj = zzefVar.zzj(24);
        }
        int iZzj5 = zzefVar.zzj(3);
        int i11 = 1;
        if (iZzj5 == 0) {
            i2 = 768;
        } else if (iZzj5 == 1) {
            i2 = 1024;
        } else if (iZzj5 == 2 || iZzj5 == 3) {
            i2 = 2048;
        } else {
            if (iZzj5 != 4) {
                StringBuilder sb2 = new StringBuilder(com.google.android.gms.ads.internal.client.a.a(iZzj5, 36));
                sb2.append("Unsupported coreSbrFrameLengthIndex ");
                sb2.append(iZzj5);
                throw zzat.zzc(sb2.toString());
            }
            i2 = 4096;
        }
        if (iZzj5 == 0 || iZzj5 == 1) {
            c7 = 0;
        } else if (iZzj5 == 2) {
            c7 = 2;
        } else if (iZzj5 == 3) {
            c7 = 3;
        } else {
            if (iZzj5 != 4) {
                StringBuilder sb3 = new StringBuilder(com.google.android.gms.ads.internal.client.a.a(iZzj5, 36));
                sb3.append("Unsupported coreSbrFrameLengthIndex ");
                sb3.append(iZzj5);
                throw zzat.zzc(sb3.toString());
            }
            c7 = 1;
        }
        zzefVar.zzh(2);
        zzc(zzefVar);
        int iZzj6 = zzefVar.zzj(5);
        int i12 = 0;
        int iZzf = 0;
        while (true) {
            int i13 = 16;
            if (i12 < iZzj6 + 1) {
                int iZzj7 = zzefVar.zzj(3);
                iZzf += zzf(zzefVar, 5, 8, 16) + 1;
                if ((iZzj7 == 0 || iZzj7 == 2) && zzefVar.zzi()) {
                    zzc(zzefVar);
                }
                i12++;
            } else {
                int iZzf2 = zzf(zzefVar, 4, 8, 16) + 1;
                zzefVar.zzg();
                int i14 = 0;
                while (true) {
                    double d8 = 2.0d;
                    if (i14 >= iZzf2) {
                        int i15 = iZzj3;
                        byte[] bArr = null;
                        if (zzefVar.zzi()) {
                            int iZzf3 = zzf(zzefVar, 2, 4, 8) + 1;
                            for (int i16 = 0; i16 < iZzf3; i16++) {
                                int iZzf4 = zzf(zzefVar, 4, 8, 16);
                                int iZzf5 = zzf(zzefVar, 4, 8, 16);
                                if (iZzf4 == 7) {
                                    int iZzj8 = zzefVar.zzj(4) + 1;
                                    zzefVar.zzh(4);
                                    byte[] bArr2 = new byte[iZzj8];
                                    for (int i17 = 0; i17 < iZzj8; i17++) {
                                        bArr2[i17] = (byte) zzefVar.zzj(8);
                                    }
                                    bArr = bArr2;
                                } else {
                                    zzefVar.zzh(iZzf5 * 8);
                                }
                            }
                        }
                        byte[] bArr3 = bArr;
                        switch (iZzj) {
                            case 14700:
                            case 16000:
                                d8 = 3.0d;
                                break;
                            case 22050:
                            case 24000:
                                break;
                            case 29400:
                            case 32000:
                            case 58800:
                            case 64000:
                                d8 = 1.5d;
                                break;
                            case DefaultEncoderProfilesProvider.DEFAULT_AUDIO_SAMPLE_RATE /* 44100 */:
                            case 48000:
                            case 88200:
                            case DefaultEncoderProfilesProvider.DEFAULT_AUDIO_BITRATE /* 96000 */:
                                d8 = 1.0d;
                                break;
                            default:
                                StringBuilder sb4 = new StringBuilder(String.valueOf(iZzj).length() + 26);
                                sb4.append("Unsupported sampling rate ");
                                sb4.append(iZzj);
                                throw zzat.zzc(sb4.toString());
                        }
                        return new zzanf(i15, (int) (((double) iZzj) * d8), (int) (((double) i2) * d8), bArr3, null);
                    }
                    int iZzj9 = zzefVar.zzj(2);
                    if (iZzj9 == 0) {
                        i8 = iZzj3;
                        i9 = i11;
                        zzd(zzefVar);
                        if (c7 > 0) {
                            zze(zzefVar);
                        }
                    } else if (iZzj9 == i11) {
                        i9 = i11;
                        if (zzd(zzefVar)) {
                            zzefVar.zzg();
                        }
                        if (c7 > 0) {
                            zze(zzefVar);
                            iZzj2 = zzefVar.zzj(2);
                            c8 = c7;
                        } else {
                            iZzj2 = 0;
                            c8 = 0;
                        }
                        if (iZzj2 > 0) {
                            zzefVar.zzh(6);
                            int iZzj10 = zzefVar.zzj(2);
                            zzefVar.zzh(4);
                            if (zzefVar.zzi()) {
                                zzefVar.zzh(i10);
                            }
                            if (iZzj2 == 2 || iZzj2 == 3) {
                                zzefVar.zzh(6);
                            }
                            if (iZzj10 == 2) {
                                zzefVar.zzg();
                            }
                        }
                        i8 = iZzj3;
                        int iFloor = ((int) Math.floor(Math.log(iZzf - 1) / Math.log(2.0d))) + 1;
                        int iZzj11 = zzefVar.zzj(2);
                        if (iZzj11 > 0 && zzefVar.zzi()) {
                            zzefVar.zzh(iFloor);
                        }
                        if (zzefVar.zzi()) {
                            zzefVar.zzh(iFloor);
                        }
                        if (c8 == 0 && iZzj11 == 0) {
                            zzefVar.zzg();
                        }
                    } else if (iZzj9 != 3) {
                        i8 = iZzj3;
                        i9 = i11;
                    } else {
                        zzf(zzefVar, 4, 8, i13);
                        int iZzf6 = zzf(zzefVar, 4, 8, i13);
                        i9 = i11;
                        if (zzefVar.zzi()) {
                            zzf(zzefVar, 8, i13, 0);
                        }
                        zzefVar.zzg();
                        if (iZzf6 > 0) {
                            zzefVar.zzh(iZzf6 * 8);
                        }
                        i8 = iZzj3;
                    }
                    i14++;
                    iZzj3 = i8;
                    i11 = i9;
                    i10 = 5;
                    i13 = 16;
                }
            }
        }
    }

    private static void zzc(zzef zzefVar) {
        int iZzj;
        int iZzj2 = zzefVar.zzj(2);
        if (iZzj2 == 0) {
            zzefVar.zzh(6);
            return;
        }
        int iZzf = zzf(zzefVar, 5, 8, 16) + 1;
        if (iZzj2 == 1) {
            zzefVar.zzh(iZzf * 7);
            return;
        }
        if (iZzj2 == 2) {
            boolean zZzi = zzefVar.zzi();
            int i2 = true != zZzi ? 5 : 1;
            int i8 = true == zZzi ? 7 : 5;
            int i9 = true == zZzi ? 8 : 6;
            int i10 = 0;
            while (i10 < iZzf) {
                if (zzefVar.zzi()) {
                    zzefVar.zzh(7);
                    iZzj = 0;
                } else {
                    if (zzefVar.zzj(2) == 3 && zzefVar.zzj(i8) * i2 != 0) {
                        zzefVar.zzg();
                    }
                    iZzj = zzefVar.zzj(i9) * i2;
                    if (iZzj != 0 && iZzj != 180) {
                        zzefVar.zzg();
                    }
                    zzefVar.zzg();
                }
                if (iZzj != 0 && iZzj != 180 && zzefVar.zzi()) {
                    i10++;
                }
                i10++;
            }
        }
    }

    private static boolean zzd(zzef zzefVar) {
        zzefVar.zzh(3);
        boolean zZzi = zzefVar.zzi();
        if (zZzi) {
            zzefVar.zzh(13);
        }
        return zZzi;
    }

    private static void zze(zzef zzefVar) {
        zzefVar.zzh(3);
        zzefVar.zzh(8);
        boolean zZzi = zzefVar.zzi();
        boolean zZzi2 = zzefVar.zzi();
        if (zZzi) {
            zzefVar.zzh(5);
        }
        if (zZzi2) {
            zzefVar.zzh(6);
        }
    }

    private static int zzf(zzef zzefVar, int i2, int i8, int i9) {
        zzgmd.zza(Math.max(Math.max(i2, i8), i9) <= 31);
        int i10 = (1 << i2) - 1;
        int i11 = (1 << i8) - 1;
        long j = ((long) i10) + ((long) i11);
        long j3 = (int) j;
        if (j != j3) {
            throw new ArithmeticException();
        }
        if (j3 + ((long) (1 << i9)) != ((int) r6)) {
            throw new ArithmeticException();
        }
        if (zzefVar.zzc() < i2) {
            return -1;
        }
        int iZzj = zzefVar.zzj(i2);
        if (iZzj == i10) {
            if (zzefVar.zzc() < i8) {
                return -1;
            }
            int iZzj2 = zzefVar.zzj(i8);
            iZzj += iZzj2;
            if (iZzj2 == i11) {
                if (zzefVar.zzc() < i9) {
                    return -1;
                }
                return zzefVar.zzj(i9) + iZzj;
            }
        }
        return iZzj;
    }
}
