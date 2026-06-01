package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.ads.internal.client.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfe implements ObjectEncoder {
    static final zzfe zza = new zzfe();

    static {
        a.l(4, a.f(3, a.f(2, a.f(1, FieldDescriptor.builder("supportedFormats"), "durationMs"), IronSourceConstants.EVENTS_ERROR_CODE), "allowManualInput"));
    }

    private zzfe() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
