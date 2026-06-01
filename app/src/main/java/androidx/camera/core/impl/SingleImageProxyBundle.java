package androidx.camera.core.impl;

import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.utils.futures.Futures;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SingleImageProxyBundle implements ImageProxyBundle {
    private final int mCaptureId;
    private final ImageProxy mImageProxy;

    public SingleImageProxyBundle(ImageProxy imageProxy, String str) {
        ImageInfo imageInfo = imageProxy.getImageInfo();
        if (imageInfo == null) {
            throw new IllegalArgumentException("ImageProxy has no associated ImageInfo");
        }
        Integer num = (Integer) imageInfo.getTagBundle().getTag(str);
        if (num == null) {
            throw new IllegalArgumentException("ImageProxy has no associated tag");
        }
        this.mCaptureId = num.intValue();
        this.mImageProxy = imageProxy;
    }

    public void close() {
        this.mImageProxy.close();
    }

    @Override // androidx.camera.core.impl.ImageProxyBundle
    public List<Integer> getCaptureIds() {
        return Collections.singletonList(Integer.valueOf(this.mCaptureId));
    }

    @Override // androidx.camera.core.impl.ImageProxyBundle
    public j2.q getImageProxy(int i2) {
        return i2 != this.mCaptureId ? Futures.immediateFailedFuture(new IllegalArgumentException("Capture id does not exist in the bundle")) : Futures.immediateFuture(this.mImageProxy);
    }

    public SingleImageProxyBundle(ImageProxy imageProxy, int i2) {
        this.mCaptureId = i2;
        this.mImageProxy = imageProxy;
    }
}
