package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import b7.j;
import d7.g;
import d7.m;
import e7.b;
import e7.d;
import i7.f;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.k;
import q5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateEncoder extends b {
    private final SavedStateConfiguration configuration;
    private String key;
    private final Bundle savedState;
    private final f serializersModule;

    public SavedStateEncoder(Bundle savedState, SavedStateConfiguration configuration) {
        k.e(savedState, "savedState");
        k.e(configuration, "configuration");
        this.savedState = savedState;
        this.configuration = configuration;
        this.key = "";
        this.serializersModule = configuration.getSerializersModule();
    }

    private final void checkDiscriminatorCollisions(Bundle bundle, String str) {
        if (this.configuration.getClassDiscriminatorMode() == 1) {
            boolean zM84containsimpl = SavedStateReader.m84containsimpl(SavedStateReader.m83constructorimpl(bundle), "type");
            boolean zA = k.a(str, "type");
            if (zM84containsimpl && zA) {
                throw new IllegalArgumentException(a1.a.o("SavedStateEncoder for ", SavedStateReader.m154getStringimpl(SavedStateReader.m83constructorimpl(bundle), "type"), " has property '", str, "' that conflicts with the class discriminator. You can rename a property with @SerialName annotation."));
            }
        }
    }

    private final void encodeBooleanArray(boolean[] zArr) {
        SavedStateWriter.m176putBooleanArrayimpl(SavedStateWriter.m169constructorimpl(this.savedState), this.key, zArr);
    }

    private final void encodeCharArray(char[] cArr) {
        SavedStateWriter.m178putCharArrayimpl(SavedStateWriter.m169constructorimpl(this.savedState), this.key, cArr);
    }

    private final void encodeDoubleArray(double[] dArr) {
        SavedStateWriter.m183putDoubleArrayimpl(SavedStateWriter.m169constructorimpl(this.savedState), this.key, dArr);
    }

    private final void encodeFloatArray(float[] fArr) {
        SavedStateWriter.m185putFloatArrayimpl(SavedStateWriter.m169constructorimpl(this.savedState), this.key, fArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> boolean encodeFormatSpecificTypes(j jVar, T t3) {
        if (SavedStateEncoder_androidKt.encodeFormatSpecificTypesOnPlatform(this, jVar, t3)) {
            return true;
        }
        g descriptor = jVar.getDescriptor();
        if (k.a(descriptor, SavedStateCodecUtilsKt.getIntListDescriptor())) {
            k.c(t3, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Int>");
            encodeIntList((List) t3);
            return true;
        }
        if (k.a(descriptor, SavedStateCodecUtilsKt.getStringListDescriptor())) {
            k.c(t3, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            encodeStringList((List) t3);
            return true;
        }
        if (k.a(descriptor, SavedStateCodecUtilsKt.getBooleanArrayDescriptor())) {
            k.c(t3, "null cannot be cast to non-null type kotlin.BooleanArray");
            encodeBooleanArray((boolean[]) t3);
            return true;
        }
        if (k.a(descriptor, SavedStateCodecUtilsKt.getCharArrayDescriptor())) {
            k.c(t3, "null cannot be cast to non-null type kotlin.CharArray");
            encodeCharArray((char[]) t3);
            return true;
        }
        if (k.a(descriptor, SavedStateCodecUtilsKt.getDoubleArrayDescriptor())) {
            k.c(t3, "null cannot be cast to non-null type kotlin.DoubleArray");
            encodeDoubleArray((double[]) t3);
            return true;
        }
        if (k.a(descriptor, SavedStateCodecUtilsKt.getFloatArrayDescriptor())) {
            k.c(t3, "null cannot be cast to non-null type kotlin.FloatArray");
            encodeFloatArray((float[]) t3);
            return true;
        }
        if (k.a(descriptor, SavedStateCodecUtilsKt.getIntArrayDescriptor())) {
            k.c(t3, "null cannot be cast to non-null type kotlin.IntArray");
            encodeIntArray((int[]) t3);
            return true;
        }
        if (k.a(descriptor, SavedStateCodecUtilsKt.getLongArrayDescriptor())) {
            k.c(t3, "null cannot be cast to non-null type kotlin.LongArray");
            encodeLongArray((long[]) t3);
            return true;
        }
        if (!k.a(descriptor, SavedStateCodecUtilsKt.getStringArrayDescriptor())) {
            return false;
        }
        k.c(t3, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        encodeStringArray((String[]) t3);
        return true;
    }

    private final void encodeIntArray(int[] iArr) {
        SavedStateWriter.m187putIntArrayimpl(SavedStateWriter.m169constructorimpl(this.savedState), this.key, iArr);
    }

    private final void encodeIntList(List<Integer> list) {
        SavedStateWriter.m188putIntListimpl(SavedStateWriter.m169constructorimpl(this.savedState), this.key, list);
    }

    private final void encodeLongArray(long[] jArr) {
        SavedStateWriter.m191putLongArrayimpl(SavedStateWriter.m169constructorimpl(this.savedState), this.key, jArr);
    }

    private final void encodeStringArray(String[] strArr) {
        SavedStateWriter.m203putStringArrayimpl(SavedStateWriter.m169constructorimpl(this.savedState), this.key, strArr);
    }

    private final void encodeStringList(List<String> list) {
        SavedStateWriter.m204putStringListimpl(SavedStateWriter.m169constructorimpl(this.savedState), this.key, list);
    }

    private final void putClassDiscriminatorIfRequired(SavedStateConfiguration savedStateConfiguration, g gVar, Bundle bundle) {
        if (savedStateConfiguration.getClassDiscriminatorMode() == 1 && !SavedStateReader.m84containsimpl(SavedStateReader.m83constructorimpl(bundle), "type")) {
            if (k.a(gVar.getKind(), m.f11201b) || k.a(gVar.getKind(), m.e)) {
                SavedStateWriter.m202putStringimpl(SavedStateWriter.m169constructorimpl(bundle), "type", gVar.h());
            }
        }
    }

    @Override // e7.b, e7.f
    public d beginStructure(g descriptor) {
        k.e(descriptor, "descriptor");
        if (k.a(this.key, "")) {
            putClassDiscriminatorIfRequired(this.configuration, descriptor, this.savedState);
            return this;
        }
        i[] iVarArr = new i[0];
        Bundle bundleBundleOf = BundleKt.bundleOf((i[]) Arrays.copyOf(iVarArr, iVarArr.length));
        SavedStateWriter.m169constructorimpl(bundleBundleOf);
        SavedStateWriter.m196putSavedStateimpl(SavedStateWriter.m169constructorimpl(this.savedState), this.key, bundleBundleOf);
        putClassDiscriminatorIfRequired(this.configuration, descriptor, bundleBundleOf);
        return new SavedStateEncoder(bundleBundleOf, this.configuration);
    }

    @Override // e7.b, e7.f
    public void encodeBoolean(boolean z2) {
        SavedStateWriter.m175putBooleanimpl(SavedStateWriter.m169constructorimpl(this.savedState), this.key, z2);
    }

    @Override // e7.b, e7.f
    public void encodeByte(byte b8) {
        SavedStateWriter.m186putIntimpl(SavedStateWriter.m169constructorimpl(this.savedState), this.key, b8);
    }

    @Override // e7.b, e7.f
    public void encodeChar(char c7) {
        SavedStateWriter.m177putCharimpl(SavedStateWriter.m169constructorimpl(this.savedState), this.key, c7);
    }

    @Override // e7.b, e7.f
    public void encodeDouble(double d8) {
        SavedStateWriter.m182putDoubleimpl(SavedStateWriter.m169constructorimpl(this.savedState), this.key, d8);
    }

    @Override // e7.b
    public boolean encodeElement(g descriptor, int i2) {
        k.e(descriptor, "descriptor");
        String strE = descriptor.e(i2);
        this.key = strE;
        checkDiscriminatorCollisions(this.savedState, strE);
        return true;
    }

    @Override // e7.b, e7.f
    public void encodeEnum(g enumDescriptor, int i2) {
        k.e(enumDescriptor, "enumDescriptor");
        SavedStateWriter.m186putIntimpl(SavedStateWriter.m169constructorimpl(this.savedState), this.key, i2);
    }

    @Override // e7.b, e7.f
    public void encodeFloat(float f4) {
        SavedStateWriter.m184putFloatimpl(SavedStateWriter.m169constructorimpl(this.savedState), this.key, f4);
    }

    @Override // e7.b, e7.f
    public void encodeInt(int i2) {
        SavedStateWriter.m186putIntimpl(SavedStateWriter.m169constructorimpl(this.savedState), this.key, i2);
    }

    @Override // e7.b, e7.f
    public void encodeLong(long j) {
        SavedStateWriter.m190putLongimpl(SavedStateWriter.m169constructorimpl(this.savedState), this.key, j);
    }

    @Override // e7.b, e7.f
    public void encodeNull() {
        SavedStateWriter.m192putNullimpl(SavedStateWriter.m169constructorimpl(this.savedState), this.key);
    }

    @Override // e7.b, e7.f
    public <T> void encodeSerializableValue(j serializer, T t3) {
        k.e(serializer, "serializer");
        if (encodeFormatSpecificTypes(serializer, t3)) {
            return;
        }
        serializer.serialize(this, t3);
    }

    @Override // e7.b, e7.f
    public void encodeShort(short s7) {
        SavedStateWriter.m186putIntimpl(SavedStateWriter.m169constructorimpl(this.savedState), this.key, s7);
    }

    @Override // e7.b, e7.f
    public void encodeString(String value) {
        k.e(value, "value");
        SavedStateWriter.m202putStringimpl(SavedStateWriter.m169constructorimpl(this.savedState), this.key, value);
    }

    public final String getKey$savedstate_release() {
        return this.key;
    }

    public final Bundle getSavedState$savedstate_release() {
        return this.savedState;
    }

    @Override // e7.f
    public f getSerializersModule() {
        return this.serializersModule;
    }

    @Override // e7.b, e7.d
    public boolean shouldEncodeElementDefault(g descriptor, int i2) {
        k.e(descriptor, "descriptor");
        return this.configuration.getEncodeDefaults();
    }
}
