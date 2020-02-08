public class Printer {

    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        this.tonerLevel = tonerLevel >= 0 && tonerLevel <= 100 ? tonerLevel : -1;
        this.pagesPrinted = 0;
        this.duplex = duplex;
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }

    public boolean isDuplex() {
        return duplex;
    }

    public int addToner(int tonerLevel) {
        if (!(tonerLevel > 0 && tonerLevel<= 100)) {
            return -1;
        }

        if ((this.tonerLevel + tonerLevel) > 100) {
            return -1;
        }

        this.tonerLevel += tonerLevel;
        return this.tonerLevel;
    }

    public int printPages(int pages) {
        int pagesToPrint = pages;
        if (duplex) {
            pagesToPrint = (pages / 2) + (pages % 2);
            System.out.println("Printing in duplex mode.");
        }
        increasePrintedPages(pagesToPrint);
        return pagesToPrint;
    }

    private void increasePrintedPages(int n) {
        pagesPrinted += n;
    }
}
