package com.google.mlkit.vision.common.internal;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import c2.a;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_common.zzlx;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTask;
import com.google.mlkit.vision.common.InputImage;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public class MobileVisionBase<DetectionResultT> implements Closeable, LifecycleObserver {
    public static final /* synthetic */ int zza = 0;
    private static final GmsLogger zzb = new GmsLogger("MobileVisionBase", "");
    private final AtomicBoolean zzc = new AtomicBoolean(false);
    private final MLTask zzd;
    private final CancellationTokenSource zze;
    private final Executor zzf;
    private final Task zzg;

    @KeepForSdk
    public MobileVisionBase(@NonNull MLTask<DetectionResultT, InputImage> mLTask, @NonNull Executor executor) {
        this.zzd = mLTask;
        CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        this.zze = cancellationTokenSource;
        this.zzf = executor;
        mLTask.pin();
        this.zzg = mLTask.callAfterLoad(executor, new Callable() { // from class: com.google.mlkit.vision.common.internal.zzb
            @Override // java.util.concurrent.Callable
            public final Object call() {
                int i2 = MobileVisionBase.zza;
                return null;
            }
        }, cancellationTokenSource.getToken()).addOnFailureListener(new OnFailureListener() { // from class: com.google.mlkit.vision.common.internal.zzc
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                MobileVisionBase.zzb.e("MobileVisionBase", "Error preloading model resource", exc);
            }
        });
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, com.google.mlkit.vision.barcode.BarcodeScanner
    @KeepForSdk
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public synchronized void close() {
        if (this.zzc.getAndSet(true)) {
            return;
        }
        this.zze.cancel();
        this.zzd.unpin(this.zzf);
    }

    @NonNull
    @KeepForSdk
    public synchronized Task<Void> closeWithTask() {
        if (this.zzc.getAndSet(true)) {
            return Tasks.forResult(null);
        }
        this.zze.cancel();
        return this.zzd.unpinWithTask(this.zzf);
    }

    @NonNull
    @KeepForSdk
    public synchronized Task<Void> getInitTaskBase() {
        return this.zzg;
    }

    @NonNull
    @KeepForSdk
    public Task<DetectionResultT> process(@NonNull Bitmap bitmap, int i2) {
        return processBase(InputImage.fromBitmap(bitmap, i2));
    }

    @NonNull
    @KeepForSdk
    public synchronized Task<DetectionResultT> processBase(@NonNull a aVar) {
        Preconditions.checkNotNull(aVar, "MlImage can not be null");
        if (!this.zzc.get()) {
            throw null;
        }
        return Tasks.forException(new MlKitException("This detector is already closed!", 14));
    }

    public final /* synthetic */ Object zza(InputImage inputImage) throws Exception {
        zzlx zzlxVarZze = zzlx.zze("detectorTaskWithResource#run");
        zzlxVarZze.zzb();
        try {
            Object objRun = this.zzd.run(inputImage);
            zzlxVarZze.close();
            return objRun;
        } catch (Throwable th) {
            try {
                zzlxVarZze.close();
            } catch (Throwable th2) {
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                } catch (Exception unused) {
                }
            }
            throw th;
        }
    }

    public final /* synthetic */ Object zzb(a aVar) throws Exception {
        InputImage inputImageConvertMlImagetoInputImage = CommonConvertUtils.convertMlImagetoInputImage(aVar);
        if (inputImageConvertMlImagetoInputImage != null) {
            return this.zzd.run(inputImageConvertMlImagetoInputImage);
        }
        throw new MlKitException("Current type of MlImage is not supported.", 13);
    }

    @NonNull
    @KeepForSdk
    public Task<DetectionResultT> process(@NonNull Image image, int i2) {
        return processBase(InputImage.fromMediaImage(image, i2));
    }

    @NonNull
    @KeepForSdk
    public Task<DetectionResultT> process(@NonNull Image image, int i2, @NonNull Matrix matrix) {
        return processBase(InputImage.fromMediaImage(image, i2, matrix));
    }

    @NonNull
    @KeepForSdk
    public Task<DetectionResultT> process(@NonNull ByteBuffer byteBuffer, int i2, int i8, int i9, int i10) {
        return processBase(InputImage.fromByteBuffer(byteBuffer, i2, i8, i9, i10));
    }

    @NonNull
    @KeepForSdk
    public synchronized Task<DetectionResultT> processBase(@NonNull final InputImage inputImage) {
        Preconditions.checkNotNull(inputImage, "InputImage can not be null");
        if (this.zzc.get()) {
            return Tasks.forException(new MlKitException("This detector is already closed!", 14));
        }
        if (inputImage.getWidth() >= 32 && inputImage.getHeight() >= 32) {
            return this.zzd.callAfterLoad(this.zzf, new Callable() { // from class: com.google.mlkit.vision.common.internal.zza
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zza(inputImage);
                }
            }, this.zze.getToken());
        }
        return Tasks.forException(new MlKitException("InputImage width and height should be at least 32!", 3));
    }
}
