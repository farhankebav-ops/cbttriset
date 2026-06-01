package androidx.camera.camera2.internal.compat.quirk;

import androidx.camera.core.SessionConfig;
import androidx.camera.core.impl.QuirkSettings;
import androidx.core.content.IntentSanitizer;
import androidx.core.util.Consumer;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3413a;

    public /* synthetic */ b(int i2) {
        this.f3413a = i2;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        switch (this.f3413a) {
            case 0:
                DeviceQuirks.lambda$static$0((QuirkSettings) obj);
                break;
            case 1:
                SessionConfig.featureSelectionListener$lambda$0((Set) obj);
                break;
            case 2:
                androidx.camera.core.internal.compat.quirk.DeviceQuirks.lambda$static$0((QuirkSettings) obj);
                break;
            case 3:
                androidx.camera.extensions.internal.compat.quirk.DeviceQuirks.lambda$static$0((QuirkSettings) obj);
                break;
            case 4:
                androidx.camera.video.internal.compat.quirk.DeviceQuirks.lambda$static$0((QuirkSettings) obj);
                break;
            case 5:
                IntentSanitizer.lambda$sanitizeByThrowing$1((String) obj);
                break;
            case 6:
                IntentSanitizer.lambda$sanitizeByFiltering$0((String) obj);
                break;
            default:
                androidx.camera.view.internal.compat.quirk.DeviceQuirks.lambda$static$0((QuirkSettings) obj);
                break;
        }
    }
}
