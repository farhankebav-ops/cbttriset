package com.unity3d.services.core.request;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IWebRequestProgressListener {
    void onRequestProgress(String str, long j, long j3);

    void onRequestStart(String str, long j, int i2, Map<String, List<String>> map);
}
