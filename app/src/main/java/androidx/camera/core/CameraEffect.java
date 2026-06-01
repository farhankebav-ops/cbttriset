package androidx.camera.core;

import androidx.annotation.RestrictTo;
import androidx.camera.core.processing.SurfaceProcessorInternal;
import androidx.camera.core.processing.SurfaceProcessorWithExecutor;
import androidx.camera.core.processing.TargetUtils;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CameraEffect {
    public static final int IMAGE_CAPTURE = 4;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int OUTPUT_OPTION_ONE_FOR_ALL_TARGETS = 0;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int OUTPUT_OPTION_ONE_FOR_EACH_TARGET = 1;
    public static final int PREVIEW = 1;
    private static final List<Integer> SURFACE_PROCESSOR_TARGETS = Arrays.asList(1, 2, 3, 7);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int TRANSFORMATION_ARBITRARY = 0;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int TRANSFORMATION_CAMERA_AND_SURFACE_ROTATION = 1;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int TRANSFORMATION_PASSTHROUGH = 2;
    public static final int VIDEO_CAPTURE = 2;
    private final Consumer<Throwable> mErrorListener;
    private final Executor mExecutor;
    private final ImageProcessor mImageProcessor;
    private final int mOutputOption;
    private final SurfaceProcessor mSurfaceProcessor;
    private final int mTargets;
    private final int mTransformation;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Formats {
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface OutputOptions {
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Targets {
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Transformations {
    }

    public CameraEffect(int i2, Executor executor, ImageProcessor imageProcessor, Consumer<Throwable> consumer) {
        Preconditions.checkArgument(i2 == 4, "Currently ImageProcessor can only target IMAGE_CAPTURE.");
        this.mTargets = i2;
        this.mTransformation = 0;
        this.mOutputOption = 0;
        this.mExecutor = executor;
        this.mSurfaceProcessor = null;
        this.mImageProcessor = imageProcessor;
        this.mErrorListener = consumer;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public SurfaceProcessorInternal createSurfaceProcessorInternal() {
        return new SurfaceProcessorWithExecutor(this);
    }

    public Consumer<Throwable> getErrorListener() {
        return this.mErrorListener;
    }

    public Executor getExecutor() {
        return this.mExecutor;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ImageProcessor getImageProcessor() {
        return this.mImageProcessor;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getOutputOption() {
        return this.mOutputOption;
    }

    public SurfaceProcessor getSurfaceProcessor() {
        return this.mSurfaceProcessor;
    }

    public int getTargets() {
        return this.mTargets;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getTransformation() {
        return this.mTransformation;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraEffect(int i2, int i8, Executor executor, SurfaceProcessor surfaceProcessor, Consumer<Throwable> consumer) {
        this(i2, 0, i8, executor, surfaceProcessor, consumer);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraEffect(int i2, int i8, int i9, Executor executor, SurfaceProcessor surfaceProcessor, Consumer<Throwable> consumer) {
        TargetUtils.checkSupportedTargets(SURFACE_PROCESSOR_TARGETS, i2);
        this.mTargets = i2;
        this.mOutputOption = i8;
        this.mTransformation = i9;
        this.mExecutor = executor;
        this.mSurfaceProcessor = surfaceProcessor;
        this.mImageProcessor = null;
        this.mErrorListener = consumer;
    }

    public CameraEffect(int i2, Executor executor, SurfaceProcessor surfaceProcessor, Consumer<Throwable> consumer) {
        this(i2, 0, 0, executor, surfaceProcessor, consumer);
    }
}
