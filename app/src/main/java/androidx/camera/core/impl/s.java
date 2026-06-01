package androidx.camera.core.impl;

import androidx.camera.core.DynamicRange;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class s {
    public static DynamicRange a(ImageInputConfig imageInputConfig) {
        return (DynamicRange) Preconditions.checkNotNull((DynamicRange) imageInputConfig.retrieveOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, DynamicRange.UNSPECIFIED));
    }

    public static int b(ImageInputConfig imageInputConfig) {
        return ((Integer) imageInputConfig.retrieveOption(ImageInputConfig.OPTION_INPUT_FORMAT)).intValue();
    }

    public static int c(ImageInputConfig imageInputConfig) {
        return ((Integer) imageInputConfig.retrieveOption(ImageInputConfig.OPTION_SECONDARY_INPUT_FORMAT, 0)).intValue();
    }

    public static boolean d(ImageInputConfig imageInputConfig) {
        return imageInputConfig.containsOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE);
    }
}
