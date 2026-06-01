package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.bumptech.glide.load.Key;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.measurement.zzqp;
import com.google.android.gms.internal.measurement.zzrb;
import com.ironsource.C2300e4;
import com.ironsource.Q6;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.NewHtcHomeBadger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzpk extends zzos {
    public zzpk(zzpg zzpgVar) {
        super(zzpgVar);
    }

    public static final void zzC(com.google.android.gms.internal.measurement.zzhr zzhrVar, String str, Object obj) {
        List listZza = zzhrVar.zza();
        int i2 = 0;
        while (true) {
            if (i2 >= listZza.size()) {
                i2 = -1;
                break;
            } else if (str.equals(((com.google.android.gms.internal.measurement.zzhw) listZza.get(i2)).zzb())) {
                break;
            } else {
                i2++;
            }
        }
        com.google.android.gms.internal.measurement.zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
        zzhvVarZzn.zzb(str);
        zzhvVarZzn.zzf(((Long) obj).longValue());
        if (i2 >= 0) {
            zzhrVar.zze(i2, zzhvVarZzn);
        } else {
            zzhrVar.zzg(zzhvVarZzn);
        }
    }

    @WorkerThread
    public static final boolean zzD(zzbg zzbgVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzbgVar);
        Preconditions.checkNotNull(zzrVar);
        return !TextUtils.isEmpty(zzrVar.zzb);
    }

    public static final Bundle zzE(List list) {
        Bundle bundle = new Bundle();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) it.next();
            String strZzb = zzhwVar.zzb();
            if (zzhwVar.zzi()) {
                bundle.putDouble(strZzb, zzhwVar.zzj());
            } else if (zzhwVar.zzg()) {
                bundle.putFloat(strZzb, zzhwVar.zzh());
            } else if (zzhwVar.zzc()) {
                bundle.putString(strZzb, zzhwVar.zzd());
            } else if (zzhwVar.zze()) {
                bundle.putLong(strZzb, zzhwVar.zzf());
            }
        }
        return bundle;
    }

    public static final com.google.android.gms.internal.measurement.zzhw zzF(com.google.android.gms.internal.measurement.zzhs zzhsVar, String str) {
        for (com.google.android.gms.internal.measurement.zzhw zzhwVar : zzhsVar.zza()) {
            if (zzhwVar.zzb().equals(str)) {
                return zzhwVar;
            }
        }
        return null;
    }

    public static final Map zzG(com.google.android.gms.internal.measurement.zzhs zzhsVar, String... strArr) {
        Object objZzP;
        HashMap map = new HashMap();
        for (com.google.android.gms.internal.measurement.zzhw zzhwVar : zzhsVar.zza()) {
            if (Arrays.asList(strArr).contains(zzhwVar.zzb()) && (objZzP = zzP(zzhwVar)) != null) {
                map.put(zzhwVar.zzb(), objZzP);
            }
        }
        return map;
    }

    public static final Map zzH(com.google.android.gms.internal.measurement.zzhs zzhsVar, String str) {
        Object objZzP;
        HashMap map = new HashMap();
        for (com.google.android.gms.internal.measurement.zzhw zzhwVar : zzhsVar.zza()) {
            if (zzhwVar.zzb().startsWith("gad_") && (objZzP = zzP(zzhwVar)) != null) {
                map.put(zzhwVar.zzb(), objZzP);
            }
        }
        return map;
    }

    public static final Object zzI(com.google.android.gms.internal.measurement.zzhs zzhsVar, String str) {
        com.google.android.gms.internal.measurement.zzhw zzhwVarZzF = zzF(zzhsVar, str);
        if (zzhwVarZzF == null) {
            return null;
        }
        return zzP(zzhwVarZzF);
    }

    public static final Object zzJ(com.google.android.gms.internal.measurement.zzhs zzhsVar, String str, Object obj) {
        Object objZzI = zzI(zzhsVar, str);
        return objZzI == null ? obj : objZzI;
    }

    private final void zzK(StringBuilder sb, int i2, List list) {
        if (list == null) {
            return;
        }
        int i8 = i2 + 1;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) it.next();
            if (zzhwVar != null) {
                zzM(sb, i8);
                sb.append("param {\n");
                zzS(sb, i8, "name", zzhwVar.zza() ? this.zzu.zzl().zzb(zzhwVar.zzb()) : null);
                zzS(sb, i8, "string_value", zzhwVar.zzc() ? zzhwVar.zzd() : null);
                zzS(sb, i8, "int_value", zzhwVar.zze() ? Long.valueOf(zzhwVar.zzf()) : null);
                zzS(sb, i8, "double_value", zzhwVar.zzi() ? Double.valueOf(zzhwVar.zzj()) : null);
                if (zzhwVar.zzm() > 0) {
                    zzK(sb, i8, zzhwVar.zzk());
                }
                zzM(sb, i8);
                sb.append("}\n");
            }
        }
    }

    private final void zzL(StringBuilder sb, int i2, com.google.android.gms.internal.measurement.zzfh zzfhVar) {
        String str;
        if (zzfhVar == null) {
            return;
        }
        zzM(sb, i2);
        sb.append("filter {\n");
        if (zzfhVar.zze()) {
            zzS(sb, i2, "complement", Boolean.valueOf(zzfhVar.zzf()));
        }
        if (zzfhVar.zzg()) {
            zzS(sb, i2, "param_name", this.zzu.zzl().zzb(zzfhVar.zzh()));
        }
        if (zzfhVar.zza()) {
            int i8 = i2 + 1;
            com.google.android.gms.internal.measurement.zzfr zzfrVarZzb = zzfhVar.zzb();
            if (zzfrVarZzb != null) {
                zzM(sb, i8);
                sb.append("string_filter {\n");
                if (zzfrVarZzb.zza()) {
                    switch (zzfrVarZzb.zzj()) {
                        case 1:
                            str = "UNKNOWN_MATCH_TYPE";
                            break;
                        case 2:
                            str = "REGEXP";
                            break;
                        case 3:
                            str = "BEGINS_WITH";
                            break;
                        case 4:
                            str = "ENDS_WITH";
                            break;
                        case 5:
                            str = "PARTIAL";
                            break;
                        case 6:
                            str = "EXACT";
                            break;
                        default:
                            str = "IN_LIST";
                            break;
                    }
                    zzS(sb, i8, "match_type", str);
                }
                if (zzfrVarZzb.zzb()) {
                    zzS(sb, i8, "expression", zzfrVarZzb.zzc());
                }
                if (zzfrVarZzb.zzd()) {
                    zzS(sb, i8, "case_sensitive", Boolean.valueOf(zzfrVarZzb.zze()));
                }
                if (zzfrVarZzb.zzg() > 0) {
                    zzM(sb, i2 + 2);
                    sb.append("expression_list {\n");
                    for (String str2 : zzfrVarZzb.zzf()) {
                        zzM(sb, i2 + 3);
                        sb.append(str2);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                zzM(sb, i8);
                sb.append("}\n");
            }
        }
        if (zzfhVar.zzc()) {
            zzT(sb, i2 + 1, "number_filter", zzfhVar.zzd());
        }
        zzM(sb, i2);
        sb.append("}\n");
    }

    private static final void zzM(StringBuilder sb, int i2) {
        for (int i8 = 0; i8 < i2; i8++) {
            sb.append("  ");
        }
    }

    private static final void zzN(Uri.Builder builder, String str, String str2, Set set) {
        if (set.contains(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.appendQueryParameter(str, str2);
    }

    private static final String zzO(boolean z2, boolean z7, boolean z8) {
        StringBuilder sb = new StringBuilder();
        if (z2) {
            sb.append("Dynamic ");
        }
        if (z7) {
            sb.append("Sequence ");
        }
        if (z8) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    private static final Object zzP(com.google.android.gms.internal.measurement.zzhw zzhwVar) {
        if (zzhwVar.zzc()) {
            return zzhwVar.zzd();
        }
        if (zzhwVar.zze()) {
            return Long.valueOf(zzhwVar.zzf());
        }
        if (zzhwVar.zzi()) {
            return Double.valueOf(zzhwVar.zzj());
        }
        if (zzhwVar.zzm() > 0) {
            return zzy(zzhwVar.zzk());
        }
        return null;
    }

    private static final void zzQ(Uri.Builder builder, String[] strArr, Bundle bundle, Set set) {
        for (String str : strArr) {
            String[] strArrSplit = str.split(",");
            String str2 = strArrSplit[0];
            String str3 = strArrSplit[strArrSplit.length - 1];
            String string = bundle.getString(str2);
            if (string != null) {
                zzN(builder, str3, string, set);
            }
        }
    }

    private static final void zzR(StringBuilder sb, int i2, String str, com.google.android.gms.internal.measurement.zzii zziiVar) {
        if (zziiVar == null) {
            return;
        }
        zzM(sb, 3);
        sb.append(str);
        sb.append(" {\n");
        if (zziiVar.zzd() != 0) {
            zzM(sb, 4);
            sb.append("results: ");
            int i8 = 0;
            for (Long l : zziiVar.zzc()) {
                int i9 = i8 + 1;
                if (i8 != 0) {
                    sb.append(", ");
                }
                sb.append(l);
                i8 = i9;
            }
            sb.append('\n');
        }
        if (zziiVar.zzb() != 0) {
            zzM(sb, 4);
            sb.append("status: ");
            int i10 = 0;
            for (Long l8 : zziiVar.zza()) {
                int i11 = i10 + 1;
                if (i10 != 0) {
                    sb.append(", ");
                }
                sb.append(l8);
                i10 = i11;
            }
            sb.append('\n');
        }
        if (zziiVar.zzf() != 0) {
            zzM(sb, 4);
            sb.append("dynamic_filter_timestamps: {");
            int i12 = 0;
            for (com.google.android.gms.internal.measurement.zzhq zzhqVar : zziiVar.zze()) {
                int i13 = i12 + 1;
                if (i12 != 0) {
                    sb.append(", ");
                }
                sb.append(zzhqVar.zza() ? Integer.valueOf(zzhqVar.zzb()) : null);
                sb.append(":");
                sb.append(zzhqVar.zzc() ? Long.valueOf(zzhqVar.zzd()) : null);
                i12 = i13;
            }
            sb.append("}\n");
        }
        if (zziiVar.zzh() != 0) {
            zzM(sb, 4);
            sb.append("sequence_filter_timestamps: {");
            int i14 = 0;
            for (com.google.android.gms.internal.measurement.zzik zzikVar : zziiVar.zzg()) {
                int i15 = i14 + 1;
                if (i14 != 0) {
                    sb.append(", ");
                }
                sb.append(zzikVar.zza() ? Integer.valueOf(zzikVar.zzb()) : null);
                sb.append(": [");
                Iterator it = zzikVar.zzc().iterator();
                int i16 = 0;
                while (it.hasNext()) {
                    long jLongValue = ((Long) it.next()).longValue();
                    int i17 = i16 + 1;
                    if (i16 != 0) {
                        sb.append(", ");
                    }
                    sb.append(jLongValue);
                    i16 = i17;
                }
                sb.append(C2300e4.i.e);
                i14 = i15;
            }
            sb.append("}\n");
        }
        zzM(sb, 3);
        sb.append("}\n");
    }

    private static final void zzS(StringBuilder sb, int i2, String str, Object obj) {
        if (obj == null) {
            return;
        }
        zzM(sb, i2 + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    private static final void zzT(StringBuilder sb, int i2, String str, com.google.android.gms.internal.measurement.zzfl zzflVar) {
        if (zzflVar == null) {
            return;
        }
        zzM(sb, i2);
        sb.append(str);
        sb.append(" {\n");
        if (zzflVar.zza()) {
            int iZzm = zzflVar.zzm();
            zzS(sb, i2, "comparison_type", iZzm != 1 ? iZzm != 2 ? iZzm != 3 ? iZzm != 4 ? "BETWEEN" : "EQUAL" : "GREATER_THAN" : "LESS_THAN" : "UNKNOWN_COMPARISON_TYPE");
        }
        if (zzflVar.zzb()) {
            zzS(sb, i2, "match_as_float", Boolean.valueOf(zzflVar.zzc()));
        }
        if (zzflVar.zzd()) {
            zzS(sb, i2, "comparison_value", zzflVar.zze());
        }
        if (zzflVar.zzf()) {
            zzS(sb, i2, "min_comparison_value", zzflVar.zzg());
        }
        if (zzflVar.zzh()) {
            zzS(sb, i2, "max_comparison_value", zzflVar.zzi());
        }
        zzM(sb, i2);
        sb.append("}\n");
    }

    public static boolean zzm(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    public static boolean zzn(List list, int i2) {
        if (i2 < list.size() * 64) {
            return ((1 << (i2 % 64)) & ((Long) list.get(i2 / 64)).longValue()) != 0;
        }
        return false;
    }

    public static List zzp(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            long j = 0;
            for (int i8 = 0; i8 < 64; i8++) {
                int i9 = (i2 * 64) + i8;
                if (i9 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i9)) {
                    j |= 1 << i8;
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    public static com.google.android.gms.internal.measurement.zznl zzw(com.google.android.gms.internal.measurement.zznl zznlVar, byte[] bArr) throws com.google.android.gms.internal.measurement.zzmr {
        com.google.android.gms.internal.measurement.zzlr zzlrVarZza = com.google.android.gms.internal.measurement.zzlr.zza();
        return zzlrVarZza != null ? zznlVar.zzaV(bArr, zzlrVarZza) : zznlVar.zzaW(bArr);
    }

    public static int zzx(com.google.android.gms.internal.measurement.zzic zzicVar, String str) {
        for (int i2 = 0; i2 < zzicVar.zzl(); i2++) {
            if (str.equals(zzicVar.zzm(i2).zzc())) {
                return i2;
            }
        }
        return -1;
    }

    public static Bundle[] zzy(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) it.next();
            if (zzhwVar != null) {
                Bundle bundle = new Bundle();
                for (com.google.android.gms.internal.measurement.zzhw zzhwVar2 : zzhwVar.zzk()) {
                    if (zzhwVar2.zzc()) {
                        bundle.putString(zzhwVar2.zzb(), zzhwVar2.zzd());
                    } else if (zzhwVar2.zze()) {
                        bundle.putLong(zzhwVar2.zzb(), zzhwVar2.zzf());
                    } else if (zzhwVar2.zzi()) {
                        bundle.putDouble(zzhwVar2.zzb(), zzhwVar2.zzj());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public final zzbg zzA(com.google.android.gms.internal.measurement.zzaa zzaaVar) {
        Object obj;
        Bundle bundleZzB = zzB(zzaaVar.zzf(), true);
        String string = (!bundleZzB.containsKey("_o") || (obj = bundleZzB.get("_o")) == null) ? "app" : obj.toString();
        String strZzb = zzjm.zzb(zzaaVar.zzb());
        if (strZzb == null) {
            strZzb = zzaaVar.zzb();
        }
        return new zzbg(strZzb, new zzbe(bundleZzB), string, zzaaVar.zza());
    }

    public final Bundle zzB(Map map, boolean z2) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                bundle.putString(str, obj.toString());
            } else if (z2) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList2.add(zzB((Map) arrayList.get(i2), false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
        }
        return bundle;
    }

    @Override // com.google.android.gms.measurement.internal.zzos
    public final boolean zzbb() {
        return false;
    }

    public final void zzc(com.google.android.gms.internal.measurement.zzit zzitVar, Object obj) {
        Preconditions.checkNotNull(obj);
        zzitVar.zzd();
        zzitVar.zzf();
        zzitVar.zzh();
        if (obj instanceof String) {
            zzitVar.zzc((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzitVar.zze(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzitVar.zzg(((Double) obj).doubleValue());
        } else {
            this.zzu.zzaV().zzb().zzb("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public final void zzd(com.google.android.gms.internal.measurement.zzhv zzhvVar, Object obj) {
        Preconditions.checkNotNull(obj);
        zzhvVar.zze();
        zzhvVar.zzg();
        zzhvVar.zzi();
        zzhvVar.zzm();
        if (obj instanceof String) {
            zzhvVar.zzd((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzhvVar.zzf(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            zzhvVar.zzh(((Double) obj).doubleValue());
            return;
        }
        if (!(obj instanceof Bundle[])) {
            this.zzu.zzaV().zzb().zzb("Ignoring invalid (type) event param value", obj);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : (Bundle[]) obj) {
            if (bundle != null) {
                com.google.android.gms.internal.measurement.zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                for (String str : bundle.keySet()) {
                    com.google.android.gms.internal.measurement.zzhv zzhvVarZzn2 = com.google.android.gms.internal.measurement.zzhw.zzn();
                    zzhvVarZzn2.zzb(str);
                    Object obj2 = bundle.get(str);
                    if (obj2 instanceof Long) {
                        zzhvVarZzn2.zzf(((Long) obj2).longValue());
                    } else if (obj2 instanceof String) {
                        zzhvVarZzn2.zzd((String) obj2);
                    } else if (obj2 instanceof Double) {
                        zzhvVarZzn2.zzh(((Double) obj2).doubleValue());
                    }
                    zzhvVarZzn.zzk(zzhvVarZzn2);
                }
                if (zzhvVarZzn.zzj() > 0) {
                    arrayList.add((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn.zzbc());
                }
            }
        }
        zzhvVar.zzl(arrayList);
    }

    public final zzoh zzf(String str, com.google.android.gms.internal.measurement.zzic zzicVar, com.google.android.gms.internal.measurement.zzhr zzhrVar, String str2) {
        int iIndexOf;
        zzqp.zza();
        zzic zzicVar2 = this.zzu;
        if (!zzicVar2.zzc().zzp(str, zzfy.zzaP)) {
            return null;
        }
        long jCurrentTimeMillis = zzicVar2.zzaZ().currentTimeMillis();
        String[] strArrSplit = zzicVar2.zzc().zzk(str, zzfy.zzau).split(",");
        HashSet hashSet = new HashSet(strArrSplit.length);
        for (String str3 : strArrSplit) {
            Objects.requireNonNull(str3);
            if (!hashSet.add(str3)) {
                throw new IllegalArgumentException("duplicate element: " + ((Object) str3));
            }
        }
        Set setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
        zzpg zzpgVar = this.zzg;
        zzou zzouVarZzf = zzpgVar.zzf();
        String strZzc = zzouVarZzf.zzg.zzh().zzc(str);
        Uri.Builder builder = new Uri.Builder();
        zzic zzicVar3 = zzouVarZzf.zzu;
        builder.scheme(zzicVar3.zzc().zzk(str, zzfy.zzan));
        if (TextUtils.isEmpty(strZzc)) {
            builder.authority(zzicVar3.zzc().zzk(str, zzfy.zzao));
        } else {
            String strZzk = zzicVar3.zzc().zzk(str, zzfy.zzao);
            StringBuilder sb = new StringBuilder(String.valueOf(strZzc).length() + 1 + String.valueOf(strZzk).length());
            sb.append(strZzc);
            sb.append(".");
            sb.append(strZzk);
            builder.authority(sb.toString());
        }
        builder.path(zzicVar3.zzc().zzk(str, zzfy.zzap));
        zzN(builder, "gmp_app_id", zzicVar.zzac(), setUnmodifiableSet);
        zzicVar2.zzc().zzi();
        zzN(builder, "gmp_version", String.valueOf(133005L), setUnmodifiableSet);
        String strZzV = zzicVar.zzV();
        zzal zzalVarZzc = zzicVar2.zzc();
        zzfx zzfxVar = zzfy.zzaS;
        if (zzalVarZzc.zzp(str, zzfxVar) && zzpgVar.zzh().zzt(str)) {
            strZzV = "";
        }
        zzN(builder, "app_instance_id", strZzV, setUnmodifiableSet);
        zzN(builder, "rdid", zzicVar.zzP(), setUnmodifiableSet);
        zzN(builder, "bundle_id", zzicVar.zzK(), setUnmodifiableSet);
        String strZzk2 = zzhrVar.zzk();
        String strZza = zzjm.zza(strZzk2);
        if (true != TextUtils.isEmpty(strZza)) {
            strZzk2 = strZza;
        }
        zzN(builder, "app_event_name", strZzk2, setUnmodifiableSet);
        zzN(builder, "app_version", String.valueOf(zzicVar.zzai()), setUnmodifiableSet);
        String strZzD = zzicVar.zzD();
        if (zzicVar2.zzc().zzp(str, zzfxVar) && zzpgVar.zzh().zzq(str) && !TextUtils.isEmpty(strZzD) && (iIndexOf = strZzD.indexOf(".")) != -1) {
            strZzD = strZzD.substring(0, iIndexOf);
        }
        zzN(builder, "os_version", strZzD, setUnmodifiableSet);
        zzN(builder, "timestamp", String.valueOf(zzhrVar.zzn()), setUnmodifiableSet);
        if (zzicVar.zzS()) {
            zzN(builder, Q6.f7465s, "1", setUnmodifiableSet);
        }
        zzN(builder, "privacy_sandbox_version", String.valueOf(zzicVar.zzaG()), setUnmodifiableSet);
        zzN(builder, "trigger_uri_source", "1", setUnmodifiableSet);
        zzN(builder, "trigger_uri_timestamp", String.valueOf(jCurrentTimeMillis), setUnmodifiableSet);
        zzN(builder, "request_uuid", str2, setUnmodifiableSet);
        List<com.google.android.gms.internal.measurement.zzhw> listZza = zzhrVar.zza();
        Bundle bundle = new Bundle();
        for (com.google.android.gms.internal.measurement.zzhw zzhwVar : listZza) {
            String strZzb = zzhwVar.zzb();
            if (zzhwVar.zzi()) {
                bundle.putString(strZzb, String.valueOf(zzhwVar.zzj()));
            } else if (zzhwVar.zzg()) {
                bundle.putString(strZzb, String.valueOf(zzhwVar.zzh()));
            } else if (zzhwVar.zzc()) {
                bundle.putString(strZzb, zzhwVar.zzd());
            } else if (zzhwVar.zze()) {
                bundle.putString(strZzb, String.valueOf(zzhwVar.zzf()));
            }
        }
        zzQ(builder, zzicVar2.zzc().zzk(str, zzfy.zzat).split("\\|"), bundle, setUnmodifiableSet);
        List<com.google.android.gms.internal.measurement.zziu> listZzk = zzicVar.zzk();
        Bundle bundle2 = new Bundle();
        for (com.google.android.gms.internal.measurement.zziu zziuVar : listZzk) {
            String strZzc2 = zziuVar.zzc();
            if (zziuVar.zzj()) {
                bundle2.putString(strZzc2, String.valueOf(zziuVar.zzk()));
            } else if (zziuVar.zzh()) {
                bundle2.putString(strZzc2, String.valueOf(zziuVar.zzi()));
            } else if (zziuVar.zzd()) {
                bundle2.putString(strZzc2, zziuVar.zze());
            } else if (zziuVar.zzf()) {
                bundle2.putString(strZzc2, String.valueOf(zziuVar.zzg()));
            }
        }
        zzQ(builder, zzicVar2.zzc().zzk(str, zzfy.zzas).split("\\|"), bundle2, setUnmodifiableSet);
        zzN(builder, "dma", true != zzicVar.zzaC() ? "0" : "1", setUnmodifiableSet);
        if (!zzicVar.zzaE().isEmpty()) {
            zzN(builder, "dma_cps", zzicVar.zzaE(), setUnmodifiableSet);
        }
        if (zzicVar.zzaK()) {
            com.google.android.gms.internal.measurement.zzha zzhaVarZzaL = zzicVar.zzaL();
            if (!zzhaVarZzaL.zzb().isEmpty()) {
                zzN(builder, "dl_gclid", zzhaVarZzaL.zzb(), setUnmodifiableSet);
            }
            if (!zzhaVarZzaL.zzd().isEmpty()) {
                zzN(builder, "dl_gbraid", zzhaVarZzaL.zzd(), setUnmodifiableSet);
            }
            if (!zzhaVarZzaL.zzf().isEmpty()) {
                zzN(builder, "dl_gs", zzhaVarZzaL.zzf(), setUnmodifiableSet);
            }
            if (zzhaVarZzaL.zzh() > 0) {
                zzN(builder, "dl_ss_ts", String.valueOf(zzhaVarZzaL.zzh()), setUnmodifiableSet);
            }
            if (!zzhaVarZzaL.zzj().isEmpty()) {
                zzN(builder, "mr_gclid", zzhaVarZzaL.zzj(), setUnmodifiableSet);
            }
            if (!zzhaVarZzaL.zzm().isEmpty()) {
                zzN(builder, "mr_gbraid", zzhaVarZzaL.zzm(), setUnmodifiableSet);
            }
            if (!zzhaVarZzaL.zzo().isEmpty()) {
                zzN(builder, "mr_gs", zzhaVarZzaL.zzo(), setUnmodifiableSet);
            }
            if (zzhaVarZzaL.zzq() > 0) {
                zzN(builder, "mr_click_ts", String.valueOf(zzhaVarZzaL.zzq()), setUnmodifiableSet);
            }
        }
        return new zzoh(builder.build().toString(), jCurrentTimeMillis, 1);
    }

    public final com.google.android.gms.internal.measurement.zzhs zzh(zzbb zzbbVar) {
        com.google.android.gms.internal.measurement.zzhr zzhrVarZzk = com.google.android.gms.internal.measurement.zzhs.zzk();
        zzhrVarZzk.zzq(zzbbVar.zze);
        zzbe zzbeVar = zzbbVar.zzf;
        zzbd zzbdVar = new zzbd(zzbeVar);
        while (zzbdVar.hasNext()) {
            String next = zzbdVar.next();
            com.google.android.gms.internal.measurement.zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
            zzhvVarZzn.zzb(next);
            Object objZza = zzbeVar.zza(next);
            Preconditions.checkNotNull(objZza);
            zzd(zzhvVarZzn, objZza);
            zzhrVarZzk.zzg(zzhvVarZzn);
        }
        String str = zzbbVar.zzc;
        if (!TextUtils.isEmpty(str) && zzbeVar.zza("_o") == null) {
            com.google.android.gms.internal.measurement.zzhv zzhvVarZzn2 = com.google.android.gms.internal.measurement.zzhw.zzn();
            zzhvVarZzn2.zzb("_o");
            zzhvVarZzn2.zzd(str);
            zzhrVarZzk.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn2.zzbc());
        }
        return (com.google.android.gms.internal.measurement.zzhs) zzhrVarZzk.zzbc();
    }

    public final String zzi(com.google.android.gms.internal.measurement.zzib zzibVar) {
        com.google.android.gms.internal.measurement.zzhe zzheVarZzat;
        if (zzibVar == null) {
            return "";
        }
        StringBuilder sbR = androidx.camera.core.processing.util.a.r("\nbatch {\n");
        if (zzibVar.zzf()) {
            zzS(sbR, 0, "upload_subdomain", zzibVar.zzg());
        }
        if (zzibVar.zzd()) {
            zzS(sbR, 0, "sgtm_join_id", zzibVar.zze());
        }
        for (com.google.android.gms.internal.measurement.zzid zzidVar : zzibVar.zza()) {
            if (zzidVar != null) {
                zzM(sbR, 1);
                sbR.append("bundle {\n");
                if (zzidVar.zza()) {
                    zzS(sbR, 1, "protocol_version", Integer.valueOf(zzidVar.zzb()));
                }
                zzrb.zza();
                zzic zzicVar = this.zzu;
                if (zzicVar.zzc().zzp(zzidVar.zzA(), zzfy.zzaM) && zzidVar.zzag()) {
                    zzS(sbR, 1, "session_stitching_token", zzidVar.zzah());
                }
                zzS(sbR, 1, Q6.H, zzidVar.zzt());
                if (zzidVar.zzC()) {
                    zzS(sbR, 1, "gmp_version", Long.valueOf(zzidVar.zzD()));
                }
                if (zzidVar.zzE()) {
                    zzS(sbR, 1, "uploading_gmp_version", Long.valueOf(zzidVar.zzF()));
                }
                if (zzidVar.zzac()) {
                    zzS(sbR, 1, "dynamite_version", Long.valueOf(zzidVar.zzad()));
                }
                if (zzidVar.zzW()) {
                    zzS(sbR, 1, "config_version", Long.valueOf(zzidVar.zzX()));
                }
                zzS(sbR, 1, "gmp_app_id", zzidVar.zzP());
                zzS(sbR, 1, "app_id", zzidVar.zzA());
                zzS(sbR, 1, "app_version", zzidVar.zzB());
                if (zzidVar.zzU()) {
                    zzS(sbR, 1, "app_version_major", Integer.valueOf(zzidVar.zzV()));
                }
                zzS(sbR, 1, "firebase_instance_id", zzidVar.zzT());
                if (zzidVar.zzK()) {
                    zzS(sbR, 1, "dev_cert_hash", Long.valueOf(zzidVar.zzL()));
                }
                zzS(sbR, 1, "app_store", zzidVar.zzz());
                if (zzidVar.zzi()) {
                    zzS(sbR, 1, "upload_timestamp_millis", Long.valueOf(zzidVar.zzj()));
                }
                if (zzidVar.zzk()) {
                    zzS(sbR, 1, "start_timestamp_millis", Long.valueOf(zzidVar.zzm()));
                }
                if (zzidVar.zzn()) {
                    zzS(sbR, 1, "end_timestamp_millis", Long.valueOf(zzidVar.zzo()));
                }
                if (zzidVar.zzp()) {
                    zzS(sbR, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(zzidVar.zzq()));
                }
                if (zzidVar.zzr()) {
                    zzS(sbR, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(zzidVar.zzs()));
                }
                zzS(sbR, 1, "app_instance_id", zzidVar.zzJ());
                zzS(sbR, 1, "resettable_device_id", zzidVar.zzG());
                zzS(sbR, 1, "ds_id", zzidVar.zzZ());
                if (zzidVar.zzH()) {
                    zzS(sbR, 1, "limited_ad_tracking", Boolean.valueOf(zzidVar.zzI()));
                }
                zzS(sbR, 1, "os_version", zzidVar.zzu());
                zzS(sbR, 1, "device_model", zzidVar.zzv());
                zzS(sbR, 1, "user_default_language", zzidVar.zzw());
                if (zzidVar.zzx()) {
                    zzS(sbR, 1, "time_zone_offset_minutes", Integer.valueOf(zzidVar.zzy()));
                }
                if (zzidVar.zzM()) {
                    zzS(sbR, 1, "bundle_sequential_index", Integer.valueOf(zzidVar.zzN()));
                }
                if (zzidVar.zzau()) {
                    zzS(sbR, 1, "delivery_index", Integer.valueOf(zzidVar.zzav()));
                }
                if (zzidVar.zzQ()) {
                    zzS(sbR, 1, "service_upload", Boolean.valueOf(zzidVar.zzR()));
                }
                zzS(sbR, 1, "health_monitor", zzidVar.zzO());
                if (zzidVar.zzaa()) {
                    zzS(sbR, 1, "retry_counter", Integer.valueOf(zzidVar.zzab()));
                }
                if (zzidVar.zzae()) {
                    zzS(sbR, 1, "consent_signals", zzidVar.zzaf());
                }
                if (zzidVar.zzan()) {
                    zzS(sbR, 1, "is_dma_region", Boolean.valueOf(zzidVar.zzao()));
                }
                if (zzidVar.zzap()) {
                    zzS(sbR, 1, "core_platform_services", zzidVar.zzaq());
                }
                if (zzidVar.zzal()) {
                    zzS(sbR, 1, "consent_diagnostics", zzidVar.zzam());
                }
                if (zzidVar.zzai()) {
                    zzS(sbR, 1, "target_os_version", Long.valueOf(zzidVar.zzaj()));
                }
                zzqp.zza();
                if (zzicVar.zzc().zzp(zzidVar.zzA(), zzfy.zzaP)) {
                    zzS(sbR, 1, "ad_services_version", Integer.valueOf(zzidVar.zzar()));
                    if (zzidVar.zzas() && (zzheVarZzat = zzidVar.zzat()) != null) {
                        zzM(sbR, 2);
                        sbR.append("attribution_eligibility_status {\n");
                        zzS(sbR, 2, "eligible", Boolean.valueOf(zzheVarZzat.zza()));
                        zzS(sbR, 2, "no_access_adservices_attribution_permission", Boolean.valueOf(zzheVarZzat.zzb()));
                        zzS(sbR, 2, "pre_r", Boolean.valueOf(zzheVarZzat.zzc()));
                        zzS(sbR, 2, "r_extensions_too_old", Boolean.valueOf(zzheVarZzat.zzd()));
                        zzS(sbR, 2, "adservices_extension_too_old", Boolean.valueOf(zzheVarZzat.zze()));
                        zzS(sbR, 2, "ad_storage_not_allowed", Boolean.valueOf(zzheVarZzat.zzf()));
                        zzS(sbR, 2, "measurement_manager_disabled", Boolean.valueOf(zzheVarZzat.zzg()));
                        zzM(sbR, 2);
                        sbR.append("}\n");
                    }
                }
                if (zzidVar.zzaw()) {
                    com.google.android.gms.internal.measurement.zzha zzhaVarZzax = zzidVar.zzax();
                    zzM(sbR, 2);
                    sbR.append("ad_campaign_info {\n");
                    if (zzhaVarZzax.zza()) {
                        zzS(sbR, 2, "deep_link_gclid", zzhaVarZzax.zzb());
                    }
                    if (zzhaVarZzax.zzc()) {
                        zzS(sbR, 2, "deep_link_gbraid", zzhaVarZzax.zzd());
                    }
                    if (zzhaVarZzax.zze()) {
                        zzS(sbR, 2, "deep_link_gad_source", zzhaVarZzax.zzf());
                    }
                    if (zzhaVarZzax.zzg()) {
                        zzS(sbR, 2, "deep_link_session_millis", Long.valueOf(zzhaVarZzax.zzh()));
                    }
                    if (zzhaVarZzax.zzi()) {
                        zzS(sbR, 2, "market_referrer_gclid", zzhaVarZzax.zzj());
                    }
                    if (zzhaVarZzax.zzk()) {
                        zzS(sbR, 2, "market_referrer_gbraid", zzhaVarZzax.zzm());
                    }
                    if (zzhaVarZzax.zzn()) {
                        zzS(sbR, 2, "market_referrer_gad_source", zzhaVarZzax.zzo());
                    }
                    if (zzhaVarZzax.zzp()) {
                        zzS(sbR, 2, "market_referrer_click_millis", Long.valueOf(zzhaVarZzax.zzq()));
                    }
                    zzM(sbR, 2);
                    sbR.append("}\n");
                }
                if (zzidVar.zzaA()) {
                    zzS(sbR, 1, "batching_timestamp_millis", Long.valueOf(zzidVar.zzaB()));
                }
                if (zzidVar.zzay()) {
                    com.google.android.gms.internal.measurement.zzis zzisVarZzaz = zzidVar.zzaz();
                    zzM(sbR, 2);
                    sbR.append("sgtm_diagnostics {\n");
                    int iZzf = zzisVarZzaz.zzf();
                    zzS(sbR, 2, "upload_type", iZzf != 1 ? iZzf != 2 ? iZzf != 3 ? iZzf != 4 ? "SDK_SERVICE_UPLOAD" : "PACKAGE_SERVICE_UPLOAD" : "SDK_CLIENT_UPLOAD" : "GA_UPLOAD" : "UPLOAD_TYPE_UNKNOWN");
                    zzS(sbR, 2, "client_upload_eligibility", zzisVarZzaz.zza().name());
                    int iZzg = zzisVarZzaz.zzg();
                    zzS(sbR, 2, "service_upload_eligibility", iZzg != 1 ? iZzg != 2 ? iZzg != 3 ? iZzg != 4 ? iZzg != 5 ? "NON_PLAY_MISSING_SGTM_SERVER_URL" : "MISSING_SGTM_PROXY_INFO" : "MISSING_SGTM_SETTINGS" : "NOT_IN_ROLLOUT" : "SERVICE_UPLOAD_ELIGIBLE" : "SERVICE_UPLOAD_ELIGIBILITY_UNKNOWN");
                    zzM(sbR, 2);
                    sbR.append("}\n");
                }
                if (zzidVar.zzaC()) {
                    com.google.android.gms.internal.measurement.zzho zzhoVarZzaD = zzidVar.zzaD();
                    zzM(sbR, 2);
                    sbR.append("consent_info_extra {\n");
                    for (com.google.android.gms.internal.measurement.zzhl zzhlVar : zzhoVarZzaD.zza()) {
                        zzM(sbR, 3);
                        sbR.append("limited_data_modes {\n");
                        int iZzc = zzhlVar.zzc();
                        zzS(sbR, 3, "type", iZzc != 1 ? iZzc != 2 ? iZzc != 3 ? iZzc != 4 ? "AD_PERSONALIZATION" : "AD_USER_DATA" : "ANALYTICS_STORAGE" : "AD_STORAGE" : "CONSENT_TYPE_UNSPECIFIED");
                        int iZzd = zzhlVar.zzd();
                        zzS(sbR, 3, C2300e4.a.f8302t, iZzd != 1 ? iZzd != 2 ? "NO_DATA_MODE" : "LIMITED_MODE" : "NOT_LIMITED");
                        zzM(sbR, 3);
                        sbR.append("}\n");
                    }
                    zzM(sbR, 2);
                    sbR.append("}\n");
                }
                List<com.google.android.gms.internal.measurement.zziu> listZzf = zzidVar.zzf();
                if (listZzf != null) {
                    for (com.google.android.gms.internal.measurement.zziu zziuVar : listZzf) {
                        if (zziuVar != null) {
                            zzM(sbR, 2);
                            sbR.append("user_property {\n");
                            zzS(sbR, 2, "set_timestamp_millis", zziuVar.zza() ? Long.valueOf(zziuVar.zzb()) : null);
                            zzS(sbR, 2, "name", zzicVar.zzl().zzc(zziuVar.zzc()));
                            zzS(sbR, 2, "string_value", zziuVar.zze());
                            zzS(sbR, 2, "int_value", zziuVar.zzf() ? Long.valueOf(zziuVar.zzg()) : null);
                            zzS(sbR, 2, "double_value", zziuVar.zzj() ? Double.valueOf(zziuVar.zzk()) : null);
                            zzM(sbR, 2);
                            sbR.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.zzhg> listZzS = zzidVar.zzS();
                if (listZzS != null) {
                    for (com.google.android.gms.internal.measurement.zzhg zzhgVar : listZzS) {
                        if (zzhgVar != null) {
                            zzM(sbR, 2);
                            sbR.append("audience_membership {\n");
                            if (zzhgVar.zza()) {
                                zzS(sbR, 2, "audience_id", Integer.valueOf(zzhgVar.zzb()));
                            }
                            if (zzhgVar.zzf()) {
                                zzS(sbR, 2, "new_audience", Boolean.valueOf(zzhgVar.zzg()));
                            }
                            zzR(sbR, 2, "current_data", zzhgVar.zzc());
                            if (zzhgVar.zzd()) {
                                zzR(sbR, 2, "previous_data", zzhgVar.zze());
                            }
                            zzM(sbR, 2);
                            sbR.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.zzhs> listZzc = zzidVar.zzc();
                if (listZzc != null) {
                    for (com.google.android.gms.internal.measurement.zzhs zzhsVar : listZzc) {
                        if (zzhsVar != null) {
                            zzM(sbR, 2);
                            sbR.append("event {\n");
                            zzS(sbR, 2, "name", zzicVar.zzl().zza(zzhsVar.zzd()));
                            if (zzhsVar.zze()) {
                                zzS(sbR, 2, "timestamp_millis", Long.valueOf(zzhsVar.zzf()));
                            }
                            if (zzhsVar.zzg()) {
                                zzS(sbR, 2, "previous_timestamp_millis", Long.valueOf(zzhsVar.zzh()));
                            }
                            if (zzhsVar.zzi()) {
                                zzS(sbR, 2, NewHtcHomeBadger.COUNT, Integer.valueOf(zzhsVar.zzj()));
                            }
                            if (zzhsVar.zzb() != 0) {
                                zzK(sbR, 2, zzhsVar.zza());
                            }
                            zzM(sbR, 2);
                            sbR.append("}\n");
                        }
                    }
                }
                zzM(sbR, 1);
                sbR.append("}\n");
            }
        }
        sbR.append("} // End-of-batch\n");
        return sbR.toString();
    }

    public final String zzj(com.google.android.gms.internal.measurement.zzff zzffVar) {
        if (zzffVar == null) {
            return "null";
        }
        StringBuilder sbR = androidx.camera.core.processing.util.a.r("\nevent_filter {\n");
        if (zzffVar.zza()) {
            zzS(sbR, 0, "filter_id", Integer.valueOf(zzffVar.zzb()));
        }
        zzS(sbR, 0, "event_name", this.zzu.zzl().zza(zzffVar.zzc()));
        String strZzO = zzO(zzffVar.zzi(), zzffVar.zzj(), zzffVar.zzm());
        if (!strZzO.isEmpty()) {
            zzS(sbR, 0, "filter_type", strZzO);
        }
        if (zzffVar.zzg()) {
            zzT(sbR, 1, "event_count_filter", zzffVar.zzh());
        }
        if (zzffVar.zze() > 0) {
            sbR.append("  filters {\n");
            Iterator it = zzffVar.zzd().iterator();
            while (it.hasNext()) {
                zzL(sbR, 2, (com.google.android.gms.internal.measurement.zzfh) it.next());
            }
        }
        zzM(sbR, 1);
        sbR.append("}\n}\n");
        return sbR.toString();
    }

    public final String zzk(com.google.android.gms.internal.measurement.zzfn zzfnVar) {
        if (zzfnVar == null) {
            return "null";
        }
        StringBuilder sbR = androidx.camera.core.processing.util.a.r("\nproperty_filter {\n");
        if (zzfnVar.zza()) {
            zzS(sbR, 0, "filter_id", Integer.valueOf(zzfnVar.zzb()));
        }
        zzS(sbR, 0, "property_name", this.zzu.zzl().zzc(zzfnVar.zzc()));
        String strZzO = zzO(zzfnVar.zze(), zzfnVar.zzf(), zzfnVar.zzh());
        if (!strZzO.isEmpty()) {
            zzS(sbR, 0, "filter_type", strZzO);
        }
        zzL(sbR, 1, zzfnVar.zzd());
        sbR.append("}\n");
        return sbR.toString();
    }

    public final Parcelable zzl(byte[] bArr, Parcelable.Creator creator) {
        Parcelable parcelable = null;
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                parcelObtain.unmarshall(bArr, 0, bArr.length);
                parcelObtain.setDataPosition(0);
                parcelable = (Parcelable) creator.createFromParcel(parcelObtain);
            } catch (SafeParcelReader.ParseException unused) {
                this.zzu.zzaV().zzb().zza("Failed to load parcelable from buffer");
            }
            return parcelable;
        } finally {
            parcelObtain.recycle();
        }
    }

    public final List zzq(List list, List list2) {
        int i2;
        ArrayList arrayList = new ArrayList(list);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num.intValue() < 0) {
                this.zzu.zzaV().zze().zzb("Ignoring negative bit index to be cleared", num);
            } else {
                int iIntValue = num.intValue() / 64;
                if (iIntValue >= arrayList.size()) {
                    this.zzu.zzaV().zze().zzc("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(iIntValue, Long.valueOf(((Long) arrayList.get(iIntValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i8 = size2;
            i2 = size;
            size = i8;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i2);
    }

    public final boolean zzs(long j, long j3) {
        return j == 0 || j3 <= 0 || Math.abs(this.zzu.zzaZ().currentTimeMillis() - j) > j3;
    }

    @WorkerThread
    public final long zzt(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        zzic zzicVar = this.zzu;
        zzicVar.zzk().zzg();
        MessageDigest messageDigestZzO = zzpp.zzO();
        if (messageDigestZzO != null) {
            return zzpp.zzP(messageDigestZzO.digest(bArr));
        }
        com.google.android.gms.ads.internal.client.a.n(zzicVar, "Failed to get MD5");
        return 0L;
    }

    public final long zzu(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return zzt(str.getBytes(Charset.forName(Key.STRING_CHARSET_NAME)));
    }

    public final byte[] zzv(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            this.zzu.zzaV().zzb().zzb("Failed to gzip content", e);
            throw e;
        }
    }

    public final Map zzz(Bundle bundle, boolean z2) {
        HashMap map = new HashMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            boolean z7 = obj instanceof Parcelable[];
            if (z7 || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
                if (z2) {
                    ArrayList arrayList = new ArrayList();
                    if (z7) {
                        for (Parcelable parcelable : (Parcelable[]) obj) {
                            if (parcelable instanceof Bundle) {
                                arrayList.add(zzz((Bundle) parcelable, false));
                            }
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size = arrayList2.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            Object obj2 = arrayList2.get(i2);
                            if (obj2 instanceof Bundle) {
                                arrayList.add(zzz((Bundle) obj2, false));
                            }
                        }
                    } else if (obj instanceof Bundle) {
                        arrayList.add(zzz((Bundle) obj, false));
                    }
                    map.put(str, arrayList);
                }
            } else if (obj != null) {
                map.put(str, obj);
            }
        }
        return map;
    }
}
