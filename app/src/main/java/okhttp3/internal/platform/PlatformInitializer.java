package okhttp3.internal.platform;

import android.content.Context;
import androidx.startup.Initializer;
import java.util.List;
import kotlin.jvm.internal.k;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class PlatformInitializer implements Initializer<Platform> {
    @Override // androidx.startup.Initializer
    public List<Class<Initializer<?>>> dependencies() {
        return r.f13638a;
    }

    @Override // androidx.startup.Initializer
    public Platform create(Context context) {
        k.e(context, "context");
        PlatformRegistry.INSTANCE.setApplicationContext(context);
        return Platform.Companion.get();
    }
}
