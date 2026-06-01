package androidx.camera.core.impl;

import android.util.Pair;
import android.util.Size;
import androidx.camera.core.AspectRatio;
import androidx.camera.core.impl.Config;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface ImageOutputConfig extends ReadableConfig {
    public static final int INVALID_ROTATION = -1;
    public static final Config.Option<Integer> OPTION_APP_TARGET_ROTATION;
    public static final Config.Option<List<Size>> OPTION_CUSTOM_ORDERED_RESOLUTIONS;
    public static final Config.Option<Size> OPTION_DEFAULT_RESOLUTION;
    public static final Config.Option<Size> OPTION_MAX_RESOLUTION;
    public static final Config.Option<Integer> OPTION_MIRROR_MODE;
    public static final Config.Option<ResolutionSelector> OPTION_RESOLUTION_SELECTOR;
    public static final Config.Option<List<Pair<Integer, Size[]>>> OPTION_SUPPORTED_RESOLUTIONS;
    public static final Config.Option<Integer> OPTION_TARGET_ASPECT_RATIO = Config.Option.create("camerax.core.imageOutput.targetAspectRatio", AspectRatio.class);
    public static final Config.Option<Size> OPTION_TARGET_RESOLUTION;
    public static final Config.Option<Integer> OPTION_TARGET_ROTATION;
    public static final int ROTATION_NOT_SPECIFIED = -1;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface Builder<B> {
        B setCustomOrderedResolutions(List<Size> list);

        B setDefaultResolution(Size size);

        B setMaxResolution(Size size);

        B setMirrorMode(int i2);

        B setResolutionSelector(ResolutionSelector resolutionSelector);

        B setSupportedResolutions(List<Pair<Integer, Size[]>> list);

        B setTargetAspectRatio(int i2);

        B setTargetResolution(Size size);

        B setTargetRotation(int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface OptionalRotationValue {
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface RotationDegreesValue {
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface RotationValue {
    }

    static {
        Class cls = Integer.TYPE;
        OPTION_TARGET_ROTATION = Config.Option.create("camerax.core.imageOutput.targetRotation", cls);
        OPTION_APP_TARGET_ROTATION = Config.Option.create("camerax.core.imageOutput.appTargetRotation", cls);
        OPTION_MIRROR_MODE = Config.Option.create("camerax.core.imageOutput.mirrorMode", cls);
        OPTION_TARGET_RESOLUTION = Config.Option.create("camerax.core.imageOutput.targetResolution", Size.class);
        OPTION_DEFAULT_RESOLUTION = Config.Option.create("camerax.core.imageOutput.defaultResolution", Size.class);
        OPTION_MAX_RESOLUTION = Config.Option.create("camerax.core.imageOutput.maxResolution", Size.class);
        OPTION_SUPPORTED_RESOLUTIONS = Config.Option.create("camerax.core.imageOutput.supportedResolutions", List.class);
        OPTION_RESOLUTION_SELECTOR = Config.Option.create("camerax.core.imageOutput.resolutionSelector", ResolutionSelector.class);
        OPTION_CUSTOM_ORDERED_RESOLUTIONS = Config.Option.create("camerax.core.imageOutput.customOrderedResolutions", List.class);
    }

    int getAppTargetRotation(int i2);

    List<Size> getCustomOrderedResolutions();

    List<Size> getCustomOrderedResolutions(List<Size> list);

    Size getDefaultResolution();

    Size getDefaultResolution(Size size);

    Size getMaxResolution();

    Size getMaxResolution(Size size);

    int getMirrorMode(int i2);

    ResolutionSelector getResolutionSelector();

    ResolutionSelector getResolutionSelector(ResolutionSelector resolutionSelector);

    List<Pair<Integer, Size[]>> getSupportedResolutions();

    List<Pair<Integer, Size[]>> getSupportedResolutions(List<Pair<Integer, Size[]>> list);

    int getTargetAspectRatio();

    Size getTargetResolution();

    Size getTargetResolution(Size size);

    int getTargetRotation();

    int getTargetRotation(int i2);

    boolean hasTargetAspectRatio();
}
