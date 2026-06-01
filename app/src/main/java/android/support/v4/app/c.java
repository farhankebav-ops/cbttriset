package android.support.v4.app;

import android.app.Notification;
import android.os.IInterface;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface c extends IInterface {

    /* JADX INFO: renamed from: x6, reason: collision with root package name */
    public static final String f3242x6 = "android$support$v4$app$INotificationSideChannel".replace('$', '.');

    void cancel(String str, int i2, String str2);

    void cancelAll(String str);

    void notify(String str, int i2, String str2, Notification notification);
}
