package androidx.constraintlayout.core.parser;

import a1.a;
import androidx.annotation.NonNull;
import androidx.core.location.LocationRequestCompat;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class CLElement implements Cloneable {
    protected static int sBaseIndent = 2;
    protected static int sMaxLine = 80;
    protected CLContainer mContainer;
    private final char[] mContent;
    private int mLine;
    protected long mStart = -1;
    protected long mEnd = LocationRequestCompat.PASSIVE_INTERVAL;

    public CLElement(char[] cArr) {
        this.mContent = cArr;
    }

    public void addIndent(StringBuilder sb, int i2) {
        for (int i8 = 0; i8 < i2; i8++) {
            sb.append(' ');
        }
    }

    public String content() {
        String str = new String(this.mContent);
        if (str.length() < 1) {
            return "";
        }
        long j = this.mEnd;
        if (j != LocationRequestCompat.PASSIVE_INTERVAL) {
            long j3 = this.mStart;
            if (j >= j3) {
                return str.substring((int) j3, ((int) j) + 1);
            }
        }
        long j8 = this.mStart;
        return str.substring((int) j8, ((int) j8) + 1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CLElement)) {
            return false;
        }
        CLElement cLElement = (CLElement) obj;
        if (this.mStart == cLElement.mStart && this.mEnd == cLElement.mEnd && this.mLine == cLElement.mLine && Arrays.equals(this.mContent, cLElement.mContent)) {
            return Objects.equals(this.mContainer, cLElement.mContainer);
        }
        return false;
    }

    public CLElement getContainer() {
        return this.mContainer;
    }

    public String getDebugName() {
        if (!CLParser.sDebug) {
            return "";
        }
        return getStrClass() + " -> ";
    }

    public long getEnd() {
        return this.mEnd;
    }

    public float getFloat() {
        if (this instanceof CLNumber) {
            return ((CLNumber) this).getFloat();
        }
        return Float.NaN;
    }

    public int getInt() {
        if (this instanceof CLNumber) {
            return ((CLNumber) this).getInt();
        }
        return 0;
    }

    public int getLine() {
        return this.mLine;
    }

    public long getStart() {
        return this.mStart;
    }

    public String getStrClass() {
        String string = getClass().toString();
        return string.substring(string.lastIndexOf(46) + 1);
    }

    public boolean hasContent() {
        char[] cArr = this.mContent;
        return cArr != null && cArr.length >= 1;
    }

    public int hashCode() {
        int iHashCode = Arrays.hashCode(this.mContent) * 31;
        long j = this.mStart;
        int i2 = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j3 = this.mEnd;
        int i8 = (i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        CLContainer cLContainer = this.mContainer;
        return ((i8 + (cLContainer != null ? cLContainer.hashCode() : 0)) * 31) + this.mLine;
    }

    public boolean isDone() {
        return this.mEnd != LocationRequestCompat.PASSIVE_INTERVAL;
    }

    public boolean isStarted() {
        return this.mStart > -1;
    }

    public boolean notStarted() {
        return this.mStart == -1;
    }

    public void setContainer(CLContainer cLContainer) {
        this.mContainer = cLContainer;
    }

    public void setEnd(long j) {
        if (this.mEnd != LocationRequestCompat.PASSIVE_INTERVAL) {
            return;
        }
        this.mEnd = j;
        if (CLParser.sDebug) {
            System.out.println("closing " + hashCode() + " -> " + this);
        }
        CLContainer cLContainer = this.mContainer;
        if (cLContainer != null) {
            cLContainer.add(this);
        }
    }

    public void setLine(int i2) {
        this.mLine = i2;
    }

    public void setStart(long j) {
        this.mStart = j;
    }

    public String toFormattedJSON(int i2, int i8) {
        return "";
    }

    public String toJSON() {
        return "";
    }

    public String toString() {
        long j = this.mStart;
        long j3 = this.mEnd;
        if (j > j3 || j3 == LocationRequestCompat.PASSIVE_INTERVAL) {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass());
            sb.append(" (INVALID, ");
            sb.append(this.mStart);
            sb.append("-");
            return a.p(sb, this.mEnd, ")");
        }
        return getStrClass() + " (" + this.mStart + " : " + this.mEnd + ") <<" + new String(this.mContent).substring((int) this.mStart, ((int) this.mEnd) + 1) + ">>";
    }

    @Override // 
    @NonNull
    /* JADX INFO: renamed from: clone */
    public CLElement mo34clone() {
        try {
            return (CLElement) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }
}
