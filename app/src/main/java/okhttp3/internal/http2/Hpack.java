package okhttp3.internal.http2;

import androidx.webkit.ProxyConfig;
import com.ironsource.C2270ca;
import com.ironsource.Ib;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;
import l7.l;
import l7.m;
import l7.o0;
import okhttp3.internal._UtilCommonKt;
import r5.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class Hpack {
    public static final Hpack INSTANCE;
    private static final Map<m, Integer> NAME_TO_FIRST_INDEX;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
    private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
    private static final Header[] STATIC_HEADER_TABLE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Reader {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        public int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final l source;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Reader(o0 source, int i2) {
            this(source, i2, 0, 4, null);
            k.e(source, "source");
        }

        private final void adjustDynamicTableByteCount() {
            int i2 = this.maxDynamicTableByteCount;
            int i8 = this.dynamicTableByteCount;
            if (i2 < i8) {
                if (i2 == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i8 - i2);
                }
            }
        }

        private final void clearDynamicTable() {
            Header[] headerArr = this.dynamicTable;
            j.k0(null, headerArr, 0, headerArr.length);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int dynamicTableIndex(int i2) {
            return this.nextHeaderIndex + 1 + i2;
        }

        private final int evictToRecoverBytes(int i2) {
            int i8;
            int i9 = 0;
            if (i2 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i8 = this.nextHeaderIndex;
                    if (length < i8 || i2 <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    k.b(header);
                    int i10 = header.hpackSize;
                    i2 -= i10;
                    this.dynamicTableByteCount -= i10;
                    this.headerCount--;
                    i9++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i8 + 1, headerArr, i8 + 1 + i9, this.headerCount);
                this.nextHeaderIndex += i9;
            }
            return i9;
        }

        private final m getName(int i2) throws IOException {
            if (isStaticHeader(i2)) {
                return Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i2].name;
            }
            int iDynamicTableIndex = dynamicTableIndex(i2 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (iDynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (iDynamicTableIndex < headerArr.length) {
                    Header header = headerArr[iDynamicTableIndex];
                    k.b(header);
                    return header.name;
                }
            }
            throw new IOException("Header index too large " + (i2 + 1));
        }

        private final void insertIntoDynamicTable(int i2, Header header) {
            this.headerList.add(header);
            int i8 = header.hpackSize;
            if (i2 != -1) {
                Header header2 = this.dynamicTable[dynamicTableIndex(i2)];
                k.b(header2);
                i8 -= header2.hpackSize;
            }
            int i9 = this.maxDynamicTableByteCount;
            if (i8 > i9) {
                clearDynamicTable();
                return;
            }
            int iEvictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i8) - i9);
            if (i2 == -1) {
                int i10 = this.headerCount + 1;
                Header[] headerArr = this.dynamicTable;
                if (i10 > headerArr.length) {
                    Header[] headerArr2 = new Header[headerArr.length * 2];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i11 = this.nextHeaderIndex;
                this.nextHeaderIndex = i11 - 1;
                this.dynamicTable[i11] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[dynamicTableIndex(i2) + iEvictToRecoverBytes + i2] = header;
            }
            this.dynamicTableByteCount += i8;
        }

        private final boolean isStaticHeader(int i2) {
            return i2 >= 0 && i2 <= Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length - 1;
        }

        private final int readByte() throws IOException {
            return _UtilCommonKt.and(this.source.readByte(), 255);
        }

        private final void readIndexedHeader(int i2) throws IOException {
            if (isStaticHeader(i2)) {
                this.headerList.add(Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i2]);
                return;
            }
            int iDynamicTableIndex = dynamicTableIndex(i2 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (iDynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (iDynamicTableIndex < headerArr.length) {
                    List<Header> list = this.headerList;
                    Header header = headerArr[iDynamicTableIndex];
                    k.b(header);
                    list.add(header);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i2 + 1));
        }

        private final void readLiteralHeaderWithIncrementalIndexingIndexedName(int i2) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(i2), readByteString()));
        }

        private final void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingIndexedName(int i2) throws IOException {
            this.headerList.add(new Header(getName(i2), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            this.headerList.add(new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        public final List<Header> getAndResetHeaderList() {
            List<Header> listN1 = r5.l.n1(this.headerList);
            this.headerList.clear();
            return listN1;
        }

        public final int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        public final m readByteString() throws IOException {
            int i2 = readByte();
            boolean z2 = (i2 & 128) == 128;
            long j = readInt(i2, 127);
            if (!z2) {
                return this.source.J(j);
            }
            l7.j jVar = new l7.j();
            Huffman.INSTANCE.decode(this.source, j, jVar);
            return jVar.J(jVar.f12868b);
        }

        public final void readHeaders() throws IOException {
            while (!this.source.M()) {
                int iAnd = _UtilCommonKt.and(this.source.readByte(), 255);
                if (iAnd == 128) {
                    throw new IOException("index == 0");
                }
                if ((iAnd & 128) == 128) {
                    readIndexedHeader(readInt(iAnd, 127) - 1);
                } else if (iAnd == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((iAnd & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(iAnd, 63) - 1);
                } else if ((iAnd & 32) == 32) {
                    int i2 = readInt(iAnd, 31);
                    this.maxDynamicTableByteCount = i2;
                    if (i2 < 0 || i2 > this.headerTableSizeSetting) {
                        throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                    adjustDynamicTableByteCount();
                } else if (iAnd == 16 || iAnd == 0) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(iAnd, 15) - 1);
                }
            }
        }

        public final int readInt(int i2, int i8) throws IOException {
            int i9 = i2 & i8;
            if (i9 < i8) {
                return i9;
            }
            int i10 = 0;
            while (true) {
                int i11 = readByte();
                if ((i11 & 128) == 0) {
                    return i8 + (i11 << i10);
                }
                i8 += (i11 & 127) << i10;
                i10 += 7;
            }
        }

        public Reader(o0 source, int i2, int i8) {
            k.e(source, "source");
            this.headerTableSizeSetting = i2;
            this.maxDynamicTableByteCount = i8;
            this.headerList = new ArrayList();
            this.source = l7.b.c(source);
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = 7;
        }

        public /* synthetic */ Reader(o0 o0Var, int i2, int i8, int i9, kotlin.jvm.internal.f fVar) {
            this(o0Var, i2, (i9 & 4) != 0 ? i2 : i8);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Writer {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        public int headerCount;
        public int headerTableSizeSetting;
        public int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final l7.j out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Writer(int i2, l7.j out) {
            this(i2, false, out, 2, null);
            k.e(out, "out");
        }

        private final void adjustDynamicTableByteCount() {
            int i2 = this.maxDynamicTableByteCount;
            int i8 = this.dynamicTableByteCount;
            if (i2 < i8) {
                if (i2 == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i8 - i2);
                }
            }
        }

        private final void clearDynamicTable() {
            Header[] headerArr = this.dynamicTable;
            j.k0(null, headerArr, 0, headerArr.length);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int evictToRecoverBytes(int i2) {
            int i8;
            int i9 = 0;
            if (i2 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i8 = this.nextHeaderIndex;
                    if (length < i8 || i2 <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    k.b(header);
                    i2 -= header.hpackSize;
                    int i10 = this.dynamicTableByteCount;
                    Header header2 = this.dynamicTable[length];
                    k.b(header2);
                    this.dynamicTableByteCount = i10 - header2.hpackSize;
                    this.headerCount--;
                    i9++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i8 + 1, headerArr, i8 + 1 + i9, this.headerCount);
                Header[] headerArr2 = this.dynamicTable;
                int i11 = this.nextHeaderIndex;
                Arrays.fill(headerArr2, i11 + 1, i11 + 1 + i9, (Object) null);
                this.nextHeaderIndex += i9;
            }
            return i9;
        }

        private final void insertIntoDynamicTable(Header header) {
            int i2 = header.hpackSize;
            int i8 = this.maxDynamicTableByteCount;
            if (i2 > i8) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i2) - i8);
            int i9 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (i9 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i10 = this.nextHeaderIndex;
            this.nextHeaderIndex = i10 - 1;
            this.dynamicTable[i10] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i2;
        }

        public final void resizeHeaderTable(int i2) {
            this.headerTableSizeSetting = i2;
            int iMin = Math.min(i2, 16384);
            int i8 = this.maxDynamicTableByteCount;
            if (i8 == iMin) {
                return;
            }
            if (iMin < i8) {
                this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, iMin);
            }
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = iMin;
            adjustDynamicTableByteCount();
        }

        public final void writeByteString(m data) throws IOException {
            k.e(data, "data");
            if (this.useCompression) {
                Huffman huffman = Huffman.INSTANCE;
                if (huffman.encodedLength(data) < data.d()) {
                    l7.j jVar = new l7.j();
                    huffman.encode(data, jVar);
                    m mVarJ = jVar.J(jVar.f12868b);
                    writeInt(mVarJ.d(), 127, 128);
                    this.out.w(mVarJ);
                    return;
                }
            }
            writeInt(data.d(), 127, 0);
            this.out.w(data);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0077  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void writeHeaders(java.util.List<okhttp3.internal.http2.Header> r13) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 264
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Hpack.Writer.writeHeaders(java.util.List):void");
        }

        public final void writeInt(int i2, int i8, int i9) {
            if (i2 < i8) {
                this.out.x(i2 | i9);
                return;
            }
            this.out.x(i9 | i8);
            int i10 = i2 - i8;
            while (i10 >= 128) {
                this.out.x(128 | (i10 & 127));
                i10 >>>= 7;
            }
            this.out.x(i10);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Writer(l7.j out) {
            this(0, false, out, 3, null);
            k.e(out, "out");
        }

        public Writer(int i2, boolean z2, l7.j out) {
            k.e(out, "out");
            this.headerTableSizeSetting = i2;
            this.useCompression = z2;
            this.out = out;
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.maxDynamicTableByteCount = i2;
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = r2.length - 1;
        }

        public /* synthetic */ Writer(int i2, boolean z2, l7.j jVar, int i8, kotlin.jvm.internal.f fVar) {
            this((i8 & 1) != 0 ? 4096 : i2, (i8 & 2) != 0 ? true : z2, jVar);
        }
    }

    static {
        Hpack hpack = new Hpack();
        INSTANCE = hpack;
        Header header = new Header(Header.TARGET_AUTHORITY, "");
        m mVar = Header.TARGET_METHOD;
        Header header2 = new Header(mVar, "GET");
        Header header3 = new Header(mVar, "POST");
        m mVar2 = Header.TARGET_PATH;
        Header header4 = new Header(mVar2, "/");
        Header header5 = new Header(mVar2, "/index.html");
        m mVar3 = Header.TARGET_SCHEME;
        Header header6 = new Header(mVar3, ProxyConfig.MATCH_HTTP);
        Header header7 = new Header(mVar3, "https");
        m mVar4 = Header.RESPONSE_STATUS;
        STATIC_HEADER_TABLE = new Header[]{header, header2, header3, header4, header5, header6, header7, new Header(mVar4, "200"), new Header(mVar4, "204"), new Header(mVar4, "206"), new Header(mVar4, "304"), new Header(mVar4, "400"), new Header(mVar4, "404"), new Header(mVar4, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header(C2270ca.m, ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header(Ib.f6986a, ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
        NAME_TO_FIRST_INDEX = hpack.nameToFirstIndex();
    }

    private Hpack() {
    }

    private final Map<m, Integer> nameToFirstIndex() {
        Header[] headerArr = STATIC_HEADER_TABLE;
        LinkedHashMap linkedHashMap = new LinkedHashMap(headerArr.length, 1.0f);
        int length = headerArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            Header[] headerArr2 = STATIC_HEADER_TABLE;
            if (!linkedHashMap.containsKey(headerArr2[i2].name)) {
                linkedHashMap.put(headerArr2[i2].name, Integer.valueOf(i2));
            }
        }
        Map<m, Integer> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        k.d(mapUnmodifiableMap, "unmodifiableMap(...)");
        return mapUnmodifiableMap;
    }

    public final m checkLowercase(m name) throws IOException {
        k.e(name, "name");
        int iD = name.d();
        for (int i2 = 0; i2 < iD; i2++) {
            byte bI = name.i(i2);
            if (65 <= bI && bI < 91) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: ".concat(name.t()));
            }
        }
        return name;
    }

    public final Map<m, Integer> getNAME_TO_FIRST_INDEX() {
        return NAME_TO_FIRST_INDEX;
    }

    public final Header[] getSTATIC_HEADER_TABLE() {
        return STATIC_HEADER_TABLE;
    }
}
