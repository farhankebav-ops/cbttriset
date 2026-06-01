package com.unity3d.services.ads.video;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.widget.VideoView;
import com.unity3d.services.core.device.MimeTypes;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.IEventSender;
import com.unity3d.services.core.webview.bridge.SharedInstances;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class VideoPlayerView extends VideoView {
    private AudioManager _audioManager;
    private final IEventSender _eventSender;
    private boolean _infoListenerEnabled;
    private MediaPlayer _mediaPlayer;
    private Timer _prepareTimer;
    private int _progressEventInterval;
    private Timer _videoTimer;
    private String _videoUrl;
    private Float _volume;

    public VideoPlayerView(Context context) {
        this(context, SharedInstances.INSTANCE.getWebViewEventSender());
    }

    private void startPrepareTimer(long j) {
        Timer timer = new Timer();
        this._prepareTimer = timer;
        timer.schedule(new TimerTask() { // from class: com.unity3d.services.ads.video.VideoPlayerView.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                boolean zIsPlaying;
                try {
                    zIsPlaying = VideoPlayerView.this.isPlaying();
                    if (zIsPlaying) {
                        return;
                    }
                    try {
                        VideoPlayerView.this._eventSender.sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.PREPARE_TIMEOUT, VideoPlayerView.this._videoUrl);
                        DeviceLog.error("Video player prepare timeout: " + VideoPlayerView.this._videoUrl);
                    } catch (IllegalStateException e) {
                        e = e;
                        DeviceLog.exception("Exception while preparing timer", e);
                        VideoPlayerView.this._eventSender.sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.ILLEGAL_STATE, VideoPlayerEvent.PREPARE_TIMEOUT, VideoPlayerView.this._videoUrl, Boolean.valueOf(zIsPlaying));
                    }
                } catch (IllegalStateException e4) {
                    e = e4;
                    zIsPlaying = false;
                }
            }
        }, j);
    }

    private void startVideoProgressTimer() {
        Timer timer = new Timer();
        this._videoTimer = timer;
        TimerTask timerTask = new TimerTask() { // from class: com.unity3d.services.ads.video.VideoPlayerView.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                boolean zIsPlaying;
                try {
                    zIsPlaying = VideoPlayerView.this.isPlaying();
                } catch (IllegalStateException e) {
                    e = e;
                    zIsPlaying = false;
                }
                try {
                    VideoPlayerView.this._eventSender.sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.PROGRESS, Integer.valueOf(VideoPlayerView.this.getCurrentPosition()));
                } catch (IllegalStateException e4) {
                    e = e4;
                    DeviceLog.exception("Exception while sending current position to webapp", e);
                    VideoPlayerView.this._eventSender.sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.ILLEGAL_STATE, VideoPlayerEvent.PROGRESS, VideoPlayerView.this._videoUrl, Boolean.valueOf(zIsPlaying));
                }
            }
        };
        int i2 = this._progressEventInterval;
        timer.scheduleAtFixedRate(timerTask, i2, i2);
    }

    public int getProgressEventInterval() {
        return this._progressEventInterval;
    }

    public int[] getVideoViewRectangle() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return new int[]{iArr[0], iArr[1], getMeasuredWidth(), getMeasuredHeight()};
    }

    public float getVolume() {
        return this._volume.floatValue();
    }

    @Override // android.widget.VideoView, android.widget.MediaController.MediaPlayerControl
    public void pause() {
        try {
            super.pause();
            if (Build.VERSION.SDK_INT < 26) {
                AudioManager audioManager = this._audioManager;
                if (audioManager != null) {
                    audioManager.abandonAudioFocus(null);
                }
            } else {
                setAudioFocusRequest(0);
            }
            stopVideoProgressTimer();
            this._eventSender.sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.PAUSE, this._videoUrl);
        } catch (Exception e) {
            this._eventSender.sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.PAUSE_ERROR, this._videoUrl);
            DeviceLog.exception("Error pausing video", e);
        }
    }

    public void play() {
        DeviceLog.entered();
        setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.unity3d.services.ads.video.VideoPlayerView.5
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null) {
                    VideoPlayerView.this._mediaPlayer = mediaPlayer;
                }
                VideoPlayerView.this._eventSender.sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.COMPLETED, VideoPlayerView.this._videoUrl);
                VideoPlayerView.this.stopVideoProgressTimer();
            }
        });
        try {
            start();
            stopVideoProgressTimer();
            startVideoProgressTimer();
            this._eventSender.sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.PLAY, this._videoUrl);
        } catch (IllegalStateException unused) {
            this._eventSender.sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.ILLEGAL_STATE, this._videoUrl, Boolean.FALSE);
        }
    }

    public boolean prepare(String str, final float f4, int i2) {
        DeviceLog.entered();
        this._videoUrl = str;
        setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.unity3d.services.ads.video.VideoPlayerView.3
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoPlayerView.this.stopPrepareTimer();
                if (mediaPlayer != null) {
                    VideoPlayerView.this._mediaPlayer = mediaPlayer;
                }
                VideoPlayerView.this.setVolume(Float.valueOf(f4));
                VideoPlayerView.this._eventSender.sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.PREPARED, VideoPlayerView.this._videoUrl, Integer.valueOf(mediaPlayer.getDuration()), Integer.valueOf(mediaPlayer.getVideoWidth()), Integer.valueOf(mediaPlayer.getVideoHeight()));
            }
        });
        setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.unity3d.services.ads.video.VideoPlayerView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i8, int i9) {
                VideoPlayerView.this.stopPrepareTimer();
                if (mediaPlayer != null) {
                    VideoPlayerView.this._mediaPlayer = mediaPlayer;
                }
                VideoPlayerView.this._eventSender.sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.GENERIC_ERROR, VideoPlayerView.this._videoUrl, Integer.valueOf(i8), Integer.valueOf(i9));
                VideoPlayerView.this.stopVideoProgressTimer();
                return true;
            }
        });
        setInfoListenerEnabled(this._infoListenerEnabled);
        if (i2 > 0) {
            startPrepareTimer(i2);
        }
        try {
            if (Build.VERSION.SDK_INT < 26) {
                AudioManager audioManager = (AudioManager) getContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
                this._audioManager = audioManager;
                if (audioManager != null) {
                    audioManager.requestAudioFocus(null, 3, 2);
                }
            } else {
                setAudioFocusRequest(2);
            }
            setVideoPath(this._videoUrl);
            return true;
        } catch (Exception e) {
            this._eventSender.sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.PREPARE_ERROR, this._videoUrl);
            DeviceLog.exception("Error preparing video: " + this._videoUrl, e);
            return false;
        }
    }

    @Override // android.widget.VideoView, android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i2) {
        try {
            super.seekTo(i2);
            this._eventSender.sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.SEEKTO, this._videoUrl);
        } catch (Exception e) {
            this._eventSender.sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.SEEKTO_ERROR, this._videoUrl);
            DeviceLog.exception("Error seeking video", e);
        }
    }

    public void setInfoListenerEnabled(boolean z2) {
        this._infoListenerEnabled = z2;
        if (z2) {
            setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.unity3d.services.ads.video.VideoPlayerView.6
                @Override // android.media.MediaPlayer.OnInfoListener
                public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i8) {
                    VideoPlayerView.this._eventSender.sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.INFO, VideoPlayerView.this._videoUrl, Integer.valueOf(i2), Integer.valueOf(i8));
                    return true;
                }
            });
        } else {
            setOnInfoListener(null);
        }
    }

    public void setProgressEventInterval(int i2) {
        this._progressEventInterval = i2;
        if (this._videoTimer != null) {
            stopVideoProgressTimer();
            startVideoProgressTimer();
        }
    }

    public void setVolume(Float f4) {
        try {
            this._mediaPlayer.setVolume(f4.floatValue(), f4.floatValue());
            this._volume = f4;
        } catch (Exception e) {
            DeviceLog.exception("MediaPlayer generic error", e);
        }
    }

    public void stop() {
        stopPlayback();
        stopVideoProgressTimer();
        if (Build.VERSION.SDK_INT < 26) {
            AudioManager audioManager = this._audioManager;
            if (audioManager != null) {
                audioManager.abandonAudioFocus(null);
            }
        } else {
            setAudioFocusRequest(0);
        }
        this._eventSender.sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.STOP, this._videoUrl);
    }

    public void stopPrepareTimer() {
        Timer timer = this._prepareTimer;
        if (timer != null) {
            timer.cancel();
            this._prepareTimer.purge();
            this._prepareTimer = null;
        }
    }

    public void stopVideoProgressTimer() {
        Timer timer = this._videoTimer;
        if (timer != null) {
            timer.cancel();
            this._videoTimer.purge();
            this._videoTimer = null;
        }
    }

    public VideoPlayerView(Context context, IEventSender iEventSender) {
        super(context);
        this._progressEventInterval = 500;
        this._mediaPlayer = null;
        this._volume = null;
        this._infoListenerEnabled = true;
        this._audioManager = null;
        this._eventSender = iEventSender;
    }
}
