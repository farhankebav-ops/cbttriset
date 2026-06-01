package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface MenuProvider {
    void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater);

    void onMenuClosed(@NonNull Menu menu);

    boolean onMenuItemSelected(@NonNull MenuItem menuItem);

    void onPrepareMenu(@NonNull Menu menu);
}
