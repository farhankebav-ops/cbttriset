package com.instagram.common.viewpoint.core;

import android.net.Uri;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lO, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1944lO implements H1 {
    public final byte[] A00 = new byte[4096];

    @Override // com.instagram.common.viewpoint.core.H1
    public final /* synthetic */ int AI5(AnonymousClass20 anonymousClass20, int i2, boolean z2) {
        return AbstractC0786Gy.A00(this, anonymousClass20, i2, z2);
    }

    @Override // com.instagram.common.viewpoint.core.H1
    public final /* synthetic */ void AI7(C4J c4j, int i2) {
        AbstractC0786Gy.A01(this, c4j, i2);
    }

    @Override // com.instagram.common.viewpoint.core.H1
    public final void A6W(C2154or c2154or) {
    }

    @Override // com.instagram.common.viewpoint.core.H1
    public final int AI6(AnonymousClass20 anonymousClass20, int i2, boolean z2, int i8) throws IOException {
        int bytesSkipped = anonymousClass20.read(this.A00, 0, Math.min(this.A00.length, i2));
        if (bytesSkipped == -1) {
            if (z2) {
                return -1;
            }
            throw new EOFException();
        }
        return bytesSkipped;
    }

    @Override // com.instagram.common.viewpoint.core.H1
    public final void AI8(C4J c4j, int i2, int i8) {
        c4j.A0g(i2);
    }

    @Override // com.instagram.common.viewpoint.core.H1
    public final void AIA(long j, int i2, int i8, int i9, C0787Gz c0787Gz) {
    }

    @Override // com.instagram.common.viewpoint.core.H1
    @MetaExoPlayerCustomization("New API added for Meta")
    public final void AJu(Uri uri) {
    }
}
