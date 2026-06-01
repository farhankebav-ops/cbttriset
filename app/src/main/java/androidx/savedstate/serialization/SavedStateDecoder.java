package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.savedstate.SavedStateReader;
import b7.b;
import d7.g;
import d7.m;
import e7.c;
import i7.f;
import java.util.List;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateDecoder extends e7.a {
    private final SavedStateConfiguration configuration;
    private int index;
    private String key;
    private final Bundle savedState;
    private final f serializersModule;

    public SavedStateDecoder(Bundle savedState, SavedStateConfiguration configuration) {
        k.e(savedState, "savedState");
        k.e(configuration, "configuration");
        this.savedState = savedState;
        this.configuration = configuration;
        this.key = "";
        this.serializersModule = configuration.getSerializersModule();
    }

    private final boolean[] decodeBooleanArray() {
        return SavedStateReader.m93getBooleanArrayimpl(SavedStateReader.m83constructorimpl(this.savedState), this.key);
    }

    private final char[] decodeCharArray() {
        return SavedStateReader.m97getCharArrayimpl(SavedStateReader.m83constructorimpl(this.savedState), this.key);
    }

    private final double[] decodeDoubleArray() {
        return SavedStateReader.m107getDoubleArrayimpl(SavedStateReader.m83constructorimpl(this.savedState), this.key);
    }

    private static final boolean decodeElementIndex$presentInEncoding(SavedStateDecoder savedStateDecoder, g gVar, int i2) {
        return SavedStateReader.m84containsimpl(SavedStateReader.m83constructorimpl(savedStateDecoder.savedState), gVar.e(i2));
    }

    private final float[] decodeFloatArray() {
        return SavedStateReader.m111getFloatArrayimpl(SavedStateReader.m83constructorimpl(this.savedState), this.key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> T decodeFormatSpecificTypes(b bVar) {
        T t3 = (T) SavedStateDecoder_androidKt.decodeFormatSpecificTypesOnPlatform(this, bVar);
        if (t3 != null) {
            return t3;
        }
        g descriptor = bVar.getDescriptor();
        if (k.a(descriptor, SavedStateCodecUtilsKt.getIntListDescriptor())) {
            return (T) decodeIntList();
        }
        if (k.a(descriptor, SavedStateCodecUtilsKt.getStringListDescriptor())) {
            return (T) decodeStringList();
        }
        if (k.a(descriptor, SavedStateCodecUtilsKt.getBooleanArrayDescriptor())) {
            return (T) decodeBooleanArray();
        }
        if (k.a(descriptor, SavedStateCodecUtilsKt.getCharArrayDescriptor())) {
            return (T) decodeCharArray();
        }
        if (k.a(descriptor, SavedStateCodecUtilsKt.getDoubleArrayDescriptor())) {
            return (T) decodeDoubleArray();
        }
        if (k.a(descriptor, SavedStateCodecUtilsKt.getFloatArrayDescriptor())) {
            return (T) decodeFloatArray();
        }
        if (k.a(descriptor, SavedStateCodecUtilsKt.getIntArrayDescriptor())) {
            return (T) decodeIntArray();
        }
        if (k.a(descriptor, SavedStateCodecUtilsKt.getLongArrayDescriptor())) {
            return (T) decodeLongArray();
        }
        if (k.a(descriptor, SavedStateCodecUtilsKt.getStringArrayDescriptor())) {
            return (T) decodeStringArray();
        }
        return null;
    }

    private final int[] decodeIntArray() {
        return SavedStateReader.m115getIntArrayimpl(SavedStateReader.m83constructorimpl(this.savedState), this.key);
    }

    private final List<Integer> decodeIntList() {
        return SavedStateReader.m117getIntListimpl(SavedStateReader.m83constructorimpl(this.savedState), this.key);
    }

    private final long[] decodeLongArray() {
        return SavedStateReader.m125getLongArrayimpl(SavedStateReader.m83constructorimpl(this.savedState), this.key);
    }

    private final String[] decodeStringArray() {
        return SavedStateReader.m155getStringArrayimpl(SavedStateReader.m83constructorimpl(this.savedState), this.key);
    }

    private final List<String> decodeStringList() {
        return SavedStateReader.m157getStringListimpl(SavedStateReader.m83constructorimpl(this.savedState), this.key);
    }

    @Override // e7.a, e7.e
    public c beginStructure(g descriptor) {
        k.e(descriptor, "descriptor");
        return k.a(this.key, "") ? this : new SavedStateDecoder(SavedStateReader.m140getSavedStateimpl(SavedStateReader.m83constructorimpl(this.savedState), this.key), this.configuration);
    }

    @Override // e7.a, e7.e
    public boolean decodeBoolean() {
        return SavedStateReader.m92getBooleanimpl(SavedStateReader.m83constructorimpl(this.savedState), this.key);
    }

    @Override // e7.a, e7.e
    public byte decodeByte() {
        return (byte) SavedStateReader.m114getIntimpl(SavedStateReader.m83constructorimpl(this.savedState), this.key);
    }

    @Override // e7.a, e7.e
    public char decodeChar() {
        return SavedStateReader.m96getCharimpl(SavedStateReader.m83constructorimpl(this.savedState), this.key);
    }

    @Override // e7.a, e7.e
    public double decodeDouble() {
        return SavedStateReader.m106getDoubleimpl(SavedStateReader.m83constructorimpl(this.savedState), this.key);
    }

    @Override // e7.c
    public int decodeElementIndex(g descriptor) {
        k.e(descriptor, "descriptor");
        int iM163sizeimpl = (k.a(descriptor.getKind(), m.f11202c) || k.a(descriptor.getKind(), m.f11203d)) ? SavedStateReader.m163sizeimpl(SavedStateReader.m83constructorimpl(this.savedState)) : descriptor.d();
        while (true) {
            int i2 = this.index;
            if (i2 >= iM163sizeimpl || !descriptor.i(i2) || decodeElementIndex$presentInEncoding(this, descriptor, this.index)) {
                break;
            }
            this.index++;
        }
        int i8 = this.index;
        if (i8 >= iM163sizeimpl) {
            return -1;
        }
        this.key = descriptor.e(i8);
        int i9 = this.index;
        this.index = i9 + 1;
        return i9;
    }

    @Override // e7.a, e7.e
    public int decodeEnum(g enumDescriptor) {
        k.e(enumDescriptor, "enumDescriptor");
        return SavedStateReader.m114getIntimpl(SavedStateReader.m83constructorimpl(this.savedState), this.key);
    }

    @Override // e7.a, e7.e
    public float decodeFloat() {
        return SavedStateReader.m110getFloatimpl(SavedStateReader.m83constructorimpl(this.savedState), this.key);
    }

    @Override // e7.a, e7.e
    public int decodeInt() {
        return SavedStateReader.m114getIntimpl(SavedStateReader.m83constructorimpl(this.savedState), this.key);
    }

    @Override // e7.a, e7.e
    public long decodeLong() {
        return SavedStateReader.m124getLongimpl(SavedStateReader.m83constructorimpl(this.savedState), this.key);
    }

    @Override // e7.a, e7.e
    public boolean decodeNotNullMark() {
        return !SavedStateReader.m162isNullimpl(SavedStateReader.m83constructorimpl(this.savedState), this.key);
    }

    @Override // e7.a, e7.e
    public <T> T decodeSerializableValue(b deserializer) {
        k.e(deserializer, "deserializer");
        T t3 = (T) decodeFormatSpecificTypes(deserializer);
        return t3 == null ? (T) super.decodeSerializableValue(deserializer) : t3;
    }

    @Override // e7.a, e7.e
    public short decodeShort() {
        return (short) SavedStateReader.m114getIntimpl(SavedStateReader.m83constructorimpl(this.savedState), this.key);
    }

    @Override // e7.a, e7.e
    public String decodeString() {
        return SavedStateReader.m154getStringimpl(SavedStateReader.m83constructorimpl(this.savedState), this.key);
    }

    public final String getKey$savedstate_release() {
        return this.key;
    }

    public final Bundle getSavedState$savedstate_release() {
        return this.savedState;
    }

    @Override // e7.e, e7.c
    public f getSerializersModule() {
        return this.serializersModule;
    }
}
