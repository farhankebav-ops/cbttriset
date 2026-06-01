package com.instagram.common.viewpoint.core;

import android.net.Uri;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lN, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public interface InterfaceC1943lN extends AnonymousClass20 {
    void A3z(int i2) throws IOException;

    boolean A40(int i2, boolean z2) throws IOException;

    long A8G();

    long A8a();

    long A8f();

    @MetaExoPlayerCustomization("Added API for MP4 extractor")
    Uri A9H();

    int AG8(byte[] bArr, int i2, int i8) throws IOException;

    void AG9(byte[] bArr, int i2, int i8) throws IOException;

    boolean AGA(byte[] bArr, int i2, int i8, boolean z2) throws IOException;

    boolean AGh(byte[] bArr, int i2, int i8, boolean z2) throws IOException;

    void AI1();

    int AJG(int i2) throws IOException;

    void AJJ(int i2) throws IOException;

    @Override // com.instagram.common.viewpoint.core.AnonymousClass20
    int read(byte[] bArr, int i2, int i8) throws IOException;

    void readFully(byte[] bArr, int i2, int i8) throws IOException;
}
