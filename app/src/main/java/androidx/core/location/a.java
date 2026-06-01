package androidx.core.location;

import android.app.Notification;
import android.location.GnssMeasurementsEvent$Callback;
import android.os.LocaleList;
import android.view.PointerIcon;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ Notification.DecoratedMediaCustomViewStyle e() {
        return new Notification.DecoratedMediaCustomViewStyle();
    }

    public static /* bridge */ /* synthetic */ GnssMeasurementsEvent$Callback f(Object obj) {
        return (GnssMeasurementsEvent$Callback) obj;
    }

    public static /* bridge */ /* synthetic */ LocaleList i(Object obj) {
        return (LocaleList) obj;
    }

    public static /* bridge */ /* synthetic */ PointerIcon j(Object obj) {
        return (PointerIcon) obj;
    }

    public static /* bridge */ /* synthetic */ Class l() {
        return GnssMeasurementsEvent$Callback.class;
    }

    public static /* bridge */ /* synthetic */ Consumer r(Object obj) {
        return (Consumer) obj;
    }
}
