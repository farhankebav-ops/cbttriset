package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import com.vungle.ads.internal.protos.Sdk;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ix {

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static long f2638 = 6327984086712293453L;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2639 = 0;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static long f2640 = -3790727232008568432L;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f2641 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static void m2597(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        httpURLConnection.connect();
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.flush();
        m2606(dataOutputStream);
        int i2 = f2639 + 69;
        f2641 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static ir m2599(JSONObject jSONObject, String str) {
        f2639 = (f2641 + 43) % 128;
        try {
            HttpURLConnection httpURLConnectionM2596 = m2596(str);
            byte[] bArrM2598 = m2598(httpURLConnectionM2596, jSONObject);
            long jM2805 = jv.m2805();
            m2597(httpURLConnectionM2596, bArrM2598);
            String strM2595 = m2595(httpURLConnectionM2596);
            int responseCode = httpURLConnectionM2596.getResponseCode();
            String responseMessage = httpURLConnectionM2596.getResponseMessage();
            if (responseCode >= 400) {
                f2639 = (f2641 + 95) % 128;
                httpURLConnectionM2596.disconnect();
            }
            ir irVar = new ir(strM2595, responseCode, responseMessage, jv.m2805() - jM2805);
            f2641 = (f2639 + 29) % 128;
            return irVar;
        } catch (Throwable th) {
            String strIntern = m2594("䒝ᑟ붅ᩈ䓓햪㻑庭䊩폦㒉僋", (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1).intern();
            StringBuilder sb = new StringBuilder();
            sb.append(m2605("須꽊\uf6d5㹽䗫贤풀ᰛ⎋欴늶﨤Ŗ䢜遛ꟹ\uef6e㛼繗薐촌ᒥ尶掫\uaac6\uf254㦕䄺", View.resolveSizeAndState(0, 0, 0) + 14197).intern());
            sb.append(th.getLocalizedMessage());
            k.m2861(strIntern, sb.toString(), th);
            return null;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static boolean m2602(String str) {
        if (str.length() <= 256) {
            f2639 = (f2641 + 103) % 128;
            return false;
        }
        int i2 = f2639 + 93;
        f2641 = i2 % 128;
        return i2 % 2 != 0;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static ir m2604(String str) {
        f2641 = (f2639 + 43) % 128;
        try {
            HttpURLConnection httpURLConnectionM2601 = m2601(str);
            long jM2805 = jv.m2805();
            String strM2595 = m2595(httpURLConnectionM2601);
            int responseCode = httpURLConnectionM2601.getResponseCode();
            String responseMessage = httpURLConnectionM2601.getResponseMessage();
            if (responseCode >= 400) {
                int i2 = f2639 + 3;
                f2641 = i2 % 128;
                if (i2 % 2 == 0) {
                    httpURLConnectionM2601.disconnect();
                    throw null;
                }
                httpURLConnectionM2601.disconnect();
            }
            return new ir(strM2595, responseCode, responseMessage, jv.m2805() - jM2805);
        } catch (Throwable th) {
            String strIntern = m2594("䒝ᑟ붅ᩈ䓓햪㻑庭䊩폦㒉僋", View.getDefaultSize(0, 0)).intern();
            StringBuilder sb = new StringBuilder();
            sb.append(m2594("൞恶\ue3ab炨ഛꆔ惹㑷୬Ꞇ檸㨽ư긂汢⇶Ό됆瘬➽ᐪ뫆翹\u2d7dቯ胓䆮ጫ⢪蝜䬫", ViewConfiguration.getEdgeSlop() >> 16).intern());
            sb.append(th.getLocalizedMessage());
            k.m2861(strIntern, sb.toString(), th);
            return null;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static byte[] m2603(byte[] bArr) throws Throwable {
        GZIPOutputStream gZIPOutputStream = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(bArr);
                    gZIPOutputStream2.flush();
                    gZIPOutputStream2.close();
                    return byteArrayOutputStream.toByteArray();
                } catch (Exception e) {
                    e = e;
                    gZIPOutputStream = gZIPOutputStream2;
                    throw new RuntimeException(e);
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                            f2639 = (f2641 + 69) % 128;
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static byte[] m2598(HttpURLConnection httpURLConnection, JSONObject jSONObject) throws Throwable {
        String strM2600 = m2600(jSONObject);
        byte[] bytes = strM2600.getBytes(m2594("㟺襔࿀㨭㞯䢐貦纰ㆂ", (-1) - TextUtils.indexOf((CharSequence) "", '0', 0)).intern());
        if (!m2602(strM2600)) {
            return bytes;
        }
        f2639 = (f2641 + 37) % 128;
        httpURLConnection.setRequestProperty(m2605("頎⧓﯁跪忬\ue196뎟䗷ក\ud95a歄㵹콥鄙⌍\uf535", 45553 - Color.blue(0)).intern(), m2594("䷞⑅讲\uf7b2䶹\ue5afࣻ덲", TextUtils.getTrimmedLength("")).intern());
        byte[] bArrM2603 = m2603(bytes);
        f2639 = (f2641 + 9) % 128;
        return bArrM2603;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static void m2606(Closeable closeable) {
        int i2 = (f2641 + 89) % 128;
        f2639 = i2;
        if (closeable != null) {
            int i8 = i2 + 73;
            f2641 = i8 % 128;
            try {
                if (i8 % 2 != 0) {
                    closeable.close();
                    f2641 = (f2639 + 25) % 128;
                } else {
                    closeable.close();
                    throw null;
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static HttpURLConnection m2601(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod(m2605("頊⎙\uef3b", 48017 - View.MeasureSpec.getMode(0)).intern());
        f2641 = (f2639 + 47) % 128;
        return httpURLConnection;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static HttpURLConnection m2596(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod(m2594("絽쏁精ဂ紭Ȟ祮哦", ViewConfiguration.getEdgeSlop() >> 16).intern());
        httpURLConnection.setRequestProperty(m2605("頎⟿\ue799Ɪ杜❲\ue717ꝫ曱⛱\ue69fꙗ", TextUtils.indexOf("", "", 0, 0) + 49117).intern(), m2605("頬\ud9d2ᯣ巬龘톅Ꮆ喰靜쥅୵䴧輓석̰䔢蚆\uf8b2㫠粘뺀\uf0a4㊴瑑뙑\ue827⩾氌긏\ue073≷", (ViewConfiguration.getLongPressTimeout() >> 16) + 16879).intern());
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setReadTimeout(60000);
        int i2 = f2641 + 75;
        f2639 = i2 % 128;
        if (i2 % 2 == 0) {
            return httpURLConnection;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2605(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (j.f2671) {
            try {
                j.f2669 = i2;
                char[] cArr2 = new char[cArr.length];
                j.f2670 = 0;
                while (true) {
                    int i8 = j.f2670;
                    if (i8 < cArr.length) {
                        cArr2[i8] = (char) (((long) (cArr[i8] ^ (j.f2669 * i8))) ^ f2638);
                        j.f2670++;
                    } else {
                        str2 = new String(cArr2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m2600(JSONObject jSONObject) {
        String string = jSONObject.toString();
        String strM2809 = jw.m2809(string);
        StringBuilder sbR = androidx.camera.core.processing.util.a.r(string.substring(0, string.lastIndexOf(Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE)));
        sbR.append(m2594("ᡨ뗽ᥦ㣋ᡄ瑏騮簈Ḋ爗逤", TextUtils.lastIndexOf("", '0', 0) + 1).intern());
        sbR.append(strM2809);
        String strZ = com.google.android.gms.ads.internal.client.a.z(sbR, m2594("\ue675\u1aae呭ᐃ\ue657\udb43", ViewConfiguration.getWindowTouchSlop() >> 8));
        f2639 = (f2641 + 77) % 128;
        return strZ;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2595(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        BufferedReader bufferedReader;
        StringBuffer stringBuffer;
        String string = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            bufferedReader = null;
        }
        try {
            stringBuffer = new StringBuffer();
            f2639 = (f2641 + 93) % 128;
        } catch (Throwable th3) {
            th = th3;
            try {
                k.m2861(m2594("䒝ᑟ붅ᩈ䓓햪㻑庭䊩폦㒉僋", View.combineMeasuredStates(0, 0)).intern(), m2594("킡喟郍駱탤鑽\u139f뷅횓鉯\u19ca뎏\udc55鯻ἄꡄ숆臯՟긏짒轿ಂ꓄쾒딪", ViewConfiguration.getDoubleTapTimeout() >> 16).intern(), th);
            } finally {
                m2606(inputStream);
                m2606(bufferedReader);
            }
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            if (stringBuffer.length() > 0) {
                stringBuffer.append('\r');
                f2639 = (f2641 + 41) % 128;
            }
            stringBuffer.append(line);
            return string;
        }
        string = stringBuffer.toString();
        return string;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static String m2593(ir irVar) {
        int i2 = f2641 + 53;
        f2639 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
        if (irVar == null) {
            return null;
        }
        String strM2556 = irVar.m2556();
        int i8 = f2641 + 23;
        f2639 = i8 % 128;
        if (i8 % 2 == 0) {
            return strM2556;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2594(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (i.f2441) {
            try {
                char[] cArrM2497 = i.m2497(f2640, cArr, i2);
                i.f2442 = 4;
                while (true) {
                    int i8 = i.f2442;
                    if (i8 < cArrM2497.length) {
                        i.f2443 = i8 - 4;
                        cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f2640));
                        i.f2442 = i8 + 1;
                    } else {
                        str2 = new String(cArrM2497, 4, cArrM2497.length - 4);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }
}
