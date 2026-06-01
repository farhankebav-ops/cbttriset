package androidx.camera.core;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.impl.AdapterCameraInfo;
import androidx.camera.core.impl.Identifier;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class CameraIdentifier {
    public static final Companion Companion = new Companion(null);
    private final List<String> cameraIds;
    private final Identifier compatibilityId;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        public static /* synthetic */ CameraIdentifier create$default(Companion companion, List list, Identifier identifier, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                identifier = null;
            }
            return companion.create((List<String>) list, identifier);
        }

        public final CameraIdentifier create(String primaryCameraId) {
            kotlin.jvm.internal.k.e(primaryCameraId, "primaryCameraId");
            return create$default(this, primaryCameraId, null, null, 6, null);
        }

        public final CameraIdentifier fromAdapterInfos(AdapterCameraInfo primaryInfo, AdapterCameraInfo adapterCameraInfo) {
            kotlin.jvm.internal.k.e(primaryInfo, "primaryInfo");
            String cameraId = adapterCameraInfo != null ? adapterCameraInfo.getCameraId() : null;
            Identifier compatibilityId = primaryInfo.getCameraConfig().getCompatibilityId();
            kotlin.jvm.internal.k.d(compatibilityId, "getCompatibilityId(...)");
            String cameraId2 = primaryInfo.getCameraId();
            kotlin.jvm.internal.k.d(cameraId2, "getCameraId(...)");
            return create(cameraId2, cameraId, compatibilityId);
        }

        private Companion() {
        }

        public static /* synthetic */ CameraIdentifier create$default(Companion companion, String str, String str2, Identifier identifier, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                str2 = null;
            }
            if ((i2 & 4) != 0) {
                identifier = null;
            }
            return companion.create(str, str2, identifier);
        }

        public final CameraIdentifier create(String primaryCameraId, String str) {
            kotlin.jvm.internal.k.e(primaryCameraId, "primaryCameraId");
            return create$default(this, primaryCameraId, str, null, 4, null);
        }

        @VisibleForTesting
        public final CameraIdentifier create(List<String> cameraIds) {
            kotlin.jvm.internal.k.e(cameraIds, "cameraIds");
            return create$default(this, cameraIds, null, 2, null);
        }

        @VisibleForTesting
        public final CameraIdentifier create(List<String> cameraIds, Identifier identifier) {
            kotlin.jvm.internal.k.e(cameraIds, "cameraIds");
            return new CameraIdentifier(cameraIds, identifier, null);
        }

        public final CameraIdentifier create(String primaryCameraId, String str, Identifier identifier) {
            kotlin.jvm.internal.k.e(primaryCameraId, "primaryCameraId");
            ArrayList arrayListI0 = r5.m.I0(primaryCameraId);
            if (str != null) {
                arrayListI0.add(str);
            }
            return create(arrayListI0, identifier);
        }
    }

    public /* synthetic */ CameraIdentifier(List list, Identifier identifier, kotlin.jvm.internal.f fVar) {
        this(list, identifier);
    }

    public static final CameraIdentifier create(String str) {
        return Companion.create(str);
    }

    public static final CameraIdentifier fromAdapterInfos(AdapterCameraInfo adapterCameraInfo, AdapterCameraInfo adapterCameraInfo2) {
        return Companion.fromAdapterInfos(adapterCameraInfo, adapterCameraInfo2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraIdentifier)) {
            return false;
        }
        CameraIdentifier cameraIdentifier = (CameraIdentifier) obj;
        return kotlin.jvm.internal.k.a(this.cameraIds, cameraIdentifier.cameraIds) && kotlin.jvm.internal.k.a(this.compatibilityId, cameraIdentifier.compatibilityId);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final List<String> getCameraIds() {
        return this.cameraIds;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Identifier getCompatibilityId() {
        return this.compatibilityId;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final String getInternalId() {
        Preconditions.checkState(this.cameraIds.size() == 1, "getInternalId() is only available for single-camera identifiers.");
        return (String) r5.l.X0(this.cameraIds);
    }

    public int hashCode() {
        int iHashCode = this.cameraIds.hashCode() * 31;
        Identifier identifier = this.compatibilityId;
        return iHashCode + (identifier != null ? identifier.hashCode() : 0);
    }

    public final boolean isOf(Camera camera) {
        kotlin.jvm.internal.k.e(camera, "camera");
        Preconditions.checkNotNull(camera);
        return equals(camera.getCameraInfo().getCameraIdentifier());
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            r8 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "CameraIdentifier{cameraIds="
            r0.<init>(r1)
            java.util.List<java.lang.String> r2 = r8.cameraIds
            r6 = 0
            r7 = 62
            java.lang.String r3 = ","
            r4 = 0
            r5 = 0
            java.lang.String r1 = r5.l.c1(r2, r3, r4, r5, r6, r7)
            r0.append(r1)
            androidx.camera.core.impl.Identifier r1 = r8.compatibilityId
            if (r1 == 0) goto L2b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = ", compatId="
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r1 != 0) goto L2d
        L2b:
            java.lang.String r1 = ""
        L2d:
            r2 = 125(0x7d, float:1.75E-43)
            java.lang.String r0 = a1.a.e(r2, r1, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.CameraIdentifier.toString():java.lang.String");
    }

    private CameraIdentifier(List<String> list, Identifier identifier) {
        this.cameraIds = list;
        this.compatibilityId = identifier;
        Preconditions.checkArgument(!list.isEmpty(), "Camera ID set cannot be empty.");
    }

    public static final CameraIdentifier create(String str, String str2) {
        return Companion.create(str, str2);
    }

    public static final CameraIdentifier create(String str, String str2, Identifier identifier) {
        return Companion.create(str, str2, identifier);
    }

    @VisibleForTesting
    public static final CameraIdentifier create(List<String> list) {
        return Companion.create(list);
    }

    public final boolean isOf(CameraInfo cameraInfo) {
        kotlin.jvm.internal.k.e(cameraInfo, "cameraInfo");
        Preconditions.checkNotNull(cameraInfo);
        return equals(cameraInfo.getCameraIdentifier());
    }

    @VisibleForTesting
    public static final CameraIdentifier create(List<String> list, Identifier identifier) {
        return Companion.create(list, identifier);
    }
}
