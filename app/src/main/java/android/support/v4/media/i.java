package android.support.v4.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.util.Log;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserProtocol;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends MediaBrowser.ConnectionCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a4.a f3267a;

    public i(a4.a aVar) {
        this.f3267a = aVar;
    }

    @Override // android.media.browse.MediaBrowser.ConnectionCallback
    public final void onConnected() {
        android.support.v4.media.session.c cVar;
        c cVar2 = (c) this.f3267a.f3216b;
        b bVar = cVar2.mConnectionCallbackInternal;
        if (bVar != null) {
            d dVar = (d) bVar;
            a aVar = dVar.f3259d;
            MediaBrowser mediaBrowser = dVar.f3257b;
            Bundle extras = mediaBrowser.getExtras();
            if (extras != null) {
                int i2 = 0;
                byte b8 = 0;
                extras.getInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 0);
                IBinder binder = BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER);
                if (binder != null) {
                    Bundle bundle = dVar.f3258c;
                    g gVar = new g(i2, (boolean) (b8 == true ? 1 : 0));
                    gVar.f3263b = new Messenger(binder);
                    gVar.f3264c = bundle;
                    dVar.f3260f = gVar;
                    Messenger messenger = new Messenger(aVar);
                    dVar.g = messenger;
                    aVar.getClass();
                    aVar.f3255b = new WeakReference(messenger);
                    try {
                        g gVar2 = dVar.f3260f;
                        Context context = dVar.f3256a;
                        Messenger messenger2 = dVar.g;
                        gVar2.getClass();
                        Bundle bundle2 = new Bundle();
                        bundle2.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
                        bundle2.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, (Bundle) gVar2.f3264c);
                        gVar2.q(6, bundle2, messenger2);
                    } catch (RemoteException unused) {
                        Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                    }
                }
                IBinder binder2 = BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_SESSION_BINDER);
                int i8 = android.support.v4.media.session.b.f3289a;
                if (binder2 == null) {
                    cVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = binder2.queryLocalInterface("android.support.v4.media.session.IMediaSession");
                    if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof android.support.v4.media.session.c)) {
                        android.support.v4.media.session.a aVar2 = new android.support.v4.media.session.a();
                        aVar2.f3288a = binder2;
                        cVar = aVar2;
                    } else {
                        cVar = (android.support.v4.media.session.c) iInterfaceQueryLocalInterface;
                    }
                }
                if (cVar != null) {
                    dVar.h = MediaSessionCompat$Token.a(mediaBrowser.getSessionToken(), cVar);
                }
            }
        }
        cVar2.onConnected();
    }

    @Override // android.media.browse.MediaBrowser.ConnectionCallback
    public final void onConnectionFailed() {
        c cVar = (c) this.f3267a.f3216b;
        b bVar = cVar.mConnectionCallbackInternal;
        cVar.onConnectionFailed();
    }

    @Override // android.media.browse.MediaBrowser.ConnectionCallback
    public final void onConnectionSuspended() {
        c cVar = (c) this.f3267a.f3216b;
        b bVar = cVar.mConnectionCallbackInternal;
        if (bVar != null) {
            d dVar = (d) bVar;
            dVar.f3260f = null;
            dVar.g = null;
            dVar.h = null;
            a aVar = dVar.f3259d;
            aVar.getClass();
            aVar.f3255b = new WeakReference(null);
        }
        cVar.onConnectionSuspended();
    }
}
