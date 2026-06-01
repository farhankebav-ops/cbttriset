package androidx.profileinstaller;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
enum FileSectionType {
    DEX_FILES(0),
    EXTRA_DESCRIPTORS(1),
    CLASSES(2),
    METHODS(3),
    AGGREGATION_COUNT(4);

    private final long mValue;

    FileSectionType(long j) {
        this.mValue = j;
    }

    public static FileSectionType fromValue(long j) {
        FileSectionType[] fileSectionTypeArrValues = values();
        for (int i2 = 0; i2 < fileSectionTypeArrValues.length; i2++) {
            if (fileSectionTypeArrValues[i2].getValue() == j) {
                return fileSectionTypeArrValues[i2];
            }
        }
        throw new IllegalArgumentException(androidx.camera.core.processing.util.a.j("Unsupported FileSection Type ", j));
    }

    public long getValue() {
        return this.mValue;
    }
}
