package androidx.core.content;

import android.content.SharedPreferences;
import e6.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SharedPreferencesKt {
    public static final void edit(SharedPreferences sharedPreferences, boolean z2, l lVar) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        lVar.invoke(editorEdit);
        if (z2) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
    }

    public static /* synthetic */ void edit$default(SharedPreferences sharedPreferences, boolean z2, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        lVar.invoke(editorEdit);
        if (z2) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
    }
}
