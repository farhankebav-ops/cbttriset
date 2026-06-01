package androidx.camera.video.internal.encoder;

import androidx.camera.video.internal.encoder.VideoEncoderInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p implements VideoEncoderInfo.Finder {
    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo.Finder
    public final VideoEncoderInfo find(String str) {
        return VideoEncoderInfoImpl.lambda$static$0(str);
    }
}
