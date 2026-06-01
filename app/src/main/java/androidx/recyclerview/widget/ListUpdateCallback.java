package androidx.recyclerview.widget;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface ListUpdateCallback {
    void onChanged(int i2, int i8, @Nullable Object obj);

    void onInserted(int i2, int i8);

    void onMoved(int i2, int i8);

    void onRemoved(int i2, int i8);
}
