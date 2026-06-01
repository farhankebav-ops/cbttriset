package com.instagram.common.viewpoint.core;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.util.Pair;
import android.view.Surface;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2021mf implements AO {
    public static String[] A03 = {"TBh0kDiSO0F5FU8B8W6", "Wu96YBEbp5", "GXHkztSg0E", "SVf9uR0CS1ZMhrygTfVGTHtgONFy9fbr", "ToJtFxraFZDV0Nhg1oJyUAeavZbRFz0H", "e4ZNDN8Q6QOy3wABZV9fSILWPV6YlB7H", "vAs40s3kLNqKh27SimoH5s3SjKwld5mw", "MzWq8aWYtfnIiGPN6xqzLuzHDFClSOvg"};
    public ByteBuffer[] A00;
    public ByteBuffer[] A01;
    public final MediaCodec A02;

    @MetaExoPlayerCustomization("This constructor is private in Exo r2.18.6 and builder pattern should be used.This can be fixed after MediaCodecPool.Java dependency is removed.Because the Factory calls start before allocating the adapter it can call getInputBuffers here. Butdo not do it while the constructor is public because start hasn't been called yet.See S358180")
    public C2021mf(MediaCodec mediaCodec) {
        this.A02 = mediaCodec;
    }

    public final /* synthetic */ void A00(AN an, MediaCodec mediaCodec, long j, long j3) {
        an.ADL(this, j, j3);
    }

    @Override // com.instagram.common.viewpoint.core.AO
    @MetaExoPlayerCustomization("Override is customization due to dependency on MediaCodec[Audio/Video]Renderer")
    public final void A50(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i2, Object obj) {
        this.A02.configure(mediaFormat, surface, mediaCrypto, i2);
    }

    @Override // com.instagram.common.viewpoint.core.AO
    public final int A5k() {
        return this.A02.dequeueInputBuffer(0L);
    }

    @Override // com.instagram.common.viewpoint.core.AO
    public final int A5m(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            iDequeueOutputBuffer = this.A02.dequeueOutputBuffer(bufferInfo, 0L);
            if (iDequeueOutputBuffer == -3 && AbstractC04664a.A02 < 21) {
                this.A01 = this.A02.getOutputBuffers();
            }
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
    }

    @Override // com.instagram.common.viewpoint.core.AO
    public final ByteBuffer A8B(int i2) {
        if (AbstractC04664a.A02 >= 21) {
            return this.A02.getInputBuffer(i2);
        }
        ByteBuffer[] byteBufferArr = this.A00;
        if (A03[0].length() == 9) {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[2] = "7Nv94jZvV7";
        strArr[1] = "iAeXpyFDwx";
        return ((ByteBuffer[]) AbstractC04664a.A0f(byteBufferArr))[i2];
    }

    @Override // com.instagram.common.viewpoint.core.AO
    public final ByteBuffer A8W(int i2) {
        if (AbstractC04664a.A02 >= 21) {
            return this.A02.getOutputBuffer(i2);
        }
        return ((ByteBuffer[]) AbstractC04664a.A0f(this.A01))[i2];
    }

    @Override // com.instagram.common.viewpoint.core.AO
    public final MediaFormat A8X() {
        return this.A02.getOutputFormat();
    }

    @Override // com.instagram.common.viewpoint.core.AO
    @MetaExoPlayerCustomization("Added in D39791066")
    public final Pair<Long, Integer> A8b() {
        return new Pair<>(0L, 0);
    }

    @Override // com.instagram.common.viewpoint.core.AO
    @MetaExoPlayerCustomization("Added in D39791066")
    public final int A9C() {
        return 0;
    }

    @Override // com.instagram.common.viewpoint.core.AO
    public final void AGY(int i2, int i8, int i9, long j, int i10) {
        this.A02.queueInputBuffer(i2, i8, i9, j, i10);
    }

    @Override // com.instagram.common.viewpoint.core.AO
    public final void AGa(int i2, int i8, C5N c5n, long j, int i9) {
        this.A02.queueSecureInputBuffer(i2, i8, c5n.A00(), j, i9);
    }

    @Override // com.instagram.common.viewpoint.core.AO
    public final void AGr() {
        this.A00 = null;
        this.A01 = null;
        this.A02.release();
    }

    @Override // com.instagram.common.viewpoint.core.AO
    public final void AGx(int i2, long j) {
        this.A02.releaseOutputBuffer(i2, j);
    }

    @Override // com.instagram.common.viewpoint.core.AO
    public final void AGy(int i2, boolean z2) {
        this.A02.releaseOutputBuffer(i2, z2);
    }

    @Override // com.instagram.common.viewpoint.core.AO
    public final void AIq(final AN an, Handler handler) {
        this.A02.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: com.facebook.ads.redexgen.X.Az
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j, long j3) {
                this.A01.A00(an, mediaCodec, j, j3);
            }
        }, handler);
    }

    @Override // com.instagram.common.viewpoint.core.AO
    public final void AIr(Surface surface) {
        this.A02.setOutputSurface(surface);
    }

    @Override // com.instagram.common.viewpoint.core.AO
    public final void AJ8(int i2) {
        this.A02.setVideoScalingMode(i2);
    }

    @Override // com.instagram.common.viewpoint.core.AO
    public final void flush() {
        this.A02.flush();
    }

    @Override // com.instagram.common.viewpoint.core.AO
    @MetaExoPlayerCustomization
    public final void reset() {
        this.A02.reset();
    }

    @Override // com.instagram.common.viewpoint.core.AO
    @MetaExoPlayerCustomization("Could be revisited after upgrading MediaCodecRenderer")
    public final void start() {
        this.A02.start();
    }

    @Override // com.instagram.common.viewpoint.core.AO
    @MetaExoPlayerCustomization
    public final void stop() {
        this.A02.stop();
    }
}
