package androidx.camera.core.impl;

import androidx.camera.core.impl.Config;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class w {
    public static boolean a(ReadableConfig readableConfig, Config.Option option) {
        return readableConfig.getConfig().containsOption(option);
    }

    public static void b(ReadableConfig readableConfig, String str, Config.OptionMatcher optionMatcher) {
        readableConfig.getConfig().findOptions(str, optionMatcher);
    }

    public static Config.OptionPriority c(ReadableConfig readableConfig, Config.Option option) {
        return readableConfig.getConfig().getOptionPriority(option);
    }

    public static Set d(ReadableConfig readableConfig, Config.Option option) {
        return readableConfig.getConfig().getPriorities(option);
    }

    public static Set e(ReadableConfig readableConfig) {
        return readableConfig.getConfig().listOptions();
    }

    public static Object f(ReadableConfig readableConfig, Config.Option option) {
        return readableConfig.getConfig().retrieveOption(option);
    }

    public static Object g(ReadableConfig readableConfig, Config.Option option, Object obj) {
        return readableConfig.getConfig().retrieveOption(option, obj);
    }

    public static Object h(ReadableConfig readableConfig, Config.Option option, Config.OptionPriority optionPriority) {
        return readableConfig.getConfig().retrieveOptionWithPriority(option, optionPriority);
    }
}
