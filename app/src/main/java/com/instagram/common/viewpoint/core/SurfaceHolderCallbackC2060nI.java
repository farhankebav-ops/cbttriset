package com.instagram.common.viewpoint.core;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nI, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class SurfaceHolderCallbackC2060nI implements InterfaceC0750Fo, C8D, InterfaceC0700Dq, B3, SurfaceHolder.Callback, TextureView.SurfaceTextureListener {
    public static String[] A01 = {"mdkndyL3N", "34XFwDl9WvKoMHQUixXhMeiNQCyC6vNP", "5uafIaN5", "lxzaK8fg5Pf0nzPouXyzPKk1aT8cB3T1", "DTIJ", "0UAV", "B5vkeIjqEzHsmqRbylQSobdgrKqNmXUo", "pkzfV8UoB1KOSL3E8gfET47OMeTC19My"};
    public final /* synthetic */ C9V A00;

    @Override // com.instagram.common.viewpoint.core.C8D
    public final /* synthetic */ void ACT(C2154or c2154or, C05015j c05015j) {
    }

    @Override // com.instagram.common.viewpoint.core.C8D
    public final /* synthetic */ void ACU(long j) {
    }

    @Override // com.instagram.common.viewpoint.core.C8D
    public final /* synthetic */ void ACV(Exception exc) {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0750Fo
    public final /* synthetic */ void ACr(int i2, long j) {
    }

    @Override // com.instagram.common.viewpoint.core.C8D
    public final /* synthetic */ void AFF(boolean z2) {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0750Fo
    public final /* synthetic */ void AFl(C2154or c2154or, C05015j c05015j) {
    }

    public SurfaceHolderCallbackC2060nI(C9V c9v) {
        this.A00 = c9v;
    }

    @Override // com.instagram.common.viewpoint.core.C8D
    public final void ACP(String str, long j, long j3) {
        Iterator it = this.A00.A0H.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            if (A01[1].charAt(3) != 'F') {
                throw new RuntimeException();
            }
            A01[3] = "1hpUDXdDopjYnxDN8fIPsNGSxN8OzRvU";
            if (zHasNext) {
                ((C8D) it.next()).ACP(str, j, j3);
            } else {
                return;
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.C8D
    public final void ACQ(C04985g c04985g) {
        Iterator it = this.A00.A0H.iterator();
        while (it.hasNext()) {
            ((C8D) it.next()).ACQ(c04985g);
        }
        this.A00.A07 = null;
        this.A00.A09 = null;
        this.A00.A01 = 0;
    }

    @Override // com.instagram.common.viewpoint.core.C8D
    public final void ACR(C04985g c04985g) {
        this.A00.A09 = c04985g;
        Iterator it = this.A00.A0H.iterator();
        while (it.hasNext()) {
            ((C8D) it.next()).ACR(c04985g);
        }
    }

    @Override // com.instagram.common.viewpoint.core.C8D
    public final void ACS(C2154or c2154or) {
        this.A00.A07 = c2154or;
        Iterator it = this.A00.A0H.iterator();
        while (it.hasNext()) {
            ((C8D) it.next()).ACS(c2154or);
        }
    }

    @Override // com.instagram.common.viewpoint.core.C8D
    public final void ACY(int i2, long j, long j3) {
        Iterator it = this.A00.A0H.iterator();
        while (it.hasNext()) {
            ((C8D) it.next()).ACY(i2, j, j3);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0700Dq
    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "Required until we deprecate and move ComponentListener to ExoPlayerImpl.")
    public final void ACv(C2103o0 c2103o0) {
        Iterator it = this.A00.A0I.iterator();
        while (it.hasNext()) {
            ((InterfaceC04322s) it.next()).ACv(c2103o0);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0700Dq
    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "Required until we deprecate and move ComponentListener to ExoPlayerImpl.")
    public final void ACw(List<C2105o2> list) {
        Iterator it = this.A00.A0I.iterator();
        while (it.hasNext()) {
            ((InterfaceC04322s) it.next()).ACw(list);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0750Fo
    public final void AD7(int i2, long j) {
        Iterator it = this.A00.A0K.iterator();
        while (it.hasNext()) {
            ((InterfaceC0750Fo) it.next()).AD7(i2, j);
        }
    }

    @Override // com.instagram.common.viewpoint.core.B3
    public final void AEE(Metadata metadata, long j) {
        Iterator it = this.A00.A0J.iterator();
        while (it.hasNext()) {
            ((B3) it.next()).AEE(metadata, j);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0750Fo
    public final void AEx(Object obj, long j) {
        if (this.A00.A03 == obj) {
            Iterator it = this.A00.A0L.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        Iterator it2 = this.A00.A0K.iterator();
        while (it2.hasNext()) {
            ((InterfaceC0750Fo) it2.next()).AEx(obj, j);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0750Fo
    public final void AFd(String str, long j, long j3) {
        Iterator it = this.A00.A0K.iterator();
        while (it.hasNext()) {
            ((InterfaceC0750Fo) it.next()).AFd(str, j, j3);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0750Fo
    public final void AFe(C04985g c04985g) {
        Iterator it = this.A00.A0K.iterator();
        while (it.hasNext()) {
            ((InterfaceC0750Fo) it.next()).AFe(c04985g);
        }
        this.A00.A08 = null;
        this.A00.A0A = null;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0750Fo
    public final void AFf(C04985g c04985g) {
        this.A00.A0A = c04985g;
        Iterator it = this.A00.A0K.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            if (A01[0].length() != 9) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[7] = "MKCckBbCZrSSu6G06Z7NkbaNocq2WvpN";
            strArr[6] = "V8qjKHPFdvtphjyj0wrcUTYdTARdRgua";
            if (zHasNext) {
                ((InterfaceC0750Fo) it.next()).AFf(c04985g);
            } else {
                return;
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0750Fo
    public final void AFk(C2154or c2154or) {
        this.A00.A08 = c2154or;
        Iterator it = this.A00.A0K.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            if (A01[1].charAt(3) != 'F') {
                throw new RuntimeException();
            }
            A01[3] = "2z1T7IcDfmpzuxqypnwVKmOXmU8bKGPo";
            if (zHasNext) {
                ((InterfaceC0750Fo) it.next()).AFk(c2154or);
            } else {
                return;
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0750Fo
    public final void AFr(C2107o4 c2107o4) {
        Iterator it = this.A00.A0L.iterator();
        while (it.hasNext()) {
            ((InterfaceC04754j) it.next()).AFq(c2107o4.A03, c2107o4.A01, c2107o4.A02, c2107o4.A00);
        }
        for (InterfaceC0750Fo interfaceC0750Fo : this.A00.A0K) {
            String[] strArr = A01;
            if (strArr[4].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            A01[1] = "q7eFcMKXm9CoB0iVpo1HKrbod3G9GfaY";
            interfaceC0750Fo.AFr(c2107o4);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i8) {
        this.A00.A0F(new Surface(surfaceTexture), true);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.A00.A0F(null, true);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i8) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i8, int i9) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.A00.A0F(surfaceHolder.getSurface(), false);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.A00.A0F(null, false);
    }
}
