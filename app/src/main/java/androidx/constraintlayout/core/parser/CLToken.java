package androidx.constraintlayout.core.parser;

import com.ironsource.mediationsdk.metadata.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class CLToken extends CLElement {
    int mIndex;
    char[] mTokenFalse;
    char[] mTokenNull;
    char[] mTokenTrue;
    Type mType;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum Type {
        UNKNOWN,
        TRUE,
        FALSE,
        NULL
    }

    public CLToken(char[] cArr) {
        super(cArr);
        this.mIndex = 0;
        this.mType = Type.UNKNOWN;
        this.mTokenTrue = a.g.toCharArray();
        this.mTokenFalse = "false".toCharArray();
        this.mTokenNull = "null".toCharArray();
    }

    public static CLElement allocate(char[] cArr) {
        return new CLToken(cArr);
    }

    public boolean getBoolean() throws CLParsingException {
        Type type = this.mType;
        if (type == Type.TRUE) {
            return true;
        }
        if (type == Type.FALSE) {
            return false;
        }
        throw new CLParsingException("this token is not a boolean: <" + content() + ">", this);
    }

    public Type getType() {
        return this.mType;
    }

    public boolean isNull() throws CLParsingException {
        if (this.mType == Type.NULL) {
            return true;
        }
        throw new CLParsingException("this token is not a null: <" + content() + ">", this);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i2, int i8) {
        StringBuilder sb = new StringBuilder();
        addIndent(sb, i2);
        sb.append(content());
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        if (!CLParser.sDebug) {
            return content();
        }
        return "<" + content() + ">";
    }

    public boolean validate(char c7, long j) {
        int iOrdinal = this.mType.ordinal();
        if (iOrdinal == 0) {
            char[] cArr = this.mTokenTrue;
            int i2 = this.mIndex;
            if (cArr[i2] == c7) {
                this.mType = Type.TRUE;
            } else if (this.mTokenFalse[i2] == c7) {
                this.mType = Type.FALSE;
            } else if (this.mTokenNull[i2] == c7) {
                this.mType = Type.NULL;
            }
            z = true;
        } else if (iOrdinal == 1) {
            char[] cArr2 = this.mTokenTrue;
            int i8 = this.mIndex;
            z = cArr2[i8] == c7;
            if (z && i8 + 1 == cArr2.length) {
                setEnd(j);
            }
        } else if (iOrdinal == 2) {
            char[] cArr3 = this.mTokenFalse;
            int i9 = this.mIndex;
            z = cArr3[i9] == c7;
            if (z && i9 + 1 == cArr3.length) {
                setEnd(j);
            }
        } else if (iOrdinal == 3) {
            char[] cArr4 = this.mTokenNull;
            int i10 = this.mIndex;
            z = cArr4[i10] == c7;
            if (z && i10 + 1 == cArr4.length) {
                setEnd(j);
            }
        }
        this.mIndex++;
        return z;
    }
}
