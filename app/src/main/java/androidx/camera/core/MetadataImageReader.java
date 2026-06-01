package androidx.camera.core;

import android.media.ImageReader;
import android.util.LongSparseArray;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MetadataImageReader implements ImageReaderProxy, ForwardingImageProxy.OnImageCloseListener {
    private static final String TAG = "MetadataImageReader";

    @GuardedBy("mLock")
    private final List<ImageProxy> mAcquiredImageProxies;
    private CameraCaptureCallback mCameraCaptureCallback;

    @GuardedBy("mLock")
    private boolean mClosed;

    @GuardedBy("mLock")
    private Executor mExecutor;

    @GuardedBy("mLock")
    private int mImageProxiesIndex;

    @GuardedBy("mLock")
    private final ImageReaderProxy mImageReaderProxy;

    @GuardedBy("mLock")
    ImageReaderProxy.OnImageAvailableListener mListener;
    private final Object mLock;

    @GuardedBy("mLock")
    private final List<ImageProxy> mMatchedImageProxies;

    @GuardedBy("mLock")
    private final LongSparseArray<ImageInfo> mPendingImageInfos;

    @GuardedBy("mLock")
    private final LongSparseArray<ImageProxy> mPendingImages;
    private ImageReaderProxy.OnImageAvailableListener mTransformedListener;

    @GuardedBy("mLock")
    private int mUnAcquiredAvailableImageCount;

    public MetadataImageReader(int i2, int i8, int i9, int i10) {
        this(createImageReaderProxy(i2, i8, i9, i10));
    }

    private static ImageReaderProxy createImageReaderProxy(int i2, int i8, int i9, int i10) {
        return new AndroidImageReaderProxy(ImageReader.newInstance(i2, i8, i9, i10));
    }

    private void dequeImageProxy(ImageProxy imageProxy) {
        synchronized (this.mLock) {
            try {
                int iIndexOf = this.mMatchedImageProxies.indexOf(imageProxy);
                if (iIndexOf >= 0) {
                    this.mMatchedImageProxies.remove(iIndexOf);
                    int i2 = this.mImageProxiesIndex;
                    if (iIndexOf <= i2) {
                        this.mImageProxiesIndex = i2 - 1;
                    }
                }
                this.mAcquiredImageProxies.remove(imageProxy);
                if (this.mUnAcquiredAvailableImageCount > 0) {
                    imageIncoming(this.mImageReaderProxy);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void enqueueImageProxy(SettableImageProxy settableImageProxy) {
        ImageReaderProxy.OnImageAvailableListener onImageAvailableListener;
        Executor executor;
        synchronized (this.mLock) {
            try {
                if (this.mMatchedImageProxies.size() < getMaxImages()) {
                    settableImageProxy.addOnImageCloseListener(this);
                    this.mMatchedImageProxies.add(settableImageProxy);
                    onImageAvailableListener = this.mListener;
                    executor = this.mExecutor;
                } else {
                    Logger.d("TAG", "Maximum image number reached.");
                    settableImageProxy.close();
                    onImageAvailableListener = null;
                    executor = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (onImageAvailableListener != null) {
            if (executor != null) {
                executor.execute(new a(3, this, onImageAvailableListener));
            } else {
                onImageAvailableListener.onImageAvailable(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$enqueueImageProxy$1(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
        onImageAvailableListener.onImageAvailable(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(ImageReaderProxy imageReaderProxy) {
        synchronized (this.mLock) {
            this.mUnAcquiredAvailableImageCount++;
        }
        imageIncoming(imageReaderProxy);
    }

    private void matchImages() {
        synchronized (this.mLock) {
            try {
                for (int size = this.mPendingImageInfos.size() - 1; size >= 0; size--) {
                    ImageInfo imageInfoValueAt = this.mPendingImageInfos.valueAt(size);
                    long timestamp = imageInfoValueAt.getTimestamp();
                    ImageProxy imageProxy = this.mPendingImages.get(timestamp);
                    if (imageProxy != null) {
                        this.mPendingImages.remove(timestamp);
                        this.mPendingImageInfos.removeAt(size);
                        enqueueImageProxy(new SettableImageProxy(imageProxy, imageInfoValueAt));
                    }
                }
                removeStaleData();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void removeStaleData() {
        synchronized (this.mLock) {
            try {
                if (this.mPendingImages.size() != 0 && this.mPendingImageInfos.size() != 0) {
                    long jKeyAt = this.mPendingImages.keyAt(0);
                    Long lValueOf = Long.valueOf(jKeyAt);
                    long jKeyAt2 = this.mPendingImageInfos.keyAt(0);
                    Preconditions.checkArgument(!Long.valueOf(jKeyAt2).equals(lValueOf));
                    if (jKeyAt2 > jKeyAt) {
                        for (int size = this.mPendingImages.size() - 1; size >= 0; size--) {
                            if (this.mPendingImages.keyAt(size) < jKeyAt2) {
                                this.mPendingImages.valueAt(size).close();
                                this.mPendingImages.removeAt(size);
                            }
                        }
                    } else {
                        for (int size2 = this.mPendingImageInfos.size() - 1; size2 >= 0; size2--) {
                            if (this.mPendingImageInfos.keyAt(size2) < jKeyAt) {
                                this.mPendingImageInfos.removeAt(size2);
                            }
                        }
                    }
                }
            } finally {
            }
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public ImageProxy acquireLatestImage() {
        synchronized (this.mLock) {
            try {
                if (this.mMatchedImageProxies.isEmpty()) {
                    return null;
                }
                if (this.mImageProxiesIndex >= this.mMatchedImageProxies.size()) {
                    throw new IllegalStateException("Maximum image number reached.");
                }
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                for (int i8 = 0; i8 < this.mMatchedImageProxies.size() - 1; i8++) {
                    if (!this.mAcquiredImageProxies.contains(this.mMatchedImageProxies.get(i8))) {
                        arrayList.add(this.mMatchedImageProxies.get(i8));
                    }
                }
                int size = arrayList.size();
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    ((ImageProxy) obj).close();
                }
                int size2 = this.mMatchedImageProxies.size();
                List<ImageProxy> list = this.mMatchedImageProxies;
                this.mImageProxiesIndex = size2;
                ImageProxy imageProxy = list.get(size2 - 1);
                this.mAcquiredImageProxies.add(imageProxy);
                return imageProxy;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public ImageProxy acquireNextImage() {
        synchronized (this.mLock) {
            try {
                if (this.mMatchedImageProxies.isEmpty()) {
                    return null;
                }
                if (this.mImageProxiesIndex >= this.mMatchedImageProxies.size()) {
                    throw new IllegalStateException("Maximum image number reached.");
                }
                List<ImageProxy> list = this.mMatchedImageProxies;
                int i2 = this.mImageProxiesIndex;
                this.mImageProxiesIndex = i2 + 1;
                ImageProxy imageProxy = list.get(i2);
                this.mAcquiredImageProxies.add(imageProxy);
                return imageProxy;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void clearOnImageAvailableListener() {
        synchronized (this.mLock) {
            this.mImageReaderProxy.clearOnImageAvailableListener();
            this.mListener = null;
            this.mExecutor = null;
            this.mUnAcquiredAvailableImageCount = 0;
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void close() {
        synchronized (this.mLock) {
            try {
                if (this.mClosed) {
                    return;
                }
                ArrayList arrayList = new ArrayList(this.mMatchedImageProxies);
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    ((ImageProxy) obj).close();
                }
                this.mMatchedImageProxies.clear();
                this.mImageReaderProxy.close();
                this.mClosed = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public CameraCaptureCallback getCameraCaptureCallback() {
        return this.mCameraCaptureCallback;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getHeight() {
        int height;
        synchronized (this.mLock) {
            height = this.mImageReaderProxy.getHeight();
        }
        return height;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getImageFormat() {
        int imageFormat;
        synchronized (this.mLock) {
            imageFormat = this.mImageReaderProxy.getImageFormat();
        }
        return imageFormat;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getMaxImages() {
        int maxImages;
        synchronized (this.mLock) {
            maxImages = this.mImageReaderProxy.getMaxImages();
        }
        return maxImages;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public Surface getSurface() {
        Surface surface;
        synchronized (this.mLock) {
            surface = this.mImageReaderProxy.getSurface();
        }
        return surface;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getWidth() {
        int width;
        synchronized (this.mLock) {
            width = this.mImageReaderProxy.getWidth();
        }
        return width;
    }

    public void imageIncoming(ImageReaderProxy imageReaderProxy) {
        ImageProxy imageProxyAcquireNextImage;
        synchronized (this.mLock) {
            try {
                if (this.mClosed) {
                    return;
                }
                int size = this.mPendingImages.size() + this.mMatchedImageProxies.size();
                if (size >= imageReaderProxy.getMaxImages()) {
                    Logger.d(TAG, "Skip to acquire the next image because the acquired image count has reached the max images count.");
                    return;
                }
                do {
                    try {
                        imageProxyAcquireNextImage = imageReaderProxy.acquireNextImage();
                        if (imageProxyAcquireNextImage != null) {
                            this.mUnAcquiredAvailableImageCount--;
                            size++;
                            this.mPendingImages.put(imageProxyAcquireNextImage.getImageInfo().getTimestamp(), imageProxyAcquireNextImage);
                            matchImages();
                        }
                    } catch (IllegalStateException e) {
                        Logger.d(TAG, "Failed to acquire next image.", e);
                        imageProxyAcquireNextImage = null;
                    }
                    if (imageProxyAcquireNextImage == null || this.mUnAcquiredAvailableImageCount <= 0) {
                        break;
                    }
                } while (size < imageReaderProxy.getMaxImages());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
    public void onImageClose(ImageProxy imageProxy) {
        synchronized (this.mLock) {
            dequeImageProxy(imageProxy);
        }
    }

    public void resultIncoming(CameraCaptureResult cameraCaptureResult) {
        synchronized (this.mLock) {
            try {
                if (this.mClosed) {
                    return;
                }
                this.mPendingImageInfos.put(cameraCaptureResult.getTimestamp(), new CameraCaptureResultImageInfo(cameraCaptureResult));
                matchImages();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void setOnImageAvailableListener(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, Executor executor) {
        synchronized (this.mLock) {
            this.mListener = (ImageReaderProxy.OnImageAvailableListener) Preconditions.checkNotNull(onImageAvailableListener);
            this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
            this.mImageReaderProxy.setOnImageAvailableListener(this.mTransformedListener, executor);
        }
    }

    public MetadataImageReader(ImageReaderProxy imageReaderProxy) {
        this.mLock = new Object();
        this.mCameraCaptureCallback = new CameraCaptureCallback() { // from class: androidx.camera.core.MetadataImageReader.1
            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void onCaptureCompleted(int i2, CameraCaptureResult cameraCaptureResult) {
                super.onCaptureCompleted(i2, cameraCaptureResult);
                MetadataImageReader.this.resultIncoming(cameraCaptureResult);
            }
        };
        this.mUnAcquiredAvailableImageCount = 0;
        this.mTransformedListener = new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.core.b0
            @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
            public final void onImageAvailable(ImageReaderProxy imageReaderProxy2) {
                this.f3569a.lambda$new$0(imageReaderProxy2);
            }
        };
        this.mClosed = false;
        this.mPendingImageInfos = new LongSparseArray<>();
        this.mPendingImages = new LongSparseArray<>();
        this.mAcquiredImageProxies = new ArrayList();
        this.mImageReaderProxy = imageReaderProxy;
        this.mImageProxiesIndex = 0;
        this.mMatchedImageProxies = new ArrayList(getMaxImages());
    }
}
