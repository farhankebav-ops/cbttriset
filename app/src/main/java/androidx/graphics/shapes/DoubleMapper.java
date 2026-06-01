package androidx.graphics.shapes;

import androidx.collection.MutableFloatList;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class DoubleMapper {
    public static final Companion Companion = new Companion(null);
    public static final DoubleMapper Identity;
    private final MutableFloatList sourceValues;
    private final MutableFloatList targetValues;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Float fValueOf = Float.valueOf(0.0f);
        i iVar = new i(fValueOf, fValueOf);
        Float fValueOf2 = Float.valueOf(0.5f);
        Identity = new DoubleMapper(iVar, new i(fValueOf2, fValueOf2));
    }

    public DoubleMapper(i... mappings) {
        k.e(mappings, "mappings");
        this.sourceValues = new MutableFloatList(mappings.length);
        this.targetValues = new MutableFloatList(mappings.length);
        int length = mappings.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.sourceValues.add(((Number) mappings[i2].f13498a).floatValue());
            this.targetValues.add(((Number) mappings[i2].f13499b).floatValue());
        }
        FloatMappingKt.validateProgress(this.sourceValues);
        FloatMappingKt.validateProgress(this.targetValues);
    }

    public final float map(float f4) {
        return FloatMappingKt.linearMap(this.sourceValues, this.targetValues, f4);
    }

    public final float mapBack(float f4) {
        return FloatMappingKt.linearMap(this.targetValues, this.sourceValues, f4);
    }
}
