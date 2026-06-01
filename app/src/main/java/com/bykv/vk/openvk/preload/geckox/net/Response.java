package com.bykv.vk.openvk.preload.geckox.net;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Response {
    public final String body;
    public final int code;
    public final Map<String, String> headers;
    public final String msg;

    public Response(Map<String, String> map, String str, int i2, String str2) {
        this.headers = map;
        this.body = str;
        this.code = i2;
        this.msg = str2;
    }
}
