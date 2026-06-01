package androidx.camera.extensions.internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class AutoValue_Version extends Version {
    private final String description;
    private final int major;
    private final int minor;
    private final int patch;

    public AutoValue_Version(int i2, int i8, int i9, String str) {
        this.major = i2;
        this.minor = i8;
        this.patch = i9;
        if (str == null) {
            throw new NullPointerException("Null description");
        }
        this.description = str;
    }

    @Override // androidx.camera.extensions.internal.Version
    public String getDescription() {
        return this.description;
    }

    @Override // androidx.camera.extensions.internal.Version
    public int getMajor() {
        return this.major;
    }

    @Override // androidx.camera.extensions.internal.Version
    public int getMinor() {
        return this.minor;
    }

    @Override // androidx.camera.extensions.internal.Version
    public int getPatch() {
        return this.patch;
    }
}
