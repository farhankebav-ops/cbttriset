package android.support.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface f extends IInterface {

    /* JADX INFO: renamed from: s6, reason: collision with root package name */
    public static final String f3233s6 = "android$support$customtabs$ICustomTabsService".replace('$', '.');

    Bundle extraCommand(String str, Bundle bundle);

    boolean isEngagementSignalsApiAvailable(c cVar, Bundle bundle);

    boolean mayLaunchUrl(c cVar, Uri uri, Bundle bundle, List list);

    boolean newSession(c cVar);

    boolean newSessionWithExtras(c cVar, Bundle bundle);

    int postMessage(c cVar, String str, Bundle bundle);

    boolean receiveFile(c cVar, Uri uri, int i2, Bundle bundle);

    boolean requestPostMessageChannel(c cVar, Uri uri);

    boolean requestPostMessageChannelWithExtras(c cVar, Uri uri, Bundle bundle);

    boolean setEngagementSignalsCallback(c cVar, IBinder iBinder, Bundle bundle);

    boolean updateVisuals(c cVar, Bundle bundle);

    boolean validateRelationship(c cVar, int i2, Uri uri, Bundle bundle);

    boolean warmup(long j);
}
