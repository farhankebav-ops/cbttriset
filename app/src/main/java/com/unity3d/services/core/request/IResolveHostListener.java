package com.unity3d.services.core.request;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IResolveHostListener {
    void onFailed(String str, ResolveHostError resolveHostError, String str2);

    void onResolve(String str, String str2);
}
