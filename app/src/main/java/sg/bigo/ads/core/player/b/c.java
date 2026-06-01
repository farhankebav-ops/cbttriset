package sg.bigo.ads.core.player.b;

import android.media.MediaPlayer;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.api.a.i;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes6.dex */
public final class c implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener {
    static final AtomicBoolean h = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    MediaPlayer f17326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f17327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    a f17328c;
    boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f17330f;
    private Surface j;
    private long k;
    private boolean m;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f17329d = 0;
    final Runnable g = new Runnable() { // from class: sg.bigo.ads.core.player.b.c.1
        @Override // java.lang.Runnable
        public final void run() {
            if (c.this.f17328c != null) {
                c.this.f17328c.i();
            }
            if (c.this.f17329d == 3 || c.this.f17329d == 4 || c.this.f17329d == 5) {
                return;
            }
            sg.bigo.ads.common.n.d.a(2, c.this.g, 500L);
        }
    };
    private boolean l = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f17331i = 0;

    public interface a {
        void a(int i2, String str, int i8);

        void a(MediaPlayer mediaPlayer, int i2);

        boolean a(int i2);

        boolean a(int i2, int i8);

        void e_();

        void f();

        void g();

        void h();

        void i();

        void j();

        void k();
    }

    public c() {
        this.m = false;
        this.m = i.f15457a.n().a(3);
        g();
    }

    private boolean h() {
        return !this.m || this.f17331i >= 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        try {
            sg.bigo.ads.common.t.a.a(0, 3, "MediaPlayerWrapper", "prepareAsync");
            this.k = SystemClock.elapsedRealtime();
            this.f17326a.prepareAsync();
            return true;
        } catch (Exception e) {
            a aVar = this.f17328c;
            if (aVar != null) {
                aVar.a(10, Log.getStackTraceString(e), this.f17331i);
            }
            b(10);
            sg.bigo.ads.common.t.a.a(0, "MediaPlayerWrapper", "Player prepareAsync failed");
            return false;
        }
    }

    public final int c() {
        try {
            if (this.e) {
                return this.f17326a.getCurrentPosition();
            }
            sg.bigo.ads.common.t.a.a(0, "MediaPlayerWrapper", "getCurrentPosition failed，not initialize or release already");
            return 0;
        } catch (IllegalStateException e) {
            a aVar = this.f17328c;
            if (aVar != null) {
                aVar.a(5, Log.getStackTraceString(e), this.f17331i);
            }
            sg.bigo.ads.common.t.a.a(0, "MediaPlayerWrapper", "getCurrentPosition IllegalStateException");
            return 0;
        }
    }

    public final boolean d() {
        try {
            this.f17326a.stop();
            sg.bigo.ads.common.n.d.a(this.g);
            this.f17329d = 4;
            sg.bigo.ads.common.t.a.a(0, 3, "MediaPlayerWrapper", "stop play");
            a aVar = this.f17328c;
            if (aVar != null) {
                aVar.h();
            }
            return true;
        } catch (IllegalStateException e) {
            a aVar2 = this.f17328c;
            if (aVar2 != null) {
                aVar2.a(6, Log.getStackTraceString(e), this.f17331i);
            }
            sg.bigo.ads.common.t.a.a(1, "MediaPlayerWrapper", "Failed to stop video: " + e.getMessage());
            return false;
        }
    }

    public final void e() {
        try {
            this.f17326a.release();
            h.set(true);
            sg.bigo.ads.common.n.d.a(this.g);
        } catch (IllegalStateException e) {
            a aVar = this.f17328c;
            if (aVar != null) {
                aVar.a(7, Log.getStackTraceString(e), this.f17331i);
            }
            sg.bigo.ads.common.t.a.a(0, "MediaPlayerWrapper", "player release IllegalStateException");
        }
        this.f17329d = 0;
        this.e = false;
        sg.bigo.ads.common.t.a.a(0, 3, "MediaPlayerWrapper", "player release called");
    }

    public final int f() {
        try {
            if (this.e) {
                return this.f17326a.getDuration();
            }
            sg.bigo.ads.common.t.a.a(0, "MediaPlayerWrapper", "getDuration failed，not initialize or release already");
            return 0;
        } catch (IllegalStateException e) {
            a aVar = this.f17328c;
            if (aVar != null) {
                aVar.a(8, Log.getStackTraceString(e), this.f17331i);
            }
            sg.bigo.ads.common.t.a.a(0, "MediaPlayerWrapper", "getDuration IllegalStateException");
            return 0;
        }
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
        sg.bigo.ads.common.t.a.a(0, 3, "MediaPlayerWrapper", "onBufferingUpdate percent = ".concat(String.valueOf(i2)));
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        sg.bigo.ads.common.n.d.a(this.g);
        a aVar = this.f17328c;
        if (aVar != null) {
            this.f17329d = 5;
            aVar.j();
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i2, int i8) {
        a aVar;
        if (h() && (aVar = this.f17328c) != null) {
            return aVar.a(i2, i8);
        }
        sg.bigo.ads.common.n.d.a(this.g);
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i2, int i8) {
        a aVar = this.f17328c;
        if (aVar != null) {
            return aVar.a(i2);
        }
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        if (!this.f17330f) {
            sg.bigo.ads.common.t.a.b("MediaPlayerWrapper", "Surface is not available, do prepare cancel");
            return;
        }
        this.f17329d = 1;
        this.e = true;
        sg.bigo.ads.common.t.a.a(0, 3, "MediaPlayerWrapper", "onPrepared called cost = " + (SystemClock.elapsedRealtime() - this.k));
        a aVar = this.f17328c;
        if (aVar != null) {
            aVar.a(mediaPlayer, this.f17331i);
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i8) {
        a aVar = this.f17328c;
        if (aVar != null) {
            aVar.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f17326a = new MediaPlayer();
        h.set(false);
        this.f17326a.setOnCompletionListener(this);
        this.f17326a.setOnErrorListener(this);
        this.f17326a.setOnInfoListener(this);
        this.f17326a.setOnPreparedListener(this);
        this.f17326a.setOnVideoSizeChangedListener(this);
        this.f17326a.setOnBufferingUpdateListener(this);
    }

    public final void a(Surface surface) {
        try {
            this.j = surface;
            this.f17326a.setSurface(surface);
            this.f17330f = true;
        } catch (Exception e) {
            a aVar = this.f17328c;
            if (aVar != null) {
                aVar.a(12, Log.getStackTraceString(e), this.f17331i);
            }
            b(12);
            sg.bigo.ads.common.t.a.a(0, "MediaPlayerWrapper", "setSurface IllegalStateException");
        }
    }

    public final void b(final int i2) {
        if (!this.m) {
            sg.bigo.ads.common.t.a.a(0, 3, "MediaPlayerWrapper", "createMediaPlayerWhenException switch is off");
            return;
        }
        int i8 = this.f17331i;
        if (i8 >= 3) {
            a aVar = this.f17328c;
            if (aVar != null) {
                aVar.a(i2, "retry times has reached limit", i8);
            }
            sg.bigo.ads.common.t.a.a(0, 3, "MediaPlayerWrapper", "createMediaPlayer times reach the limit(3 times), stop creating");
            return;
        }
        this.f17331i = i8 + 1;
        sg.bigo.ads.common.t.a.a(0, 3, "MediaPlayerWrapper", "start to create mediaPlayer, retry time: " + this.f17331i);
        e();
        sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.core.player.b.c.3
            @Override // java.lang.Runnable
            public final void run() {
                c.this.g();
                int i9 = i2;
                if (i9 != 9 && i9 != 10) {
                    if (i9 == 12) {
                        c cVar = c.this;
                        cVar.a(cVar.j);
                        return;
                    } else if (i9 != 15) {
                        return;
                    }
                }
                c cVar2 = c.this;
                cVar2.a(cVar2.j);
                c cVar3 = c.this;
                cVar3.a(cVar3.f17327b);
            }
        });
    }

    public final void a(final String str) {
        if (q.a((CharSequence) str)) {
            sg.bigo.ads.common.t.a.a(0, "MediaPlayerWrapper", "invalidate file path, set data source failed");
        } else {
            this.f17327b = str;
            sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.core.player.b.c.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (c.this.b(str)) {
                        c.this.i();
                    }
                }
            });
        }
    }

    public final boolean b() {
        try {
            this.f17326a.pause();
            sg.bigo.ads.common.n.d.a(this.g);
            this.f17329d = 3;
            sg.bigo.ads.common.t.a.a(0, 3, "MediaPlayerWrapper", "pauseAd play");
            a aVar = this.f17328c;
            if (aVar != null) {
                aVar.g();
            }
            return true;
        } catch (IllegalStateException e) {
            a aVar2 = this.f17328c;
            if (aVar2 != null) {
                aVar2.a(4, Log.getStackTraceString(e), this.f17331i);
            }
            sg.bigo.ads.common.t.a.a(1, "MediaPlayerWrapper", "Failed to pause video: " + e.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(@NonNull String str) {
        try {
            if (!this.f17330f) {
                sg.bigo.ads.common.t.a.b("MediaPlayerWrapper", "Surface is not available, setDataSource cancel");
                return false;
            }
            sg.bigo.ads.common.t.a.a(0, 3, "MediaPlayerWrapper", "player setDataSource, path = ".concat(String.valueOf(str)));
            this.f17326a.reset();
            this.f17326a.setDataSource(str);
            return true;
        } catch (Exception e) {
            sg.bigo.ads.common.t.a.a(0, "MediaPlayerWrapper", "Player setDataSource failed");
            if (this.f17328c != null) {
                if (h()) {
                    sg.bigo.ads.common.t.a.b("MediaPlayerWrapper", "setDataSource called onError");
                    this.f17328c.a(1, -1004);
                }
                this.f17328c.a(9, Log.getStackTraceString(e), this.f17331i);
            }
            b(9);
            return false;
        }
    }

    public final boolean a() {
        try {
            if (this.e && this.f17330f) {
                if (this.f17326a.isPlaying()) {
                    sg.bigo.ads.common.t.a.a(0, 3, "MediaPlayerWrapper", "startAd but is playing, return.");
                    return true;
                }
                this.f17326a.start();
                if (!this.l) {
                    this.l = true;
                    a aVar = this.f17328c;
                    if (aVar != null) {
                        aVar.e_();
                    }
                }
                this.f17329d = 2;
                sg.bigo.ads.common.t.a.a(0, 3, "MediaPlayerWrapper", "startAd play called ");
                sg.bigo.ads.common.n.d.a(this.g);
                sg.bigo.ads.common.n.d.a(2, this.g);
                a aVar2 = this.f17328c;
                if (aVar2 != null) {
                    aVar2.f();
                }
                return true;
            }
            sg.bigo.ads.common.t.a.b("MediaPlayerWrapper", "Surface is not available or player unprepared, do start play cancel");
            return false;
        } catch (IllegalStateException e) {
            a aVar3 = this.f17328c;
            if (aVar3 != null) {
                aVar3.a(3, Log.getStackTraceString(e), this.f17331i);
            }
            sg.bigo.ads.common.t.a.a(1, "MediaPlayerWrapper", "Failed to play video: " + e.getMessage());
            return false;
        }
    }

    public final boolean a(int i2) {
        try {
            sg.bigo.ads.common.t.a.a(0, 3, "MediaPlayerWrapper", "seekTo : ".concat(String.valueOf(i2)));
            this.f17326a.seekTo(i2);
            return true;
        } catch (IllegalStateException e) {
            a aVar = this.f17328c;
            if (aVar != null) {
                aVar.a(1, Log.getStackTraceString(e), this.f17331i);
            }
            sg.bigo.ads.common.t.a.a(1, "MediaPlayerWrapper", "The video failed to seek:" + e.getMessage());
            return false;
        }
    }

    public final boolean a(boolean z2) {
        try {
            if (z2) {
                this.f17326a.setVolume(0.0f, 0.0f);
                return z2;
            }
            this.f17326a.setVolume(1.0f, 1.0f);
            return z2;
        } catch (IllegalStateException e) {
            a aVar = this.f17328c;
            if (aVar != null) {
                aVar.a(14, Log.getStackTraceString(e), this.f17331i);
            }
            sg.bigo.ads.common.t.a.a(1, "MediaPlayerWrapper", "The video failed to set volume: " + e.getMessage());
            return z2;
        }
    }
}
