package c6;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public File[] f4220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4221d;
    public boolean e;

    @Override // c6.h
    public final File a() {
        boolean z2 = this.e;
        File file = this.f4230a;
        if (!z2 && this.f4220c == null) {
            File[] fileArrListFiles = file.listFiles();
            this.f4220c = fileArrListFiles;
            if (fileArrListFiles == null) {
                this.e = true;
            }
        }
        File[] fileArr = this.f4220c;
        if (fileArr == null || this.f4221d >= fileArr.length) {
            if (this.f4219b) {
                return null;
            }
            this.f4219b = true;
            return file;
        }
        kotlin.jvm.internal.k.b(fileArr);
        int i2 = this.f4221d;
        this.f4221d = i2 + 1;
        return fileArr[i2];
    }
}
