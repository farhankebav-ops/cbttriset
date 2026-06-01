package androidx.work;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class InputMerger {
    private static final String TAG = Logger.tagWithPrefix("InputMerger");

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static InputMerger fromClassName(@NonNull String str) {
        try {
            return (InputMerger) Class.forName(str).getDeclaredConstructor(null).newInstance(null);
        } catch (Exception e) {
            Logger.get().error(TAG, "Trouble instantiating + " + str, e);
            return null;
        }
    }

    @NonNull
    public abstract Data merge(@NonNull List<Data> list);
}
