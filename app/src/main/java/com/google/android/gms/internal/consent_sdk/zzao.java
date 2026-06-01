package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzao implements zzd {
    private final Application zza;
    private final zzaq zzb;
    private final zzl zzc;
    private final Executor zzd;

    public zzao(Application application, zzaq zzaqVar, zzl zzlVar, Executor executor) {
        this.zza = application;
        this.zzb = zzaqVar;
        this.zzd = executor;
        this.zzc = zzlVar;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzd
    public final Executor zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzd
    public final boolean zzb(String str, JSONObject jSONObject) {
        int iHashCode = str.hashCode();
        if (iHashCode != 94746189) {
            if (iHashCode == 113399775 && str.equals("write")) {
                zzco zzcoVar = new zzco(this.zza);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Object objOpt = jSONObject.opt(next);
                    Log.d("UserMessagingPlatform", "Writing to storage: [" + next + "] " + String.valueOf(objOpt));
                    if (zzcoVar.zze(next, objOpt)) {
                        this.zzb.zzd().add(next);
                    } else {
                        Log.d("UserMessagingPlatform", "Failed writing key: ".concat(String.valueOf(next)));
                    }
                }
                this.zzb.zzf();
                zzcoVar.zzc();
                Map mapZzb = zzcoVar.zzb();
                if (mapZzb.size() > 1) {
                    this.zzc.zza(mapZzb);
                    zzcoVar.zzd();
                }
                return true;
            }
        } else if (str.equals("clear")) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(UserMetadata.KEYDATA_FILENAME);
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                Log.d("UserMessagingPlatform", "Action[clear]: wrong args.".concat(String.valueOf(jSONObject.toString())));
            } else {
                HashSet hashSet = new HashSet();
                int length = jSONArrayOptJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i2);
                    if (TextUtils.isEmpty(strOptString)) {
                        Log.d("UserMessagingPlatform", "Action[clear]: empty key at index: " + i2);
                    } else {
                        hashSet.add(strOptString);
                    }
                }
                zzcp.zzb(this.zza, hashSet);
            }
            return true;
        }
        return false;
    }
}
