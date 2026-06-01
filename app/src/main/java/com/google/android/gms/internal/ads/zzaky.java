package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.work.WorkRequest;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaky implements zzaki {
    private static final Pattern zza = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    private final boolean zzb;

    @Nullable
    private final zzakx zzc;
    private final zzeg zzd;
    private Map zze;
    private float zzf;
    private float zzg;

    public zzaky() {
        this(null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void zzb(zzeg zzegVar, Charset charset) {
        while (true) {
            String strZzN = zzegVar.zzN(charset);
            if (strZzN == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(strZzN)) {
                while (true) {
                    String strZzN2 = zzegVar.zzN(charset);
                    if (strZzN2 == null || (zzegVar.zzd() != 0 && zzegVar.zzp(charset) == 91)) {
                        break;
                    }
                    String[] strArrSplit = strZzN2.split(":");
                    if (strArrSplit.length == 2) {
                        String strZza = zzglm.zza(strArrSplit[0].trim());
                        switch (strZza.hashCode()) {
                            case 1879649548:
                                if (strZza.equals("playresx")) {
                                    this.zzf = Float.parseFloat(strArrSplit[1].trim());
                                }
                                break;
                            case 1879649549:
                                if (strZza.equals("playresy")) {
                                    try {
                                        this.zzg = Float.parseFloat(strArrSplit[1].trim());
                                    } catch (NumberFormatException unused) {
                                    }
                                }
                                break;
                        }
                    }
                }
            } else if ("[V4+ Styles]".equalsIgnoreCase(strZzN)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                zzakz zzakzVarZza = null;
                while (true) {
                    String strZzN3 = zzegVar.zzN(charset);
                    if (strZzN3 != null && (zzegVar.zzd() == 0 || zzegVar.zzp(charset) != 91)) {
                        if (strZzN3.startsWith("Format:")) {
                            zzakzVarZza = zzakz.zza(strZzN3);
                        } else if (strZzN3.startsWith("Style:")) {
                            if (zzakzVarZza == null) {
                                zzdt.zzc("SsaParser", "Skipping 'Style:' line before 'Format:' line: ".concat(strZzN3));
                            } else {
                                zzalb zzalbVarZza = zzalb.zza(strZzN3, zzakzVarZza);
                                if (zzalbVarZza != null) {
                                    linkedHashMap.put(zzalbVarZza.zza, zzalbVarZza);
                                }
                            }
                        }
                    }
                }
                this.zze = linkedHashMap;
            } else if ("[V4 Styles]".equalsIgnoreCase(strZzN)) {
                zzdt.zzb("SsaParser", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(strZzN)) {
                return;
            }
        }
    }

    private static long zzc(String str) {
        Matcher matcher = zza.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        String strGroup = matcher.group(1);
        String str2 = zzep.zza;
        long j = Long.parseLong(strGroup) * 3600000000L;
        long j3 = Long.parseLong(matcher.group(2)) * 60000000;
        return j + j3 + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(4)) * WorkRequest.MIN_BACKOFF_MILLIS);
    }

    private static float zzd(int i2) {
        if (i2 == 0) {
            return 0.05f;
        }
        if (i2 != 1) {
            return i2 != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    private static int zze(long j, List list, List list2) {
        int i2;
        int size = list.size();
        while (true) {
            size--;
            if (size < 0) {
                i2 = 0;
                break;
            }
            if (((Long) list.get(size)).longValue() == j) {
                return size;
            }
            if (((Long) list.get(size)).longValue() < j) {
                i2 = size + 1;
                break;
            }
        }
        list.add(i2, Long.valueOf(j));
        list2.add(i2, i2 == 0 ? new ArrayList() : new ArrayList((Collection) list2.get(i2 - 1)));
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02f7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b4  */
    @Override // com.google.android.gms.internal.ads.zzaki
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(byte[] r23, int r24, int r25, com.google.android.gms.internal.ads.zzakh r26, com.google.android.gms.internal.ads.zzdg r27) {
        /*
            Method dump skipped, instruction units count: 844
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaky.zza(byte[], int, int, com.google.android.gms.internal.ads.zzakh, com.google.android.gms.internal.ads.zzdg):void");
    }

    public zzaky(@Nullable List list) {
        this.zzf = -3.4028235E38f;
        this.zzg = -3.4028235E38f;
        this.zzd = new zzeg();
        if (list == null || list.isEmpty()) {
            this.zzb = false;
            this.zzc = null;
            return;
        }
        this.zzb = true;
        String strZzi = zzep.zzi((byte[]) list.get(0));
        zzgmd.zza(strZzi.startsWith("Format:"));
        zzakx zzakxVarZza = zzakx.zza(strZzi);
        zzakxVarZza.getClass();
        this.zzc = zzakxVarZza;
        zzb(new zzeg((byte[]) list.get(1)), StandardCharsets.UTF_8);
    }
}
