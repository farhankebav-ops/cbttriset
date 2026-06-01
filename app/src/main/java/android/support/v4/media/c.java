package android.support.v4.media;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    b mConnectionCallbackInternal;
    final Object mConnectionCallbackObj = new i(new a4.a(this, 3));

    public abstract void onConnected();

    public abstract void onConnectionFailed();

    public abstract void onConnectionSuspended();

    public void setInternalConnectionCallback(b bVar) {
        this.mConnectionCallbackInternal = bVar;
    }
}
