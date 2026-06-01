package androidx.datastore.preferences.core;

import e6.a;
import java.io.File;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import n6.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class PreferenceDataStoreFactory$create$delegate$1 extends l implements a {
    final /* synthetic */ a $produceFile;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreferenceDataStoreFactory$create$delegate$1(a aVar) {
        super(0);
        this.$produceFile = aVar;
    }

    @Override // e6.a
    public final File invoke() {
        File file = (File) this.$produceFile.invoke();
        k.e(file, "<this>");
        String name = file.getName();
        k.d(name, "getName(...)");
        if (m.O0('.', name, "").equals("preferences_pb")) {
            File absoluteFile = file.getAbsoluteFile();
            k.d(absoluteFile, "file.absoluteFile");
            return absoluteFile;
        }
        throw new IllegalStateException(("File extension for file: " + file + " does not match required extension for Preferences file: preferences_pb").toString());
    }
}
