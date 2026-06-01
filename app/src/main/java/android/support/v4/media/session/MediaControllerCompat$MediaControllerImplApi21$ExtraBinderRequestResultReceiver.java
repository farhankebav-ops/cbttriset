package android.support.v4.media.session;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.ResultReceiver;
import androidx.core.app.BundleCompat;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver extends ResultReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference f3268a;

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i2, Bundle bundle) {
        c cVar;
        e eVar = (e) this.f3268a.get();
        if (eVar == null || bundle == null) {
            return;
        }
        synchronized (eVar.f3292b) {
            MediaSessionCompat$Token mediaSessionCompat$Token = eVar.e;
            IBinder binder = BundleCompat.getBinder(bundle, "android.support.v4.media.session.EXTRA_BINDER");
            int i8 = b.f3289a;
            if (binder == null) {
                cVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = binder.queryLocalInterface("android.support.v4.media.session.IMediaSession");
                if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) {
                    a aVar = new a();
                    aVar.f3288a = binder;
                    cVar = aVar;
                } else {
                    cVar = (c) iInterfaceQueryLocalInterface;
                }
            }
            mediaSessionCompat$Token.f3273b = cVar;
            MediaSessionCompat$Token mediaSessionCompat$Token2 = eVar.e;
            bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE");
            mediaSessionCompat$Token2.getClass();
            eVar.a();
        }
    }
}
