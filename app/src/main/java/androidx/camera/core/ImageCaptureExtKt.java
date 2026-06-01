package androidx.camera.core;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.imagecapture.RequestWithCallback;
import androidx.camera.core.imagecapture.TakePictureRequest;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ImageCaptureExtKt {
    @VisibleForTesting
    public static final TakePictureRequest getTakePictureRequest(ImageCapture imageCapture) {
        kotlin.jvm.internal.k.e(imageCapture, "<this>");
        RequestWithCallback capturingRequest = imageCapture.getTakePictureManager().getCapturingRequest();
        if (capturingRequest != null) {
            return capturingRequest.getTakePictureRequest();
        }
        return null;
    }

    public static final Object takePicture(ImageCapture imageCapture, final e6.a aVar, final e6.l lVar, final e6.l lVar2, v5.c<? super ImageProxy> cVar) {
        Executor executorDirectExecutor;
        v5.f fVar = cVar.getContext().get(v5.d.f17609a);
        q6.w wVar = fVar instanceof q6.w ? (q6.w) fVar : null;
        if (wVar != null) {
            executorDirectExecutor = q6.c0.f(wVar);
        } else {
            executorDirectExecutor = CameraXExecutors.directExecutor();
            kotlin.jvm.internal.k.d(executorDirectExecutor, "directExecutor(...)");
        }
        final q6.l lVar3 = new q6.l(1, a.a.I(cVar));
        lVar3.r();
        final kotlin.jvm.internal.a0 a0Var = new kotlin.jvm.internal.a0();
        a0Var.f12717a = new DelegatingImageCapturedCallback(new ImageCapture.OnImageCapturedCallback() { // from class: androidx.camera.core.ImageCaptureExtKt$takePicture$2$1
            @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
            public void onCaptureProcessProgressed(int i2) {
                e6.l lVar4 = lVar;
                if (lVar4 != null) {
                    lVar4.invoke(Integer.valueOf(i2));
                }
            }

            @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
            public void onCaptureStarted() {
                e6.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.invoke();
                }
            }

            @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
            public void onCaptureSuccess(ImageProxy imageProxy) {
                kotlin.jvm.internal.k.e(imageProxy, "imageProxy");
                Object obj = a0Var.f12717a;
                if (obj == null) {
                    kotlin.jvm.internal.k.l("delegatingCallback");
                    throw null;
                }
                ((DelegatingImageCapturedCallback) obj).dispose();
                lVar3.resumeWith(imageProxy);
            }

            @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
            public void onError(ImageCaptureException exception) {
                kotlin.jvm.internal.k.e(exception, "exception");
                Object obj = a0Var.f12717a;
                if (obj == null) {
                    kotlin.jvm.internal.k.l("delegatingCallback");
                    throw null;
                }
                ((DelegatingImageCapturedCallback) obj).dispose();
                lVar3.resumeWith(r2.q.M(exception));
            }

            @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
            public void onPostviewBitmapAvailable(Bitmap bitmap) {
                kotlin.jvm.internal.k.e(bitmap, "bitmap");
                e6.l lVar4 = lVar2;
                if (lVar4 != null) {
                    lVar4.invoke(bitmap);
                }
            }
        });
        lVar3.t(new e6.l() { // from class: androidx.camera.core.ImageCaptureExtKt$takePicture$2$2
            @Override // e6.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return q5.x.f13520a;
            }

            public final void invoke(Throwable th) {
                Object obj = a0Var.f12717a;
                if (obj != null) {
                    ((DelegatingImageCapturedCallback) obj).dispose();
                } else {
                    kotlin.jvm.internal.k.l("delegatingCallback");
                    throw null;
                }
            }
        });
        Object obj = a0Var.f12717a;
        if (obj == null) {
            kotlin.jvm.internal.k.l("delegatingCallback");
            throw null;
        }
        imageCapture.lambda$takePicture$1(executorDirectExecutor, (DelegatingImageCapturedCallback) obj);
        Object objP = lVar3.p();
        w5.a aVar2 = w5.a.f17774a;
        return objP;
    }

    public static /* synthetic */ Object takePicture$default(ImageCapture imageCapture, e6.a aVar, e6.l lVar, e6.l lVar2, v5.c cVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            aVar = null;
        }
        if ((i2 & 2) != 0) {
            lVar = null;
        }
        if ((i2 & 4) != 0) {
            lVar2 = null;
        }
        return takePicture(imageCapture, aVar, lVar, lVar2, cVar);
    }

    public static /* synthetic */ Object takePicture$default(ImageCapture imageCapture, ImageCapture.OutputFileOptions outputFileOptions, e6.a aVar, e6.l lVar, e6.l lVar2, v5.c cVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            aVar = null;
        }
        if ((i2 & 4) != 0) {
            lVar = null;
        }
        if ((i2 & 8) != 0) {
            lVar2 = null;
        }
        return takePicture(imageCapture, outputFileOptions, aVar, lVar, lVar2, cVar);
    }

    public static final Object takePicture(ImageCapture imageCapture, ImageCapture.OutputFileOptions outputFileOptions, final e6.a aVar, final e6.l lVar, final e6.l lVar2, v5.c<? super ImageCapture.OutputFileResults> cVar) {
        Executor executorDirectExecutor;
        v5.f fVar = cVar.getContext().get(v5.d.f17609a);
        q6.w wVar = fVar instanceof q6.w ? (q6.w) fVar : null;
        if (wVar != null) {
            executorDirectExecutor = q6.c0.f(wVar);
        } else {
            executorDirectExecutor = CameraXExecutors.directExecutor();
            kotlin.jvm.internal.k.d(executorDirectExecutor, "directExecutor(...)");
        }
        final q6.l lVar3 = new q6.l(1, a.a.I(cVar));
        lVar3.r();
        final kotlin.jvm.internal.a0 a0Var = new kotlin.jvm.internal.a0();
        a0Var.f12717a = new DelegatingImageSavedCallback(new ImageCapture.OnImageSavedCallback() { // from class: androidx.camera.core.ImageCaptureExtKt$takePicture$4$1
            @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
            public void onCaptureProcessProgressed(int i2) {
                e6.l lVar4 = lVar;
                if (lVar4 != null) {
                    lVar4.invoke(Integer.valueOf(i2));
                }
            }

            @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
            public void onCaptureStarted() {
                e6.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.invoke();
                }
            }

            @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
            public void onError(ImageCaptureException exception) {
                kotlin.jvm.internal.k.e(exception, "exception");
                Object obj = a0Var.f12717a;
                if (obj == null) {
                    kotlin.jvm.internal.k.l("delegatingCallback");
                    throw null;
                }
                ((DelegatingImageSavedCallback) obj).dispose();
                lVar3.resumeWith(r2.q.M(exception));
            }

            @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
            public void onImageSaved(ImageCapture.OutputFileResults outputFileResults) {
                kotlin.jvm.internal.k.e(outputFileResults, "outputFileResults");
                Object obj = a0Var.f12717a;
                if (obj == null) {
                    kotlin.jvm.internal.k.l("delegatingCallback");
                    throw null;
                }
                ((DelegatingImageSavedCallback) obj).dispose();
                lVar3.resumeWith(outputFileResults);
            }

            @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
            public void onPostviewBitmapAvailable(Bitmap bitmap) {
                kotlin.jvm.internal.k.e(bitmap, "bitmap");
                e6.l lVar4 = lVar2;
                if (lVar4 != null) {
                    lVar4.invoke(bitmap);
                }
            }
        });
        lVar3.t(new e6.l() { // from class: androidx.camera.core.ImageCaptureExtKt$takePicture$4$2
            @Override // e6.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return q5.x.f13520a;
            }

            public final void invoke(Throwable th) {
                Object obj = a0Var.f12717a;
                if (obj != null) {
                    ((DelegatingImageSavedCallback) obj).dispose();
                } else {
                    kotlin.jvm.internal.k.l("delegatingCallback");
                    throw null;
                }
            }
        });
        Object obj = a0Var.f12717a;
        if (obj != null) {
            imageCapture.lambda$takePicture$2(outputFileOptions, executorDirectExecutor, (DelegatingImageSavedCallback) obj);
            Object objP = lVar3.p();
            w5.a aVar2 = w5.a.f17774a;
            return objP;
        }
        kotlin.jvm.internal.k.l("delegatingCallback");
        throw null;
    }
}
