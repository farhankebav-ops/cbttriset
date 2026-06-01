package androidx.browser.customtabs;

import android.os.Bundle;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface EngagementSignalsCallback {
    void onGreatestScrollPercentageIncreased(@IntRange(from = 1, to = 100) int i2, @NonNull Bundle bundle);

    void onSessionEnded(boolean z2, @NonNull Bundle bundle);

    void onVerticalScrollEvent(boolean z2, @NonNull Bundle bundle);
}
