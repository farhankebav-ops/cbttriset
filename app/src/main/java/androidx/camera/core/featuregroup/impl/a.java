package androidx.camera.core.featuregroup.impl;

import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.featuregroup.impl.FeatureCombinationQuery;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    static {
        FeatureCombinationQuery.Companion companion = FeatureCombinationQuery.Companion;
    }

    public static SessionConfig.Builder a(UseCaseConfig useCaseConfig, Size size, DynamicRange dynamicRange) {
        return FeatureCombinationQuery.Companion.createSessionConfigBuilder(useCaseConfig, size, dynamicRange);
    }
}
