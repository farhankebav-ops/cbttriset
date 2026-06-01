package androidx.camera.core.impl;

import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.utils.ResolutionSelectorUtil;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class o {
    public static boolean a(Config.OptionPriority optionPriority, Config.OptionPriority optionPriority2) {
        Config.OptionPriority optionPriority3 = Config.OptionPriority.REQUIRED;
        return optionPriority == optionPriority3 && optionPriority2 == optionPriority3;
    }

    public static Config b(Config config, Config config2) {
        if (config == null && config2 == null) {
            return OptionsBundle.emptyBundle();
        }
        MutableOptionsBundle mutableOptionsBundleFrom = config2 != null ? MutableOptionsBundle.from(config2) : MutableOptionsBundle.create();
        if (config != null) {
            Iterator<Config.Option<?>> it = config.listOptions().iterator();
            while (it.hasNext()) {
                c(mutableOptionsBundleFrom, config2, config, it.next());
            }
        }
        return OptionsBundle.from(mutableOptionsBundleFrom);
    }

    public static void c(MutableOptionsBundle mutableOptionsBundle, Config config, Config config2, Config.Option option) {
        if (!Objects.equals(option, ImageOutputConfig.OPTION_RESOLUTION_SELECTOR)) {
            mutableOptionsBundle.insertOption(option, config2.getOptionPriority(option), config2.retrieveOption(option));
            return;
        }
        ResolutionSelector resolutionSelector = (ResolutionSelector) config2.retrieveOption(option, null);
        mutableOptionsBundle.insertOption(option, config2.getOptionPriority(option), ResolutionSelectorUtil.overrideResolutionSelectors((ResolutionSelector) config.retrieveOption(option, null), resolutionSelector));
    }
}
