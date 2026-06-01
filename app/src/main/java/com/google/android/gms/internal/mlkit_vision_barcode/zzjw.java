package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.ads.internal.client.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.onesignal.inAppMessages.internal.InAppMessagePage;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzjw implements ObjectEncoder {
    static final zzjw zza = new zzjw();

    static {
        a.A(11, a.x(10, a.x(9, a.x(8, a.x(7, a.x(6, a.x(5, a.x(4, a.x(3, a.x(2, a.x(1, FieldDescriptor.builder("screenName"), JsonStorageKeyNames.SESSION_ID_KEY), "timestampMs"), "options"), "elementName"), "isAutoCaptureMode"), InAppMessagePage.PAGE_INDEX), "appliedToAllPages"), IronSourceConstants.EVENTS_ERROR_CODE), "callerAppId"), "cleanUpStrokeSize"));
    }

    private zzjw() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
