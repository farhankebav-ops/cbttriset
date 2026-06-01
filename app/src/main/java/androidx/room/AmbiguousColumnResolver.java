package androidx.room;

import androidx.annotation.RestrictTo;
import com.ironsource.adqualitysdk.sdk.i.a0;
import e6.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.x;
import r5.n;
import r5.r;
import r5.v;
import s5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class AmbiguousColumnResolver {
    public static final AmbiguousColumnResolver INSTANCE = new AmbiguousColumnResolver();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Match {
        private final List<Integer> resultIndices;
        private final k6.d resultRange;

        public Match(k6.d resultRange, List<Integer> resultIndices) {
            k.e(resultRange, "resultRange");
            k.e(resultIndices, "resultIndices");
            this.resultRange = resultRange;
            this.resultIndices = resultIndices;
        }

        public final List<Integer> getResultIndices() {
            return this.resultIndices;
        }

        public final k6.d getResultRange() {
            return this.resultRange;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class ResultColumn {
        private final int index;
        private final String name;

        public ResultColumn(String name, int i2) {
            k.e(name, "name");
            this.name = name;
            this.index = i2;
        }

        public static /* synthetic */ ResultColumn copy$default(ResultColumn resultColumn, String str, int i2, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                str = resultColumn.name;
            }
            if ((i8 & 2) != 0) {
                i2 = resultColumn.index;
            }
            return resultColumn.copy(str, i2);
        }

        public final String component1() {
            return this.name;
        }

        public final int component2() {
            return this.index;
        }

        public final ResultColumn copy(String name, int i2) {
            k.e(name, "name");
            return new ResultColumn(name, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResultColumn)) {
                return false;
            }
            ResultColumn resultColumn = (ResultColumn) obj;
            return k.a(this.name, resultColumn.name) && this.index == resultColumn.index;
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.index;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ResultColumn(name=");
            sb.append(this.name);
            sb.append(", index=");
            return a0.c(sb, this.index, ')');
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Solution implements Comparable<Solution> {
        public static final Companion Companion = new Companion(null);
        private static final Solution NO_SOLUTION = new Solution(r.f13638a, Integer.MAX_VALUE, Integer.MAX_VALUE);
        private final int coverageOffset;
        private final List<Match> matches;
        private final int overlaps;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
                this();
            }

            public final Solution build(List<Match> matches) {
                k.e(matches, "matches");
                int i2 = 0;
                int size = 0;
                for (Match match : matches) {
                    size += ((match.getResultRange().f12710b - match.getResultRange().f12709a) + 1) - match.getResultIndices().size();
                }
                Iterator<T> it = matches.iterator();
                if (!it.hasNext()) {
                    throw new NoSuchElementException();
                }
                int i8 = ((Match) it.next()).getResultRange().f12709a;
                while (it.hasNext()) {
                    int i9 = ((Match) it.next()).getResultRange().f12709a;
                    if (i8 > i9) {
                        i8 = i9;
                    }
                }
                Iterator<T> it2 = matches.iterator();
                if (!it2.hasNext()) {
                    throw new NoSuchElementException();
                }
                int i10 = ((Match) it2.next()).getResultRange().f12710b;
                while (it2.hasNext()) {
                    int i11 = ((Match) it2.next()).getResultRange().f12710b;
                    if (i10 < i11) {
                        i10 = i11;
                    }
                }
                Iterable dVar = new k6.d(i8, i10, 1);
                if (!(dVar instanceof Collection) || !((Collection) dVar).isEmpty()) {
                    Iterator it3 = dVar.iterator();
                    int i12 = 0;
                    while (((k6.c) it3).f12714c) {
                        int iNextInt = ((v) it3).nextInt();
                        Iterator<T> it4 = matches.iterator();
                        int i13 = 0;
                        while (true) {
                            if (it4.hasNext()) {
                                k6.d resultRange = ((Match) it4.next()).getResultRange();
                                if (resultRange.f12709a <= iNextInt && iNextInt <= resultRange.f12710b) {
                                    i13++;
                                }
                                if (i13 > 1) {
                                    i12++;
                                    if (i12 < 0) {
                                        throw new ArithmeticException("Count overflow has happened.");
                                    }
                                }
                            }
                        }
                    }
                    i2 = i12;
                }
                return new Solution(matches, size, i2);
            }

            public final Solution getNO_SOLUTION() {
                return Solution.NO_SOLUTION;
            }

            private Companion() {
            }
        }

        public Solution(List<Match> matches, int i2, int i8) {
            k.e(matches, "matches");
            this.matches = matches;
            this.coverageOffset = i2;
            this.overlaps = i8;
        }

        public final int getCoverageOffset() {
            return this.coverageOffset;
        }

        public final List<Match> getMatches() {
            return this.matches;
        }

        public final int getOverlaps() {
            return this.overlaps;
        }

        @Override // java.lang.Comparable
        public int compareTo(Solution other) {
            k.e(other, "other");
            int iG = k.g(this.overlaps, other.overlaps);
            return iG != 0 ? iG : k.g(this.coverageOffset, other.coverageOffset);
        }
    }

    /* JADX INFO: renamed from: androidx.room.AmbiguousColumnResolver$resolve$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass4 extends l implements e6.l {
        final /* synthetic */ kotlin.jvm.internal.a0 $bestSolution;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(kotlin.jvm.internal.a0 a0Var) {
            super(1);
            this.$bestSolution = a0Var;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List<Match>) obj);
            return x.f13520a;
        }

        public final void invoke(List<Match> it) {
            k.e(it, "it");
            Solution solutionBuild = Solution.Companion.build(it);
            if (solutionBuild.compareTo((Solution) this.$bestSolution.f12717a) < 0) {
                this.$bestSolution.f12717a = solutionBuild;
            }
        }
    }

    private AmbiguousColumnResolver() {
    }

    private final <T> void dfs(List<? extends List<? extends T>> list, List<T> list2, int i2, e6.l lVar) {
        if (i2 == list.size()) {
            lVar.invoke(r5.l.n1(list2));
            return;
        }
        Iterator<T> it = list.get(i2).iterator();
        while (it.hasNext()) {
            list2.add(it.next());
            INSTANCE.dfs(list, list2, i2 + 1, lVar);
            r5.l.h1(list2);
        }
    }

    public static /* synthetic */ void dfs$default(AmbiguousColumnResolver ambiguousColumnResolver, List list, List list2, int i2, e6.l lVar, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            list2 = new ArrayList();
        }
        if ((i8 & 4) != 0) {
            i2 = 0;
        }
        ambiguousColumnResolver.dfs(list, list2, i2, lVar);
    }

    private final void rabinKarpSearch(List<ResultColumn> list, String[] strArr, q qVar) {
        int i2 = 0;
        int iHashCode = 0;
        for (String str : strArr) {
            iHashCode += str.hashCode();
        }
        int length = strArr.length;
        Iterator<T> it = list.subList(0, length).iterator();
        int iHashCode2 = 0;
        while (it.hasNext()) {
            iHashCode2 += ((ResultColumn) it.next()).getName().hashCode();
        }
        while (true) {
            if (iHashCode == iHashCode2) {
                qVar.invoke(Integer.valueOf(i2), Integer.valueOf(length), list.subList(i2, length));
            }
            int i8 = i2 + 1;
            int i9 = length + 1;
            if (i9 > list.size()) {
                return;
            }
            iHashCode2 = (iHashCode2 - list.get(i2).getName().hashCode()) + list.get(length).getName().hashCode();
            i2 = i8;
            length = i9;
        }
    }

    public static final int[][] resolve(String[] resultColumns, String[][] mappings) {
        k.e(resultColumns, "resultColumns");
        k.e(mappings, "mappings");
        int length = resultColumns.length;
        int i2 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            String strSubstring = resultColumns[i8];
            if (strSubstring.charAt(0) == '`' && strSubstring.charAt(strSubstring.length() - 1) == '`') {
                strSubstring = strSubstring.substring(1, strSubstring.length() - 1);
                k.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            Locale US = Locale.US;
            k.d(US, "US");
            String lowerCase = strSubstring.toLowerCase(US);
            k.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            resultColumns[i8] = lowerCase;
        }
        int length2 = mappings.length;
        for (int i9 = 0; i9 < length2; i9++) {
            int length3 = mappings[i9].length;
            for (int i10 = 0; i10 < length3; i10++) {
                String[] strArr = mappings[i9];
                String str = strArr[i10];
                Locale US2 = Locale.US;
                k.d(US2, "US");
                String lowerCase2 = str.toLowerCase(US2);
                k.d(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                strArr[i10] = lowerCase2;
            }
        }
        i iVar = new i();
        for (String[] strArr2 : mappings) {
            r5.l.R0(iVar, strArr2);
        }
        i iVarF = n7.b.f(iVar);
        s5.c cVarN = r2.q.N();
        int length4 = resultColumns.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length4) {
            String str2 = resultColumns[i11];
            int i13 = i12 + 1;
            if (iVarF.f13717a.containsKey(str2)) {
                cVarN.add(new ResultColumn(str2, i12));
            }
            i11++;
            i12 = i13;
        }
        s5.c cVarO = r2.q.o(cVarN);
        int length5 = mappings.length;
        ArrayList arrayList = new ArrayList(length5);
        for (int i14 = 0; i14 < length5; i14++) {
            arrayList.add(new ArrayList());
        }
        int length6 = mappings.length;
        int i15 = 0;
        int i16 = 0;
        while (i15 < length6) {
            String[] strArr3 = mappings[i15];
            int i17 = i16 + 1;
            INSTANCE.rabinKarpSearch(cVarO, strArr3, new AmbiguousColumnResolver$resolve$1$1(strArr3, arrayList, i16));
            if (((List) arrayList.get(i16)).isEmpty()) {
                ArrayList arrayList2 = new ArrayList(strArr3.length);
                int length7 = strArr3.length;
                int i18 = i2;
                while (i18 < length7) {
                    String str3 = strArr3[i18];
                    s5.c cVarN2 = r2.q.N();
                    ListIterator listIterator = cVarO.listIterator(i2);
                    while (true) {
                        s5.a aVar = (s5.a) listIterator;
                        if (!aVar.hasNext()) {
                            break;
                        }
                        ResultColumn resultColumn = (ResultColumn) aVar.next();
                        if (k.a(str3, resultColumn.getName())) {
                            cVarN2.add(Integer.valueOf(resultColumn.getIndex()));
                        }
                    }
                    s5.c cVarO2 = r2.q.o(cVarN2);
                    if (cVarO2.isEmpty()) {
                        throw new IllegalStateException(a1.a.m("Column ", str3, " not found in result").toString());
                    }
                    arrayList2.add(cVarO2);
                    i18++;
                    i2 = 0;
                }
                dfs$default(INSTANCE, arrayList2, null, 0, new AmbiguousColumnResolver$resolve$1$2(arrayList, i16), 6, null);
            }
            i15++;
            i16 = i17;
            i2 = 0;
        }
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            int i19 = 0;
            while (i19 < size) {
                Object obj = arrayList.get(i19);
                i19++;
                if (((List) obj).isEmpty()) {
                    throw new IllegalStateException("Failed to find matches for all mappings");
                }
            }
        }
        kotlin.jvm.internal.a0 a0Var = new kotlin.jvm.internal.a0();
        a0Var.f12717a = Solution.Companion.getNO_SOLUTION();
        dfs$default(INSTANCE, arrayList, null, 0, new AnonymousClass4(a0Var), 6, null);
        List<Match> matches = ((Solution) a0Var.f12717a).getMatches();
        ArrayList arrayList3 = new ArrayList(n.L0(matches, 10));
        Iterator<T> it = matches.iterator();
        while (it.hasNext()) {
            arrayList3.add(r5.l.m1(((Match) it.next()).getResultIndices()));
        }
        Object[] array = arrayList3.toArray(new int[0][]);
        k.c(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (int[][]) array;
    }
}
