package androidx.webkit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@UiThread
public interface ProfileStore {
    boolean deleteProfile(@NonNull String str);

    @NonNull
    List<String> getAllProfileNames();

    @NonNull
    Profile getOrCreateProfile(@NonNull String str);

    @Nullable
    Profile getProfile(@NonNull String str);
}
