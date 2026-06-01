package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.ads.internal.client.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfr implements ObjectEncoder {
    static final zzfr zza = new zzfr();

    static {
        a.l(7, a.f(6, a.f(5, a.f(4, a.f(3, a.f(2, a.f(1, FieldDescriptor.builder("options"), JsonStorageKeyNames.SESSION_ID_KEY), "sessionDurationMs"), "callerAppId"), "numRetakes"), "pages"), "isSessionCanceled"));
    }

    private zzfr() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
