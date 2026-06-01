package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Messenger;
import android.support.v4.media.session.MediaSessionCompat$Token;
import androidx.collection.ArrayMap;
import androidx.media.MediaBrowserProtocol;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaBrowser f3257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f3258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f3259d = new a(this);
    public final ArrayMap e = new ArrayMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g f3260f;
    public Messenger g;
    public MediaSessionCompat$Token h;

    public d(Context context, ComponentName componentName, c cVar) {
        this.f3256a = context;
        Bundle bundle = new Bundle();
        this.f3258c = bundle;
        bundle.putInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 1);
        cVar.setInternalConnectionCallback(this);
        this.f3257b = new MediaBrowser(context, componentName, (MediaBrowser.ConnectionCallback) cVar.mConnectionCallbackObj, bundle);
    }
}
