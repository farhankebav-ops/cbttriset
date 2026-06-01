package androidx.savedstate.serialization.serializers;

import android.util.SparseArray;
import b7.c;
import b7.h;
import b7.j;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import d7.g;
import e7.e;
import f7.c1;
import f7.d;
import f7.e1;
import f7.l0;
import f7.m1;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.k;
import n7.b;
import q5.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SparseArraySerializer<T> implements c {
    private final g descriptor;
    private final c surrogateSerializer;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @h
    public static final class SparseArraySurrogate<T> {
        private static final g $cachedDescriptor;
        private final List<Integer> keys;
        private final List<T> values;
        public static final Companion Companion = new Companion(null);
        private static final f[] $childSerializers = {b.B(q5.g.f13495b, new a()), null};

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            private Companion() {
            }

            public final <T> c serializer(c typeSerial0) {
                k.e(typeSerial0, "typeSerial0");
                return new SparseArraySerializer$SparseArraySurrogate$$serializer(typeSerial0);
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
                this();
            }
        }

        static {
            e1 e1Var = new e1("androidx.savedstate.serialization.serializers.SparseArraySerializer.SparseArraySurrogate", null, 2);
            e1Var.j(UserMetadata.KEYDATA_FILENAME, false);
            e1Var.j("values", false);
            $cachedDescriptor = e1Var;
        }

        public /* synthetic */ SparseArraySurrogate(int i2, List list, List list2, m1 m1Var) {
            if (3 != (i2 & 3)) {
                c1.j($cachedDescriptor, i2, 3);
                throw null;
            }
            this.keys = list;
            this.values = list2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ c _childSerializers$_anonymous_() {
            return new d(l0.f11478a, 0);
        }

        public static final /* synthetic */ void write$Self$savedstate_release(SparseArraySurrogate sparseArraySurrogate, e7.d dVar, g gVar, c cVar) {
            dVar.encodeSerializableElement(gVar, 0, (j) $childSerializers[0].getValue(), sparseArraySurrogate.keys);
            dVar.encodeSerializableElement(gVar, 1, new d(cVar, 0), sparseArraySurrogate.values);
        }

        public final List<Integer> getKeys() {
            return this.keys;
        }

        public final List<T> getValues() {
            return this.values;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SparseArraySurrogate(List<Integer> keys, List<? extends T> values) {
            k.e(keys, "keys");
            k.e(values, "values");
            this.keys = keys;
            this.values = values;
        }
    }

    public SparseArraySerializer(c elementSerializer) {
        k.e(elementSerializer, "elementSerializer");
        c cVarSerializer = SparseArraySurrogate.Companion.serializer(elementSerializer);
        this.surrogateSerializer = cVarSerializer;
        this.descriptor = cVarSerializer.getDescriptor();
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return this.descriptor;
    }

    @Override // b7.b
    public SparseArray<T> deserialize(e decoder) {
        k.e(decoder, "decoder");
        SparseArraySurrogate sparseArraySurrogate = (SparseArraySurrogate) decoder.decodeSerializableValue(this.surrogateSerializer);
        if (sparseArraySurrogate.getKeys().size() != sparseArraySurrogate.getValues().size()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        SparseArray<T> sparseArray = new SparseArray<>(sparseArraySurrogate.getKeys().size());
        int size = sparseArraySurrogate.getKeys().size();
        for (int i2 = 0; i2 < size; i2++) {
            sparseArray.append(sparseArraySurrogate.getKeys().get(i2).intValue(), sparseArraySurrogate.getValues().get(i2));
        }
        return sparseArray;
    }

    @Override // b7.j
    public void serialize(e7.f encoder, SparseArray<T> value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        int size = value.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(Integer.valueOf(value.keyAt(i2)));
        }
        int size2 = value.size();
        ArrayList arrayList2 = new ArrayList(size2);
        for (int i8 = 0; i8 < size2; i8++) {
            arrayList2.add(value.valueAt(i8));
        }
        encoder.encodeSerializableValue(this.surrogateSerializer, new SparseArraySurrogate(arrayList, arrayList2));
    }
}
