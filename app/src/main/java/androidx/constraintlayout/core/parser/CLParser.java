package androidx.constraintlayout.core.parser;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class CLParser {
    static boolean sDebug = false;
    private String mContent;
    private boolean mHasComment = false;
    private int mLineNumber;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum TYPE {
        UNKNOWN,
        OBJECT,
        ARRAY,
        NUMBER,
        STRING,
        KEY,
        TOKEN
    }

    public CLParser(String str) {
        this.mContent = str;
    }

    private CLElement createElement(CLElement cLElement, int i2, TYPE type, boolean z2, char[] cArr) {
        CLElement cLElementAllocate;
        if (sDebug) {
            System.out.println("CREATE " + type + " at " + cArr[i2]);
        }
        switch (type.ordinal()) {
            case 1:
                cLElementAllocate = CLObject.allocate(cArr);
                i2++;
                break;
            case 2:
                cLElementAllocate = CLArray.allocate(cArr);
                i2++;
                break;
            case 3:
                cLElementAllocate = CLNumber.allocate(cArr);
                break;
            case 4:
                cLElementAllocate = CLString.allocate(cArr);
                break;
            case 5:
                cLElementAllocate = CLKey.allocate(cArr);
                break;
            case 6:
                cLElementAllocate = CLToken.allocate(cArr);
                break;
            default:
                cLElementAllocate = null;
                break;
        }
        if (cLElementAllocate == null) {
            return null;
        }
        cLElementAllocate.setLine(this.mLineNumber);
        if (z2) {
            cLElementAllocate.setStart(i2);
        }
        if (cLElement instanceof CLContainer) {
            cLElementAllocate.setContainer((CLContainer) cLElement);
        }
        return cLElementAllocate;
    }

    private CLElement getNextJsonElement(int i2, char c7, CLElement cLElement, char[] cArr) throws CLParsingException {
        if (c7 != '\t' && c7 != '\n' && c7 != '\r' && c7 != ' ') {
            if (c7 == '\"' || c7 == '\'') {
                return cLElement instanceof CLObject ? createElement(cLElement, i2, TYPE.KEY, true, cArr) : createElement(cLElement, i2, TYPE.STRING, true, cArr);
            }
            if (c7 == '[') {
                return createElement(cLElement, i2, TYPE.ARRAY, true, cArr);
            }
            if (c7 != ']') {
                if (c7 == '{') {
                    return createElement(cLElement, i2, TYPE.OBJECT, true, cArr);
                }
                if (c7 != '}') {
                    switch (c7) {
                        case '+':
                        case '-':
                        case '.':
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case AD_VISIBILITY_VALUE:
                        case INIT_TO_SUCCESS_CALLBACK_DURATION_MS_VALUE:
                            return createElement(cLElement, i2, TYPE.NUMBER, true, cArr);
                        case ',':
                        case INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
                            break;
                        case '/':
                            int i8 = i2 + 1;
                            if (i8 >= cArr.length || cArr[i8] != '/') {
                                return cLElement;
                            }
                            this.mHasComment = true;
                            return cLElement;
                        default:
                            if (!(cLElement instanceof CLContainer) || (cLElement instanceof CLObject)) {
                                return createElement(cLElement, i2, TYPE.KEY, true, cArr);
                            }
                            CLElement cLElementCreateElement = createElement(cLElement, i2, TYPE.TOKEN, true, cArr);
                            CLToken cLToken = (CLToken) cLElementCreateElement;
                            if (cLToken.validate(c7, i2)) {
                                return cLElementCreateElement;
                            }
                            throw new CLParsingException("incorrect token <" + c7 + "> at line " + this.mLineNumber, cLToken);
                    }
                }
            }
            cLElement.setEnd(i2 - 1);
            CLElement container = cLElement.getContainer();
            container.setEnd(i2);
            return container;
        }
        return cLElement;
    }

    public static CLObject parse(String str) throws CLParsingException {
        return new CLParser(str).parse();
    }

    public CLObject parse() throws CLParsingException {
        int i2;
        char[] charArray = this.mContent.toCharArray();
        int length = charArray.length;
        int i8 = 1;
        this.mLineNumber = 1;
        boolean z2 = false;
        int i9 = 0;
        while (true) {
            if (i9 >= length) {
                i9 = -1;
                break;
            }
            char c7 = charArray[i9];
            if (c7 == '{') {
                break;
            }
            if (c7 == '\n') {
                this.mLineNumber++;
            }
            i9++;
        }
        if (i9 == -1) {
            throw new CLParsingException("invalid json content", null);
        }
        CLObject cLObjectAllocate = CLObject.allocate(charArray);
        cLObjectAllocate.setLine(this.mLineNumber);
        cLObjectAllocate.setStart(i9);
        int i10 = i9 + 1;
        CLElement container = cLObjectAllocate;
        while (i10 < length) {
            char c8 = charArray[i10];
            if (c8 == '\n') {
                this.mLineNumber += i8;
            }
            if (this.mHasComment) {
                if (c8 == '\n') {
                    this.mHasComment = z2;
                } else {
                    i2 = i8;
                    i10++;
                    i8 = i2;
                    z2 = false;
                }
            }
            if (container == null) {
                break;
            }
            if (container.isDone()) {
                container = getNextJsonElement(i10, c8, container, charArray);
            } else if (container instanceof CLObject) {
                if (c8 == '}') {
                    container.setEnd(i10 - 1);
                } else {
                    container = getNextJsonElement(i10, c8, container, charArray);
                }
            } else if (!(container instanceof CLArray)) {
                boolean z7 = container instanceof CLString;
                if (z7) {
                    long j = container.mStart;
                    if (charArray[(int) j] == c8) {
                        container.setStart(j + 1);
                        container.setEnd(i10 - 1);
                    }
                } else {
                    if (container instanceof CLToken) {
                        CLToken cLToken = (CLToken) container;
                        i2 = i8;
                        if (!cLToken.validate(c8, i10)) {
                            throw new CLParsingException("parsing incorrect token " + cLToken.content() + " at line " + this.mLineNumber, cLToken);
                        }
                    } else {
                        i2 = i8;
                    }
                    if ((container instanceof CLKey) || z7) {
                        long j3 = container.mStart;
                        char c9 = charArray[(int) j3];
                        if ((c9 == '\'' || c9 == '\"') && c9 == c8) {
                            container.setStart(j3 + 1);
                            container.setEnd(i10 - 1);
                        }
                    }
                    if (!container.isDone() && (c8 == '}' || c8 == ']' || c8 == ',' || c8 == ' ' || c8 == '\t' || c8 == '\r' || c8 == '\n' || c8 == ':')) {
                        long j8 = i10 - 1;
                        container.setEnd(j8);
                        if (c8 == '}' || c8 == ']') {
                            container = container.getContainer();
                            container.setEnd(j8);
                            if (container instanceof CLKey) {
                                container = container.getContainer();
                                container.setEnd(j8);
                            }
                        }
                    }
                    if (!container.isDone() && (!(container instanceof CLKey) || ((CLKey) container).mElements.size() > 0)) {
                        container = container.getContainer();
                    }
                    i10++;
                    i8 = i2;
                    z2 = false;
                }
            } else if (c8 == ']') {
                container.setEnd(i10 - 1);
            } else {
                container = getNextJsonElement(i10, c8, container, charArray);
            }
            i2 = i8;
            if (!container.isDone()) {
            }
            i10++;
            i8 = i2;
            z2 = false;
        }
        while (container != null && !container.isDone()) {
            if (container instanceof CLString) {
                container.setStart(((int) container.mStart) + 1);
            }
            container.setEnd(length - 1);
            container = container.getContainer();
        }
        if (sDebug) {
            System.out.println("Root: " + cLObjectAllocate.toJSON());
        }
        return cLObjectAllocate;
    }
}
