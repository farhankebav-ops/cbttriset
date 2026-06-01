package com.unity3d.ads.core.domain;

import android.opengl.GLES20;
import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.gl.EglCore;
import com.unity3d.ads.gl.OffscreenSurface;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidGetOpenGLRendererInfo implements GetOpenGLRendererInfo {
    private final SessionRepository sessionRepository;

    public AndroidGetOpenGLRendererInfo(SessionRepository sessionRepository) {
        k.e(sessionRepository, "sessionRepository");
        this.sessionRepository = sessionRepository;
    }

    @Override // com.unity3d.ads.core.domain.GetOpenGLRendererInfo
    public ByteString invoke() {
        if (!this.sessionRepository.getFeatureFlags().getOpenglGpuEnabled()) {
            ByteString byteStringEmpty = ByteString.empty();
            k.d(byteStringEmpty, "{\n            ByteString.empty()\n        }");
            return byteStringEmpty;
        }
        EglCore eglCore = new EglCore(null, 2);
        OffscreenSurface offscreenSurface = new OffscreenSurface(eglCore, 1, 1);
        offscreenSurface.makeCurrent();
        String renderer = GLES20.glGetString(7937);
        k.d(renderer, "renderer");
        byte[] bytes = renderer.getBytes(n6.a.f13073a);
        k.d(bytes, "this as java.lang.String).getBytes(charset)");
        ByteString byteStringCopyFrom = ByteString.copyFrom(bytes);
        offscreenSurface.release();
        eglCore.release();
        k.d(byteStringCopyFrom, "{\n            // We need…dererByteString\n        }");
        return byteStringCopyFrom;
    }
}
