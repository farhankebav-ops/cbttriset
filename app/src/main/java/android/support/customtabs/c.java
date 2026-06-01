package android.support.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.IInterface;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface c extends IInterface {

    /* JADX INFO: renamed from: r6, reason: collision with root package name */
    public static final String f3231r6 = "android$support$customtabs$ICustomTabsCallback".replace('$', '.');

    void extraCallback(String str, Bundle bundle);

    Bundle extraCallbackWithResult(String str, Bundle bundle);

    void onActivityLayout(int i2, int i8, int i9, int i10, int i11, Bundle bundle);

    void onActivityResized(int i2, int i8, Bundle bundle);

    void onMessageChannelReady(Bundle bundle);

    void onMinimized(Bundle bundle);

    void onNavigationEvent(int i2, Bundle bundle);

    void onPostMessage(String str, Bundle bundle);

    void onRelationshipValidationResult(int i2, Uri uri, boolean z2, Bundle bundle);

    void onUnminimized(Bundle bundle);

    void onWarmupCompleted(Bundle bundle);
}
