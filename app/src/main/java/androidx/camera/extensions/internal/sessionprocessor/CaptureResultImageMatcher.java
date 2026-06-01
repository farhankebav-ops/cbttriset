package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.util.LongSparseArray;
import androidx.annotation.GuardedBy;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class CaptureResultImageMatcher {
    private static final int INVALID_TIMESTAMP = -1;

    @GuardedBy("mLock")
    ImageReferenceListener mImageReferenceListener;
    private final Object mLock = new Object();

    @GuardedBy("mLock")
    private final LongSparseArray<List<TotalCaptureResult>> mPendingCaptureResults = new LongSparseArray<>();

    @GuardedBy("mLock")
    Map<TotalCaptureResult, Integer> mCaptureStageIdMap = new HashMap();

    @GuardedBy("mLock")
    private final LongSparseArray<List<ImageReference>> mPendingImages = new LongSparseArray<>();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface ImageReferenceListener {
        void onImageReferenceIncoming(ImageReference imageReference, TotalCaptureResult totalCaptureResult, int i2);
    }

    private <T> void addToList(LongSparseArray<List<T>> longSparseArray, long j, T t3) {
        List<T> arrayList = longSparseArray.get(j);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            longSparseArray.put(j, arrayList);
        }
        arrayList.add(t3);
    }

    private long getTimeStampFromCaptureResult(TotalCaptureResult totalCaptureResult) {
        Long l = (Long) totalCaptureResult.get(CaptureResult.SENSOR_TIMESTAMP);
        if (l != null) {
            return l.longValue();
        }
        return -1L;
    }

    private void matchImages() {
        TotalCaptureResult totalCaptureResult;
        ImageReference imageReference;
        synchronized (this.mLock) {
            try {
                int size = this.mPendingCaptureResults.size() - 1;
                while (true) {
                    if (size < 0) {
                        totalCaptureResult = null;
                        imageReference = null;
                        break;
                    }
                    List<TotalCaptureResult> listValueAt = this.mPendingCaptureResults.valueAt(size);
                    if (!listValueAt.isEmpty()) {
                        totalCaptureResult = listValueAt.get(0);
                        long timeStampFromCaptureResult = getTimeStampFromCaptureResult(totalCaptureResult);
                        Preconditions.checkState(timeStampFromCaptureResult == this.mPendingCaptureResults.keyAt(size));
                        List<ImageReference> list = this.mPendingImages.get(timeStampFromCaptureResult);
                        if (list != null && !list.isEmpty()) {
                            imageReference = list.get(0);
                            removeFromList(this.mPendingImages, timeStampFromCaptureResult, imageReference);
                            listValueAt.remove(totalCaptureResult);
                            if (listValueAt.isEmpty()) {
                                this.mPendingCaptureResults.removeAt(size);
                            }
                        }
                    }
                    size--;
                }
                removeStaleData();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (imageReference == null || totalCaptureResult == null) {
            return;
        }
        notifyImage(imageReference, totalCaptureResult);
    }

    private void notifyImage(ImageReference imageReference, TotalCaptureResult totalCaptureResult) {
        ImageReferenceListener imageReferenceListener;
        Integer num;
        synchronized (this.mLock) {
            try {
                imageReferenceListener = this.mImageReferenceListener;
                if (imageReferenceListener != null) {
                    num = this.mCaptureStageIdMap.get(totalCaptureResult);
                } else {
                    imageReference.decrement();
                    imageReferenceListener = null;
                    num = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (imageReferenceListener != null) {
            imageReferenceListener.onImageReferenceIncoming(imageReference, totalCaptureResult, num.intValue());
        }
    }

    private <T> void removeFromList(LongSparseArray<List<T>> longSparseArray, long j, T t3) {
        List<T> list = longSparseArray.get(j);
        if (list != null) {
            list.remove(t3);
            if (list.isEmpty()) {
                longSparseArray.remove(j);
            }
        }
    }

    private void removeStaleData() {
        synchronized (this.mLock) {
            try {
                if (this.mPendingImages.size() != 0 && this.mPendingCaptureResults.size() != 0) {
                    long jKeyAt = this.mPendingImages.keyAt(0);
                    Long lValueOf = Long.valueOf(jKeyAt);
                    long jKeyAt2 = this.mPendingCaptureResults.keyAt(0);
                    Preconditions.checkArgument(!Long.valueOf(jKeyAt2).equals(lValueOf));
                    if (jKeyAt2 > jKeyAt) {
                        for (int size = this.mPendingImages.size() - 1; size >= 0; size--) {
                            if (this.mPendingImages.keyAt(size) < jKeyAt2) {
                                Iterator<ImageReference> it = this.mPendingImages.valueAt(size).iterator();
                                while (it.hasNext()) {
                                    it.next().decrement();
                                }
                                this.mPendingImages.removeAt(size);
                            }
                        }
                    } else {
                        for (int size2 = this.mPendingCaptureResults.size() - 1; size2 >= 0; size2--) {
                            if (this.mPendingCaptureResults.keyAt(size2) < jKeyAt) {
                                this.mPendingCaptureResults.removeAt(size2);
                            }
                        }
                    }
                }
            } finally {
            }
        }
    }

    public void captureResultIncoming(TotalCaptureResult totalCaptureResult) {
        captureResultIncoming(totalCaptureResult, 0);
    }

    public void clear() {
        synchronized (this.mLock) {
            try {
                this.mPendingCaptureResults.clear();
                for (int i2 = 0; i2 < this.mPendingImages.size(); i2++) {
                    Iterator<ImageReference> it = this.mPendingImages.get(this.mPendingImages.keyAt(i2)).iterator();
                    while (it.hasNext()) {
                        it.next().decrement();
                    }
                }
                this.mPendingImages.clear();
                this.mCaptureStageIdMap.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void clearImageReferenceListener() {
        synchronized (this.mLock) {
            this.mImageReferenceListener = null;
        }
    }

    public void imageIncoming(ImageReference imageReference) {
        synchronized (this.mLock) {
            addToList(this.mPendingImages, imageReference.get().getTimestamp(), imageReference);
        }
        matchImages();
    }

    public void setImageReferenceListener(ImageReferenceListener imageReferenceListener) {
        synchronized (this.mLock) {
            this.mImageReferenceListener = imageReferenceListener;
        }
    }

    public void captureResultIncoming(TotalCaptureResult totalCaptureResult, int i2) {
        synchronized (this.mLock) {
            try {
                long timeStampFromCaptureResult = getTimeStampFromCaptureResult(totalCaptureResult);
                if (timeStampFromCaptureResult == -1) {
                    return;
                }
                addToList(this.mPendingCaptureResults, timeStampFromCaptureResult, totalCaptureResult);
                this.mCaptureStageIdMap.put(totalCaptureResult, Integer.valueOf(i2));
                matchImages();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
