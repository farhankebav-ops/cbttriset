package com.unity3d.ads.core.configuration;

import com.unity3d.services.core.misc.JsonStorage;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class MediationTraitsMetadataReader extends MetadataReader<JSONObject> {
    public static final String BOLD_SDK_ENABLED = "boldSdkEnabled";
    public static final Companion Companion = new Companion(null);
    public static final String MEDIATION_TRAITS = "mediation.traits.value";
    public static final String USE_REFACTORED_HTTP_CLIENT = "useRefactoredHttpClient";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediationTraitsMetadataReader(JsonStorage jsonStorage) {
        super(jsonStorage, MEDIATION_TRAITS);
        k.e(jsonStorage, "jsonStorage");
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Boolean getBooleanTrait(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.k.e(r4, r0)
            com.unity3d.services.core.misc.JsonStorage r0 = r3.getJsonStorage()
            java.lang.String r1 = r3.getKey()
            java.lang.Object r0 = r0.get(r1)
            r1 = 0
            if (r0 == 0) goto L1c
            boolean r2 = r0 instanceof org.json.JSONObject
            if (r2 == 0) goto L19
            goto L1a
        L19:
            r0 = r1
        L1a:
            if (r0 != 0) goto L1d
        L1c:
            r0 = r1
        L1d:
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            if (r0 == 0) goto L34
            boolean r2 = r0.has(r4)
            if (r2 == 0) goto L28
            goto L29
        L28:
            r0 = r1
        L29:
            if (r0 == 0) goto L34
            boolean r4 = r0.optBoolean(r4)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            return r4
        L34:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.configuration.MediationTraitsMetadataReader.getBooleanTrait(java.lang.String):java.lang.Boolean");
    }
}
