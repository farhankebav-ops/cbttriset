package androidx.camera.core.impl.utils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class ExifTag {
    public final String name;
    public final int number;
    public final int primaryFormat;
    public final int secondaryFormat;

    public ExifTag(String str, int i2, int i8) {
        this.name = str;
        this.number = i2;
        this.primaryFormat = i8;
        this.secondaryFormat = -1;
    }

    public boolean isFormatCompatible(int i2) {
        int i8;
        int i9 = this.primaryFormat;
        if (i9 == 7 || i2 == 7 || i9 == i2 || (i8 = this.secondaryFormat) == i2) {
            return true;
        }
        if ((i9 == 4 || i8 == 4) && i2 == 3) {
            return true;
        }
        if ((i9 == 9 || i8 == 9) && i2 == 8) {
            return true;
        }
        return (i9 == 12 || i8 == 12) && i2 == 11;
    }

    public ExifTag(String str, int i2, int i8, int i9) {
        this.name = str;
        this.number = i2;
        this.primaryFormat = i8;
        this.secondaryFormat = i9;
    }
}
