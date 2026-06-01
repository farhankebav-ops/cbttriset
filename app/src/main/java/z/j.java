package z;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Surface;
import com.ironsource.C2300e4;
import java.io.IOException;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f17877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f17878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f17879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f17880d;
    public a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f17881f;
    public f g;
    public boolean h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MediaPlayer f17882i;
    public final i j;
    public a0.a k;
    public Surface l;
    public final Object m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile boolean f17883n;

    public j() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.m = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.f17882i = mediaPlayer;
        }
        if (Build.VERSION.SDK_INT < 28) {
            try {
                Class<?> cls = Class.forName("android.media.MediaTimeProvider");
                Class<?> cls2 = Class.forName("android.media.SubtitleController");
                Class<?> cls3 = Class.forName("android.media.SubtitleController$Anchor");
                Object objNewInstance = cls2.getConstructor(Context.class, cls, Class.forName("android.media.SubtitleController$Listener")).newInstance(r.a.f13608a, null, null);
                Field declaredField = cls2.getDeclaredField("mHandler");
                declaredField.setAccessible(true);
                try {
                    declaredField.set(objNewInstance, new Handler());
                    declaredField.setAccessible(false);
                    mediaPlayer.getClass().getMethod("setSubtitleAnchor", cls2, cls3).invoke(mediaPlayer, objNewInstance, null);
                } catch (Throwable unused) {
                    declaredField.setAccessible(false);
                }
            } catch (Throwable unused2) {
            }
        }
        try {
            this.f17882i.setAudioStreamType(3);
        } catch (Throwable unused3) {
        }
        this.j = new i(this);
        d();
    }

    public final void a(long j, int i2) {
        int i8 = Build.VERSION.SDK_INT;
        MediaPlayer mediaPlayer = this.f17882i;
        if (i8 < 26) {
            mediaPlayer.seekTo((int) j);
            return;
        }
        if (i2 == 0) {
            mediaPlayer.seekTo((int) j, 0);
            return;
        }
        if (i2 == 1) {
            mediaPlayer.seekTo((int) j, 1);
            return;
        }
        if (i2 == 2) {
            mediaPlayer.seekTo((int) j, 2);
        } else if (i2 != 3) {
            mediaPlayer.seekTo((int) j);
        } else {
            mediaPlayer.seekTo((int) j, 3);
        }
    }

    public final void b(String str) throws IOException {
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        boolean zIsEmpty = TextUtils.isEmpty(scheme);
        MediaPlayer mediaPlayer = this.f17882i;
        if (zIsEmpty || !scheme.equalsIgnoreCase(C2300e4.h.f8363b)) {
            mediaPlayer.setDataSource(str);
        } else {
            mediaPlayer.setDataSource(uri.getPath());
        }
    }

    public final void c() {
        this.f17877a = null;
        this.f17879c = null;
        this.f17878b = null;
        this.f17880d = null;
        this.e = null;
        this.f17881f = null;
        this.g = null;
    }

    public final void d() {
        MediaPlayer mediaPlayer = this.f17882i;
        i iVar = this.j;
        mediaPlayer.setOnPreparedListener(iVar);
        mediaPlayer.setOnBufferingUpdateListener(iVar);
        mediaPlayer.setOnCompletionListener(iVar);
        mediaPlayer.setOnSeekCompleteListener(iVar);
        mediaPlayer.setOnVideoSizeChangedListener(iVar);
        mediaPlayer.setOnErrorListener(iVar);
        mediaPlayer.setOnInfoListener(iVar);
    }

    public final void finalize() throws Throwable {
        super.finalize();
        try {
            Surface surface = this.l;
            if (surface != null) {
                surface.release();
                this.l = null;
            }
        } catch (Throwable unused) {
        }
    }
}
