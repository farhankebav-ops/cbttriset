package com.onesignal.core.internal.preferences;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IPreferencesService {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DefaultImpls {
        public static /* synthetic */ Boolean getBool$default(IPreferencesService iPreferencesService, String str, String str2, Boolean bool, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBool");
            }
            if ((i2 & 4) != 0) {
                bool = null;
            }
            return iPreferencesService.getBool(str, str2, bool);
        }

        public static /* synthetic */ Integer getInt$default(IPreferencesService iPreferencesService, String str, String str2, Integer num, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInt");
            }
            if ((i2 & 4) != 0) {
                num = null;
            }
            return iPreferencesService.getInt(str, str2, num);
        }

        public static /* synthetic */ Long getLong$default(IPreferencesService iPreferencesService, String str, String str2, Long l, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLong");
            }
            if ((i2 & 4) != 0) {
                l = null;
            }
            return iPreferencesService.getLong(str, str2, l);
        }

        public static /* synthetic */ String getString$default(IPreferencesService iPreferencesService, String str, String str2, String str3, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getString");
            }
            if ((i2 & 4) != 0) {
                str3 = null;
            }
            return iPreferencesService.getString(str, str2, str3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Set getStringSet$default(IPreferencesService iPreferencesService, String str, String str2, Set set, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getStringSet");
            }
            if ((i2 & 4) != 0) {
                set = null;
            }
            return iPreferencesService.getStringSet(str, str2, set);
        }
    }

    Boolean getBool(String str, String str2, Boolean bool);

    Integer getInt(String str, String str2, Integer num);

    Long getLong(String str, String str2, Long l);

    String getString(String str, String str2, String str3);

    Set<String> getStringSet(String str, String str2, Set<String> set);

    void saveBool(String str, String str2, Boolean bool);

    void saveInt(String str, String str2, Integer num);

    void saveLong(String str, String str2, Long l);

    void saveString(String str, String str2, String str3);

    void saveStringSet(String str, String str2, Set<String> set);
}
