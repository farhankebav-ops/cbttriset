package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import java.util.UUID;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidGenerateByteStringId implements GetByteStringId {
    @Override // com.unity3d.ads.core.domain.GetByteStringId
    public ByteString invoke() {
        UUID uuidRandomUUID = UUID.randomUUID();
        k.d(uuidRandomUUID, "randomUUID()");
        return ProtobufExtensionsKt.toByteString(uuidRandomUUID);
    }
}
