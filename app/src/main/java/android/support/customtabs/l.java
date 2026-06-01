package android.support.customtabs;

import android.os.Bundle;
import android.os.IInterface;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface l extends IInterface {

    /* JADX INFO: renamed from: u6, reason: collision with root package name */
    public static final String f3237u6 = "android$support$customtabs$IPostMessageService".replace('$', '.');

    void onMessageChannelReady(c cVar, Bundle bundle);

    void onPostMessage(c cVar, String str, Bundle bundle);
}
