package com.bytedance.sdk.openadsdk.oeT;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public interface tV {
    Map<String, String> Bc();

    String Cc();

    String EO();

    HandlerThread IlO(String str, int i2);

    ExecutorService IlO();

    JSONObject IlO(JSONObject jSONObject);

    Context MY();

    Handler tV();

    JSONObject vCE();
}
