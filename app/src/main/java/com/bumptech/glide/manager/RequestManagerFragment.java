package com.bumptech.glide.manager;

import android.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class RequestManagerFragment extends Fragment {
    @Nullable
    @Deprecated
    public RequestManager getRequestManager() {
        return null;
    }

    @NonNull
    @Deprecated
    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return new RequestManagerTreeNode() { // from class: com.bumptech.glide.manager.RequestManagerFragment.1
            @Override // com.bumptech.glide.manager.RequestManagerTreeNode
            @NonNull
            public Set<RequestManager> getDescendants() {
                return Collections.EMPTY_SET;
            }
        };
    }

    @Deprecated
    public void setRequestManager(@Nullable RequestManager requestManager) {
    }
}
