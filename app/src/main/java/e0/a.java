package e0;

import android.os.Build;
import android.view.View;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11206a = Build.VERSION.SDK_INT;

    public static int a(long j, long j3) {
        return Math.min(Math.max(0, j3 > 0 ? (int) (((j * 1.0d) / j3) * 100.0d) : 0), 100);
    }

    public static String b(long j) {
        StringBuilder sb = new StringBuilder();
        long j3 = j / RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS;
        long j8 = ((j % 3600000) % RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS) / 1000;
        if (j3 >= 10) {
            sb.append(j3);
        } else if (j3 > 0) {
            sb.append(0);
            sb.append(j3);
        } else {
            sb.append("00");
        }
        sb.append(":");
        if (j8 >= 10) {
            sb.append(j8);
        } else if (j8 > 0) {
            sb.append(0);
            sb.append(j8);
        } else {
            sb.append("00");
        }
        return sb.toString();
    }

    public static void c(View view, boolean z2) {
        if (view == null) {
            return;
        }
        if (z2) {
            view.setSystemUiVisibility(0);
            return;
        }
        int i2 = f11206a;
        if (i2 >= 19) {
            view.setSystemUiVisibility(3846);
        } else if (i2 >= 16) {
            view.setSystemUiVisibility(5);
        } else {
            view.setSystemUiVisibility(1);
        }
    }
}
