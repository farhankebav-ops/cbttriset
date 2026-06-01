package androidx.activity;

import android.content.res.Resources;
import androidx.annotation.ColorInt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SystemBarStyle {
    public static final Companion Companion = new Companion(null);
    private final int darkScrim;
    private final e6.l detectDarkMode;
    private final int lightScrim;
    private final int nightMode;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        public static /* synthetic */ SystemBarStyle auto$default(Companion companion, int i2, int i8, e6.l lVar, int i9, Object obj) {
            if ((i9 & 4) != 0) {
                lVar = new u(2);
            }
            return companion.auto(i2, i8, lVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean auto$lambda$0(Resources resources) {
            kotlin.jvm.internal.k.e(resources, "resources");
            return (resources.getConfiguration().uiMode & 48) == 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean dark$lambda$1(Resources resources) {
            kotlin.jvm.internal.k.e(resources, "<unused var>");
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean light$lambda$2(Resources resources) {
            kotlin.jvm.internal.k.e(resources, "<unused var>");
            return false;
        }

        public final SystemBarStyle auto(@ColorInt int i2, @ColorInt int i8) {
            return auto$default(this, i2, i8, null, 4, null);
        }

        public final SystemBarStyle dark(@ColorInt int i2) {
            return new SystemBarStyle(i2, i2, 2, new u(1), null);
        }

        public final SystemBarStyle light(@ColorInt int i2, @ColorInt int i8) {
            return new SystemBarStyle(i2, i8, 1, new u(0), null);
        }

        private Companion() {
        }

        public final SystemBarStyle auto(@ColorInt int i2, @ColorInt int i8, e6.l detectDarkMode) {
            kotlin.jvm.internal.k.e(detectDarkMode, "detectDarkMode");
            return new SystemBarStyle(i2, i8, 0, detectDarkMode, null);
        }
    }

    public /* synthetic */ SystemBarStyle(int i2, int i8, int i9, e6.l lVar, kotlin.jvm.internal.f fVar) {
        this(i2, i8, i9, lVar);
    }

    public static final SystemBarStyle auto(@ColorInt int i2, @ColorInt int i8) {
        return Companion.auto(i2, i8);
    }

    public static final SystemBarStyle dark(@ColorInt int i2) {
        return Companion.dark(i2);
    }

    public static final SystemBarStyle light(@ColorInt int i2, @ColorInt int i8) {
        return Companion.light(i2, i8);
    }

    public final int getDarkScrim$activity_release() {
        return this.darkScrim;
    }

    public final e6.l getDetectDarkMode$activity_release() {
        return this.detectDarkMode;
    }

    public final int getNightMode$activity_release() {
        return this.nightMode;
    }

    public final int getScrim$activity_release(boolean z2) {
        return z2 ? this.darkScrim : this.lightScrim;
    }

    public final int getScrimWithEnforcedContrast$activity_release(boolean z2) {
        if (this.nightMode == 0) {
            return 0;
        }
        return z2 ? this.darkScrim : this.lightScrim;
    }

    private SystemBarStyle(int i2, int i8, int i9, e6.l lVar) {
        this.lightScrim = i2;
        this.darkScrim = i8;
        this.nightMode = i9;
        this.detectDarkMode = lVar;
    }

    public static final SystemBarStyle auto(@ColorInt int i2, @ColorInt int i8, e6.l lVar) {
        return Companion.auto(i2, i8, lVar);
    }
}
