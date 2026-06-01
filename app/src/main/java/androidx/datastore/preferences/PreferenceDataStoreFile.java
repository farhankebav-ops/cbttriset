package androidx.datastore.preferences;

import android.content.Context;
import androidx.datastore.DataStoreFile;
import java.io.File;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class PreferenceDataStoreFile {
    public static final File preferencesDataStoreFile(Context context, String name) {
        k.e(context, "<this>");
        k.e(name, "name");
        return DataStoreFile.dataStoreFile(context, name.concat(".preferences_pb"));
    }
}
