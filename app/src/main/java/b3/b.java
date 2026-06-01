package b3;

import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract /* synthetic */ class b {
    public static void a(AdapterAdListener adapterAdListener, Map map) {
        adapterAdListener.onAdClicked();
    }

    public static void b(AdapterAdListener adapterAdListener, AdapterErrorType adapterErrorType, int i2, String str, Map map) {
        adapterAdListener.onAdLoadFailed(adapterErrorType, i2, str);
    }

    public static void c(AdapterAdListener adapterAdListener, Map map) {
        adapterAdListener.onAdLoadSuccess();
    }

    public static void d(AdapterAdListener adapterAdListener, Map map) {
        adapterAdListener.onAdOpened();
    }

    public static void e(AdapterAdListener adapterAdListener, int i2, String str, Map map) {
        adapterAdListener.onAdShowFailed(i2, str);
    }
}
