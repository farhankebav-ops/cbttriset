package androidx.camera.core.internal;

import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ReadableConfig;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface TargetConfig<T> extends ReadableConfig {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Config.Option<String> OPTION_TARGET_NAME = Config.Option.create("camerax.core.target.name", String.class);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Config.Option<Class<?>> OPTION_TARGET_CLASS = Config.Option.create("camerax.core.target.class", Class.class);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface Builder<T, B> {
        B setTargetClass(Class<T> cls);

        B setTargetName(String str);
    }

    Class<T> getTargetClass();

    Class<T> getTargetClass(Class<T> cls);

    String getTargetName();

    String getTargetName(String str);
}
