package com.google.android.gms.internal.ads;

import com.bumptech.glide.load.Key;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbqm {
    private static final Charset zzc = Charset.forName(Key.STRING_CHARSET_NAME);
    public static final zzbqj zza = new zzbqk();
    public static final zzbqh zzb = zzbql.zza;

    public static /* synthetic */ InputStream zza(JSONObject jSONObject) {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(zzc));
    }
}
