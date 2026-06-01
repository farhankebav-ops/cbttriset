package com.ironsource.adqualitysdk.sdk.i;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.datastore.preferences.protobuf.DescriptorProtos;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.ChartboostDelegate;
import com.chartboost.sdk.InPlay.CBInPlay;
import com.chartboost.sdk.Model.CBError;
import com.ironsource.adqualitysdk.sdk.i.bg;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.vungle.ads.internal.protos.Sdk;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class bj extends bg {

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f851 = 0;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static int f852 = 1;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static char[] f855 = {51437, 65012, 41643, 22346, 7186, 49462, 63469, 48287, 24909, 5656, 56091, 33259, 46722, 31565, 8292, 54569, 39930, 16517, 43356, 40047, 49970, 14052, 32167, 41111, 38486, 56626, 252, 30644, 47748, 57431, 55046, 6902, 16855, 46232, 64073, 8484, 5359, 23504, 'C', 13680, 27181, 40952, 54424, 2454, 16205, 29735, 'C', 13680, 27177, 40947, 54444, 2451, 16205, 29738, 43513, 57005, 5018, 'C', 13680, 27181, 40955, 54456, 2440, 16201, 29741, 43491, 57003, 5019, 18760, 32276, 46063, 59611, 7567, 21315, 34859, 48581, 62165, 10140, 23923, 37434, 50967, 64708, 12699, 37916, 41241, 65117, 3001, 16628, 40400, 43783, 57460, 'A', 13654, 27175, 40951, 54436, 2454, 16206, 29759, 43507, 57001, 'I', 13660, 27152, 40947, 54458, 2441, 16216, 29751, 43492, 57003, 5013, 18762, 32283, 46059, 59600, 7554, 21314, 34867, 48615, 62173, 'S', 13638, 27141, 40932, 54460, 2489, 16205, 29746, 43516, 56992, 5013, 18757, 32307, '6', 13596, 27221, 40888, 54520, 's', 13655, 27152, 40898, 54442, 2494, 16201, 29746, 43509, 56997, 5013, 18770, 32317, 'g', 13655, 27152, 40917, 54432, 2459, 16222, 29738, 43506, 57005, 5019, 18773, 32300, 46030, 59609, 7554, 21317, 34869, 48613, 62146, 10125, 9479, 4151, 20336, 47797, 61888, 11515, 6718, 20810, 35986, 64461, 14075, 27701, 23372, 38588, 52708, 14545, 30324, 44397, 39124, 55186, 749, 30742, 46921, 57977, 55729, 5366, 16913, 'c', 13632, 27137, 40951, 54460, 2463, 16248, 29724, 43475, 57002, 5013, 18772, 32300, 46056, 59603, 7553, 21331, 34854, 48576, 62163, 10116, 23935, 37419, 50975, 64708, 12679, 'i', 13633, 27187, 40947, 54442, 2476, 16197, 29755, 43495, 56967, 5018, 18759, 32314, 46054, 59609, 7562, 534, 14142, 26703, 40331, 55027, 3040, 15679, 30276, 43912, 56540, 4607, 19260};

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static long f856 = -4703846895164574414L;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static long f853 = 0;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f857 = 0;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static char f854 = 43951;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b extends ChartboostDelegate implements hc<ChartboostDelegate> {

        /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
        private static int f867 = 0;

        /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
        private static int f868 = 1;

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private static long f869;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private static char[] f870;

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private ChartboostDelegate f871;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private ch f872;

        static {
            char[] cArr = new char[1261];
            a0.o("\u0000C,SX\u0017\u0084Ã°\u0098ÝE\t\r5òa«\u008egº\næì\u0012¨>\u009ak]\u0097\u0014ÃÄï\u008e\u001c\bH\u0012tô ¸Ígù!%ìQ\u0091}\u009bªHÖ\u0001\u0002Ê.\u0099[Q\u0087)³õß¢\ft8>dô\u0090¶¼\u0094éL\u0015\u001aAÏm\u00857l\u001b|o8³ì\u0087·êj>\"\u0002ÝV\u0084¹H\u008d%ÑÃ%\u0087\tµ\\r ;ôëØ¡+'\u007f=CÛ\u0097\u0097úHÎ\u000e\u0012Ãf¨J¸\u009deá+5ì\u0019¤ls°\u0006\u0084Úè\u008d;[\u000f\u0011SÛ§\u0099\u008b»Þc\"5vàZª\u0000C,SX\u0017\u0084Ã°\u0098ÝE\t\r5òa«\u008egº\næì\u0012¨>\u009ak]\u0097\u0014ÃÄï\u008e\u001c\bH\u0005tõ ³ÍQù,%ëQ«}\u009bªpÖ\u001a\u0002Û.\u008f[W\u0087\u0013³ïß¿\fe8%dæ\u0090®%n\t~}:¡î\u0095µøh, \u0010ßD\u0086«J\u009f'ÃÁ7\u0085\u001b·Np²9æéÊ£9%m(QØ\u0085\u009eèyÜ\u0001\u0000Ìt\u0082X\u0087\u008f{ó\u0015'í\u000b¦~l¢\u0004\u0096Øú\u008f)Y\u001d\u0013AÙµ\u009b\u0099¹Ìa07dâH¨Gékù\u001f½Ãi÷2\u009aïN§rX&\u0001ÉÍý ¡FU\u0002y0,÷Ð¾\u0084n¨$[¢\u000f¯3_ç\u0019\u008aü¾\u008ebQ\u0016\u0004:=íà\u0091\u00adELi.\u001cûÀ¯ôC\u0098\u000fKÏ\u007f\u008f#Y×\u0001û6®þ¼\u0004\u0090\u0014äP8\u0084\fßa\u0002µJ\u0089µÝì2 \u0006MZ«®ï\u0082Ý×\u001a+S\u007f\u0083SÉ OôBÈ²\u001côq\u0016Ef\u0099 í÷ÁÜ\u00167j]¾\u009c\u0092Èç\u0010;T\u000f¨cø°\"\u0084bØ¡,é\u0000C,SX\u0017\u0084Ã°\u0098ÝE\t\r5òa«\u008egº\næì\u0012¨>\u009ak]\u0097\u0014ÃÄï\u008e\u001c\bH\u0005tõ ³ÍQù!%áQ }\u0095ªpÖ\u001a\u0002Û.\u008f[W\u0087\u0013³ïß¿\fe8%dæ\u0090®\u0000C,SX\u0017\u0084Ã°\u0098ÝE\t\r5òa«\u008egº\næì\u0012¨>\u009ak]\u0097\u0014ÃÄï\u008e\u001c\bH\u0005tõ ³ÍVù$%ûQ³}\u0092ªXÖ\r\u0002æ.\u0084[Q\u0087\u0005³éß¥\fe8%dó\u0090«¼\u009céThPD@0\u0004ìÐØ\u008bµVa\u001e]á\t¸ætÒ\u0019\u008eÿz»V\u0089\u0003Nÿ\u0007«×\u0087\u009dt\u001b \u0016\u001cæÈ ¥B\u00911Mö9 \u0015\u0081ÂO¾\u0013jÙF°3Xï\u0007Ûí··dqP+\fýø¥Ô\u0087\u0081J}\f_^sN\u0007\nÛÞï\u0085\u0082XV\u0010jï>¶Ñzå\u0017¹ñMµa\u00874@È\t\u009cÙ°\u0093C\u0015\u0017\u000f+éÿ¥\u0092z¦<zñ\u000e\u008c\"\u0086õU\u0089\u001c]×q\u0084\u0004LØ0ìé\u0080¹Sig\u0010;êÏ¯ã\u0093\u0000C,SX\u0017\u0084Ã°\u0098ÝE\t\r5òa«\u008egº\næì\u0012¨>\u009ak]\u0097\u0014ÃÄï\u008e\u001c\bH\u0005tõ ³ÍQù,%ëQ«}\u009bªtÖ\u001b\u0002Ý.\u008f[d\u0087\u0010³ëß¥Ø?ô/\u0080k\\¿hä\u00059Ñqí\u008e¹×V\u001bbv>\u0090ÊÔææ³!Oh\u001b¸7òÄt\u0090n¬\u0088xÄ\u0015\u001b!]ý\u0090\u0089û¥ër6\u000exÚ¿ö÷\u0083 _Qk\u0088\u0007ØÔ\bàq¼\u008bHÎdò\u0000C,SX\u0017\u0084Ã°\u0098ÝE\t\r5òa«\u008egº\næì\u0012¨>\u009ak]\u0097\u0014ÃÄï\u008e\u001c\bH\u0005tõ ³ÍTù,%áQ¯}ªªVÖ8\u0002À.\u008b[A\u0087-³ôß¤\ft8\rd÷\u0090²¼\u008e\u0000C,SX\u0017\u0084Ã°\u0098ÝE\t\r5òa«\u008egº\næì\u0012¨>\u009ak]\u0097\u0014ÃÄï\u008e\u001c\bH\u0005tõ ³ÍVù$%ûQ®}\u0097ªJÖ\u0007\u0002â.\u0085[W\u0087\u0005³Úß¦\fa8?ú(Ö8¢|~¨Jó'.ófÏ\u0099\u009bÀt\f@a\u001c\u0087èÃÄñ\u00916m\u007f9¯\u0015åæc²n\u008e\u009eZØ7:\u0003Jß\u008c«Û\u0087ðP\u001f,pø¶Ôä¡\u000f}{I\u0080%Î\u0000C,SX\u0017\u0084Ã°\u0098ÝE\t\r5òa«\u008egº\næì\u0012¨>\u009ak]\u0097\u0014ÃÄï\u008e\u001c\bH\u0005tõ ³ÍQù!%áQ }\u0095ªtÖ\u001b\u0002Ý.\u008f[d\u0087\u0010³ëß¥\u0000C,SX\u0017\u0084Ã°\u0098ÝE\t\r5òa«\u008egº\næì\u0012¨>\u009ak]\u0097\u0014ÃÄï\u008e\u001c\bH\u0005tõ ³ÍVù$%ûQ³}\u0092ªXÖ\r\u0002â.\u0085[W\u0087\u0005³Úß¦\fa8?\u0000C,SX\u0017\u0084Ã°\u0098ÝE\t\r5òa«\u008egº\næì\u0012¨>\u009ak]\u0097\u0014ÃÄï\u008e\u001c\bH\u0005tõ ³ÍTù,%áQ¯}ªªVÖ&\u0002Ê.\u0089[J\u0087\u0012³ÿß\u0095\f}8%dä\u0090©u0Y -dñ°Åë¨6|~@\u0081\u0014Øû\u0014Ïy\u0093\u009fgÛKé\u001e.âg¶·\u009aýi{=v\u0001\u0086ÕÀ¸1\u008c_P\u008e$Ã\bèß\t£kwµ[ú.=òUÆ\u0087ª×y!MP\u0011\u009aå×Éç\u009c9`m4¼\u0018îï>³C\u0087\u0087\u008d\u0003¡5Õu\t\u0086=êP5\u0084v¸\u009fìü\u0003\u00187@k\u008d\u009fÈ³Þæ2\u001a`N\u0094bã\u0091/Å`ù\u0092-Â@\u0018tK¨\u009bÜÍðö'0u\u001cY\f-Hñ\u009cÅÇ¨\u001a|R@\u00ad\u0014ôû8ÏU\u0093³g÷KÅ\u001e\u0002âK¶\u009b\u009aÑiW=M\u0001«Õç¸8\u008c~P³$Ø\bÈß\u0015£[w\u009c[Ô.\u0003òmÆ¡ªþy/Ma\u0011¼åøÉÆ\u009c1`E4\u0095\u0018Óï\u0014\u001aö6æB¢\u009evª-Çð\u0013¸/G{\u001e\u0094Ò ¿üY\b\u001d$/qè\u008d¡Ùqõ;\u0006½R°n@º\u0006×äã\u0099?^K\u001eg.°ÞÌ¤\u0018m4>Aâ\u009d±©KÅ\u0007\u0016ò\"\u0090~V\u008a\u0012¦'\u0000C,SX\u0017\u0084Ã°\u0098ÝE\t\r5òa«\u008egº\næì\u0012¨>\u009ak]\u0097\u0014ÃÄï\u008e\u001c\bH\u0005tõ ³ÍTù,%áQ¯}ªªVÖ8\u0002À.\u008b[A\u00872³þß¡\fp8>dã\u0090§¼\u0099én\u0015\u001aAÊm\u008c\u009aKjÜFÌ2\u0088î\\Ú\u0007·Úc\u0092_m\u000b4äøÐ\u0095\u008csx7T\u0005\u0001Âý\u008b©[\u0085\u0011v\u0097\"\u009a\u001ejÊ,§É\u0093»Od;1\u0017\bÀÕ¼\u0098hbD\u00101Íí\u009eÙvµ-fëR·\u000eNú4Ö\u0006\u0083Â\u007f\u0083ý\u001fÑ\u000f¥Ky\u009fMÄ \u0019ôQÈ®\u009c÷s;GV\u001b°ïôÃÆ\u0096\u0001jH>\u0098\u0012ÒáTµY\u0089©]ï0\r\u0004}Ø»¬ì\u0080ÇW7+Mÿ\u0084Ó×¦\u000bzXN¢\"îñ\u001bÅy\u0099¿mûAÎ\u0000C,SX\u0017\u0084Ã°\u0098ÝE\t\r5òa«\u008egº\næì\u0012¨>\u009ak]\u0097\u0014ÃÄï\u008e\u001c\bH\u0005tõ ³ÍQù!%áQ }\u0095ªkÖ\u0011\u0002Ø.\u008b[W\u0087\u0004³þß²\fG8%dã\u0090§¼\u0092\u0000C,SX\u0017\u0084Ã°\u0098ÝE\t\r5òa«\u008egº\næì\u0012¨>\u009ak]\u0097\u0014ÃÄï\u008e\u001c\bH\u0005tõ ³ÍQù\"%åQ³}\u0092ª\\Ö\u0000\u0002Ê.¸[@\u0087\u0017³úß¤\fu8)dã\u0090\u0094¼\u0094é\\\u0015\u0016AÁ\u0000C,SX\u0017\u0084Ã°\u0098ÝE\t\r5òa«\u008egº\næì\u0012¨>\u009ak]\u0097\u0014ÃÄï\u008e\u001c\bH\u0005tõ ³ÍVù$%ûQ³}\u0092ªXÖ\r\u0002ý.\u008f[R\u0087\u0001³éß²\ft8(dÑ\u0090«¼\u0099é]\u0015\u001c\u0000C,SX\u0017\u0084Ã°\u0098ÝE\t\r5òa«\u008egº\næì\u0012¨>\u009ak]\u0097\u0014ÃÄï\u008e\u001c\bH\u0016tõ »Í~ù\t%áQ°}\u008eªUÖ\u0015\u0002Ö.¼[L\u0087\u0004³þß¹\u0000C,SX\u0017\u0084Ã°\u0098ÝE\t\r5òa«\u008egº\næì\u0012¨>\u009ak]\u0097\u0014ÃÄï\u008e\u001c\bH\u0005tõ ³ÍQù,%ëQ«}\u009bªpÖ\u001a\u0002ÿ.\u0086[D\u0087\u0019Ò§þ·\u008aóV'b|\u000f¡Ûéç\u0016³O\\\u0083hî4\bÀLì~¹¹Eð\u0011 =jÎì\u009aá¦\u0011rW\u001f°+È÷\u0005\u0083K¯Nx²\u0004ÜÐ$üo\u0089¥UÍa\u0011\rbÞ\u0099êÉ¶\u001a\u0000C,SX\u0017\u0084Ã°\u0098ÝE\t\r5òa«\u008egº\næì\u0012¨>\u009ak]\u0097\u0014ÃÄï\u008e\u001c\bH\u0005tõ ³Í[ù#%áQ·}\u0097ªXÖ\u0018\u0002Æ.\u0090[@", "ISO-8859-1", cArr, 0, 1261);
            f870 = cArr;
            f869 = 795143199028948027L;
        }

        public b(ChartboostDelegate chartboostDelegate, ch chVar) {
            this.f871 = chartboostDelegate;
            this.f872 = chVar;
        }

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private ChartboostDelegate m962() {
            int i2 = f867;
            int i8 = i2 + 57;
            f868 = i8 % 128;
            if (i8 % 2 == 0) {
                throw null;
            }
            ChartboostDelegate chartboostDelegate = this.f871;
            f868 = (i2 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
            return chartboostDelegate;
        }

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private static String m963(char c7, int i2, int i8) {
            String str;
            synchronized (c.f1192) {
                try {
                    char[] cArr = new char[i2];
                    c.f1193 = 0;
                    while (true) {
                        int i9 = c.f1193;
                        if (i9 < i2) {
                            cArr[i9] = (char) ((((long) f870[i8 + i9]) ^ (((long) i9) * f869)) ^ ((long) c7));
                            c.f1193 = i9 + 1;
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

        public void didCacheInPlay(String str) {
            f867 = (f868 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
            bj.this.m885(this, this.f872, m963((char) TextUtils.getOffsetBefore("", 0), ExpandableListView.getPackedPositionGroup(0L) + 33, View.resolveSize(0, 0) + 1158).intern(), str);
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate != null) {
                chartboostDelegate.didCacheInPlay(str);
            }
            f868 = (f867 + 23) % 128;
        }

        public void didCacheInterstitial(String str) {
            f868 = (f867 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
            bj.this.m885(this, this.f872, m963((char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')), 'W' - AndroidCharacter.getMirror('0'), 88 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))).intern(), str);
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate != null) {
                chartboostDelegate.didCacheInterstitial(str);
                f868 = (f867 + 49) % 128;
            }
        }

        public void didCacheMoreApps(String str) {
            bj.this.m885(this, this.f872, m963((char) View.resolveSize(0, 0), Gravity.getAbsoluteGravity(0, 0) + 35, 413 - (ViewConfiguration.getTouchSlop() >> 8)).intern(), str);
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate != null) {
                int i2 = f868 + 63;
                f867 = i2 % 128;
                int i8 = i2 % 2;
                chartboostDelegate.didCacheMoreApps(str);
                if (i8 != 0) {
                    throw null;
                }
            }
            int i9 = f868 + 87;
            f867 = i9 % 128;
            if (i9 % 2 != 0) {
                throw null;
            }
        }

        public void didCacheRewardedVideo(String str) {
            bj.this.m885(this, this.f872, m963((char) (Drawable.resolveOpacity(0, 0) + 6837), (KeyEvent.getMaxKeyCode() >> 16) + 40, 831 - TextUtils.indexOf("", "", 0, 0)).intern(), str);
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate != null) {
                f867 = (f868 + 37) % 128;
                chartboostDelegate.didCacheRewardedVideo(str);
                f868 = (f867 + 109) % 128;
            }
        }

        public void didClickInterstitial(String str) {
            f867 = (f868 + 77) % 128;
            bj.this.m885(this, this.f872, m963((char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 38, TextUtils.indexOf("", "", 0, 0) + 251).intern(), str);
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate != null) {
                chartboostDelegate.didClickInterstitial(str);
            }
            f867 = (f868 + 99) % 128;
        }

        public void didClickMoreApps(String str) {
            f868 = (f867 + 109) % 128;
            bj.this.m885(this, this.f872, m963((char) Color.green(0), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 34, View.MeasureSpec.getMode(0) + 600).intern(), str);
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate != null) {
                chartboostDelegate.didClickMoreApps(str);
                f867 = (f868 + 19) % 128;
            }
        }

        public void didClickRewardedVideo(String str) {
            f867 = (f868 + 49) % 128;
            bj.this.m885(this, this.f872, m963((char) (ViewConfiguration.getEdgeSlop() >> 16), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 40, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + DescriptorProtos.Edition.EDITION_PROTO2_VALUE).intern(), str);
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate != null) {
                f868 = (f867 + 21) % 128;
                chartboostDelegate.didClickRewardedVideo(str);
            }
        }

        public void didCloseInterstitial(String str) {
            bj.this.m885(this, this.f872, m963((char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 48198), 39 - (ViewConfiguration.getScrollDefaultDelay() >> 16), View.getDefaultSize(0, 0) + Sdk.SDKError.Reason.PLACEMENT_SLEEP_VALUE).intern(), str);
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate != null) {
                f867 = (f868 + 115) % 128;
                chartboostDelegate.didCloseInterstitial(str);
            }
            int i2 = f867 + 37;
            f868 = i2 % 128;
            if (i2 % 2 == 0) {
                throw null;
            }
        }

        public void didCloseMoreApps(String str) {
            f868 = (f867 + 107) % 128;
            bj.this.m885(this, this.f872, m963((char) (64107 - (ViewConfiguration.getDoubleTapTimeout() >> 16)), 34 - ExpandableListView.getPackedPositionChild(0L), 565 - (ViewConfiguration.getTapTimeout() >> 16)).intern(), str);
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate != null) {
                f867 = (f868 + 13) % 128;
                chartboostDelegate.didCloseMoreApps(str);
            }
            f868 = (f867 + 69) % 128;
        }

        public void didCloseRewardedVideo(String str) {
            bj.this.m885(this, this.f872, m963((char) (64859 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), 40 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), TextUtils.lastIndexOf("", '0') + 959).intern(), str);
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate != null) {
                f868 = (f867 + 75) % 128;
                chartboostDelegate.didCloseRewardedVideo(str);
                f868 = (f867 + 13) % 128;
            }
        }

        public void didCompleteInterstitial(String str) {
            f868 = (f867 + 9) % 128;
            bj.this.m885(this, this.f872, m963((char) (TextUtils.getCapsMode("", 0, 0) + 26643), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 41, (ViewConfiguration.getTouchSlop() >> 8) + 331).intern(), str);
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate != null) {
                int i2 = f868 + 67;
                f867 = i2 % 128;
                int i8 = i2 % 2;
                chartboostDelegate.didCompleteInterstitial(str);
                if (i8 != 0) {
                    throw null;
                }
            }
        }

        public void didCompleteRewardedVideo(String str, int i2) {
            f867 = (f868 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) % 128;
            bj.this.m885(this, this.f872, m963((char) (ImageFormat.getBitsPerPixel(0) + 1), Gravity.getAbsoluteGravity(0, 0) + 43, (ViewConfiguration.getDoubleTapTimeout() >> 16) + IronSourceError.ERROR_RV_SHOW_EXCEPTION).intern(), str, Integer.valueOf(i2));
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate != null) {
                f867 = (f868 + 31) % 128;
                chartboostDelegate.didCompleteRewardedVideo(str, i2);
                f867 = (f868 + 49) % 128;
            }
        }

        public void didDismissInterstitial(String str) {
            f868 = (f867 + 93) % 128;
            bj.this.m885(this, this.f872, m963((char) (18346 - View.MeasureSpec.getMode(0)), 41 - Gravity.getAbsoluteGravity(0, 0), TextUtils.getOffsetAfter("", 0) + 171).intern(), str);
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate != null) {
                int i2 = f868 + 3;
                f867 = i2 % 128;
                int i8 = i2 % 2;
                chartboostDelegate.didDismissInterstitial(str);
                if (i8 != 0) {
                    throw null;
                }
            }
        }

        public void didDismissMoreApps(String str) {
            f867 = (f868 + 71) % 128;
            bj.this.m885(this, this.f872, m963((char) View.MeasureSpec.getMode(0), TextUtils.indexOf("", "") + 37, 527 - ExpandableListView.getPackedPositionChild(0L)).intern(), str);
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate != null) {
                chartboostDelegate.didDismissMoreApps(str);
            }
            f868 = (f867 + 7) % 128;
        }

        public void didDismissRewardedVideo(String str) {
            bj.this.m885(this, this.f872, m963((char) (27295 - Color.blue(0)), 42 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 916 - (Process.myPid() >> 22)).intern(), str);
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate != null) {
                f867 = (f868 + 111) % 128;
                chartboostDelegate.didDismissRewardedVideo(str);
            }
            f867 = (f868 + 13) % 128;
        }

        public void didDisplayInterstitial(String str) {
            f868 = (f867 + 85) % 128;
            bj.this.m885(this, this.f872, m963((char) TextUtils.getTrimmedLength(""), TextUtils.getCapsMode("", 0, 0) + 41, 291 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))).intern(), str);
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate != null) {
                chartboostDelegate.didDisplayInterstitial(str);
                f867 = (f868 + 1) % 128;
            }
        }

        public void didDisplayMoreApps(String str) {
            f868 = (f867 + 37) % 128;
            bj.this.m885(this, this.f872, m963((char) Color.alpha(0), 37 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (ViewConfiguration.getWindowTouchSlop() >> 8) + 635).intern(), str);
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate != null) {
                int i2 = f867 + 79;
                f868 = i2 % 128;
                int i8 = i2 % 2;
                chartboostDelegate.didDisplayMoreApps(str);
                if (i8 == 0) {
                    throw null;
                }
            }
        }

        public void didDisplayRewardedVideo(String str) {
            bj.this.m885(this, this.f872, m963((char) KeyEvent.normalizeMetaState(0), 42 - (ViewConfiguration.getTapTimeout() >> 16), 1081 - Color.green(0)).intern(), str);
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate != null) {
                f867 = (f868 + 63) % 128;
                chartboostDelegate.didDisplayRewardedVideo(str);
                f867 = (f868 + 59) % 128;
            }
            int i2 = f867 + 19;
            f868 = i2 % 128;
            if (i2 % 2 == 0) {
                throw null;
            }
        }

        public void didFailToLoadInPlay(String str, CBError.CBImpressionError cBImpressionError) {
            bj.this.m885(this, this.f872, m963((char) ((Process.myPid() >> 22) + 53988), AndroidCharacter.getMirror('0') - '\n', 1192 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))).intern(), str, cBImpressionError);
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate != null) {
                f867 = (f868 + 19) % 128;
                chartboostDelegate.didFailToLoadInPlay(str, cBImpressionError);
                f868 = (f867 + 23) % 128;
            }
        }

        public void didFailToLoadInterstitial(String str, CBError.CBImpressionError cBImpressionError) {
            f867 = (f868 + 101) % 128;
            bj.this.m885(this, this.f872, m963((char) (Color.green(0) + 9517), (ViewConfiguration.getEdgeSlop() >> 16) + 44, 127 - (ViewConfiguration.getTapTimeout() >> 16)).intern(), str, cBImpressionError);
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate != null) {
                int i2 = f867 + 97;
                f868 = i2 % 128;
                int i8 = i2 % 2;
                chartboostDelegate.didFailToLoadInterstitial(str, cBImpressionError);
                if (i8 == 0) {
                    throw null;
                }
            }
        }

        public void didFailToLoadMoreApps(String str, CBError.CBImpressionError cBImpressionError) {
            bj.this.m885(this, this.f872, m963((char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1), TextUtils.lastIndexOf("", '0', 0, 0) + 41, (-16776728) - Color.rgb(0, 0, 0)).intern(), str, cBImpressionError);
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate != null) {
                chartboostDelegate.didFailToLoadMoreApps(str, cBImpressionError);
                f867 = (f868 + 1) % 128;
            }
            int i2 = f867 + 53;
            f868 = i2 % 128;
            if (i2 % 2 == 0) {
                throw null;
            }
        }

        public void didFailToLoadRewardedVideo(String str, CBError.CBImpressionError cBImpressionError) {
            bj.this.m885(this, this.f872, m963((char) View.combineMeasuredStates(0, 0), 44 - TextUtils.indexOf((CharSequence) "", '0'), 871 - (ViewConfiguration.getLongPressTimeout() >> 16)).intern(), str, cBImpressionError);
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate != null) {
                int i2 = f868 + 17;
                f867 = i2 % 128;
                int i8 = i2 % 2;
                chartboostDelegate.didFailToLoadRewardedVideo(str, cBImpressionError);
                if (i8 != 0) {
                    throw null;
                }
            }
            f867 = (f868 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
        }

        public void didFailToRecordClick(String str, CBError.CBClickError cBClickError) {
            bj.this.m885(this, this.f872, m963((char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), ExpandableListView.getPackedPositionChild(0L) + 40, 672 - KeyEvent.normalizeMetaState(0)).intern(), str, cBClickError);
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate != null) {
                int i2 = f868 + 85;
                f867 = i2 % 128;
                int i8 = i2 % 2;
                chartboostDelegate.didFailToRecordClick(str, cBClickError);
                if (i8 != 0) {
                    throw null;
                }
            }
            f867 = (f868 + 7) % 128;
        }

        public void didInitialize() {
            f868 = (f867 + 55) % 128;
            bj.this.m885(this, this.f872, m963((char) Color.argb(0, 0, 0, 0), 32 - (Process.myTid() >> 22), 1229 - Color.red(0)).intern(), new Object[0]);
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate != null) {
                int i2 = f868 + 11;
                f867 = i2 % 128;
                int i8 = i2 % 2;
                chartboostDelegate.didInitialize();
                if (i8 != 0) {
                    throw null;
                }
            }
        }

        public void didPauseClickForConfirmation(Activity activity) {
            f867 = (f868 + 67) % 128;
            bj.this.m885(this, this.f872, m963((char) (30067 - TextUtils.indexOf("", "", 0, 0)), (ViewConfiguration.getWindowTouchSlop() >> 8) + 47, 710 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)).intern(), activity);
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate != null) {
                f867 = (f868 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
                try {
                    chartboostDelegate.getClass().getDeclaredMethod(m963((char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 36198), ((Process.getThreadPriority(0) + 20) >> 6) + 28, (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 758).intern(), Activity.class).invoke(this.f871, activity);
                } catch (Throwable unused) {
                }
            }
        }

        public boolean shouldDisplayInterstitial(String str) {
            f867 = (f868 + 3) % 128;
            bj.this.m885(this, this.f872, m963((char) (TextUtils.indexOf((CharSequence) "", '0') + 14128), 44 - TextUtils.getOffsetBefore("", 0), 44 - Color.blue(0)).intern(), str);
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate == null) {
                return false;
            }
            boolean zShouldDisplayInterstitial = chartboostDelegate.shouldDisplayInterstitial(str);
            int i2 = f868 + 81;
            f867 = i2 % 128;
            if (i2 % 2 == 0) {
                return zShouldDisplayInterstitial;
            }
            throw null;
        }

        public boolean shouldDisplayMoreApps(String str) {
            f868 = (f867 + 99) % 128;
            bj.this.m885(this, this.f872, m963((char) (55420 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)), 40 - View.combineMeasuredStates(0, 0), 447 - TextUtils.lastIndexOf("", '0', 0, 0)).intern(), str);
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate == null) {
                return false;
            }
            int i2 = f867 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
            f868 = i2 % 128;
            if (i2 % 2 != 0) {
                return chartboostDelegate.shouldDisplayMoreApps(str);
            }
            boolean zShouldDisplayMoreApps = chartboostDelegate.shouldDisplayMoreApps(str);
            int i8 = 83 / 0;
            return zShouldDisplayMoreApps;
        }

        public boolean shouldDisplayRewardedVideo(String str) {
            f867 = (f868 + 113) % 128;
            bj.this.m885(this, this.f872, m963((char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 30046), View.MeasureSpec.getSize(0) + 45, View.MeasureSpec.makeMeasureSpec(0, 0) + 786).intern(), str);
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate == null) {
                return false;
            }
            boolean zShouldDisplayRewardedVideo = chartboostDelegate.shouldDisplayRewardedVideo(str);
            f868 = (f867 + 17) % 128;
            return zShouldDisplayRewardedVideo;
        }

        public boolean shouldRequestInterstitial(String str) {
            f868 = (f867 + 87) % 128;
            bj.this.m885(this, this.f872, m963((char) ExpandableListView.getPackedPositionGroup(0L), 45 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))).intern(), str);
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate != null) {
                return chartboostDelegate.shouldRequestInterstitial(str);
            }
            f867 = (f868 + 69) % 128;
            return false;
        }

        public boolean shouldRequestMoreApps(String str) {
            f867 = (f868 + 99) % 128;
            bj.this.m885(this, this.f872, m963((char) (24349 - View.MeasureSpec.makeMeasureSpec(0, 0)), KeyEvent.normalizeMetaState(0) + 40, 373 - (Process.myPid() >> 22)).intern(), str);
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate == null) {
                return false;
            }
            f868 = (f867 + 95) % 128;
            return chartboostDelegate.shouldRequestMoreApps(str);
        }

        public void willDisplayVideo(String str) {
            f868 = (f867 + 59) % 128;
            bj.this.m885(this, this.f872, m963((char) (KeyEvent.getMaxKeyCode() >> 16), Color.green(0) + 35, Process.getGidForName("") + 1124).intern(), str);
            ChartboostDelegate chartboostDelegate = this.f871;
            if (chartboostDelegate != null) {
                int i2 = f868 + 31;
                f867 = i2 % 128;
                int i8 = i2 % 2;
                chartboostDelegate.willDisplayVideo(str);
                if (i8 != 0) {
                    throw null;
                }
            }
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.hc
        /* JADX INFO: renamed from: ｋ */
        public final /* synthetic */ ChartboostDelegate mo831() {
            f868 = (f867 + 3) % 128;
            ChartboostDelegate chartboostDelegateM962 = m962();
            int i2 = f868 + 49;
            f867 = i2 % 128;
            if (i2 % 2 != 0) {
                int i8 = 1 / 0;
            }
            return chartboostDelegateM962;
        }
    }

    public bj(String str) {
        super(str);
    }

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    private static boolean m942() {
        f852 = (f851 + 15) % 128;
        boolean z2 = m943() instanceof b;
        int i2 = f851 + 81;
        f852 = i2 % 128;
        if (i2 % 2 != 0) {
            return z2;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private static Object m943() {
        com.chartboost.sdk.a delegate;
        int i2 = f851 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
        f852 = i2 % 128;
        if (i2 % 2 == 0) {
            delegate = Chartboost.getDelegate();
            int i8 = 66 / 0;
        } else {
            delegate = Chartboost.getDelegate();
        }
        int i9 = f852 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
        f851 = i9 % 128;
        if (i9 % 2 == 0) {
            return delegate;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    public static /* synthetic */ boolean m944() {
        int i2 = f851 + 95;
        f852 = i2 % 128;
        if (i2 % 2 != 0) {
            return m945();
        }
        m945();
        throw null;
    }

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private static boolean m945() {
        f852 = (f851 + 3) % 128;
        boolean zIsWebViewEnabled = Chartboost.isWebViewEnabled();
        int i2 = f851 + 105;
        f852 = i2 % 128;
        if (i2 % 2 != 0) {
            return zIsWebViewEnabled;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private static Object m946() {
        f851 = (f852 + 65) % 128;
        com.chartboost.sdk.impl.a aVar = com.chartboost.sdk.g.d;
        int i2 = f852 + 63;
        f851 = i2 % 128;
        if (i2 % 2 == 0) {
            return aVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    public static /* synthetic */ Object m947() {
        f851 = (f852 + 13) % 128;
        Object objM943 = m943();
        f851 = (f852 + 19) % 128;
        return objM943;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public static /* synthetic */ Object m948() {
        int i2 = f851 + 33;
        f852 = i2 % 128;
        if (i2 % 2 != 0) {
            return m946();
        }
        m946();
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ void m952(ChartboostDelegate chartboostDelegate) {
        f852 = (f851 + 89) % 128;
        m959(chartboostDelegate);
        int i2 = f851 + 53;
        f852 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ String m953(CBInPlay cBInPlay) {
        f852 = (f851 + 73) % 128;
        String strM949 = m949(cBInPlay);
        f852 = (f851 + 75) % 128;
        return strM949;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ String m955(CBInPlay cBInPlay) {
        f851 = (f852 + 97) % 128;
        String strM958 = m958(cBInPlay);
        f852 = (f851 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
        return strM958;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ b m956(bj bjVar, ChartboostDelegate chartboostDelegate, ch chVar) {
        int i2 = f851 + 41;
        f852 = i2 % 128;
        int i8 = i2 % 2;
        b bVarM954 = bjVar.m954(chartboostDelegate, chVar);
        if (i8 == 0) {
            int i9 = 44 / 0;
        }
        int i10 = f851 + 111;
        f852 = i10 % 128;
        if (i10 % 2 == 0) {
            int i11 = 5 / 0;
        }
        return bVarM954;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻐ */
    public final String mo825() {
        int i2 = f851 + 111;
        f852 = i2 % 128;
        try {
            if (i2 % 2 == 0) {
                Chartboost.getSDKVersion();
                throw null;
            }
            String sDKVersion = Chartboost.getSDKVersion();
            f852 = (f851 + 103) % 128;
            return sDKVersion;
        } catch (Error unused) {
            return m957((char) (TextUtils.lastIndexOf("", '0') + 1), AndroidCharacter.getMirror('0') - '+', 134 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)).intern();
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ void m960(bj bjVar, ch chVar) {
        f851 = (f852 + 7) % 128;
        bjVar.m950(chVar);
        int i2 = f851 + 35;
        f852 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00c1  */
    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻛ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Class mo826(java.lang.String r21) {
        /*
            Method dump skipped, instruction units count: 992
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.bj.mo826(java.lang.String):java.lang.Class");
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﾇ */
    public final Map<String, bg.a> mo827() {
        HashMap map = new HashMap();
        map.put(m957((char) (Process.myPid() >> 22), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 13, 138 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bj.2
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                bj.m960(bj.this, chVar);
                return null;
            }
        });
        map.put(m957((char) (Process.myPid() >> 22), AndroidCharacter.getMirror('0') - 27, 152 - View.resolveSize(0, 0)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bj.4
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bj.m947();
            }
        });
        map.put(m957((char) (TextUtils.indexOf("", "", 0, 0) + 9568), TextUtils.lastIndexOf("", '0', 0) + 28, 173 - Color.blue(0)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bj.1
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bj.m948();
            }
        });
        map.put(m957((char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 26 - (Process.myPid() >> 22), 200 - View.resolveSizeAndState(0, 0, 0)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bj.3
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bj.m956(bj.this, (ChartboostDelegate) list.get(0), chVar);
            }
        });
        map.put(m951("媡☂婒ㄛ", (char) View.MeasureSpec.makeMeasureSpec(0, 0), "基ᓓᶉ廙ቛ霪访\udce3쥋뉱묻ꣲ栝썏쒧虈渁\ufddc业퍡\uda07", TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1378222683, "\u0000\u0000\u0000\u0000").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bj.5
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                bj.m952((ChartboostDelegate) list.get(0));
                return null;
            }
        });
        map.put(m957((char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 17 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 226 - (ViewConfiguration.getTapTimeout() >> 16)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bj.8
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return Boolean.valueOf(bj.m944());
            }
        });
        map.put(m951("薕\ud8b8ꮾ覡", (char) Color.blue(0), "쿔\uf732ꚉ뭖\uf078㕐\ud8a9\ue15b\uf6c8\uf689䲡", (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) - 1093093243, "\u0000\u0000\u0000\u0000").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bj.6
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bj.m953((CBInPlay) list.get(0));
            }
        });
        map.put(m951("繅튚䊲㓔", (char) TextUtils.getOffsetBefore("", 0), "빘쪥\uf249阦憝ጩ閍묃\uf0e1\uf8c6", AndroidCharacter.getMirror('0') - '0', "\u0000\u0000\u0000\u0000").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bj.7
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bj.m955((CBInPlay) list.get(0));
            }
        });
        map.put(m957((char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 639), 12 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 242 - (ViewConfiguration.getEdgeSlop() >> 16)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bj.10
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return Boolean.valueOf(bj.m961(bj.this));
            }
        });
        int i2 = f852 + 113;
        f851 = i2 % 128;
        if (i2 % 2 == 0) {
            return map;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ boolean m961(bj bjVar) {
        f851 = (f852 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
        boolean zM942 = m942();
        int i2 = f852 + 5;
        f851 = i2 % 128;
        if (i2 % 2 == 0) {
            return zM942;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static void m959(ChartboostDelegate chartboostDelegate) {
        int i2 = f851 + 25;
        f852 = i2 % 128;
        int i8 = i2 % 2;
        Chartboost.setDelegate(chartboostDelegate);
        if (i8 == 0) {
            throw null;
        }
        f851 = (f852 + 65) % 128;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m958(CBInPlay cBInPlay) {
        int i2 = f851 + 7;
        f852 = i2 % 128;
        if (i2 % 2 == 0) {
            cBInPlay.getAppName();
            throw null;
        }
        String appName = cBInPlay.getAppName();
        int i8 = f851 + 87;
        f852 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 8 / 0;
        }
        return appName;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private void m950(ch chVar) {
        f852 = (f851 + 111) % 128;
        m959(m954((ChartboostDelegate) m943(), chVar));
        f851 = (f852 + 73) % 128;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m957(char c7, int i2, int i8) {
        String str;
        synchronized (c.f1192) {
            try {
                char[] cArr = new char[i2];
                c.f1193 = 0;
                while (true) {
                    int i9 = c.f1193;
                    if (i9 < i2) {
                        cArr[i9] = (char) ((((long) f855[i8 + i9]) ^ (((long) i9) * f856)) ^ ((long) c7));
                        c.f1193 = i9 + 1;
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

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m949(CBInPlay cBInPlay) {
        int i2 = f852 + 49;
        f851 = i2 % 128;
        int i8 = i2 % 2;
        String location = cBInPlay.getLocation();
        if (i8 != 0) {
            int i9 = 6 / 0;
        }
        f851 = (f852 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) % 128;
        return location;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private b m954(ChartboostDelegate chartboostDelegate, ch chVar) {
        b bVar = new b(chartboostDelegate, chVar);
        int i2 = f851 + 55;
        f852 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 69 / 0;
        }
        return bVar;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m951(String str, char c7, String str2, int i2, String str3) {
        String str4;
        Object charArray = str3;
        if (str3 != null) {
            charArray = str3.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        Object charArray2 = str2;
        if (str2 != null) {
            charArray2 = str2.toCharArray();
        }
        char[] cArr2 = (char[]) charArray2;
        Object charArray3 = str;
        if (str != null) {
            charArray3 = str.toCharArray();
        }
        char[] cArr3 = (char[]) charArray3;
        synchronized (f.f2031) {
            try {
                char[] cArr4 = (char[]) cArr3.clone();
                char[] cArr5 = (char[]) cArr.clone();
                cArr4[0] = (char) (c7 ^ cArr4[0]);
                cArr5[2] = (char) (cArr5[2] + ((char) i2));
                int length = cArr2.length;
                char[] cArr6 = new char[length];
                f.f2032 = 0;
                while (true) {
                    int i8 = f.f2032;
                    if (i8 < length) {
                        int i9 = (i8 + 2) % 4;
                        int i10 = (i8 + 3) % 4;
                        int i11 = cArr4[i8 % 4] * 32718;
                        char c8 = cArr5[i9];
                        char c9 = (char) ((i11 + c8) % 65535);
                        f.f2030 = c9;
                        cArr5[i10] = (char) com.google.android.gms.ads.internal.client.a.w(cArr4[i10], 32718, c8, 65535);
                        cArr4[i10] = c9;
                        int i12 = f.f2032;
                        cArr6[i12] = (char) (((((long) (c9 ^ cArr2[i12])) ^ f853) ^ ((long) f857)) ^ ((long) f854));
                        f.f2032 = i12 + 1;
                    } else {
                        str4 = new String(cArr6);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str4;
    }
}
