package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import j2.q;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public interface ForegroundUpdater {
    @NonNull
    q setForegroundAsync(@NonNull Context context, @NonNull UUID uuid, @NonNull ForegroundInfo foregroundInfo);
}
