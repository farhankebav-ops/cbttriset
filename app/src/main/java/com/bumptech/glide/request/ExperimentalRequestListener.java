package com.bumptech.glide.request;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.target.Target;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public abstract class ExperimentalRequestListener<ResourceT> implements RequestListener<ResourceT> {
    public abstract boolean onResourceReady(ResourceT resourcet, Object obj, Target<ResourceT> target, DataSource dataSource, boolean z2, boolean z7);

    public void onRequestStarted(Object obj) {
    }
}
