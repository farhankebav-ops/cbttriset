package com.ironsource.adqualitysdk.sdk.i;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.vungle.ads.internal.protos.Sdk;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ii {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static byte[] f2534 = null;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static short[] f2535 = null;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static int f2536 = 1;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f2537;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static int f2538;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f2539;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static final String[] f2540;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f2541;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private final b f2542;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private final SQLiteDatabase f2543;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class b extends SQLiteOpenHelper {

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private static int f2544 = 0;

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private static long f2545 = -1962244487376634150L;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private static int f2546 = 1;

        public b(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        }

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private static String m2534(String str, int i2) {
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
                            cArr2[i8] = (char) (((long) (cArr[i8] ^ (j.f2669 * i8))) ^ f2545);
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

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            int i2 = f2544 + 65;
            f2546 = i2 % 128;
            if (i2 % 2 == 0) {
                sQLiteDatabase.isReadOnly();
                throw null;
            }
            if (!sQLiteDatabase.isReadOnly()) {
                sQLiteDatabase.execSQL(m2534("纊罗紥笀秫矀痀玥灍湿氉樦棉曧撷抠捏慬彉崘寸", KeyEvent.getDeadChar(0, 0) + 479).intern());
                f2546 = (f2544 + 43) % 128;
            }
            sQLiteDatabase.execSQL(m2534("纙샷ɡ䗦蝲웤ࠀ䯷赣쳯\u0e60凪錎틠ᑮ型饤\ud8fa᩠嶗齳\udee9⁹揠ꕦ\ue4ee☜槔ꭈ\ueae6ⱋ濏녕\uf0f7㉡疯띭\uf6e4㡹箣뵖ﳈ㹔臛쌮˙䑚蟂쥇ࣔ䩆跎켶\u0eda偕鏊픾ᒽ噪駾\udb72᪹屌鿞\ue142₱才", 48767 - ExpandableListView.getPackedPositionType(0L)).intern());
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i8) {
            int i9 = f2546 + 31;
            f2544 = i9 % 128;
            if (i9 % 2 != 0) {
                throw null;
            }
        }
    }

    static {
        m2528();
        f2540 = new String[]{m2527((-35) - TextUtils.getCapsMode("", 0, 0), (short) (TextUtils.getTrimmedLength("") + 24), (-159487865) - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (byte) (TextUtils.lastIndexOf("", '0') + 1), 172712483 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))).intern(), m2527((ViewConfiguration.getTapTimeout() >> 16) - 35, (short) ((ViewConfiguration.getTapTimeout() >> 16) - 8), View.resolveSize(0, 0) - 159487882, (byte) View.MeasureSpec.makeMeasureSpec(0, 0), (ViewConfiguration.getTouchSlop() >> 8) + 172712495).intern()};
        int i2 = f2537 + 105;
        f2536 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    public ii(Context context, String str) {
        b bVar = new b(context, str);
        this.f2542 = bVar;
        this.f2543 = bVar.getWritableDatabase();
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m2527(int i2, short s7, int i8, byte b8, int i9) {
        String string;
        synchronized (n.f2979) {
            try {
                StringBuilder sb = new StringBuilder();
                int i10 = f2541;
                int i11 = i2 + i10;
                int i12 = i11 == -1 ? 1 : 0;
                if (i12 != 0) {
                    byte[] bArr = f2534;
                    i11 = bArr != null ? (byte) (bArr[f2539 + i8] + i10) : (short) (f2535[f2539 + i8] + i10);
                }
                if (i11 > 0) {
                    n.f2984 = ((i8 + i11) - 2) + f2539 + i12;
                    n.f2982 = b8;
                    char c7 = (char) (i9 + f2538);
                    n.f2981 = c7;
                    sb.append(c7);
                    n.f2980 = n.f2981;
                    n.f2983 = 1;
                    while (n.f2983 < i11) {
                        byte[] bArr2 = f2534;
                        if (bArr2 != null) {
                            int i13 = n.f2984;
                            n.f2984 = i13 - 1;
                            n.f2981 = (char) (n.f2980 + (((byte) (bArr2[i13] + s7)) ^ n.f2982));
                        } else {
                            short[] sArr = f2535;
                            int i14 = n.f2984;
                            n.f2984 = i14 - 1;
                            n.f2981 = (char) (n.f2980 + (((short) (sArr[i14] + s7)) ^ n.f2982));
                        }
                        sb.append(n.f2981);
                        n.f2980 = n.f2981;
                        n.f2983++;
                    }
                }
                string = sb.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
        return string;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static void m2528() {
        f2539 = 159487882;
        f2541 = 34;
        f2538 = -172712377;
        f2534 = new byte[]{-31, 19, -13, -27, -107, 89, -109, 29, -118, 112, -26, 56, 72, 64, 70, 89, 46, 80, -31, -4, -30, -29, 40, -22, 58, 32, -24, -2, -70, -39, -31, -36, 11, -122, -13, -39, -24, -95, -17, -49, 50, -72, -22, -35, -22, -16};
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final synchronized void m2531(String str, String str2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(m2527((-34) - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (short) (ImageFormat.getBitsPerPixel(0) - 7), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) - 159487882, (byte) ExpandableListView.getPackedPositionGroup(0L), (ViewConfiguration.getEdgeSlop() >> 16) + 172712495).intern(), str2);
            if (this.f2543.update(m2527(View.MeasureSpec.getMode(0) - 35, (short) ((ViewConfiguration.getTapTimeout() >> 16) - 69), (-159487872) - (Process.myTid() >> 22), (byte) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 172712483).intern(), contentValues, m2527((-35) - View.resolveSize(0, 0), (short) ((-117) - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), TextUtils.getCapsMode("", 0, 0) - 159487879, (byte) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), 172712485 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))).intern(), new String[]{str}) == 0) {
                f2537 = (f2536 + 51) % 128;
                contentValues.put(m2527((-35) - (ViewConfiguration.getFadingEdgeLength() >> 16), (short) (TextUtils.indexOf("", "", 0, 0) + 24), (ViewConfiguration.getEdgeSlop() >> 16) - 159487864, (byte) (TextUtils.lastIndexOf("", '0', 0) + 1), Color.argb(0, 0, 0, 0) + 172712484).intern(), str);
                this.f2543.replace(m2527((-35) - KeyEvent.getDeadChar(0, 0), (short) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) - 69), TextUtils.indexOf("", "", 0, 0) - 159487872, (byte) ((-1) - ImageFormat.getBitsPerPixel(0)), Gravity.getAbsoluteGravity(0, 0) + 172712484).intern(), null, contentValues);
            }
            int i2 = f2536 + 3;
            f2537 = i2 % 128;
            if (i2 % 2 != 0) {
                int i8 = 26 / 0;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final synchronized void m2532(String str) {
        f2536 = (f2537 + 57) % 128;
        this.f2543.delete(m2527((-35) - View.MeasureSpec.getMode(0), (short) (View.combineMeasuredStates(0, 0) - 69), (ViewConfiguration.getKeyRepeatDelay() >> 16) - 159487872, (byte) (ViewConfiguration.getEdgeSlop() >> 16), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 172712484).intern(), m2527(MotionEvent.axisFromString("") - 34, (short) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) - 38), (ViewConfiguration.getKeyRepeatTimeout() >> 16) - 159487861, (byte) ('0' - AndroidCharacter.getMirror('0')), 172712484 - ((Process.getThreadPriority(0) + 20) >> 6)).intern(), new String[]{str});
        f2536 = (f2537 + 113) % 128;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final synchronized int m2533(String str) {
        f2537 = (f2536 + 75) % 128;
        Cursor cursorQuery = null;
        try {
            cursorQuery = this.f2543.query(m2527((-35) - View.MeasureSpec.getMode(0), (short) (TextUtils.getTrimmedLength("") - 69), KeyEvent.getDeadChar(0, 0) - 159487872, (byte) View.MeasureSpec.makeMeasureSpec(0, 0), 172712485 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))).intern(), new String[]{m2527((-35) - ExpandableListView.getPackedPositionType(0L), (short) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 28), ImageFormat.getBitsPerPixel(0) - 159487845, (byte) TextUtils.getOffsetBefore("", 0), 172712444 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))).intern()}, m2527(Color.alpha(0) - 35, (short) (33 - View.getDefaultSize(0, 0)), (-159487856) - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (byte) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1), 172712484 - ExpandableListView.getPackedPositionType(0L)).intern(), new String[]{str.replace('*', '%')}, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                int i2 = cursorQuery.getInt(0);
                cursorQuery.close();
                return i2;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            f2537 = (f2536 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
            return 0;
        } finally {
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final synchronized String m2529(String str) {
        Cursor cursor = null;
        try {
            Cursor cursorQuery = this.f2543.query(m2527((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) - 35, (short) ((-69) - TextUtils.getCapsMode("", 0, 0)), (-159487871) - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (byte) (ViewConfiguration.getKeyRepeatDelay() >> 16), 172712483 - ExpandableListView.getPackedPositionChild(0L)).intern(), f2540, m2527(View.MeasureSpec.getMode(0) - 35, (short) (View.resolveSizeAndState(0, 0, 0) - 118), (ViewConfiguration.getPressedStateDuration() >> 16) - 159487879, (byte) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1), 172712484 - View.resolveSizeAndState(0, 0, 0)).intern(), new String[]{str}, null, null, null);
            if (cursorQuery != null) {
                f2537 = (f2536 + 49) % 128;
                try {
                    if (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(m2527(TextUtils.indexOf("", "", 0, 0) - 35, (short) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) - 8), Color.argb(0, 0, 0, 0) - 159487882, (byte) ((-1) - MotionEvent.axisFromString("")), View.MeasureSpec.getSize(0) + 172712495).intern()));
                        int i2 = f2537 + 79;
                        f2536 = i2 % 128;
                        if (i2 % 2 != 0) {
                            cursorQuery.close();
                            return string;
                        }
                        cursorQuery.close();
                        throw null;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                        f2536 = (f2537 + 73) % 128;
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final synchronized HashMap<String, String> m2530(String str, int i2) {
        String string;
        HashMap<String, String> map;
        f2537 = (f2536 + 95) % 128;
        Cursor cursorQuery = null;
        try {
            String strReplace = str.replace('*', '%');
            String strIntern = m2527((-36) - TextUtils.indexOf((CharSequence) "", '0'), (short) ('Q' - AndroidCharacter.getMirror('0')), (-159487856) - TextUtils.getOffsetAfter("", 0), (byte) Color.blue(0), 172712484 - TextUtils.getCapsMode("", 0, 0)).intern();
            String[] strArr = {strReplace};
            if (i2 <= 0) {
                f2537 = (f2536 + 77) % 128;
                string = null;
            } else {
                string = Integer.toString(i2);
            }
            cursorQuery = this.f2543.query(m2527((-35) - TextUtils.getCapsMode("", 0, 0), (short) ((-69) - (ViewConfiguration.getWindowTouchSlop() >> 8)), TextUtils.lastIndexOf("", '0', 0) - 159487871, (byte) TextUtils.indexOf("", "", 0), (ViewConfiguration.getJumpTapTimeout() >> 16) + 172712484).intern(), f2540, strIntern, strArr, null, null, null, string);
            map = new HashMap<>();
            while (cursorQuery != null) {
                if (!cursorQuery.moveToNext()) {
                    break;
                }
                try {
                    map.put(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(m2527((ViewConfiguration.getMinimumFlingVelocity() >> 16) - 35, (short) (24 - (Process.myPid() >> 22)), (-159487864) - View.MeasureSpec.makeMeasureSpec(0, 0), (byte) (ViewConfiguration.getPressedStateDuration() >> 16), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 172712485).intern())), cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(m2527((-34) - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (short) ((-9) - TextUtils.lastIndexOf("", '0', 0, 0)), (-159487882) - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (byte) Color.green(0), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 172712495).intern())));
                } catch (IllegalArgumentException unused) {
                }
            }
            if (cursorQuery != null) {
                f2536 = (f2537 + 19) % 128;
                cursorQuery.close();
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
        return map;
    }
}
