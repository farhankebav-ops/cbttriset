package com.onesignal.inAppMessages.internal.common;

import com.onesignal.core.internal.language.ILanguageContext;
import com.onesignal.inAppMessages.internal.InAppMessage;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;
import r5.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InAppHelper {
    public static final InAppHelper INSTANCE = new InAppHelper();
    private static final List<String> PREFERRED_VARIANT_ORDER = m.H0("android", "app", "all");

    private InAppHelper() {
    }

    public final String variantIdForMessage(InAppMessage message, ILanguageContext languageContext) {
        k.e(message, "message");
        k.e(languageContext, "languageContext");
        String language = languageContext.getLanguage();
        for (String str : PREFERRED_VARIANT_ORDER) {
            if (message.getVariants().containsKey(str)) {
                Map<String, String> map = message.getVariants().get(str);
                k.b(map);
                Map<String, String> map2 = map;
                if (!map2.containsKey(language)) {
                    language = "default";
                }
                return map2.get(language);
            }
        }
        return null;
    }
}
