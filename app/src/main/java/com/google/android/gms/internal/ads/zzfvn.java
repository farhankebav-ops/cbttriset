package com.google.android.gms.internal.ads;

import androidx.datastore.core.Serializer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfvn implements Serializer {
    public static final zzfvn zza = new zzfvn();
    private static final zzfvk zzb;

    static {
        zzfvk zzfvkVarZzd = zzfvk.zzd();
        kotlin.jvm.internal.k.d(zzfvkVarZzd, "getDefaultInstance(...)");
        zzb = zzfvkVarZzd;
    }

    private zzfvn() {
    }

    @Override // androidx.datastore.core.Serializer
    public final /* synthetic */ Object getDefaultValue() {
        return zzb;
    }

    @Override // androidx.datastore.core.Serializer
    public final Object readFrom(InputStream inputStream, v5.c cVar) {
        try {
            zzfvk zzfvkVarZzc = zzfvk.zzc(inputStream);
            kotlin.jvm.internal.k.b(zzfvkVarZzc);
            return zzfvkVarZzc;
        } catch (Exception unused) {
            return zzb;
        }
    }

    @Override // androidx.datastore.core.Serializer
    public final /* synthetic */ Object writeTo(Object obj, OutputStream outputStream, v5.c cVar) throws IOException {
        ((zzfvk) obj).zzaO(outputStream);
        return q5.x.f13520a;
    }
}
