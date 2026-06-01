package com.bytedance.sdk.openadsdk.oeT;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    private final String EO;
    private SharedPreferences IlO;
    private final Context MY;

    public MY(Context context, String str) {
        this.MY = context;
        this.EO = str;
    }

    private SharedPreferences MY() {
        Context context;
        SharedPreferences sharedPreferences = this.IlO;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        if (TextUtils.isEmpty(this.EO) || (context = this.MY) == null) {
            return null;
        }
        try {
            this.IlO = context.getSharedPreferences(this.EO, 0);
        } catch (Throwable th) {
            Log.e("SPUnit", th.getMessage());
        }
        return this.IlO;
    }

    public void IlO(JSONObject jSONObject) {
        try {
            SharedPreferences sharedPreferencesMY = MY();
            if (sharedPreferencesMY != null) {
                SharedPreferences.Editor editorEdit = sharedPreferencesMY.edit();
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        if (!TextUtils.isEmpty(next)) {
                            Object obj = jSONObject.get(next);
                            if (obj instanceof Integer) {
                                editorEdit.putInt(next, ((Integer) obj).intValue());
                            } else if (obj instanceof Long) {
                                editorEdit.putLong(next, ((Long) obj).longValue());
                            } else if (obj instanceof String) {
                                editorEdit.putString(next, (String) obj);
                            } else if (obj instanceof Boolean) {
                                editorEdit.putBoolean(next, ((Boolean) obj).booleanValue());
                            } else if (obj instanceof Float) {
                                editorEdit.putFloat(next, ((Float) obj).floatValue());
                            } else if (obj instanceof Double) {
                                editorEdit.putFloat(next, ((Double) obj).floatValue());
                            }
                        }
                    } catch (Throwable th) {
                        Log.e("SPUnit", th.getMessage());
                    }
                }
                editorEdit.apply();
            }
        } catch (Throwable th2) {
            Log.e("SPUnit", th2.getMessage());
        }
    }

    public long MY(String str, long j) {
        try {
            SharedPreferences sharedPreferencesMY = MY();
            if (sharedPreferencesMY != null && sharedPreferencesMY.contains(str)) {
                return sharedPreferencesMY.getLong(str, j);
            }
            return j;
        } catch (Throwable th) {
            Log.i("SPUnit", this.EO + th.getMessage());
            return j;
        }
    }

    public void IlO(String str, long j) {
        try {
            SharedPreferences sharedPreferencesMY = MY();
            if (sharedPreferencesMY != null) {
                SharedPreferences.Editor editorEdit = sharedPreferencesMY.edit();
                editorEdit.putLong(str, j);
                editorEdit.apply();
            }
        } catch (Throwable th) {
            Log.e("SPUnit", th.getMessage());
        }
    }

    public int IlO(String str, int i2) {
        try {
            SharedPreferences sharedPreferencesMY = MY();
            if (sharedPreferencesMY != null && sharedPreferencesMY.contains(str)) {
                return sharedPreferencesMY.getInt(str, i2);
            }
            return i2;
        } catch (Throwable th) {
            Log.i("SPUnit", this.EO + th.getMessage());
            return i2;
        }
    }

    public String IlO(String str, String str2) {
        try {
            SharedPreferences sharedPreferencesMY = MY();
            if (sharedPreferencesMY != null && sharedPreferencesMY.contains(str)) {
                return sharedPreferencesMY.getString(str, str2);
            }
            return str2;
        } catch (Throwable th) {
            Log.i("SPUnit", this.EO + th.getMessage());
            return str2;
        }
    }

    public boolean IlO(String str, boolean z2) {
        try {
            SharedPreferences sharedPreferencesMY = MY();
            if (sharedPreferencesMY != null && sharedPreferencesMY.contains(str)) {
                return sharedPreferencesMY.getBoolean(str, z2);
            }
            return z2;
        } catch (Throwable th) {
            Log.i("SPUnit", this.EO + th.getMessage());
            return z2;
        }
    }

    public void IlO() {
        SharedPreferences sharedPreferencesMY = MY();
        if (sharedPreferencesMY != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesMY.edit();
            editorEdit.clear();
            editorEdit.commit();
        }
    }
}
