package com.google.android.gms.ads.internal.util.client;

import android.util.JsonWriter;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.ironsource.C2300e4;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzl {
    public static final /* synthetic */ int zza = 0;

    @GuardedBy("lock")
    private static boolean zzc = false;

    @GuardedBy("lock")
    private static boolean zzd = false;
    private final List zzg;
    private static final Object zzb = new Object();
    private static final Clock zze = DefaultClock.getInstance();
    private static final Set zzf = new HashSet(Arrays.asList(new String[0]));

    public zzl() {
        throw null;
    }

    public static void zzg() {
        synchronized (zzb) {
            zzc = false;
            zzd = false;
            zzo.zzi("Ad debug logging enablement is out of date.");
        }
    }

    public static void zzh(boolean z2) {
        synchronized (zzb) {
            zzc = true;
            zzd = z2;
        }
    }

    public static boolean zzi() {
        boolean z2;
        synchronized (zzb) {
            z2 = zzc;
        }
        return z2;
    }

    public static boolean zzj() {
        boolean z2;
        synchronized (zzb) {
            try {
                z2 = false;
                if (zzc && zzd) {
                    z2 = true;
                }
            } finally {
            }
        }
        return z2;
    }

    public static /* synthetic */ void zzk(String str, String str2, Map map, byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("uri").value(str);
        jsonWriter.name("verb").value(str2);
        jsonWriter.endObject();
        zzp(jsonWriter, map);
        if (bArr != null) {
            jsonWriter.name(C2300e4.h.E0).value(Base64Utils.encode(bArr));
        }
        jsonWriter.endObject();
    }

    public static /* synthetic */ void zzl(int i2, Map map, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("code").value(i2);
        jsonWriter.endObject();
        zzp(jsonWriter, map);
        jsonWriter.endObject();
    }

    private final void zzm(final String str, final String str2, @Nullable final Map map, @Nullable final byte[] bArr) {
        zzq("onNetworkRequest", new zzk() { // from class: com.google.android.gms.ads.internal.util.client.zzj
            @Override // com.google.android.gms.ads.internal.util.client.zzk
            public final /* synthetic */ void zza(JsonWriter jsonWriter) throws IOException {
                zzl.zzk(str, str2, map, bArr, jsonWriter);
            }
        });
    }

    private final void zzn(@Nullable final Map map, final int i2) {
        zzq("onNetworkResponse", new zzk() { // from class: com.google.android.gms.ads.internal.util.client.zzg
            @Override // com.google.android.gms.ads.internal.util.client.zzk
            public final /* synthetic */ void zza(JsonWriter jsonWriter) throws IOException {
                zzl.zzl(i2, map, jsonWriter);
            }
        });
    }

    private final void zzo(@Nullable final String str) {
        zzq("onNetworkRequestError", new zzk() { // from class: com.google.android.gms.ads.internal.util.client.zzi
            @Override // com.google.android.gms.ads.internal.util.client.zzk
            public final /* synthetic */ void zza(JsonWriter jsonWriter) throws IOException {
                int i2 = zzl.zza;
                jsonWriter.name("params").beginObject();
                String str2 = str;
                if (str2 != null) {
                    jsonWriter.name("error_description").value(str2);
                }
                jsonWriter.endObject();
            }
        });
    }

    private static void zzp(JsonWriter jsonWriter, @Nullable Map map) throws IOException {
        if (map == null) {
            return;
        }
        jsonWriter.name("headers").beginArray();
        Iterator it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            if (!zzf.contains(str)) {
                if (!(entry.getValue() instanceof List)) {
                    if (!(entry.getValue() instanceof String)) {
                        zzo.zzf("Connection headers should be either Map<String, String> or Map<String, List<String>>");
                        break;
                    }
                    jsonWriter.beginObject();
                    jsonWriter.name("name").value(str);
                    jsonWriter.name("value").value((String) entry.getValue());
                    jsonWriter.endObject();
                } else {
                    for (String str2 : (List) entry.getValue()) {
                        jsonWriter.beginObject();
                        jsonWriter.name("name").value(str);
                        jsonWriter.name("value").value(str2);
                        jsonWriter.endObject();
                    }
                }
            }
        }
        jsonWriter.endArray();
    }

    private final void zzq(String str, zzk zzkVar) {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name("timestamp").value(zze.currentTimeMillis());
            jsonWriter.name(NotificationCompat.CATEGORY_EVENT).value(str);
            jsonWriter.name("components").beginArray();
            Iterator it = this.zzg.iterator();
            while (it.hasNext()) {
                jsonWriter.value((String) it.next());
            }
            jsonWriter.endArray();
            zzkVar.zza(jsonWriter);
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException e) {
            zzo.zzg("unable to log", e);
        }
        zzr(stringWriter.toString());
    }

    private static synchronized void zzr(String str) {
        try {
            zzo.zzh("GMA Debug BEGIN");
            int i2 = 0;
            while (i2 < str.length()) {
                int i8 = i2 + 4000;
                zzo.zzh("GMA Debug CONTENT ".concat(String.valueOf(str.substring(i2, Math.min(i8, str.length())))));
                i2 = i8;
            }
            zzo.zzh("GMA Debug FINISH");
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void zza(HttpURLConnection httpURLConnection, @Nullable byte[] bArr) {
        if (zzj()) {
            zzm(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), httpURLConnection.getRequestProperties() == null ? null : new HashMap(httpURLConnection.getRequestProperties()), bArr);
        }
    }

    public final void zzb(String str, String str2, @Nullable Map map, @Nullable byte[] bArr) {
        if (zzj()) {
            zzm(str, "GET", map, bArr);
        }
    }

    public final void zzc(HttpURLConnection httpURLConnection, int i2) {
        if (zzj()) {
            String responseMessage = null;
            zzn(httpURLConnection.getHeaderFields() == null ? null : new HashMap(httpURLConnection.getHeaderFields()), i2);
            if (i2 < 200 || i2 >= 300) {
                try {
                    responseMessage = httpURLConnection.getResponseMessage();
                } catch (IOException e) {
                    zzo.zzi("Can not get error message from error HttpURLConnection\n".concat(String.valueOf(e.getMessage())));
                }
                zzo(responseMessage);
            }
        }
    }

    public final void zzd(@Nullable Map map, int i2) {
        if (zzj()) {
            zzn(map, i2);
            if (i2 < 200 || i2 >= 300) {
                zzo(null);
            }
        }
    }

    public final void zze(@Nullable String str) {
        if (zzj() && str != null) {
            zzf(str.getBytes());
        }
    }

    public final void zzf(final byte[] bArr) {
        zzq("onNetworkResponseBody", new zzk() { // from class: com.google.android.gms.ads.internal.util.client.zzh
            @Override // com.google.android.gms.ads.internal.util.client.zzk
            public final /* synthetic */ void zza(JsonWriter jsonWriter) throws IOException {
                int i2 = zzl.zza;
                jsonWriter.name("params").beginObject();
                byte[] bArr2 = bArr;
                int length = bArr2.length;
                String strEncode = Base64Utils.encode(bArr2);
                if (length < 10000) {
                    jsonWriter.name(C2300e4.h.E0).value(strEncode);
                } else {
                    String strZzf = zzf.zzf(strEncode);
                    if (strZzf != null) {
                        jsonWriter.name("bodydigest").value(strZzf);
                    }
                }
                jsonWriter.name("bodylength").value(length);
                jsonWriter.endObject();
            }
        });
    }

    public zzl(@Nullable String str) {
        this.zzg = !zzj() ? new ArrayList() : Arrays.asList("network_request_".concat(String.valueOf(UUID.randomUUID().toString())));
    }
}
