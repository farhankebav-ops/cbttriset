package android.support.v4.media;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import androidx.media.MediaBrowserProtocol;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f3254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference f3255b;

    public a(d dVar) {
        this.f3254a = new WeakReference(dVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        WeakReference weakReference = this.f3255b;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        WeakReference weakReference2 = this.f3254a;
        if (weakReference2.get() == null) {
            return;
        }
        Bundle data = message.getData();
        android.support.v4.media.session.g.a(data);
        d dVar = (d) weakReference2.get();
        Messenger messenger = (Messenger) this.f3255b.get();
        try {
            int i2 = message.what;
            if (i2 == 1) {
                android.support.v4.media.session.g.a(data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS));
                data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID);
                dVar.getClass();
                return;
            }
            if (i2 == 2) {
                dVar.getClass();
                return;
            }
            if (i2 != 3) {
                Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1);
                return;
            }
            android.support.v4.media.session.g.a(data.getBundle(MediaBrowserProtocol.DATA_OPTIONS));
            android.support.v4.media.session.g.a(data.getBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS));
            String string = data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID);
            data.getParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST);
            if (dVar.g != messenger) {
                return;
            }
            if (dVar.e.get(string) != null) {
                throw new ClassCastException();
            }
            if (h.f3265b) {
                Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + string);
            }
        } catch (BadParcelableException unused) {
            Log.e("MediaBrowserCompat", "Could not unparcel the data.");
            if (message.what == 1) {
                dVar.getClass();
            }
        }
    }
}
