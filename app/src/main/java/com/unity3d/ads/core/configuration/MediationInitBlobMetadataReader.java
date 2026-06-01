package com.unity3d.ads.core.configuration;

import com.unity3d.services.core.misc.JsonStorage;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class MediationInitBlobMetadataReader extends MetadataReader<String> {
    public static final Companion Companion = new Companion(null);
    public static final String MEDIATION_UADS_INIT_BLOB = "mediation.uads_init_blob.value";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediationInitBlobMetadataReader(JsonStorage jsonStorage) {
        super(jsonStorage, MEDIATION_UADS_INIT_BLOB);
        k.e(jsonStorage, "jsonStorage");
    }
}
