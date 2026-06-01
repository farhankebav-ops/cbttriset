package androidx.camera.camera2.internal;

import android.adservices.adid.AdId;
import android.adservices.adid.AdIdManager;
import android.adservices.adselection.AdSelectionConfig;
import android.adservices.adselection.AdSelectionManager;
import android.adservices.adselection.AdSelectionOutcome;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class w0 {
    public static /* bridge */ /* synthetic */ Class C() {
        return AdSelectionManager.class;
    }

    public static /* bridge */ /* synthetic */ AdId a(Object obj) {
        return (AdId) obj;
    }

    public static /* bridge */ /* synthetic */ AdIdManager c(Object obj) {
        return (AdIdManager) obj;
    }

    public static /* synthetic */ AdSelectionConfig.Builder d() {
        return new AdSelectionConfig.Builder();
    }

    public static /* bridge */ /* synthetic */ AdSelectionManager l(Object obj) {
        return (AdSelectionManager) obj;
    }

    public static /* bridge */ /* synthetic */ AdSelectionOutcome m(Object obj) {
        return (AdSelectionOutcome) obj;
    }

    public static /* bridge */ /* synthetic */ Class q() {
        return AdIdManager.class;
    }
}
