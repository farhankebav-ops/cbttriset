package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.FrameMetricsAggregator;
import com.amazon.aps.ads.Aps;
import com.amazon.aps.ads.ApsAd;
import com.amazon.aps.ads.ApsAdController;
import com.amazon.aps.ads.ApsAdRequest;
import com.amazon.aps.ads.ApsAdView;
import com.amazon.aps.ads.activity.ApsAdActivity;
import com.amazon.aps.ads.activity.ApsInterstitialActivity;
import com.amazon.aps.ads.listeners.ApsAdListener;
import com.amazon.aps.ads.listeners.ApsAdRequestListener;
import com.amazon.aps.ads.model.ApsAdFormat;
import com.amazon.aps.ads.model.ApsAdType;
import com.amazon.device.ads.AdRegistration;
import com.amazon.device.ads.AdType;
import com.amazon.device.ads.DTBActivity;
import com.amazon.device.ads.DTBAdActivity;
import com.amazon.device.ads.DTBAdBannerListener;
import com.amazon.device.ads.DTBAdBaseBannerListener;
import com.amazon.device.ads.DTBAdBaseInterstitialListener;
import com.amazon.device.ads.DTBAdCallback;
import com.amazon.device.ads.DTBAdExpandedListener;
import com.amazon.device.ads.DTBAdInterstitial;
import com.amazon.device.ads.DTBAdInterstitialListener;
import com.amazon.device.ads.DTBAdListener;
import com.amazon.device.ads.DTBAdLoader;
import com.amazon.device.ads.DTBAdRequest;
import com.amazon.device.ads.DTBAdResponse;
import com.amazon.device.ads.DTBAdSize;
import com.amazon.device.ads.DTBAdView;
import com.amazon.device.ads.DTBAdViewSupportClient;
import com.amazon.device.ads.DTBFetchFactory;
import com.amazon.device.ads.DTBFetchManager;
import com.amazon.device.ads.DTBInterstitialActivity;
import com.amazon.device.ads.DTBRenderer;
import com.ironsource.adqualitysdk.sdk.i.bg;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class bi extends bg {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f811 = 0;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static long f812 = 0;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f813 = 1;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static char[] f814;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class c extends ThreadPoolExecutor implements hc<ThreadPoolExecutor>, AutoCloseable {

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private static int f838 = 1;

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private static int f839 = 0;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private static int f840 = 45;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private ch f841;

        /* JADX WARN: Illegal instructions before constructor call */
        public c(ThreadPoolExecutor threadPoolExecutor, ch chVar) {
            int corePoolSize = threadPoolExecutor.getCorePoolSize();
            int maximumPoolSize = threadPoolExecutor.getMaximumPoolSize();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            super(corePoolSize, maximumPoolSize, threadPoolExecutor.getKeepAliveTime(timeUnit), timeUnit, threadPoolExecutor.getQueue());
            this.f841 = chVar;
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private ThreadPoolExecutor m937() {
            int i2 = f838 + 25;
            f839 = i2 % 128;
            if (i2 % 2 != 0) {
                int i8 = 10 / 0;
            }
            return this;
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static String m938(int i2, int i8, String str, int i9, boolean z2) {
            String str2;
            Object charArray = str;
            if (str != null) {
                charArray = str.toCharArray();
            }
            char[] cArr = (char[]) charArray;
            synchronized (com.ironsource.adqualitysdk.sdk.i.e.f1927) {
                try {
                    char[] cArr2 = new char[i8];
                    com.ironsource.adqualitysdk.sdk.i.e.f1926 = 0;
                    while (true) {
                        int i10 = com.ironsource.adqualitysdk.sdk.i.e.f1926;
                        if (i10 >= i8) {
                            break;
                        }
                        com.ironsource.adqualitysdk.sdk.i.e.f1929 = cArr[i10];
                        cArr2[com.ironsource.adqualitysdk.sdk.i.e.f1926] = (char) (com.ironsource.adqualitysdk.sdk.i.e.f1929 + i2);
                        int i11 = com.ironsource.adqualitysdk.sdk.i.e.f1926;
                        cArr2[i11] = (char) (cArr2[i11] - f840);
                        com.ironsource.adqualitysdk.sdk.i.e.f1926 = i11 + 1;
                    }
                    if (i9 > 0) {
                        com.ironsource.adqualitysdk.sdk.i.e.f1928 = i9;
                        char[] cArr3 = new char[i8];
                        System.arraycopy(cArr2, 0, cArr3, 0, i8);
                        int i12 = com.ironsource.adqualitysdk.sdk.i.e.f1928;
                        System.arraycopy(cArr3, 0, cArr2, i8 - i12, i12);
                        int i13 = com.ironsource.adqualitysdk.sdk.i.e.f1928;
                        System.arraycopy(cArr3, i13, cArr2, 0, i8 - i13);
                    }
                    if (z2) {
                        char[] cArr4 = new char[i8];
                        com.ironsource.adqualitysdk.sdk.i.e.f1926 = 0;
                        while (true) {
                            int i14 = com.ironsource.adqualitysdk.sdk.i.e.f1926;
                            if (i14 >= i8) {
                                break;
                            }
                            cArr4[i14] = cArr2[(i8 - i14) - 1];
                            com.ironsource.adqualitysdk.sdk.i.e.f1926 = i14 + 1;
                        }
                        cArr2 = cArr4;
                    }
                    str2 = new String(cArr2);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return str2;
        }

        @Override // java.lang.AutoCloseable
        public final /* synthetic */ void close() {
            androidx.appcompat.app.c.v(this);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            f838 = (f839 + 49) % 128;
            bi.this.m885(this, this.f841, m938(146 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 'I' - AndroidCharacter.getMirror('0'), "\uffff\u0005\u0012\u000e\u0001\uffef\u000e\u000b\u0010\u0011\uffff\u0001\u0014￡\uffde\ufff0\u0001\u0010\u0011\uffff\u0001\u0014\u0001ￊ\u0001", TextUtils.getTrimmedLength("") + 16, true).intern(), runnable);
            super.execute(runnable);
            f839 = (f838 + 69) % 128;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.hc
        /* JADX INFO: renamed from: ｋ */
        public final /* synthetic */ ThreadPoolExecutor mo831() {
            f839 = (f838 + 39) % 128;
            ThreadPoolExecutor threadPoolExecutorM937 = m937();
            f838 = (f839 + 15) % 128;
            return threadPoolExecutorM937;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class e extends HashMap<String, DTBFetchManager> implements hc<HashMap<String, DTBFetchManager>> {

        /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
        private static boolean f843 = true;

        /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
        private static int f844 = 0;

        /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
        private static int f845 = 1;

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private static char[] f846 = {260, 276, 258, 262, 293, 308, 291, 296, 269, 289, 302, 295, 306, 299, 264, 307, 304, 238, 309};

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private static boolean f847 = true;

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static int f848 = 192;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private ch f849;

        public e(HashMap<String, DTBFetchManager> map, ch chVar) {
            super(map);
            this.f849 = chVar;
        }

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private HashMap<String, DTBFetchManager> m940() {
            int i2 = f845 + 25;
            f844 = i2 % 128;
            if (i2 % 2 == 0) {
                return this;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private DTBFetchManager m941(String str, DTBFetchManager dTBFetchManager) {
            f844 = (f845 + 33) % 128;
            bi.this.m885(this, this.f849, m939(null, 127 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), null, "\u0086\u0093\u0091\u0092\u0091\u008a\u0089\u0088\u0090\u008a\u008f\u008e\u008d\u0085\u008c\u008a\u008b\u008a\u0089\u0088\u0087\u0086\u0085\u0084\u0083\u0082\u0081").intern(), str, dTBFetchManager);
            DTBFetchManager dTBFetchManager2 = (DTBFetchManager) super.put(str, dTBFetchManager);
            f845 = (f844 + 1) % 128;
            return dTBFetchManager2;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public /* synthetic */ Object put(Object obj, Object obj2) {
            int i2 = f844 + 49;
            f845 = i2 % 128;
            String str = (String) obj;
            DTBFetchManager dTBFetchManager = (DTBFetchManager) obj2;
            if (i2 % 2 != 0) {
                return m941(str, dTBFetchManager);
            }
            m941(str, dTBFetchManager);
            throw null;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.hc
        /* JADX INFO: renamed from: ｋ */
        public final /* synthetic */ HashMap<String, DTBFetchManager> mo831() {
            f844 = (f845 + 83) % 128;
            HashMap<String, DTBFetchManager> mapM940 = m940();
            f844 = (f845 + 93) % 128;
            return mapM940;
        }

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private static String m939(String str, int i2, int[] iArr, String str2) throws UnsupportedEncodingException {
            Object bytes = str2;
            if (str2 != null) {
                bytes = str2.getBytes("ISO-8859-1");
            }
            byte[] bArr = (byte[]) bytes;
            Object charArray = str;
            if (str != null) {
                charArray = str.toCharArray();
            }
            char[] cArr = (char[]) charArray;
            synchronized (m.f2978) {
                try {
                    char[] cArr2 = f846;
                    int i8 = f848;
                    if (f843) {
                        int length = bArr.length;
                        m.f2976 = length;
                        char[] cArr3 = new char[length];
                        m.f2977 = 0;
                        while (m.f2977 < m.f2976) {
                            int i9 = m.f2977;
                            int i10 = m.f2976 - 1;
                            int i11 = m.f2977;
                            cArr3[i9] = (char) (cArr2[bArr[i10 - i11] + i2] - i8);
                            m.f2977 = i11 + 1;
                        }
                        return new String(cArr3);
                    }
                    if (f847) {
                        int length2 = cArr.length;
                        m.f2976 = length2;
                        char[] cArr4 = new char[length2];
                        m.f2977 = 0;
                        while (m.f2977 < m.f2976) {
                            int i12 = m.f2977;
                            int i13 = m.f2976 - 1;
                            int i14 = m.f2977;
                            cArr4[i12] = (char) (cArr2[cArr[i13 - i14] - i2] - i8);
                            m.f2977 = i14 + 1;
                        }
                        return new String(cArr4);
                    }
                    int length3 = iArr.length;
                    m.f2976 = length3;
                    char[] cArr5 = new char[length3];
                    m.f2977 = 0;
                    while (m.f2977 < m.f2976) {
                        int i15 = m.f2977;
                        int i16 = m.f2976 - 1;
                        int i17 = m.f2977;
                        cArr5[i15] = (char) (cArr2[iArr[i16 - i17] - i2] - i8);
                        m.f2977 = i17 + 1;
                    }
                    return new String(cArr5);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    static {
        char[] cArr = new char[1191];
        a0.o("q¹\u0015Ä¹H\\Ôà(\u0087\u0096+%ÎöR\u0002ùý\u009d\u0004 \u008aÄ\u0011Âø¦¤\n\u0019ï·S:4\u008d\u0098\u001c}\u0082á\u0003J\u0099.w\u0093ãwzØò\u0000Dd-È°-*\u0091\u0087ö)Z¿¿9#¡\u00885ìÃ\u0000cd\u0016È\u009f-E\u0091\u0085ö0Z·¿5#§\u0088/ì\u0094QWµÉ\u001aS~÷ãtGõ¬'\u0010ãt\u009fÙ\u0007=Ã¢\"\u0006\u008bk\u001aÏ\u00904)\u0098·ýUaÃÆG*Ó\u008fY\"EF,ê±\u000f#³\u008bÔ(x²\u009d<\u0001ºª4ÎÒsF\u0097Ä8E\\óÁWeò\u008e|2êV\u008cû\u001c\u001f\u0098\u0080\u001e\u0000cd\u0016È\u009f-E\u0091\u0085ö0Z·¿5#§\u0088/ì\u0094QWµÉ\u001aS~÷ãtGõ¬'\u0010ãt\u009fÙ\u0007=Ã¢\"\u0006\u008bk\u001aÏ\u00984$\u0098·ýYaÇÆ]*Ó\u008fIóíX{¼ê!h\u0085<é\u0095N\u001b²\u0081\u0017\u0017{³à'Dµ\u0085oá\u0006M\u009b¨\u0001\u0014«s7ß\u009e:\u0010¦\u008a\r\u001ciøÔl0þ\u0000cd\u0016È\u009f-E\u0091\u0085ö0Z·¿5#§\u0088/ì\u0094QWµÉ\u001aS~÷ãtGõ¬'\u0010ãt\u009fÙ\u0007=Ã¢\"\u0006\u008bk\u001aÏ\u00904.\u0098\u0082ý_aÁÆG*Ñ\u008fIóíXk\u0000Dd-È°-*\u0091\u0080ö\u0014Z¸¿;#\u00ad\u00883ìÉQGµÅ\u001aQ~÷ãvGüÄ\u0010 y\fäé~UÔ2E\u009eí{zçøLp(\u009c\u000e\u009djôÆi#ó\u009fYøÖTj±ç-d\u0086ýâ\u0010_\u009e©YÍ0a\u00ad\u008478\u009d_\u0012ó®\u0016!\u008a¥!3EÉø]\u001cÔ\u0000Dd-È°-*\u0091\u0080ö\u000bZ¿¿*#¿\u0000cd\u0016È\u009f-E\u0091\u0085ö0Z·¿5#§\u0088/ì\u0094QWµÉ\u001aS~÷ãtGõ¬'\u0010ãt\u009fÙ\u0007=Ã¢\"\u0006\u008bk\u001aÏ\u00904.\u0098\u0095ýUaÐÆYÐÃ´ª\u00187ý\u00adA\u0007&\u0089\u008a8o²ó*\u0005Úa³Í.(´\u0094\u001eó\u0095_!º´&!\u008d\u008céQTÝ°B\u001fÔ{ræýBM©û\u0015uq\u0000Ü\u00848\u0007Ýg¹\u000e\u0015\u0093ð\u000eL¢+\n\u0087\u0096b\u0004þ\u00adU\u00031ú\u008cdhàÇt£Äø\t\u009c`0ýÕ`iÌ\u000ed¢øGjÛÈpm\u0014\u0099©\u001fM\u0086â\r\u0086¡:å^\u008cò\u0011\u0017\u0098« Ì\u0092`\u0013\u0085\u008b\u0019\u001b²\u0085Öi\u0000Dd-È°-*\u0091\u0080ö\u001fZ·¿!#¦\u0088$ìÈQ\u007fµÅ\u001aV~êãrGþ¬l\u0010ð\u0000Dd-È°-*\u0091\u0080ö\u001fZ·¿<#\u00ad\u0088\u0003ìÛQ]µÂ\u001a@~ìã[Gù¬z\u0010öt\u009eÙ\u001a=\u0088¢\u0014\u0000Dd-È°-*\u0091\u0080ö\u001fZ·¿<#\u00ad\u0088\bìÔQGµÉ\u001aW~íãcGù¬}\u0010ët\u009aÙ\u0018=¡¢\u000f\u0006¬k,Ï´4$\u0098¦ýN\u0000Dd-È°-*\u0091\u0080ö\u001eZ·¿##¤\u0088#ìÛQPµÇi\u0004\rm¡ðDjøÀ\u009fX3îÖ\u007fJéáo\u0085\u009e8\u0016Ü\u0088s)\u0017·\u008a$.¤Å,y¬\u001dÞ°F2§VÎúS\u001fÉ£cÄ÷h[\u008dØ\u0011NºÐÞ*c¤\u0087&(²L\u0014Ñ\u0095u\u001f\u009e¦\"\bFkëã\u000fk\u0090ë4YYÉ\u0082,æEJØ¯B\u0013ètyØ×=T¡Ô\nLn¼Ó>7¶\u0000Td;È¿-\n\u0091\u008aö<Z±¿*#º\u0088\tìÛQ@µÄ\u001ah~ÿãg\u0000Td;È·-\u0013\u0091\u0081ö>Z£¿;#§\u00883ìéQVµÞ\u001aS~÷ãtGõ\u0000Ad\tÈ\u0081-\"\u0091\u008aö)Z³¿=#»\u00885ìÓQGµÅ\u001aD~òãVGó¬}\u0010ët\u008dÙ\u001d=\u0099¢\u001f\u0000cd\u0016È\u009f-E\u0091\u0085ö0Z·¿5#§\u0088/ì\u0094QRµÜ\u001aV~°ãvGô¬z\u0010¬t\u009aÙ\u0017=\u0099¢\u000f\u0006©k1Ï¥43\u0098íý}aÅÆ]*î\u008fNóíXw¼ù!w\u0085\té\u009fN\u001b²\u0081\u0017\u0000{¶à\u0012D¯©1\r×rAÖÙ;]\u009fÛ\u0000Ad\tÈ\u0081-*\u0091\u0080ö\u001cZµ¿;#¡\u00887ìÓQGµÕ\n^n+Â¢'x\u009b¸ü\rP\u008aµ\b)\u009a\u0082\u0012æ©[o¿á\u0010kt\u008déKMÉ¦G\u001a\u0091~§Ó*7¤¨2\f\u0094a\fÅ\u0098>\u000e\u0092Ð÷@køÌ` Û\u0085yùåRL¶Â+P\u008f6ã¢D&¸¬\u0000Ad\tÈ\u0081-*\u0091\u0080ö\u000bZ¿¿*#¿ô¦\u0090î<f\u0000Ad\tÈ\u0081-*\u0091\u0080çe\u0083-/¥Ê\u000ev¤\u0011:½\u009dX\u0005Ä\u0098o\u0017\u000bñ¶{Räýd\u0099È\u0000Ad\tÈ\u0081-*\u0091\u0080ö\u0011Z¿¿<#¼\u0088$ìÔQVµÞ\u000f\u0014k\\ÇÔ\"\u007f\u009eÕùZUæ°k,è\u0087qã\u009c^\u0012ºµ\u0015\u0019q¸ì6H £2\u001f²{ÜýV\u0099\u001e5\u0096Ð=l\u0097\u000b\f§®B*Þ²u7\u0011Ùû\u0005\u009fM3ÅÖnjÄ\rM¡ëD{Øé\u0000Ad\tÈ\u0081-*\u0091\u0080ö\u000fZ³¿>#½\u0088$ìÉQGã\u009d\u0087æ+|ÎÐrn\u0015×¹g\\ÐÀK\u0000gd\u001cÈ\u0086--\u0091\u0081ö)Zµ¿'#\u008e\u0088 ìÙQGµÃ\u001aW~çã^Gþ¬z\u0010öt\u009aÙ\u001a=\u008e¢\u0003\u001eÌz·Ö-3\u0081\u008f+è¤D\u0018¡\u0097=\u0013\u0096\u0085ò\u007fOë«b\u0004Ì`\\ýØYr²Æ\u0000gd\u001cÈ\u0086-*\u0091\u0080ö\u000fZ³¿<#¸\u0088.ìÔQ@µÉ\u001af~ìãrGñ¬}\u0010ët\u008dÙ\u0011=¤¢\u0002\u0000gd\u001cÈ\u0086-*\u0091\u0080ö\u000fZ³¿<#¸\u0088.ìÔQ@µÉ\u001al~óãgGâ¬l\u0010ñt\u0088Ù\u001d=\u0082¢\b\u0006\u008ak*Ï½\u0000gd\u001cÈ\u0086-*\u0091\u0080ö\u000fZ³¿<#¸\u0088.ìÔQ@µÉ\u001aw~ûãyGô¬l\u0010ðt\u0092Ù\u001a=\u008a¢+\u0006¾k(¼ÎØµt/\u0091\u0083-)J¦æ\u001a\u0003\u0095\u009f\u00114\u0087P}íé\t`¦ÞÂR_Ðû]\u0010Å¬YÈ;e³\u0081#\u001e\u008dº\u0003×\u009fs\u001c\u0088\u008f$\u000f\u0000gd\u001cÈ\u0086-/\u0091\u0081ö;Z·¿:#¤\u00885ììQZµÈ\u001a@~ñãVGô¬z\u0010Ðt\u009eÙ\u0005=\u0098¢\u0003\u0006¬k,Ï\u00924?\u0098°ýHaÚÆC*÷\u008fAóëXs¼æ!w\u0000gd\u001cÈ\u0086-*\u0091\u0080ö\u000fZ³¿<#¸\u0088.ìÔQ@µÉ\u001ad~úãd\u0000gd\u001cÈ\u0086-*\u0091\u0080ö\u000fZ³¿<#¸\u0088.ìÔQ@µÉ\u001au~ìã~Gó¬l\u0010Òt\u0094Ù\u001d=\u0083¢\u0012\u0004N`5Ì¯)\u0003\u0095©ò'^\u0096»\u001c'\u0084\u008c;èÿUu±ñ\u001eYzâçwCý\u0089\u009cíçA}¤Ñ\u0018{\u007fõÓD6ÎªV\u0001ûe%Ø\u009c<.\u0093®÷\u0000\u0000gd\u001cÈ\u0086-*\u0091\u0080ö\u000eZ¿¿5#\u00ad\u0088\u0011ìÏQQµÿ\u001a@~êãcGù¬g\u0010åt\u0088\u0000id\nÈ³-\u000f\u0091·ö4Z¬¿*#\u0081\u0088/ìÎQVµÞ\u001aV~êã~Gä¬`\u0010ãt\u0097Ù5=\u0089\u0000cd\u000bÈ\u0097-\n\u0091\u0090ö8Z\u0082¿\r#\u008e\u0088$ìÎQPµÄ\u001ac~ÿãtGä¬f\u0010ðt\u0082Ù9=\u008c¢\b\u0006¾k?Ï´48\u0098\u008eý]aÅ\u0000cd\u000bÈ\u0097-\n\u0091\u0090ö8Z\u0082¿\r#\u008d\u00889ìßQPµÙ\u001aQ~ñãeGÃ¬l\u0010ðt\u008dÙ\u001d=\u008e¢\u0003\u0000gd\u001cÈ\u0086-*\u0091\u0094ö.Z\u0097¿+#\u009a\u0088$ìËQFµÉ\u001aV~ê(yL\u0002à\u0098\u00057¹\u0093Þ'r\u0081\u0097?\u000b° 0\u0000gd\u001cÈ\u0086-;\u0091\u0096ö4Zµ¿*#\u0098\u0088.ìÓQ]µØ\u0000gd\u001cÈ\u0086-8\u0091\u0088ö2Z¢¿\u001a#½\u0088(ìÞ\u0000gd\u001cÈ\u0086-*\u0091\u0094ö.Z\u0097¿+#\u008e\u0088.ìÈQ^µÍ\u001aQ\u0000gd\u001cÈ\u0086-*\u0091\u0080ö\u0011Z¹¿.#¬\u0088$ìÈ\u0000gd\u001cÈ\u0086-*\u0091\u0080ö\u000bZ¿¿*#¿", "ISO-8859-1", cArr, 0, 1191);
        f814 = cArr;
        f812 = -8381553664943496071L;
    }

    public bi(String str) {
        super(str);
    }

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    private static DTBFetchFactory m891() {
        int i2 = f811 + 9;
        f813 = i2 % 128;
        if (i2 % 2 != 0) {
            return DTBFetchFactory.getInstance();
        }
        int i8 = 92 / 0;
        return DTBFetchFactory.getInstance();
    }

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private static String m892() {
        int i2 = f813 + 19;
        f811 = i2 % 128;
        if (i2 % 2 != 0) {
            AdRegistration.getAppKey();
            throw null;
        }
        String appKey = AdRegistration.getAppKey();
        int i8 = f811 + 59;
        f813 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 13 / 0;
        }
        return appKey;
    }

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    private static Map<String, String> m895(DTBAdResponse dTBAdResponse) {
        int i2 = f813 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE;
        f811 = i2 % 128;
        int i8 = i2 % 2;
        Map<String, String> defaultVideoAdsRequestCustomParams = dTBAdResponse.getDefaultVideoAdsRequestCustomParams();
        if (i8 != 0) {
            int i9 = 85 / 0;
        }
        f813 = (f811 + 43) % 128;
        return defaultVideoAdsRequestCustomParams;
    }

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private static Bundle m896(DTBAdResponse dTBAdResponse) {
        f813 = (f811 + 3) % 128;
        Bundle renderingBundle = dTBAdResponse.getRenderingBundle();
        f813 = (f811 + 81) % 128;
        return renderingBundle;
    }

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private static HashMap<String, Object> m899(DTBAdResponse dTBAdResponse) {
        f811 = (f813 + 93) % 128;
        HashMap<String, Object> renderingMap = dTBAdResponse.getRenderingMap();
        f813 = (f811 + 51) % 128;
        return renderingMap;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    public static /* synthetic */ DTBFetchFactory m900() {
        f813 = (f811 + 107) % 128;
        DTBFetchFactory dTBFetchFactoryM891 = m891();
        int i2 = f813 + 57;
        f811 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 26 / 0;
        }
        return dTBFetchFactoryM891;
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    public static /* synthetic */ DTBAdView m903(ApsAd apsAd) {
        f813 = (f811 + 39) % 128;
        DTBAdView dTBAdViewM897 = m897(apsAd);
        int i2 = f813 + 5;
        f811 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 18 / 0;
        }
        return dTBAdViewM897;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    public static /* synthetic */ ApsAdRequest m906(ApsAd apsAd) {
        int i2 = f813 + 35;
        f811 = i2 % 128;
        if (i2 % 2 == 0) {
            return m894(apsAd);
        }
        m894(apsAd);
        throw null;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public static /* synthetic */ String m910() {
        f811 = (f813 + 79) % 128;
        String strM892 = m892();
        int i2 = f813 + 83;
        f811 = i2 % 128;
        if (i2 % 2 == 0) {
            return strM892;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    public static /* synthetic */ List m914(DTBAdResponse dTBAdResponse) {
        int i2 = f811 + 59;
        f813 = i2 % 128;
        if (i2 % 2 != 0) {
            return m893(dTBAdResponse);
        }
        m893(dTBAdResponse);
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ AdType m915(DTBAdSize dTBAdSize) {
        f811 = (f813 + 51) % 128;
        AdType adTypeM907 = m907(dTBAdSize);
        int i2 = f811 + 25;
        f813 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 1 / 0;
        }
        return adTypeM907;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ Bundle m919(DTBAdResponse dTBAdResponse) {
        f813 = (f811 + 33) % 128;
        Bundle bundleM896 = m896(dTBAdResponse);
        int i2 = f811 + 107;
        f813 = i2 % 128;
        if (i2 % 2 != 0) {
            return bundleM896;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ ApsAdRequest m924(ApsAd apsAd) {
        int i2 = f813 + 113;
        f811 = i2 % 128;
        int i8 = i2 % 2;
        ApsAdRequest apsAdRequestM909 = m909(apsAd);
        if (i8 != 0) {
            int i9 = 47 / 0;
        }
        return apsAdRequestM909;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ ApsAdFormat m930(ApsAd apsAd) {
        f811 = (f813 + 109) % 128;
        ApsAdFormat apsAdFormatM890 = m890(apsAd);
        int i2 = f811 + 7;
        f813 = i2 % 128;
        if (i2 % 2 != 0) {
            return apsAdFormatM890;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ String m933(ApsAd apsAd) {
        f813 = (f811 + 47) % 128;
        String strM898 = m898(apsAd);
        int i2 = f813 + 113;
        f811 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 42 / 0;
        }
        return strM898;
    }

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    private static ApsAdFormat m890(ApsAd apsAd) {
        int i2 = f813 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
        f811 = i2 % 128;
        int i8 = i2 % 2;
        ApsAdFormat apsAdFormat = apsAd.getApsAdFormat();
        if (i8 != 0) {
            int i9 = 39 / 0;
        }
        return apsAdFormat;
    }

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private static List<DTBAdSize> m893(DTBAdResponse dTBAdResponse) {
        f811 = (f813 + 115) % 128;
        List<DTBAdSize> dTBAds = dTBAdResponse.getDTBAds();
        f813 = (f811 + 9) % 128;
        return dTBAds;
    }

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    private static ApsAdRequest m894(ApsAd apsAd) {
        int i2 = f813 + 107;
        f811 = i2 % 128;
        if (i2 % 2 == 0) {
            return apsAd.getAdLoader();
        }
        apsAd.getAdLoader();
        throw null;
    }

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private static DTBAdView m897(ApsAd apsAd) {
        f811 = (f813 + 15) % 128;
        DTBAdView adView = apsAd.getAdView();
        f813 = (f811 + 105) % 128;
        return adView;
    }

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private static String m898(ApsAd apsAd) {
        f811 = (f813 + 99) % 128;
        String slotUuid = apsAd.getSlotUuid();
        int i2 = f813 + 57;
        f811 = i2 % 128;
        if (i2 % 2 == 0) {
            return slotUuid;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    public static /* synthetic */ Map m902(DTBAdResponse dTBAdResponse) {
        int i2 = f811 + 65;
        f813 = i2 % 128;
        int i8 = i2 % 2;
        Map<String, String> mapM895 = m895(dTBAdResponse);
        if (i8 == 0) {
            int i9 = 71 / 0;
        }
        return mapM895;
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static String m904(DTBAdResponse dTBAdResponse) {
        f813 = (f811 + 49) % 128;
        String impressionUrl = dTBAdResponse.getImpressionUrl();
        f811 = (f813 + 17) % 128;
        return impressionUrl;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static String m908(DTBAdResponse dTBAdResponse) {
        f813 = (f811 + 11) % 128;
        String bidId = dTBAdResponse.getBidId();
        f811 = (f813 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
        return bidId;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static String m911(DTBAdResponse dTBAdResponse) {
        int i2 = f811 + 115;
        f813 = i2 % 128;
        if (i2 % 2 == 0) {
            dTBAdResponse.getCrid();
            throw null;
        }
        String crid = dTBAdResponse.getCrid();
        f813 = (f811 + 47) % 128;
        return crid;
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static String m913(ApsAd apsAd) {
        int i2 = f813 + 41;
        f811 = i2 % 128;
        int i8 = i2 % 2;
        String pricePoint = apsAd.getPricePoint();
        if (i8 != 0) {
            int i9 = 89 / 0;
        }
        return pricePoint;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ c m916(bi biVar, ThreadPoolExecutor threadPoolExecutor, ch chVar) {
        int i2 = f811 + 3;
        f813 = i2 % 128;
        if (i2 % 2 == 0) {
            biVar.m920(threadPoolExecutor, chVar);
            throw null;
        }
        c cVarM920 = biVar.m920(threadPoolExecutor, chVar);
        f811 = (f813 + 65) % 128;
        return cVarM920;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ String m922(ApsAd apsAd) {
        int i2 = f813 + 81;
        f811 = i2 % 128;
        if (i2 % 2 != 0) {
            m901(apsAd);
            throw null;
        }
        String strM901 = m901(apsAd);
        f811 = (f813 + 89) % 128;
        return strM901;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ e m925(bi biVar, HashMap map, ch chVar) {
        f811 = (f813 + 69) % 128;
        e eVarM921 = biVar.m921((HashMap<String, DTBFetchManager>) map, chVar);
        f813 = (f811 + 107) % 128;
        return eVarM921;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ HashMap m932(DTBAdResponse dTBAdResponse) {
        f811 = (f813 + 21) % 128;
        HashMap<String, Object> mapM899 = m899(dTBAdResponse);
        int i2 = f813 + 17;
        f811 = i2 % 128;
        if (i2 % 2 == 0) {
            return mapM899;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ String m934(DTBAdResponse dTBAdResponse) {
        int i2 = f811 + 29;
        f813 = i2 % 128;
        if (i2 % 2 == 0) {
            m908(dTBAdResponse);
            throw null;
        }
        String strM908 = m908(dTBAdResponse);
        f811 = (f813 + 5) % 128;
        return strM908;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static String m901(ApsAd apsAd) {
        int i2 = f811 + 115;
        f813 = i2 % 128;
        if (i2 % 2 == 0) {
            apsAd.getBidInfo();
            throw null;
        }
        String bidInfo = apsAd.getBidInfo();
        int i8 = f811 + 31;
        f813 = i8 % 128;
        if (i8 % 2 != 0) {
            return bidInfo;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static boolean m905(DTBAdSize dTBAdSize) {
        int i2 = f811 + 33;
        f813 = i2 % 128;
        if (i2 % 2 == 0) {
            dTBAdSize.isInterstitialAd();
            throw null;
        }
        boolean zIsInterstitialAd = dTBAdSize.isInterstitialAd();
        int i8 = f813 + 23;
        f811 = i8 % 128;
        if (i8 % 2 == 0) {
            return zIsInterstitialAd;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static AdType m907(DTBAdSize dTBAdSize) {
        int i2 = f811 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
        f813 = i2 % 128;
        if (i2 % 2 != 0) {
            return dTBAdSize.getDTBAdType();
        }
        dTBAdSize.getDTBAdType();
        throw null;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static JSONObject m912(DTBAdSize dTBAdSize) {
        int i2 = f813 + 63;
        f811 = i2 % 128;
        if (i2 % 2 != 0) {
            dTBAdSize.getPubSettings();
            throw null;
        }
        JSONObject pubSettings = dTBAdSize.getPubSettings();
        int i8 = f813 + 59;
        f811 = i8 % 128;
        if (i8 % 2 == 0) {
            return pubSettings;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ String m917(ApsAd apsAd) {
        int i2 = f811 + 87;
        f813 = i2 % 128;
        int i8 = i2 % 2;
        String strM913 = m913(apsAd);
        if (i8 == 0) {
            int i9 = 65 / 0;
        }
        int i10 = f813 + 53;
        f811 = i10 % 128;
        if (i10 % 2 == 0) {
            return strM913;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ String m923(DTBAdSize dTBAdSize) {
        f813 = (f811 + 77) % 128;
        String strM931 = m931(dTBAdSize);
        int i2 = f813 + 101;
        f811 = i2 % 128;
        if (i2 % 2 == 0) {
            return strM931;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ String m927(DTBAdResponse dTBAdResponse) {
        f813 = (f811 + 111) % 128;
        String strM911 = m911(dTBAdResponse);
        f813 = (f811 + 75) % 128;
        return strM911;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ JSONObject m936(DTBAdSize dTBAdSize) {
        f811 = (f813 + 63) % 128;
        JSONObject jSONObjectM912 = m912(dTBAdSize);
        f813 = (f811 + 19) % 128;
        return jSONObjectM912;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﾇ */
    public final Map<String, bg.a> mo827() {
        HashMap map = new HashMap();
        map.put(m926((char) (Color.green(0) + 58362), 9 - Gravity.getAbsoluteGravity(0, 0), 753 - View.resolveSize(0, 0)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bi.1
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bi.m910();
            }
        });
        map.put(m926((char) (ViewConfiguration.getWindowTouchSlop() >> 8), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 22, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 763).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bi.13
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bi.m900();
            }
        });
        map.put(m926((char) (7851 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), (ViewConfiguration.getEdgeSlop() >> 16) + 18, 786 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bi.18
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bi.m934((DTBAdResponse) list.get(0));
            }
        });
        map.put(m926((char) ExpandableListView.getPackedPositionGroup(0L), 22 - Process.getGidForName(""), (ViewConfiguration.getPressedStateDuration() >> 16) + 803).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bi.20
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bi.m927((DTBAdResponse) list.get(0));
            }
        });
        map.put(m926((char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), 26 - KeyEvent.getDeadChar(0, 0), 826 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bi.19
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bi.m918((DTBAdResponse) list.get(0));
            }
        });
        map.put(m926((char) View.MeasureSpec.getMode(0), 25 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 851).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bi.16
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bi.m932((DTBAdResponse) list.get(0));
            }
        });
        map.put(m926((char) (TextUtils.lastIndexOf("", '0') + 48298), 28 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 877 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bi.23
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bi.m919((DTBAdResponse) list.get(0));
            }
        });
        map.put(m926((char) TextUtils.getOffsetAfter("", 0), 36 - TextUtils.indexOf((CharSequence) "", '0', 0), 905 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bi.21
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bi.m902((DTBAdResponse) list.get(0));
            }
        });
        map.put(m926((char) (ViewConfiguration.getTouchSlop() >> 8), 16 - (ViewConfiguration.getFadingEdgeLength() >> 16), View.MeasureSpec.getSize(0) + 942).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bi.24
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bi.m914((DTBAdResponse) list.get(0));
            }
        });
        map.put(m926((char) (ViewConfiguration.getKeyRepeatDelay() >> 16), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 23, Color.argb(0, 0, 0, 0) + 958).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bi.4
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bi.m928((DTBAdResponse) list.get(0), (DTBAdSize) list.get(1));
            }
        });
        map.put(m926((char) (1065 - Drawable.resolveOpacity(0, 0)), TextUtils.indexOf("", "", 0) + 17, (Process.myPid() >> 22) + 981).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bi.2
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bi.m923((DTBAdSize) list.get(0));
            }
        });
        map.put(m926((char) (35323 - TextUtils.getTrimmedLength("")), 15 - TextUtils.getCapsMode("", 0, 0), 998 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bi.5
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bi.m915((DTBAdSize) list.get(0));
            }
        });
        map.put(m926((char) (Process.myPid() >> 22), Color.red(0) + 20, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 1012).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bi.3
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bi.m936((DTBAdSize) list.get(0));
            }
        });
        map.put(m926((char) View.MeasureSpec.getMode(0), Drawable.resolveOpacity(0, 0) + 22, 1033 - TextUtils.indexOf("", "")).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bi.6
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return Boolean.valueOf(bi.m929((DTBAdSize) list.get(0)));
            }
        });
        map.put(m926((char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1), Color.argb(0, 0, 0, 0) + 30, (ViewConfiguration.getLongPressTimeout() >> 16) + 1055).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bi.8
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bi.m925(bi.this, (HashMap) list.get(0), chVar);
            }
        });
        map.put(m926((char) Drawable.resolveOpacity(0, 0), TextUtils.indexOf("", "", 0) + 23, (ViewConfiguration.getJumpTapTimeout() >> 16) + 1085).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bi.7
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bi.m916(bi.this, (ThreadPoolExecutor) list.get(0), chVar);
            }
        });
        map.put(m926((char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), (Process.myPid() >> 22) + 15, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 1108).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bi.9
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bi.m924((ApsAd) list.get(0));
            }
        });
        map.put(m926((char) (Color.red(0) + 10270), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 10, TextUtils.getTrimmedLength("") + 1123).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bi.10
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bi.m922((ApsAd) list.get(0));
            }
        });
        map.put(m926((char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), 13 - (ViewConfiguration.getKeyRepeatDelay() >> 16), View.MeasureSpec.makeMeasureSpec(0, 0) + 1133).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bi.14
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bi.m917((ApsAd) list.get(0));
            }
        });
        map.put(m926((char) TextUtils.getTrimmedLength(""), 12 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 1146 - TextUtils.indexOf("", "", 0, 0)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bi.11
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bi.m933((ApsAd) list.get(0));
            }
        });
        map.put(m926((char) (AndroidCharacter.getMirror('0') - '0'), 13 - TextUtils.lastIndexOf("", '0'), (ViewConfiguration.getScrollBarSize() >> 8) + 1157).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bi.15
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bi.m930((ApsAd) list.get(0));
            }
        });
        map.put(m926((char) (Process.myPid() >> 22), 11 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 1171 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bi.12
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bi.m906((ApsAd) list.get(0));
            }
        });
        map.put(m926((char) (ImageFormat.getBitsPerPixel(0) + 1), 9 - TextUtils.indexOf("", "", 0, 0), 1182 - TextUtils.indexOf("", "")).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bi.17
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bi.m903((ApsAd) list.get(0));
            }
        });
        f813 = (f811 + 11) % 128;
        return map;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static ApsAdRequest m909(ApsAd apsAd) {
        int i2 = f811 + 29;
        f813 = i2 % 128;
        if (i2 % 2 != 0) {
            return apsAd.getApsAdRequest();
        }
        apsAd.getApsAdRequest();
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ String m918(DTBAdResponse dTBAdResponse) {
        f811 = (f813 + 103) % 128;
        String strM904 = m904(dTBAdResponse);
        int i2 = f811 + 1;
        f813 = i2 % 128;
        if (i2 % 2 != 0) {
            return strM904;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ String m928(DTBAdResponse dTBAdResponse, DTBAdSize dTBAdSize) {
        int i2 = f811 + 89;
        f813 = i2 % 128;
        if (i2 % 2 != 0) {
            return m935(dTBAdResponse, dTBAdSize);
        }
        m935(dTBAdResponse, dTBAdSize);
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m935(DTBAdResponse dTBAdResponse, DTBAdSize dTBAdSize) {
        int i2 = f813 + 39;
        f811 = i2 % 128;
        int i8 = i2 % 2;
        String pricePoints = dTBAdResponse.getPricePoints(dTBAdSize);
        if (i8 != 0) {
            int i9 = 60 / 0;
        }
        return pricePoints;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻛ */
    public final String mo881() {
        f811 = (f813 + 1) % 128;
        String version = AdRegistration.getVersion();
        f811 = (f813 + 37) % 128;
        return version;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ boolean m929(DTBAdSize dTBAdSize) {
        int i2 = f811 + 75;
        f813 = i2 % 128;
        if (i2 % 2 == 0) {
            m905(dTBAdSize);
            throw null;
        }
        boolean zM905 = m905(dTBAdSize);
        f813 = (f811 + 109) % 128;
        return zM905;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻐ */
    public final String mo825() {
        Matcher matcher = Pattern.compile(m926((char) (29079 - (ViewConfiguration.getKeyRepeatDelay() >> 16)), Color.blue(0) + 13, ViewConfiguration.getScrollDefaultDelay() >> 16).intern()).matcher(mo881());
        if (!matcher.matches()) {
            return null;
        }
        f811 = (f813 + 65) % 128;
        String strGroup = matcher.group(1);
        f811 = (f813 + 53) % 128;
        return strGroup;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo826(String str) {
        switch (str.hashCode()) {
            case -2137858584:
                if (str.equals(m926((char) (50261 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), 10 - TextUtils.indexOf((CharSequence) "", '0'), 204 - TextUtils.indexOf("", "", 0)).intern())) {
                    return DTBAdLoader.class;
                }
                return null;
            case -2133119933:
                if (str.equals(m926((char) (59172 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), (-16777201) - Color.rgb(0, 0, 0), 673 - Drawable.resolveOpacity(0, 0)).intern())) {
                    return ApsAdController.class;
                }
                return null;
            case -1987686071:
                if (str.equals(m926((char) (ExpandableListView.getPackedPositionGroup(0L) + 33384), 13 - Gravity.getAbsoluteGravity(0, 0), (ViewConfiguration.getLongPressTimeout() >> 16) + 482).intern())) {
                    return DTBAdListener.class;
                }
                return null;
            case -1885106463:
                if (str.equals(m926((char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 11 - (ViewConfiguration.getJumpTapTimeout() >> 16), TextUtils.lastIndexOf("", '0', 0) + 28).intern())) {
                    return DTBActivity.class;
                }
                return null;
            case -1879113962:
                if (str.equals(m926((char) (53383 - (ViewConfiguration.getScrollDefaultDelay() >> 16)), TextUtils.indexOf("", "", 0, 0) + 9, 280 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))).intern())) {
                    return DTBAdSize.class;
                }
                return null;
            case -1879025222:
                if (str.equals(m926((char) (TextUtils.lastIndexOf("", '0', 0) + 1), 9 - View.MeasureSpec.getMode(0), 240 - (ViewConfiguration.getEdgeSlop() >> 16)).intern())) {
                    return DTBAdView.class;
                }
                return null;
            case -1554728876:
                if (str.equals(m926((char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1), 44 - MotionEvent.axisFromString(""), 95 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))).intern())) {
                    return DTBInterstitialActivity.class;
                }
                return null;
            case -1464660218:
                if (str.equals(m926((char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1), 28 - TextUtils.lastIndexOf("", '0', 0, 0), 394 - Drawable.resolveOpacity(0, 0)).intern())) {
                    return DTBAdBaseInterstitialListener.class;
                }
                return null;
            case -1358954558:
                if (str.equals(m926((char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 56610), View.getDefaultSize(0, 0) + 15, 311 - TextUtils.indexOf("", "")).intern())) {
                    return DTBFetchFactory.class;
                }
                return null;
            case -1293925587:
                if (!str.equals(m926((char) (8704 - Process.getGidForName("")), 22 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 71).intern())) {
                    return null;
                }
                f811 = (f813 + 27) % 128;
                return DTBInterstitialActivity.class;
            case -1291566264:
                if (!str.equals(m926((char) KeyEvent.normalizeMetaState(0), ExpandableListView.getPackedPositionGroup(0L) + 12, (Process.myTid() >> 22) + 741).intern())) {
                    return null;
                }
                f813 = (f811 + 75) % 128;
                return ApsAdRequest.class;
            case -1092884085:
                if (!str.equals(m926((char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 34, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 153).intern())) {
                    return null;
                }
                break;
            case -1090060454:
                if (str.equals(m926((char) (Color.blue(0) + 3801), Color.alpha(0) + 12, (ViewConfiguration.getTouchSlop() >> 8) + Sdk.SDKError.Reason.AD_RESPONSE_EMPTY_VALUE).intern())) {
                    return DTBAdRequest.class;
                }
                return null;
            case -832298225:
                if (str.equals(m926((char) (Process.myPid() >> 22), 16 - (ViewConfiguration.getLongPressTimeout() >> 16), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 494).intern())) {
                    return e.class;
                }
                return null;
            case -791598050:
                if (str.equals(m926((char) (View.MeasureSpec.getMode(0) + 64791), View.MeasureSpec.makeMeasureSpec(0, 0) + 11, 721 - (ViewConfiguration.getMaximumFlingVelocity() >> 16)).intern())) {
                    return ApsAdFormat.class;
                }
                return null;
            case -723985259:
                if (str.equals(m926((char) (KeyEvent.normalizeMetaState(0) + 15009), 11 - TextUtils.getOffsetBefore("", 0), 389 - AndroidCharacter.getMirror('0')).intern())) {
                    return DTBRenderer.class;
                }
                return null;
            case -696695160:
                if (str.equals(m926((char) (ViewConfiguration.getScrollBarSize() >> 8), (ViewConfiguration.getPressedStateDuration() >> 16) + 33, (Process.myTid() >> 22) + 38).intern())) {
                    return DTBActivity.class;
                }
                return null;
            case -694845532:
                if (!str.equals(m926((char) (34090 - ((byte) KeyEvent.getModifierMetaStateMask())), 12 - TextUtils.indexOf((CharSequence) "", '0', 0), Process.getGidForName("") + 140).intern())) {
                    return null;
                }
                break;
            case -466918522:
                if (str.equals(m926((char) ((-1) - ImageFormat.getBitsPerPixel(0)), TextUtils.lastIndexOf("", '0', 0) + 24, 371 - TextUtils.indexOf("", "")).intern())) {
                    return DTBAdBaseBannerListener.class;
                }
                return null;
            case -341719851:
                if (str.equals(m926((char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), Process.getGidForName("") + 20, 352 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))).intern())) {
                    return DTBAdBannerListener.class;
                }
                return null;
            case -300800492:
                if (str.equals(m926((char) View.MeasureSpec.getSize(0), 17 - (ViewConfiguration.getEdgeSlop() >> 16), Color.red(0) + FrameMetricsAggregator.EVERY_DURATION).intern())) {
                    return c.class;
                }
                return null;
            case -197992833:
                if (str.equals(m926((char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1), TextUtils.lastIndexOf("", '0', 0, 0) + 24, ExpandableListView.getPackedPositionGroup(0L) + 528).intern())) {
                    return ApsInterstitialActivity.class;
                }
                return null;
            case -27446238:
                if (str.equals(m926((char) (26944 - View.resolveSizeAndState(0, 0, 0)), 20 - Process.getGidForName(""), Color.blue(0) + 436).intern())) {
                    return DTBAdExpandedListener.class;
                }
                return null;
            case 66052:
                if (str.equals(m926((char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 62695), KeyEvent.normalizeMetaState(0) + 3, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 665).intern())) {
                    return Aps.class;
                }
                return null;
            case 63478087:
                if (str.equals(m926((char) (AndroidCharacter.getMirror('0') - '0'), 5 - (ViewConfiguration.getTapTimeout() >> 16), 669 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))).intern())) {
                    return ApsAd.class;
                }
                return null;
            case 355568411:
                if (!str.equals(m926((char) KeyEvent.keyCodeFromString(""), Color.rgb(0, 0, 0) + 16777229, 689 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))).intern())) {
                    return null;
                }
                f811 = (f813 + 69) % 128;
                return ApsAdListener.class;
            case 568188517:
                if (!str.equals(m926((char) (63565 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), (ViewConfiguration.getEdgeSlop() >> 16) + 15, ((byte) KeyEvent.getModifierMetaStateMask()) + 327).intern())) {
                    return null;
                }
                f811 = (f813 + 5) % 128;
                return DTBFetchManager.class;
            case 620798166:
                if (str.equals(m926((char) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 43293), 13 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (ViewConfiguration.getScrollBarSize() >> 8) + 227).intern())) {
                    return DTBAdResponse.class;
                }
                return null;
            case 788901082:
                if (str.equals(m926((char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1), (ViewConfiguration.getLongPressTimeout() >> 16) + 13, TextUtils.indexOf((CharSequence) "", '0', 0) + TypedValues.CycleType.TYPE_WAVE_OFFSET).intern())) {
                    return DTBAdCallback.class;
                }
                return null;
            case 1036908700:
                if (!str.equals(m926((char) (49849 - View.MeasureSpec.getSize(0)), 13 - TextUtils.lastIndexOf("", '0'), 12 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))).intern())) {
                    return null;
                }
                f813 = (f811 + 17) % 128;
                return AdRegistration.class;
            case 1251356764:
                if (str.equals(m926((char) (2621 - (ViewConfiguration.getFadingEdgeLength() >> 16)), 41 - View.resolveSizeAndState(0, 0, 0), (ViewConfiguration.getPressedStateDuration() >> 16) + IronSourceError.ERROR_BN_LOAD_NO_CONFIG).intern())) {
                    return ApsAdActivity.class;
                }
                return null;
            case 1306698049:
                if (str.equals(m926((char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), 17 - KeyEvent.keyCodeFromString(""), 188 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))).intern())) {
                    return DTBAdInterstitial.class;
                }
                return null;
            case 1328085269:
                if (!str.equals(m926((char) (TextUtils.indexOf("", "", 0, 0) + 13027), TextUtils.lastIndexOf("", '0', 0, 0) + 26, TextUtils.getOffsetAfter("", 0) + 457).intern())) {
                    return null;
                }
                int i2 = f813 + 3;
                f811 = i2 % 128;
                if (i2 % 2 != 0) {
                    return null;
                }
                return DTBAdInterstitialListener.class;
            case 1340383521:
                if (str.equals(m926((char) (64324 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 8, TextUtils.getCapsMode("", 0, 0) + 732).intern())) {
                    return ApsAdType.class;
                }
                return null;
            case 1340427404:
                if (!str.equals(m926((char) (AndroidCharacter.getMirror('0') - '0'), 9 - Color.argb(0, 0, 0, 0), Gravity.getAbsoluteGravity(0, 0) + 656).intern())) {
                    return null;
                }
                int i8 = f813 + 1;
                f811 = i8 % 128;
                if (i8 % 2 == 0) {
                    return ApsAdView.class;
                }
                return ApsAd.class;
            case 1600627740:
                if (str.equals(m926((char) (3925 - (Process.myPid() >> 22)), (ViewConfiguration.getTapTimeout() >> 16) + 20, TextUtils.indexOf("", "", 0, 0) + 701).intern())) {
                    return ApsAdRequestListener.class;
                }
                return null;
            case 1648408950:
                if (str.equals(m926((char) Color.alpha(0), 13 - (ViewConfiguration.getDoubleTapTimeout() >> 16), TextUtils.lastIndexOf("", '0', 0, 0) + 603).intern())) {
                    return ApsAdActivity.class;
                }
                return null;
            case 1713728997:
                if (str.equals(m926((char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 52, Process.getGidForName("") + 552).intern())) {
                    return ApsInterstitialActivity.class;
                }
                return null;
            case 2019413793:
                if (!str.equals(m926((char) KeyEvent.getDeadChar(0, 0), AndroidCharacter.getMirror('0') - 17, 249 - Color.blue(0)).intern())) {
                    return null;
                }
                f813 = (f811 + 87) % 128;
                return DTBAdView.class;
            case 2144664800:
                if (!str.equals(m926((char) (TextUtils.lastIndexOf("", '0') + 1439), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 22, 288 - ((byte) KeyEvent.getModifierMetaStateMask())).intern())) {
                    return null;
                }
                int i9 = f811 + 21;
                f813 = i9 % 128;
                if (i9 % 2 == 0) {
                    return null;
                }
                return DTBAdViewSupportClient.class;
            default:
                return null;
        }
        f811 = (f813 + 7) % 128;
        return DTBAdActivity.class;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m926(char c7, int i2, int i8) {
        String str;
        synchronized (com.ironsource.adqualitysdk.sdk.i.c.f1192) {
            try {
                char[] cArr = new char[i2];
                com.ironsource.adqualitysdk.sdk.i.c.f1193 = 0;
                while (true) {
                    int i9 = com.ironsource.adqualitysdk.sdk.i.c.f1193;
                    if (i9 < i2) {
                        cArr[i9] = (char) ((((long) f814[i8 + i9]) ^ (((long) i9) * f812)) ^ ((long) c7));
                        com.ironsource.adqualitysdk.sdk.i.c.f1193 = i9 + 1;
                    } else {
                        str = new String(cArr);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m931(DTBAdSize dTBAdSize) {
        f813 = (f811 + 113) % 128;
        String slotUUID = dTBAdSize.getSlotUUID();
        int i2 = f811 + 115;
        f813 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 51 / 0;
        }
        return slotUUID;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private e m921(HashMap<String, DTBFetchManager> map, ch chVar) {
        e eVar = new e(map, chVar);
        f811 = (f813 + 115) % 128;
        return eVar;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private c m920(ThreadPoolExecutor threadPoolExecutor, ch chVar) {
        c cVar = new c(threadPoolExecutor, chVar);
        int i2 = f813 + 87;
        f811 = i2 % 128;
        if (i2 % 2 == 0) {
            return cVar;
        }
        throw null;
    }
}
