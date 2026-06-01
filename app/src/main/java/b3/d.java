package b3;

import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract /* synthetic */ class d {
    public static void a(AdapterAdViewListener adapterAdViewListener, Map map) {
        adapterAdViewListener.onAdLeftApplication();
    }

    public static void b(AdapterAdViewListener adapterAdViewListener, View view, FrameLayout.LayoutParams layoutParams, Map map) {
        adapterAdViewListener.onAdLoadSuccess(view, layoutParams);
    }

    public static void c(AdapterAdViewListener adapterAdViewListener, Map map) {
        adapterAdViewListener.onAdScreenDismissed();
    }

    public static void d(AdapterAdViewListener adapterAdViewListener, Map map) {
        adapterAdViewListener.onAdScreenPresented();
    }
}
