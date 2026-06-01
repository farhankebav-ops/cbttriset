package okhttp3.internal.publicsuffix;

import androidx.webkit.ProxyConfig;
import java.net.IDN;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import l7.m;
import m6.d;
import m6.h;
import n6.a;
import okhttp3.internal._UtilCommonKt;
import r2.q;
import r4.c;
import r5.l;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class PublicSuffixDatabase {
    public static final Companion Companion = new Companion(null);
    private static final char EXCEPTION_MARKER = '!';
    private static final List<String> PREVAILING_RULE;
    private static final m WILDCARD_LABEL;
    private static final PublicSuffixDatabase instance;
    private final PublicSuffixList publicSuffixList;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String binarySearch(m mVar, m[] mVarArr, int i2) {
            int i8;
            int iAnd;
            boolean z2;
            int iAnd2;
            int iD = mVar.d();
            int i9 = 0;
            while (i9 < iD) {
                int i10 = (i9 + iD) / 2;
                while (i10 > -1 && mVar.i(i10) != 10) {
                    i10--;
                }
                int i11 = i10 + 1;
                int i12 = 1;
                while (true) {
                    i8 = i11 + i12;
                    if (mVar.i(i8) == 10) {
                        break;
                    }
                    i12++;
                }
                int i13 = i8 - i11;
                int i14 = i2;
                boolean z7 = false;
                int i15 = 0;
                int i16 = 0;
                while (true) {
                    if (z7) {
                        iAnd = 46;
                        z2 = false;
                    } else {
                        boolean z8 = z7;
                        iAnd = _UtilCommonKt.and(mVarArr[i14].i(i15), 255);
                        z2 = z8;
                    }
                    iAnd2 = iAnd - _UtilCommonKt.and(mVar.i(i11 + i16), 255);
                    if (iAnd2 != 0) {
                        break;
                    }
                    i16++;
                    i15++;
                    if (i16 == i13) {
                        break;
                    }
                    if (mVarArr[i14].d() != i15) {
                        z7 = z2;
                    } else {
                        if (i14 == mVarArr.length - 1) {
                            break;
                        }
                        i14++;
                        z7 = true;
                        i15 = -1;
                    }
                }
                if (iAnd2 >= 0) {
                    if (iAnd2 <= 0) {
                        int i17 = i13 - i16;
                        int iD2 = mVarArr[i14].d() - i15;
                        int length = mVarArr.length;
                        for (int i18 = i14 + 1; i18 < length; i18++) {
                            iD2 += mVarArr[i18].d();
                        }
                        if (iD2 >= i17) {
                            if (iD2 <= i17) {
                                return mVar.p(i11, i13 + i11).o(a.f13073a);
                            }
                        }
                    }
                    i9 = i8 + 1;
                }
                iD = i10;
            }
            return null;
        }

        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.instance;
        }

        private Companion() {
        }
    }

    static {
        m mVar = m.f12880d;
        WILDCARD_LABEL = c.f(42);
        PREVAILING_RULE = q.j0(ProxyConfig.MATCH_ALL_SCHEMES);
        instance = new PublicSuffixDatabase(PublicSuffixList_androidKt.getDefault(PublicSuffixList.Companion));
    }

    public PublicSuffixDatabase(PublicSuffixList publicSuffixList) {
        k.e(publicSuffixList, "publicSuffixList");
        this.publicSuffixList = publicSuffixList;
    }

    private final List<String> findMatchingRule(List<String> list) {
        String str;
        String strBinarySearch;
        String strBinarySearch2;
        this.publicSuffixList.ensureLoaded();
        int size = list.size();
        m[] mVarArr = new m[size];
        for (int i2 = 0; i2 < size; i2++) {
            m mVar = m.f12880d;
            mVarArr[i2] = c.e(list.get(i2));
        }
        int i8 = 0;
        while (true) {
            str = null;
            if (i8 >= size) {
                strBinarySearch = null;
                break;
            }
            strBinarySearch = Companion.binarySearch(this.publicSuffixList.getBytes(), mVarArr, i8);
            if (strBinarySearch != null) {
                break;
            }
            i8++;
        }
        if (size > 1) {
            m[] mVarArr2 = (m[]) mVarArr.clone();
            int length = mVarArr2.length - 1;
            for (int i9 = 0; i9 < length; i9++) {
                mVarArr2[i9] = WILDCARD_LABEL;
                strBinarySearch2 = Companion.binarySearch(this.publicSuffixList.getBytes(), mVarArr2, i9);
                if (strBinarySearch2 != null) {
                    break;
                }
            }
            strBinarySearch2 = null;
        } else {
            strBinarySearch2 = null;
        }
        if (strBinarySearch2 != null) {
            int i10 = size - 1;
            int i11 = 0;
            while (true) {
                if (i11 >= i10) {
                    break;
                }
                String strBinarySearch3 = Companion.binarySearch(this.publicSuffixList.getExceptionBytes(), mVarArr, i11);
                if (strBinarySearch3 != null) {
                    str = strBinarySearch3;
                    break;
                }
                i11++;
            }
        }
        if (str != null) {
            return n6.m.J0("!".concat(str), new char[]{'.'});
        }
        if (strBinarySearch == null && strBinarySearch2 == null) {
            return PREVAILING_RULE;
        }
        List<String> listJ0 = r.f13638a;
        List<String> listJ02 = strBinarySearch != null ? n6.m.J0(strBinarySearch, new char[]{'.'}) : listJ0;
        if (strBinarySearch2 != null) {
            listJ0 = n6.m.J0(strBinarySearch2, new char[]{'.'});
        }
        return listJ02.size() > listJ0.size() ? listJ02 : listJ0;
    }

    private final List<String> splitDomain(String str) {
        List<String> listJ0 = n6.m.J0(str, new char[]{'.'});
        if (!k.a(l.d1(listJ0), "")) {
            return listJ0;
        }
        int size = listJ0.size() - 1;
        return l.k1(size >= 0 ? size : 0, listJ0);
    }

    public final String getEffectiveTldPlusOne(String domain) {
        int size;
        int size2;
        k.e(domain, "domain");
        String unicode = IDN.toUnicode(domain);
        k.b(unicode);
        List<String> listSplitDomain = splitDomain(unicode);
        List<String> listFindMatchingRule = findMatchingRule(listSplitDomain);
        if (listSplitDomain.size() == listFindMatchingRule.size() && listFindMatchingRule.get(0).charAt(0) != '!') {
            return null;
        }
        if (listFindMatchingRule.get(0).charAt(0) == '!') {
            size = listSplitDomain.size();
            size2 = listFindMatchingRule.size();
        } else {
            size = listSplitDomain.size();
            size2 = listFindMatchingRule.size() + 1;
        }
        int i2 = size - size2;
        h hVarS0 = l.S0(splitDomain(domain));
        if (i2 < 0) {
            throw new IllegalArgumentException(a1.a.h(i2, "Requested element count ", " is less than zero.").toString());
        }
        if (i2 != 0) {
            hVarS0 = hVarS0 instanceof d ? ((d) hVarS0).a(i2) : new m6.c(hVarS0, i2, 0);
        }
        return m6.k.I0(hVarS0, ".");
    }
}
