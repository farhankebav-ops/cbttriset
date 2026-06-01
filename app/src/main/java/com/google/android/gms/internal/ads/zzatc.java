package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzatc {
    public int zza = 1;
    private Object zzb;
    private long zzc;
    private double zzd;
    private zzasg zze;
    private List zzf;
    private zzasu zzg;

    private zzatc() {
    }

    public static zzatc zza(Object obj) {
        zzatc zzatcVar = new zzatc();
        int[] iArr = {572660336, 1963204074, 810270723, 1168973800, 12304897, -1027511958, 1433925857, 2084420925, 1937477084};
        int i2 = iArr[0];
        int i8 = iArr[1];
        int i9 = iArr[2];
        int i10 = iArr[3];
        int i11 = iArr[4];
        int i12 = iArr[5];
        int i13 = iArr[6];
        int i14 = iArr[7];
        int iC = com.google.android.gms.ads.internal.client.a.c((i8 & (~i2)) | i9, (i2 & i10) | i11, i12, i13);
        zzatcVar.zzr();
        zzatcVar.zza = (i14 % 1937477084) ^ iC;
        zzatcVar.zzb = obj;
        return zzatcVar;
    }

    public static zzatc zzb(long j) {
        zzatc zzatcVar = new zzatc();
        int[] iArr = {269455306, 1628467785, 508432336, 1769894153, 149815616, -1737813993, 468055906, 524872353, 327254586};
        int i2 = iArr[0];
        int i8 = iArr[1];
        int i9 = iArr[2];
        int i10 = iArr[3];
        int i11 = iArr[4];
        int i12 = iArr[5];
        int i13 = iArr[6];
        int i14 = iArr[7];
        int iC = com.google.android.gms.ads.internal.client.a.c((i8 & (~i2)) | i9, (i2 & i10) | i11, i12, i13);
        zzatcVar.zzr();
        zzatcVar.zza = (i14 % 327254586) ^ iC;
        zzatcVar.zzc = j;
        return zzatcVar;
    }

    public static zzatc zzc(double d8) {
        zzatc zzatcVar = new zzatc();
        int[] iArr = {76065818, 1629326670, 912768099, 1092092300, 784816880, -1349977414, 434065736, 1884661237, 1605908235};
        int i2 = iArr[0];
        int i8 = iArr[1];
        int i9 = iArr[2];
        int i10 = iArr[3];
        int i11 = iArr[4];
        int i12 = iArr[5];
        int i13 = iArr[6];
        int i14 = iArr[7];
        int iC = com.google.android.gms.ads.internal.client.a.c((i8 & (~i2)) | i9, (i2 & i10) | i11, i12, i13);
        zzatcVar.zzr();
        zzatcVar.zza = (i14 % 1605908235) ^ iC;
        zzatcVar.zzd = d8;
        return zzatcVar;
    }

    public static zzatc zzd(zzasg zzasgVar) {
        zzatc zzatcVar = new zzatc();
        int[] iArr = {1143408282, 544368152, 1884037077, 79323401, 1472762119, -801477845, 201305624, 1470503465, 1402586708};
        int i2 = iArr[0];
        int i8 = iArr[1];
        int i9 = iArr[2];
        int i10 = iArr[3];
        int i11 = iArr[4];
        int i12 = iArr[5];
        int i13 = iArr[6];
        int i14 = iArr[7];
        int iC = com.google.android.gms.ads.internal.client.a.c((i8 & (~i2)) | i9, (i2 & i10) | i11, i12, i13);
        zzatcVar.zzr();
        zzatcVar.zza = (i14 % 1402586708) ^ iC;
        zzatcVar.zze = zzasgVar;
        return zzatcVar;
    }

    public static zzatc zze(List list) {
        zzatc zzatcVar = new zzatc();
        int[] iArr = {231602422, 370241669, 619070592, 319896591, 694865338, 1425770340, 39950860, 555996658, 324763920};
        int i2 = iArr[0];
        int i8 = iArr[1];
        int i9 = iArr[2];
        int i10 = iArr[3];
        int i11 = iArr[4];
        int i12 = iArr[5];
        int i13 = iArr[6];
        int i14 = iArr[7];
        int iC = com.google.android.gms.ads.internal.client.a.c((i8 & (~i2)) | i9, (i2 & i10) | i11, i12, i13);
        zzatcVar.zzr();
        zzatcVar.zza = (i14 % 324763920) ^ iC;
        zzatcVar.zzf = list;
        return zzatcVar;
    }

    public static zzatc zzf(zzasu zzasuVar) {
        zzatc zzatcVar = new zzatc();
        int[] iArr = {1315209188, 67133601, 1612794668, 612376713, 2023183116, -774012042, 5007439, 661761152, 474613996};
        int i2 = iArr[0];
        int i8 = iArr[1];
        int i9 = iArr[2];
        int i10 = iArr[3];
        int i11 = iArr[4];
        int i12 = iArr[5];
        int i13 = iArr[6];
        int i14 = iArr[7];
        int iC = com.google.android.gms.ads.internal.client.a.c((i8 & (~i2)) | i9, (i2 & i10) | i11, i12, i13);
        zzatcVar.zzr();
        zzatcVar.zza = (i14 % 474613996) ^ iC;
        zzatcVar.zzg = zzasuVar;
        return zzatcVar;
    }

    public static zzatc zzg(Object obj) {
        if (obj instanceof Long) {
            return zzb(((Long) obj).longValue());
        }
        if (obj instanceof Boolean) {
            return zzb(true != ((Boolean) obj).booleanValue() ? 0L : 1L);
        }
        if (obj instanceof Integer) {
            return zzb(((Integer) obj).intValue());
        }
        if (obj instanceof Double) {
            return zzc(((Double) obj).doubleValue());
        }
        if (obj instanceof Float) {
            return zzc(((Float) obj).floatValue());
        }
        if (obj instanceof Short) {
            return zzb(((Short) obj).shortValue());
        }
        if (obj instanceof Byte) {
            return zzb(((Byte) obj).byteValue());
        }
        if (obj instanceof zzasg) {
            return zzd((zzasg) obj);
        }
        if (obj instanceof String) {
            return zzd(zzasg.zzf((String) obj));
        }
        if (!(obj instanceof ArrayList)) {
            return zza(obj);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = (ArrayList) obj;
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(zzg(arrayList2.get(i2)));
        }
        return zze(arrayList);
    }

    public static zzatc zzj(zzatc zzatcVar) {
        int[] iArr = {1154349542, 1365661854, 772762753, -35647458, -1399059520, 905919471, 65677639, 1759726503, 552812661};
        int i2 = iArr[0];
        int i8 = iArr[1];
        int i9 = iArr[2];
        int i10 = iArr[3];
        int i11 = iArr[4];
        int i12 = iArr[5];
        int i13 = iArr[6];
        int i14 = iArr[7];
        int iC = com.google.android.gms.ads.internal.client.a.c((i8 & (~i2)) | i9, (i2 & i10) | i11, i12, i13);
        int i15 = i14 % 552812661;
        try {
            int i16 = zzatcVar.zza;
            int i17 = (i15 ^ iC) + i16;
            if (i16 == 0) {
                throw null;
            }
            switch (i17) {
                case 0:
                    return new zzatc();
                case 1:
                    return zza(zzatcVar.zzl());
                case 2:
                    return zzb(zzatcVar.zzm());
                case 3:
                    return zzd(zzatcVar.zzn());
                case 4:
                    ArrayList arrayList = new ArrayList();
                    Iterator it = zzatcVar.zzo().iterator();
                    while (it.hasNext()) {
                        arrayList.add(zzj((zzatc) it.next()));
                    }
                    return zze(arrayList);
                case 5:
                    return zzf(zzatcVar.zzp());
                case 6:
                    return zzc(zzatcVar.zzq());
                default:
                    throw new AssertionError(zzase.zza("HkezqgQcPni/TE/NwjgYPC5H6Q2JRdEp275wOg=="));
            }
        } catch (zzasz e) {
            throw new AssertionError(zzase.zza("CEiv6BFfPnitUE+D"), e);
        }
    }

    private final void zzr() {
        this.zza = 1;
        this.zzc = 0L;
        this.zzb = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = null;
    }

    private final void zzs(int i2) throws zzasz {
        if (i2 != this.zza) {
            throw new zzasz();
        }
    }

    public final Object zzh() throws zzasz {
        int[] iArr = {172154289, 1050326876, 843682288, -858640882, -228026365, 881347074, 13857144, 514820752, 473891334};
        int i2 = iArr[0];
        int i8 = iArr[1];
        int i9 = iArr[2];
        int i10 = iArr[3];
        int i11 = iArr[4];
        int i12 = iArr[5];
        int i13 = iArr[6];
        int i14 = iArr[7];
        int iC = com.google.android.gms.ads.internal.client.a.c((i8 & (~i2)) | i9, (i2 & i10) | i11, i12, i13);
        int i15 = this.zza;
        int i16 = ((i14 % 473891334) ^ iC) + i15;
        if (i15 == 0) {
            throw null;
        }
        switch (i16) {
            case 0:
            case 5:
                throw new zzasz();
            case 1:
                return zzl();
            case 2:
                return Long.valueOf(zzm());
            case 3:
                return zzn().zza();
            case 4:
                ArrayList arrayList = new ArrayList();
                Iterator it = zzo().iterator();
                while (it.hasNext()) {
                    arrayList.add(((zzatc) it.next()).zzh());
                }
                return arrayList;
            case 6:
                return Double.valueOf(zzq());
            default:
                throw new AssertionError(zzase.zza("HkezqgQcPni/TE/NwjgYPC5H6Q2JRdEp275wOg=="));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:138:0x0252, code lost:
    
        if (r19.equals(java.lang.Object.class) != false) goto L150;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzi(java.lang.Class r19) throws com.google.android.gms.internal.ads.zzasz {
        /*
            Method dump skipped, instruction units count: 698
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzatc.zzi(java.lang.Class):java.lang.Object");
    }

    public final void zzk(OutputStream outputStream) throws zzasz, IOException {
        long[] jArr = {1269833163, 1628598594, 308676977, 1629286434, 15633520, 3337700125L, 1402923307, 613197917, 297598514};
        long j = jArr[0];
        long j3 = jArr[1];
        long j8 = jArr[2];
        long j9 = jArr[3];
        long j10 = jArr[4];
        long j11 = jArr[5];
        long j12 = jArr[6];
        long j13 = jArr[7];
        long j14 = (((((~j) & j3) | j8) + ((j & j9) | j10)) - j11) + j12;
        long j15 = j13 % 297598514;
        int i2 = ((((~136416008) & 1315652152) | 568681609) + ((136416008 & 1310591536) | 838183178)) - (-1654427070);
        int i8 = 1414460396 % 78756298;
        int i9 = ((((~1202640845) & 472047875) | 1135942642) + ((1202640845 & 1006822481) | 585369424)) - 1952913860;
        int i10 = 1225708428 % 987359759;
        int i11 = this.zza;
        int i12 = ((((((~1959970879) & 1489831444) | 1998984087) + ((1959970879 & (-1446423480)) | (-182037905))) - (-2117037800)) ^ (1544048623 % 665228399)) + i11;
        if (i11 == 0) {
            throw null;
        }
        switch (i12) {
            case 0:
            case 1:
            case 5:
                throw new zzasz();
            case 2:
                zzasc.zzb(zzm(), new zzatb(outputStream, 1), true);
                return;
            case 3:
                byte[] bArr = zzn().zza;
                zzasc.zzb(((long) bArr.length) * (j14 ^ j15), new zzatb(outputStream, 0), true);
                outputStream.write(bArr);
                return;
            case 4:
                List listZzo = zzo();
                zzasc.zzb(listZzo.size(), new zzatb(outputStream, i9 ^ i10), true);
                Iterator it = listZzo.iterator();
                while (it.hasNext()) {
                    ((zzatc) it.next()).zzk(outputStream);
                }
                return;
            case 6:
                double dZzq = zzq();
                zzatb zzatbVar = new zzatb(outputStream, i2 ^ i8);
                long jDoubleToRawLongBits = Double.doubleToRawLongBits(dZzq);
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate((((((~1470558289) & 1721781326) | 2037102441) + ((1470558289 & 109139991) | 560281113)) - (-1975232131)) ^ (1043353969 % 656635246));
                byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
                byteBufferAllocate.putLong(jDoubleToRawLongBits);
                for (byte b8 : byteBufferAllocate.array()) {
                    zzatbVar.zza(b8);
                }
                int length = byteBufferAllocate.array().length;
                return;
            default:
                return;
        }
    }

    public final Object zzl() throws zzasz {
        int[] iArr = {427355115, 404248040, 1318670750, 874677346, 1819730563, -970011213, 126401947, 1858504292, 235745791};
        int i2 = iArr[0];
        int i8 = iArr[1];
        int i9 = iArr[2];
        int i10 = iArr[3];
        int i11 = iArr[4];
        int i12 = iArr[5];
        int i13 = iArr[6];
        zzs((iArr[7] % 235745791) ^ com.google.android.gms.ads.internal.client.a.c((i8 & (~i2)) | i9, (i2 & i10) | i11, i12, i13));
        return this.zzb;
    }

    public final long zzm() throws zzasz {
        int[] iArr = {1646478179, 763209928, 1529626135, 609321208, 1403807536, -1382063087, 25624641, 1388803074, 733327814};
        int i2 = iArr[0];
        int i8 = iArr[1];
        int i9 = iArr[2];
        int i10 = iArr[3];
        int i11 = iArr[4];
        int i12 = iArr[5];
        int i13 = iArr[6];
        zzs((iArr[7] % 733327814) ^ com.google.android.gms.ads.internal.client.a.c((i8 & (~i2)) | i9, (i2 & i10) | i11, i12, i13));
        return this.zzc;
    }

    public final zzasg zzn() throws zzasz {
        int[] iArr = {2059344234, 1917530355, 739411611, 1399403104, 95815174, 2094390031, 51245830, 1312994984, 1140384172};
        int i2 = iArr[0];
        int i8 = iArr[1];
        int i9 = iArr[2];
        int i10 = iArr[3];
        int i11 = iArr[4];
        int i12 = iArr[5];
        int i13 = iArr[6];
        zzs((iArr[7] % 1140384172) ^ com.google.android.gms.ads.internal.client.a.c((i8 & (~i2)) | i9, (i2 & i10) | i11, i12, i13));
        return this.zze;
    }

    public final List zzo() throws zzasz {
        int[] iArr = {1435218189, 1093276829, 949583962, 1092752517, 575966040, -2054938211, 262178224, 1891252715, 1250801052};
        int i2 = iArr[0];
        int i8 = iArr[1];
        int i9 = iArr[2];
        int i10 = iArr[3];
        int i11 = iArr[4];
        int i12 = iArr[5];
        int i13 = iArr[6];
        zzs((iArr[7] % 1250801052) ^ com.google.android.gms.ads.internal.client.a.c((i8 & (~i2)) | i9, (i2 & i10) | i11, i12, i13));
        return this.zzf;
    }

    public final zzasu zzp() throws zzasz {
        int[] iArr = {672139932, 1821026951, 1629321417, 214090246, 828986457, -1439766056, 580508860, 1579068977, 395191309};
        int i2 = iArr[0];
        int i8 = iArr[1];
        int i9 = iArr[2];
        int i10 = iArr[3];
        int i11 = iArr[4];
        int i12 = iArr[5];
        int i13 = iArr[6];
        zzs((iArr[7] % 395191309) ^ com.google.android.gms.ads.internal.client.a.c((i8 & (~i2)) | i9, (i2 & i10) | i11, i12, i13));
        return this.zzg;
    }

    public final double zzq() throws zzasz {
        int[] iArr = {1714636915, 1758565445, 174653454, 1653642817, 38095532, -1976041400, 596516649, 1804289383, 846930886};
        int i2 = iArr[0];
        int i8 = iArr[1];
        int i9 = iArr[2];
        int i10 = iArr[3];
        int i11 = iArr[4];
        int i12 = iArr[5];
        int i13 = iArr[6];
        zzs((iArr[7] % 846930886) ^ com.google.android.gms.ads.internal.client.a.c((i8 & (~i2)) | i9, (i2 & i10) | i11, i12, i13));
        return this.zzd;
    }
}
