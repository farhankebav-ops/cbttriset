package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import n7.b;
import y5.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface InspectableProperty {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface EnumEntry {
        String name();

        int value();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FlagEntry {
        int mask() default 0;

        String name();

        int target();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class ValueType {
        private static final /* synthetic */ a $ENTRIES;
        private static final /* synthetic */ ValueType[] $VALUES;
        public static final ValueType NONE = new ValueType("NONE", 0);
        public static final ValueType INFERRED = new ValueType("INFERRED", 1);
        public static final ValueType INT_ENUM = new ValueType("INT_ENUM", 2);
        public static final ValueType INT_FLAG = new ValueType("INT_FLAG", 3);
        public static final ValueType COLOR = new ValueType("COLOR", 4);
        public static final ValueType GRAVITY = new ValueType("GRAVITY", 5);
        public static final ValueType RESOURCE_ID = new ValueType("RESOURCE_ID", 6);

        private static final /* synthetic */ ValueType[] $values() {
            return new ValueType[]{NONE, INFERRED, INT_ENUM, INT_FLAG, COLOR, GRAVITY, RESOURCE_ID};
        }

        static {
            ValueType[] valueTypeArr$values = $values();
            $VALUES = valueTypeArr$values;
            $ENTRIES = b.n(valueTypeArr$values);
        }

        private ValueType(String str, int i2) {
        }

        public static a getEntries() {
            return $ENTRIES;
        }

        public static ValueType valueOf(String str) {
            return (ValueType) Enum.valueOf(ValueType.class, str);
        }

        public static ValueType[] values() {
            return (ValueType[]) $VALUES.clone();
        }
    }

    int attributeId() default 0;

    EnumEntry[] enumMapping() default {};

    FlagEntry[] flagMapping() default {};

    boolean hasAttributeId() default true;

    String name() default "";

    ValueType valueType() default ValueType.INFERRED;
}
