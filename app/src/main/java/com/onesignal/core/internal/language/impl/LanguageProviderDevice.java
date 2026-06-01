package com.onesignal.core.internal.language.impl;

import java.util.Locale;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LanguageProviderDevice {
    private static final String CHINESE = "zh";
    public static final Companion Companion = new Companion(null);
    private static final String HEBREW_CORRECTED = "he";
    private static final String HEBREW_INCORRECT = "iw";
    private static final String INDONESIAN_CORRECTED = "id";
    private static final String INDONESIAN_INCORRECT = "in";
    private static final String YIDDISH_CORRECTED = "yi";
    private static final String YIDDISH_INCORRECT = "ji";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public final String getLanguage() {
        String language = Locale.getDefault().getLanguage();
        if (language != null) {
            int iHashCode = language.hashCode();
            if (iHashCode != 3365) {
                if (iHashCode != 3374) {
                    if (iHashCode != 3391) {
                        if (iHashCode == 3886 && language.equals(CHINESE)) {
                            return language + '-' + Locale.getDefault().getCountry();
                        }
                    } else if (language.equals(YIDDISH_INCORRECT)) {
                        return YIDDISH_CORRECTED;
                    }
                } else if (language.equals(HEBREW_INCORRECT)) {
                    return HEBREW_CORRECTED;
                }
            } else if (language.equals("in")) {
                return "id";
            }
        }
        k.d(language, "language");
        return language;
    }
}
