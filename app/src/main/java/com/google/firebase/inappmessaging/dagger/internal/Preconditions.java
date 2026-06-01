package com.google.firebase.inappmessaging.dagger.internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static <T> void checkBuilderRequirement(T t3, Class<T> cls) {
        if (t3 != null) {
            return;
        }
        throw new IllegalStateException(cls.getCanonicalName() + " must be set");
    }

    public static <T> T checkNotNull(T t3) {
        t3.getClass();
        return t3;
    }

    public static <T> T checkNotNullFromComponent(T t3) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable component method");
    }

    public static <T> T checkNotNullFromProvides(T t3) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }

    public static <T> T checkNotNull(T t3, String str) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(str);
    }

    public static <T> T checkNotNull(T t3, String str, Object obj) {
        String strValueOf;
        if (t3 != null) {
            return t3;
        }
        if (str.contains("%s")) {
            if (str.indexOf("%s") == str.lastIndexOf("%s")) {
                if (obj instanceof Class) {
                    strValueOf = ((Class) obj).getCanonicalName();
                } else {
                    strValueOf = String.valueOf(obj);
                }
                throw new NullPointerException(str.replace("%s", strValueOf));
            }
            throw new IllegalArgumentException("errorMessageTemplate has more than one format specifier");
        }
        throw new IllegalArgumentException("errorMessageTemplate has no format specifiers");
    }
}
