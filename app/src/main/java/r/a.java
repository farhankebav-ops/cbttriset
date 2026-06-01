package r;

import android.content.Context;
import androidx.work.WorkRequest;
import com.bytedance.sdk.component.MY.IlO.EV;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f13608a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f13609b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f13610c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static EV f13611d = null;
    public static int e = 1;

    public static EV a() {
        if (f13611d == null) {
            EV.IlO ilO = new EV.IlO("v_config");
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            f13611d = ilO.IlO(WorkRequest.MIN_BACKOFF_MILLIS, timeUnit).MY(WorkRequest.MIN_BACKOFF_MILLIS, timeUnit).EO(WorkRequest.MIN_BACKOFF_MILLIS, timeUnit).IlO();
        }
        return f13611d;
    }
}
