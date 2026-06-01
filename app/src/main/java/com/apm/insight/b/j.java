package com.apm.insight.b;

import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.Field;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static MessageQueue f4343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f4344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Field f4345c;

    public static MessageQueue a() {
        if (f4343a == null && Looper.getMainLooper() != null) {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper == Looper.myLooper()) {
                f4343a = Looper.myQueue();
            } else {
                f4343a = mainLooper.getQueue();
            }
        }
        return f4343a;
    }

    public static Message a(MessageQueue messageQueue) {
        Field field = f4344b;
        if (field == null) {
            try {
                Field declaredField = Class.forName("android.os.MessageQueue").getDeclaredField("mMessages");
                f4344b = declaredField;
                declaredField.setAccessible(true);
                return (Message) f4344b.get(messageQueue);
            } catch (Exception unused) {
                return null;
            }
        }
        try {
            return (Message) field.get(messageQueue);
        } catch (Exception unused2) {
            return null;
        }
    }

    private static Message a(Message message) {
        Field field = f4345c;
        if (field == null) {
            try {
                Field declaredField = Class.forName("android.os.Message").getDeclaredField("next");
                f4345c = declaredField;
                declaredField.setAccessible(true);
                return (Message) f4345c.get(message);
            } catch (Exception unused) {
                return null;
            }
        }
        try {
            return (Message) field.get(message);
        } catch (Exception unused2) {
            return null;
        }
    }

    private static JSONObject a(Message message, long j) {
        JSONObject jSONObject = new JSONObject();
        if (message != null) {
            try {
                jSONObject.put("when", message.getWhen() - j);
                if (message.getCallback() != null) {
                    jSONObject.put("callback", String.valueOf(message.getCallback()));
                }
                jSONObject.put("what", message.what);
                if (message.getTarget() != null) {
                    jSONObject.put(TypedValues.AttributesType.S_TARGET, String.valueOf(message.getTarget()));
                } else {
                    jSONObject.put("barrier", message.arg1);
                }
                jSONObject.put("arg1", message.arg1);
                jSONObject.put("arg2", message.arg2);
                Object obj = message.obj;
                if (obj != null) {
                    jSONObject.put("obj", obj);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                return jSONObject;
            }
        }
        return jSONObject;
    }

    public static JSONArray a(long j) {
        MessageQueue messageQueueA = a();
        JSONArray jSONArray = new JSONArray();
        if (messageQueueA != null) {
            try {
                synchronized (messageQueueA) {
                    try {
                        Message messageA = a(messageQueueA);
                        if (messageA == null) {
                            return jSONArray;
                        }
                        int i2 = 0;
                        int i8 = 0;
                        while (messageA != null && i2 < 100) {
                            i2++;
                            i8++;
                            JSONObject jSONObjectA = a(messageA, j);
                            try {
                                jSONObjectA.put("id", i8);
                            } catch (JSONException unused) {
                            }
                            jSONArray.put(jSONObjectA);
                            messageA = a(messageA);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th2, "NPTH_CATCH");
                return jSONArray;
            }
        }
        return jSONArray;
    }
}
