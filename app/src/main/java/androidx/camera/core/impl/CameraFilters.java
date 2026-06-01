package androidx.camera.core.impl;

import androidx.camera.core.CameraFilter;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class CameraFilters {
    public static final CameraFilter ANY;
    public static final CameraFilter NONE;

    static {
        final int i2 = 0;
        ANY = new CameraFilter() { // from class: androidx.camera.core.impl.i
            @Override // androidx.camera.core.CameraFilter
            public final List filter(List list) {
                switch (i2) {
                    case 0:
                        return CameraFilters.lambda$static$0(list);
                    default:
                        return CameraFilters.lambda$static$1(list);
                }
            }

            @Override // androidx.camera.core.CameraFilter
            public final /* synthetic */ Identifier getIdentifier() {
                switch (i2) {
                }
                return androidx.camera.core.g.a(this);
            }
        };
        final int i8 = 1;
        NONE = new CameraFilter() { // from class: androidx.camera.core.impl.i
            @Override // androidx.camera.core.CameraFilter
            public final List filter(List list) {
                switch (i8) {
                    case 0:
                        return CameraFilters.lambda$static$0(list);
                    default:
                        return CameraFilters.lambda$static$1(list);
                }
            }

            @Override // androidx.camera.core.CameraFilter
            public final /* synthetic */ Identifier getIdentifier() {
                switch (i8) {
                }
                return androidx.camera.core.g.a(this);
            }
        };
    }

    private CameraFilters() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$static$1(List list) {
        return Collections.EMPTY_LIST;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$static$0(List list) {
        return list;
    }
}
