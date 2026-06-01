package androidx.camera.core;

import android.util.Size;
import androidx.camera.core.ImageProxy;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class ImageProxyDownsampler {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum DownsamplingMethod {
        NEAREST_NEIGHBOR,
        AVERAGING
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class ForwardingImageProxyImpl extends ForwardingImageProxy {
        private final int mDownsampledHeight;
        private final ImageProxy.PlaneProxy[] mDownsampledPlanes;
        private final int mDownsampledWidth;

        public ForwardingImageProxyImpl(ImageProxy imageProxy, ImageProxy.PlaneProxy[] planeProxyArr, int i2, int i8) {
            super(imageProxy);
            this.mDownsampledPlanes = planeProxyArr;
            this.mDownsampledWidth = i2;
            this.mDownsampledHeight = i8;
        }

        @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
        public int getHeight() {
            return this.mDownsampledHeight;
        }

        @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
        public ImageProxy.PlaneProxy[] getPlanes() {
            return this.mDownsampledPlanes;
        }

        @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
        public int getWidth() {
            return this.mDownsampledWidth;
        }
    }

    private ImageProxyDownsampler() {
    }

    private static ImageProxy.PlaneProxy createPlaneProxy(int i2, int i8, byte[] bArr) {
        return new ImageProxy.PlaneProxy(bArr, i2, i8) { // from class: androidx.camera.core.ImageProxyDownsampler.1
            final ByteBuffer mBuffer;
            final /* synthetic */ byte[] val$data;
            final /* synthetic */ int val$pixelStride;
            final /* synthetic */ int val$rowStride;

            {
                this.val$data = bArr;
                this.val$rowStride = i2;
                this.val$pixelStride = i8;
                this.mBuffer = ByteBuffer.wrap(bArr);
            }

            @Override // androidx.camera.core.ImageProxy.PlaneProxy
            public ByteBuffer getBuffer() {
                return this.mBuffer;
            }

            @Override // androidx.camera.core.ImageProxy.PlaneProxy
            public int getPixelStride() {
                return this.val$pixelStride;
            }

            @Override // androidx.camera.core.ImageProxy.PlaneProxy
            public int getRowStride() {
                return this.val$rowStride;
            }
        };
    }

    public static ForwardingImageProxy downsample(ImageProxy imageProxy, int i2, int i8, DownsamplingMethod downsamplingMethod) {
        byte[] bArr;
        int i9;
        byte[] bArr2;
        if (imageProxy.getFormat() != 35) {
            throw new UnsupportedOperationException("Only YUV_420_888 format is currently supported.");
        }
        if (imageProxy.getWidth() < i2 || imageProxy.getHeight() < i8) {
            throw new IllegalArgumentException("Downsampled dimension " + new Size(i2, i8) + " is not <= original dimension " + new Size(imageProxy.getWidth(), imageProxy.getHeight()) + ".");
        }
        if (imageProxy.getWidth() == i2 && imageProxy.getHeight() == i8) {
            return new ForwardingImageProxyImpl(imageProxy, imageProxy.getPlanes(), i2, i8);
        }
        int[] iArr = {imageProxy.getWidth(), imageProxy.getWidth() / 2, imageProxy.getWidth() / 2};
        int[] iArr2 = {imageProxy.getHeight(), imageProxy.getHeight() / 2, imageProxy.getHeight() / 2};
        int i10 = i2 / 2;
        int[] iArr3 = {i2, i10, i10};
        int i11 = i8 / 2;
        int[] iArr4 = {i8, i11, i11};
        ImageProxy.PlaneProxy[] planeProxyArr = new ImageProxy.PlaneProxy[3];
        for (int i12 = 0; i12 < 3; i12++) {
            ImageProxy.PlaneProxy planeProxy = imageProxy.getPlanes()[i12];
            ByteBuffer buffer = planeProxy.getBuffer();
            byte[] bArr3 = new byte[iArr3[i12] * iArr4[i12]];
            int iOrdinal = downsamplingMethod.ordinal();
            if (iOrdinal == 0) {
                bArr = bArr3;
                int i13 = iArr[i12];
                int pixelStride = planeProxy.getPixelStride();
                int rowStride = planeProxy.getRowStride();
                i9 = 1;
                resizeNearestNeighbor(buffer, i13, pixelStride, rowStride, iArr2[i12], bArr, iArr3[i12], iArr4[i12]);
            } else if (iOrdinal != 1) {
                bArr2 = bArr3;
                i9 = 1;
                planeProxyArr[i12] = createPlaneProxy(iArr3[i12], i9, bArr2);
            } else {
                bArr = bArr3;
                int i14 = iArr[i12];
                int pixelStride2 = planeProxy.getPixelStride();
                int rowStride2 = planeProxy.getRowStride();
                i9 = 1;
                resizeAveraging(buffer, i14, pixelStride2, rowStride2, iArr2[i12], bArr, iArr3[i12], iArr4[i12]);
            }
            bArr2 = bArr;
            planeProxyArr[i12] = createPlaneProxy(iArr3[i12], i9, bArr2);
        }
        return new ForwardingImageProxyImpl(imageProxy, planeProxyArr, i2, i8);
    }

    private static void resizeAveraging(ByteBuffer byteBuffer, int i2, int i8, int i9, int i10, byte[] bArr, int i11, int i12) {
        float f4 = i2 / i11;
        float f8 = i10 / i12;
        byte[] bArr2 = new byte[i9];
        byte[] bArr3 = new byte[i9];
        int[] iArr = new int[i11];
        int i13 = 0;
        for (int i14 = 0; i14 < i11; i14++) {
            iArr[i14] = ((int) (i14 * f4)) * i8;
        }
        synchronized (byteBuffer) {
            try {
                byteBuffer.rewind();
                int i15 = 0;
                while (i15 < i12) {
                    int i16 = (int) (i15 * f8);
                    int i17 = i10 - 1;
                    int iMin = Math.min(i16, i17) * i9;
                    int iMin2 = Math.min(i16 + 1, i17) * i9;
                    int i18 = i15 * i11;
                    byteBuffer.position(iMin);
                    byteBuffer.get(bArr2, i13, Math.min(i9, byteBuffer.remaining()));
                    byteBuffer.position(iMin2);
                    byteBuffer.get(bArr3, i13, Math.min(i9, byteBuffer.remaining()));
                    for (int i19 = i13; i19 < i11; i19++) {
                        int i20 = iArr[i19];
                        bArr[i18 + i19] = (byte) ((((((bArr2[i20] & 255) + (bArr2[i20 + i8] & 255)) + (bArr3[i20] & 255)) + (bArr3[i20 + i8] & 255)) / 4) & 255);
                    }
                    i15++;
                    i13 = 0;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void resizeNearestNeighbor(ByteBuffer byteBuffer, int i2, int i8, int i9, int i10, byte[] bArr, int i11, int i12) {
        float f4 = i2 / i11;
        float f8 = i10 / i12;
        byte[] bArr2 = new byte[i9];
        int[] iArr = new int[i11];
        for (int i13 = 0; i13 < i11; i13++) {
            iArr[i13] = ((int) (i13 * f4)) * i8;
        }
        synchronized (byteBuffer) {
            try {
                byteBuffer.rewind();
                for (int i14 = 0; i14 < i12; i14++) {
                    int i15 = i14 * i11;
                    byteBuffer.position(Math.min((int) (i14 * f8), i10 - 1) * i9);
                    byteBuffer.get(bArr2, 0, Math.min(i9, byteBuffer.remaining()));
                    for (int i16 = 0; i16 < i11; i16++) {
                        bArr[i15 + i16] = bArr2[iArr[i16]];
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
