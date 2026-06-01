package com.google.mlkit.vision.interfaces;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleObserver;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public interface Detector<DetectionResultT> extends Closeable, LifecycleObserver {

    @KeepForSdk
    public static final int TYPE_BARCODE_SCANNING = 1;

    @KeepForSdk
    public static final int TYPE_DOCUMENT_DETECTION = 10;

    @KeepForSdk
    public static final int TYPE_FACE_DETECTION = 2;

    @KeepForSdk
    public static final int TYPE_IMAGE_CAPTIONING = 9;

    @KeepForSdk
    public static final int TYPE_IMAGE_LABELING = 3;

    @KeepForSdk
    public static final int TYPE_OBJECT_DETECTION = 5;

    @KeepForSdk
    public static final int TYPE_POSE_DETECTION = 6;

    @KeepForSdk
    public static final int TYPE_SEGMENTATION = 7;

    @KeepForSdk
    public static final int TYPE_SELFIE_FACE_DETECTION = 8;

    @KeepForSdk
    public static final int TYPE_SUBJECT_SEGMENTATION = 11;

    @KeepForSdk
    public static final int TYPE_TEXT_RECOGNITION = 4;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @KeepForSdk
    @Retention(RetentionPolicy.CLASS)
    public @interface DetectorType {
    }

    @DetectorType
    @KeepForSdk
    int getDetectorType();

    @NonNull
    @KeepForSdk
    Task<DetectionResultT> process(@NonNull Bitmap bitmap, int i2);

    @NonNull
    @KeepForSdk
    Task<DetectionResultT> process(@NonNull Image image, int i2);

    @NonNull
    @KeepForSdk
    Task<DetectionResultT> process(@NonNull Image image, int i2, @NonNull Matrix matrix);

    @NonNull
    @KeepForSdk
    Task<DetectionResultT> process(@NonNull ByteBuffer byteBuffer, int i2, int i8, int i9, int i10);
}
