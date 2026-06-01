package com.bumptech.glide.module;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public interface GlideModule extends RegistersComponents, AppliesOptions {
    @Override // com.bumptech.glide.module.AppliesOptions
    /* synthetic */ void applyOptions(Context context, GlideBuilder glideBuilder);

    @Override // com.bumptech.glide.module.RegistersComponents
    /* synthetic */ void registerComponents(Context context, Glide glide, Registry registry);
}
