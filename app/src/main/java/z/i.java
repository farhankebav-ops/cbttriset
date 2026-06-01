package z;

import android.media.MediaPlayer;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f17876a;

    public i(j jVar) {
        this.f17876a = new WeakReference(jVar);
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
        d dVar;
        try {
            j jVar = (j) this.f17876a.get();
            if (jVar == null || (dVar = jVar.f17879c) == null) {
                return;
            }
            dVar.IlO(jVar, i2);
        } catch (Throwable unused) {
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        e eVar;
        try {
            j jVar = (j) this.f17876a.get();
            if (jVar == null || (eVar = jVar.f17878b) == null) {
                return;
            }
            eVar.IlO(jVar);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018  */
    @Override // android.media.MediaPlayer.OnErrorListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onError(android.media.MediaPlayer r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 0
            java.lang.ref.WeakReference r0 = r3.f17876a     // Catch: java.lang.Throwable -> L1c
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L1c
            z.j r0 = (z.j) r0     // Catch: java.lang.Throwable -> L1c
            if (r0 == 0) goto L1c
            r1 = 1
            z.c r2 = r0.f17881f     // Catch: java.lang.Throwable -> L18
            if (r2 == 0) goto L18
            boolean r5 = r2.IlO(r0, r5, r6)     // Catch: java.lang.Throwable -> L18
            if (r5 == 0) goto L18
            r5 = r1
            goto L19
        L18:
            r5 = r4
        L19:
            if (r5 == 0) goto L1c
            return r1
        L1c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: z.i.onError(android.media.MediaPlayer, int, int):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018  */
    @Override // android.media.MediaPlayer.OnInfoListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onInfo(android.media.MediaPlayer r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 0
            java.lang.ref.WeakReference r0 = r3.f17876a     // Catch: java.lang.Throwable -> L1c
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L1c
            z.j r0 = (z.j) r0     // Catch: java.lang.Throwable -> L1c
            if (r0 == 0) goto L1c
            r1 = 1
            z.f r2 = r0.g     // Catch: java.lang.Throwable -> L18
            if (r2 == 0) goto L18
            boolean r5 = r2.MY(r0, r5, r6)     // Catch: java.lang.Throwable -> L18
            if (r5 == 0) goto L18
            r5 = r1
            goto L19
        L18:
            r5 = r4
        L19:
            if (r5 == 0) goto L1c
            return r1
        L1c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: z.i.onInfo(android.media.MediaPlayer, int, int):boolean");
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        b bVar;
        try {
            j jVar = (j) this.f17876a.get();
            if (jVar == null || (bVar = jVar.f17877a) == null) {
                return;
            }
            bVar.MY(jVar);
        } catch (Throwable unused) {
        }
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public final void onSeekComplete(MediaPlayer mediaPlayer) {
        g gVar;
        try {
            j jVar = (j) this.f17876a.get();
            if (jVar == null || (gVar = jVar.f17880d) == null) {
                return;
            }
            gVar.EO(jVar);
        } catch (Throwable unused) {
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i8) {
        a aVar;
        try {
            j jVar = (j) this.f17876a.get();
            if (jVar == null || (aVar = jVar.e) == null) {
                return;
            }
            aVar.IlO(jVar, i2, i8, 1, 1);
        } catch (Throwable unused) {
        }
    }
}
