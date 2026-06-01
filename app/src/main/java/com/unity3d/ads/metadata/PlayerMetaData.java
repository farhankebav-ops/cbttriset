package com.unity3d.ads.metadata;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class PlayerMetaData extends MetaData {
    public static final String KEY_SERVER_ID = "server_id";

    public PlayerMetaData(Context context) {
        super(context);
        setCategory("player");
    }

    public void setServerId(String str) {
        set(KEY_SERVER_ID, str);
    }
}
