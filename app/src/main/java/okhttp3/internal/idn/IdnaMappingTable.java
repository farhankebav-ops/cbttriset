package okhttp3.internal.idn;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class IdnaMappingTable {
    private final String mappings;
    private final String ranges;
    private final String sections;

    public IdnaMappingTable(String sections, String ranges, String mappings) {
        k.e(sections, "sections");
        k.e(ranges, "ranges");
        k.e(mappings, "mappings");
        this.sections = sections;
        this.ranges = ranges;
        this.mappings = mappings;
    }

    private final int findRangesOffset(int i2, int i8, int i9) {
        int i10;
        int i11 = i2 & 127;
        int i12 = i9 - 1;
        while (true) {
            if (i8 > i12) {
                i10 = (-i8) - 1;
                break;
            }
            i10 = (i8 + i12) / 2;
            int iG = k.g(i11, this.ranges.charAt(i10 * 4));
            if (iG >= 0) {
                if (iG <= 0) {
                    break;
                }
                i8 = i10 + 1;
            } else {
                i12 = i10 - 1;
            }
        }
        return i10 >= 0 ? i10 * 4 : ((-i10) - 2) * 4;
    }

    private final int findSectionsIndex(int i2) {
        int i8;
        int i9 = (i2 & 2097024) >> 7;
        int length = (this.sections.length() / 4) - 1;
        int i10 = 0;
        while (true) {
            if (i10 > length) {
                i8 = (-i10) - 1;
                break;
            }
            i8 = (i10 + length) / 2;
            int iG = k.g(i9, IdnaMappingTableKt.read14BitInt(this.sections, i8 * 4));
            if (iG >= 0) {
                if (iG <= 0) {
                    break;
                }
                i10 = i8 + 1;
            } else {
                length = i8 - 1;
            }
        }
        return i8 >= 0 ? i8 * 4 : ((-i8) - 2) * 4;
    }

    public final String getMappings() {
        return this.mappings;
    }

    public final String getRanges() {
        return this.ranges;
    }

    public final String getSections() {
        return this.sections;
    }

    public final boolean map(int i2, l7.k sink) {
        k.e(sink, "sink");
        int iFindSectionsIndex = findSectionsIndex(i2);
        int iFindRangesOffset = findRangesOffset(i2, IdnaMappingTableKt.read14BitInt(this.sections, iFindSectionsIndex + 2), iFindSectionsIndex + 4 < this.sections.length() ? IdnaMappingTableKt.read14BitInt(this.sections, iFindSectionsIndex + 6) : this.ranges.length() / 4);
        char cCharAt = this.ranges.charAt(iFindRangesOffset + 1);
        if (cCharAt >= 0 && cCharAt < '@') {
            int i8 = IdnaMappingTableKt.read14BitInt(this.ranges, iFindRangesOffset + 2);
            sink.S(i8, cCharAt + i8, this.mappings);
            return true;
        }
        if ('@' <= cCharAt && cCharAt < 'P') {
            sink.A(i2 - (this.ranges.charAt(iFindRangesOffset + 3) | (((cCharAt & 15) << 14) | (this.ranges.charAt(iFindRangesOffset + 2) << 7))));
            return true;
        }
        if ('P' <= cCharAt && cCharAt < '`') {
            sink.A(i2 + (this.ranges.charAt(iFindRangesOffset + 3) | ((cCharAt & 15) << 14) | (this.ranges.charAt(iFindRangesOffset + 2) << 7)));
            return true;
        }
        if (cCharAt == 'w') {
            return true;
        }
        if (cCharAt == 'x') {
            sink.A(i2);
            return true;
        }
        if (cCharAt == 'y') {
            sink.A(i2);
            return false;
        }
        if (cCharAt == 'z') {
            sink.writeByte(this.ranges.charAt(iFindRangesOffset + 2));
            return true;
        }
        if (cCharAt == '{') {
            sink.writeByte(this.ranges.charAt(iFindRangesOffset + 2) | 128);
            return true;
        }
        if (cCharAt == '|') {
            sink.writeByte(this.ranges.charAt(iFindRangesOffset + 2));
            sink.writeByte(this.ranges.charAt(iFindRangesOffset + 3));
            return true;
        }
        if (cCharAt == '}') {
            sink.writeByte(this.ranges.charAt(iFindRangesOffset + 2) | 128);
            sink.writeByte(this.ranges.charAt(iFindRangesOffset + 3));
            return true;
        }
        if (cCharAt == '~') {
            sink.writeByte(this.ranges.charAt(iFindRangesOffset + 2));
            sink.writeByte(this.ranges.charAt(iFindRangesOffset + 3) | 128);
            return true;
        }
        if (cCharAt == 127) {
            sink.writeByte(this.ranges.charAt(iFindRangesOffset + 2) | 128);
            sink.writeByte(this.ranges.charAt(iFindRangesOffset + 3) | 128);
            return true;
        }
        throw new IllegalStateException(("unexpected rangesIndex for " + i2).toString());
    }
}
