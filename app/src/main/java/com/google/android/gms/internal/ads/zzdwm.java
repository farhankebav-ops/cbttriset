package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdwm {
    public final long zza;
    public final int[] zzb;

    private zzdwm(long j, int[] iArr) {
        this.zza = j;
        this.zzb = iArr;
    }

    public static zzgpe zza(JsonReader jsonReader) throws IOException {
        int i2 = zzgpe.zzd;
        zzgpb zzgpbVar = new zzgpb();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            zzgpe zzgpeVarZzi = zzgpe.zzi();
            jsonReader.beginObject();
            zzdwm zzdwmVar = null;
            Long lValueOf = null;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (Objects.equals(strNextName, "id")) {
                    lValueOf = Long.valueOf(jsonReader.nextLong());
                } else if (Objects.equals(strNextName, "event_types")) {
                    zzgpb zzgpbVar2 = new zzgpb();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        zzgpbVar2.zzf(Integer.valueOf(jsonReader.nextInt()));
                    }
                    jsonReader.endArray();
                    zzgpeVarZzi = zzgpbVar2.zzi();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            if (lValueOf != null && !zzgpeVarZzi.isEmpty()) {
                long jLongValue = lValueOf.longValue();
                int[] iArr = new int[zzgpeVarZzi.size()];
                for (int i8 = 0; i8 < zzgpeVarZzi.size(); i8++) {
                    iArr[i8] = ((Integer) zzgpeVarZzi.get(i8)).intValue();
                }
                zzdwmVar = new zzdwm(jLongValue, iArr);
            }
            if (zzdwmVar != null) {
                zzgpbVar.zzf(zzdwmVar);
            }
        }
        jsonReader.endArray();
        return zzgpbVar.zzi();
    }
}
