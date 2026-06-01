package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.ads.internal.client.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzkw implements ObjectEncoder {
    static final zzkw zza = new zzkw();

    static {
        a.A(7, a.x(6, a.x(5, a.x(4, a.x(3, a.x(2, a.x(1, FieldDescriptor.builder("options"), "roughDownloadDurationMs"), IronSourceConstants.EVENTS_ERROR_CODE), "exactDownloadDurationMs"), "downloadStatus"), "downloadFailureStatus"), "mddDownloadErrorCodes"));
    }

    private zzkw() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
