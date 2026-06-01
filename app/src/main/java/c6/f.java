package c6;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class f extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public File[] f4224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4225d;

    @Override // c6.h
    public final File a() {
        boolean z2 = this.f4223b;
        File file = this.f4230a;
        if (!z2) {
            this.f4223b = true;
            return file;
        }
        File[] fileArr = this.f4224c;
        if (fileArr != null && this.f4225d >= fileArr.length) {
            return null;
        }
        if (fileArr == null) {
            File[] fileArrListFiles = file.listFiles();
            this.f4224c = fileArrListFiles;
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                return null;
            }
        }
        File[] fileArr2 = this.f4224c;
        kotlin.jvm.internal.k.b(fileArr2);
        int i2 = this.f4225d;
        this.f4225d = i2 + 1;
        return fileArr2[i2];
    }
}
