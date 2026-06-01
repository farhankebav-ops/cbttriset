package com.instagram.common.viewpoint.core;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.util.Pair;
import android.view.Surface;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: assets/audience_network.dex */
public interface AO {
    @MetaExoPlayerCustomization("No longer in upstream exo")
    void A50(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i2, Object obj);

    int A5k();

    int A5m(MediaCodec.BufferInfo bufferInfo);

    ByteBuffer A8B(int i2);

    ByteBuffer A8W(int i2);

    MediaFormat A8X();

    @MetaExoPlayerCustomization("Added in D39791066")
    Pair<Long, Integer> A8b();

    @MetaExoPlayerCustomization("Added in D39791066")
    int A9C();

    void AGY(int i2, int i8, int i9, long j, int i10);

    void AGa(int i2, int i8, C5N c5n, long j, int i9);

    void AGr();

    void AGx(int i2, long j);

    void AGy(int i2, boolean z2);

    void AIq(AN an, Handler handler);

    void AIr(Surface surface);

    void AJ8(int i2);

    void flush();

    @MetaExoPlayerCustomization("No longer in upstream exo")
    @Deprecated
    void reset();

    @MetaExoPlayerCustomization("No longer in upstream exo")
    void start();

    @MetaExoPlayerCustomization("No longer in upstream exo")
    @Deprecated
    void stop();
}
