package sg.bigo.ads.api;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public interface VideoController {

    public interface VideoLifeCallback {
        void onMuteChange(boolean z2);

        void onVideoEnd();

        void onVideoPause();

        void onVideoPlay();

        void onVideoStart();
    }

    public interface a {
        void i(boolean z2);
    }

    public interface b extends VideoLifeCallback {
        void a();

        void b();
    }

    public interface c {
        void a();
    }

    public interface d {
        void a(int i2, int i8);
    }

    a getBackupLoadCallback();

    c getLoadHTMLCallback();

    @Nullable
    d getProgressChangeListener();

    @Nullable
    VideoLifeCallback getVideoLifeCallback();

    boolean isMuted();

    boolean isPaused();

    boolean isPlaying();

    void mute(boolean z2);

    void notifyBackupResourceReady();

    void notifyPlayViewRegister();

    void notifyResourceReady();

    void pause();

    void play();

    void setBackupLoadCallback(a aVar);

    void setLoadHTMLCallback(c cVar);

    void setProgressChangeListener(d dVar);

    void setVideoLifeCallback(VideoLifeCallback videoLifeCallback);
}
