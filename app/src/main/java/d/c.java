package d;

import android.content.Context;
import androidx.camera.camera2.Camera2Config;
import androidx.camera.core.impl.UseCaseConfigFactory;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements UseCaseConfigFactory.Provider {
    @Override // androidx.camera.core.impl.UseCaseConfigFactory.Provider
    public final UseCaseConfigFactory newInstance(Context context) {
        return Camera2Config.lambda$defaultConfig$1(context);
    }
}
