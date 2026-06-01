package androidx.savedstate.serialization;

import i4.c1;
import i7.d;
import i7.f;
import i7.h;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateConfiguration {
    public static final Companion Companion = new Companion(null);
    public static final SavedStateConfiguration DEFAULT = new SavedStateConfiguration(null, 0, false, 7, null);
    private final int classDiscriminatorMode;
    private final boolean encodeDefaults;
    private final f serializersModule;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ SavedStateConfiguration(f fVar, int i2, boolean z2, kotlin.jvm.internal.f fVar2) {
        this(fVar, i2, z2);
    }

    public final int getClassDiscriminatorMode() {
        return this.classDiscriminatorMode;
    }

    public final boolean getEncodeDefaults() {
        return this.encodeDefaults;
    }

    public final f getSerializersModule() {
        return this.serializersModule;
    }

    private SavedStateConfiguration(f fVar, int i2, boolean z2) {
        this.serializersModule = fVar;
        this.classDiscriminatorMode = i2;
        this.encodeDefaults = z2;
    }

    public /* synthetic */ SavedStateConfiguration(f fVar, int i2, boolean z2, int i8, kotlin.jvm.internal.f fVar2) {
        this((i8 & 1) != 0 ? SavedStateConfigurationKt.DEFAULT_SERIALIZERS_MODULE : fVar, (i8 & 2) != 0 ? 2 : i2, (i8 & 4) != 0 ? false : z2);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {
        private int classDiscriminatorMode;
        private boolean encodeDefaults;
        private f serializersModule;

        public Builder(SavedStateConfiguration configuration) {
            k.e(configuration, "configuration");
            this.serializersModule = configuration.getSerializersModule();
            this.encodeDefaults = configuration.getEncodeDefaults();
            this.classDiscriminatorMode = configuration.getClassDiscriminatorMode();
        }

        public final SavedStateConfiguration build$savedstate_release() {
            f fVar = SavedStateConfigurationKt.DEFAULT_SERIALIZERS_MODULE;
            f other = this.serializersModule;
            d dVar = h.f12046a;
            k.e(fVar, "<this>");
            k.e(other, "other");
            c1 c1Var = new c1();
            fVar.a(c1Var);
            other.a(new a4.a(c1Var, 15));
            return new SavedStateConfiguration(c1Var.a(), this.classDiscriminatorMode, this.encodeDefaults, null);
        }

        public final int getClassDiscriminatorMode() {
            return this.classDiscriminatorMode;
        }

        public final boolean getEncodeDefaults() {
            return this.encodeDefaults;
        }

        public final f getSerializersModule() {
            return this.serializersModule;
        }

        public final void setClassDiscriminatorMode(int i2) {
            this.classDiscriminatorMode = i2;
        }

        public final void setEncodeDefaults(boolean z2) {
            this.encodeDefaults = z2;
        }

        public final void setSerializersModule(f fVar) {
            k.e(fVar, "<set-?>");
            this.serializersModule = fVar;
        }

        public static /* synthetic */ void getClassDiscriminatorMode$annotations() {
        }

        public static /* synthetic */ void getEncodeDefaults$annotations() {
        }
    }
}
