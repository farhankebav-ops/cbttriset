package com.instagram.common.viewpoint.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.instagram.common.viewpoint.core.InterfaceC0719Ej;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Eg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public interface InterfaceC0716Eg<T extends InterfaceC0719Ej> {
    void ADx(T t3, long j, long j3, boolean z2);

    void ADz(T t3, long j, long j3);

    C0717Eh AE0(T t3, long j, long j3, IOException iOException, int i2);

    @MetaExoPlayerCustomization(type = {"MERGED"}, value = "For Media3 Migration Backward Compatibility")
    void AE3(T t3, long j, long j3, int i2);
}
