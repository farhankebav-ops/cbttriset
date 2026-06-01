package androidx.camera.core;

import android.graphics.Matrix;
import android.util.Size;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.resolutionselector.ResolutionFilter;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m implements CallbackToFutureAdapter.Resolver, ImageAnalysis.Analyzer, ResolutionFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f3675a;

    public /* synthetic */ m(Object obj) {
        this.f3675a = obj;
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public void analyze(ImageProxy imageProxy) {
        ((ImageAnalysis.Analyzer) this.f3675a).analyze(imageProxy);
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return ((CameraX) this.f3675a).lambda$shutdownInternal$4(completer);
    }

    @Override // androidx.camera.core.resolutionselector.ResolutionFilter
    public List filter(List list, int i2) {
        return ImageAnalysis.lambda$onMergeConfig$0((Size) this.f3675a, list, i2);
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public /* synthetic */ Size getDefaultTargetResolution() {
        return o.a(this);
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public /* synthetic */ int getTargetCoordinateSystem() {
        return o.b(this);
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public /* synthetic */ void updateTransform(Matrix matrix) {
        o.c(this, matrix);
    }
}
