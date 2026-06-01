package c3;

import com.ironsource.mediationsdk.adunit.adapter.listener.NetworkInitializationListener;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract /* synthetic */ class a {
    public static void a(NetworkInitializationListener networkInitializationListener, int i2, String str, Map map) {
        networkInitializationListener.onInitFailed(i2, str);
    }

    public static void b(NetworkInitializationListener networkInitializationListener, Map map) {
        networkInitializationListener.onInitSuccess();
    }
}
