package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.camera.core.processing.util.a;
import androidx.webkit.ProxyConfig;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class es {
    private static volatile es EO;
    private Map<String, String> IlO;
    private volatile boolean MY = false;
    private Context tV;

    private es(Context context) {
        if (context != null && this.tV == null) {
            this.tV = context.getApplicationContext();
            IlO();
        }
        this.tV = context;
    }

    private static String Cc(String str) {
        int iIndexOf;
        return (str == null || str.isEmpty() || (iIndexOf = str.indexOf(46)) < 0 || iIndexOf >= str.length() + (-1)) ? "" : str.substring(iIndexOf + 1);
    }

    private static boolean EO(String str) {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (!IlO(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    private static String MY(String str) {
        int iIndexOf = str.indexOf(47);
        int iIndexOf2 = str.indexOf(59);
        if (iIndexOf < 0) {
            return null;
        }
        String strTrim = str.substring(0, iIndexOf).trim();
        Locale locale = Locale.ENGLISH;
        String lowerCase = strTrim.toLowerCase(locale);
        if (!EO(lowerCase)) {
            return null;
        }
        int i2 = iIndexOf + 1;
        String lowerCase2 = (iIndexOf2 < 0 ? str.substring(i2) : str.substring(i2, iIndexOf2)).trim().toLowerCase(locale);
        if (!EO(lowerCase2)) {
            return null;
        }
        StringBuilder sb = new StringBuilder(a.D(lowerCase.length(), 1, lowerCase2));
        sb.append(lowerCase);
        sb.append('/');
        sb.append(lowerCase2);
        return sb.toString();
    }

    private String tV(String str) {
        String str2;
        String strCc = Cc(str);
        if (strCc.isEmpty()) {
            return null;
        }
        IlO();
        Map<String, String> map = this.IlO;
        if (map == null || map.isEmpty()) {
            return null;
        }
        do {
            str2 = this.IlO.get(strCc);
            if (str2 == null) {
                strCc = Cc(strCc);
            }
            if (str2 != null) {
                break;
            }
        } while (!strCc.isEmpty());
        return str2;
    }

    private void vCE(String str) {
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return;
        }
        if (strTrim.charAt(0) == '#') {
            return;
        }
        String strReplaceAll = strTrim.replaceAll("\\s*#.*", "");
        if (strReplaceAll.indexOf(61) <= 0) {
            String[] strArrSplit = strReplaceAll.split("\\s+");
            for (int i2 = 1; i2 < strArrSplit.length; i2++) {
                IlO(strArrSplit[i2], strArrSplit[0]);
            }
            return;
        }
        Matcher matcher = Pattern.compile("\\btype=(\"\\p{Graph}+?/\\p{Graph}+?\"|\\p{Graph}+/\\p{Graph}+\\b)").matcher(strReplaceAll);
        if (matcher.find()) {
            String strSubstring = matcher.group().substring(5);
            if (strSubstring.charAt(0) == '\"') {
                strSubstring = strSubstring.substring(1, strSubstring.length() - 1);
            }
            Matcher matcher2 = Pattern.compile("\\bexts=(\"[\\p{Graph}|\\p{Blank}]+?\"|\\p{Graph}+\\b)").matcher(strReplaceAll);
            if (matcher2.find()) {
                String strSubstring2 = matcher2.group().substring(5);
                if (strSubstring2.charAt(0) == '\"') {
                    strSubstring2 = strSubstring2.substring(1, strSubstring2.length() - 1);
                }
                for (String str2 : strSubstring2.split("[\\p{Blank}|\\p{Punct}]+")) {
                    IlO(str2, strSubstring);
                }
            }
        }
    }

    public static String IlO(Context context, String str) {
        if (str != null) {
            try {
                if (str.startsWith(ProxyConfig.MATCH_HTTP) && str.contains("?")) {
                    str = str.split("\\?")[0];
                    if (str.endsWith("/")) {
                        str = str.substring(0, str.length() - 1);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return IlO(context).IlO(str);
    }

    public static es IlO(Context context) {
        if (EO == null) {
            synchronized (es.class) {
                try {
                    if (EO == null) {
                        EO = new es(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return EO;
    }

    public final String IlO(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strTV = tV(str);
        if (TextUtils.isEmpty(strTV)) {
            return null;
        }
        return MY(strTV);
    }

    private static boolean IlO(char c7) {
        return c7 > ' ' && c7 < 127 && "()<>@,;:/[]?=\\\"".indexOf(c7) < 0;
    }

    private void IlO() {
        if (this.tV == null || this.MY) {
            return;
        }
        synchronized (this) {
            try {
                if (!this.MY) {
                    List list = (List) AccessController.doPrivileged(new PrivilegedAction<List<String>>() { // from class: com.bytedance.sdk.component.utils.es.1
                        @Override // java.security.PrivilegedAction
                        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
                        public List<String> run() {
                            BufferedReader bufferedReader;
                            InputStream inputStream = null;
                            try {
                                ArrayList arrayList = new ArrayList();
                                InputStream inputStreamOpen = es.this.tV.getAssets().open("tt_mime_type.pro");
                                try {
                                    bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen));
                                    while (true) {
                                        try {
                                            String line = bufferedReader.readLine();
                                            if (line == null) {
                                                break;
                                            }
                                            if (!TextUtils.isEmpty(line)) {
                                                arrayList.add(line);
                                            }
                                        } catch (Throwable unused) {
                                            inputStream = inputStreamOpen;
                                            try {
                                                List<String> list2 = Collections.EMPTY_LIST;
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (Throwable unused2) {
                                                    }
                                                }
                                                if (bufferedReader != null) {
                                                    try {
                                                        bufferedReader.close();
                                                    } catch (Throwable unused3) {
                                                    }
                                                }
                                                return list2;
                                            } finally {
                                            }
                                        }
                                    }
                                    if (inputStreamOpen != null) {
                                        try {
                                            inputStreamOpen.close();
                                        } catch (Throwable unused4) {
                                        }
                                    }
                                    try {
                                        bufferedReader.close();
                                    } catch (Throwable unused5) {
                                    }
                                    return arrayList;
                                } catch (Throwable unused6) {
                                    bufferedReader = null;
                                }
                            } catch (Throwable unused7) {
                                bufferedReader = null;
                            }
                        }
                    });
                    this.IlO = new HashMap(list.size());
                    String strSubstring = "";
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        String str = strSubstring + ((String) it.next());
                        if (str.endsWith("\\")) {
                            strSubstring = str.substring(0, str.length() - 1);
                        } else {
                            vCE(str);
                            strSubstring = "";
                        }
                    }
                    if (!strSubstring.isEmpty()) {
                        vCE(strSubstring);
                    }
                    this.MY = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void IlO(String str, String str2) {
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty() || this.IlO.containsKey(str)) {
            return;
        }
        this.IlO.put(str, str2);
    }
}
