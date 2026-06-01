package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.RequestManager;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class SupportRequestManagerFragment extends Fragment {
    @Nullable
    @Deprecated
    public RequestManager getRequestManager() {
        return null;
    }

    @NonNull
    @Deprecated
    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return new EmptyRequestManagerTreeNode();
    }

    @Deprecated
    public void setRequestManager(@Nullable RequestManager requestManager) {
    }
}
