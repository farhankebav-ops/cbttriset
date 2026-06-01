package android.support.customtabs;

import android.os.Bundle;
import android.os.IInterface;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface i extends IInterface {

    /* JADX INFO: renamed from: t6, reason: collision with root package name */
    public static final String f3235t6 = "android$support$customtabs$IEngagementSignalsCallback".replace('$', '.');

    void onGreatestScrollPercentageIncreased(int i2, Bundle bundle);

    void onSessionEnded(boolean z2, Bundle bundle);

    void onVerticalScrollEvent(boolean z2, Bundle bundle);
}
