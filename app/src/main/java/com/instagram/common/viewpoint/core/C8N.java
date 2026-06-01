package com.instagram.common.viewpoint.core;

import android.media.AudioDeviceInfo;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8N, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public interface C8N {
    void A51(C2154or c2154or, int i2, int[] iArr) throws C8G;

    void A5r();

    void A6E();

    void A6L();

    long A7X(boolean z2);

    C2138ob A8e();

    boolean A9W(ByteBuffer byteBuffer, long j, int i2) throws C8M, C8H;

    void A9Z();

    boolean A9g();

    boolean AAG();

    void AGG();

    void AGI() throws C8M;

    void AIW(C2160oy c2160oy);

    void AIX(int i2);

    void AIY(C1P c1p);

    @MetaExoPlayerCustomization(type = {"NEW_METHOD"}, value = "Enable Retry Audio Track")
    void AIg(boolean z2);

    void AIl(C8J c8j);

    void AIt(C2138ob c2138ob);

    void AIw(C05567m c05567m);

    void AIy(AudioDeviceInfo audioDeviceInfo);

    void AJ4(boolean z2);

    boolean AJc(C2154or c2154or);

    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "Old API that can be removed when we move to MediaCodecRenderer2")
    boolean AJe(int i2, int i8);

    void flush();

    void pause();

    void setVolume(float f4);
}
