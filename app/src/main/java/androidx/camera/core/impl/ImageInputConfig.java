package androidx.camera.core.impl;

import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.Config;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface ImageInputConfig extends ReadableConfig {
    public static final Config.Option<DynamicRange> OPTION_INPUT_DYNAMIC_RANGE;
    public static final Config.Option<Integer> OPTION_INPUT_FORMAT;
    public static final Config.Option<Integer> OPTION_SECONDARY_INPUT_FORMAT;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface Builder<B> {
        B setDynamicRange(DynamicRange dynamicRange);
    }

    static {
        Class cls = Integer.TYPE;
        OPTION_INPUT_FORMAT = Config.Option.create("camerax.core.imageInput.inputFormat", cls);
        OPTION_SECONDARY_INPUT_FORMAT = Config.Option.create("camerax.core.imageInput.secondaryInputFormat", cls);
        OPTION_INPUT_DYNAMIC_RANGE = Config.Option.create("camerax.core.imageInput.inputDynamicRange", DynamicRange.class);
    }

    DynamicRange getDynamicRange();

    int getInputFormat();

    int getSecondaryInputFormat();

    boolean hasDynamicRange();
}
